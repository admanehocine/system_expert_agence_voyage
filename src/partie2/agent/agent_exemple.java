package partie2.agent;

import jade.core.Agent;
import jade.lang.acl.ACLMessage;

public class agent_exemple extends Agent{
	
	@Override
	protected void setup() {
		System.out.println("hello i am the first agent");
		ACLMessage msg= new ACLMessage(ACLMessage.INFORM);
		//msg.addReceiver(new AID("AgentCentral",ID.));
	}
	

}
