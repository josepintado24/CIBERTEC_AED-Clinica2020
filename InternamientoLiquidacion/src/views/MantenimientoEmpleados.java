package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import constantes.Constantes;
import controllers.MantenimientoEmpleadosController;
import models.Empleado;

public class MantenimientoEmpleados extends JFrame {

	MantenimientoEmpleadosController empleado = new MantenimientoEmpleadosController("empleados.txt");
	
	private JPanel contentPane;
	private JLabel lblBackground;
	private JLabel btnClose;
	private JTextPane txtDesc;
	private JSeparator separator;
	private JSeparator separatorMenu;
	private JLabel lblTitulo;
	private JLabel btnListar;
	private JLabel btnIngresar;
	private JLabel btnConsultar;
	private JLabel btnModificar;
	private JLabel btnEliminar;
	private JLabel lblInputBuscar;
	private JLabel lblBuscarPor;
	private JLabel lblInputIngresar;
	private JLabel lblIngresar;
	private JLabel btnBuscar;
	private JLabel lblBuscar;
	private JLabel lblAviso;
	private JLabel lblCodigo;
	private JLabel lblInputCodigo;
	private JLabel lblNombre;
	private JLabel lblInputNombre;
	private JLabel lblCargo;
	private JLabel lblInputCargo;
	private JTextField txtBuscar;
	private JTextField txtIngresar;
	private JTextField txtCodigo;
	private JTextField txtCargo;
	private JTextField txtNombre;
	private JTable table;
	private JScrollPane tblTabla;
	private DefaultTableModel tabla;
	private JScrollPane scrollPane;
	private JLabel arrowBuscarPor;
	private JLabel cboBackground;
	private JLabel btnSeleccionar;
	private JLabel btnCodigo;
	private JLabel btnEstado;
	private JPanel cboBuscarPor;
	private JLabel btnIngresarConfirm;
	private JLabel btnModificarConfirm;
	private JLabel btnEliminarConfirm;
	private JLabel lblIngresarConfirm;
	private JLabel lblModificarConfirm;
	private JLabel lblEliminarConfirm;
	private JPanel cboCargo;
	private JLabel cboEstadoBackground;
	private JLabel btnSeleccionarEstado;
	private JLabel btnMedico;
	private JLabel btnEnfermera;
	private JLabel label;
	private JLabel lblInputApellidos;
	private JTextField txtApellidos;
	private JLabel lblDni;
	private JTextField txtDni;
	private JLabel lblInputDni;
	private JLabel lblTelefono;
	private JTextField txtTelefono;
	private JLabel lblInputTelefono;
	private JLabel btnSupervisor;
	private JLabel btnDni;
	private JLabel lblUsuario;
	private JTextField txtUsuario;
	private JLabel lblInputUsuario;
	private JLabel lblContrasea;
	private JLabel lblInputPassword;
	private JPasswordField txtPassword;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantenimientoEmpleados frame = new MantenimientoEmpleados();
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
	public MantenimientoEmpleados() {
		setBackground(Color.WHITE);
		// Obtener el tamaÒo de la pantalla
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int ySize = ((int) toolkit.getScreenSize().getHeight());
		int xSize = ((int) toolkit.getScreenSize().getWidth());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, xSize-310, ySize-50);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnClose = new JLabel("");
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnClose.setIcon(new ImageIcon(MantenimientoEmpleados.class.getResource("/views/images/close-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnClose.setIcon(new ImageIcon(MantenimientoEmpleados.class.getResource("/views/images/close.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
		cboBuscarPor = new JPanel();
		cboBuscarPor.setVisible(false);
		
		cboCargo = new JPanel();
		cboCargo.setVisible(false);
		cboCargo.setBounds(682, 419, 349, 150);
		contentPane.add(cboCargo);
		cboCargo.setLayout(null);
		
		btnSeleccionarEstado = new JLabel("Seleccionar --");
		btnSeleccionarEstado.setOpaque(true);
		btnSeleccionarEstado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSeleccionarEstado.setBackground(Constantes.hoverFont);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSeleccionarEstado.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCargo.setText(btnSeleccionarEstado.getText());
				cboCargo.setVisible(false);
			}
		});
		btnSeleccionarEstado.setForeground(Constantes.textgray);
		btnSeleccionarEstado.setBackground(Color.WHITE);
		btnSeleccionarEstado.setCursor(Constantes.pointer);
		btnSeleccionarEstado.setFont(Constantes.regularFont);
		btnSeleccionarEstado.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnSeleccionarEstado.setBounds(1, 12, 347, 30);
		cboCargo.add(btnSeleccionarEstado);
		
