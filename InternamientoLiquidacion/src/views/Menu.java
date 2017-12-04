package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import constantes.Constantes;
import controllers.LoginController;
import controllers.MantenimientoEmpleadosController;

public class Menu extends JFrame {
	
	MantenimientoPacientes mantenimientoPacientes = new MantenimientoPacientes();
	MantenimientoMedicinas mantenimientoMedicinas = new MantenimientoMedicinas();
	MantenimientoCamas mantenimientoCamas = new MantenimientoCamas();
	MantenimientoEmpleados mantenimientoEmpleados = new MantenimientoEmpleados();
	InternamientoPacientes internamientoPacientes = new InternamientoPacientes();
	MantenimientoEmpleadosController empleados = new MantenimientoEmpleadosController("empleados.txt");
	AtencionMedicinas atencionMedicinas = new AtencionMedicinas();
	PagoMedicinas pagoMedicinas = new PagoMedicinas();
	PagoInternamiento pagoInternamiento = new PagoInternamiento();
	ReportePacientesInternados reportePacientes = new ReportePacientesInternados();
	ReporteInternamientosPagados reporteInternamientos = new ReporteInternamientosPagados();
	ReporteAtencionesPagadas reporteAtenciones = new ReporteAtencionesPagadas();
	
	private JPanel contentPane;
	private JLabel btnClose;
	private JLabel lblBackground;
	private JTextPane lblBienvenido;
	private JLabel lblMantenimiento;
	private JLabel btnMantPacientes;
	private JLabel arrowMantPaciente;
	private JLabel btnMantMedicinas;
	private JLabel arrowMantMedicina;
	private JLabel arrowMantCamas;
	private JLabel btnMantCamas;
	private JLabel lblInternamiento;
	private JLabel arrowIntPacientes;
	private JLabel btnIntPacientes;
	private JLabel lblAtencion;
	private JLabel arrowAtMedicina;
	private JLabel btnAtMedicinas;
	private JLabel lblPagos;
	private JLabel arrowPagoMedicina;
	private JLabel btnPagoMedicinas;
	private JLabel arrowPagoDias;
	private JLabel btnPagoDias;
	private JLabel btnReporte;
	private JLabel btnCerrarSesion;
	private JLabel btnMantEmpleados;
	private JLabel label_1;
	private String user;
	
	JFrame[] views = new JFrame[]{
		mantenimientoPacientes,
		mantenimientoMedicinas,
		mantenimientoCamas,
		mantenimientoEmpleados,
		internamientoPacientes,
		atencionMedicinas,
		pagoMedicinas,
		pagoInternamiento,
		reportePacientes,
		reporteInternamientos,
		reporteAtenciones
	};
	private JLabel btnReporteInter;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel btnReportePacientes;
	private JLabel label_5;
	private JLabel btnReporteAtencion;
	
