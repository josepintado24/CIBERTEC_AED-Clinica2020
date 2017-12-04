
package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
import controllers.InternamientoPacientesController;
import controllers.MantenimientoCamasController;
import controllers.MantenimientoPacientesController;
import models.Cama;
import models.Internamiento;
import models.Paciente;

public class PagoInternamiento extends JFrame {

	Constantes constantes = new Constantes();
	InternamientoPacientesController internamiento = new InternamientoPacientesController("internamiento.txt");
	MantenimientoPacientesController paciente = new MantenimientoPacientesController("pacientes.txt");
	MantenimientoCamasController cama = new MantenimientoCamasController("camas.txt");
	BuscadorPacienteInternamiento buscadorInternamiento = new BuscadorPacienteInternamiento();
	BuscadorCama buscadorCama = new BuscadorCama();
	DateFormat hourFormat = new SimpleDateFormat("HH:mm");
	DateFormat dayFormat = new SimpleDateFormat("dd/MM/yyyy");
	DecimalFormat decimalFormat = new DecimalFormat("#.00");
	
	private JPanel contentPane;
	private JLabel lblBackground;
	private JLabel btnClose;
	private JTextPane txtDesc;
	private JSeparator separator;
	private JSeparator separatorMenu;
	private JLabel lblTitulo;
	private JLabel btnPagar;
	private JLabel lblAviso;
	private JLabel lblCodPaciente;
	private JLabel lblPaciente;
	private JLabel lblInputPaciente;
	private JLabel lblFechaIngreso;
	private DefaultTableModel tabla;
	private JLabel lblCodCama;
	private JLabel lblInputCodCama;
	private JLabel btnPagarConfirm;
	private JLabel lblPagarConfirm;
	private JTextField txtCodPaciente;
	private JTextField txtPaciente;
	private JTextField txtCodCama;
	private JTextField txtFechaIngreso;
	private JTextField txtHoraIngreso;
	private JTextField txtFechaSalida;
	private JTextField txtHoraSalida;
	private JTextField txtEstado;
	private JLabel lblInputCodPaciente;
	private JLabel lblSelectCodPaciente;
	private JLabel btnSelectCodPaciente;
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
	private JLabel lblInfo;
	private JLabel lblDiasInt;
	private JTextField txtDiasInt;
	private JLabel lblBackDiasInt;
	private JTable tblTable;
	private JScrollPane scrollPane;
	private JTextArea txtInfo;
	private JScrollPane scrollPane_1;
	private JLabel lblTotalPagar;
	private JTextField txtTotalPagar;
	private JLabel lblBackTotalPagar;
	private JLabel lblPreciocama;
	private JTextField txtPrecioCama;
	private JLabel label_1;

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
					PagoInternamiento frame = new PagoInternamiento();
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
	public PagoInternamiento() {
		buscadorInternamiento.setVisible(false);
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
				btnClose.setIcon(new ImageIcon(PagoInternamiento.class.getResource("/views/images/close-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnClose.setIcon(new ImageIcon(PagoInternamiento.class.getResource("/views/images/close.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
		lblTitulo = new JLabel("Pago por d\u00EDas de internamiento");
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
		txtDesc.setText("En esta secci\u00F3n podr\u00E1s generar la boleta de pago al cancelar los servicios de la clinica a un determinado paciente.");
		txtDesc.setBounds(25, 77, this.getWidth()-50, 22);
		txtDesc.setEditable(false);
		txtDesc.setForeground(Constantes.textgray);
		contentPane.add(txtDesc);
		
		btnClose.setIcon(new ImageIcon(PagoInternamiento.class.getResource("/views/images/close.png")));
		btnClose.setBounds(this.getWidth()-25, 10, 16, 14);
		btnClose.setCursor(Constantes.pointer);
		contentPane.add(btnClose);
		
		lblBackground = new JLabel("Al ingresar, activamos la opc\u00F3n de listar por defecto.*");
		lblBackground.setBackground(Color.WHITE);
		lblBackground.setBorder(new LineBorder(Constantes.lightgray, 2));
		ImageIcon background = new ImageIcon(PagoInternamiento.class.getResource("/views/images/background-mantenimiento.png"));
		ImageIcon backfinal = new ImageIcon(background.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
		
		btnPagar = new JLabel("Pagar");
		btnPagar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPagar.setForeground(Constantes.skyblue);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPagar.setForeground(Constantes.textgray);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				changeOptionActive("Pagar");
				resetFields();
				autogenerateHoraEstado();
				hideButtons();
			}
		});
		btnPagar.setHorizontalAlignment(SwingConstants.CENTER);
		btnPagar.setFont(Constantes.regularFont);
		btnPagar.setForeground(Constantes.textgray);
		btnPagar.setBounds(496, 122, 64, 26);
		btnPagar.setCursor(Constantes.pointer);
		contentPane.add(btnPagar);
		
		lblAviso = new JLabel("* Opci\u00F3n activa: Pagar");
		lblAviso.setHorizontalAlignment(SwingConstants.LEFT);
		lblAviso.setFont(Constantes.regularFont);
		lblAviso.setBounds(25, 167, 172, 26);
		lblAviso.setForeground(Constantes.skyblue);
		contentPane.add(lblAviso);
		
		lblCodPaciente = new JLabel("C\u00F3digo de Pac.:");
		lblCodPaciente.setForeground(Constantes.textgray);
		lblCodPaciente.setFont(Constantes.regularFont);
		lblCodPaciente.setBounds(25, 217, 110, 35);
		contentPane.add(lblCodPaciente);
		
		lblPaciente = new JLabel("Paciente:");
		lblPaciente.setForeground(Constantes.textgray);
		lblPaciente.setFont(Constantes.regularFont);
		lblPaciente.setBounds(548, 217, 87, 35);
		contentPane.add(lblPaciente);
		
		lblFechaIngreso = new JLabel("Fec de ingreso:");
		lblFechaIngreso.setForeground(Constantes.textgray);
		lblFechaIngreso.setFont(Constantes.regularFont);
		lblFechaIngreso.setBounds(548, 264, 100, 35);
		contentPane.add(lblFechaIngreso);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 446, 1006, 71);
		contentPane.add(scrollPane);
		
		tblTable = new JTable();
		tblTable.setFont(Constantes.regularFont);
		tblTable.setForeground(Constantes.textgray);
		tblTable.setRowHeight(30);
		tblTable.setEnabled(false);
		scrollPane.setViewportView(tblTable);
		
		tabla = new DefaultTableModel();
		tabla.addColumn("Cód. Paciente");
		tabla.addColumn("Cód. cama");
		tabla.addColumn("Fec. ingreso");
		tabla.addColumn("Hora ingreso");
		tabla.addColumn("Fec. salida");
		tabla.addColumn("Hora salida");
		tabla.addColumn("Estado");
		tabla.addColumn("Días de Int.");
		tabla.addColumn("Precio cama");
		tabla.addColumn("Total a pagar");
		tblTable.setModel(tabla);
		
		lblPagarConfirm = new JLabel("Pagar");
		lblPagarConfirm.setFont(Constantes.regularFont);
		lblPagarConfirm.setCursor(Constantes.pointer);
		lblPagarConfirm.setForeground(Color.WHITE);
		lblPagarConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblPagarConfirm.setBounds(931, 359, 100, 34);
		lblPagarConfirm.setVisible(true);
		contentPane.add(lblPagarConfirm);
		
		btnPagarConfirm = new JLabel("");
		btnPagarConfirm.setVisible(true);
		btnPagarConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPagarConfirm.setIcon(new ImageIcon(PagoInternamiento.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPagarConfirm.setIcon(new ImageIcon(PagoInternamiento.class.getResource("/views/images/btn-login.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(txtCodPaciente.getText().contentEquals("")){
						mensaje("Elija los servicios de una paciente internado que desee pagar.");
					}
					else {
						tabla.setRowCount(0);
						Object[] data = {
							txtCodPaciente.getText(),
							txtCodCama.getText(),
							txtFechaIngreso.getText(),
							txtHoraIngreso.getText(),
							txtFechaSalida.getText(),
							txtHoraSalida.getText(),
							txtEstado.getText(),
							txtDiasInt.getText(),
							txtPrecioCama.getText(),
							txtTotalPagar.getText()
						};
						Internamiento internado = internamiento.buscarPorCodigoPaciente(txtCodPaciente.getText());
						internado.setFechaSalida("" + txtFechaSalida.getText());
						internado.setHoraSalida("" + txtHoraSalida.getText());
						internado.setEstado("Alta");
						internamiento.agregarInternamiento();
						mensaje("El pago se ha realizado de manera exitosa.");
						tabla.addRow(data);
						infoPago();
						resetFields();
						buscadorInternamiento = new BuscadorPacienteInternamiento();
					}
				}
				catch(Exception er){
					mensaje("Hubo un error en el ingreso de datos.");
				}
			}
		});
		btnPagarConfirm.setIcon(new ImageIcon(PagoInternamiento.class.getResource("/views/images/btn-login.png")));
		btnPagarConfirm.setBounds(931, 358, 100, 35);
		contentPane.add(btnPagarConfirm);
		
		txtCodPaciente = new JTextField();
		txtCodPaciente.setOpaque(false);
		txtCodPaciente.setForeground(Constantes.textgray);
		txtCodPaciente.setFont(Constantes.regularFont);
		txtCodPaciente.setEditable(false);
		txtCodPaciente.setColumns(10);
		txtCodPaciente.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtCodPaciente.setBounds(153, 215, 251, 35);
		contentPane.add(txtCodPaciente);
		
		lblInputCodPaciente = new JLabel("");
		lblInputCodPaciente.setIcon(new ImageIcon(PagoInternamiento.class.getResource("/views/images/text-ingresar.png")));
		lblInputCodPaciente.setEnabled(true);
		lblInputCodPaciente.setBounds(145, 215, 266, 35);
		contentPane.add(lblInputCodPaciente);
		
		lblSelectCodPaciente = new JLabel("Seleccionar");
		lblSelectCodPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectCodPaciente.setForeground(Color.WHITE);
		lblSelectCodPaciente.setFont(Constantes.regularFont);
		lblSelectCodPaciente.setCursor(Constantes.pointer);
		lblSelectCodPaciente.setEnabled(true);
		lblSelectCodPaciente.setBounds(421, 215, 100, 35);
		contentPane.add(lblSelectCodPaciente);
		
		buscadorInternamiento.addWindowListener(new WindowListener() {
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
				String code = buscadorInternamiento.sendCodPaciente();
				Internamiento getInternamiento = internamiento.buscarPorCodigoPaciente(code);
				Paciente getPaciente = paciente.buscarPorCodigo(code);
				txtCodPaciente.setText(getInternamiento.getCodPaciente());
				txtCodCama.setText(getInternamiento.getCodCama());
				txtPaciente.setText(getInternamiento.getNombre() + " " + getPaciente.getApellidos());
				txtFechaIngreso.setText(getInternamiento.getFechaIngreso());
				txtHoraIngreso.setText(getInternamiento.getHoraIngreso());
				txtEstado.setText("Libre");
				Cama getCama = cama.buscarPorCodigo(txtCodCama.getText());
				txtPrecioCama.setText("" + getCama.getPrecioDia());
				autogenerateHoraEstado();
				try{
					Date fechaIngreso = dayFormat.parse(txtFechaIngreso.getText());
					Date fechaSalida = dayFormat.parse(txtFechaSalida.getText());
					txtDiasInt.setText("" + diffDate(fechaIngreso, fechaSalida));
					double totalPagar = diffDate(fechaIngreso, fechaSalida) * getCama.getPrecioDia();
					if(diffDate(fechaIngreso, fechaSalida) == 0){
						txtTotalPagar.setText("S/. " + decimalFormat.format(getCama.getPrecioDia() / 2));
					}
					else {
						txtTotalPagar.setText("S/. " + decimalFormat.format(totalPagar));
					}
				}
				catch(Exception err){
					System.out.println("Error en formato de fecha: " + err);
				}
			}
			@Override
			public void windowActivated(java.awt.event.WindowEvent arg0) {
			}
		});
		
