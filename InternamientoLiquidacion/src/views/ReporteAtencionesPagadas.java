package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
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
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import constantes.Constantes;
import controllers.AtencionController;
import controllers.InternamientoPacientesController;
import controllers.MantenimientoPacientesController;
import models.Atencion;

public class ReporteAtencionesPagadas extends JFrame {

	MantenimientoPacientesController paciente = new MantenimientoPacientesController("pacientes.txt");
	InternamientoPacientesController internamiento = new InternamientoPacientesController("internamiento.txt");
	AtencionController atencion = new AtencionController("atencion.txt");
	DecimalFormat decimalFormat = new DecimalFormat("#.00");
	
	private JPanel contentPane;
	private JLabel lblBackground;
	private JLabel btnClose;
	private JTextPane txtDesc;
	private JSeparator separator;
	private JSeparator separatorMenu;
	private JLabel lblTitulo;
	private JLabel btnListar;
	private JLabel btnConsultar;
	private JLabel lblInputBuscar;
	private JLabel lblBuscarPor;
	private JLabel lblInputIngresar;
	private JLabel lblIngresar;
	private JLabel btnBuscar;
	private JLabel lblBuscar;
	private JLabel lblAviso;
	private JTextField txtBuscar;
	private JTextField txtIngresar;
	private JTable table;
	private JScrollPane tblTabla;
	private DefaultTableModel tabla;
	private JScrollPane scrollPane;
	private JLabel arrowBuscarPor;
	private JLabel cboBackground;
	private JLabel btnSeleccionar;
	private JLabel btnCodigoAtencion;
	private JLabel btnCodPaciente;
	private JPanel cboBuscarPor;

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
					ReporteAtencionesPagadas frame = new ReporteAtencionesPagadas();
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
	public ReporteAtencionesPagadas() {
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
				btnClose.setIcon(new ImageIcon(ReporteAtencionesPagadas.class.getResource("/views/images/close-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnClose.setIcon(new ImageIcon(ReporteAtencionesPagadas.class.getResource("/views/images/close.png")));
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
		
		btnCodigoAtencion = new JLabel("C\u00F3digo de atenci\u00F3n");
		btnCodigoAtencion.setBackground(Color.WHITE);
		btnCodigoAtencion.setCursor(Constantes.pointer);
		btnCodigoAtencion.setBounds(1, 41, 198, 30);
		btnCodigoAtencion.setOpaque(true);
		cboBuscarPor.add(btnCodigoAtencion);
		btnCodigoAtencion.setForeground(new Color(68, 68, 68));
		btnCodigoAtencion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCodigoAtencion.setBackground(Constantes.hoverFont);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCodigoAtencion.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				txtBuscar.setText(btnCodigoAtencion.getText());
				cboBuscarPor.setVisible(false);
				getCboBuscarPor();
			}
		});
		btnCodigoAtencion.setFont(Constantes.regularFont);
		btnCodigoAtencion.setBorder(new EmptyBorder(0, 10, 0, 10));
		
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
				getCboBuscarPor();
			}
		});
		btnCodPaciente.setOpaque(true);
		btnCodPaciente.setBounds(1, 72, 198, 30);
		cboBuscarPor.add(btnCodPaciente);
		btnCodPaciente.setForeground(new Color(68, 68, 68));
		btnCodPaciente.setFont(Constantes.regularFont);
		btnCodPaciente.setBorder(new EmptyBorder(0, 10, 0, 10));
		
		cboBackground = new JLabel("");
		cboBackground.setBorder(new EmptyBorder(0, 0, 0, 0));
		cboBackground.setBounds(0, 0, 200, 150);
		cboBuscarPor.add(cboBackground);
		cboBackground.setIcon(new ImageIcon(ReporteAtencionesPagadas.class.getResource("/views/images/contenedor-combo.png")));
		
		lblTitulo = new JLabel("Reporte de Atenciones Pagadas");
		lblTitulo.setFont(Constantes.boldFont);
		lblTitulo.setForeground(Constantes.skyblue);
		lblTitulo.setBounds(25, 40, 292, 26);
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
		txtDesc.setText("En esta secci\u00F3n podras visualizar los registros de atenciones que se encuentran pagadas.");
		txtDesc.setBounds(25, 77, this.getWidth()-50, 22);
		txtDesc.setEditable(false);
		txtDesc.setForeground(Constantes.textgray);
		contentPane.add(txtDesc);
		
		btnClose.setIcon(new ImageIcon(ReporteAtencionesPagadas.class.getResource("/views/images/close.png")));
		btnClose.setBounds(this.getWidth()-25, 10, 16, 14);
		btnClose.setCursor(Constantes.pointer);
		contentPane.add(btnClose);
		
		lblBackground = new JLabel("Al ingresar, activamos la opc\u00F3n de listar por defecto.*");
		lblBackground.setBackground(Color.WHITE);
		lblBackground.setBorder(new LineBorder(Constantes.lightgray, 2));
		ImageIcon background = new ImageIcon(ReporteAtencionesPagadas.class.getResource("/views/images/background-mantenimiento.png"));
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
				txtIngresar.setText("");
				
				listarAtenciones();
			}
		});
		
		arrowBuscarPor = new JLabel("");
		arrowBuscarPor.setIcon(new ImageIcon(ReporteAtencionesPagadas.class.getResource("/views/images/ico-down.png")));
		arrowBuscarPor.setCursor(Constantes.pointer);
		arrowBuscarPor.setBounds(307, 222, 10, 14);
		
		contentPane.add(arrowBuscarPor);
		btnListar.setHorizontalAlignment(SwingConstants.CENTER);
		btnListar.setFont(Constantes.regularFont);
		btnListar.setForeground(Constantes.textgray);
		btnListar.setCursor(Constantes.pointer);
		btnListar.setBounds(376, 124, 64, 26);
		contentPane.add(btnListar);
		
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
				
				resetFields();
			}
		});
		btnConsultar.setHorizontalAlignment(SwingConstants.CENTER);
		btnConsultar.setFont(Constantes.regularFont);
		btnConsultar.setForeground(Constantes.textgray);
		btnConsultar.setBounds(649, 124, 64, 26);
		btnConsultar.setCursor(Constantes.pointer);
		contentPane.add(btnConsultar);
		btnListar.setForeground(Constantes.textgray);
		
		txtIngresar = new JTextField();
		txtIngresar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0){
				int cboSelect = getCboBuscarPor();
				if(cboSelect == 0){
					mensaje("Asegurese de haber seleccionado un filtro e ingresado un término de búsqueda.");
				}
				else {
					if(txtIngresar.getText().length() == 6){
						arg0.consume();
					}
				}
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				int cboSelect = getCboBuscarPor();
				if(cboSelect == 0){
					mensaje("Asegurese de haber seleccionado un filtro e ingresado un término de búsqueda.");
				}
				else {
					String term = getBusquedaCodigo();
					if(cboSelect == 1){
						ArrayList<Atencion> buscarAtencion = atencion.listAtencionesPagadasCodAtencion(term);
						if(buscarAtencion != null){
							tabla.setRowCount(0);
							for(int i = 0; i < buscarAtencion.size(); i++){
								Object[] data = {
									buscarAtencion.get(i).getCodAtencion(),
									buscarAtencion.get(i).getCodPaciente(),
									buscarAtencion.get(i).getFechaAtencion(),
									decimalFormat.format(buscarAtencion.get(i).getTotalPagar())
								};
								tabla.addRow(data);
							}
						}
						else {
							mensaje("No hay registros de atenciones con este código.");
						}
					}
					if(cboSelect == 2){
						ArrayList<Atencion> buscarAtencion = atencion.listAtencionesPagadasCodPaciente(term);
						if(buscarAtencion != null){
							tabla.setRowCount(0);
							for(int i = 0; i < buscarAtencion.size(); i++){
								Object[] data = {
									buscarAtencion.get(i).getCodAtencion(),
									buscarAtencion.get(i).getCodPaciente(),
									buscarAtencion.get(i).getFechaAtencion(),
									decimalFormat.format(buscarAtencion.get(i).getTotalPagar())
								};
								tabla.addRow(data);
							}
						}
						else {
							mensaje("No hay registros de atenciones con este código.");
						}
					}
				}
			}
		});
		txtIngresar.setEnabled(false);
		txtIngresar.setEditable(false);
		txtIngresar.setOpaque(false);
		txtIngresar.setColumns(10);
		txtIngresar.setForeground(new Color(68, 68, 68));
		txtIngresar.setFont(Constantes.regularFont);
		txtIngresar.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtIngresar.setBounds(663, 212, 251, 35);
		contentPane.add(txtIngresar);
		
		btnBuscar = new JLabel("");
		btnBuscar.setEnabled(false);
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBuscar.setIcon(new ImageIcon(ReporteAtencionesPagadas.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBuscar.setIcon(new ImageIcon(ReporteAtencionesPagadas.class.getResource("/views/images/btn-login.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		lblBuscar = new JLabel("Buscar");
		lblBuscar.setEnabled(false);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(Constantes.regularFont);
		lblBuscar.setBounds(931, 212, 100, 35);
		lblBuscar.setCursor(Constantes.pointer);
		contentPane.add(lblBuscar);
		btnBuscar.setIcon(new ImageIcon(ReporteAtencionesPagadas.class.getResource("/views/images/btn-login.png")));
		btnBuscar.setCursor(Constantes.pointer);
		btnBuscar.setBounds(931, 212, 100, 35);
		contentPane.add(btnBuscar);
		
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
					txtIngresar.setText("ATE");
					txtIngresar.requestFocus();
				}
				else if(cboBuscar == 2){
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
		lblInputBuscar.setIcon(new ImageIcon(ReporteAtencionesPagadas.class.getResource("/views/images/text-buscar.png")));
		lblInputBuscar.setBounds(127, 212, 200, 35);
		contentPane.add(lblInputBuscar);
		
		lblBuscarPor = new JLabel("Buscar por:");
		lblBuscarPor.setFont(Constantes.regularFont);
		lblBuscarPor.setForeground(Constantes.textgray);
		lblBuscarPor.setBounds(24, 212, 87, 35);
		contentPane.add(lblBuscarPor);
		
		lblInputIngresar = new JLabel("");
		lblInputIngresar.setEnabled(false);
		lblInputIngresar.setIcon(new ImageIcon(ReporteAtencionesPagadas.class.getResource("/views/images/text-ingresar.png")));
		lblInputIngresar.setBounds(655, 212, 266, 35);
		contentPane.add(lblInputIngresar);
		
		lblIngresar = new JLabel("Ingrese dato seg\u00FAn su selecci\u00F3n:");
		lblIngresar.setForeground(new Color(68, 68, 68));
		lblIngresar.setFont(Constantes.regularFont);
		lblIngresar.setBounds(428, 212, 217, 35);
		contentPane.add(lblIngresar);
		
		lblAviso = new JLabel("* Opci\u00F3n activa: Listar");
		lblAviso.setHorizontalAlignment(SwingConstants.LEFT);
		lblAviso.setFont(Constantes.regularFont);
		lblAviso.setBounds(25, 167, 172, 26);
		lblAviso.setForeground(Constantes.skyblue);
		contentPane.add(lblAviso);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 286, 1006, 406);
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
		tabla.addColumn("Cód. Atención");
		tabla.addColumn("Cód. Paciente");
		tabla.addColumn("Fecha de atencion");
		tabla.addColumn("Total pagado");
		table.setModel(tabla);
		
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
        
        listarAtenciones();
        
	}
	
	private int getCboBuscarPor(){
		String cboSelect = txtBuscar.getText();
		if(cboSelect.contentEquals("Código de atención"))
			return 1;
		else if(cboSelect.contentEquals("Código de paciente"))
			return 2;
		else
			return 0;
	}
	
	private void listarAtenciones(){
		tabla.setRowCount(0);
		ArrayList<Atencion> getAtencion = atencion.listAtencionesPagadas();
		for(int i = 0; i < getAtencion.size(); i++){
			Object[] data = {
				getAtencion.get(i).getCodAtencion(),
				getAtencion.get(i).getCodPaciente(),
				getAtencion.get(i).getFechaAtencion(),
				decimalFormat.format(getAtencion.get(i).getTotalPagar())
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
	}
	
	private void changeOptionActive(String optionActive){
		String text = lblAviso.getText().split(":")[0];
		lblAviso.setText(text + ": " + optionActive);
	}
	
}
