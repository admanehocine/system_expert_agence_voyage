import os

WriteOnly = 'w'
ReadOnly = 'r'
ReadAndWrite ='rw'

def makeInference(base, formula):
    file = open(base, ReadOnly)
    # Récupérer le contenu du fichier dans une liste 
    lines = file.readlines()
    file.close()
    cnf_list = list()
    i = 0
    # Enlever les saut de ligne et les lignes vides
    while i < len(lines) and lines[i] != '\n':
        cnf_list.append(lines[i].strip())
        i+=1
    # Transformer chaque ligne en liste
    for i, line in enumerate(cnf_list):
        cnf_list[i] = line.split(' ')
        # Ajouter des sauts de ligne à la fin
        cnf_list[i].append('\n')
    # Enlever les cases vides
    for i, line in enumerate(cnf_list):
        cnf_list[i] = list(filter(None, line))          
    # Ajouter la négation de la formule dans la base
    temp = formula.strip().split(' ')
    for i, lit in enumerate(temp):
        temp[i] = str((-1)*int((lit)))
    cnf_list.append(temp)
    # Mettre à jours le nombre de clauses
    (cnf_list[0])[3] = str(int((cnf_list[0])[3]) + 1)
    # Créer un fichier nouveau fichier pour le test
    temp = open('temp.cnf', WriteOnly)
    for i, line in enumerate(cnf_list):
        temp.write(' '.join(line))
    temp.close()    
    # Lancer le solveur SAT
    os.system('ubcsat -alg saps -i temp.cnf -solve > result.txt')
    # Ouvrir le fichier qui contient le résultat
    result = open('result.txt', ReadOnly)
    lines = result.readlines()
    # Vérifier si le solveur a trouvé une solution
    if '# Solution found for -target 0\n' in lines:
        return True
    else: 
        return False
                       
file_name = input('Entrer le nom de la base(Sans extension) : ')
formule = input('Entrer la formule à inférer(Sans 0 à la fin) ou bien 0 pour signaler la fin : ')
while(formule != str(0)):
    formule += ' 0'

    if makeInference('{}.cnf'.format(file_name), formule) == True:
        print('\n(Solution trouvé) BC n\'infère pas Phi')
    else:
        print('\n(Contradiction) BC infère Phi')
    file_name = 'temp'    
    formule = input('Entrer la formule à inférer(Sans 0 à la fin) : ')    
