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
import controllers.MantenimientoMedicinasController;
import models.Medicina;
import models.Paciente;

public class BuscadorMedicina extends JFrame {

	MantenimientoMedicinasController medicinas = new MantenimientoMedicinasController("medicinas.txt");
	
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
	private JLabel lblMedicina;
	private JLabel lblSeleccionar;
	private JLabel btnSeleccionar;
	private JTable tblTabla;
	private JScrollPane scrollPane;
	private JLabel lblBackground;
	private JPanel cboBuscarPor;
	private JLabel lblBackgroundCbo;
	private JLabel btnBuscarSeleccionar;
	private JLabel btnCodigo;
	private JLabel btnLaboratorio;
	private JLabel btnNombre;
	private DefaultTableModel tabla;
	private JTable table;
	private JTextField textField;
	private JTextField txtCodigo;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JLabel lblBackCantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscadorMedicina frame = new BuscadorMedicina();
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
	public BuscadorMedicina() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnClose = new JLabel("");
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnClose.setIcon(new ImageIcon(BuscadorMedicina.class.getResource("/views/images/close-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnClose.setIcon(new ImageIcon(BuscadorMedicina.class.getResource("/views/images/close.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
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
		
		btnCodigo = new JLabel("C\u00F3digo de medicina");
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
				txtIngresar.setText("MED");
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
		
		btnLaboratorio = new JLabel("Laboratorio");
		btnLaboratorio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLaboratorio.setBackground(Constantes.hoverFont);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnLaboratorio.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				txtBuscarPor.setText(btnLaboratorio.getText());
				cboBuscarPor.setVisible(false);
				txtIngresar.setText("");
			}
		});
		btnLaboratorio.setOpaque(true);
		btnLaboratorio.setCursor(Constantes.pointer);
		btnLaboratorio.setForeground(new Color(68, 68, 68));
		btnLaboratorio.setFont(Constantes.regularFont);
		btnLaboratorio.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnLaboratorio.setBackground(Color.WHITE);
		btnLaboratorio.setBounds(1, 74, 264, 30);
		cboBuscarPor.add(btnLaboratorio);
		
