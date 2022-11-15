package partie2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.awt.Color;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JYearChooser;

import exemple_agent.Agentguide;
import jade.core.Agent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.gui.GuiEvent;
import jade.util.ExtendedProperties;
import jade.util.leap.Properties;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;

public class Reservation extends JFrame {
     private   AgentCentral AgentG;
     private Log text;
     public ChoixVols chv;
     //private ChoixVols chv;
    
	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t6;
	private JTextField t5;
	private JTextField t7;
	private JTextField t8;
	private static	Formulaire temp = null;
	public static Formulaire form = null;
	private static Connection cnx=null;//pour la connexion de la bdd
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	
	
	
	public static void main(String[] args) {
		//TurkishAirlines T = null;
		//T.select();
	
		
		System.out.println("");
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					mainContainer();
					Reservation frame = new Reservation();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
					//cnx=connexion.connecter();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			
		});
	}
	public Log getText() {
		return text;
	}
    
	public void setText(Log text) {
		this.text = text;
	}

	public AgentCentral getAgentG() {
		return AgentG;
	}

	public void setAgentG(AgentCentral agentG) {
		this.AgentG = agentG;
	}

	
	public void startContainer() {
		try {
			Runtime runtime=Runtime.instance();
			Profile profile=new ProfileImpl(false);
			profile.setParameter(Profile.MAIN_HOST, "localhost");
			chv=new ChoixVols();
			AgentContainer agentContainer=runtime.createAgentContainer(profile);
			AgentController agentController=
					agentContainer.createNewAgent("Agent Central", "partie2.AgentCentral", new Object[] {this,chv});
				agentController.start();
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void startContainer2() {
		try {
			Runtime runtime=Runtime.instance();
			Profile profile=new ProfileImpl(false);
			profile.setParameter(Profile.MAIN_HOST, "localhost");
			AgentContainer agentContainer=runtime.createAgentContainer(profile);
			AgentController agentController=
					agentContainer.createNewAgent("TurkishAirlines", "partie2.TurkishAirlines", new Object[] {});
				agentController.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void mainContainer() {
		try {	Runtime runtime=Runtime.instance();
		Properties properties=new ExtendedProperties();
		properties.setProperty(Profile.GUI, "true");
		ProfileImpl profile=new ProfileImpl(properties);
		AgentContainer mainContainer=runtime.createMainContainer(profile);
			mainContainer.start();
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Reservation() {
		
		startContainer();
		startContainer2();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 849, 426);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 25, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVeuillerRemplireCe = new JLabel("veuillez remplir le formulaire suivant\r\n");
		lblVeuillerRemplireCe.setForeground(new Color(64, 224, 208));
		lblVeuillerRemplireCe.setBackground(new Color(220, 20, 60));
		lblVeuillerRemplireCe.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		lblVeuillerRemplireCe.setBounds(257, 11, 354, 23);
		contentPane.add(lblVeuillerRemplireCe);
		
		JLabel lblNewLabel = new JLabel("Date de d\u00E9part");
		lblNewLabel.setFont(new Font("Yu Gothic Light", Font.BOLD, 12));
		lblNewLabel.setForeground(new Color(192, 192, 192));
		lblNewLabel.setBounds(49, 169, 118, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblDateDeRetour = new JLabel("Date de retour\r\n");
		lblDateDeRetour.setFont(new Font("Yu Gothic Light", Font.BOLD, 12));
		lblDateDeRetour.setForeground(new Color(192, 192, 192));
		lblDateDeRetour.setBounds(49, 229, 118, 31);
		contentPane.add(lblDateDeRetour);
		
		t1 = new JTextField();
		t1.setText("Alger");
		t1.setFont(new Font("Tahoma", Font.BOLD, 15));
		t1.setForeground(new Color(0, 0, 0));
		t1.setColumns(10);
		t1.setBounds(177, 64, 194, 31);
		contentPane.add(t1);
		
		JLabel lblDpartAPartir = new JLabel("D\u00E9part a partir\r\n");
		lblDpartAPartir.setFont(new Font("Yu Gothic Light", Font.BOLD, 12));
		lblDpartAPartir.setForeground(new Color(192, 192, 192));
		lblDpartAPartir.setBounds(49, 66, 118, 31);
		contentPane.add(lblDpartAPartir);
		
		JLabel lblDistination = new JLabel("Distination");
		lblDistination.setFont(new Font("Yu Gothic Light", Font.BOLD, 12));
		lblDistination.setForeground(new Color(192, 192, 192));
		lblDistination.setBounds(49, 116, 118, 31);
		contentPane.add(lblDistination);
		
		JDateChooser t4 = new JDateChooser();
		t4.setBounds(176, 229, 195, 31);
		contentPane.add(t4);
		
		JDateChooser t3 = new JDateChooser();
		t3.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		t3.setBounds(177, 169, 194, 31);
		contentPane.add(t3);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {
		     if(t1.getText().toString().length()==0 && 
				t2.getText().toString().length()==0 &&  
				t3.getDate() == null &&
				t4.getDate() == null &&
				
				t5.getText().toString().length() == 0 && 
				t6.getText().toString().length() == 0 && 
				t7.getText().toString().length() == 0 &&
				t8.getText().toString().length() == 0 ) {
		    	 JOptionPane.showMessageDialog
		    	 (contentPane , "Erreur ! au moins un champ ne peut pas etre vide !", "Erreur",JOptionPane.ERROR_MESSAGE);
		     }		
			 else {
				 
				 
				temp = new Formulaire();
				if (t3.getDate() != null)
				{SimpleDateFormat date =new SimpleDateFormat("yyyy/MM/dd");
					String k3=date.format(t3.getDate());
					temp.setDateDepart(k3);
				}if (t4.getDate() != null)
				{SimpleDateFormat date =new SimpleDateFormat("yyyy-MM-dd");
					String k4=date.format(t4.getDate());
					temp.setDateRetour(k4);
				}if(t1.getText().toString().length()!=0)
					temp.setDepart(t1.getText().toString());
				if(t2.getText().toString().length()!=0)
                temp.setDistination(t2.getText().toString());
				if(t5.getText().toString().length() != 0 )
					temp.setNbrAdultes(Integer.parseInt(t5.getText().toString()));
				if(t6.getText().toString().length() != 0 )
					temp.setNbrSenieurs(Integer.parseInt(t6.getText().toString()));
				if(t7.getText().toString().length() != 0 )
					temp.setNbrEnfants(Integer.parseInt(t7.getText().toString()));
				if(t8.getText().toString().length() != 0 )
					temp.setNbrBebes(Integer.parseInt(t8.getText().toString()));
			
                form = new Formulaire(temp);              
              System.out.print(form.toString());
        
             // String Livre=t1.getText();
				GuiEvent guiEvent=new GuiEvent(this,1);
				guiEvent.addParameter(form);
				
				AgentG.onGuiEvent(guiEvent);

                
			}}
		});
		btnValider.setBounds(383, 308, 108, 39);
		contentPane.add(btnValider);
		
		t2 = new JTextField();
		t2.setText("Alger");
		t2.setForeground(Color.BLACK);
		t2.setFont(new Font("Tahoma", Font.BOLD, 15));
		t2.setColumns(10);
		t2.setBounds(177, 114, 194, 31);
		contentPane.add(t2);
		
		t6 = new JTextField();
		t6.setText("1");
		t6.setForeground(Color.BLACK);
		t6.setFont(new Font("Tahoma", Font.BOLD, 15));
		t6.setColumns(10);
		t6.setBounds(673, 114, 58, 31);
		contentPane.add(t6);
		
		JLabel lblNombreDesSenieurs = new JLabel("Nombre des senieurs\r\n");
		lblNombreDesSenieurs.setForeground(Color.LIGHT_GRAY);
		lblNombreDesSenieurs.setFont(new Font("Yu Gothic Light", Font.BOLD, 12));
		lblNombreDesSenieurs.setBounds(524, 116, 133, 31);
		contentPane.add(lblNombreDesSenieurs);
		
		JLabel lblNombreDadultes = new JLabel("Nombre d'adultes");
		lblNombreDadultes.setForeground(Color.LIGHT_GRAY);
		lblNombreDadultes.setFont(new Font("Yu Gothic Light", Font.BOLD, 12));
		lblNombreDadultes.setBounds(539, 66, 118, 31);
		contentPane.add(lblNombreDadultes);
		
		t5 = new JTextField();
		t5.setText("1");
		t5.setForeground(Color.BLACK);
		t5.setFont(new Font("Tahoma", Font.BOLD, 15));
		t5.setColumns(10);
		t5.setBounds(673, 64, 58, 31);
		contentPane.add(t5);
		
		JLabel lblNombreDesBebes = new JLabel("Nombre des bebes");
		lblNombreDesBebes.setForeground(Color.LIGHT_GRAY);
		lblNombreDesBebes.setFont(new Font("Yu Gothic Light", Font.BOLD, 12));
		lblNombreDesBebes.setBounds(539, 229, 118, 31);
		contentPane.add(lblNombreDesBebes);
		
		JLabel lblNombreDenfants = new JLabel("Nombre d'enfants");
		lblNombreDenfants.setForeground(Color.LIGHT_GRAY);
		lblNombreDenfants.setFont(new Font("Yu Gothic Light", Font.BOLD, 12));
		lblNombreDenfants.setBounds(539, 169, 118, 31);
		contentPane.add(lblNombreDenfants);
		
		t7 = new JTextField();
		t7.setText("1");
		t7.setForeground(Color.BLACK);
		t7.setFont(new Font("Tahoma", Font.BOLD, 15));
		t7.setColumns(10);
		t7.setBounds(673, 169, 58, 31);
		contentPane.add(t7);
		
		t8 = new JTextField();
		t8.setText("1");
		t8.setForeground(Color.BLACK);
		t8.setFont(new Font("Tahoma", Font.BOLD, 15));
		t8.setColumns(10);
		t8.setBounds(673, 227, 58, 31);
		contentPane.add(t8);
		
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setBounds(305, 287, 48, 23);
		contentPane.add(yearChooser);
		
		JButton btnOkey = new JButton("OKEY");
		btnOkey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Livre=t1.getText();
				GuiEvent guiEvent=new GuiEvent(this,1);
				guiEvent.addParameter(Livre);
				AgentG.onGuiEvent(guiEvent);
			}
		});
		btnOkey.setBounds(203, 335, 89, 23);
		contentPane.add(btnOkey);
		
		textField = new JTextField();
		textField.setBounds(37, 327, 156, 49);
		contentPane.add(textField);
		textField.setColumns(10);
	}
	
	
	/*public Reservation_guide getAgentCentral() {
		return agentCentral;
	}
	
	public void setAgentCentral(Reservation_guide agentCentral2) {
		// TODO Auto-generated method stub
		this.agentCentral = agentCentral;
	}*/
	}
