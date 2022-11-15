package partie2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import jade.gui.GuiEvent;

public class ChoixVols extends JFrame {
	 private   AgentCentral AgentG;
	private JPanel contentPane;
	public static JTable table;
   String id1,id2;
   int f=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChoixVols frame = new ChoixVols();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	public AgentCentral getAgentG() {
		return AgentG;
	}

	public void setAgentG(AgentCentral agentG) {
		AgentG = agentG;
	}

	/**
	 * Create the frame.
	 */
	public ChoixVols() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 240, 245));
		panel.setBounds(0, 0, 917, 405);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 78, 897, 253);
		panel.add(scrollPane);
		
		table = new JTable(){
			 public boolean isCellEditable(int d,int c) {
				 return false;
			 }
		 };
			
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Aeroport", "id vol", "Organisation", "D\u00E9part", "D\u00E9stination", "Depart le ", "\u00E0", "Retour le", "\u00E0", "Dur\u00E9 de Vol", "Prix de vol"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(0);
		table.getColumnModel().getColumn(1).setMinWidth(0);
		table.getColumnModel().getColumn(1).setMaxWidth(0);
	
		JTableHeader theader=table.getTableHeader();
		theader.setBackground(Color.lightGray);
		theader.setForeground(Color.BLACK);
		theader.setFont(new Font("Arial",Font.BOLD,14));
		table.setFont(new Font("tahome",Font.BOLD,12));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int ligne= table.getSelectedRow();
				
				  id1=table.getModel().getValueAt(ligne, 1).toString();
				  id2=table.getModel().getValueAt(ligne, 2).toString();
				  table.setSelectionBackground(Color.getColor("a", Color.getHSBColor(520, 50, 50)));
					 table.setSelectionForeground(Color.BLACK);
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblVeuillezChoisirUn = new JLabel("veuillez choisir un vol");
		lblVeuillezChoisirUn.setForeground(new Color(47, 79, 79));
		lblVeuillezChoisirUn.setBackground(new Color(47, 79, 79));
		lblVeuillezChoisirUn.setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 21));
		lblVeuillezChoisirUn.setBounds(265, 11, 476, 38);
		panel.add(lblVeuillezChoisirUn);
		
		JButton btnValid = new JButton("Valider");
		btnValid.setFont(new Font("Segoe UI Historic", Font.BOLD, 13));
		btnValid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f=1;
		
				//AgentG.onGuiEvent(null);
				GuiEvent guiEvent=new GuiEvent(this,2);
				guiEvent.addParameter(id1);
				guiEvent.addParameter(id2);
				
				
				AgentG.onGuiEvent(guiEvent);
			}
		});
		btnValid.setBounds(359, 356, 180, 38);
		panel.add(btnValid);
	}

	}
