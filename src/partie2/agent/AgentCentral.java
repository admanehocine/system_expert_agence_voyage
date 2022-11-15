package partie2.agent;
/*
import java.io.IOException;

import jade.core.*;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.util.leap.Serializable;
import partie2.Formulaire;
import partie2.Reservation;




public class AgentCentral extends Agent {
	
	@Override
	public void setup() {
		//addBehaviour(new AgentCentral_B1());
		//Object[] o = this.getArguments();
		//Formulaire f = (Formulaire)o[0];
		
		Formulaire a = Reservation.form;
		this.addBehaviour(new OneShotBehaviour() {
			@Override
			public void action() {
				System.out.println("Central_b1 est lancé");
				ACLMessage m = new ACLMessage(ACLMessage.INFORM);
				m.addReceiver(new AID("Agent_AlgerieAirlines",AID.ISLOCALNAME));
				try {
					m.setContentObject("HELLLLLLLLLLO");

					myAgent.send(m);
					done();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		System.out.println("Agent " + getLocalName() + " est lancé ");
	}
}*/



import javax.swing.JOptionPane;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class AgentCentral extends Agent {
	private boolean flag=true;
	
	protected  void setup() { 
	 addBehaviour(new CyclicBehaviour() {
		
		@Override
		public void action() {
			// TODO Auto-generated method stub
			ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
			
			if(flag) {
				msg.setContent("Ping");
				msg.addReceiver(new AID("a2",AID.ISLOCALNAME));
				send(msg);
				flag=false;
			}
			
			String sentMsg = JOptionPane.showInputDialog("Message sent:\nAny question you want to ask?");
			msg.setContent(sentMsg);
			send(msg);
			
		    	ACLMessage receiveMsg = receive();
            		if (receiveMsg!=null) {
                		System.out.println( " - " + myAgent.getLocalName() + " <- " + receiveMsg.getContent() );
            		}
			
			block();
		}
	});
   }
}