		btnNombre = new JLabel("Nombre");
		btnNombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNombre.setBackground(Constantes.hoverFont);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNombre.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				txtBuscarPor.setText(btnNombre.getText());
				cboBuscarPor.setVisible(false);
				txtIngresar.setText("");
			}
		});
		btnNombre.setOpaque(true);
		btnNombre.setCursor(Constantes.pointer);
		btnNombre.setForeground(new Color(68, 68, 68));
		btnNombre.setFont(Constantes.regularFont);
		btnNombre.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnNombre.setBackground(Color.WHITE);
		btnNombre.setBounds(1, 105, 264, 30);
		cboBuscarPor.add(btnNombre);
		
		lblBackgroundCbo = new JLabel("");
		lblBackgroundCbo.setIcon(new ImageIcon(BuscadorMedicina.class.getResource("/views/images/combo-buscar-por-dos.png")));
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
		btnClose.setIcon(new ImageIcon(BuscadorMedicina.class.getResource("/views/images/close.png")));
		btnClose.setBounds(624, 11, 16, 14);
		btnClose.setCursor(Constantes.pointer);
		contentPane.add(btnClose);
		
		lblTitulo = new JLabel("Buscador de Medicinas");
		lblTitulo.setForeground(new Color(59, 138, 191));
		lblTitulo.setFont(Constantes.boldFont);
		lblTitulo.setBounds(25, 40, 269, 26);
		contentPane.add(lblTitulo);
		
		txtDesc = new JTextPane();
		txtDesc.setBackground(Color.WHITE);
		txtDesc.setText("Aqu\u00ED podr\u00E1s obtener el listado de medicinas y realizar la selecci\u00F3n seg\u00FAn sea requerido.");
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
		label.setIcon(new ImageIcon(BuscadorMedicina.class.getResource("/views/images/ico-down.png")));
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
		lblInputSeleccionar.setIcon(new ImageIcon(BuscadorMedicina.class.getResource("/views/images/text-ingresar.png")));
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
							ArrayList<Medicina> buscarMedicina = medicinas.listLaboratorio(term);
							if(buscarMedicina != null){
								tabla.setRowCount(0);
								for(int i = 0; i < buscarMedicina.size(); i++){
									Object[] data = {
										buscarMedicina.get(i).getCodMedicina(),
										buscarMedicina.get(i).getNombre(),
										buscarMedicina.get(i).getLaboratorio(),
										buscarMedicina.get(i).getPrecio(),
										buscarMedicina.get(i).getPrecio()
									};
									tabla.addRow(data);
								}
							}
							else {
								mensaje("No hay registros de medicinas con este nombre de laboratorio.");
							}
						}
						else {
							mensaje("El laboratorio no ha sido ingresado en un formato correcto.");
						}
					}
					if(cboSelect == 3){
						if(term.matches("[a-zA-ZÒ—·ÈÌÛ˙¡…Õ”⁄\\s+]{0,25}") || term.matches("[a-zA-ZÒ—·ÈÌÛ˙¡…Õ”⁄+]{0,25}")){
							ArrayList<Medicina> buscarMedicina = medicinas.listNombre(term);
							if(buscarMedicina != null){
								tabla.setRowCount(0);
								for(int i = 0; i < buscarMedicina.size(); i++){
									Object[] data = {
										buscarMedicina.get(i).getCodMedicina(),
										buscarMedicina.get(i).getNombre(),
										buscarMedicina.get(i).getLaboratorio(),
										buscarMedicina.get(i).getPrecio(),
										buscarMedicina.get(i).getPrecio()
									};
									tabla.addRow(data);
								}
							}
							else {
								mensaje("No hay registros de pacientes con este nombre.");
							}
						}
						else {
							mensaje("El nombre no ha sido ingresado en un formato correcto.\nIngrese sÛlo letras.");
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
		lblInputIngresar.setIcon(new ImageIcon(BuscadorMedicina.class.getResource("/views/images/text-ingresar.png")));
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
				btnBuscar.setIcon(new ImageIcon(BuscadorMedicina.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBuscar.setIcon(new ImageIcon(BuscadorMedicina.class.getResource("/views/images/btn-login.png")));
			}
			void mostrarDatos(Medicina data){
				txtPaciente.setText(data.getNombre());
				txtCodigo.setText(data.getCodMedicina());
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
							if(term.matches("MED\\d{3}")){
								Medicina buscarMedicina = medicinas.buscarPorCodigo(term);
								if(buscarMedicina != null){
									mostrarDatos(buscarMedicina);
								}
								else {
									mensaje("No hay registros de medicinas con este cÛdigo.");
								}
							}
							else {
								mensaje("El cÛdigo no ha sido ingresado en un formato correcto.\nEjemplo: \"MED001\"");
							}
						}
						if(cboSelect == 2){
							if(term.matches("[a-zA-ZÒ—·ÈÌÛ˙¡…Õ”⁄\\-\\_\\s+]{3,25}") || term.matches("[a-zA-ZÒ—·ÈÌÛ˙¡…Õ”⁄\\-\\_+]{3,25}")){
								Medicina buscarMedicina = medicinas.buscarPorLaboratorio(term);
								if(buscarMedicina != null){
									mostrarDatos(buscarMedicina);
								}
								else {
									mensaje("No hay registros de medicinas de este laboratorio.");
								}
							}
							else {
								mensaje("El laboratorio no ha sido ingresado en un formato correcto.");
							}
						}
						if(cboSelect == 3){
							if(term.matches("[a-zA-ZÒ—·ÈÌÛ˙¡…Õ”⁄\\-\\_\\s+]{3,25}") || term.matches("[a-zA-ZÒ—·ÈÌÛ˙¡…Õ”⁄\\-\\_+]{3,25}")){
								Medicina buscarMedicina = medicinas.buscarPorNombre(term);
								if(buscarMedicina != null){
									mostrarDatos(buscarMedicina);
								}
								else {
									mensaje("No hay registros de medicinas con este nombre.");
								}
							}
							else {
								mensaje("El nombre no ha sido ingresado en un formato correcto.\nIngrese sÛlo letras.");
							}
						}
					}
				}
				else {
					return;
				}
			}
		});
		btnBuscar.setIcon(new ImageIcon(BuscadorMedicina.class.getResource("/views/images/btn-login.png")));
		btnBuscar.setBounds(526, 161, 100, 35);
		contentPane.add(btnBuscar);
		
		txtPaciente = new JTextField();
		txtPaciente.setOpaque(false);
		txtPaciente.setEditable(false);
		txtPaciente.setForeground(new Color(68, 68, 68));
		txtPaciente.setFont(Constantes.regularFont);
		txtPaciente.setColumns(10);
		txtPaciente.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtPaciente.setBounds(260, 207, 251, 35);
		contentPane.add(txtPaciente);
		
		lblInputCodPaciente = new JLabel("");
		lblInputCodPaciente.setIcon(new ImageIcon(BuscadorMedicina.class.getResource("/views/images/text-ingresar.png")));
		lblInputCodPaciente.setBounds(252, 207, 266, 35);
		contentPane.add(lblInputCodPaciente);
		
		lblMedicina = new JLabel("Medicina seleccionada:");
		lblMedicina.setForeground(new Color(68, 68, 68));
		lblMedicina.setFont(Constantes.regularFont);
		lblMedicina.setBounds(25, 207, 217, 35);
		contentPane.add(lblMedicina);
		
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
				btnSeleccionar.setIcon(new ImageIcon(BuscadorMedicina.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSeleccionar.setIcon(new ImageIcon(BuscadorMedicina.class.getResource("/views/images/btn-login.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(!txtPaciente.getText().contentEquals("") && !txtCantidad.getText().contentEquals("")){
					sendCodMedicina();
					sendCantidad();
					dispose();
				}
				else {
					mensaje("Asegurese de seleccionar una medicina y cantidad por favor.");
				}
			}
		});
		btnSeleccionar.setIcon(new ImageIcon(BuscadorMedicina.class.getResource("/views/images/btn-login.png")));
		btnSeleccionar.setBounds(526, 207, 100, 35);
		contentPane.add(btnSeleccionar);
		
		txtCantidad = new JTextField();
		txtCantidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent evt){
				String cantidad = txtCantidad.getText();
				if(cantidad.matches("[0-9]+") || evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
					return;
				}
				else {
					mensaje("Error al ingresar la cantidad.\nIngrese sÛlo n˙meros.");
				}
			}
		});
		txtCantidad.setBounds(260, 253, 251, 35);
		contentPane.add(txtCantidad);
		txtCantidad.setOpaque(false);
		txtCantidad.setForeground(new Color(68, 68, 68));
		txtCantidad.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		txtCantidad.setEditable(true);
		txtCantidad.setColumns(10);
		txtCantidad.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		lblBackCantidad = new JLabel("");
		lblBackCantidad.setIcon(new ImageIcon(BuscadorMedicina.class.getResource("/views/images/text-ingresar.png")));
		lblBackCantidad.setBounds(252, 253, 266, 35);
		contentPane.add(lblBackCantidad);
		
		lblCantidad = new JLabel("Cantidad de medicinas:");
		lblCantidad.setForeground(new Color(68, 68, 68));
		lblCantidad.setFont(new Font("Josefin Sans", Font.PLAIN, 14));
		lblCantidad.setBounds(25, 253, 217, 35);
		contentPane.add(lblCantidad);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 299, 601, 128);
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
				Medicina getMedicina = medicinas.buscarPorCodigo(code);
				txtPaciente.setText(getMedicina.getNombre());
				txtCodigo.setText(getMedicina.getCodMedicina());
			}
		});
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		tabla = new DefaultTableModel();
		tabla.addColumn("CÛdigo");
		tabla.addColumn("Nombre");
		tabla.addColumn("Laboratorio");
		tabla.addColumn("Precio");
		tabla.addColumn("Stock");
		table.setModel(tabla);
		
		lblBackground = new JLabel("");
		lblBackground.setBorder(new LineBorder(Constantes.lightgray, 2));
		lblBackground.setIcon(new ImageIcon(BuscadorMedicina.class.getResource("/views/images/background-mantenimiento.png")));
		lblBackground.setBounds(0, 0, 650, 450);
		contentPane.add(lblBackground);
		
		txtCodigo = new JTextField();
		txtCodigo.setVisible(false);
		txtCodigo.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtCodigo.setBounds(53, 0, 65, 35);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		listarMedicinas();
	}
	
	private String getBusquedaCodigo(){
		return txtIngresar.getText();
	}

	private int cboBuscarPor(){
		String txtBuscar = txtBuscarPor.getText();
		if(txtBuscar.contentEquals("CÛdigo de medicina"))
			return 1;
		if(txtBuscar.contentEquals("Laboratorio"))
			return 2;
		if(txtBuscar.contentEquals("Nombre"))
			return 3;
		else
			return 0;
	}
	
	private void mensaje(String msg){
		JOptionPane.showMessageDialog(null, msg);
	}
	
	private void listarMedicinas(){
		tabla.setRowCount(0);
		for(int i = 0; i < medicinas.tamanio(); i++){
			Object[] data = {
				medicinas.obtener(i).getCodMedicina(),
				medicinas.obtener(i).getNombre(),
				medicinas.obtener(i).getLaboratorio(),
				medicinas.obtener(i).getPrecio(),
				medicinas.obtener(i).getStock()
			};
			tabla.addRow(data);
		}
	}
	
	public String sendCodMedicina(){
		return txtCodigo.getText();
	}
	
	public String sendCantidad(){
		return txtCantidad.getText();
	}
	
}
