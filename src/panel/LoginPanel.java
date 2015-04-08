package panel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginPanel extends JFrame{
	
	private GridLayout loginLayout = new GridLayout(6, 0, 0, 5);
	private GridLayout infoLayout = new GridLayout(7, 2, 0, 1);
	private ImageIcon logo = new ImageIcon("src/panel/pppicture.png");
	private JPanel panel = new JPanel();
	private JPanel logoPanel = new JPanel();
	private JPanel newUserPanel = new JPanel();
	
	private JPanel loginPanel;
	private JButton signIn;
	private JLabel existingUserEnter;
	private JTextField existingUser;
	private JLabel existingPasswordEnter;
	private JPasswordField existingPassword;
	
	private JButton logoButton = new JButton();
	private JButton newUser = new JButton("New User");
	private JButton login = new JButton("Login");
	private JButton submit = new JButton("Submit");
	private JLabel title = new JLabel("Welcome to the Patient Portal System!", SwingConstants.CENTER);
	private JLabel descriptionOne = new JLabel("If you are new to the system, please click \"NewUser\" to create an account", SwingConstants.CENTER);
	private JLabel descriptionTwo = new JLabel("Otherwise, please click \"Login\"", SwingConstants.CENTER);
	private JLabel nameOne = new JLabel("First Name:");
	private JLabel nameTwo = new JLabel("Last Name:");
	private JLabel emailEnter = new JLabel("Email:");
	private JLabel typeEnter = new JLabel("User Type:");
	private JLabel usernameEnter = new JLabel("Username:");
	private JLabel passwordEnter = new JLabel("Password:");
	private JTextField firstName = new JTextField(20);
	private JTextField lastName = new JTextField(20);
	private JTextField email = new JTextField(20);
	private JTextField userName = new JTextField(20);
	private JPasswordField password = new JPasswordField(20);
	private String[] types = {"Patient", "Doctor", "Nurse", "Staff"};
	private JComboBox userType = new JComboBox(types);
	
	public LoginPanel(){
		super("Patient Portal");
		setLayout(new FlowLayout());

		int scale = 2;
		int width = logo.getIconWidth();
		int newWidth = width / scale;
		logoButton.setIcon(new ImageIcon(logo.getImage().getScaledInstance(newWidth, -1, Image.SCALE_SMOOTH)));
		logoPanel.add(logoButton);
		panel.setLayout(loginLayout);
		panel.add(title);
		panel.add(descriptionOne);
		panel.add(descriptionTwo);
		panel.add(newUser);
		panel.add(login);
		newUserPanel.setLayout(infoLayout);
		newUserPanel.add(nameOne);
		newUserPanel.add(firstName);
		newUserPanel.add(nameTwo);
		newUserPanel.add(lastName);
		newUserPanel.add(emailEnter);
		newUserPanel.add(email);
		newUserPanel.add(typeEnter);
		newUserPanel.add(userType);
		newUserPanel.add(usernameEnter);
		newUserPanel.add(userName);
		newUserPanel.add(passwordEnter);
		newUserPanel.add(password);
		newUserPanel.add(submit);
		
		loginPanel = new JPanel(new GridLayout(3, 2, 0, 0));
		existingUserEnter = new JLabel("UserName: ");
		existingUser = new JTextField(20);
		existingPasswordEnter = new JLabel("PassWord: ");
		existingPassword = new JPasswordField(20);
		signIn = new JButton("Sign In");		
		loginPanel.add(existingUserEnter);
		loginPanel.add(existingUser);
		loginPanel.add(existingPasswordEnter);
		loginPanel.add(existingPassword);
		loginPanel.add(signIn);
		
		add(logoPanel, BorderLayout.NORTH);
		add(panel, BorderLayout.SOUTH);
		add(newUserPanel, BorderLayout.SOUTH);
		add(loginPanel, BorderLayout.SOUTH);
		newUserPanel.setVisible(false);
		loginPanel.setVisible(false);
	}
	
	public void registerListeners(LoginController lc){
		login.addActionListener(lc);
		newUser.addActionListener(lc);
		logoButton.addActionListener(lc);
		submit.addActionListener(lc);
		signIn.addActionListener(lc);
	}
	
	public void resetFields(){
		firstName.setText("");
		lastName.setText("");
		email.setText("");
		userName.setText("");
		password.setText("");
	}
	
	public void resetPassword(){
		existingUser.setText("");
		existingPassword.setText("");
	}
	
	//temporary check method to test authentication
	public void checkUser(LoginController lc){
		try {
			lc.checkCredentials(existingUser.getText(), existingPassword.getPassword());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(signIn, "Invalid Credentials");
		}
	}
	
	public JPanel getLoginPanel(){
		return this.loginPanel;
	}
	
	public JPanel getMainPanel(){
		return this.panel;
	}
	
	public JPanel getNewUserPanel(){
		return this.newUserPanel;
	}
	
}