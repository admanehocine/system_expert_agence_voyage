
import java.io.IOException;
import jade.core.*;
import jade.lang.acl.*;
import jade.core.behaviours.*;
public class B1 extends Behaviour{
ACLMessage m1 =null;
public void action() {
int [] T = new int [10];
T[0]=1; T[1]=2; T[2]=3; T[3]=4;
T[4]=5;
T[5]=6; T[6]=7; T[7]=8; T[8]=9;
T[9]=10;
ACLMessage m = new ACLMessage(ACLMessage.INFORM);
m.addReceiver(new AID("A2",AID.ISLOCALNAME));
m.addReceiver(new AID("A3",AID.ISLOCALNAME));
try {m.setContentObject(T);}
catch (IOException e) {e.printStackTrace();}
myAgent.send(m);
for(int i=0;i<2;i++){
m1=myAgent.blockingReceive();
if(m1!=null){System.out.println("Je suis A1 : " +
m1.getContent());}
}
}
public boolean done() {return (m1!=null);}
}