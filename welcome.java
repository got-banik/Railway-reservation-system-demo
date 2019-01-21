package mysql;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class welcome extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					welcome frame = new welcome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public welcome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToIrct = new JLabel("Welcome to IRCTC");
		lblWelcomeToIrct.setForeground(Color.WHITE);
		lblWelcomeToIrct.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
		lblWelcomeToIrct.setBounds(148, 11, 194, 32);
		contentPane.add(lblWelcomeToIrct);
		
		JLabel lblEnterYourEmail = new JLabel("Enter your email adress for more update about us.");
		lblEnterYourEmail.setForeground(Color.PINK);
		lblEnterYourEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEnterYourEmail.setBounds(83, 66, 344, 14);
		contentPane.add(lblEnterYourEmail);
		
		textField = new JTextField();
		textField.setBounds(68, 91, 361, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnGetInTouch = new JButton("GET IN TOUCH");
		btnGetInTouch.setBounds(188, 124, 116, 22);
		contentPane.add(btnGetInTouch);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registration welcome = new Registration();
				welcome.setVisible(true);
			}
		});
		btnSignUp.setBounds(68, 188, 103, 23);
		contentPane.add(btnSignUp);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login lg=new login();
				lg.setVisible(true);
			}
		});
		btnLogIn.setBounds(68, 254, 103, 23);
		contentPane.add(btnLogIn);
		
		JLabel lblForNewUsers = new JLabel("For new users please sign up");
		lblForNewUsers.setForeground(Color.WHITE);
		lblForNewUsers.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblForNewUsers.setBounds(68, 157, 209, 20);
		contentPane.add(lblForNewUsers);
		
		JLabel lblForExsistingUsers = new JLabel("For Exsisting Users");
		lblForExsistingUsers.setForeground(Color.WHITE);
		lblForExsistingUsers.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblForExsistingUsers.setBounds(68, 222, 146, 21);
		contentPane.add(lblForExsistingUsers);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\got.banik\\Downloads\\train-Copy-620x400.jpg"));
		lblNewLabel.setBounds(0, -15, 498, 321);
		contentPane.add(lblNewLabel);
	}
}
