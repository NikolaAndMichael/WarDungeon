package net.naprav.wardungeon.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import net.naprav.wardungeon.WarDungeon;
import net.naprav.wardungeon.login.file.Directory;

public class Login extends JPanel {

	private static final long serialVersionUID = 1L;

	private static final int WIDTH = WarDungeon.WIDTH;
	private static final int HEIGHT = WarDungeon.HEIGHT;
	private static final int SCALE = 2;
	private final Dimension size = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);

	JFrame frame;
	Background background;
	ScreenShot shot;
	Register account;
	LoginGame gamelogin;
	Directory directory;

	Action action;

	JButton login;
	JButton register;
	JTextField username;
	JPasswordField passcode;

	/**
	 * Main constructor for the login screen.
	 */
	public Login() {
		background = new Background(WIDTH, HEIGHT, "/login/login_screen.png");
		shot = new ScreenShot(654, 392, "/login/splash.png");
		directory = new Directory();

		createWindow();
	}

	/**
	 * Creates a JFrame for the content to reside in.
	 */
	private final void createWindow() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception exc) {
			exc.printStackTrace();
		}

		frame = new JFrame("WarDungeon Login");
		
		// MAKE SURE TO CHANGE TO THE NAPRAV REGISTER SITE!!!
		account = new Register("www.google.ca");
		gamelogin = new LoginGame();

		action = new Action();

		login = new JButton("Login!");
		login.setBackground(new Color(23, 23, 23));
		login.setFont(new Font("Tahoma", Font.PLAIN, 15));
		login.setBounds(85, 400, 100, 25);
		login.addActionListener(action);

		register = new JButton("Register!");
		register.setBackground(new Color(23, 23, 23));
		register.setFont(new Font("Tahoma", Font.PLAIN, 14));
		register.setBounds(85, 430, 100, 25);
		register.addActionListener(action);

		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.PLAIN, 14));
		username.setBounds(70, 290, 125, 25);

		passcode = new JPasswordField();
		passcode.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passcode.setBounds(70, 350, 125, 25);

		setPreferredSize(size);
		setLayout(null);

		add(login);
		add(register);
		add(username);
		add(passcode);
		frame.setContentPane(this);

		frame.setSize(size);
		frame.setResizable(false);
		frame.setIconImage(new ImageIcon("res/wardungeon_logo.png").getImage());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Paints the JPanel.
	 */
	public void paintComponent(Graphics gfx) {
		super.paintComponent(gfx);

		gfx.drawImage(background.image, 0, 0, getWidth(), getHeight(), null);
		gfx.drawImage(shot.image, 264, 0, 654, 372, null);

		gfx.setColor(new Color(105, 105, 105));
		gfx.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gfx.drawString("Naprav © 2013", 3, (getHeight() - 4));
		gfx.drawString("\"WarDungeon\" is a trademark of Naprav Specifications.", (getWidth() - 302), (getHeight() - 3));

		gfx.setColor(new Color(120, 120, 120));
		gfx.drawString("Username:", 105, 285);
		gfx.drawString("Password:", 105, 345);
	}

	@SuppressWarnings("deprecation")
	public class Action implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			if (action.getSource() == login) {
				gamelogin.attemptLogin(username.getText(), passcode.getText(), frame);
				directory.createDirectories();
			} else if (action.getSource() == register) {
				account.registerAccount();
			}
		}
	}
}
