package net.naprav.wardungeon.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import net.naprav.wardungeon.login.file.Directory;

public class Login extends JPanel {

	private static final long serialVersionUID = 1L;

	private static final int WIDTH = 495;
	private static final int HEIGHT = 307;
	private static final int SCALE = 2;
	private final Dimension size = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);

	private BufferedImage screen = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	public int[] pixels = ((DataBufferInt) screen.getRaster().getDataBuffer()).getData();

	private BufferedImage image = new BufferedImage(315, 177, BufferedImage.TYPE_INT_RGB);
	public int[] shotPixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	JFrame frame;
	MainMenu menu;
	ScreenShot shot;
	Register account;
	LoginGame gamelogin;
	Directory directory;

	Action action;

	JButton login;
	JButton register;
	JTextField username;
	JPasswordField passcode;

	public Login() {
		menu = new MainMenu(WIDTH, HEIGHT, "/login/login_screen.png");
		shot = new ScreenShot(315, 177, "/login/splash.png");
		directory = new Directory();

		createWindow();
	}

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
		login.setFont(new Font("Tahoma", Font.PLAIN, 15));
		login.setBounds(90, 480, 100, 25);
		login.addActionListener(action);

		register = new JButton("Register!");
		register.setFont(new Font("Tahoma", Font.PLAIN, 14));
		register.setBounds(90, 510, 100, 25);
		register.addActionListener(action);

		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.PLAIN, 14));
		username.setBounds(75, 370, 125, 25);

		passcode = new JPasswordField();
		passcode.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passcode.setBounds(75, 430, 125, 25);

		setPreferredSize(size);
		setLayout(null);

		add(login);
		add(register);
		add(username);
		add(passcode);
		frame.setContentPane(this);

		frame.setSize(size);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setIconImage(new ImageIcon("res/wardungeon_logo.png").getImage());
		frame.setLocationRelativeTo(null);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void updateLogin() {
		for (int a = 0; a < pixels.length; a++) {
			pixels[a] = menu.pixels[a];
		}

		for (int a = 0; a < shotPixels.length; a++) {
			shotPixels[a] = shot.splashPixels[a];
		}
	}

	public void paintComponent(Graphics gfx) {
		super.paintComponent(gfx);

		updateLogin();
		
		gfx.drawImage(screen, 0, 0, getWidth(), getHeight(), null);
		gfx.drawImage(image, 320, 37, 625, 340, null);

		gfx.setColor(new Color(90, 90, 90));
		gfx.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gfx.drawString("Naprav © 2013", 3, (getHeight() - 4));
		gfx.drawString("\"WarDungeon\" is a trademark of Naprav Specifications.", (getWidth() - 302), (getHeight() - 3));

		gfx.setColor(new Color(115, 115, 115));
		gfx.drawString("Username:", 110, 365);
		gfx.drawString("Password:", 110, 425);
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