		btnMedico = new JLabel("M\u00E9dico");
		btnMedico.setOpaque(true);
		btnMedico.setBackground(Color.WHITE);
		btnMedico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMedico.setBackground(Constantes.hoverFont);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnMedico.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCargo.setText(btnMedico.getText());
				cboCargo.setVisible(false);
			}
		});
		btnMedico.setForeground(Constantes.textgray);
		btnMedico.setCursor(Constantes.pointer);
		btnMedico.setFont(Constantes.regularFont);
		btnMedico.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnMedico.setBounds(1, 42, 347, 30);
		cboCargo.add(btnMedico);
		
		btnEnfermera = new JLabel("Enfermera(o)");
		btnEnfermera.setOpaque(true);
		btnEnfermera.setBackground(Color.WHITE);
		btnEnfermera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEnfermera.setBackground(Constantes.hoverFont);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEnfermera.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCargo.setText(btnEnfermera.getText());
				cboCargo.setVisible(false);
			}
		});
		btnEnfermera.setForeground(Constantes.textgray);
		btnEnfermera.setCursor(Constantes.pointer);
		btnEnfermera.setFont(Constantes.regularFont);
		btnEnfermera.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnEnfermera.setBounds(1, 73, 347, 30);
		cboCargo.add(btnEnfermera);
		
		btnSupervisor = new JLabel("Supervisor(a)");
		btnSupervisor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSupervisor.setBackground(Constantes.hoverFont);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSupervisor.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCargo.setText(btnSupervisor.getText());
				cboCargo.setVisible(false);
			}
		});
		btnSupervisor.setOpaque(true);
		btnSupervisor.setCursor(Constantes.pointer);
		btnSupervisor.setForeground(Constantes.textgray);
		btnSupervisor.setFont(Constantes.regularFont);
		btnSupervisor.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnSupervisor.setBackground(Color.WHITE);
		btnSupervisor.setBounds(1, 104, 347, 30);
		cboCargo.add(btnSupervisor);
		
		cboEstadoBackground = new JLabel("");
		cboEstadoBackground.setIcon(new ImageIcon(MantenimientoEmpleados.class.getResource("/views/images/contenedor-combo-estado.png")));
		cboEstadoBackground.setBounds(0, 0, 349, 150);
		cboCargo.add(cboEstadoBackground);
		cboBuscarPor.setBounds(127, 249, 200, 150);
		contentPane.add(cboBuscarPor);
		cboBuscarPor.setLayout(null);
		
		btnSeleccionar = new JLabel("Seleccionar --");
		btnSeleccionar.setOpaque(true);
		btnSeleccionar.setBackground(Color.WHITE);
		btnSeleccionar.setCursor(Constantes.pointer);
		btnSeleccionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSeleccionar.setBackground(Constantes.hoverFont);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSeleccionar.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				txtBuscar.setText(btnSeleccionar.getText());
				getCboBuscarPor();
				cboBuscarPor.setVisible(false);
			}
		});
		btnSeleccionar.setBounds(1, 11, 198, 30);
		cboBuscarPor.add(btnSeleccionar);
		btnSeleccionar.setFont(Constantes.regularFont);
		btnSeleccionar.setForeground(Constantes.textgray);
		btnSeleccionar.setBorder(new EmptyBorder(0, 10, 0, 10));
		
		btnCodigo = new JLabel("C\u00F3digo de empleado");
		btnCodigo.setBackground(Color.WHITE);
		btnCodigo.setCursor(Constantes.pointer);
		btnCodigo.setBounds(1, 41, 198, 30);
		btnCodigo.setOpaque(true);
		cboBuscarPor.add(btnCodigo);
		btnCodigo.setForeground(Constantes.textgray);
		btnCodigo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCodigo.setBackground(Constantes.hoverFont);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCodigo.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				txtBuscar.setText(btnCodigo.getText());
				cboBuscarPor.setVisible(false);
				getCboBuscarPor();
			}
		});
		btnCodigo.setFont(Constantes.regularFont);
		btnCodigo.setBorder(new EmptyBorder(0, 10, 0, 10));
		
		btnEstado = new JLabel("Apellidos");
		btnEstado.setBackground(Color.WHITE);
		btnEstado.setCursor(Constantes.pointer);
		btnEstado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEstado.setBackground(Constantes.hoverFont);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEstado.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				txtBuscar.setText(btnEstado.getText());
				cboBuscarPor.setVisible(false);
				getCboBuscarPor();
			}
		});
		btnEstado.setOpaque(true);
		btnEstado.setBounds(1, 72, 198, 30);
		cboBuscarPor.add(btnEstado);
		btnEstado.setForeground(Constantes.textgray);
		btnEstado.setFont(Constantes.regularFont);
		btnEstado.setBorder(new EmptyBorder(0, 10, 0, 10));
		
		btnDni = new JLabel("DNI");
		btnDni.setOpaque(true);
		btnDni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDni.setBackground(Constantes.hoverFont);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDni.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				txtBuscar.setText(btnDni.getText());
				cboBuscarPor.setVisible(false);
			}
		});
		btnDni.setForeground(Constantes.textgray);
		btnDni.setCursor(Constantes.pointer);
		btnDni.setFont(Constantes.regularFont);
		btnDni.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnDni.setBackground(Color.WHITE);
		btnDni.setBounds(1, 103, 198, 30);
		cboBuscarPor.add(btnDni);
		
		cboBackground = new JLabel("");
		cboBackground.setBorder(new EmptyBorder(0, 0, 0, 0));
		cboBackground.setBounds(0, 0, 200, 150);
		cboBuscarPor.add(cboBackground);
		cboBackground.setIcon(new ImageIcon(MantenimientoEmpleados.class.getResource("/views/images/contenedor-combo.png")));
		
		lblTitulo = new JLabel("Mantenimiento de Empleados");
		lblTitulo.setFont(Constantes.boldFont);
		lblTitulo.setForeground(Constantes.skyblue);
		lblTitulo.setBounds(25, 40, 269, 26);
		contentPane.add(lblTitulo);
		
		separatorMenu = new JSeparator();
		separatorMenu.setBorder(new LineBorder(Constantes.skyblue));
		separatorMenu.setBounds(25, 160, 1006, 2);
		contentPane.add(separatorMenu);
		
		separator = new JSeparator();
		separator.setBounds(25, 110, this.getWidth()-50, 2);
		separator.setForeground(Constantes.lightgray);
		contentPane.add(separator);
		
		txtDesc = new JTextPane();
		txtDesc.setOpaque(false);
		txtDesc.setFont(Constantes.regularFont);
		txtDesc.setText("En esta secci\u00F3n podr\u00E1s ingresar datos de empleados, actualizar y eliminar sus datos, adem\u00E1s de listar todos los registros de nuestra base de datos.");
		txtDesc.setBounds(25, 77, this.getWidth()-50, 22);
		txtDesc.setEditable(false);
		txtDesc.setForeground(Constantes.textgray);
		contentPane.add(txtDesc);
		
		btnClose.setIcon(new ImageIcon(MantenimientoEmpleados.class.getResource("/views/images/close.png")));
		btnClose.setBounds(this.getWidth()-25, 10, 16, 14);
		btnClose.setCursor(Constantes.pointer);
		contentPane.add(btnClose);
		
		lblBackground = new JLabel("Al ingresar, activamos la opc\u00F3n de listar por defecto.*");
		lblBackground.setBackground(Color.WHITE);
		lblBackground.setBorder(new LineBorder(Constantes.lightgray, 2));
		ImageIcon background = new ImageIcon(MantenimientoEmpleados.class.getResource("/views/images/background-mantenimiento.png"));
		ImageIcon backfinal = new ImageIcon(background.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
		
		btnListar = new JLabel("Listar");
		btnListar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnListar.setForeground(Constantes.skyblue);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnListar.setForeground(Constantes.textgray);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				changeOptionActive("Listar");
				txtBuscar.setEnabled(false);
				lblInputBuscar.setEnabled(false);
				lblInputIngresar.setEnabled(false);
				txtIngresar.setEditable(false);
				txtIngresar.setEnabled(false);
				btnBuscar.setEnabled(false);
				lblBuscar.setEnabled(false);
				
				lblInputCodigo.setEnabled(false);
				txtCodigo.setEditable(false);
				lblInputNombre.setEnabled(false);
				txtNombre.setEditable(false);
				lblInputApellidos.setEnabled(false);
				txtApellidos.setEditable(false);
				lblInputDni.setEnabled(false);
				txtDni.setEditable(false);
				lblInputTelefono.setEnabled(false);
				txtTelefono.setEditable(false);
				lblInputCargo.setEnabled(false);
				txtCargo.setEnabled(false);
				lblInputUsuario.setEnabled(false);
				txtUsuario.setEditable(false);
				lblInputPassword.setEnabled(false);
				txtPassword.setEditable(false);
				txtCargo.setCursor(Constantes.defaultCursor);
				
				txtCodigo.setText("");
				hideButtons();
				listarEmpleados();
			}
		});
		
		arrowBuscarPor = new JLabel("");
		arrowBuscarPor.setIcon(new ImageIcon(MantenimientoEmpleados.class.getResource("/views/images/ico-down.png")));
		arrowBuscarPor.setCursor(Constantes.pointer);
		arrowBuscarPor.setBounds(307, 222, 10, 14);
		
		contentPane.add(arrowBuscarPor);
		btnListar.setHorizontalAlignment(SwingConstants.CENTER);
		btnListar.setFont(Constantes.regularFont);
		btnListar.setForeground(Constantes.textgray);
		btnListar.setCursor(Constantes.pointer);
		btnListar.setBounds(121, 122, 64, 26);
		contentPane.add(btnListar);
		
		btnIngresar = new JLabel("Ingresar");
		btnIngresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIngresar.setForeground(Constantes.skyblue);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIngresar.setForeground(Constantes.textgray);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				changeOptionActive("Ingresar");
				resetFields();
				txtBuscar.setEnabled(false);
				lblInputBuscar.setEnabled(false);
				lblInputIngresar.setEnabled(false);
				txtIngresar.setEditable(false);
				txtIngresar.setEnabled(false);
				btnBuscar.setEnabled(false);
				lblBuscar.setEnabled(false);
				
				lblInputCodigo.setEnabled(false);
				txtCodigo.setEditable(false);
				lblInputNombre.setEnabled(true);
				txtNombre.setEditable(true);
				lblInputApellidos.setEnabled(true);
				txtApellidos.setEditable(true);
				lblInputDni.setEnabled(true);
				txtDni.setEditable(true);
				lblInputTelefono.setEnabled(true);
				txtTelefono.setEditable(true);
				lblInputCargo.setEnabled(true);
				txtCargo.setEnabled(true);
				lblInputUsuario.setEnabled(true);
				txtUsuario.setEditable(true);
				lblInputPassword.setEnabled(true);
				txtPassword.setEditable(true);
				txtCargo.setCursor(Constantes.pointer);
				
				hideButtons();
				lblIngresarConfirm.setVisible(true);
				btnIngresarConfirm.setVisible(true);
				
				autogenerateCode();
			}
		});
		btnIngresar.setHorizontalAlignment(SwingConstants.CENTER);
		btnIngresar.setFont(Constantes.regularFont);
		btnIngresar.setForeground(Constantes.textgray);
		btnIngresar.setBounds(307, 122, 64, 26);
		btnIngresar.setCursor(Constantes.pointer);
		contentPane.add(btnIngresar);
		
		btnConsultar = new JLabel("Consultar");
		btnConsultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnConsultar.setForeground(Constantes.skyblue);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnConsultar.setForeground(Constantes.textgray);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				changeOptionActive("Consultar");
				txtBuscar.setEnabled(true);
				lblInputBuscar.setEnabled(true);
				lblInputIngresar.setEnabled(true);
				txtIngresar.setEditable(true);
				txtIngresar.setEnabled(true);
				btnBuscar.setEnabled(true);
				lblBuscar.setEnabled(true);
				
				lblInputCodigo.setEnabled(false);
				txtCodigo.setEditable(false);
				lblInputNombre.setEnabled(false);
				txtNombre.setEditable(false);
				lblInputApellidos.setEnabled(false);
				txtApellidos.setEditable(false);
				lblInputDni.setEnabled(false);
				txtDni.setEditable(false);
				lblInputTelefono.setEnabled(false);
				txtTelefono.setEditable(false);
				lblInputCargo.setEnabled(false);
				txtCargo.setEnabled(false);
				lblInputUsuario.setEnabled(false);
				txtUsuario.setEditable(false);
				lblInputPassword.setEnabled(false);
				txtPassword.setEditable(false);
				txtCargo.setCursor(Constantes.defaultCursor);
				
				txtCodigo.setText("");
				hideButtons();
				
				resetFields();
			}
		});
		btnConsultar.setHorizontalAlignment(SwingConstants.CENTER);
		btnConsultar.setFont(Constantes.regularFont);
		btnConsultar.setForeground(Constantes.textgray);
		btnConsultar.setBounds(496, 122, 64, 26);
		btnConsultar.setCursor(Constantes.pointer);
		contentPane.add(btnConsultar);
		
		btnModificar = new JLabel("Modificar");
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnModificar.setForeground(Constantes.skyblue);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnModificar.setForeground(Constantes.textgray);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				changeOptionActive("Modificar");
				txtBuscar.setEnabled(true);
				lblInputBuscar.setEnabled(true);
				lblInputIngresar.setEnabled(true);
				txtIngresar.setEditable(true);
				txtIngresar.setEnabled(true);
				btnBuscar.setEnabled(true);
				lblBuscar.setEnabled(true);
				
				lblInputCodigo.setEnabled(false);
				txtCodigo.setEditable(false);
				lblInputNombre.setEnabled(true);
				txtNombre.setEditable(true);
				lblInputApellidos.setEnabled(true);
				txtApellidos.setEditable(true);
				lblInputDni.setEnabled(true);
				txtDni.setEditable(true);
				lblInputTelefono.setEnabled(true);
				txtTelefono.setEditable(true);
				lblInputCargo.setEnabled(true);
				txtCargo.setEnabled(true);
				lblInputUsuario.setEnabled(true);
				txtUsuario.setEditable(true);
				lblInputPassword.setEnabled(true);
				txtPassword.setEditable(true);
				txtCargo.setCursor(Constantes.pointer);
				
				hideButtons();
				lblModificarConfirm.setVisible(true);
				btnModificarConfirm.setVisible(true);
				
