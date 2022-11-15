package partie2.agent;


import java.io.IOException;

import partie2.Formulaire;
import partie2.Reservation;
import jade.lang.acl.*;

import jade.core.*;
import jade.lang.acl.*;
import jade.core.behaviours.*;

public class AgentCentral_B1 extends Behaviour{
	boolean actionFaite = false;
	Formulaire a = Reservation.form;
	@Override
	public void action() {
		
		if(!actionFaite) {	
			if (a!=null && a.valide == true) {
				System.out.println("Central_b1 est lancé");
				//ACLMessage m = new ACLMessage(a);
				//m.addReceiver(new AID("Agent_AlgerieAirlines",AID.ISLOCALNAME));
				//myAgent.send(m);
				done();
			}
				
		} else {
			this.block();
		}
			
	}
	
	@Override
	public boolean done() {
		
		return false;
	}

}
