package partie2;

import java.io.IOException;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.gui.GuiAgent;
import jade.gui.GuiEvent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import jade.util.leap.ArrayList;
import jade.wrapper.ControllerException;

public class TurkishAirlines extends Agent{
	static Connection cnx=null;
	 static ResultSet rst=null;
	 static java.sql.PreparedStatement pr=null;
	 static Statement pr1=null;
	int fk;
	   static LinkedList<Vols> vol=new LinkedList(); 
	   static BaseDeRegle BR=new BaseDeRegle();
	   AgentCentral kilo;
	 //  static Object[] mat=new Object[vol.size()];

	   public void update(int fb,String g) {
			
				String requete="UPDATE vols  SET   Nbplace=Nbplace-'"+fb+"' where idVols ='"+g+"'";
					
			
					try {
						pr=cnx.prepareStatement(requete);
						pr.executeUpdate();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				
	   }
	   
	   public static void select() {//as 'numero rapport'   as 'numero chef service ' , ouvrier_id as'numero reparateur' 
		
	String d="TurkishAirlines";
		String sql=" SELECT idVols,nbplace,Depart,Destination"
				+ ",Aeroport,Organisation,Jour,Heure,Dure ,JourRetour,HeureRetour,prix FROM vols WHERE Organisation='"+d+"'";
		try {
			cnx=(Connection) connexion.connecter();
			java.sql.Statement st = cnx.createStatement();
			
			 rst = st.executeQuery(sql);
		    //rst.last();
		    int nb=rst.getRow();
		    //if(nb==1 )
		   // System.out.println("$$$$$"+nb);
		   while(rst.next())
		    vol.add(new Vols(rst.getInt(1),rst.getInt(2),rst.getString(3),rst.getString(4)
		    		,rst.getString(5),rst.getString(6),
		    		rst.getString(7),rst.getString(8),rst.getString(9)
		    		,rst.getString(10),rst.getString(11),rst.getDouble(12)));
		    
		   
		   
		   for(int i=0;i<vol.size();i++) {
		    	System.out.println("\n*******i*****"+vol.get(i).toString());		    }
				} catch (SQLException e) {
			
					}
	}
	
	public void affiche() {
		//Log.txtrEe.append("\nje suis "+this.getAID().getLocalName()+"\nj'ai envoyé un message l'agent Agent central");
		
	}
	@Override
	protected void setup()
	{    
		//gui=(Reservation) getArguments()[0];
		
		//gui.setAgentG(this);
	System.out.println("Initialisation de l'agent"+this.getAID().getName());
 

  
	
	
	addBehaviour(new CyclicBehaviour(){
		
	  	
		@Override
       public void action() {
			
		
		ACLMessage message=receive();
				if(message!=null) {
					if(kilo.m==2) {
						    System.out.println("\nreception d un message:"+((String)message.getContent()));
						    ACLMessage reply = message.createReply();
					        reply.setPerformative(ACLMessage.INFORM);
					        update(fk,(String)message.getContent());
					        reply.setContent("id vol bien recu");	
				            myAgent.send(reply);
					}else {
			try {
				System.out.println("\nreception d un message:"+((Formulaire)message.getContentObject()));
					
			} catch (UnreadableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
           select(); 
			ACLMessage reply = message.createReply();
		        reply.setPerformative(ACLMessage.INFORM);
		        
		    	//System.out.println("11111*****$$$");
		        try {	//System.out.println("*****$$$1111");
					LinkedList<Vols> vol2=new LinkedList();
					fk=((Formulaire)message.getContentObject()).getNbrPassageTotal();
					//System.out.println("le forumalire est :"+fk.toString());
				    //(Formulaire)message.getContentObject();
					vol2=BR.RegleDecision((Formulaire)message.getContentObject(), vol);
		        	reply.setContentObject(vol2);
					 for(int i=0;i<vol2.size();i++) {
					    	System.out.println("print de puis agent turkish\n"+vol2.get(i).toString());}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnreadableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	//System.out.println("****111*$$$");
		        myAgent.send(reply);

			
			}
					}else block();
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

	

	
		
	

}
