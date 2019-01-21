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
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JTextField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogIn = new JLabel("LOGIN PAGE");
		lblLogIn.setForeground(Color.WHITE);
		lblLogIn.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
		lblLogIn.setBounds(172, 11, 128, 53);
		contentPane.add(lblLogIn);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUserName.setBounds(46, 89, 75, 14);
		contentPane.add(lblUserName);
		
		user = new JTextField();
		user.setBounds(171, 84, 223, 28);
		contentPane.add(user);
		user.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(46, 146, 75, 14);
		contentPane.add(lblPassword);
		
		pass = new JTextField();
		pass.setBounds(171, 141, 223, 28);
		contentPane.add(pass);
		pass.setColumns(10);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database1","root","12345");
					Statement stmt=con.createStatement();
					String sql="SELECT * FROM registration WHERE username='"+user.getText()+"' AND pass='"+pass.getText().toString()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next())
					{
						JOptionPane.showMessageDialog(null, "Login succesfully");
						Booking login=new Booking();
						login.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null, "inncorrect");
					con.close();
				}
				catch(Exception c)
				{
					System.out.println(c);
				}
			}
		});
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogIn.setBounds(189, 180, 89, 34);
		contentPane.add(btnLogIn);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcome wl=new welcome();
				wl.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBack.setBounds(189, 225, 89, 28);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\got.banik\\Downloads\\gleise-41646_20141210143829790.jpg"));
		label.setBounds(-127, -107, 693, 493);
		contentPane.add(label);
	}
}
