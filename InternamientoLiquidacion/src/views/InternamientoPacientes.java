package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import constantes.Constantes;
import controllers.InternamientoPacientesController;
import models.Internamiento;

public class InternamientoPacientes extends JFrame {

	Constantes constantes = new Constantes();
	InternamientoPacientesController internamiento = new InternamientoPacientesController("internamiento.txt");
	BuscadorPaciente buscadorPaciente = new BuscadorPaciente();
	BuscadorCama buscadorCama = new BuscadorCama();
	
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
	private JLabel btnEliminar;
	private JLabel lblInputBuscar;
	private JLabel lblBuscarPor;
	private JLabel lblInputIngresar;
	private JLabel lblIngresar;
	private JLabel btnBuscar;
	private JLabel lblBuscar;
	private JLabel lblAviso;
	private JLabel lblCodInternamiento;
	private JLabel lblCodPaciente;
	private JLabel lblNombre;
	private JLabel lblInputNombre;
	private JLabel lblFechaIngreso;
	private JTextField txtBuscar;
	private JTextField txtIngresar;
	private JTable table;
	private JScrollPane tblTabla;
	private DefaultTableModel tabla;
	private JScrollPane scrollPane;
	private JLabel arrowBuscarPor;
	private JLabel cboBackground;
	private JLabel btnSeleccionar;
	private JLabel btnCodigoInt;
	private JLabel btnCodPaciente;
	private JLabel lblCodCama;
	private JLabel lblInputCodCama;
	private JLabel btnCodigoCama;
	private JPanel cboBuscarPor;
	private JLabel btnIngresarConfirm;
	private JLabel btnEliminarConfirm;
	private JLabel lblIngresarConfirm;
	private JLabel lblEliminarConfirm;
	private JTextField txtCodInternamiento;
	private JLabel lblInputCodInternamiento;
	private JTextField txtCodPaciente;
	private JTextField txtNombre;
	private JTextField txtCodCama;
	private JTextField txtFechaIngreso;
	private JTextField txtHoraIngreso;
	private JTextField txtFechaSalida;
	private JTextField txtHoraSalida;
	private JTextField txtEstado;
	private JLabel lblInputCodPaciente;
	private JLabel lblSelectCodPaciente;
	private JLabel btnSelectCodPaciente;
	private JLabel lblSelectCodCama;
	private JLabel btnSelectCodCama;
	private JLabel lblHoraIngreso;
	private JLabel lblInputFecIngreso;
	private JLabel lblInputHoraIngreso;
	private JLabel lblFechaSalida;
	private JLabel lblHoraSalida;
	private JLabel lblInputFecSalida;
	private JLabel lblInputHoraSalida;
	private JLabel lblEstado;
	private JLabel lblInputSeleccionarEstado;
	private Date date;

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
					InternamientoPacientes frame = new InternamientoPacientes();
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
	public InternamientoPacientes() {
		buscadorPaciente.setVisible(false);
		buscadorCama.setVisible(false);
		setBackground(Color.WHITE);
		// Obtener el tamaño de la pantalla
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
				btnClose.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/close-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnClose.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/close.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
		cboBuscarPor = new JPanel();
		cboBuscarPor.setVisible(false);
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
		
		btnCodigoInt = new JLabel("C\u00F3digo de internamiento");
		btnCodigoInt.setBackground(Color.WHITE);
		btnCodigoInt.setCursor(Constantes.pointer);
		btnCodigoInt.setBounds(1, 41, 198, 30);
		btnCodigoInt.setOpaque(true);
		cboBuscarPor.add(btnCodigoInt);
		btnCodigoInt.setForeground(new Color(68, 68, 68));
		btnCodigoInt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCodigoInt.setBackground(Constantes.hoverFont);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCodigoInt.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				txtBuscar.setText(btnCodigoInt.getText());
				cboBuscarPor.setVisible(false);
				txtIngresar.setText("INT");
				txtIngresar.requestFocus();
				getCboBuscarPor();
			}
		});
		btnCodigoInt.setFont(Constantes.regularFont);
		btnCodigoInt.setBorder(new EmptyBorder(0, 10, 0, 10));
		
		btnCodPaciente = new JLabel("C\u00F3digo de paciente");
		btnCodPaciente.setBackground(Color.WHITE);
		btnCodPaciente.setCursor(Constantes.pointer);
		btnCodPaciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCodPaciente.setBackground(Constantes.hoverFont);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCodPaciente.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				txtBuscar.setText(btnCodPaciente.getText());
				cboBuscarPor.setVisible(false);
				txtIngresar.setText("PAC");
				txtIngresar.requestFocus();
				getCboBuscarPor();
			}
		});
		btnCodPaciente.setOpaque(true);
		btnCodPaciente.setBounds(1, 72, 198, 30);
		cboBuscarPor.add(btnCodPaciente);
		btnCodPaciente.setForeground(new Color(68, 68, 68));
		btnCodPaciente.setFont(Constantes.regularFont);
		btnCodPaciente.setBorder(new EmptyBorder(0, 10, 0, 10));
		
		btnCodigoCama = new JLabel("C\u00F3digo de cama");
		btnCodigoCama.setBackground(Color.WHITE);
		btnCodigoCama.setOpaque(true);
		btnCodigoCama.setBounds(1, 104, 198, 30);
		cboBuscarPor.add(btnCodigoCama);
		btnCodigoCama.setForeground(new Color(68, 68, 68));
		btnCodigoCama.setCursor(Constantes.pointer);
		btnCodigoCama.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCodigoCama.setBackground(Constantes.hoverFont);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCodigoCama.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				txtBuscar.setText(btnCodigoCama.getText());
				cboBuscarPor.setVisible(false);
				txtIngresar.setText("CAM");
				txtIngresar.requestFocus();
				getCboBuscarPor();
			}
		});
		btnCodigoCama.setFont(Constantes.regularFont);
		btnCodigoCama.setBorder(new EmptyBorder(0, 10, 0, 10));
		
		cboBackground = new JLabel("");
		cboBackground.setBorder(new EmptyBorder(0, 0, 0, 0));
		cboBackground.setBounds(0, 0, 200, 150);
		cboBuscarPor.add(cboBackground);
		cboBackground.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/contenedor-combo.png")));
		
		txtCodInternamiento = new JTextField();
		txtCodInternamiento.setOpaque(false);
		txtCodInternamiento.setForeground(new Color(68, 68, 68));
		txtCodInternamiento.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		txtCodInternamiento.setEditable(false);
		txtCodInternamiento.setColumns(10);
		txtCodInternamiento.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtCodInternamiento.setBounds(135, 286, 358, 35);
		contentPane.add(txtCodInternamiento);
		
		lblInputCodInternamiento = new JLabel("");
		lblInputCodInternamiento.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/input-text-large.png")));
		lblInputCodInternamiento.setEnabled(false);
		lblInputCodInternamiento.setBounds(127, 286, 376, 35);
		contentPane.add(lblInputCodInternamiento);
		
		lblTitulo = new JLabel("Internamiento de Pacientes");
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
		txtDesc.setText("En esta secci\u00F3n podr\u00E1s generar los datos necesarios para el internamiento de un paciente y registrarlo en nuestra base de datos.");
		txtDesc.setBounds(25, 77, this.getWidth()-50, 22);
		txtDesc.setEditable(false);
		txtDesc.setForeground(Constantes.textgray);
		contentPane.add(txtDesc);
		
		btnClose.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/close.png")));
		btnClose.setBounds(this.getWidth()-25, 10, 16, 14);
		btnClose.setCursor(Constantes.pointer);
		contentPane.add(btnClose);
		
		lblBackground = new JLabel("Al ingresar, activamos la opc\u00F3n de listar por defecto.*");
		lblBackground.setBackground(Color.WHITE);
		lblBackground.setBorder(new LineBorder(Constantes.lightgray, 2));
		ImageIcon background = new ImageIcon(InternamientoPacientes.class.getResource("/views/images/background-mantenimiento.png"));
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
//				btnListar.setForeground(Constantes.skyblue);
				txtBuscar.setEnabled(false);
				lblInputBuscar.setEnabled(false);
				lblInputIngresar.setEnabled(false);
				txtIngresar.setEditable(false);
				txtIngresar.setEnabled(false);
				btnBuscar.setEnabled(false);
				lblBuscar.setEnabled(false);
				
				lblInputCodInternamiento.setEnabled(false);
				txtCodInternamiento.setEditable(false);
				lblInputNombre.setEnabled(false);
				txtNombre.setEditable(false);
				lblInputCodPaciente.setEnabled(false);
				txtCodPaciente.setEditable(false);
				lblInputCodCama.setEnabled(false);
				txtCodCama.setEditable(false);
				lblSelectCodPaciente.setEnabled(false);
				btnSelectCodPaciente.setEnabled(false);
				lblSelectCodCama.setEnabled(false);
				btnSelectCodCama.setEnabled(false);
				
				txtCodInternamiento.setText("");
				hideButtons();
			}
		});
		
		arrowBuscarPor = new JLabel("");
		arrowBuscarPor.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/ico-down.png")));
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
				
				lblInputCodInternamiento.setEnabled(false);
				txtCodInternamiento.setEditable(false);
				lblInputNombre.setEnabled(true);
				txtNombre.setEditable(true);
				lblInputCodPaciente.setEnabled(true);
				txtCodPaciente.setEditable(true);
				lblInputCodCama.setEnabled(true);
				txtCodCama.setEditable(true);
				lblSelectCodPaciente.setEnabled(true);
				btnSelectCodPaciente.setEnabled(true);
				lblSelectCodCama.setEnabled(true);
				btnSelectCodCama.setEnabled(true);
				
				autogenerateHoraEstado();
				
				hideButtons();
				lblIngresarConfirm.setVisible(true);
				btnIngresarConfirm.setVisible(true);
				
				autogenerateCode();
			}
		});
		btnIngresar.setHorizontalAlignment(SwingConstants.CENTER);
		btnIngresar.setFont(Constantes.regularFont);
		btnIngresar.setForeground(Constantes.textgray);
		btnIngresar.setBounds(360, 122, 64, 26);
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
				
				lblInputCodInternamiento.setEnabled(false);
				txtCodInternamiento.setEditable(false);
				lblInputNombre.setEnabled(false);
				txtNombre.setEditable(false);
				lblInputCodPaciente.setEnabled(false);
				txtCodPaciente.setEditable(false);
				lblInputCodCama.setEnabled(false);
				txtCodCama.setEditable(false);
				lblSelectCodPaciente.setEnabled(false);
				btnSelectCodPaciente.setEnabled(false);
				lblSelectCodCama.setEnabled(false);
				btnSelectCodCama.setEnabled(false);
				
				txtCodInternamiento.setText("");
				hideButtons();
				
				resetFields();
			}
		});
		btnConsultar.setHorizontalAlignment(SwingConstants.CENTER);
		btnConsultar.setFont(Constantes.regularFont);
		btnConsultar.setForeground(Constantes.textgray);
		btnConsultar.setBounds(614, 122, 64, 26);
		btnConsultar.setCursor(Constantes.pointer);
		contentPane.add(btnConsultar);
		btnListar.setForeground(Constantes.textgray);
		
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
				
				lblInputCodInternamiento.setEnabled(false);
				txtCodInternamiento.setEditable(false);
				lblInputNombre.setEnabled(false);
				txtNombre.setEditable(false);
				lblInputCodPaciente.setEnabled(false);
				txtCodPaciente.setEditable(false);
				lblInputCodCama.setEnabled(false);
				txtCodCama.setEditable(false);
				lblSelectCodPaciente.setEnabled(false);
				btnSelectCodPaciente.setEnabled(false);
				lblSelectCodCama.setEnabled(false);
				btnSelectCodCama.setEnabled(false);
				
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
		
		txtIngresar = new JTextField();
		txtIngresar.setEnabled(false);
		txtIngresar.setEditable(false);
		txtIngresar.setOpaque(false);
		txtIngresar.setForeground(new Color(68, 68, 68));
		txtIngresar.setFont(Constantes.regularFont);
		txtIngresar.setColumns(10);
		txtIngresar.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtIngresar.setBounds(663, 212, 251, 35);
		contentPane.add(txtIngresar);
		
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
					txtIngresar.setText("PAC");
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
		lblInputBuscar.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/text-buscar.png")));
		lblInputBuscar.setBounds(127, 212, 200, 35);
		contentPane.add(lblInputBuscar);
		
		lblBuscarPor = new JLabel("Buscar por:");
		lblBuscarPor.setFont(Constantes.regularFont);
		lblBuscarPor.setForeground(Constantes.textgray);
		lblBuscarPor.setBounds(24, 212, 87, 35);
		contentPane.add(lblBuscarPor);
		
		lblInputIngresar = new JLabel("");
		lblInputIngresar.setEnabled(false);
		lblInputIngresar.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/text-ingresar.png")));
		lblInputIngresar.setBounds(655, 212, 266, 35);
		contentPane.add(lblInputIngresar);
		
		lblIngresar = new JLabel("Ingrese dato seg\u00FAn su selecci\u00F3n:");
		lblIngresar.setForeground(new Color(68, 68, 68));
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
				btnBuscar.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBuscar.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/btn-login.png")));
			}
			void mostrarDatos(Internamiento data){
				txtCodInternamiento.setText(data.getCodInternamiento());
				txtCodPaciente.setText(data.getCodPaciente());
				txtNombre.setText(data.getNombre());
				txtCodCama.setText(data.getCodCama());
				txtFechaIngreso.setText(data.getFechaIngreso());
				txtHoraIngreso.setText(data.getHoraIngreso());
				txtFechaSalida.setText(data.getFechaSalida());
				txtHoraSalida.setText(data.getHoraSalida());
				txtEstado.setText(data.getEstado());
				resetearBusqueda();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnBuscar.isEnabled()){
					int cboSelect = getCboBuscarPor();
					if(getBusquedaCodigo().contentEquals("") || cboSelect == 0){
						mensaje("Asegurese de haber seleccionado un filtro e ingresado un término de búsqueda.");
					}
					else {
						String term = getBusquedaCodigo();
						if(cboSelect == 1){
							if(term.matches("INT\\d{3}")){
								Internamiento buscarInternamiento = internamiento.buscarPorCodigoInternamiento(term);
								if(buscarInternamiento != null){
									mostrarDatos(buscarInternamiento);
								}
								else {
									mensaje("No hay registros de pacientes con este código.");
								}
							}
							else {
								mensaje("El código no ha sido ingresado en un formato correcto.\nEjemplo: \"INT001\"");
							}
						}
						if(cboSelect == 2){
							if(term.matches("PAC\\d{3}")){
								Internamiento buscarInternamiento = internamiento.buscarPorCodigoPaciente(term);
								if(buscarInternamiento != null){
									mostrarDatos(buscarInternamiento);
								}
								else {
									mensaje("No hay registros de pacientes con este código.");
								}
							}
							else {
								mensaje("El código no ha sido ingresado en un formato correcto.\nEjemplo: \"PAC001\"");
							}
						}
						if(cboSelect == 3){
							if(term.matches("CAM\\d{3}")){
								Internamiento buscarInternamiento = internamiento.buscarPorCodigoCama(term);
								if(buscarInternamiento != null){
									mostrarDatos(buscarInternamiento);
								}
								else {
									mensaje("No hay registros de pacientes con este código.");
								}
							}
							else {
								mensaje("El código no ha sido ingresado en un formato correcto.\nEjemplo: \"CAM001\"");
							}
						}
					}
				}
				else {
					return;
				}
			}
		});
		btnBuscar.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/btn-login.png")));
		btnBuscar.setCursor(Constantes.pointer);
		btnBuscar.setBounds(931, 212, 100, 35);
		contentPane.add(btnBuscar);
		
		lblAviso = new JLabel("* Opci\u00F3n activa: Listar");
		lblAviso.setHorizontalAlignment(SwingConstants.LEFT);
		lblAviso.setFont(Constantes.regularFont);
		lblAviso.setBounds(25, 167, 172, 26);
		lblAviso.setForeground(Constantes.skyblue);
		contentPane.add(lblAviso);
		
		lblCodInternamiento = new JLabel("C\u00F3digo de Int.:");
		lblCodInternamiento.setForeground(new Color(68, 68, 68));
		lblCodInternamiento.setFont(Constantes.regularFont);
		lblCodInternamiento.setBounds(25, 286, 92, 35);
		contentPane.add(lblCodInternamiento);
		
		lblCodPaciente = new JLabel("C\u00F3digo de Pac.:");
		lblCodPaciente.setForeground(new Color(68, 68, 68));
		lblCodPaciente.setFont(Constantes.regularFont);
		lblCodPaciente.setBounds(533, 286, 112, 35);
		contentPane.add(lblCodPaciente);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(new Color(68, 68, 68));
		lblNombre.setFont(Constantes.regularFont);
		lblNombre.setBounds(25, 332, 87, 35);
		contentPane.add(lblNombre);
		
		lblFechaIngreso = new JLabel("Fec de ingreso:");
		lblFechaIngreso.setForeground(new Color(68, 68, 68));
		lblFechaIngreso.setFont(Constantes.regularFont);
		lblFechaIngreso.setBounds(25, 379, 100, 35);
		contentPane.add(lblFechaIngreso);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 481, 1006, 211);
		contentPane.add(scrollPane);
		
		tblTabla = new JScrollPane();
		scrollPane.setViewportView(tblTabla);
		
		table = new JTable();
		table.setEnabled(false);
		table.setForeground(Constantes.textgray);
		table.setFont(Constantes.regularFont);
		table.setRowHeight(30);
		table.setFillsViewportHeight(true);
		tblTabla.setViewportView(table);
		
		tabla = new DefaultTableModel();
		tabla.addColumn("Código de Internamiento");
		tabla.addColumn("Código de Paciente");
		tabla.addColumn("Nombre");
		tabla.addColumn("Código de cama");
		tabla.addColumn("Fecha de ingreso");
		tabla.addColumn("Hora de ingreso");
		tabla.addColumn("Fecha de salida");
		tabla.addColumn("Hora de salida");
		tabla.addColumn("Estado");
		table.setModel(tabla);
		
		lblIngresarConfirm = new JLabel("Ingresar");
		lblIngresarConfirm.setFont(Constantes.regularFont);
		lblIngresarConfirm.setCursor(Constantes.pointer);
		lblIngresarConfirm.setForeground(Color.WHITE);
		lblIngresarConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresarConfirm.setBounds(931, 427, 100, 34);
		lblIngresarConfirm.setVisible(false);
		contentPane.add(lblIngresarConfirm);
		
		btnIngresarConfirm = new JLabel("");
		btnIngresarConfirm.setVisible(false);
		btnIngresarConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIngresarConfirm.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIngresarConfirm.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/btn-login.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int option = JOptionPane.showConfirmDialog(null, "¿Está seguro de ingresar los registros de un nuevo internamiento?", "Confirmar ingreso de datos", JOptionPane.OK_CANCEL_OPTION);
					if(option == 0){
						Internamiento newInternamiento = new Internamiento(getCodInternamiento(), getCodPaciente(), getNombre(), getCodCama(), getFechaIngreso(), getHoraIngreso(), "---", "---", getEstado());
						internamiento.adicionar(newInternamiento);
						internamiento.agregarInternamiento();
						
						mensaje("Los nuevos registros han sido grabados correctamente.");
						listarInternamientos();
						resetFields();
						autogenerateCode();
						autogenerateHoraEstado();
					}
				}
				catch(Exception er){
					mensaje("Hubo un error en el ingreso de datos.");
				}
			}
		});
		btnIngresarConfirm.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/btn-login.png")));
		btnIngresarConfirm.setBounds(931, 426, 100, 35);
		contentPane.add(btnIngresarConfirm);
		
		lblEliminarConfirm = new JLabel("Eliminar");
		lblEliminarConfirm.setFont(Constantes.regularFont);
		lblEliminarConfirm.setCursor(Constantes.pointer);
		lblEliminarConfirm.setForeground(Color.WHITE);
		lblEliminarConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarConfirm.setBounds(931, 427, 100, 34);
		lblEliminarConfirm.setVisible(false);
		contentPane.add(lblEliminarConfirm);
		
		btnEliminarConfirm = new JLabel("");
		btnEliminarConfirm.setVisible(false);
		btnEliminarConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIngresarConfirm.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIngresarConfirm.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/btn-login.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				String codigo = txtCodInternamiento.getText();
				Internamiento dropInternamiento = internamiento.buscarPorCodigoInternamiento(codigo);
				if(dropInternamiento != null){
					int option = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar los registros de este internamiento?", "Confirmar eliminación", JOptionPane.OK_CANCEL_OPTION);
					if(option == 0){
						internamiento.eliminarInternamiento(dropInternamiento);
						internamiento.agregarInternamiento();
						listarInternamientos();
						resetFields();
						mensaje("Los registros de este paciente han sido eliminados correctamente.");
					}
				}
				else {
					mensaje("No has ingresado pacientes para eliminar.");
				}
			}
		});
		btnEliminarConfirm.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/btn-login.png")));
		btnEliminarConfirm.setBounds(931, 426, 100, 35);
		contentPane.add(btnEliminarConfirm);
		
		txtCodPaciente = new JTextField();
		txtCodPaciente.setOpaque(false);
		txtCodPaciente.setForeground(new Color(68, 68, 68));
		txtCodPaciente.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		txtCodPaciente.setEditable(false);
		txtCodPaciente.setColumns(10);
		txtCodPaciente.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtCodPaciente.setBounds(663, 285, 251, 35);
		contentPane.add(txtCodPaciente);
		
		lblInputCodPaciente = new JLabel("");
		lblInputCodPaciente.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/text-ingresar.png")));
		lblInputCodPaciente.setEnabled(false);
		lblInputCodPaciente.setBounds(655, 285, 266, 35);
		contentPane.add(lblInputCodPaciente);
		
		lblSelectCodPaciente = new JLabel("Seleccionar");
		lblSelectCodPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectCodPaciente.setForeground(Color.WHITE);
		lblSelectCodPaciente.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		lblSelectCodPaciente.setCursor(Constantes.pointer);
		lblSelectCodPaciente.setEnabled(false);
		lblSelectCodPaciente.setBounds(931, 285, 100, 35);
		contentPane.add(lblSelectCodPaciente);
		
		buscadorPaciente.addWindowListener(new WindowListener() {
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
				String code = buscadorPaciente.sendCodPaciente();
				String nombre = buscadorPaciente.sendNombrePaciente();
				txtCodPaciente.setText(code);
				txtNombre.setText(nombre);
			}
			@Override
			public void windowActivated(java.awt.event.WindowEvent arg0) {
			}
		});
		
		buscadorCama.addWindowListener(new WindowListener() {
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
				String code = buscadorCama.sendCodCama();
				txtCodCama.setText(code);
			}
			@Override
			public void windowActivated(java.awt.event.WindowEvent arg0) {
			}
		});
		
		
		btnSelectCodPaciente = new JLabel("");
		btnSelectCodPaciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSelectCodPaciente.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSelectCodPaciente.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/btn-login.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				buscadorPaciente.setVisible(true);
				String codPaciente = buscadorPaciente.sendCodPaciente();
				txtCodPaciente.setText(codPaciente);
			}
		});
		btnSelectCodPaciente.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/btn-login.png")));
		btnSelectCodPaciente.setEnabled(false);
		btnSelectCodPaciente.setBounds(931, 285, 100, 35);
		contentPane.add(btnSelectCodPaciente);
		
		txtNombre = new JTextField();
		txtNombre.setOpaque(false);
		txtNombre.setForeground(new Color(68, 68, 68));
		txtNombre.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtNombre.setBounds(135, 332, 358, 35);
		contentPane.add(txtNombre);
		
		lblInputNombre = new JLabel("");
		lblInputNombre.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/input-text-large.png")));
		lblInputNombre.setEnabled(false);
		lblInputNombre.setBounds(127, 332, 376, 35);
		contentPane.add(lblInputNombre);
		
		lblCodCama = new JLabel("C\u00F3digo de Cama:");
		lblCodCama.setForeground(new Color(68, 68, 68));
		lblCodCama.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		lblCodCama.setBounds(533, 332, 112, 35);
		contentPane.add(lblCodCama);
		
		txtCodCama = new JTextField();
		txtCodCama.setOpaque(false);
		txtCodCama.setForeground(new Color(68, 68, 68));
		txtCodCama.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		txtCodCama.setEditable(false);
		txtCodCama.setColumns(10);
		txtCodCama.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtCodCama.setBounds(663, 331, 251, 35);
		contentPane.add(txtCodCama);
		
		lblInputCodCama = new JLabel("");
		lblInputCodCama.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/text-ingresar.png")));
		lblInputCodCama.setEnabled(false);
		lblInputCodCama.setBounds(655, 331, 266, 35);
		contentPane.add(lblInputCodCama);
		
		lblSelectCodCama = new JLabel("Seleccionar");
		lblSelectCodCama.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectCodCama.setForeground(Color.WHITE);
		lblSelectCodCama.setCursor(Constantes.pointer);
		lblSelectCodCama.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		lblSelectCodCama.setEnabled(false);
		lblSelectCodCama.setBounds(931, 331, 100, 35);
		contentPane.add(lblSelectCodCama);
		
		btnSelectCodCama = new JLabel("");
		btnSelectCodCama.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSelectCodCama.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSelectCodCama.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/btn-login.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				buscadorCama.setVisible(true);
			}
		});
		btnSelectCodCama.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/btn-login.png")));
		btnSelectCodCama.setEnabled(false);
		btnSelectCodCama.setBounds(931, 331, 100, 35);
		contentPane.add(btnSelectCodCama);
		
		lblHoraIngreso = new JLabel("Hora de ingreso:");
		lblHoraIngreso.setForeground(new Color(68, 68, 68));
		lblHoraIngreso.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		lblHoraIngreso.setBounds(265, 379, 112, 35);
		contentPane.add(lblHoraIngreso);
		
		txtFechaIngreso = new JTextField();
		txtFechaIngreso.setOpaque(false);
		txtFechaIngreso.setForeground(new Color(68, 68, 68));
		txtFechaIngreso.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		txtFechaIngreso.setEditable(false);
		txtFechaIngreso.setColumns(10);
		txtFechaIngreso.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtFechaIngreso.setBounds(135, 379, 115, 35);
		contentPane.add(txtFechaIngreso);
		
		lblInputFecIngreso = new JLabel("");
		lblInputFecIngreso.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/input-text-short.png")));
		lblInputFecIngreso.setEnabled(false);
		lblInputFecIngreso.setBounds(127, 379, 130, 35);
		contentPane.add(lblInputFecIngreso);
		
		txtHoraIngreso = new JTextField();
		txtHoraIngreso.setOpaque(false);
		txtHoraIngreso.setForeground(new Color(68, 68, 68));
		txtHoraIngreso.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		txtHoraIngreso.setEditable(false);
		txtHoraIngreso.setColumns(10);
		txtHoraIngreso.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtHoraIngreso.setBounds(381, 379, 115, 35);
		contentPane.add(txtHoraIngreso);
		
		lblInputHoraIngreso = new JLabel("");
		lblInputHoraIngreso.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/input-text-short.png")));
		lblInputHoraIngreso.setEnabled(false);
		lblInputHoraIngreso.setBounds(373, 379, 130, 35);
		contentPane.add(lblInputHoraIngreso);
		
		txtEstado = new JTextField();
		txtEstado.setOpaque(false);
		txtEstado.setForeground(new Color(68, 68, 68));
		txtEstado.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		txtEstado.setEditable(false);
		txtEstado.setColumns(10);
		txtEstado.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtEstado.setBounds(135, 427, 358, 35);
		contentPane.add(txtEstado);
		
		lblFechaSalida = new JLabel("Fec de salida:");
		lblFechaSalida.setForeground(new Color(68, 68, 68));
		lblFechaSalida.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		lblFechaSalida.setBounds(533, 379, 87, 35);
		contentPane.add(lblFechaSalida);
		
		lblHoraSalida = new JLabel("Hora de salida:");
		lblHoraSalida.setForeground(new Color(68, 68, 68));
		lblHoraSalida.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		lblHoraSalida.setBounds(798, 379, 100, 35);
		contentPane.add(lblHoraSalida);
		
		txtFechaSalida = new JTextField();
		txtFechaSalida.setOpaque(false);
		txtFechaSalida.setForeground(new Color(68, 68, 68));
		txtFechaSalida.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		txtFechaSalida.setEnabled(false);
		txtFechaSalida.setEditable(false);
		txtFechaSalida.setColumns(10);
		txtFechaSalida.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtFechaSalida.setBounds(663, 379, 115, 35);
		contentPane.add(txtFechaSalida);
		
		lblInputFecSalida = new JLabel("");
		lblInputFecSalida.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/input-text-short.png")));
		lblInputFecSalida.setEnabled(false);
		lblInputFecSalida.setBounds(655, 379, 130, 35);
		contentPane.add(lblInputFecSalida);
		
		txtHoraSalida = new JTextField();
		txtHoraSalida.setOpaque(false);
		txtHoraSalida.setForeground(new Color(68, 68, 68));
		txtHoraSalida.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		txtHoraSalida.setEnabled(false);
		txtHoraSalida.setEditable(false);
		txtHoraSalida.setColumns(10);
		txtHoraSalida.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtHoraSalida.setBounds(909, 379, 115, 35);
		contentPane.add(txtHoraSalida);
		
		lblInputHoraSalida = new JLabel("");
		lblInputHoraSalida.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/input-text-short.png")));
		lblInputHoraSalida.setEnabled(false);
		lblInputHoraSalida.setBounds(901, 379, 130, 35);
		contentPane.add(lblInputHoraSalida);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setForeground(new Color(68, 68, 68));
		lblEstado.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		lblEstado.setBounds(24, 426, 87, 35);
		contentPane.add(lblEstado);
		
		lblInputSeleccionarEstado = new JLabel("");
		lblInputSeleccionarEstado.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/input-text-large.png")));
		lblInputSeleccionarEstado.setEnabled(false);
		lblInputSeleccionarEstado.setBounds(127, 427, 376, 35);
		contentPane.add(lblInputSeleccionarEstado);
		
		lblBackground.setIcon(backfinal);
		lblBackground.setBounds(0, 0, xSize-310, ySize-50);
		contentPane.add(lblBackground);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		//Ubicar la barra de menú en la parte superior izquierda de la pantalla
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX() - this.getWidth();
        int y = (int) rect.getMinY();
        setLocation(x, y);
        setVisible(true);
        
        listarInternamientos();
        
        
        
	}
	
	private int getCboBuscarPor(){
		String cboSelect = txtBuscar.getText();
		if(cboSelect.contentEquals("Código de internamiento"))
			return 1;
		else if(cboSelect.contentEquals("Código de paciente"))
			return 2;
		else if(cboSelect.contentEquals("Código de cama"))
			return 3;
		else
			return 0;
	}
	
	private void listarInternamientos(){
		tabla.setRowCount(0);
		for(int i = 0; i < internamiento.tamanio(); i++){
			Object[] data = {
				internamiento.obtener(i).getCodInternamiento(),
				internamiento.obtener(i).getCodPaciente(),
				internamiento.obtener(i).getNombre(),
				internamiento.obtener(i).getCodCama(),
				internamiento.obtener(i).getFechaIngreso(),
				internamiento.obtener(i).getHoraIngreso(),
				internamiento.obtener(i).getFechaSalida(),
				internamiento.obtener(i).getHoraSalida(),
				internamiento.obtener(i).getEstado()
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
		txtCodInternamiento.setText("");
		txtCodPaciente.setText("");
		txtNombre.setText("");
		txtCodCama.setText("");
		txtFechaIngreso.setText("");
		txtHoraIngreso.setText("");
		txtFechaSalida.setText("");
		txtHoraSalida.setText("");
		txtEstado.setText("");
	}
	
	private void changeOptionActive(String optionActive){
		String text = lblAviso.getText().split(":")[0];
		lblAviso.setText(text + ": " + optionActive);
	}
	
	private void hideButtons(){
		lblIngresarConfirm.setVisible(false);
		btnIngresarConfirm.setVisible(false);
		lblEliminarConfirm.setVisible(false);
		btnEliminarConfirm.setVisible(false);
	}
	
	private String getCodInternamiento(){
		return txtCodInternamiento.getText();
	}
	
	private String getCodPaciente(){
		return txtCodPaciente.getText();
	}
	
	private String getNombre(){
		return txtNombre.getText();
	}
	
	private String getCodCama(){
		return txtCodCama.getText();
	}
	
	private String getFechaIngreso(){
		return txtFechaIngreso.getText();
	}
	
	private String getHoraIngreso(){
		return txtHoraIngreso.getText();
	}
	
	private String getEstado(){
		return txtEstado.getText();
	}
	
	private void autogenerateCode(){
		int lastCode = internamiento.obtenerUltimoCodigo() + 1;
		String newCode = "INT";
		if(Integer.toString(lastCode).length() == 1) newCode += "00" + lastCode;
		if(Integer.toString(lastCode).length() == 2) newCode += "0" + lastCode;
		if(Integer.toString(lastCode).length() == 3) newCode += "" + lastCode;
		txtCodInternamiento.setText(newCode);
	}
	
	private void autogenerateHoraEstado(){
		date = new Date();
		DateFormat hourFormat = new SimpleDateFormat("HH:mm");
		DateFormat dayFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		txtFechaIngreso.setText("" + dayFormat.format(date));
		txtHoraIngreso.setText("" + hourFormat.format(date));
		
		txtEstado.setText("Alojado");
	}
	
}
