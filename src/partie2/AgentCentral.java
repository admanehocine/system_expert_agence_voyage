package partie2;


import java.io.IOException;
import java.util.LinkedList;

import javax.swing.table.DefaultTableModel;

import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.gui.*;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import jade.util.leap.ArrayList;
import jade.wrapper.ControllerException;
public class AgentCentral extends GuiAgent{
  private Reservation gui;
  //private ChoixVols chv;
  //private TurkishAirlines gui2;
  private Formulaire formule;
  static int   m=0;
  public void converterVersTable(LinkedList <Vols> list,Formulaire f) {
	 
	      DefaultTableModel model = (DefaultTableModel) gui.chv.table.getModel();
	      //LinkedList <Vols> list = L;
	      Object rowData[] = new Object[11];
	      for(int i = 0; i < list.size(); i++)
	      {   rowData[0] = list.get(i).getAeroport();
	          rowData[1] = list.get(i).getIdVols();
	          rowData[2] = list.get(i).getOrganisation();
	          rowData[3] = list.get(i).getDepart();
	          rowData[4] = list.get(i).getDestination();
	          rowData[5] = f.getDateDepart();
	          rowData[6] = list.get(i).getHeure();
	          rowData[7] = f.getDateRetour();
	          rowData[8] = list.get(i).getHeurRetour();
	          rowData[9] = list.get(i).getDure();
	          rowData[10] = list.get(i).getPrix();
	          model.addRow(rowData);
	      	
			gui.chv.setVisible(true);
	  }
  }
  
@Override
	protected void setup()
	{    
		gui=(Reservation) getArguments()[0];
		
		gui.setAgentG(this);
	System.out.println("Initialisation de l'agent"+this.getAID().getName());

	gui.chv=(ChoixVols) getArguments()[1];
	gui.chv.setAgentG(this); 


//  gui2=(TurkishAirlines) getArguments()[1];
	
	//gui2.set
	addBehaviour(new CyclicBehaviour(){
		
	  	
		@Override
       public void action() {
			
			//  afficher(k);	
			//afficher(this.myAgent.getAID().getName());
		ACLMessage message=receive();
		
		if(message!=null) {
			
			if(m==2) {
				 System.out.println("\nreception d un message:"+((String)message.getContent()));
			
					
					
				
			}else {
		       try {
				//ArrayList p=new ArrayList();
				//p.clone((Object[])message.getContentObject());
				

		    	   //System.out.println("======>"+message.getAllReceiver().toString());
				//System.out.println("reception d un message==>"+message.getContentObject().toString());
				LinkedList <Vols> p=new LinkedList();
				p=(LinkedList) message.getContentObject();
				System.out.println("reception d un message de l'agent annexe turkish==>\n");

				for(int i=0;i<p.size();i++) {
				    	System.out.println("\n"+p.get(i).toString());}
				converterVersTable(p,formule);//liste vers jtable
		       } catch (UnreadableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				
				//System.out.println("reception d un message"+message.getContent());
		}}else block();
		}
		
		
	});
	
	}
	
	@Override
	protected void takeDown()
	{
		
	try {
		System.out.println("destruction de l'agent"+this.getContainerController().getContainerName());
	} catch (ControllerException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	@Override
	protected void beforeMove()
	{
		try {
			System.out.println("avant migration du container"+this.getContainerController().getContainerName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void afterMove()
	{
		try {
			System.out.println(" migration du container"+this.getContainerController().getContainerName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void onGuiEvent(GuiEvent guiEvent) {
		// TODO Auto-generated method stub*
		Log frame = new Log();
		frame.setVisible(true);
		if(guiEvent.getType()==1) {
			ACLMessage aclMessage=new ACLMessage(ACLMessage.REQUEST);
			 formule=(Formulaire)guiEvent.getParameter(0);
			//LinkedList <Vols> b=new LinkedList();
			
			//b.add(new Vols(1,1,"e","d","d","d","d","&"));
			
			//System.out.println("$$$$$$$$$$$$$$$$$$"+formule.);
			try {
				aclMessage.setContentObject(formule);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// setContent(livre);
			aclMessage.addReceiver(new  AID("TurkishAirlines",AID.ISLOCALNAME));
			  Log.txtrEe.append("\nje suis "+this.getAID().getLocalName()+"j'ai envoyé le formulaire a l'agent turkish Airlines");
			  Log.txtrEe.append("\nvoici le formulaire que j'ai envoyé:\n"+formule.afficherFormulaire());
			send(aclMessage);
		}
		if(guiEvent.getType()==2) {
			
			ACLMessage aclMessage=new ACLMessage(ACLMessage.REQUEST);
			 String d=(String)guiEvent.getParameter(0);
			 String b=(String)guiEvent.getParameter(1);
			 m=2;
			//LinkedList <Vols> b=new LinkedList();
			
			//b.add(new Vols(1,1,"e","d","d","d","d","&"));
			
			//System.out.println("$$$$$$$$$$$$$$$$$$"+formule.);
				aclMessage.setContent(d);
			aclMessage.addReceiver(new  AID(b,AID.ISLOCALNAME));
			  Log.txtrEe.append("\nje suis "+this.getAID().getLocalName()+"j'ai envoyé le id vols a l'agent "+ b);
			  Log.txtrEe.append("\nvoici le id vols que j'ai envoyé:\n"+d);
			send(aclMessage);
		}
			
	}

}

