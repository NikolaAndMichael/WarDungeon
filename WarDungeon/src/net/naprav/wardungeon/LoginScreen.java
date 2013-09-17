package net.naprav.wardungeon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import net.naprav.wardungeon.WindowFrame;

public class LoginScreen extends JFrame {
	private static final long serialVersionUID = 1203994186653691379L;

	static int WIDTH = WindowFrame.WIDTH;
	static int HEIGHT = WindowFrame.HEIGHT;
	
	private static final Dimension size = new Dimension(WIDTH, HEIGHT);
	
	private ImageIcon image;
	
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
		this.setResizable(true);
		this.setLocationRelativeTo(null);

		this.setLayout(null);
		
		image = new ImageIcon("res/wardungeon_logo.png");
		this.setIconImage(image.getImage());

		pane = new JPanel();
		
		pane.setBackground(Color.RED);
		pane.setSize(WindowFrame.WIDTH, WindowFrame.HEIGHT);
		pane.setVisible(true);
		
		pane.setLayout(null);
		
		login = new JButton("Login");
		login.setVisible(true);
		login.setSize(75, 20);
		login.setLocation(50, 50);
		
		action = new Action();
		login.addActionListener(action);
		
		pane.add(login);
		
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
	
	public class Action implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			loginGame();
		}
	}
}
