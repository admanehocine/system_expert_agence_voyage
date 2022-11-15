package partie2;

import java.io.Serializable;

public class Formulaire implements Serializable {
          private boolean valide;
	private String Depart,Distination,DateDepart,DateRetour;
	private int nbrPassageTotal;
	private int nbrAdultes,nbrEnfants,nbrBebes,nbrSenieurs;
	
	public Formulaire() {
		valide = false;
		Depart = "";
		Distination = "";
		DateDepart = "";
		DateRetour = "";
		nbrPassageTotal = 0;
		nbrAdultes = 0;
		nbrEnfants = 0;
		nbrBebes = 0;
		nbrSenieurs = 0;
		
	}
	
	@Override
	public String toString() {
		return "Formulaire [valide=" + valide + ", Depart=" + Depart + ", Distination=" + Distination + ", DateDepart="
				+ DateDepart + ", DateRetour=" + DateRetour + ", nbrPassageTotal=" + nbrPassageTotal + ", nbrAdultes="
				+ nbrAdultes + ", nbrEnfants=" + nbrEnfants + ", nbrBebes=" + nbrBebes + ", nbrSenieurs=" + nbrSenieurs
				+ "]";
	}

	public Formulaire(Formulaire f) {
		this.valide = f.valide;
		this.Depart = f.Depart;
		this.Distination = f.Distination;
		this.DateDepart = f.DateDepart;
		this.DateRetour = f.DateRetour;
		this.nbrAdultes =f.nbrAdultes;
		this.nbrEnfants = f.nbrEnfants;
		this.nbrBebes = f.nbrBebes;
		this.nbrSenieurs = f.nbrSenieurs;
		this.nbrPassageTotal = f.nbrAdultes+f.nbrEnfants+f.nbrBebes+f.nbrSenieurs;
	}

//	@Override
	public String afficherFormulaire(){
		return 	"\n-[Fichier Formulaire]-----------------------------------------------------------"+
				"\nDepart : "+this.Depart +
				"\nDistination : "+this.Distination +
				"\nDate de Depart : "+this.DateDepart +
				"\nDate de Retour : "+this.DateRetour +
				"\nNombre de passager total : "+ this.nbrPassageTotal+
					"\n\t--> Nombre des Adultes : " + this.nbrAdultes +
					"\n\t--> Nombre des Enfants (>7 et <11) : " + this.nbrEnfants + 
					"\n\t--> Nombre des Bebes (<6) : " +this.nbrBebes +
					"\n\t--> Nombre des Senieurs(>75) : " + this.nbrSenieurs+
				"\n-----------------------------------------------------------------------------------\n\n"
				;
	}

	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	public String getDepart() {
		return Depart;
	}

	public void setDepart(String depart) {
		Depart = depart;
	}

	public String getDistination() {
		return Distination;
	}

	public void setDistination(String distination) {
		Distination = distination;
	}

	public String getDateDepart() {
		return DateDepart;
	}

	public void setDateDepart(String dateDepart) {
		DateDepart = dateDepart;
	}

	public String getDateRetour() {
		return DateRetour;
	}

	public void setDateRetour(String dateRetour) {
		DateRetour = dateRetour;
	}

	public int getNbrPassageTotal() {
		return nbrPassageTotal;
	}

	public void setNbrPassageTotal(int nbrPassageTotal) {
		this.nbrPassageTotal = nbrPassageTotal;
	}

	public int getNbrAdultes() {
		return nbrAdultes;
	}

	public void setNbrAdultes(int nbrAdultes) {
		this.nbrAdultes = nbrAdultes;
	}

	public int getNbrEnfants() {
		return nbrEnfants;
	}

	public void setNbrEnfants(int nbrEnfants) {
		this.nbrEnfants = nbrEnfants;
	}

	public int getNbrBebes() {
		return nbrBebes;
	}

	public void setNbrBebes(int nbrBebes) {
		this.nbrBebes = nbrBebes;
	}

	public int getNbrSenieurs() {
		return nbrSenieurs;
	}

	public void setNbrSenieurs(int nbrSenieurs) {
		this.nbrSenieurs = nbrSenieurs;
	}
	
	
}
