package login_sy;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;

import student_ms.Student_MS;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login_S {

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_S window = new Login_S();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_S() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 100, 633, 426);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login System");
		lblNewLabel.setBounds(212, 22, 168, 34);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(112, 94, 103, 34);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(112, 156, 96, 34);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(232, 106, 130, 19);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(232, 168, 130, 19);
		frame.getContentPane().add(txtPassword);
		
		JButton btnButton = new JButton("Login");
		btnButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnButton.setBounds(69, 281, 120, 52);
		btnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String password = txtPassword.getText();
				String username = txtUsername.getText();
				if (password.contains("DSCE")&& username.contains("Admin")) {
					txtPassword.setText(null);
					txtUsername.setText(null);
					
					Student_MS open= new Student_MS();
					Student_MS.main(null);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid Login Details","Login Error",JOptionPane.ERROR_MESSAGE);
					txtPassword.setText(null);
					txtUsername.setText(null);
				}
			}
		});
		frame.getContentPane().add(btnButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReset.setBounds(268, 281, 120, 52);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtUsername.setText(null);
				txtPassword.setText(null);
			}
		});
		frame.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExit.setBounds(469, 281, 120, 52);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JButton frmLoginSystem = new JButton("Exit");
				if (JOptionPane.showConfirmDialog(frmLoginSystem,"Confirm if you want to exit", "Login Systems",
					JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		frame.getContentPane().add(btnExit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(559, 205, -497, -6);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(204, 73, 1, 2);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(43, 229, 522, 7);
		frame.getContentPane().add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(47, 73, 367, -10);
		frame.getContentPane().add(separator_3);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(43, 73, 522, 7);
		frame.getContentPane().add(separator_2_1);
	}
}
