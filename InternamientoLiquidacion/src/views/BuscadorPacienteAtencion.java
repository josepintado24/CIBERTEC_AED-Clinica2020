package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import constantes.Constantes;
import controllers.InternamientoPacientesController;
import controllers.MantenimientoPacientesController;
import models.Internamiento;
import models.Paciente;

public class BuscadorPacienteAtencion extends JFrame {

	MantenimientoPacientesController paciente = new MantenimientoPacientesController("pacientes.txt");
	InternamientoPacientesController internamiento = new InternamientoPacientesController("internamiento.txt");
	
	private JPanel contentPane;
	private JLabel btnClose;
	private JLabel lblTitulo;
	private JTextPane txtDesc;
	private JSeparator separator;
	private JLabel label;
	private JTextField txtBuscarPor;
	private JLabel lblInputSeleccionar;
	private JLabel lblBuscarPor;
	private JTextField txtIngresar;
	private JLabel lblInputIngresar;
	private JLabel lblIngresar;
	private JLabel lblBuscar;
	private JLabel btnBuscar;
	private JTextField txtPaciente;
	private JLabel lblInputCodPaciente;
	private JLabel lblCodPaciente;
	private JLabel lblSeleccionar;
	private JLabel btnSeleccionar;
	private JTable tblTabla;
	private JScrollPane scrollPane;
	private JLabel lblBackground;
	private JPanel cboBuscarPor;
	private JLabel lblBackgroundCbo;
	private JLabel btnBuscarSeleccionar;
	private JLabel btnCodigo;
	private JLabel btnApellidos;
	private JLabel btnDni;
	private DefaultTableModel tabla;
	private JTable table;
	private JTextField textField;
	private JTextField txtNombre;
	private JTextField txtCodigo;
	private JTextField txtApellidos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscadorPacienteAtencion frame = new BuscadorPacienteAtencion();
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
	public BuscadorPacienteAtencion() {
		
		this.addWindowListener(new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {
//				MantenimientoPacientesController paciente = new MantenimientoPacientesController("pacientes.txt");
//				InternamientoPacientesController internamiento = new InternamientoPacientesController("internamiento.txt");
				listarPacientes();
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
			}
			@Override
			public void windowActivated(WindowEvent e) {
			}
		});
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cboBuscarPor = new JPanel();
		cboBuscarPor.setBounds(252, 153, 266, 150);
		cboBuscarPor.setVisible(false);
		contentPane.add(cboBuscarPor);
		cboBuscarPor.setLayout(null);
		
