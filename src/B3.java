import jade.core.*;
import jade.lang.acl.*;
import jade.core.behaviours.*;
public class B3 extends Behaviour{
ACLMessage m1 =null;
public void action() {
m1=myAgent.blockingReceive();
if(m1!=null){
System.out.println("Je suis A3");
}
ACLMessage m = new ACLMessage(ACLMessage.INFORM);
m.addReceiver(new AID("A1",AID.ISLOCALNAME));
String r = null;
int [] T = new int [10];
try {T =(int[]) m1.getContentObject();}
catch (UnreadableException e) {e.printStackTrace();}
int S = 0;
for (int i=0;i<T.length;i++){
if(T[i] % 2 != 0)
{S = S + T[i];}
}
r="Somme des Nombres impaires : "+S;
m.setContent(r);
myAgent.send(m);
}
public boolean done() {return (m1!=null);}
}