		btnSelectCodPaciente = new JLabel("");
		btnSelectCodPaciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSelectCodPaciente.setIcon(new ImageIcon(PagoInternamiento.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSelectCodPaciente.setIcon(new ImageIcon(PagoInternamiento.class.getResource("/views/images/btn-login.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				buscadorInternamiento.setVisible(true);
				String codPaciente = buscadorInternamiento.sendCodPaciente();
				txtCodPaciente.setText(codPaciente);
			}
		});
		btnSelectCodPaciente.setIcon(new ImageIcon(PagoInternamiento.class.getResource("/views/images/btn-login.png")));
		btnSelectCodPaciente.setEnabled(true);
		btnSelectCodPaciente.setBounds(421, 215, 100, 35);
		contentPane.add(btnSelectCodPaciente);
		
		txtPaciente = new JTextField();
		txtPaciente.setOpaque(false);
		txtPaciente.setForeground(Constantes.textgray);
		txtPaciente.setFont(Constantes.regularFont);
		txtPaciente.setEditable(false);
		txtPaciente.setColumns(10);
		txtPaciente.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtPaciente.setBounds(663, 217, 358, 35);
		contentPane.add(txtPaciente);
		
		lblInputPaciente = new JLabel("");
		lblInputPaciente.setIcon(new ImageIcon(PagoInternamiento.class.getResource("/views/images/input-text-large.png")));
		lblInputPaciente.setEnabled(true);
		lblInputPaciente.setBounds(655, 217, 376, 35);
		contentPane.add(lblInputPaciente);
		
		lblCodCama = new JLabel("C\u00F3digo de Cama:");
		lblCodCama.setForeground(Constantes.textgray);
		lblCodCama.setFont(Constantes.regularFont);
		lblCodCama.setBounds(25, 266, 110, 35);
		contentPane.add(lblCodCama);
		
		txtCodCama = new JTextField();
		txtCodCama.setOpaque(false);
		txtCodCama.setForeground(Constantes.textgray);
		txtCodCama.setFont(Constantes.regularFont);
		txtCodCama.setEditable(false);
		txtCodCama.setColumns(10);
		txtCodCama.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtCodCama.setBounds(153, 264, 358, 35);
		contentPane.add(txtCodCama);
		
		lblInputCodCama = new JLabel("");
		lblInputCodCama.setIcon(new ImageIcon(PagoInternamiento.class.getResource("/views/images/input-text-large.png")));
		lblInputCodCama.setEnabled(true);
		lblInputCodCama.setBounds(145, 264, 376, 35);
		contentPane.add(lblInputCodCama);
		
		lblHoraIngreso = new JLabel("Hora de ingreso:");
		lblHoraIngreso.setForeground(Constantes.textgray);
		lblHoraIngreso.setFont(Constantes.regularFont);
		lblHoraIngreso.setBounds(793, 264, 112, 35);
		contentPane.add(lblHoraIngreso);
		
		txtFechaIngreso = new JTextField();
		txtFechaIngreso.setOpaque(false);
		txtFechaIngreso.setForeground(Constantes.textgray);
		txtFechaIngreso.setFont(Constantes.regularFont);
		txtFechaIngreso.setEditable(false);
		txtFechaIngreso.setColumns(10);
		txtFechaIngreso.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtFechaIngreso.setBounds(663, 264, 115, 35);
		contentPane.add(txtFechaIngreso);
		
		lblInputFecIngreso = new JLabel("");
		lblInputFecIngreso.setIcon(new ImageIcon(PagoInternamiento.class.getResource("/views/images/input-text-short.png")));
		lblInputFecIngreso.setEnabled(false);
		lblInputFecIngreso.setBounds(655, 264, 130, 35);
		contentPane.add(lblInputFecIngreso);
		
		txtHoraIngreso = new JTextField();
		txtHoraIngreso.setOpaque(false);
		txtHoraIngreso.setForeground(Constantes.textgray);
		txtHoraIngreso.setFont(Constantes.regularFont);
		txtHoraIngreso.setEditable(false);
		txtHoraIngreso.setColumns(10);
		txtHoraIngreso.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtHoraIngreso.setBounds(909, 264, 115, 35);
		contentPane.add(txtHoraIngreso);
		
		lblInputHoraIngreso = new JLabel("");
		lblInputHoraIngreso.setIcon(new ImageIcon(PagoInternamiento.class.getResource("/views/images/input-text-short.png")));
		lblInputHoraIngreso.setEnabled(false);
		lblInputHoraIngreso.setBounds(901, 264, 130, 35);
		contentPane.add(lblInputHoraIngreso);
		
		txtEstado = new JTextField("Libre");
		txtEstado.setOpaque(false);
		txtEstado.setForeground(Constantes.textgray);
		txtEstado.setFont(Constantes.regularFont);
		txtEstado.setEditable(false);
		txtEstado.setColumns(10);
		txtEstado.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtEstado.setBounds(154, 311, 358, 35);
		contentPane.add(txtEstado);
		
		lblFechaSalida = new JLabel("Fec de salida:");
		lblFechaSalida.setForeground(Constantes.textgray);
		lblFechaSalida.setFont(Constantes.regularFont);
		lblFechaSalida.setBounds(548, 311, 87, 35);
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
		txtFechaSalida.setEnabled(true);
		txtFechaSalida.setEditable(false);
		txtFechaSalida.setColumns(10);
		txtFechaSalida.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtFechaSalida.setBounds(663, 311, 115, 35);
		contentPane.add(txtFechaSalida);
		
		lblInputFecSalida = new JLabel("");
		lblInputFecSalida.setIcon(new ImageIcon(PagoInternamiento.class.getResource("/views/images/input-text-short.png")));
		lblInputFecSalida.setEnabled(false);
		lblInputFecSalida.setBounds(655, 311, 130, 35);
		contentPane.add(lblInputFecSalida);
		
		txtHoraSalida = new JTextField();
		txtHoraSalida.setOpaque(false);
		txtHoraSalida.setForeground(Constantes.textgray);
		txtHoraSalida.setFont(Constantes.regularFont);
		txtHoraSalida.setEnabled(true);
		txtHoraSalida.setEditable(false);
		txtHoraSalida.setColumns(10);
		txtHoraSalida.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtHoraSalida.setBounds(909, 311, 115, 35);
		contentPane.add(txtHoraSalida);
		
		lblInputHoraSalida = new JLabel("");
		lblInputHoraSalida.setIcon(new ImageIcon(PagoInternamiento.class.getResource("/views/images/input-text-short.png")));
		lblInputHoraSalida.setEnabled(false);
		lblInputHoraSalida.setBounds(901, 311, 130, 35);
		contentPane.add(lblInputHoraSalida);
		
		lblEstado = new JLabel("Estado de cama:");
		lblEstado.setForeground(Constantes.textgray);
		lblEstado.setFont(Constantes.regularFont);
		lblEstado.setBounds(25, 311, 110, 35);
		contentPane.add(lblEstado);
		
		lblInputSeleccionarEstado = new JLabel("");
		lblInputSeleccionarEstado.setIcon(new ImageIcon(PagoInternamiento.class.getResource("/views/images/input-text-large.png")));
		lblInputSeleccionarEstado.setEnabled(false);
		lblInputSeleccionarEstado.setBounds(146, 311, 376, 35);
		contentPane.add(lblInputSeleccionarEstado);
		
		lblInfo = new JLabel("Boleta de pago:");
		lblInfo.setForeground(Constantes.textgray);
		lblInfo.setFont(Constantes.regularFont);
		lblInfo.setBounds(25, 418, 468, 26);
		contentPane.add(lblInfo);
		
		lblDiasInt = new JLabel("D\u00EDas de intern.:");
		lblDiasInt.setForeground(Constantes.textgray);
		lblDiasInt.setFont(Constantes.regularFont);
		lblDiasInt.setBounds(24, 359, 111, 35);
		contentPane.add(lblDiasInt);
		
		txtDiasInt = new JTextField("");
		txtDiasInt.setOpaque(false);
		txtDiasInt.setForeground(Constantes.textgray);
		txtDiasInt.setFont(Constantes.regularFont);
		txtDiasInt.setEditable(false);
		txtDiasInt.setColumns(10);
		txtDiasInt.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtDiasInt.setBounds(153, 359, 115, 35);
		contentPane.add(txtDiasInt);
		
		lblBackDiasInt = new JLabel("");
		lblBackDiasInt.setIcon(new ImageIcon(PagoInternamiento.class.getResource("/views/images/input-text-short.png")));
		lblBackDiasInt.setEnabled(false);
		lblBackDiasInt.setBounds(145, 359, 130, 35);
		contentPane.add(lblBackDiasInt);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(25, 526, 1006, 169);
		contentPane.add(scrollPane_1);
		
		txtInfo = new JTextArea();
		txtInfo.setFont(new Font("Consolas", Font.PLAIN, 12));
		txtInfo.setMargin(new Insets(12, 12, 12, 12));
		tblTable.setFont(Constantes.regularFont);
		txtInfo.setEditable(false);
		scrollPane_1.setViewportView(txtInfo);
		
		lblTotalPagar = new JLabel("Total a pagar:");
		lblTotalPagar.setForeground(new Color(68, 68, 68));
		lblTotalPagar.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		lblTotalPagar.setBounds(548, 358, 100, 35);
		contentPane.add(lblTotalPagar);
		
		txtTotalPagar = new JTextField();
		txtTotalPagar.setText("S/.");
		txtTotalPagar.setOpaque(false);
		txtTotalPagar.setForeground(new Color(68, 68, 68));
		txtTotalPagar.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		txtTotalPagar.setEnabled(true);
		txtTotalPagar.setEditable(false);
		txtTotalPagar.setColumns(10);
		txtTotalPagar.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtTotalPagar.setBounds(663, 358, 115, 35);
		contentPane.add(txtTotalPagar);
		
		lblBackTotalPagar = new JLabel("");
		lblBackTotalPagar.setIcon(new ImageIcon(PagoInternamiento.class.getResource("/views/images/input-text-short.png")));
		lblBackTotalPagar.setEnabled(false);
		lblBackTotalPagar.setBounds(655, 358, 130, 35);
		contentPane.add(lblBackTotalPagar);
		
		lblPreciocama = new JLabel("Precio de cama:");
		lblPreciocama.setForeground(new Color(68, 68, 68));
		lblPreciocama.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		lblPreciocama.setBounds(287, 359, 100, 35);
		contentPane.add(lblPreciocama);
		
		txtPrecioCama = new JTextField("S/. ");
		txtPrecioCama.setOpaque(false);
		txtPrecioCama.setForeground(new Color(68, 68, 68));
		txtPrecioCama.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		txtPrecioCama.setEditable(false);
		txtPrecioCama.setColumns(10);
		txtPrecioCama.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtPrecioCama.setBounds(399, 359, 115, 35);
		contentPane.add(txtPrecioCama);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(PagoInternamiento.class.getResource("/views/images/input-text-short.png")));
		label_1.setEnabled(false);
		label_1.setBounds(391, 359, 130, 35);
		contentPane.add(label_1);
		
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
        
	}
	
