package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import constantes.Constantes;
import controllers.LoginController;
import controllers.MantenimientoEmpleadosController;
import models.Empleado;

public class Login extends JFrame {

	MantenimientoEmpleadosController empleados = new MantenimientoEmpleadosController("empleados.txt");
	Register register = new Register();
	LoginController login = new LoginController("userLoged.txt");
	Menu menu = new Menu();
	
	private int count = 0;
	private JPanel contentPane;
	private JLabel btnClose;
	private JLabel lblLogin;
	private JSeparator separator;
	private JLabel lblBackUsuario;
	private JLabel lblUsuario;
	private JLabel lblBackContraseña;
	private JLabel lblContrasea;
	private JLabel btnIngresar;
	private JLabel lblIngresar;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	private JLabel lblBackground;
	private JLabel lblNuevo;
	private JSeparator separator_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		menu.setVisible(false);
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnClose = new JLabel("");
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnClose.setIcon(new ImageIcon(Login.class.getResource("/views/images/close-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnClose.setIcon(new ImageIcon(Login.class.getResource("/views/images/close.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		btnClose.setIcon(new ImageIcon(Login.class.getResource("/views/images/close.png")));
		btnClose.setBounds(394, 11, 16, 14);
		btnClose.setCursor(Constantes.pointer);
		contentPane.add(btnClose);
		
		lblLogin = new JLabel("LOGIN");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(Constantes.skyblue);
		lblLogin.setFont(Constantes.boldFont);
		lblLogin.setBounds(168, 76, 84, 33);
		contentPane.add(lblLogin);
		
		separator = new JSeparator();
		separator.setBounds(50, 120, 320, 2);
		separator.setForeground(Constantes.lightgray);
		contentPane.add(separator);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(Constantes.regularFont);
		txtUsuario.setOpaque(false);
		txtUsuario.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtUsuario.setBounds(64, 191, 295, 26);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		lblBackUsuario = new JLabel("");
		lblBackUsuario.setIcon(new ImageIcon(Login.class.getResource("/views/images/input-text.png")));
		lblBackUsuario.setPreferredSize(new Dimension(10, 14));
		lblBackUsuario.setBounds(50, 180, 320, 45);
		contentPane.add(lblBackUsuario);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(Constantes.regularFont);
		lblUsuario.setBounds(50, 160, 51, 14);
		lblUsuario.setForeground(Constantes.textgray);
		contentPane.add(lblUsuario);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(Constantes.regularFont);
		txtPassword.setOpaque(false);
		txtPassword.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtPassword.setBounds(65, 275, 295, 26);
		contentPane.add(txtPassword);
		
		lblBackContraseña = new JLabel("");
		lblBackContraseña.setIcon(new ImageIcon(Login.class.getResource("/views/images/input-text.png")));
		lblBackContraseña.setPreferredSize(new Dimension(10, 14));
		lblBackContraseña.setBounds(50, 266, 320, 45);
		contentPane.add(lblBackContraseña);
		
		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setForeground(Constantes.textgray);
		lblContrasea.setFont(Constantes.regularFont);
		lblContrasea.setBounds(50, 245, 84, 16);
		contentPane.add(lblContrasea);
		
		lblIngresar = new JLabel("Ingresar");
		lblIngresar.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresar.setForeground(new Color(255, 255, 255));
		lblIngresar.setFont(Constantes.regularFont);
		lblIngresar.setBounds(182, 344, 58, 14);
		lblIngresar.setCursor(Constantes.pointer);
		contentPane.add(lblIngresar);
		
		btnIngresar = new JLabel("");
		btnIngresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIngresar.setIcon(new ImageIcon(Login.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIngresar.setIcon(new ImageIcon(Login.class.getResource("/views/images/btn-login.png")));
			}
			public void accessTimer(){
				Timer timer = new Timer();
				TimerTask task = new TimerTask(){
					@Override
					public void run(){
						txtUsuario.setText("");
						txtUsuario.setEditable(true);
						lblBackUsuario.setEnabled(true);
						txtPassword.setText("");
						txtPassword.setEditable(true);
						lblBackContraseña.setEnabled(true);
						btnIngresar.setEnabled(true);
						btnIngresar.setCursor(Constantes.defaultCursor);
						lblIngresar.setCursor(Constantes.defaultCursor);
					}
				};
				timer.schedule(task, 5000);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(btnIngresar.isEnabled()){
						String user = getUsuario();
						String password = getPassword();
						Empleado userLogin = empleados.buscarPorUsuario(user);
						if(userLogin != null){
							if(password.contentEquals(userLogin.getPassword())){
								login.saveUser(user);
								menu = new Menu();
								menu.setVisible(true);
								dispose();
								
							}
							else {
								mensaje("Su contraseña es incorrecta");
								count++;
								if(count >= 3){
									mensaje("Debido a que ha superado el número máximo de intentos permitidos,\nhemos bloqueado su cuenta por motivos de seguridad.\nPor favor intentelo nuevamente en unos instantes.");
									txtUsuario.setText("");
									txtUsuario.setEditable(false);
									lblBackUsuario.setEnabled(false);
									txtPassword.setText("");
									txtPassword.setEditable(false);
									lblBackContraseña.setEnabled(false);
									btnIngresar.setEnabled(false);
									btnIngresar.setCursor(Constantes.defaultCursor);
									lblIngresar.setCursor(Constantes.defaultCursor);
									accessTimer();
								}
							}
						}
						else {
							mensaje("No encontramos el usuario ingresado. Intente nuevamente.");
						}
					}
					else {
						return;
					}
				}
				catch(Exception err){
					System.out.println(err);
				}
			}
		});
		btnIngresar.setIcon(new ImageIcon(Login.class.getResource("/views/images/btn-login.png")));
		btnIngresar.setBounds(160, 333, 100, 35);
		btnIngresar.setCursor(Constantes.pointer);
		contentPane.add(btnIngresar);
		
		lblNuevo = new JLabel("Crear nuevo usuario");
		lblNuevo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				register.setVisible(true);
			}
		});
		lblNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevo.setFont(Constantes.regularFont);
		lblNuevo.setCursor(Constantes.pointer);
		lblNuevo.setBounds(137, 381, 145, 14);
		contentPane.add(lblNuevo);
		
		register.addWindowListener(new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {
			}
			@Override
			public void windowIconified(WindowEvent e) {
			}
			@Override
			public void windowDeiconified(WindowEvent e) {
			}
			@Override
			public void windowDeactivated(WindowEvent e) {
			}
			@Override
			public void windowClosing(WindowEvent e) {
			}
			@Override
			public void windowClosed(WindowEvent e) {
				empleados.cargarEmpleados();
			}
			@Override
			public void windowActivated(WindowEvent e) {
			}
		});
		
		separator_1 = new JSeparator();
		separator_1.setBounds(158, 395, 107, 4);
		contentPane.add(separator_1);
		
		lblBackground = new JLabel("");
		lblBackground.setBackground(Color.WHITE);
		lblBackground.setBorder(new LineBorder(Constantes.lightgray, 2));
		lblBackground.setIcon(new ImageIcon(Login.class.getResource("/views/images/background-login.png")));
		lblBackground.setBounds(0, 0, 420, 450);
		contentPane.add(lblBackground);
		// Deshabilitar diseño por defecto del jframe
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		menu.addWindowListener(new WindowListener() {
			@Override
			public void windowOpened(java.awt.event.WindowEvent arg0) {
			}
			@Override
			public void windowIconified(java.awt.event.WindowEvent arg0) {
			}
			@Override
			public void windowDeiconified(java.awt.event.WindowEvent arg0) {
			}
			@Override
			public void windowDeactivated(java.awt.event.WindowEvent arg0) {
			}
			@Override
			public void windowClosing(java.awt.event.WindowEvent arg0) {
			}
			@Override
			public void windowClosed(java.awt.event.WindowEvent arg0) {
				setVisible(true);
				txtUsuario.setText("");
				txtPassword.setText("");
			}
			@Override
			public void windowActivated(java.awt.event.WindowEvent arg0) {
			}
		});
	}
	
	private String getUsuario(){
		return txtUsuario.getText();
	}
	
	@SuppressWarnings("deprecation")
	private String getPassword(){
		return txtPassword.getText();
	}
	
	private void mensaje(String msg){
		JOptionPane.showMessageDialog(null, msg);
	}
	
}
