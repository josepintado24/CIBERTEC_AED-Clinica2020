package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
import controllers.MantenimientoEmpleadosController;
import models.Empleado;

public class Register extends JFrame {

	MantenimientoEmpleadosController empleados = new MantenimientoEmpleadosController("empleados.txt");
	
	private JPanel contentPane;
	private JLabel btnClose;
	private JLabel lblTitleRegistrar;
	private JSeparator separator;
	private JLabel lblBackCodigo;
	private JLabel lblCodigo;
	private JLabel btnRegistrar;
	private JLabel lblRegistrar;
	private JTextField txtCodigo;
	private JLabel lblBackground;
	private JLabel lblBackNombre;
	private JTextField txtNombre;
	private JLabel lblNombre;
	private JTextField txtUsuario;
	private JLabel lblBackUsuario;
	private JLabel lblUsuario;
	private JTextField txtApellidos;
	private JLabel lblBackApellidos;
	private JLabel lblApellidos;
	private JLabel lblPassword;
	private JLabel lblBackPassword;
	private JTextField txtCargo;
	private JLabel lblBackCargo;
	private JLabel lblCargo;
	private JLabel lblTelfono;
	private JTextField txtTelefono;
	private JLabel lblBackTelefono;
	private JTextField txtDni;
	private JLabel lblBackDni;
	private JLabel lblDni;
	private JPasswordField txtPassword;
	private JPanel cboCargo;
	private JLabel label;
	private JLabel btnSeleccionar;
	private JLabel btnMedico;
	private JLabel btnEnfermera;
	private JLabel btnSupervisor;
	private JLabel lblArrowCargo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 534);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnClose = new JLabel("");
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnClose.setIcon(new ImageIcon(Register.class.getResource("/views/images/close-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnClose.setIcon(new ImageIcon(Register.class.getResource("/views/images/close.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		
		cboCargo = new JPanel();
		cboCargo.setVisible(false);
		cboCargo.setBounds(363, 336, 290, 145);
		contentPane.add(cboCargo);
		cboCargo.setLayout(null);
		
		btnSeleccionar = new JLabel("Seleccionar --");
		btnSeleccionar.setOpaque(true);
		btnSeleccionar.setBackground(Color.white);
		btnSeleccionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnSeleccionar.setBackground(Constantes.hoverFont);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnSeleccionar.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtCargo.setText(btnSeleccionar.getText());
				cboCargo.setVisible(false);
			}
		});
		btnSeleccionar.setForeground(Constantes.textgray);
		btnSeleccionar.setFont(Constantes.regularFont);
		btnSeleccionar.setCursor(Constantes.pointer);
		btnSeleccionar.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnSeleccionar.setBounds(1, 11, 288, 30);
		cboCargo.add(btnSeleccionar);
		
		btnMedico = new JLabel("M\u00E9dico");
		btnMedico.setOpaque(true);
		btnMedico.setBackground(Color.white);
		btnMedico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnMedico.setBackground(Constantes.hoverFont);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnMedico.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtCargo.setText(btnMedico.getText());
				cboCargo.setVisible(false);
			}
		});
		btnMedico.setForeground(Constantes.textgray);
		btnMedico.setFont(Constantes.regularFont);
		btnMedico.setCursor(Constantes.pointer);
		btnMedico.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnMedico.setBounds(1, 42, 288, 30);
		cboCargo.add(btnMedico);
		
		btnEnfermera = new JLabel("Enfermera(o)");
		btnEnfermera.setOpaque(true);
		btnEnfermera.setBackground(Color.white);
		btnEnfermera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnEnfermera.setBackground(Constantes.hoverFont);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnEnfermera.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtCargo.setText(btnEnfermera.getText());
				cboCargo.setVisible(false);
			}
		});
		btnEnfermera.setForeground(Constantes.textgray);
		btnEnfermera.setFont(Constantes.regularFont);
		btnEnfermera.setCursor(Constantes.pointer);
		btnEnfermera.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnEnfermera.setBounds(1, 73, 288, 30);
		cboCargo.add(btnEnfermera);
		
		btnSupervisor = new JLabel("Supervisor(a)");
		btnSupervisor.setOpaque(true);
		btnSupervisor.setBackground(Color.white);
		btnSupervisor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnSupervisor.setBackground(Constantes.hoverFont);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnSupervisor.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtCargo.setText(btnSupervisor.getText());
				cboCargo.setVisible(false);
			}
		});
		btnSupervisor.setForeground(Constantes.textgray);
		btnSupervisor.setFont(Constantes.regularFont);
		btnSupervisor.setCursor(Constantes.pointer);
		btnSupervisor.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnSupervisor.setBounds(1, 104, 288, 30);
		cboCargo.add(btnSupervisor);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Register.class.getResource("/views/images/contenedor-combo-registro.png")));
		label.setBounds(0, 0, 290, 145);
		cboCargo.add(label);
		btnClose.setIcon(new ImageIcon(Register.class.getResource("/views/images/close.png")));
		btnClose.setBounds(674, 11, 16, 14);
		btnClose.setCursor(Constantes.pointer);
		contentPane.add(btnClose);
		
		lblTitleRegistrar = new JLabel("REGISTRAR");
		lblTitleRegistrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleRegistrar.setForeground(Constantes.skyblue);
		lblTitleRegistrar.setFont(Constantes.boldFont);
		lblTitleRegistrar.setBounds(294, 33, 112, 33);
		contentPane.add(lblTitleRegistrar);
		
		separator = new JSeparator();
		separator.setBounds(46, 64, 607, 2);
		separator.setForeground(Constantes.lightgray);
		contentPane.add(separator);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setFont(Constantes.regularFont);
		txtCodigo.setOpaque(false);
		txtCodigo.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtCodigo.setBounds(60, 124, 264, 26);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setOpaque(false);
		txtNombre.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		txtNombre.setColumns(10);
		txtNombre.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtNombre.setBounds(377, 124, 264, 26);
		contentPane.add(txtNombre);
		
		lblBackNombre = new JLabel("");
		lblBackNombre.setIcon(new ImageIcon(Register.class.getResource("/views/images/input-text-register.png")));
		lblBackNombre.setPreferredSize(new Dimension(10, 14));
		lblBackNombre.setBounds(363, 113, 290, 45);
		contentPane.add(lblBackNombre);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(new Color(68, 68, 68));
		lblNombre.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		lblNombre.setBounds(363, 93, 51, 14);
		contentPane.add(lblNombre);
		
		lblBackCodigo = new JLabel("");
		lblBackCodigo.setEnabled(false);
		lblBackCodigo.setIcon(new ImageIcon(Register.class.getResource("/views/images/input-text-register.png")));
		lblBackCodigo.setPreferredSize(new Dimension(10, 14));
		lblBackCodigo.setBounds(46, 113, 290, 45);
		contentPane.add(lblBackCodigo);
		
		lblCodigo = new JLabel("C\u00F3digo (Autogenerado):");
		lblCodigo.setFont(Constantes.regularFont);
		lblCodigo.setBounds(46, 93, 152, 14);
		lblCodigo.setForeground(Constantes.textgray);
		contentPane.add(lblCodigo);
		
		lblRegistrar = new JLabel("Registrar");
		lblRegistrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrar.setForeground(new Color(255, 255, 255));
		lblRegistrar.setFont(Constantes.regularFont);
		lblRegistrar.setBounds(328, 471, 58, 14);
		lblRegistrar.setCursor(Constantes.pointer);
		contentPane.add(lblRegistrar);
		
		btnRegistrar = new JLabel("");
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegistrar.setIcon(new ImageIcon(Register.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnRegistrar.setIcon(new ImageIcon(Register.class.getResource("/views/images/btn-login.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String user = getUsuario();
					Empleado buscarUsuario = empleados.buscarPorUsuario(user);
					if(buscarUsuario == null){
						String nombre = validarNombre();
						if(nombre == null) return;
						
						String apellidos = validarApellidos();
						if(apellidos == null) return;
						
						String usuario = validarUsuario();
						if(usuario == null) return;
						
						String password = validarPassword();
						if(password == null) return;
						
						String cargo = validarCargo();
						if(cargo == null) return;
						
						int telefono = validarTelefono();
						if(telefono == 0) return;
						
						int dni = validarDni();
						if(dni == 0) return;
						
						int option = JOptionPane.showConfirmDialog(null, "øEst· seguro de ingresar los registros de un nuevo empleado?", "Confirmar ingreso de datos", JOptionPane.OK_CANCEL_OPTION);
						
						if(option == 0){
							Empleado newEmpleado = new Empleado(getCodigo(), nombre, apellidos, dni,telefono, cargo, usuario, password);
							empleados.adicionar(newEmpleado);
							empleados.agregarEmpleado();
							
							mensaje("Los registros del nuevo empleado han sido grabados correctamente.");
							dispose();
						}
					}
					else {
						mensaje("Este usuario ya se encuentra registrado. Por favor ingrese uno diferente.");
						txtUsuario.requestFocus();
					}
					
				}
				catch(Exception err){
					mensaje("Hubo un error en el ingreso de datos.");
					System.out.println(err);
				}
			}
		});
		btnRegistrar.setIcon(new ImageIcon(Register.class.getResource("/views/images/btn-login.png")));
		btnRegistrar.setBounds(306, 460, 100, 35);
		btnRegistrar.setCursor(Constantes.pointer);
		contentPane.add(btnRegistrar);
		
		txtUsuario = new JTextField();
		txtUsuario.setOpaque(false);
		txtUsuario.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		txtUsuario.setColumns(10);
		txtUsuario.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtUsuario.setBounds(377, 209, 264, 26);
		contentPane.add(txtUsuario);
		
		lblBackUsuario = new JLabel("");
		lblBackUsuario.setIcon(new ImageIcon(Register.class.getResource("/views/images/input-text-register.png")));
		lblBackUsuario.setPreferredSize(new Dimension(10, 14));
		lblBackUsuario.setBounds(363, 198, 290, 45);
		contentPane.add(lblBackUsuario);
		
		lblUsuario = new JLabel("Usuario (con este identificador iniciar\u00E1s sesi\u00F3n):");
		lblUsuario.setForeground(new Color(68, 68, 68));
		lblUsuario.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		lblUsuario.setBounds(363, 178, 264, 14);
		contentPane.add(lblUsuario);
		
		txtApellidos = new JTextField();
		txtApellidos.setOpaque(false);
		txtApellidos.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		txtApellidos.setColumns(10);
		txtApellidos.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtApellidos.setBounds(60, 209, 264, 26);
		contentPane.add(txtApellidos);
		
		lblBackApellidos = new JLabel("");
		lblBackApellidos.setIcon(new ImageIcon(Register.class.getResource("/views/images/input-text-register.png")));
		lblBackApellidos.setPreferredSize(new Dimension(10, 14));
		lblBackApellidos.setBounds(46, 198, 290, 45);
		contentPane.add(lblBackApellidos);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setForeground(new Color(68, 68, 68));
		lblApellidos.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		lblApellidos.setBounds(46, 178, 152, 14);
		contentPane.add(lblApellidos);
		
		lblPassword = new JLabel("Contrase\u00F1a:");
		lblPassword.setForeground(new Color(68, 68, 68));
		lblPassword.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		lblPassword.setBounds(46, 268, 152, 14);
		contentPane.add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtPassword.setBounds(60, 298, 264, 26);
		contentPane.add(txtPassword);
		
		lblBackPassword = new JLabel("");
		lblBackPassword.setIcon(new ImageIcon(Register.class.getResource("/views/images/input-text-register.png")));
		lblBackPassword.setPreferredSize(new Dimension(10, 14));
		lblBackPassword.setBounds(46, 288, 290, 45);
		contentPane.add(lblBackPassword);
		
		lblArrowCargo = new JLabel("");
		lblArrowCargo.setIcon(new ImageIcon(Register.class.getResource("/views/images/ico-down.png")));
		lblArrowCargo.setBounds(633, 303, 10, 14);
		contentPane.add(lblArrowCargo);
		
		txtCargo = new JTextField();
		txtCargo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!cboCargo.isVisible()){
					cboCargo.setVisible(true);
				}
				else {
					cboCargo.setVisible(false);
				}
			}
		});
		txtCargo.setEditable(false);
		txtCargo.setCursor(Constantes.pointer);
		txtCargo.setText("Seleccionar --");
		txtCargo.setForeground(Constantes.textgray);
		txtCargo.setOpaque(false);
		txtCargo.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		txtCargo.setColumns(10);
		txtCargo.setBorder(new EmptyBorder(0, 10, 0, 10));
		txtCargo.setBounds(363, 288, 290, 45);
		contentPane.add(txtCargo);
		
		lblBackCargo = new JLabel("");
		lblBackCargo.setIcon(new ImageIcon(Register.class.getResource("/views/images/input-text-register.png")));
		lblBackCargo.setPreferredSize(new Dimension(10, 14));
		lblBackCargo.setBounds(363, 288, 290, 45);
		contentPane.add(lblBackCargo);
		
		lblCargo = new JLabel("Cargo:");
		lblCargo.setForeground(new Color(68, 68, 68));
		lblCargo.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		lblCargo.setBounds(363, 268, 264, 14);
		contentPane.add(lblCargo);
		
		lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setForeground(new Color(68, 68, 68));
		lblTelfono.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		lblTelfono.setBounds(46, 354, 152, 14);
		contentPane.add(lblTelfono);
		
		txtTelefono = new JTextField();
		txtTelefono.setOpaque(false);
		txtTelefono.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		txtTelefono.setColumns(10);
		txtTelefono.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtTelefono.setBounds(60, 385, 264, 26);
		contentPane.add(txtTelefono);
		
		lblBackTelefono = new JLabel("");
		lblBackTelefono.setIcon(new ImageIcon(Register.class.getResource("/views/images/input-text-register.png")));
		lblBackTelefono.setPreferredSize(new Dimension(10, 14));
		lblBackTelefono.setBounds(46, 374, 290, 45);
		contentPane.add(lblBackTelefono);
		
		txtDni = new JTextField();
		txtDni.setOpaque(false);
		txtDni.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		txtDni.setColumns(10);
		txtDni.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtDni.setBounds(377, 385, 264, 26);
		contentPane.add(txtDni);
		
		lblBackDni = new JLabel("");
		lblBackDni.setIcon(new ImageIcon(Register.class.getResource("/views/images/input-text-register.png")));
		lblBackDni.setPreferredSize(new Dimension(10, 14));
		lblBackDni.setBounds(363, 374, 290, 45);
		contentPane.add(lblBackDni);
		
		lblDni = new JLabel("DNI:");
		lblDni.setForeground(new Color(68, 68, 68));
		lblDni.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		lblDni.setBounds(363, 354, 264, 14);
		contentPane.add(lblDni);
		
		lblBackground = new JLabel("");
		lblBackground.setBackground(Color.WHITE);
		lblBackground.setBorder(new LineBorder(Constantes.lightgray, 2));
		lblBackground.setIcon(new ImageIcon(Register.class.getResource("/views/images/background-register.png")));
		lblBackground.setBounds(0, 0, 700, 534);
		contentPane.add(lblBackground);
		// Deshabilitar diseÒo por defecto del jframe
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		autogenerateCode();
		
	}
	
	private void autogenerateCode(){
		int lastCode = empleados.obtenerUltimoCodigo() + 1;
		String newCode = "EMP";
		if(Integer.toString(lastCode).length() == 1) newCode += "00" + lastCode;
		if(Integer.toString(lastCode).length() == 2) newCode += "0" + lastCode;
		if(Integer.toString(lastCode).length() == 3) newCode += "" + lastCode;
		txtCodigo.setText(newCode);
	}
	
	private String getCodigo(){
		return txtCodigo.getText();
	}
	
	private String getNombre(){
		return txtNombre.getText();
	}
	
	private String getApellidos(){
		return txtApellidos.getText();
	}
	
	private String getUsuario(){
		return txtUsuario.getText();
	}
	
	@SuppressWarnings("deprecation")
	private String getPassword(){
		return txtPassword.getText();
	}
	
	private int getCboCargo(){
		String cargo = getCargo();
		if(cargo.contentEquals("MÈdico"))
			return 1;
		else if(cargo.contentEquals("Enfermera(o)"))
			return 2;
		else if(cargo.contentEquals("Supervisor(a)"))
			return 3;
		else
			return 0;
	}
	
	private String getCargo(){
		return txtCargo.getText();
	}
	
	private int getDni(){
		return Integer.parseInt(txtDni.getText());
	}
	
	private int getTelefono(){
		return Integer.parseInt(txtTelefono.getText());
	}
	
	private String validarNombre(){
		String nombre = "";
		if(getNombre().matches("[a-zA-ZÒ—·ÈÌÛ˙¡…Õ”⁄\\s+]{3,25}"))
			nombre = getNombre();
		else {
			mensaje("Ingrese un nombre correcto por favor.\nEjemplo: \"Gonzalo\".");
			txtNombre.requestFocus();
			return null;
		}
		return nombre;
	}
	
	private String validarApellidos(){
		String apellidos = "";
		if(getApellidos().matches("[a-zA-ZÒ—·ÈÌÛ˙¡…Õ”⁄\\s+]{3,25}"))
			apellidos = getApellidos();
		else {
			mensaje("Ingrese los apellidos correctamente por favor.\nEjemplo: \"Rodriguez Salas\".");
			txtApellidos.requestFocus();
			return null;
		}
		return apellidos;
	}
	
	private int validarDni(){
		int dni = 0;
		if(!txtDni.getText().contentEquals("") && txtDni.getText().length() == 8)
			dni = getDni();
		else {
			mensaje("Ingrese correctamente el DNI.\nEjemplo: \"46587912\".");
			txtDni.requestFocus();
			return 0;
		}
		return dni;
	}
	
	private int validarTelefono(){
		int telefono = 0;
		if(!txtTelefono.getText().contentEquals("") && (txtTelefono.getText().length() == 7 || txtTelefono.getText().length() == 9))
			telefono = getTelefono();
		else {
			mensaje("Ingrese correctamente el n˙mero de telÈfono.\nEjemplo: \"56368957\" Û \"987654321\"\nSÛlo n˙meros, sin espacios ni guiones.");
			txtTelefono.requestFocus();
			return 0;
		}
		return telefono;
	}
	
	private String validarCargo(){
		String cargo = "Seleccionar --";
		if(!txtCargo.getText().contentEquals(cargo))
			cargo = getCargo();
		else {
			mensaje("Asegurese de haber escogido un cargo para el empleado.");
			txtCargo.requestFocus();
			return "Seleccionar --";
		}
		return cargo;
	}
	
	private String validarUsuario(){
		String usuario = "";
		if(getNombre().matches("[a-zA-ZÒ—·ÈÌÛ˙¡…Õ”⁄]{3,25}"))
			usuario = getUsuario();
		else {
			mensaje("Ingrese un usuario correcto por favor.\nEjemplo: \"Gonzalo\".\nSÛlo letras y n˙meros");
			txtUsuario.requestFocus();
			return null;
		}
		return usuario;
	}
	
	private String validarPassword(){
		String password = "";
		if(getPassword().matches("[a-zA-ZÒ—·ÈÌÛ˙¡…Õ”⁄1-9]{3,25}")){
			password = getPassword();
		}
		else {
			mensaje("Ingrese una contraseÒa correcta por favor.\nEjemplo: \"Gonzalo\".\nSÛlo letras y n˙meros");
			txtPassword.requestFocus();
			return null;
		}
		return password;
	}
	
	private void mensaje(String msg){
		JOptionPane.showMessageDialog(null, msg);
	}
	
}















