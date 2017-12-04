
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
import java.util.ArrayList;
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
import controllers.InternamientoPacientesController;
import controllers.MantenimientoMedicinasController;
import controllers.MantenimientoPacientesController;
import models.Atencion;
import models.DetalleAtencion;
import models.Medicina;
import models.Paciente;

public class PagoMedicinas extends JFrame {

	Constantes constantes = new Constantes();
	InternamientoPacientesController internamiento = new InternamientoPacientesController("internamiento.txt");
	MantenimientoPacientesController paciente = new MantenimientoPacientesController("pacientes.txt");
	AtencionController atencion = new AtencionController("atencion.txt");
	DetalleAtencionController detalleAtencion = new DetalleAtencionController("detalle.txt");
	MantenimientoMedicinasController medicina = new MantenimientoMedicinasController("medicinas.txt");
	BuscadorAtencion buscadorAtencion = new BuscadorAtencion();
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
	private JLabel lblCodAtencion;
	private JLabel lblCodPaciente;
	private JLabel lblInputPaciente;
	private DefaultTableModel tabla;
	private JLabel lblPaciente;
	private JLabel lblInputCodCama;
	private JLabel btnPagarConfirm;
	private JLabel lblPagarConfirm;
	private JTextField txtCodAtencion;
	private JTextField txtCodPaciente;
	private JTextField txtPaciente;
	private JTextField txtEstado;
	private JLabel lblInputCodPaciente;
	private JLabel lblSelectCodPaciente;
	private JLabel btnSelectCodPaciente;
	private JLabel lblEstado;
	private JLabel lblInputSeleccionarEstado;
	private Date date;
	private JLabel lblInfo;
	private JTable tblTable;
	private JScrollPane scrollPane;
	private JTextArea txtInfo;
	private JScrollPane scrollPane_1;
	private JLabel lblTotalPagar;
	private JTextField txtTotalPagar;
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
					PagoMedicinas frame = new PagoMedicinas();
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
	public PagoMedicinas() {
		buscadorAtencion.setVisible(false);
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
				btnClose.setIcon(new ImageIcon(PagoMedicinas.class.getResource("/views/images/close-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnClose.setIcon(new ImageIcon(PagoMedicinas.class.getResource("/views/images/close.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
		lblTitulo = new JLabel("Pago por medicinas");
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
		
		btnClose.setIcon(new ImageIcon(PagoMedicinas.class.getResource("/views/images/close.png")));
		btnClose.setBounds(this.getWidth()-25, 10, 16, 14);
		btnClose.setCursor(Constantes.pointer);
		contentPane.add(btnClose);
		
		lblBackground = new JLabel("Al ingresar, activamos la opc\u00F3n de listar por defecto.*");
		lblBackground.setBackground(Color.WHITE);
		lblBackground.setBorder(new LineBorder(Constantes.lightgray, 2));
		ImageIcon background = new ImageIcon(PagoMedicinas.class.getResource("/views/images/background-mantenimiento.png"));
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
		
		lblCodAtencion = new JLabel("C\u00F3digo de Ate.:");
		lblCodAtencion.setForeground(Constantes.textgray);
		lblCodAtencion.setFont(Constantes.regularFont);
		lblCodAtencion.setBounds(25, 217, 110, 35);
		contentPane.add(lblCodAtencion);
		
		lblCodPaciente = new JLabel("C\u00F3digo de Pac.:");
		lblCodPaciente.setForeground(Constantes.textgray);
		lblCodPaciente.setFont(Constantes.regularFont);
		lblCodPaciente.setBounds(548, 217, 97, 35);
		contentPane.add(lblCodPaciente);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 398, 1006, 119);
		contentPane.add(scrollPane);
		
		tblTable = new JTable();
		tblTable.setFont(Constantes.regularFont);
		tblTable.setForeground(Constantes.textgray);
		tblTable.setRowHeight(30);
		tblTable.setEnabled(false);
		scrollPane.setViewportView(tblTable);
		
		tabla = new DefaultTableModel();
		tabla.addColumn("Cód. Medicina");
		tabla.addColumn("Cantidad");
		tabla.addColumn("Precio unitario");
		tabla.addColumn("Precio a pagar");
		tblTable.setModel(tabla);
		
		lblPagarConfirm = new JLabel("Pagar");
		lblPagarConfirm.setFont(Constantes.regularFont);
		lblPagarConfirm.setCursor(Constantes.pointer);
		lblPagarConfirm.setForeground(Color.WHITE);
		lblPagarConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblPagarConfirm.setBounds(931, 312, 100, 34);
		lblPagarConfirm.setVisible(true);
		contentPane.add(lblPagarConfirm);
		
		btnPagarConfirm = new JLabel("");
		btnPagarConfirm.setVisible(true);
		btnPagarConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPagarConfirm.setIcon(new ImageIcon(PagoMedicinas.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPagarConfirm.setIcon(new ImageIcon(PagoMedicinas.class.getResource("/views/images/btn-login.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(txtCodAtencion.getText().contentEquals("")){
						mensaje("Elija los servicios de una paciente internado que desee pagar.");
					}
					else {
						String code = buscadorAtencion.sendCodAtencion();
						Atencion getAtencion = atencion.buscarPorCodigo(code);
						Paciente getPaciente = paciente.buscarPorCodigo(getAtencion.getCodPaciente());
						ArrayList<DetalleAtencion> lista = detalleAtencion.buscarPorCodigoAtencion(code);
						getAtencion.setEstado(txtEstado.getText());
						atencion.guardarAtencion();
						mensaje("El pago se ha realizado de manera exitosa.");
						resetFields();
						txtInfo.setText("");
						
						imprimir("CLÍNICA JUAN PABLO II");
						imprimir("Detalle de pago de medicinas:");
						imprimir("------------------------------------------------");
						imprimir("Código de atención: " + getAtencion.getCodAtencion());
						imprimir("Codigo de paciente: " + getAtencion.getCodPaciente());
						imprimir("Paciente: " + getPaciente.getNombres() + " " + getPaciente.getApellidos());
						imprimir("Estado: " + getAtencion.getEstado());
						imprimir("------------------------------------------------");
						imprimir("Detalle de medicinas: ");
						imprimir("------------------------------------------------");
						for(int i = 0; i < lista.size(); i++){
							Medicina getMedicina = medicina.buscarPorCodigo(lista.get(i).getCodMedicina());
							imprimir("Medicina: " + (i+1) + ":");
							imprimir("Código de medicina: " + getMedicina.getCodMedicina());
							imprimir("Nombre de medicina: " + getMedicina.getNombre());
							imprimir("Precio unitario: " + getMedicina.getPrecio());
							imprimir("Cantidad: " + lista.get(i).getCantidad());
							imprimir("Precio por medicina: " + lista.get(i).getTotalPagar());
							imprimir("------------------------------------------------");
						}
						imprimir("Total a pagar: " + txtTotalPagar.getText());
						buscadorAtencion = new BuscadorAtencion();
					}
				}
				catch(Exception er){
					mensaje("Hubo un error en el ingreso de datos.");
				}
			}
		});
		btnPagarConfirm.setIcon(new ImageIcon(PagoMedicinas.class.getResource("/views/images/btn-login.png")));
		btnPagarConfirm.setBounds(931, 311, 100, 35);
		contentPane.add(btnPagarConfirm);
		
		txtCodAtencion = new JTextField();
		txtCodAtencion.setOpaque(false);
		txtCodAtencion.setForeground(Constantes.textgray);
		txtCodAtencion.setFont(Constantes.regularFont);
		txtCodAtencion.setEditable(false);
		txtCodAtencion.setColumns(10);
		txtCodAtencion.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtCodAtencion.setBounds(153, 215, 251, 35);
		contentPane.add(txtCodAtencion);
		
		lblInputCodPaciente = new JLabel("");
		lblInputCodPaciente.setIcon(new ImageIcon(PagoMedicinas.class.getResource("/views/images/text-ingresar.png")));
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
		
		buscadorAtencion.addWindowListener(new WindowListener() {
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
				String code = buscadorAtencion.sendCodAtencion();
				Atencion getAtencion = atencion.buscarPorCodigo(code);
				Paciente getPaciente = paciente.buscarPorCodigo(getAtencion.getCodPaciente());
				ArrayList<DetalleAtencion> lista = detalleAtencion.buscarPorCodigoAtencion(code);
				txtCodAtencion.setText(getAtencion.getCodAtencion());
				txtCodPaciente.setText(getAtencion.getCodPaciente());
				txtPaciente.setText(getPaciente.getNombres() + " " + getPaciente.getApellidos());
				txtTotalPagar.setText("S/. " + getAtencion.getTotalPagar());
				tabla.setRowCount(0);
				for(int i = 0; i < lista.size(); i++){
					Object data[] = {
						lista.get(i).getCodMedicina(),
						lista.get(i).getCantidad(),
						lista.get(i).getPrecioUnitario(),
						lista.get(i).getTotalPagar()
					};
					tabla.addRow(data);
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
				btnSelectCodPaciente.setIcon(new ImageIcon(PagoMedicinas.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSelectCodPaciente.setIcon(new ImageIcon(PagoMedicinas.class.getResource("/views/images/btn-login.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				buscadorAtencion.setVisible(true);
			}
		});
		btnSelectCodPaciente.setIcon(new ImageIcon(PagoMedicinas.class.getResource("/views/images/btn-login.png")));
		btnSelectCodPaciente.setEnabled(true);
		btnSelectCodPaciente.setBounds(421, 215, 100, 35);
		contentPane.add(btnSelectCodPaciente);
		
		txtCodPaciente = new JTextField();
		txtCodPaciente.setOpaque(false);
		txtCodPaciente.setForeground(Constantes.textgray);
		txtCodPaciente.setFont(Constantes.regularFont);
		txtCodPaciente.setEditable(false);
		txtCodPaciente.setColumns(10);
		txtCodPaciente.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtCodPaciente.setBounds(663, 217, 358, 35);
		contentPane.add(txtCodPaciente);
		
		lblInputPaciente = new JLabel("");
		lblInputPaciente.setIcon(new ImageIcon(PagoMedicinas.class.getResource("/views/images/input-text-large.png")));
		lblInputPaciente.setEnabled(true);
		lblInputPaciente.setBounds(655, 217, 376, 35);
		contentPane.add(lblInputPaciente);
		
		lblPaciente = new JLabel("Paciente:");
		lblPaciente.setForeground(Constantes.textgray);
		lblPaciente.setFont(Constantes.regularFont);
		lblPaciente.setBounds(25, 266, 110, 35);
		contentPane.add(lblPaciente);
		
		txtPaciente = new JTextField();
		txtPaciente.setOpaque(false);
		txtPaciente.setForeground(Constantes.textgray);
		txtPaciente.setFont(Constantes.regularFont);
		txtPaciente.setEditable(false);
		txtPaciente.setColumns(10);
		txtPaciente.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtPaciente.setBounds(153, 264, 358, 35);
		contentPane.add(txtPaciente);
		
		lblInputCodCama = new JLabel("");
		lblInputCodCama.setIcon(new ImageIcon(PagoMedicinas.class.getResource("/views/images/input-text-large.png")));
		lblInputCodCama.setEnabled(true);
		lblInputCodCama.setBounds(145, 264, 376, 35);
		contentPane.add(lblInputCodCama);
		
		txtEstado = new JTextField("Pagado");
		txtEstado.setOpaque(false);
		txtEstado.setForeground(Constantes.textgray);
		txtEstado.setFont(Constantes.regularFont);
		txtEstado.setEditable(false);
		txtEstado.setColumns(10);
		txtEstado.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtEstado.setBounds(663, 264, 358, 35);
		contentPane.add(txtEstado);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setForeground(Constantes.textgray);
		lblEstado.setFont(Constantes.regularFont);
		lblEstado.setBounds(548, 264, 87, 35);
		contentPane.add(lblEstado);
		
		lblInputSeleccionarEstado = new JLabel("");
		lblInputSeleccionarEstado.setIcon(new ImageIcon(PagoMedicinas.class.getResource("/views/images/input-text-large.png")));
		lblInputSeleccionarEstado.setEnabled(false);
		lblInputSeleccionarEstado.setBounds(655, 264, 376, 35);
		contentPane.add(lblInputSeleccionarEstado);
		
		lblInfo = new JLabel("Boleta de pago:");
		lblInfo.setForeground(Constantes.textgray);
		lblInfo.setFont(Constantes.regularFont);
		lblInfo.setBounds(25, 371, 468, 26);
		contentPane.add(lblInfo);
		
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
		lblTotalPagar.setBounds(25, 312, 110, 35);
		contentPane.add(lblTotalPagar);
		
		txtTotalPagar = new JTextField("S/. ");
		txtTotalPagar.setOpaque(false);
		txtTotalPagar.setForeground(new Color(68, 68, 68));
		txtTotalPagar.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		txtTotalPagar.setEditable(false);
		txtTotalPagar.setColumns(10);
		txtTotalPagar.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtTotalPagar.setBounds(153, 311, 358, 35);
		contentPane.add(txtTotalPagar);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(PagoMedicinas.class.getResource("/views/images/input-text-large.png")));
		label_1.setEnabled(false);
		label_1.setBounds(145, 311, 376, 35);
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
		txtCodAtencion.setText("");
		txtCodPaciente.setText("");
		txtPaciente.setText("");
		txtEstado.setText("");
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
	
	private void imprimir(String info){
		txtInfo.append(info + "\n");
	}
}
