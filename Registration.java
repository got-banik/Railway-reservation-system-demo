package mysql;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField email;
	private JTextField mobile;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
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
	public Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistrationForm = new JLabel("Registration Form");
		lblRegistrationForm.setForeground(Color.WHITE);
		lblRegistrationForm.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		lblRegistrationForm.setBounds(163, 11, 180, 37);
		contentPane.add(lblRegistrationForm);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(46, 69, 64, 25);
		contentPane.add(lblName);
		
		JLabel lblMobileNo = new JLabel("Mobile No");
		lblMobileNo.setForeground(Color.WHITE);
		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMobileNo.setBounds(46, 150, 91, 29);
		contentPane.add(lblMobileNo);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(46, 127, 64, 25);
		contentPane.add(lblEmail);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setBounds(46, 99, 91, 25);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(46, 180, 78, 25);
		contentPane.add(lblPassword);
		
		name = new JTextField();
		name.setBounds(104, 73, 239, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setBounds(147, 103, 196, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		email = new JTextField();
		email.setBounds(157, 131, 186, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		mobile = new JTextField();
		mobile.setBounds(147, 156, 196, 20);
		contentPane.add(mobile);
		mobile.setColumns(10);
		
		password = new JTextField();
		password.setBounds(147, 184, 196, 20);
		contentPane.add(password);
		password.setColumns(10);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database1","root","12345");
					String sql="INSERT INTO registration VALUES(?,?,?,?,?)";
					PreparedStatement statement = con.prepareStatement(sql);
					statement.setString(1, name.getText());
					statement.setString(2, username.getText());
					statement.setString(3, email.getText());
					statement.setString(4, mobile.getText());
					statement.setString(5, password.getText());
					statement.execute();
					JOptionPane.showMessageDialog(null, "Registration Succesfull");
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSignUp.setBounds(163, 227, 89, 23);
		contentPane.add(btnSignUp);
		
		JButton btnHomePage = new JButton("Home Page");
		btnHomePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcome wl=new welcome();
				wl.setVisible(true);
						
			}
		});
		btnHomePage.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnHomePage.setBounds(361, 69, 104, 60);
		contentPane.add(btnHomePage);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login lg=new login();
				lg.setVisible(true);
			}
		});
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogIn.setBounds(361, 155, 104, 50);
		contentPane.add(btnLogIn);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\got.banik\\Downloads\\rail-759.jpg"));
		label.setBounds(-15, 0, 524, 305);
		contentPane.add(label);
	}

}
