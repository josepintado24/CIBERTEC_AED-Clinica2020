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
import java.text.DecimalFormat;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import constantes.Constantes;
import controllers.AtencionController;
import controllers.DetalleAtencionController;
import controllers.MantenimientoMedicinasController;
import controllers.MantenimientoPacientesController;
import models.DetalleAtencion;
import models.Medicina;
import models.Paciente;
import sun.util.resources.cldr.mas.CalendarData_mas_KE;
import models.Atencion;
import java.awt.Font;

public class AtencionMedicinas extends JFrame {

	Constantes constantes = new Constantes();
	DecimalFormat decimalFormat = new DecimalFormat("#.00");
	AtencionController atencion = new AtencionController("atencion.txt");
	DetalleAtencionController detalleAtencion = new DetalleAtencionController("detalle.txt");
	BuscadorPacienteAtencion buscadorPaciente = new BuscadorPacienteAtencion();
	BuscadorMedicina buscadorMedicina = new BuscadorMedicina();
	MantenimientoMedicinasController medicinas = new MantenimientoMedicinasController("medicinas.txt");
	MantenimientoPacientesController pacientes = new MantenimientoPacientesController("pacientes.txt");
	
	private JPanel contentPane;
	private JLabel lblBackground;
	private JLabel btnClose;
	private JTextPane txtDesc;
	private JSeparator separator;
	private JSeparator separatorMenu;
	private JLabel lblTitulo;
	private JLabel btnIngresar;
	private JLabel lblAviso;
	private JLabel lblCodAtencion;
	private JLabel lblCodPaciente;
	private JLabel lblPaciente;
	private JLabel lblBackPaciente;
	private DefaultTableModel tabla;
	private JLabel lblCodMedicina;
	private JLabel lblInputCodMedicina;
	private JLabel btnIngresarConfirm;
	private JLabel btnCancelarConfirm;
	private JLabel lblIngresarConfirm;
	private JLabel lblCancelarConfirm;
	private JTextField txtCodAtencion;
	private JLabel lblInputCodInternamiento;
	private JTextField txtCodPaciente;
	private JTextField txtPaciente;
	private JTextField txtCodMedicina;
	private JTextField txtPrecio;
	private JTextField txtFechaAtencion;
	private JTextField txtEstado;
	private JLabel lblInputCodPaciente;
	private JLabel lblSelectCodPaciente;
	private JLabel btnSelectCodPaciente;
	private JLabel lblSelectCodCama;
	private JLabel btnSelectCodCama;
	private JLabel lblPrecio;
	private JLabel lblBackPrecio;
	private JLabel lblFechaAtencion;
	private JLabel lblEstadoAtencion;
	private JLabel lblBackFecAtencion;
	private JLabel lblBackEstado;
	private Date date;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblTotalPagar;
	private JTextField txtTotalPagar;
	private JLabel label;

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
					AtencionMedicinas frame = new AtencionMedicinas();
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
	public AtencionMedicinas() {
		buscadorPaciente.setVisible(false);
		buscadorMedicina.setVisible(false);
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
				btnClose.setIcon(new ImageIcon(AtencionMedicinas.class.getResource("/views/images/close-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnClose.setIcon(new ImageIcon(AtencionMedicinas.class.getResource("/views/images/close.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
		txtCodAtencion = new JTextField();
		txtCodAtencion.setText("ATE");
		txtCodAtencion.setOpaque(false);
		txtCodAtencion.setForeground(new Color(68, 68, 68));
		txtCodAtencion.setFont(Constantes.regularFont);
		txtCodAtencion.setEditable(false);
		txtCodAtencion.setColumns(10);
		txtCodAtencion.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtCodAtencion.setBounds(135, 218, 358, 35);
		contentPane.add(txtCodAtencion);
		
		lblInputCodInternamiento = new JLabel("");
		lblInputCodInternamiento.setIcon(new ImageIcon(AtencionMedicinas.class.getResource("/views/images/input-text-large.png")));
		lblInputCodInternamiento.setEnabled(true);
		lblInputCodInternamiento.setBounds(127, 218, 376, 35);
		contentPane.add(lblInputCodInternamiento);
		
		lblTitulo = new JLabel("Atenci\u00F3n de medicinas");
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
		txtDesc.setText("En esta secci\u00F3n podr\u00E1s generar el pedido de medicinas de un paciente para luego proceder con el pago.");
		txtDesc.setBounds(25, 77, this.getWidth()-50, 22);
		txtDesc.setEditable(false);
		txtDesc.setForeground(Constantes.textgray);
		contentPane.add(txtDesc);
		
		btnClose.setIcon(new ImageIcon(AtencionMedicinas.class.getResource("/views/images/close.png")));
		btnClose.setBounds(this.getWidth()-25, 10, 16, 14);
		btnClose.setCursor(Constantes.pointer);
		contentPane.add(btnClose);
		
		lblBackground = new JLabel("Al ingresar, activamos la opc\u00F3n de listar por defecto.*");
		lblBackground.setBackground(Color.WHITE);
		lblBackground.setBorder(new LineBorder(Constantes.lightgray, 2));
		ImageIcon background = new ImageIcon(AtencionMedicinas.class.getResource("/views/images/background-mantenimiento.png"));
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
		
		lblCodAtencion = new JLabel("C\u00F3digo de Ate.:");
		lblCodAtencion.setForeground(new Color(68, 68, 68));
		lblCodAtencion.setFont(Constantes.regularFont);
		lblCodAtencion.setBounds(25, 218, 92, 35);
		contentPane.add(lblCodAtencion);
		
		lblCodPaciente = new JLabel("C\u00F3digo de Pac.:");
		lblCodPaciente.setForeground(new Color(68, 68, 68));
		lblCodPaciente.setFont(Constantes.regularFont);
		lblCodPaciente.setBounds(533, 218, 112, 35);
		contentPane.add(lblCodPaciente);
		
		lblPaciente = new JLabel("Paciente:");
		lblPaciente.setForeground(new Color(68, 68, 68));
		lblPaciente.setFont(Constantes.regularFont);
		lblPaciente.setBounds(25, 264, 87, 35);
		contentPane.add(lblPaciente);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 370, 1006, 262);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(Constantes.regularFont);
		table.setForeground(Constantes.textgray);
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		
		tabla = new DefaultTableModel();
		tabla.addColumn("Código de medicina");
		tabla.addColumn("Nombre");
		tabla.addColumn("Cantidad");
		tabla.addColumn("Precio");
		tabla.addColumn("Precio por medicina");
		table.setModel(tabla);
		
		lblIngresarConfirm = new JLabel("Ingresar");
		lblIngresarConfirm.setFont(Constantes.regularFont);
		lblIngresarConfirm.setCursor(Constantes.pointer);
		lblIngresarConfirm.setForeground(Color.WHITE);
		lblIngresarConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresarConfirm.setBounds(931, 655, 100, 34);
		lblIngresarConfirm.setVisible(true);
		contentPane.add(lblIngresarConfirm);
		
		btnIngresarConfirm = new JLabel("");
		btnIngresarConfirm.setVisible(true);
		btnIngresarConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIngresarConfirm.setIcon(new ImageIcon(AtencionMedicinas.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIngresarConfirm.setIcon(new ImageIcon(AtencionMedicinas.class.getResource("/views/images/btn-login.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String codPaciente = getCodPaciente();
					String codMedicina = getCodMedicina();
					if(codPaciente.contentEquals("PAC") || codMedicina.contentEquals("MED")){
						mensaje("Ingrese los datos necesarios por favor.");
					}
					else {
						double totalPagar = Double.parseDouble(txtTotalPagar.getText().split("S/. ")[1].replace(",", "."));
						Atencion newAtencion = new Atencion(getCodAtencion(), getCodPaciente(), txtFechaAtencion.getText(), autogenerateCodeDetalle(), txtEstado.getText(), totalPagar);
						atencion.adicionar(newAtencion);
						atencion.guardarAtencion();
						detalleAtencion.guardarDetalle();
						
						for(int i = 0; i < tabla.getRowCount(); i++){
							Medicina getMedicina = medicinas.buscarPorCodigo(txtCodMedicina.getText());
							int cantidad = Integer.parseInt((String)tabla.getValueAt(i, 2));
							int stockActual = getMedicina.getStock();
							getMedicina.setStock(stockActual - cantidad);
						}
						medicinas.agregarMedicina();
						
						mensaje("Los datos se han grabado correctamente.");
					}
				}
				catch(Exception er){
					mensaje("Hubo un error en el ingreso de datos." + er);
				}
			}
		});
		btnIngresarConfirm.setIcon(new ImageIcon(AtencionMedicinas.class.getResource("/views/images/btn-login.png")));
		btnIngresarConfirm.setBounds(931, 654, 100, 35);
		contentPane.add(btnIngresarConfirm);
		
		lblCancelarConfirm = new JLabel("Cancelar");
		lblCancelarConfirm.setFont(Constantes.regularFont);
		lblCancelarConfirm.setCursor(Constantes.pointer);
		lblCancelarConfirm.setForeground(Color.WHITE);
		lblCancelarConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancelarConfirm.setBounds(821, 655, 100, 34);
		lblCancelarConfirm.setVisible(true);
		contentPane.add(lblCancelarConfirm);
		
		btnCancelarConfirm = new JLabel("");
		btnCancelarConfirm.setVisible(true);
		btnCancelarConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCancelarConfirm.setIcon(new ImageIcon(AtencionMedicinas.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCancelarConfirm.setIcon(new ImageIcon(AtencionMedicinas.class.getResource("/views/images/btn-login.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "¿Está seguro de cancelar?", "Confirmar cancelación", JOptionPane.OK_CANCEL_OPTION);
				if(option == 0) resetFields();
				else return;
			}
		});
		btnCancelarConfirm.setIcon(new ImageIcon(AtencionMedicinas.class.getResource("/views/images/btn-login.png")));
		btnCancelarConfirm.setBounds(821, 654, 100, 35);
		contentPane.add(btnCancelarConfirm);
		
		txtCodPaciente = new JTextField();
		txtCodPaciente.setText("PAC");
		txtCodPaciente.setOpaque(false);
		txtCodPaciente.setForeground(new Color(68, 68, 68));
		txtCodPaciente.setFont(Constantes.regularFont);
		txtCodPaciente.setEditable(false);
		txtCodPaciente.setColumns(10);
		txtCodPaciente.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtCodPaciente.setBounds(663, 217, 251, 35);
		contentPane.add(txtCodPaciente);
		
		lblInputCodPaciente = new JLabel("");
		lblInputCodPaciente.setIcon(new ImageIcon(AtencionMedicinas.class.getResource("/views/images/text-ingresar.png")));
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
				Paciente getPaciente = pacientes.buscarPorCodigo(code);
				txtCodPaciente.setText(code);
				txtPaciente.setText(nombre + " " + getPaciente.getApellidos());
			}
			@Override
			public void windowActivated(java.awt.event.WindowEvent arg0) {
			}
		});
		
		buscadorMedicina.addWindowListener(new WindowListener() {
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
				double suma = 0.0;
				String code = buscadorMedicina.sendCodMedicina();
				txtCodMedicina.setText(code);
				Medicina getMedicina = medicinas.buscarPorCodigo(code);
				double totalPagar = (Double.parseDouble(buscadorMedicina.sendCantidad()) * getMedicina.getPrecio());
				txtPrecio.setText("" + decimalFormat.format(getMedicina.getPrecio()));
				Object[] data = {
					getMedicina.getCodMedicina(),
					getMedicina.getNombre(),
					buscadorMedicina.sendCantidad(),
					getMedicina.getPrecio(),
					Double.toString(totalPagar)
				};
				tabla.addRow(data);
				DetalleAtencion detalle = new DetalleAtencion(autogenerateCodeDetalle(), txtCodAtencion.getText(), getMedicina.getCodMedicina(), Integer.parseInt(buscadorMedicina.sendCantidad()), getMedicina.getPrecio(), totalPagar);
				detalleAtencion.adicionar(detalle);
				
				for(int i = 0; i < tabla.getRowCount(); i++){
					String precio = (String)tabla.getValueAt(i, 4);
					suma += Double.parseDouble(precio);
				}
				txtTotalPagar.setText("S/. " + decimalFormat.format(suma));
				
			}
			@Override
			public void windowActivated(java.awt.event.WindowEvent arg0) {
			}
		});
		
		
		btnSelectCodPaciente = new JLabel("");
		btnSelectCodPaciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSelectCodPaciente.setIcon(new ImageIcon(AtencionMedicinas.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSelectCodPaciente.setIcon(new ImageIcon(AtencionMedicinas.class.getResource("/views/images/btn-login.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				buscadorPaciente.setVisible(true);
				String codPaciente = buscadorPaciente.sendCodPaciente();
				txtCodPaciente.setText(codPaciente);
			}
		});
		btnSelectCodPaciente.setIcon(new ImageIcon(AtencionMedicinas.class.getResource("/views/images/btn-login.png")));
		btnSelectCodPaciente.setEnabled(true);
		btnSelectCodPaciente.setBounds(931, 217, 100, 35);
		contentPane.add(btnSelectCodPaciente);
		
		txtPaciente = new JTextField();
		txtPaciente.setOpaque(false);
		txtPaciente.setForeground(new Color(68, 68, 68));
		txtPaciente.setFont(Constantes.regularFont);
		txtPaciente.setEditable(false);
		txtPaciente.setColumns(10);
		txtPaciente.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtPaciente.setBounds(135, 264, 358, 35);
		contentPane.add(txtPaciente);
		
		lblBackPaciente = new JLabel("");
		lblBackPaciente.setIcon(new ImageIcon(AtencionMedicinas.class.getResource("/views/images/input-text-large.png")));
		lblBackPaciente.setEnabled(true);
		lblBackPaciente.setBounds(127, 264, 376, 35);
		contentPane.add(lblBackPaciente);
		
		lblCodMedicina = new JLabel("C\u00F3digo de Med:");
		lblCodMedicina.setForeground(new Color(68, 68, 68));
		lblCodMedicina.setFont(Constantes.regularFont);
		lblCodMedicina.setBounds(533, 264, 112, 35);
		contentPane.add(lblCodMedicina);
		
		txtCodMedicina = new JTextField();
		txtCodMedicina.setText("MED");
		txtCodMedicina.setOpaque(false);
		txtCodMedicina.setForeground(new Color(68, 68, 68));
		txtCodMedicina.setFont(Constantes.regularFont);
		txtCodMedicina.setEditable(false);
		txtCodMedicina.setColumns(10);
		txtCodMedicina.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtCodMedicina.setBounds(663, 263, 251, 35);
		contentPane.add(txtCodMedicina);
		
		lblInputCodMedicina = new JLabel("");
		lblInputCodMedicina.setIcon(new ImageIcon(AtencionMedicinas.class.getResource("/views/images/text-ingresar.png")));
		lblInputCodMedicina.setEnabled(true);
		lblInputCodMedicina.setBounds(655, 263, 266, 35);
		contentPane.add(lblInputCodMedicina);
		
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
				btnSelectCodCama.setIcon(new ImageIcon(AtencionMedicinas.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSelectCodCama.setIcon(new ImageIcon(AtencionMedicinas.class.getResource("/views/images/btn-login.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				buscadorMedicina.setVisible(true);
			}
		});
		btnSelectCodCama.setIcon(new ImageIcon(AtencionMedicinas.class.getResource("/views/images/btn-login.png")));
		btnSelectCodCama.setEnabled(true);
		btnSelectCodCama.setBounds(931, 263, 100, 35);
		contentPane.add(btnSelectCodCama);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setForeground(new Color(68, 68, 68));
		lblPrecio.setFont(Constantes.regularFont);
		lblPrecio.setBounds(25, 311, 87, 35);
		contentPane.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setText("S/. ");
		txtPrecio.setOpaque(false);
		txtPrecio.setForeground(new Color(68, 68, 68));
		txtPrecio.setFont(Constantes.regularFont);
		txtPrecio.setEditable(false);
		txtPrecio.setColumns(10);
		txtPrecio.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtPrecio.setBounds(135, 311, 115, 35);
		contentPane.add(txtPrecio);
		
		lblBackPrecio = new JLabel("");
		lblBackPrecio.setIcon(new ImageIcon(AtencionMedicinas.class.getResource("/views/images/input-text-short.png")));
		lblBackPrecio.setEnabled(false);
		lblBackPrecio.setBounds(127, 311, 130, 35);
		contentPane.add(lblBackPrecio);
		
		lblFechaAtencion = new JLabel("Fec de atenci\u00F3n:");
		lblFechaAtencion.setForeground(new Color(68, 68, 68));
		lblFechaAtencion.setFont(Constantes.regularFont);
		lblFechaAtencion.setBounds(533, 311, 95, 35);
		contentPane.add(lblFechaAtencion);
		
		lblEstadoAtencion = new JLabel("Estado:");
		lblEstadoAtencion.setForeground(new Color(68, 68, 68));
		lblEstadoAtencion.setFont(Constantes.regularFont);
		lblEstadoAtencion.setBounds(278, 311, 92, 35);
		contentPane.add(lblEstadoAtencion);
		
		txtFechaAtencion = new JTextField();
		txtFechaAtencion.setOpaque(false);
		txtFechaAtencion.setForeground(new Color(68, 68, 68));
		txtFechaAtencion.setFont(Constantes.regularFont);
		txtFechaAtencion.setEnabled(true);
		txtFechaAtencion.setEditable(false);
		txtFechaAtencion.setColumns(10);
		txtFechaAtencion.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtFechaAtencion.setBounds(663, 310, 115, 35);
		contentPane.add(txtFechaAtencion);
		
		lblBackFecAtencion = new JLabel("");
		lblBackFecAtencion.setIcon(new ImageIcon(AtencionMedicinas.class.getResource("/views/images/input-text-short.png")));
		lblBackFecAtencion.setEnabled(false);
		lblBackFecAtencion.setBounds(655, 310, 130, 35);
		contentPane.add(lblBackFecAtencion);
		
		txtEstado = new JTextField();
		txtEstado.setOpaque(false);
		txtEstado.setText("Pendiente");
		txtEstado.setForeground(new Color(68, 68, 68));
		txtEstado.setFont(Constantes.regularFont);
		txtEstado.setEditable(false);
		txtEstado.setColumns(10);
		txtEstado.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtEstado.setBounds(381, 311, 115, 35);
		contentPane.add(txtEstado);
		
		lblBackEstado = new JLabel("");
		lblBackEstado.setIcon(new ImageIcon(AtencionMedicinas.class.getResource("/views/images/input-text-short.png")));
		lblBackEstado.setEnabled(false);
		lblBackEstado.setBounds(373, 311, 130, 35);
		contentPane.add(lblBackEstado);
		
		lblTotalPagar = new JLabel("TOTAL A PAGAR:");
		lblTotalPagar.setForeground(new Color(68, 68, 68));
		lblTotalPagar.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		lblTotalPagar.setBounds(25, 654, 193, 35);
		contentPane.add(lblTotalPagar);
		
		txtTotalPagar = new JTextField();
		txtTotalPagar.setText("S/. 0.00");
		txtTotalPagar.setOpaque(false);
		txtTotalPagar.setForeground(new Color(68, 68, 68));
		txtTotalPagar.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		txtTotalPagar.setEditable(false);
		txtTotalPagar.setColumns(10);
		txtTotalPagar.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtTotalPagar.setBounds(235, 654, 115, 35);
		contentPane.add(txtTotalPagar);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(AtencionMedicinas.class.getResource("/views/images/input-text-short.png")));
		label.setEnabled(false);
		label.setBounds(227, 654, 130, 35);
		contentPane.add(label);
		
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
        
        autogenerateCode();
        autogenerateHoraEstado();
	}
	
	private void mensaje(String msg){
		JOptionPane.showMessageDialog(null, msg);
	}
	
	private void resetFields(){
		txtCodAtencion.setText("");
		txtCodPaciente.setText("");
		txtPaciente.setText("");
		txtCodMedicina.setText("");
		txtFechaAtencion.setText("");
		txtEstado.setText("");
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
	
	private String getCodAtencion(){
		return txtCodAtencion.getText();
	}
	
	private String getCodPaciente(){
		return txtCodPaciente.getText();
	}
	
	private String getNombre(){
		return txtPaciente.getText();
	}
	
	private String getCodMedicina(){
		return txtCodMedicina.getText();
	}
	
	private String getHoraIngreso(){
		return txtPrecio.getText();
	}
	
	private void autogenerateHoraEstado(){
		date = new Date();
		DateFormat hourFormat = new SimpleDateFormat("HH:mm");
		DateFormat dayFormat = new SimpleDateFormat("dd/MM/yyyy");
		txtFechaAtencion.setText(dayFormat.format(date));
	}
	
	private void autogenerateCode(){
		int lastCode = atencion.obtenerUltimoCodigo() + 1;
		String newCode = "ATE";
		if(Integer.toString(lastCode).length() == 1) newCode += "00" + lastCode;
		if(Integer.toString(lastCode).length() == 2) newCode += "0" + lastCode;
		if(Integer.toString(lastCode).length() == 3) newCode += "" + lastCode;
		txtCodAtencion.setText(newCode);
	}
	
	private String autogenerateCodeDetalle(){
		int code = Integer.parseInt(txtCodAtencion.getText().split("ATE")[1]);
		String newCode = "DEA";
		if(Integer.toString(code).length() == 1) newCode += "00" + code;
		if(Integer.toString(code).length() == 2) newCode += "0" + code;
		if(Integer.toString(code).length() == 3) newCode += "" + code;
		return newCode;
	}
}
