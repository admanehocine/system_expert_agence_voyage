package partie2;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

public class menu_client extends JFrame {
    
	private static Connection cnx=null;
	private JPanel contentPane;
    public static String User ="";
    protected static String id  ;
    private static int fails = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu_client frame = new menu_client();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
					cnx=connexion.connecter();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws UnknownHostException 
	 */
	
	
	public menu_client() {
		
	
		setResizable(false);
		setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 794, 471);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnHistorique = new JButton("historique");
		btnHistorique.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 14));
		btnHistorique.setBounds(440, 178, 154, 41);
		panel.add(btnHistorique);
		
		JButton btnNouveauVoyage = new JButton("nouveau voyage");
		btnNouveauVoyage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reservation.main(null);
			}
		});
		btnNouveauVoyage.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 14));
		btnNouveauVoyage.setBounds(146, 177, 154, 43);
		panel.add(btnNouveauVoyage);
		
		
	}
}