	public void hideViews(){
		for(int i = 0; i < views.length; i++){
			views[i].setVisible(false);
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setBackground(Color.WHITE);
		hideViews();
		LoginController login = new LoginController("userLoged.txt");
		
		lblBienvenido = new JTextPane();
		user = login.nameUser();
		lblBienvenido.setText("Bienvenido(a) " + user + ", por favor escoge una opción para continuar.");
		
		// Obtener el tamaño de la pantalla
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int ySize = ((int) toolkit.getScreenSize().getHeight());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 310, ySize-50);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnClose = new JLabel("");
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnClose.setIcon(new ImageIcon(Menu.class.getResource("/views/images/close-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnClose.setIcon(new ImageIcon(Menu.class.getResource("/views/images/close.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
		lblPagos = new JLabel("Pagos");
		lblPagos.setForeground(new Color(59, 138, 191));
		lblPagos.setFont(Constantes.boldFont);
		lblPagos.setBounds(26, 387, 143, 19);
		contentPane.add(lblPagos);
		
		arrowPagoMedicina = new JLabel("");
		arrowPagoMedicina.setIcon(new ImageIcon(Menu.class.getResource("/views/images/arrow-menu.png")));
		arrowPagoMedicina.setBounds(36, 418, 10, 14);
		contentPane.add(arrowPagoMedicina);
		
		btnPagoMedicinas = new JLabel("Pago de medicinas");
		btnPagoMedicinas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hideViews();
				pagoMedicinas.setVisible(true);
			}
		});
		btnPagoMedicinas.setForeground(Constantes.textgray);
		btnPagoMedicinas.setCursor(Constantes.pointer);
		btnPagoMedicinas.setFont(Constantes.regularFont);
		btnPagoMedicinas.setBounds(50, 417, 136, 19);
		contentPane.add(btnPagoMedicinas);
		
		arrowPagoDias = new JLabel("");
		arrowPagoDias.setIcon(new ImageIcon(Menu.class.getResource("/views/images/arrow-menu.png")));
		arrowPagoDias.setBounds(36, 444, 10, 14);
		contentPane.add(arrowPagoDias);
		
		btnPagoDias = new JLabel("Pago por d\u00EDas de internamiento");
		btnPagoDias.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hideViews();
				pagoInternamiento.setVisible(true);
			}
		});
		btnPagoDias.setForeground(Constantes.textgray);
		btnPagoDias.setCursor(Constantes.pointer);
		btnPagoDias.setFont(Constantes.regularFont);
		btnPagoDias.setBounds(50, 443, 204, 19);
		contentPane.add(btnPagoDias);
		
		lblAtencion = new JLabel("Atenci\u00F3n");
		lblAtencion.setForeground(Constantes.skyblue);
		lblAtencion.setFont(Constantes.boldFont);
		lblAtencion.setBounds(26, 317, 143, 19);
		contentPane.add(lblAtencion);
		
		arrowAtMedicina = new JLabel("");
		arrowAtMedicina.setIcon(new ImageIcon(Menu.class.getResource("/views/images/arrow-menu.png")));
		arrowAtMedicina.setBounds(44, 348, 10, 14);
		contentPane.add(arrowAtMedicina);
		
		btnAtMedicinas = new JLabel("Medicinas solicitadas");
		btnAtMedicinas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				hideViews();
				atencionMedicinas.setVisible(true);
			}
		});
		btnAtMedicinas.setForeground(Constantes.textgray);
		btnAtMedicinas.setCursor(Constantes.pointer);
		btnAtMedicinas.setFont(Constantes.regularFont);
		btnAtMedicinas.setBounds(58, 347, 136, 19);
		contentPane.add(btnAtMedicinas);
		
		arrowIntPacientes = new JLabel("");
		arrowIntPacientes.setIcon(new ImageIcon(Menu.class.getResource("/views/images/arrow-menu.png")));
		arrowIntPacientes.setBounds(44, 278, 10, 14);
		contentPane.add(arrowIntPacientes);
		
		btnIntPacientes = new JLabel("Int. de pacientes");
		btnIntPacientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hideViews();
				internamientoPacientes.setVisible(true);
			}
		});
		btnIntPacientes.setForeground(Constantes.textgray);
		btnIntPacientes.setCursor(Constantes.pointer);
		btnIntPacientes.setFont(Constantes.regularFont);
		btnIntPacientes.setBounds(58, 277, 136, 19);
		contentPane.add(btnIntPacientes);
		
		lblInternamiento = new JLabel("Internamiento");
		lblInternamiento.setForeground(new Color(59, 138, 191));
		lblInternamiento.setFont(Constantes.boldFont);
		lblInternamiento.setBounds(26, 247, 143, 19);
		contentPane.add(lblInternamiento);
		
		arrowMantCamas = new JLabel("");
		arrowMantCamas.setIcon(new ImageIcon(Menu.class.getResource("/views/images/arrow-menu.png")));
		arrowMantCamas.setBounds(44, 183, 10, 14);
		contentPane.add(arrowMantCamas);
		
		btnMantCamas = new JLabel("Mant. de camas");
		btnMantCamas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				hideViews();
				mantenimientoCamas.setVisible(true);
			}
		});
		btnMantCamas.setForeground(Constantes.textgray);
		btnMantCamas.setCursor(Constantes.pointer);
		btnMantCamas.setFont(Constantes.regularFont);
		btnMantCamas.setBounds(58, 182, 136, 19);
		contentPane.add(btnMantCamas);
		
		btnMantMedicinas = new JLabel("Mant. de medicinas");
		btnMantMedicinas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				hideViews();
				mantenimientoMedicinas.setVisible(true);
			}
		});
		btnMantMedicinas.setForeground(Constantes.textgray);
		btnMantMedicinas.setCursor(Constantes.pointer);
		btnMantMedicinas.setFont(Constantes.regularFont);
		btnMantMedicinas.setBounds(58, 156, 136, 19);
		contentPane.add(btnMantMedicinas);
		
		arrowMantMedicina = new JLabel("");
		arrowMantMedicina.setIcon(new ImageIcon(Menu.class.getResource("/views/images/arrow-menu.png")));
		arrowMantMedicina.setBounds(44, 157, 10, 14);
		contentPane.add(arrowMantMedicina);
		
		arrowMantPaciente = new JLabel("");
		arrowMantPaciente.setIcon(new ImageIcon(Menu.class.getResource("/views/images/arrow-menu.png")));
		arrowMantPaciente.setBounds(44, 131, 10, 14);
		contentPane.add(arrowMantPaciente);
		
		btnMantPacientes = new JLabel("Mant. de pacientes");
		btnMantPacientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				hideViews();
				mantenimientoPacientes.setVisible(true);
			}
		});
		btnMantPacientes.setForeground(Constantes.textgray);
		btnMantPacientes.setCursor(Constantes.pointer);
		btnMantPacientes.setFont(Constantes.regularFont);
		btnMantPacientes.setBounds(58, 130, 136, 19);
		contentPane.add(btnMantPacientes);
		
		lblMantenimiento = new JLabel("Mantenimiento");
		lblMantenimiento.setFont(Constantes.boldFont);
		lblMantenimiento.setForeground(Constantes.skyblue);
		lblMantenimiento.setBounds(26, 100, 143, 19);
		contentPane.add(lblMantenimiento);
		
		lblBienvenido.setOpaque(false);
		lblBienvenido.setFont(Constantes.regularFont);
		lblBienvenido.setBounds(26, 42, 260, 38);
		lblBienvenido.setForeground(Constantes.textgray);
		lblBienvenido.setEditable(false);
		contentPane.add(lblBienvenido);
		btnClose.setCursor(Constantes.pointer);
		btnClose.setIcon(new ImageIcon(Menu.class.getResource("/views/images/close.png")));
		btnClose.setBounds(284, 11, 16, 14);
		contentPane.add(btnClose);
		
		btnReporte = new JLabel("Reporte");
		btnReporte.setForeground(new Color(59, 138, 191));
		btnReporte.setFont(Constantes.boldFont);
		btnReporte.setBounds(26, 480, 143, 19);
		contentPane.add(btnReporte);
		
		btnCerrarSesion = new JLabel("Cerrar sesi\u00F3n");
		btnCerrarSesion.setCursor(Constantes.pointer);
		btnCerrarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnCerrarSesion.setForeground(new Color(59, 138, 191));
		btnCerrarSesion.setFont(Constantes.boldFont);
		btnCerrarSesion.setBounds(26, 600, 143, 19);
		contentPane.add(btnCerrarSesion);
		
		btnMantEmpleados = new JLabel("Mant. de empleados");
		btnMantEmpleados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				hideViews();
				mantenimientoEmpleados.setVisible(true);
			}
		});
		btnMantEmpleados.setForeground(Constantes.textgray);
		btnMantEmpleados.setFont(Constantes.regularFont);
		btnMantEmpleados.setCursor(Constantes.pointer);
		btnMantEmpleados.setBounds(58, 208, 136, 19);
		contentPane.add(btnMantEmpleados);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Menu.class.getResource("/views/images/arrow-menu.png")));
		label_1.setBounds(44, 209, 10, 14);
		contentPane.add(label_1);
		
		btnReporteInter = new JLabel("Reporte de internamientos");
		btnReporteInter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				hideViews();
				reporteInternamientos.setVisible(true);
			}
		});
		btnReporteInter.setCursor(Constantes.pointer);
		btnReporteInter.setForeground(Constantes.textgray);
		btnReporteInter.setFont(Constantes.regularFont);
		btnReporteInter.setBounds(50, 534, 204, 19);
		contentPane.add(btnReporteInter);
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Menu.class.getResource("/views/images/arrow-menu.png")));
		label_2.setBounds(36, 535, 10, 14);
		contentPane.add(label_2);
		
		label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Menu.class.getResource("/views/images/arrow-menu.png")));
		label_3.setBounds(36, 509, 10, 14);
		contentPane.add(label_3);
		
		btnReportePacientes = new JLabel("Reporte de pacientes");
		btnReportePacientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				hideViews();
				reportePacientes.setVisible(true);
			}
		});
		btnReportePacientes.setCursor(Constantes.pointer);
		btnReportePacientes.setForeground(Constantes.textgray);
		btnReportePacientes.setFont(Constantes.regularFont);
		btnReportePacientes.setBounds(50, 508, 155, 19);
		contentPane.add(btnReportePacientes);
		
		label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(Menu.class.getResource("/views/images/arrow-menu.png")));
		label_5.setBounds(36, 561, 10, 14);
		contentPane.add(label_5);
		
		btnReporteAtencion = new JLabel("Reporte de atenciones");
		btnReporteAtencion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				hideViews();
				reporteAtenciones.setVisible(true);
			}
		});
		btnReporteAtencion.setCursor(Constantes.pointer);
		btnReporteAtencion.setForeground(Constantes.textgray);
		btnReporteAtencion.setFont(Constantes.regularFont);
		btnReporteAtencion.setBounds(50, 560, 183, 19);
		contentPane.add(btnReporteAtencion);
		
		lblBackground = new JLabel("");
		lblBackground.setBackground(Color.WHITE);
		lblBackground.setFont(Constantes.boldFont);
		lblBackground.setBorder(new LineBorder(Constantes.lightgray, 2));
		lblBackground.setIcon(new ImageIcon(Menu.class.getResource("/views/images/background-menu.png")));
		lblBackground.setBounds(0, 0, 310, ySize-50);
		contentPane.add(lblBackground);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		//Ubicar la barra de menú en la parte superior izquierda de la pantalla
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMinX();
        int y = (int) rect.getMinY();
        setLocation(x, y);
        setVisible(true);
        
	}
	
	private void mensaje(String msg){
		JOptionPane.showMessageDialog(null, msg);
	}
}
