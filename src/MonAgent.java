import jade.core.*;
public class MonAgent extends Agent{
public static void main(String[] args) {
String [] jadeArg = new String [2];
StringBuffer SbAgent = new StringBuffer();
SbAgent.append("A1: MonAgent;");
SbAgent.append("A2: MonAgent;");
SbAgent.append("A3: MonAgent;");
jadeArg[0]="-gui";
jadeArg[1]=SbAgent.toString();
jade.Boot.main(jadeArg);}
public void setup (){
if (this.getLocalName().equals("A1")){
addBehaviour(new B1());
}
if (this.getLocalName().equals("A2")){
addBehaviour(new B2());
}
if (this.getLocalName().equals("A3")){
addBehaviour(new B3());
}
}
}