		btnBuscarSeleccionar = new JLabel("Seleccionar --");
		btnBuscarSeleccionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBuscarSeleccionar.setBackground(Constantes.hoverFont);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBuscarSeleccionar.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				txtBuscarPor.setText(btnBuscarSeleccionar.getText());
				cboBuscarPor.setVisible(false);
			}
		});
		btnBuscarSeleccionar.setOpaque(true);
		btnBuscarSeleccionar.setCursor(Constantes.pointer);
		btnBuscarSeleccionar.setForeground(new Color(68, 68, 68));
		btnBuscarSeleccionar.setFont(Constantes.regularFont);
		btnBuscarSeleccionar.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnBuscarSeleccionar.setBackground(Color.WHITE);
		btnBuscarSeleccionar.setBounds(1, 12, 264, 30);
		cboBuscarPor.add(btnBuscarSeleccionar);
		
		btnCodigo = new JLabel("C\u00F3digo de paciente");
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
				txtBuscarPor.setText(btnCodigo.getText());
				cboBuscarPor.setVisible(false);
				txtIngresar.setText("PAC");
				txtIngresar.requestFocus();
			}
		});
		btnCodigo.setOpaque(true);
		btnCodigo.setCursor(Constantes.pointer);
		btnCodigo.setForeground(new Color(68, 68, 68));
		btnCodigo.setFont(Constantes.regularFont);
		btnCodigo.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnCodigo.setBackground(Color.WHITE);
		btnCodigo.setBounds(1, 43, 264, 30);
		cboBuscarPor.add(btnCodigo);
		
		btnApellidos = new JLabel("Apellidos");
		btnApellidos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnApellidos.setBackground(Constantes.hoverFont);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnApellidos.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				txtBuscarPor.setText(btnApellidos.getText());
				cboBuscarPor.setVisible(false);
				txtIngresar.setText("");
			}
		});
		btnApellidos.setOpaque(true);
		btnApellidos.setCursor(Constantes.pointer);
		btnApellidos.setForeground(new Color(68, 68, 68));
		btnApellidos.setFont(Constantes.regularFont);
		btnApellidos.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnApellidos.setBackground(Color.WHITE);
		btnApellidos.setBounds(1, 74, 264, 30);
		cboBuscarPor.add(btnApellidos);
		
		btnDni = new JLabel("DNI");
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
				txtBuscarPor.setText(btnDni.getText());
				cboBuscarPor.setVisible(false);
				txtIngresar.setText("");
			}
		});
		btnDni.setOpaque(true);
		btnDni.setCursor(Constantes.pointer);
		btnDni.setForeground(new Color(68, 68, 68));
		btnDni.setFont(Constantes.regularFont);
		btnDni.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnDni.setBackground(Color.WHITE);
		btnDni.setBounds(1, 105, 264, 30);
		cboBuscarPor.add(btnDni);
		
		lblBackgroundCbo = new JLabel("");
		lblBackgroundCbo.setIcon(new ImageIcon(BuscadorPacienteAtencion.class.getResource("/views/images/combo-buscar-por-dos.png")));
		lblBackgroundCbo.setBounds(0, 0, 266, 150);
		cboBuscarPor.add(lblBackgroundCbo);
		
		textField = new JTextField();
		textField.setBounds(-104, 103, 251, 35);
		cboBuscarPor.add(textField);
		textField.setOpaque(false);
		textField.setForeground(new Color(68, 68, 68));
		textField.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		btnClose = new JLabel("");
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnClose.setIcon(new ImageIcon(BuscadorPacienteAtencion.class.getResource("/views/images/close-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnClose.setIcon(new ImageIcon(BuscadorPacienteAtencion.class.getResource("/views/images/close.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnClose.setIcon(new ImageIcon(BuscadorPacienteAtencion.class.getResource("/views/images/close.png")));
		btnClose.setBounds(624, 11, 16, 14);
		btnClose.setCursor(Constantes.pointer);
		contentPane.add(btnClose);
		
		lblTitulo = new JLabel("Buscador de Pacientes");
		lblTitulo.setForeground(new Color(59, 138, 191));
		lblTitulo.setFont(Constantes.boldFont);
		lblTitulo.setBounds(25, 40, 269, 26);
		contentPane.add(lblTitulo);
		
		txtDesc = new JTextPane();
		txtDesc.setBackground(Color.WHITE);
		txtDesc.setText("Aqu\u00ED podr\u00E1s obtener el listado de pacientes y realizar la selecci\u00F3n seg\u00FAn sea requerido.");
		txtDesc.setOpaque(false);
		txtDesc.setForeground(new Color(68, 68, 68));
		txtDesc.setFont(Constantes.regularFont);
		txtDesc.setEditable(false);
		txtDesc.setBounds(25, 69, 601, 21);
		contentPane.add(txtDesc);
		
		separator = new JSeparator();
		separator.setForeground(new Color(213, 213, 213));
		separator.setBounds(25, 102, 601, 2);
		contentPane.add(separator);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(BuscadorPacienteAtencion.class.getResource("/views/images/ico-down.png")));
		label.setBounds(497, 125, 10, 14);
		contentPane.add(label);
		
		txtBuscarPor = new JTextField();
		txtBuscarPor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(cboBuscarPor.isVisible()){
					cboBuscarPor.setVisible(false);
				}
				else{
					cboBuscarPor.setVisible(true);
				}
			}
		});
		txtBuscarPor.setEditable(false);
		txtBuscarPor.setText("Seleccionar --");
		txtBuscarPor.setOpaque(false);
		txtBuscarPor.setForeground(new Color(68, 68, 68));
		txtBuscarPor.setFont(Constantes.regularFont);
		txtBuscarPor.setDisabledTextColor(new Color(68, 68, 68));
		txtBuscarPor.setColumns(10);
		txtBuscarPor.setBorder(new EmptyBorder(0, 10, 0, 10));
		txtBuscarPor.setCursor(Constantes.pointer);
		txtBuscarPor.setBounds(252, 115, 266, 35);
		contentPane.add(txtBuscarPor);
		
		lblInputSeleccionar = new JLabel("");
		lblInputSeleccionar.setIcon(new ImageIcon(BuscadorPacienteAtencion.class.getResource("/views/images/text-ingresar.png")));
		lblInputSeleccionar.setBounds(252, 115, 266, 35);
		contentPane.add(lblInputSeleccionar);
		
		lblBuscarPor = new JLabel("Buscar por:");
		lblBuscarPor.setForeground(new Color(68, 68, 68));
		lblBuscarPor.setFont(Constantes.regularFont);
		lblBuscarPor.setBounds(25, 115, 70, 35);
		contentPane.add(lblBuscarPor);
		
		txtIngresar = new JTextField();
		txtIngresar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0){
				int cboSelect = cboBuscarPor();
				if(cboSelect == 0){
					mensaje("Asegurese de haber seleccionado un filtro e ingresado un tÈrmino de b˙squeda.");
				}
				else {
					if(cboSelect == 1){
						if(txtIngresar.getText().length() == 6){
							arg0.consume();
						}
					}
					if(cboSelect == 3){
						if(txtIngresar.getText().length() == 8){
							arg0.consume();
						}
					}
				}
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				int cboSelect = cboBuscarPor();
				if(cboSelect == 0){
					mensaje("Asegurese de haber seleccionado un filtro e ingresado un tÈrmino de b˙squeda.");
				}
				else {
					String term = getBusquedaCodigo();
					if(cboSelect == 1){
						return;
					}
					if(cboSelect == 2){
						if(term.matches("[a-zA-ZÒ—·ÈÌÛ˙¡…Õ”⁄\\s+]{0,25}") || term.matches("[a-zA-ZÒ—·ÈÌÛ˙¡…Õ”⁄+]{0,25}")){
							ArrayList<Paciente> buscarPaciente = paciente.listPacientesApellidos(term);
							if(buscarPaciente != null){
								tabla.setRowCount(0);
								for(int i = 0; i < buscarPaciente.size(); i++){
									Object[] data = {
										buscarPaciente.get(i).getCodPaciente(),
										buscarPaciente.get(i).getApellidos(),
										buscarPaciente.get(i).getNombres(),
										buscarPaciente.get(i).getTelefono(),
										buscarPaciente.get(i).getDni()
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
						if(term.matches("[0-9]+") || arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE){
							ArrayList<Paciente> buscarPaciente = paciente.listPacientesDni(term);
							if(buscarPaciente != null){
								tabla.setRowCount(0);
								for(int i = 0; i < buscarPaciente.size(); i++){
									Object[] data = {
										buscarPaciente.get(i).getCodPaciente(),
										buscarPaciente.get(i).getApellidos(),
										buscarPaciente.get(i).getNombres(),
										buscarPaciente.get(i).getTelefono(),
										buscarPaciente.get(i).getDni()
									};
									tabla.addRow(data);
								}
							}
							else {
								mensaje("No hay registros de pacientes con este DNI.");
							}
						}
						else {
							mensaje("El DNI no ha sido ingresado en un formato correcto.\nEjemplo: \"45216973\"");
						}
					}
				}
			}
		});
		txtIngresar.setOpaque(false);
		txtIngresar.setForeground(new Color(68, 68, 68));
		txtIngresar.setFont(Constantes.regularFont);
		txtIngresar.setColumns(10);
		txtIngresar.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtIngresar.setBounds(260, 161, 251, 35);
		contentPane.add(txtIngresar);
		
		lblInputIngresar = new JLabel("");
		lblInputIngresar.setIcon(new ImageIcon(BuscadorPacienteAtencion.class.getResource("/views/images/text-ingresar.png")));
		lblInputIngresar.setBounds(252, 161, 266, 35);
		contentPane.add(lblInputIngresar);
		
		lblIngresar = new JLabel("Ingrese dato seg\u00FAn su selecci\u00F3n:");
		lblIngresar.setForeground(new Color(68, 68, 68));
		lblIngresar.setFont(Constantes.regularFont);
		lblIngresar.setBounds(25, 161, 200, 35);
		contentPane.add(lblIngresar);
		
		lblBuscar = new JLabel("Buscar");
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(Constantes.regularFont);
		lblBuscar.setBounds(526, 161, 100, 35);
		lblBuscar.setCursor(Constantes.pointer);
		contentPane.add(lblBuscar);
		
		btnBuscar = new JLabel("");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBuscar.setIcon(new ImageIcon(BuscadorPacienteAtencion.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBuscar.setIcon(new ImageIcon(BuscadorPacienteAtencion.class.getResource("/views/images/btn-login.png")));
			}
			void mostrarDatos(Paciente data){
				txtPaciente.setText(data.getNombres() + " " + data.getApellidos());
				txtCodigo.setText(data.getCodPaciente());
				txtNombre.setText(data.getNombres());
				txtApellidos.setText(data.getApellidos());
			}
			public void mouseClicked(MouseEvent e) {
				if(btnBuscar.isEnabled()){
					int cboSelect = cboBuscarPor();
					if(getBusquedaCodigo().contentEquals("") || cboSelect == 0){
						mensaje("Asegurese de haber seleccionado un filtro e ingresado un tÈrmino de b˙squeda.");
					}
					else {
						String term = getBusquedaCodigo();
						if(cboSelect == 1){
							if(term.matches("PAC\\d{3}")){
								Paciente buscarPaciente = paciente.buscarPorCodigo(term);
								if(buscarPaciente != null){
									mostrarDatos(buscarPaciente);
								}
								else {
									mensaje("No hay registros de pacientes con este cÛdigo.");
								}
							}
							else {
								mensaje("El cÛdigo no ha sido ingresado en un formato correcto.\nEjemplo: \"PAC001\"");
							}
						}
						if(cboSelect == 2){
							if(term.matches("[a-zA-ZÒ—·ÈÌÛ˙¡…Õ”⁄\\s+]{3,25}") || term.matches("[a-zA-ZÒ—·ÈÌÛ˙¡…Õ”⁄+]{3,25}")){
								Paciente buscarPaciente = paciente.buscarPorApellido(term);
								if(buscarPaciente != null){
									mostrarDatos(buscarPaciente);
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
							if(term.matches("[0-9]{8}")){
								Paciente buscarPaciente = paciente.buscarPorDni(term);
								if(buscarPaciente != null){
									mostrarDatos(buscarPaciente);
								}
								else {
									mensaje("No hay registros de pacientes con este DNI.");
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
		btnBuscar.setIcon(new ImageIcon(BuscadorPacienteAtencion.class.getResource("/views/images/btn-login.png")));
		btnBuscar.setBounds(526, 161, 100, 35);
		contentPane.add(btnBuscar);
		
		txtPaciente = new JTextField();
		txtPaciente.setOpaque(false);
		txtPaciente.setForeground(new Color(68, 68, 68));
		txtPaciente.setFont(Constantes.regularFont);
		txtPaciente.setColumns(10);
		txtPaciente.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtPaciente.setBounds(260, 207, 251, 35);
		contentPane.add(txtPaciente);
		
		lblInputCodPaciente = new JLabel("");
		lblInputCodPaciente.setIcon(new ImageIcon(BuscadorPacienteAtencion.class.getResource("/views/images/text-ingresar.png")));
		lblInputCodPaciente.setBounds(252, 207, 266, 35);
		contentPane.add(lblInputCodPaciente);
		
		lblCodPaciente = new JLabel("Paciente seleccionado:");
		lblCodPaciente.setForeground(new Color(68, 68, 68));
		lblCodPaciente.setFont(Constantes.regularFont);
		lblCodPaciente.setBounds(25, 207, 217, 35);
		contentPane.add(lblCodPaciente);
		
		lblSeleccionar = new JLabel("Seleccionar");
		lblSeleccionar.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionar.setForeground(Color.WHITE);
		lblSeleccionar.setFont(Constantes.regularFont);
		lblSeleccionar.setBounds(526, 207, 100, 35);
		lblSeleccionar.setCursor(Constantes.pointer);
		contentPane.add(lblSeleccionar);
		
		btnSeleccionar = new JLabel("");
		btnSeleccionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSeleccionar.setIcon(new ImageIcon(BuscadorPacienteAtencion.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSeleccionar.setIcon(new ImageIcon(BuscadorPacienteAtencion.class.getResource("/views/images/btn-login.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(!txtPaciente.getText().contentEquals("")){
					String code = txtCodigo.getText();
					Internamiento internado = internamiento.buscarPorCodigoPaciente(code);
					if(internado == null){
						mensaje("El paciente seleccionado no se encuentra internado.");
					}
					else {
						sendCodPaciente();
						sendNombrePaciente();
						sendApellidoPaciente();
						dispose();
					}
				}
				else {
					mensaje("Asegurese de seleccionar un cÛdigo de paciente por favor.");
				}
			}
		});
		btnSeleccionar.setIcon(new ImageIcon(BuscadorPacienteAtencion.class.getResource("/views/images/btn-login.png")));
		btnSeleccionar.setBounds(526, 207, 100, 35);
		contentPane.add(btnSeleccionar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 264, 601, 163);
		contentPane.add(scrollPane);
		
		tblTabla = new JTable();
		scrollPane.setViewportView(tblTabla);
		
		table = new JTable();
		table.setForeground(Constantes.textgray);
		table.setFont(Constantes.regularFont);
		table.setRowHeight(30);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowIndex = table.getSelectedRow();
				String code = table.getValueAt(rowIndex, 0).toString();
				Paciente getPaciente = paciente.buscarPorCodigo(code);
				txtPaciente.setText(getPaciente.getNombres() + " " + getPaciente.getApellidos());
				txtCodigo.setText(getPaciente.getCodPaciente());
				txtNombre.setText(getPaciente.getNombres());
				txtApellidos.setText(getPaciente.getApellidos());
			}
		});
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		tabla = new DefaultTableModel();
		tabla.addColumn("CÛdigo");
		tabla.addColumn("Apellidos");
		tabla.addColumn("Nombre");
		tabla.addColumn("DNI");
		tabla.addColumn("TelÈfono");
		table.setModel(tabla);
		
		lblBackground = new JLabel("");
		lblBackground.setBorder(new LineBorder(Constantes.lightgray, 2));
		lblBackground.setIcon(new ImageIcon(BuscadorPacienteAtencion.class.getResource("/views/images/background-mantenimiento.png")));
		lblBackground.setBounds(0, 0, 650, 450);
		contentPane.add(lblBackground);
		
		txtCodigo = new JTextField();
		txtCodigo.setVisible(false);
		
		txtNombre = new JTextField();
		txtNombre.setVisible(false);
		txtNombre.setForeground(new Color(68, 68, 68));
		txtNombre.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		txtNombre.setColumns(10);
		txtNombre.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtNombre.setBounds(0, 0, 50, 35);
		contentPane.add(txtNombre);
		txtCodigo.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtCodigo.setBounds(53, 0, 65, 35);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtApellidos.setBounds(81, 0, 50, 35);
		txtApellidos.setVisible(false);
		contentPane.add(txtApellidos);
		txtApellidos.setColumns(10);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		listarPacientes();
	}
	
	private String getBusquedaCodigo(){
		return txtIngresar.getText();
	}

	private int cboBuscarPor(){
		String txtBuscar = txtBuscarPor.getText();
		if(txtBuscar.contentEquals("CÛdigo de paciente"))
			return 1;
		if(txtBuscar.contentEquals("Apellidos"))
			return 2;
		if(txtBuscar.contentEquals("DNI"))
			return 3;
		else
			return 0;
	}
	
	private void mensaje(String msg){
		JOptionPane.showMessageDialog(null, msg);
	}
	
	private void listarPacientes(){
		tabla.setRowCount(0);
		for(int i = 0; i < paciente.tamanio(); i++){
			Object[] data = {
				paciente.obtener(i).getCodPaciente(),
				paciente.obtener(i).getApellidos(),
				paciente.obtener(i).getNombres(),
				paciente.obtener(i).getDni(),
				paciente.obtener(i).getTelefono()
			};
			tabla.addRow(data);
		}
	}
	
	public String sendCodPaciente(){
		return txtCodigo.getText();
	}
	
	public String sendNombrePaciente(){
		return txtNombre.getText();
	}
	
	public String sendApellidoPaciente(){
		return txtApellidos.getText();
	}
	
}