//				if(!txtEstado.getText().contentEquals("")){
//					String apellido = getApellidos();
//					Paciente modPaciente = paciente.buscarPorApellido(apellido);
//					txtNumero.setText(modPaciente.getCodPaciente());
//				}
//				else
//					txtNumero.setText("");
			}
		});
		btnModificar.setHorizontalAlignment(SwingConstants.CENTER);
		btnModificar.setFont(Constantes.regularFont);
		btnListar.setForeground(Constantes.textgray);
		btnModificar.setBounds(692, 122, 74, 26);
		btnModificar.setCursor(Constantes.pointer);
		contentPane.add(btnModificar);
		
		btnEliminar = new JLabel("Eliminar");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEliminar.setForeground(Constantes.skyblue);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEliminar.setForeground(Constantes.textgray);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				changeOptionActive("Eliminar");
				txtBuscar.setEnabled(true);
				lblInputBuscar.setEnabled(true);
				lblInputIngresar.setEnabled(true);
				txtIngresar.setEditable(true);
				txtIngresar.setEnabled(true);
				btnBuscar.setEnabled(true);
				lblBuscar.setEnabled(true);
				
				lblInputCodigo.setEnabled(false);
				txtCodigo.setEditable(false);
				lblInputNombre.setEnabled(false);
				txtNombre.setEditable(false);
				lblInputApellidos.setEnabled(false);
				txtApellidos.setEditable(false);
				lblInputDni.setEnabled(false);
				txtDni.setEditable(false);
				lblInputTelefono.setEnabled(false);
				txtTelefono.setEditable(false);
				lblInputCargo.setEnabled(false);
				txtCargo.setEnabled(false);
				lblInputUsuario.setEnabled(false);
				txtUsuario.setEditable(false);
				lblInputPassword.setEnabled(false);
				txtPassword.setEditable(false);
				txtCargo.setCursor(Constantes.defaultCursor);
				
				hideButtons();
				lblEliminarConfirm.setVisible(true);
				btnEliminarConfirm.setVisible(true);
			}
		});
		btnEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		btnEliminar.setFont(Constantes.regularFont);
		btnEliminar.setForeground(Constantes.textgray);
		btnEliminar.setBounds(864, 122, 74, 26);
		btnEliminar.setCursor(Constantes.pointer);
		contentPane.add(btnEliminar);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(MantenimientoEmpleados.class.getResource("/views/images/ico-down.png")));
		label.setBounds(1010, 391, 10, 14);
		contentPane.add(label);
		
		txtIngresar = new JTextField();
		txtIngresar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				int cboSelect = getCboBuscarPor();
				if(cboSelect == 0){
					mensaje("Asegurese de haber seleccionado un filtro e ingresado un tÈrmino de b˙squeda.");
				}
				else {
					if(cboSelect == 1){
						if(txtIngresar.getText().length() == 6){
							evt.consume();
						}
					}
					if(cboSelect == 3){
						if(txtIngresar.getText().length() == 8){
							evt.consume();
						}
					}
				}
			}
			@Override
			public void keyReleased(KeyEvent evt) {
				int cboSelect = getCboBuscarPor();
				if(cboSelect == 0){
					mensaje("Asegurese de haber seleccionado un filtro e ingresado un tÈrmino de b˙squeda.");
				}
				else {
					String term = getBusquedaCodigo();
					if(cboSelect == 1){
						
					}
					if(cboSelect == 2){
						if(term.matches("[a-zA-ZÒ—·ÈÌÛ˙¡…Õ”⁄\\s+]{0,25}") || term.matches("[a-zA-ZÒ—·ÈÌÛ˙¡…Õ”⁄+]{0,25}")){
							ArrayList<Empleado> buscarEmpleado = empleado.listEmpleadoApellido(term); 
							if(buscarEmpleado != null){
								tabla.setRowCount(0);
								for(int i = 0; i < buscarEmpleado.size(); i++){
									Object[] data = {
										buscarEmpleado.get(i).getCodEmpleado(),
										buscarEmpleado.get(i).getNombre(),
										buscarEmpleado.get(i).getApellidos(),
										buscarEmpleado.get(i).getDni(),
										buscarEmpleado.get(i).getTelefono(),
										buscarEmpleado.get(i).getCargo(),
										buscarEmpleado.get(i).getUser()
									};
									tabla.addRow(data);
								}
							}
							else {
								mensaje("No hay registros de pacientes con este apellido.");
							}
						}
						else {
							mensaje("El apellido no ha sido ingresado en un formato correcto.\nIngrese sÛlo letras.");
						}
					}
					if(cboSelect == 3){
						if(term.matches("\\d+") || evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
							ArrayList<Empleado> buscarEmpleado = empleado.listEmpleadoDni(term);
							if(buscarEmpleado != null){
								tabla.setRowCount(0);
								for(int i = 0; i < buscarEmpleado.size(); i++){
									Object[] data = {
										buscarEmpleado.get(i).getCodEmpleado(),
										buscarEmpleado.get(i).getNombre(),
										buscarEmpleado.get(i).getApellidos(),
										buscarEmpleado.get(i).getDni(),
										buscarEmpleado.get(i).getTelefono(),
										buscarEmpleado.get(i).getCargo(),
										buscarEmpleado.get(i).getUser()
									};
									tabla.addRow(data);
								}
							}
						}
					}
				}
			}
		});
		txtIngresar.setEnabled(false);
		txtIngresar.setEditable(false);
		txtIngresar.setOpaque(false);
		txtIngresar.setForeground(Constantes.textgray);
		txtIngresar.setFont(Constantes.regularFont);
		txtIngresar.setColumns(10);
		txtIngresar.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtIngresar.setBounds(663, 212, 251, 35);
		contentPane.add(txtIngresar);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setOpaque(false);
		txtNombre.setForeground(Constantes.textgray);
		txtNombre.setFont(Constantes.regularFont);
		txtNombre.setColumns(10);
		txtNombre.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtNombre.setBounds(691, 286, 329, 35);
		contentPane.add(txtNombre);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setOpaque(false);
		txtCodigo.setForeground(Constantes.textgray);
		txtCodigo.setFont(Constantes.regularFont);
		txtCodigo.setColumns(10);
		txtCodigo.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtCodigo.setBounds(137, 286, 329, 35);
		contentPane.add(txtCodigo);
		
		txtCargo = new JTextField();
		txtCargo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!txtCargo.isEnabled()){
					return;
				}
				else {
					if(cboCargo.isVisible()){
						cboCargo.setVisible(false);
					}
					else {
						cboCargo.setVisible(true);
					}
				}
			}
		});
		txtCargo.setText("Seleccionar --");
		txtCargo.setEditable(false);
		txtCargo.setOpaque(false);
		txtCargo.setEnabled(false);
		txtCargo.setDisabledTextColor(Constantes.textgray);
		txtCargo.setForeground(Constantes.textgray);
		txtCargo.setFont(Constantes.regularFont);
		txtCargo.setColumns(10);
		txtCargo.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtCargo.setBounds(692, 380, 329, 35);
		contentPane.add(txtCargo);
		
		txtBuscar = new JTextField();
		txtBuscar.setEnabled(false);
		txtBuscar.setDisabledTextColor(Constantes.textgray);
		txtBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(!txtBuscar.isEnabled()){
					return;
				}
				else {
					if(cboBuscarPor.isVisible()){
						cboBuscarPor.setVisible(false);
					}
					else {
						cboBuscarPor.setVisible(true);
					}
				}
			}
		});
		txtBuscar.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
			}
			@Override
			public void insertUpdate(DocumentEvent e) {
				int cboBuscar = getCboBuscarPor();
				if(cboBuscar == 1){
					txtIngresar.setText("EMP");
					txtIngresar.requestFocus();
				}
				else {
					txtIngresar.setText("");
				}
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});
		txtBuscar.setText("Seleccionar --");
		txtBuscar.setOpaque(false);
		txtBuscar.setBorder(new EmptyBorder(0, 10, 0, 10));
		txtBuscar.setBounds(127, 212, 200, 35);
		txtBuscar.setEditable(false);
		txtBuscar.setCursor(Constantes.pointer);
		txtBuscar.setFont(Constantes.regularFont);
		txtBuscar.setForeground(Constantes.textgray);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		lblInputBuscar = new JLabel("");
		lblInputBuscar.setEnabled(false);
		lblInputBuscar.setCursor(Constantes.pointer);
		lblInputBuscar.setIcon(new ImageIcon(MantenimientoEmpleados.class.getResource("/views/images/text-buscar.png")));
		lblInputBuscar.setBounds(127, 212, 200, 35);
		contentPane.add(lblInputBuscar);
		
		lblBuscarPor = new JLabel("Buscar por:");
		lblBuscarPor.setFont(Constantes.regularFont);
		lblBuscarPor.setForeground(Constantes.textgray);
		lblBuscarPor.setBounds(24, 212, 87, 35);
		contentPane.add(lblBuscarPor);
		
		lblInputIngresar = new JLabel("");
		lblInputIngresar.setEnabled(false);
		lblInputIngresar.setIcon(new ImageIcon(MantenimientoEmpleados.class.getResource("/views/images/text-ingresar.png")));
		lblInputIngresar.setBounds(655, 212, 266, 35);
		contentPane.add(lblInputIngresar);
		
		lblIngresar = new JLabel("Ingrese dato seg\u00FAn su selecci\u00F3n:");
		lblIngresar.setForeground(Constantes.textgray);
		lblIngresar.setFont(Constantes.regularFont);
		lblIngresar.setBounds(428, 212, 217, 35);
		contentPane.add(lblIngresar);
		
		lblBuscar = new JLabel("Buscar");
		lblBuscar.setEnabled(false);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(Constantes.regularFont);
		lblBuscar.setBounds(931, 212, 100, 35);
		lblBuscar.setCursor(Constantes.pointer);
		contentPane.add(lblBuscar);
		
		btnBuscar = new JLabel("");
		btnBuscar.setEnabled(false);
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBuscar.setIcon(new ImageIcon(MantenimientoEmpleados.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBuscar.setIcon(new ImageIcon(MantenimientoEmpleados.class.getResource("/views/images/btn-login.png")));
			}
			void mostrarDatos(Empleado data){
				txtCodigo.setText(data.getCodEmpleado());
				txtNombre.setText("" + data.getNombre());
				txtApellidos.setText(data.getApellidos());
				txtDni.setText("" + data.getDni());
				txtTelefono.setText("" + data.getTelefono());
				txtUsuario.setText(data.getUser());
				txtPassword.setText(data.getPassword());
				txtCargo.setText(data.getCargo());
				resetearBusqueda();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnBuscar.isEnabled()){
					int cboSelect = getCboBuscarPor();
					if(getBusquedaCodigo().contentEquals("") || cboSelect == 0){
						mensaje("Asegurese de haber seleccionado un filtro e ingresado un tÈrmino de b˙squeda.");
					}
					else {
						String term = getBusquedaCodigo();
						if(cboSelect == 1){
							if(term.matches("EMP\\d{3}")){
								Empleado buscarEmpleado = empleado.buscarPorCodigo(term);
								if(buscarEmpleado != null){
									mostrarDatos(buscarEmpleado);
								}
								else {
									mensaje("No hay registros de empleados con este cÛdigo.");
								}
							}
							else {
								mensaje("El cÛdigo no ha sido ingresado en un formato correcto.\nEjemplo: \"EMP001\"");
							}
						}
						if(cboSelect == 2){
							if(term.matches("[a-zA-ZÒ—·ÈÌÛ˙¡…Õ”⁄\\s+]{3,25}") || term.matches("[a-zA-ZÒ—·ÈÌÛ˙¡…Õ”⁄+]{3,25}")){
								Empleado buscarEmpleado = empleado.buscarPorApellido(term);
								if(buscarEmpleado != null){
									mostrarDatos(buscarEmpleado);
								}
								else {
									mensaje("No hay registros de empleados con este apellido.");
								}
							}
							else {
								mensaje("El apellido no ha sido ingresado en un formato correcto.\nIngrese sÛlo letras.");
							}
						}
						if(cboSelect == 3){
							if(term.matches("[0-9]{8}")){
								Empleado buscarEmpleado = empleado.buscarPorDni(term);
								if(buscarEmpleado != null){
									mostrarDatos(buscarEmpleado);
								}
								else {
									mensaje("No hay registros de empleados con este DNI.");
								}
							}
							else {
								mensaje("El DNI no ha sido ingresado en un formato correcto.\nEjemplo: \"45216973\"");
							}
						}
					}
				}
				else {
					return;
				}
			}
		});
		btnBuscar.setIcon(new ImageIcon(MantenimientoEmpleados.class.getResource("/views/images/btn-login.png")));
		btnBuscar.setCursor(Constantes.pointer);
		btnBuscar.setBounds(931, 212, 100, 35);
		contentPane.add(btnBuscar);
		
		lblAviso = new JLabel("* Opci\u00F3n activa: Listar");
		lblAviso.setHorizontalAlignment(SwingConstants.LEFT);
		lblAviso.setFont(Constantes.regularFont);
		lblAviso.setBounds(25, 167, 172, 26);
		lblAviso.setForeground(Constantes.skyblue);
		contentPane.add(lblAviso);
		
		lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setForeground(Constantes.textgray);
		lblCodigo.setFont(Constantes.regularFont);
		lblCodigo.setBounds(25, 286, 87, 35);
		contentPane.add(lblCodigo);
		
		lblInputCodigo = new JLabel("");
		lblInputCodigo.setEnabled(false);
		lblInputCodigo.setIcon(new ImageIcon(MantenimientoEmpleados.class.getResource("/views/images/input-text-mantenimiento.png")));
		lblInputCodigo.setBounds(127, 286, 349, 35);
		contentPane.add(lblInputCodigo);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Constantes.textgray);
		lblNombre.setFont(Constantes.regularFont);
		lblNombre.setBounds(580, 286, 87, 35);
		contentPane.add(lblNombre);
		
		lblInputNombre = new JLabel("");
		lblInputNombre.setEnabled(false);
		lblInputNombre.setIcon(new ImageIcon(MantenimientoEmpleados.class.getResource("/views/images/input-text-mantenimiento.png")));
		lblInputNombre.setBounds(682, 286, 349, 35);
		contentPane.add(lblInputNombre);
		
		lblCargo = new JLabel("Cargo:");
		lblCargo.setForeground(Constantes.textgray);
		lblCargo.setFont(Constantes.regularFont);
		lblCargo.setBounds(580, 380, 87, 35);
		contentPane.add(lblCargo);
		
		lblInputCargo = new JLabel("");
		lblInputCargo.setEnabled(false);
		lblInputCargo.setCursor(Constantes.pointer);
		lblInputCargo.setIcon(new ImageIcon(MantenimientoEmpleados.class.getResource("/views/images/input-text-mantenimiento.png")));
		lblInputCargo.setBounds(682, 380, 349, 35);
		contentPane.add(lblInputCargo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 490, 1006, 202);
		contentPane.add(scrollPane);
		
		tblTabla = new JScrollPane();
		scrollPane.setViewportView(tblTabla);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent evt){
				int rowIndex = table.getSelectedRow();
				String code = table.getValueAt(rowIndex, 0).toString();
				Empleado getEmpleado = empleado.buscarPorCodigo(code);
				txtCodigo.setText(getEmpleado.getCodEmpleado());
				txtNombre.setText(getEmpleado.getNombre());
				txtApellidos.setText(getEmpleado.getApellidos());
				txtDni.setText("" + getEmpleado.getDni());
				txtTelefono.setText("" + getEmpleado.getTelefono());
				txtCargo.setText(getEmpleado.getCargo());
				txtUsuario.setText(getEmpleado.getUser());
				txtPassword.setText(getEmpleado.getPassword());
			}
		});
		table.setForeground(Constantes.textgray);
		table.setFont(Constantes.regularFont);
		table.setRowHeight(30);
		table.setFillsViewportHeight(true);
		tblTabla.setViewportView(table);
		
		tabla = new DefaultTableModel();
		tabla.addColumn("CÛdigo de empleado");
		tabla.addColumn("Nombre");
		tabla.addColumn("Apellidos");
		tabla.addColumn("DNI");
		tabla.addColumn("TelÈfono");
		tabla.addColumn("Cargo");
		tabla.addColumn("Usuario");
		table.setModel(tabla);
		
		lblIngresarConfirm = new JLabel("Ingresar");
		lblIngresarConfirm.setFont(Constantes.regularFont);
		lblIngresarConfirm.setCursor(Constantes.pointer);
		lblIngresarConfirm.setForeground(Color.WHITE);
		lblIngresarConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresarConfirm.setBounds(931, 428, 100, 34);
		lblIngresarConfirm.setVisible(false);
		contentPane.add(lblIngresarConfirm);
		
		btnIngresarConfirm = new JLabel("");
		btnIngresarConfirm.setVisible(false);
		btnIngresarConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIngresarConfirm.setIcon(new ImageIcon(MantenimientoEmpleados.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIngresarConfirm.setIcon(new ImageIcon(MantenimientoEmpleados.class.getResource("/views/images/btn-login.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String nombre = validarNombre();
					if(nombre == null) return;
					
					String apellidos = validarApellidos();
					if(apellidos == null) return;
					
					int dni = validarDni();
					if(dni == 0) return;
					
					int telefono = validarTelefono();
					if(telefono == 0) return;
					
					String cargo = validarCargo();
					if(cargo == "Seleccionar --") return;
					
					String usuario = validarUsuario();
					if(usuario == null) return;
					
					String password = validarPassword();
					if(password == null) return;
					
					int option = JOptionPane.showConfirmDialog(null, "øEst· seguro de ingresar los registros de un nuevo empleado?", "Confirmar ingreso de datos", JOptionPane.OK_CANCEL_OPTION);
					if(option == 0){
						Empleado newEmpleado = new Empleado(txtCodigo.getText(), nombre, apellidos, dni, telefono, cargo, usuario, password);
						empleado.adicionar(newEmpleado);
						empleado.agregarEmpleado();
						
						mensaje("Los nuevos registros han sido grabados correctamente.");
						listarEmpleados();
						resetFields();
						txtNombre.requestFocus();
						autogenerateCode();
					}
				}
				catch(Exception er){
					mensaje("Hubo un error en el ingreso de datos.");
					System.out.println(er);
				}
			}
		});
		btnIngresarConfirm.setIcon(new ImageIcon(MantenimientoEmpleados.class.getResource("/views/images/btn-login.png")));
		btnIngresarConfirm.setBounds(931, 427, 100, 35);
		contentPane.add(btnIngresarConfirm);
		
		lblModificarConfirm = new JLabel("Modificar");
		lblModificarConfirm.setFont(Constantes.regularFont);
		lblModificarConfirm.setCursor(Constantes.pointer);
		lblModificarConfirm.setForeground(Color.WHITE);
		lblModificarConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificarConfirm.setBounds(931, 428, 100, 34);
		lblModificarConfirm.setVisible(false);
		contentPane.add(lblModificarConfirm);
		
		btnModificarConfirm = new JLabel("");
		btnModificarConfirm.setVisible(false);
		btnModificarConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIngresarConfirm.setIcon(new ImageIcon(MantenimientoEmpleados.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIngresarConfirm.setIcon(new ImageIcon(MantenimientoEmpleados.class.getResource("/views/images/btn-login.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String nombre = validarNombre();
					if(nombre == null) return;
					
					String apellidos = validarApellidos();
					if(apellidos == null) return;
					
					int dni = validarDni();
					if(dni == 0) return;
					
					int telefono = validarTelefono();
					if(telefono == 0) return;
					
					String cargo = validarCargo();
					if(cargo == null) return;
					
					String usuario = validarUsuario();
					if(usuario == null) return;
					
					String password = validarPassword();
					if(password == null) return;
					
					int option = JOptionPane.showConfirmDialog(null, "øEst· seguro de modificar los registros de este empleado?", "Confirmar modificaciÛn", JOptionPane.OK_CANCEL_OPTION);
					if(option == 0){
						String codigo = txtCodigo.getText();
						Empleado modEmpleado = empleado.buscarPorCodigo(codigo);
						modEmpleado.setApellidos(apellidos);
						modEmpleado.setNombre(nombre);
						modEmpleado.setTelefono(telefono);
						modEmpleado.setDni(dni);
						modEmpleado.setCargo(cargo);
						modEmpleado.setUser(usuario);
						modEmpleado.setPassword(password);
						
						mensaje("Los registros de este paciente han sido actualizados correctamente.");
						empleado.agregarEmpleado();
						listarEmpleados();
						resetFields();
					}
				}
				catch(Exception er){
					mensaje("Hubo un error en el ingreso de datos.");
				}
			}
		});
		btnModificarConfirm.setIcon(new ImageIcon(MantenimientoEmpleados.class.getResource("/views/images/btn-login.png")));
		btnModificarConfirm.setBounds(931, 427, 100, 35);
		contentPane.add(btnModificarConfirm);
		
		lblEliminarConfirm = new JLabel("Eliminar");
		lblEliminarConfirm.setFont(Constantes.regularFont);
		lblEliminarConfirm.setCursor(Constantes.pointer);
		lblEliminarConfirm.setForeground(Color.WHITE);
		lblEliminarConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarConfirm.setBounds(931, 428, 100, 34);
		lblEliminarConfirm.setVisible(false);
		contentPane.add(lblEliminarConfirm);
		
		btnEliminarConfirm = new JLabel("");
		btnEliminarConfirm.setVisible(false);
		btnEliminarConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIngresarConfirm.setIcon(new ImageIcon(MantenimientoEmpleados.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIngresarConfirm.setIcon(new ImageIcon(MantenimientoEmpleados.class.getResource("/views/images/btn-login.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				String codigo = txtCodigo.getText();
				Empleado dropEmpleado = empleado.buscarPorCodigo(codigo);
				if(dropEmpleado != null){
					int option = JOptionPane.showConfirmDialog(null, "øEst· seguro de eliminar los registros de este empleado?", "Confirmar eliminaciÛn", JOptionPane.OK_CANCEL_OPTION);
					if(option == 0){
						empleado.eliminarEmpleado(dropEmpleado);
						empleado.agregarEmpleado();
						listarEmpleados();
						resetFields();
						mensaje("Los registros de este paciente han sido eliminados correctamente.");
					}
				}
				else {
					mensaje("No has ingresado pacientes para eliminar.");
				}
			}
		});
		btnEliminarConfirm.setIcon(new ImageIcon(MantenimientoEmpleados.class.getResource("/views/images/btn-login.png")));
		btnEliminarConfirm.setBounds(931, 427, 100, 35);
		contentPane.add(btnEliminarConfirm);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setForeground(Constantes.textgray);
		lblApellidos.setFont(Constantes.regularFont);
		lblApellidos.setBounds(25, 333, 87, 35);
		contentPane.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setOpaque(false);
		txtApellidos.setForeground(Constantes.textgray);
		txtApellidos.setFont(Constantes.regularFont);
		txtApellidos.setEditable(false);
		txtApellidos.setColumns(10);
		txtApellidos.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtApellidos.setBounds(137, 333, 329, 35);
		contentPane.add(txtApellidos);
		
		lblInputApellidos = new JLabel("");
		lblInputApellidos.setIcon(new ImageIcon(MantenimientoEmpleados.class.getResource("/views/images/input-text-mantenimiento.png")));
		lblInputApellidos.setEnabled(false);
		lblInputApellidos.setBounds(127, 333, 349, 35);
		contentPane.add(lblInputApellidos);
		
		lblDni = new JLabel("DNI:");
		lblDni.setForeground(Constantes.textgray);
		lblDni.setFont(Constantes.regularFont);
		lblDni.setBounds(580, 333, 87, 35);
		contentPane.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.addKeyListener(new KeyAdapter(){
			@Override
			public void keyTyped(KeyEvent evt){
				if(txtDni.getText().length() == 8) evt.consume();
			}
		});
		txtDni.setOpaque(false);
		txtDni.setForeground(Constantes.textgray);
		txtDni.setFont(Constantes.regularFont);
		txtDni.setEditable(false);
		txtDni.setColumns(10);
		txtDni.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtDni.setBounds(691, 333, 329, 35);
		contentPane.add(txtDni);
		
		lblInputDni = new JLabel("");
		lblInputDni.setIcon(new ImageIcon(MantenimientoEmpleados.class.getResource("/views/images/input-text-mantenimiento.png")));
		lblInputDni.setEnabled(false);
		lblInputDni.setBounds(682, 333, 349, 35);
		contentPane.add(lblInputDni);
		
		lblTelefono = new JLabel("Telefono:");
		lblTelefono.setForeground(Constantes.textgray);
		lblTelefono.setFont(Constantes.regularFont);
		lblTelefono.setBounds(25, 380, 87, 35);
		contentPane.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.addKeyListener(new KeyAdapter(){
			@Override
			public void keyTyped(KeyEvent evt){
				if(txtTelefono.getText().length() == 9) evt.consume();
			}
		});
		txtTelefono.setOpaque(false);
		txtTelefono.setForeground(Constantes.textgray);
		txtTelefono.setFont(Constantes.regularFont);
		txtTelefono.setEditable(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtTelefono.setBounds(136, 380, 329, 35);
		contentPane.add(txtTelefono);
		
		lblInputTelefono = new JLabel("");
		lblInputTelefono.setIcon(new ImageIcon(MantenimientoEmpleados.class.getResource("/views/images/input-text-mantenimiento.png")));
		lblInputTelefono.setEnabled(false);
		lblInputTelefono.setBounds(127, 380, 349, 35);
		contentPane.add(lblInputTelefono);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(Constantes.textgray);
		lblUsuario.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		lblUsuario.setBounds(25, 428, 87, 35);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setOpaque(false);
		txtUsuario.setForeground(Constantes.textgray);
		txtUsuario.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		txtUsuario.setEditable(false);
		txtUsuario.setColumns(10);
		txtUsuario.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtUsuario.setBounds(136, 428, 184, 35);
		contentPane.add(txtUsuario);
		
		lblInputUsuario = new JLabel("");
		lblInputUsuario.setIcon(new ImageIcon(MantenimientoEmpleados.class.getResource("/views/images/text-buscar.png")));
		lblInputUsuario.setEnabled(false);
		lblInputUsuario.setBounds(127, 428, 200, 35);
		contentPane.add(lblInputUsuario);
		
		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setForeground(Constantes.textgray);
		lblContrasea.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		lblContrasea.setBounds(404, 427, 87, 35);
		contentPane.add(lblContrasea);
		
		txtPassword = new JPasswordField();
		txtPassword.setOpaque(false);
		txtPassword.setEditable(false);
		txtPassword.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtPassword.setBounds(516, 428, 184, 34);
		contentPane.add(txtPassword);
		
		lblInputPassword = new JLabel("");
		lblInputPassword.setIcon(new ImageIcon(MantenimientoEmpleados.class.getResource("/views/images/text-buscar.png")));
		lblInputPassword.setEnabled(false);
		lblInputPassword.setBounds(506, 427, 200, 35);
		contentPane.add(lblInputPassword);
		
		lblBackground.setIcon(backfinal);
		lblBackground.setBounds(0, 0, xSize-310, ySize-50);
		contentPane.add(lblBackground);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		//Ubicar la barra de men˙ en la parte superior izquierda de la pantalla
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX() - this.getWidth();
        int y = (int) rect.getMinY();
        setLocation(x, y);
        setVisible(true);
        
//        paciente.cargarPacientes();
        listarEmpleados();
	}
	
	private int getCboBuscarPor(){
		String cboSelect = txtBuscar.getText();
		if(cboSelect.contentEquals("CÛdigo de empleado"))
			return 1;
		else if(cboSelect.contentEquals("Apellidos"))
			return 2;
		else if(cboSelect.contentEquals("DNI"))
			return 3;
		else if(cboSelect.contentEquals("Cargo"))
			return 4;
		else
			return 0;
	}
	
	String getNombre(){
		return txtNombre.getText();
	}
	
	String getApellidos(){
		return txtApellidos.getText();
	}
	
	int getDni(){
		return Integer.parseInt(txtDni.getText());
	}
	
	int getTelefono(){
		return Integer.parseInt(txtTelefono.getText());
	}
	
	String getCargo(){
		return txtCargo.getText();
	}
	
	String getUsuario(){
		return txtUsuario.getText();
	}
	
	@SuppressWarnings("deprecation")
	String getPassword(){
		return txtPassword.getText();
	}
	
	private void listarEmpleados(){
		tabla.setRowCount(0);
		for(int i = 0; i < empleado.tamanio(); i++){
			Object[] data = {
				empleado.obtener(i).getCodEmpleado(),
				empleado.obtener(i).getNombre(),
				empleado.obtener(i).getApellidos(),
				empleado.obtener(i).getDni(),
				empleado.obtener(i).getTelefono(),
				empleado.obtener(i).getCargo(),
				empleado.obtener(i).getUser()
			};
			tabla.addRow(data);
		}
	}
	
	private void mensaje(String msg){
		JOptionPane.showMessageDialog(null, msg);
	}
	
	private String getBusquedaCodigo(){
		return txtIngresar.getText();
	}
	
	private void resetearBusqueda(){
		txtBuscar.setText("Seleccionar --");
		txtIngresar.setText("");
	}
	
	private void resetFields(){
		txtBuscar.setText("Seleccionar --");
		txtIngresar.setText("");
		txtCodigo.setText("");
		txtNombre.setText("");
		txtApellidos.setText("");
		txtTelefono.setText("");
		txtDni.setText("");
		txtUsuario.setText("");
		txtPassword.setText("");
		txtCargo.setText("Seleccionar --");
	}
	
	private void changeOptionActive(String optionActive){
		String text = lblAviso.getText().split(":")[0];
		lblAviso.setText(text + ": " + optionActive);
	}
	
	private void hideButtons(){
		lblIngresarConfirm.setVisible(false);
		btnIngresarConfirm.setVisible(false);
		lblModificarConfirm.setVisible(false);
		btnModificarConfirm.setVisible(false);
		lblEliminarConfirm.setVisible(false);
		btnEliminarConfirm.setVisible(false);
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
			mensaje("Asegurese de haber escodigo un cargo para el empleado.");
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
	
	private void autogenerateCode(){
		int lastCode = empleado.obtenerUltimoCodigo() + 1;
		String newCode = "EMP";
		if(Integer.toString(lastCode).length() == 1) newCode += "00" + lastCode;
		if(Integer.toString(lastCode).length() == 2) newCode += "0" + lastCode;
		if(Integer.toString(lastCode).length() == 3) newCode += "" + lastCode;
		txtCodigo.setText(newCode);
	}
}