	private void mensaje(String msg){
		JOptionPane.showMessageDialog(null, msg);
	}
	
	private void resetFields(){
		txtCodPaciente.setText("");
		txtPaciente.setText("");
		txtCodCama.setText("");
		txtFechaIngreso.setText("");
		txtHoraIngreso.setText("");
		txtFechaSalida.setText("");
		txtHoraSalida.setText("");
		txtEstado.setText("");
		txtDiasInt.setText("");
		txtPrecioCama.setText("S/. ");
		txtTotalPagar.setText("S/. ");
	}
	
	private void changeOptionActive(String optionActive){
		String text = lblAviso.getText().split(":")[0];
		lblAviso.setText(text + ": " + optionActive);
	}
	
	private void hideButtons(){
		lblPagarConfirm.setVisible(false);
		btnPagarConfirm.setVisible(false);
	}
	
	private void autogenerateHoraEstado(){
		date = new Date();
		txtFechaSalida.setText("" + dayFormat.format(date));
		txtHoraSalida.setText("" + hourFormat.format(date));
	}
	
	private int diffDate(Date fechaIngreso, Date fechaSalida){
		long startTime = fechaIngreso.getTime();
		long endTime = fechaSalida.getTime();
		long diffTime = endTime - startTime;
		long diffDays = diffTime / (1000 * 60 * 60 * 24);
		return (int)diffDays;
	}
	
	private void imprimir(String info){
		txtInfo.append(info + "\n");
	}
	
	private void infoPago(){
		txtInfo.setText("");
		imprimir("CLÍNICA JUAN PABLO II");
		imprimir("Detalle de pago de internamiento:");
		imprimir("------------------------------------------------");
		imprimir("Código de paciente: " + txtCodPaciente.getText());
		imprimir("Código de cama: " + txtCodCama.getText());
		imprimir("Fecha de ingreso: " + txtFechaIngreso.getText());
		imprimir("Hora de ingreso: " + txtHoraIngreso.getText());
		imprimir("Fecha de salida:" + txtFechaSalida.getText());
		imprimir("Hora de salida: " + txtHoraSalida.getText());
		imprimir("Estado de cama: " + txtEstado.getText());
		imprimir("Días de internamiento: " + txtDiasInt.getText());
		imprimir("Precio de cama por día: " + txtPrecioCama.getText());
		imprimir("------------------------------------------------");
		imprimir("Total a pagar: " + txtTotalPagar.getText());
	}
	
}
