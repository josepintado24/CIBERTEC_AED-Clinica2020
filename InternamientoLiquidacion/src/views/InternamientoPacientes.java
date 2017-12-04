package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Insets;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import constantes.Constantes;
import controllers.InternamientoPacientesController;
import controllers.MantenimientoCamasController;
import models.Cama;
import models.Internamiento;

public class InternamientoPacientes extends JFrame {

	Constantes constantes = new Constantes();
	InternamientoPacientesController internamiento = new InternamientoPacientesController("internamiento.txt");
	MantenimientoCamasController camas = new MantenimientoCamasController("camas.txt");
	BuscadorPaciente buscadorPaciente = new BuscadorPaciente();
	BuscadorCama buscadorCama = new BuscadorCama();
	
	private JPanel contentPane;
	private JLabel lblBackground;
	private JLabel btnClose;
	private JTextPane txtDesc;
	private JSeparator separator;
	private JSeparator separatorMenu;
	private JLabel lblTitulo;
	private JLabel btnIngresar;
	private JLabel lblAviso;
	private JLabel lblCodInternamiento;
	private JLabel lblCodPaciente;
	private JLabel lblNombre;
	private JLabel lblInputNombre;
	private JLabel lblFechaIngreso;
	private DefaultTableModel tabla;
	private JLabel lblCodCama;
	private JLabel lblInputCodCama;
	private JLabel btnIngresarConfirm;
	private JLabel btnCancelarConfirm;
	private JLabel lblIngresarConfirm;
	private JLabel lblCancelarConfirm;
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
	private JTextArea txtInfo;
	private JScrollPane scrollPane;
	private JLabel lblInfo;

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
		
		txtCodInternamiento = new JTextField();
		txtCodInternamiento.setOpaque(false);
		txtCodInternamiento.setForeground(Constantes.textgray);
		txtCodInternamiento.setFont(Constantes.regularFont);
		txtCodInternamiento.setEditable(false);
		txtCodInternamiento.setColumns(10);
		txtCodInternamiento.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtCodInternamiento.setBounds(135, 218, 358, 35);
		contentPane.add(txtCodInternamiento);
		
