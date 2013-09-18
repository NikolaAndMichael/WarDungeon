package net.naprav.wardungeon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class LoginScreen extends JFrame {
	private static final long serialVersionUID = 1203994186653691379L;

	static int WIDTH = WindowFrame.WIDTH;
	static int HEIGHT = WindowFrame.HEIGHT;
	
	private static final Dimension size = new Dimension(WIDTH, HEIGHT);
	
	private ImageIcon image;
	JLabel usernamelab;
	JLabel passwordlab;
	JTextField username;
	JPasswordField password;
	Action action;
	JButton login;
	JPanel pane;
	
	/**
	 * Sets the look and feel due to OS and sets up the basic login screen.
	 * @param title
	 */
	public LoginScreen(String title) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(null, "We could not install the look and feel of your OS!", "Failure to to do so!", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		} 
		
		this.setTitle(title);
		this.setSize(size);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		this.setLayout(null);
		
		image = new ImageIcon("res/wardungeon_logo.png");
		this.setIconImage(image.getImage());

		pane = new JPanel();
		
		pane.setBackground(Color.GREEN);
		pane.setSize(WindowFrame.WIDTH, WindowFrame.HEIGHT);
		pane.setVisible(true);
		
		pane.setLayout(null);
		
		login = new JButton("Login");
		login.setVisible(true);
		login.setSize(75, 20);
		login.setLocation(710,500);
		
		passwordlab = new JLabel("Password:");
		passwordlab.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordlab.setVisible(true);
		passwordlab.setSize(100,25);
		passwordlab.setLocation(640, 471);
		
		usernamelab = new JLabel("Username:");
		usernamelab.setFont(new Font("Tahoma", Font.PLAIN, 16));
		usernamelab.setVisible(true);
		usernamelab.setSize(100,25);
		usernamelab.setLocation(640, 440);
		
		password = new JPasswordField();
		password.setVisible(true);
		password.setSize(100,25);
		password.setLocation(700, 440);
		
		username = new JTextField("");
		username.setVisible(true);
		username.setSize(100,25);
		username.setLocation(700, 470);
		action = new Action();
		login.addActionListener(action);
		
		pane.add(login);
		pane.add(username);
		pane.add(password);
		pane.add(usernamelab);
		pane.add(passwordlab);
		this.setContentPane(pane);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Gains the ability to login to play WarDungeon. 
	 */
	public void loginGame() {
		//Need to contact server for stuffs!
		this.dispose();
		WindowFrame window = new WindowFrame("WarDungeon");
		window.requestFocus();
	}
	
	public void paint(Graphics gfx) {
		Image image = this.createImage(this.getWidth(), this.getHeight());
		Graphics graphics = image.getGraphics();
		this.paintComponent(graphics);
		gfx.drawImage(image, 0, 0, this);
	}
	
	public void paintComponent(Graphics gfx) {
		super.paint(gfx);
		
		gfx.setColor(Color.RED);
		gfx.fillRect(250, 450, this.getWidth(), 500);
		gfx.setColor(Color.CYAN);
		gfx.fillRect(0, 0, 250, this.getHeight());
		
		this.repaint();
	}
	
	public class Action implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			loginGame();
		}
	}
}