		lblInputCodInternamiento = new JLabel("");
		lblInputCodInternamiento.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/input-text-large.png")));
		lblInputCodInternamiento.setEnabled(true);
		lblInputCodInternamiento.setBounds(127, 218, 376, 35);
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
				autogenerateHoraEstado();
				hideButtons();
				autogenerateCode();
			}
		});
		btnIngresar.setHorizontalAlignment(SwingConstants.CENTER);
		btnIngresar.setFont(Constantes.regularFont);
		btnIngresar.setForeground(Constantes.textgray);
		btnIngresar.setBounds(496, 122, 64, 26);
		btnIngresar.setCursor(Constantes.pointer);
		contentPane.add(btnIngresar);
		
		lblAviso = new JLabel("* Opci\u00F3n activa: Ingresar");
		lblAviso.setHorizontalAlignment(SwingConstants.LEFT);
		lblAviso.setFont(Constantes.regularFont);
		lblAviso.setBounds(25, 167, 172, 26);
		lblAviso.setForeground(Constantes.skyblue);
		contentPane.add(lblAviso);
		
		lblCodInternamiento = new JLabel("C\u00F3digo de Int.:");
		lblCodInternamiento.setForeground(Constantes.textgray);
		lblCodInternamiento.setFont(Constantes.regularFont);
		lblCodInternamiento.setBounds(25, 218, 92, 35);
		contentPane.add(lblCodInternamiento);
		
		lblCodPaciente = new JLabel("C\u00F3digo de Pac.:");
		lblCodPaciente.setForeground(Constantes.textgray);
		lblCodPaciente.setFont(Constantes.regularFont);
		lblCodPaciente.setBounds(533, 218, 112, 35);
		contentPane.add(lblCodPaciente);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Constantes.textgray);
		lblNombre.setFont(Constantes.regularFont);
		lblNombre.setBounds(25, 264, 87, 35);
		contentPane.add(lblNombre);
		
		lblFechaIngreso = new JLabel("Fec de ingreso:");
		lblFechaIngreso.setForeground(Constantes.textgray);
		lblFechaIngreso.setFont(Constantes.regularFont);
		lblFechaIngreso.setBounds(25, 311, 100, 35);
		contentPane.add(lblFechaIngreso);
		
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
		
		lblIngresarConfirm = new JLabel("Ingresar");
		lblIngresarConfirm.setFont(Constantes.regularFont);
		lblIngresarConfirm.setCursor(Constantes.pointer);
		lblIngresarConfirm.setForeground(Color.WHITE);
		lblIngresarConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresarConfirm.setBounds(931, 360, 100, 34);
		lblIngresarConfirm.setVisible(true);
		contentPane.add(lblIngresarConfirm);
		
		btnIngresarConfirm = new JLabel("");
		btnIngresarConfirm.setVisible(true);
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
					if(getCodPaciente().contentEquals("") && getCodCama().contentEquals("")){
						mensaje("Falta ingresar uno o más datos.");
					}
					else {
						int option = JOptionPane.showConfirmDialog(null, "¿Está seguro de ingresar los registros de un nuevo internamiento?", "Confirmar ingreso de datos", JOptionPane.OK_CANCEL_OPTION);
						if(option == 0){
							Internamiento newInternamiento = new Internamiento(getCodInternamiento(), getCodPaciente(), getNombre(), getCodCama(), getFechaIngreso(), getHoraIngreso(), "---", "---", getEstado());
							internamiento.adicionar(newInternamiento);
							internamiento.agregarInternamiento();
							
							Cama modCama = camas.buscarPorCodigo(txtCodCama.getText());
							modCama.setEstado("Ocupado");
							camas.agregarCamas();
							
							mensaje("Los nuevos registros han sido grabados correctamente.");
							resetFields();
							autogenerateCode();
							autogenerateHoraEstado();
							infoInternamiento();
						}
					}
				}
				catch(Exception er){
					mensaje("Hubo un error en el ingreso de datos.");
				}
			}
		});
		btnIngresarConfirm.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/btn-login.png")));
		btnIngresarConfirm.setBounds(931, 359, 100, 35);
		contentPane.add(btnIngresarConfirm);
		
		lblCancelarConfirm = new JLabel("Cancelar");
		lblCancelarConfirm.setFont(Constantes.regularFont);
		lblCancelarConfirm.setCursor(Constantes.pointer);
		lblCancelarConfirm.setForeground(Color.WHITE);
		lblCancelarConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancelarConfirm.setBounds(821, 360, 100, 34);
		lblCancelarConfirm.setVisible(true);
		contentPane.add(lblCancelarConfirm);
		
		btnCancelarConfirm = new JLabel("");
		btnCancelarConfirm.setVisible(true);
		btnCancelarConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCancelarConfirm.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCancelarConfirm.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/btn-login.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "¿Está seguro de cancelar?", "Confirmar cancelación", JOptionPane.OK_CANCEL_OPTION);
				if(option == 0) resetFields();
				else return;
			}
		});
		btnCancelarConfirm.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/btn-login.png")));
		btnCancelarConfirm.setBounds(821, 359, 100, 35);
		contentPane.add(btnCancelarConfirm);
		
		txtCodPaciente = new JTextField();
		txtCodPaciente.setOpaque(false);
		txtCodPaciente.setForeground(Constantes.textgray);
		txtCodPaciente.setFont(Constantes.regularFont);
		txtCodPaciente.setEditable(false);
		txtCodPaciente.setColumns(10);
		txtCodPaciente.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtCodPaciente.setBounds(663, 217, 251, 35);
		contentPane.add(txtCodPaciente);
		
		lblInputCodPaciente = new JLabel("");
		lblInputCodPaciente.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/text-ingresar.png")));
		lblInputCodPaciente.setEnabled(true);
		lblInputCodPaciente.setBounds(655, 217, 266, 35);
		contentPane.add(lblInputCodPaciente);
		
		lblSelectCodPaciente = new JLabel("Seleccionar");
		lblSelectCodPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectCodPaciente.setForeground(Color.WHITE);
		lblSelectCodPaciente.setFont(Constantes.regularFont);
		lblSelectCodPaciente.setCursor(Constantes.pointer);
		lblSelectCodPaciente.setEnabled(true);
		lblSelectCodPaciente.setBounds(931, 217, 100, 35);
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
		btnSelectCodPaciente.setEnabled(true);
		btnSelectCodPaciente.setBounds(931, 217, 100, 35);
		contentPane.add(btnSelectCodPaciente);
		
		txtNombre = new JTextField();
		txtNombre.setOpaque(false);
		txtNombre.setForeground(Constantes.textgray);
		txtNombre.setFont(Constantes.regularFont);
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtNombre.setBounds(135, 264, 358, 35);
		contentPane.add(txtNombre);
		
		lblInputNombre = new JLabel("");
		lblInputNombre.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/input-text-large.png")));
		lblInputNombre.setEnabled(true);
		lblInputNombre.setBounds(127, 264, 376, 35);
		contentPane.add(lblInputNombre);
		
		lblCodCama = new JLabel("C\u00F3digo de Cama:");
		lblCodCama.setForeground(Constantes.textgray);
		lblCodCama.setFont(Constantes.regularFont);
		lblCodCama.setBounds(533, 264, 112, 35);
		contentPane.add(lblCodCama);
		
		txtCodCama = new JTextField();
		txtCodCama.setOpaque(false);
		txtCodCama.setForeground(Constantes.textgray);
		txtCodCama.setFont(Constantes.regularFont);
		txtCodCama.setEditable(false);
		txtCodCama.setColumns(10);
		txtCodCama.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtCodCama.setBounds(663, 263, 251, 35);
		contentPane.add(txtCodCama);
		
		lblInputCodCama = new JLabel("");
		lblInputCodCama.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/text-ingresar.png")));
		lblInputCodCama.setEnabled(true);
		lblInputCodCama.setBounds(655, 263, 266, 35);
		contentPane.add(lblInputCodCama);
		
		lblSelectCodCama = new JLabel("Seleccionar");
		lblSelectCodCama.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectCodCama.setForeground(Color.WHITE);
		lblSelectCodCama.setCursor(Constantes.pointer);
		lblSelectCodCama.setFont(Constantes.regularFont);
		lblSelectCodCama.setEnabled(true);
		lblSelectCodCama.setBounds(931, 263, 100, 35);
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
		btnSelectCodCama.setEnabled(true);
		btnSelectCodCama.setBounds(931, 263, 100, 35);
		contentPane.add(btnSelectCodCama);
		
		lblHoraIngreso = new JLabel("Hora de ingreso:");
		lblHoraIngreso.setForeground(Constantes.textgray);
		lblHoraIngreso.setFont(Constantes.regularFont);
		lblHoraIngreso.setBounds(265, 311, 112, 35);
		contentPane.add(lblHoraIngreso);
		
		txtFechaIngreso = new JTextField();
		txtFechaIngreso.setOpaque(false);
		txtFechaIngreso.setForeground(Constantes.textgray);
		txtFechaIngreso.setFont(Constantes.regularFont);
		txtFechaIngreso.setEditable(false);
		txtFechaIngreso.setColumns(10);
		txtFechaIngreso.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtFechaIngreso.setBounds(135, 311, 115, 35);
		contentPane.add(txtFechaIngreso);
		
		lblInputFecIngreso = new JLabel("");
		lblInputFecIngreso.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/input-text-short.png")));
		lblInputFecIngreso.setEnabled(false);
		lblInputFecIngreso.setBounds(127, 311, 130, 35);
		contentPane.add(lblInputFecIngreso);
		
		txtHoraIngreso = new JTextField();
		txtHoraIngreso.setOpaque(false);
		txtHoraIngreso.setForeground(Constantes.textgray);
		txtHoraIngreso.setFont(Constantes.regularFont);
		txtHoraIngreso.setEditable(false);
		txtHoraIngreso.setColumns(10);
		txtHoraIngreso.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtHoraIngreso.setBounds(381, 311, 115, 35);
		contentPane.add(txtHoraIngreso);
		
		lblInputHoraIngreso = new JLabel("");
		lblInputHoraIngreso.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/input-text-short.png")));
		lblInputHoraIngreso.setEnabled(false);
		lblInputHoraIngreso.setBounds(373, 311, 130, 35);
		contentPane.add(lblInputHoraIngreso);
		
		txtEstado = new JTextField("Alojado");
		txtEstado.setOpaque(false);
		txtEstado.setForeground(Constantes.textgray);
		txtEstado.setFont(Constantes.regularFont);
		txtEstado.setEditable(false);
		txtEstado.setColumns(10);
		txtEstado.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtEstado.setBounds(135, 359, 358, 35);
		contentPane.add(txtEstado);
		
		lblFechaSalida = new JLabel("Fec de salida:");
		lblFechaSalida.setForeground(Constantes.textgray);
		lblFechaSalida.setFont(Constantes.regularFont);
		lblFechaSalida.setBounds(533, 311, 87, 35);
		contentPane.add(lblFechaSalida);
		
		lblHoraSalida = new JLabel("Hora de salida:");
		lblHoraSalida.setForeground(Constantes.textgray);
		lblHoraSalida.setFont(Constantes.regularFont);
		lblHoraSalida.setBounds(798, 311, 100, 35);
		contentPane.add(lblHoraSalida);
		
		txtFechaSalida = new JTextField();
		txtFechaSalida.setOpaque(false);
		txtFechaSalida.setForeground(Constantes.textgray);
		txtFechaSalida.setFont(Constantes.regularFont);
		txtFechaSalida.setEnabled(false);
		txtFechaSalida.setEditable(false);
		txtFechaSalida.setColumns(10);
		txtFechaSalida.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtFechaSalida.setBounds(663, 311, 115, 35);
		contentPane.add(txtFechaSalida);
		
		lblInputFecSalida = new JLabel("");
		lblInputFecSalida.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/input-text-short.png")));
		lblInputFecSalida.setEnabled(false);
		lblInputFecSalida.setBounds(655, 311, 130, 35);
		contentPane.add(lblInputFecSalida);
		
		txtHoraSalida = new JTextField();
		txtHoraSalida.setOpaque(false);
		txtHoraSalida.setForeground(Constantes.textgray);
		txtHoraSalida.setFont(Constantes.regularFont);
		txtHoraSalida.setEnabled(false);
		txtHoraSalida.setEditable(false);
		txtHoraSalida.setColumns(10);
		txtHoraSalida.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtHoraSalida.setBounds(909, 311, 115, 35);
		contentPane.add(txtHoraSalida);
		
		lblInputHoraSalida = new JLabel("");
		lblInputHoraSalida.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/input-text-short.png")));
		lblInputHoraSalida.setEnabled(false);
		lblInputHoraSalida.setBounds(901, 311, 130, 35);
		contentPane.add(lblInputHoraSalida);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setForeground(Constantes.textgray);
		lblEstado.setFont(Constantes.regularFont);
		lblEstado.setBounds(24, 358, 87, 35);
		contentPane.add(lblEstado);
		
		lblInputSeleccionarEstado = new JLabel("");
		lblInputSeleccionarEstado.setIcon(new ImageIcon(InternamientoPacientes.class.getResource("/views/images/input-text-large.png")));
		lblInputSeleccionarEstado.setEnabled(false);
		lblInputSeleccionarEstado.setBounds(127, 359, 376, 35);
		contentPane.add(lblInputSeleccionarEstado);
		
		lblInfo = new JLabel("Informaci\u00F3n de internamiento de pacientes:");
		lblInfo.setForeground(Constantes.textgray);
		lblInfo.setFont(Constantes.regularFont);
		lblInfo.setBounds(25, 427, 468, 26);
		contentPane.add(lblInfo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 456, 1006, 239);
		contentPane.add(scrollPane);
		
		txtInfo = new JTextArea();
		txtInfo.setMargin(new Insets(12, 12, 12, 12));
		txtInfo.setFont(Constantes.regularFont);
		txtInfo.setEditable(false);
		scrollPane.setViewportView(txtInfo);
		
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
        
        autogenerateHoraEstado();
        autogenerateCode();
	}
	
	private void mensaje(String msg){
		JOptionPane.showMessageDialog(null, msg);
	}
	
	private void resetFields(){
		txtCodInternamiento.setText("");
		txtCodPaciente.setText("");
		txtNombre.setText("");
		txtCodCama.setText("");
		txtFechaSalida.setText("");
		txtHoraSalida.setText("");
	}
	
	private void changeOptionActive(String optionActive){
		String text = lblAviso.getText().split(":")[0];
		lblAviso.setText(text + ": " + optionActive);
	}
	
	private void hideButtons(){
		lblIngresarConfirm.setVisible(false);
		btnIngresarConfirm.setVisible(false);
		lblCancelarConfirm.setVisible(false);
		btnCancelarConfirm.setVisible(false);
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
	
	private void imprimir(String s){
		txtInfo.append(s + "\n");
	}
	
	private void infoInternamiento(){
		txtInfo.setText("");
		imprimir("Código de internamiento: " + getCodInternamiento());
		imprimir("Código de paciente: " + getCodPaciente());
		imprimir("Nombre de paciente: " + getNombre());
		imprimir("Código de cama: " + getCodCama());
		imprimir("Fecha de ingreso: " + getFechaIngreso());
		imprimir("Hora de ingreso: " + getHoraIngreso());
		imprimir("Fecha de salida: No definido");
		imprimir("Hora de salida: No definido");
		imprimir("Estado: " + getEstado());
	}
}
