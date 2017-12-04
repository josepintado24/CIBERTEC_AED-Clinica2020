package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
import models.Internamiento;

public class BuscadorPacienteInternamiento extends JFrame {

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
	private JLabel btnCodigoInt;
	private JLabel btnCodPaciente;
	private JLabel btnCodCama;
	private DefaultTableModel tabla;
	private JTable table;
	private JTextField textField;
	private JTextField txtCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscadorPacienteInternamiento frame = new BuscadorPacienteInternamiento();
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
	public BuscadorPacienteInternamiento() {
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
		
		btnCodigoInt = new JLabel("C\u00F3digo de Internamiento");
		btnCodigoInt.setHorizontalAlignment(SwingConstants.LEFT);
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
				txtBuscarPor.setText(btnCodigoInt.getText());
				cboBuscarPor.setVisible(false);
				txtIngresar.setText("INT");
				txtIngresar.requestFocus();
			}
		});
		btnCodigoInt.setOpaque(true);
		btnCodigoInt.setCursor(Constantes.pointer);
		btnCodigoInt.setForeground(new Color(68, 68, 68));
		btnCodigoInt.setFont(Constantes.regularFont);
		btnCodigoInt.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnCodigoInt.setBackground(Color.WHITE);
		btnCodigoInt.setBounds(1, 43, 264, 30);
		cboBuscarPor.add(btnCodigoInt);
		
		btnCodPaciente = new JLabel("C\u00F3digo de paciente");
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
				txtBuscarPor.setText(btnCodPaciente.getText());
				cboBuscarPor.setVisible(false);
				txtIngresar.setText("PAC");
				txtIngresar.requestFocus();
			}
		});
		btnCodPaciente.setOpaque(true);
		btnCodPaciente.setCursor(Constantes.pointer);
		btnCodPaciente.setForeground(new Color(68, 68, 68));
		btnCodPaciente.setFont(Constantes.regularFont);
		btnCodPaciente.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnCodPaciente.setBackground(Color.WHITE);
		btnCodPaciente.setBounds(1, 74, 264, 30);
		cboBuscarPor.add(btnCodPaciente);
		
		btnCodCama = new JLabel("C\u00F3digo de cama");
		btnCodCama.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCodCama.setBackground(Constantes.hoverFont);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCodCama.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				txtBuscarPor.setText(btnCodCama.getText());
				cboBuscarPor.setVisible(false);
				txtIngresar.setText("CAM");
				txtIngresar.requestFocus();
			}
		});
		btnCodCama.setOpaque(true);
		btnCodCama.setCursor(Constantes.pointer);
		btnCodCama.setForeground(new Color(68, 68, 68));
		btnCodCama.setFont(Constantes.regularFont);
		btnCodCama.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnCodCama.setBackground(Color.WHITE);
		btnCodCama.setBounds(1, 105, 264, 30);
		cboBuscarPor.add(btnCodCama);
		
		lblBackgroundCbo = new JLabel("");
		lblBackgroundCbo.setIcon(new ImageIcon(BuscadorPacienteInternamiento.class.getResource("/views/images/combo-buscar-por-dos.png")));
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
				btnClose.setIcon(new ImageIcon(BuscadorPacienteInternamiento.class.getResource("/views/images/close-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnClose.setIcon(new ImageIcon(BuscadorPacienteInternamiento.class.getResource("/views/images/close.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnClose.setIcon(new ImageIcon(BuscadorPacienteInternamiento.class.getResource("/views/images/close.png")));
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
		label.setIcon(new ImageIcon(BuscadorPacienteInternamiento.class.getResource("/views/images/ico-down.png")));
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
		lblInputSeleccionar.setIcon(new ImageIcon(BuscadorPacienteInternamiento.class.getResource("/views/images/text-ingresar.png")));
		lblInputSeleccionar.setBounds(252, 115, 266, 35);
		contentPane.add(lblInputSeleccionar);
		
		lblBuscarPor = new JLabel("Buscar por:");
		lblBuscarPor.setForeground(new Color(68, 68, 68));
		lblBuscarPor.setFont(Constantes.regularFont);
		lblBuscarPor.setBounds(25, 115, 70, 35);
		contentPane.add(lblBuscarPor);
		
		txtIngresar = new JTextField();
		txtIngresar.addKeyListener(new KeyAdapter(){
			@Override
			public void keyTyped(KeyEvent evt){
				int cboSelect = cboBuscarPor();
				if(cboSelect == 0){
					mensaje("Asegurese de haber seleccionado un filtro e ingresado un término de búsqueda.");
				}
				else {
					if(txtIngresar.getText().length() == 6) evt.consume();
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
		lblInputIngresar.setIcon(new ImageIcon(BuscadorPacienteInternamiento.class.getResource("/views/images/text-ingresar.png")));
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
				btnBuscar.setIcon(new ImageIcon(BuscadorPacienteInternamiento.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBuscar.setIcon(new ImageIcon(BuscadorPacienteInternamiento.class.getResource("/views/images/btn-login.png")));
			}
			void mostrarDatos(Internamiento data){
				txtPaciente.setText(data.getNombre());
				txtCodigo.setText(data.getCodPaciente());
			}
			public void mouseClicked(MouseEvent e) {
				if(btnBuscar.isEnabled()){
					int cboSelect = cboBuscarPor();
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
								mensaje("El código no ha sido ingresado en un formato correcto.\nEjemplo: \"PAC001\"");
							}
						}
						if(cboSelect == 2){
							if(term.matches("PAC\\d{3}")){
								Internamiento buscarInternamiento = internamiento.buscarPorCodigoPaciente(term);
								if(buscarInternamiento != null){
									mostrarDatos(buscarInternamiento);
								}
								else {
									mensaje("No hay registros de pacientes con este apellido.");
								}
							}
							else {
								mensaje("El apellido no ha sido ingresado en un formato correcto.\nIngrese sólo letras.");
							}
						}
						if(cboSelect == 3){
							if(term.matches("CAM\\d{3}")){
								Internamiento buscarInternamiento = internamiento.buscarPorCodigoCama(term);
								if(buscarInternamiento != null){
									mostrarDatos(buscarInternamiento);
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
		btnBuscar.setIcon(new ImageIcon(BuscadorPacienteInternamiento.class.getResource("/views/images/btn-login.png")));
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
		lblInputCodPaciente.setIcon(new ImageIcon(BuscadorPacienteInternamiento.class.getResource("/views/images/text-ingresar.png")));
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
				btnSeleccionar.setIcon(new ImageIcon(BuscadorPacienteInternamiento.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSeleccionar.setIcon(new ImageIcon(BuscadorPacienteInternamiento.class.getResource("/views/images/btn-login.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(!txtPaciente.getText().contentEquals("")){
					Internamiento getInternado = internamiento.buscarPorCodigoPaciente(txtCodigo.getText());
					if(getInternado.getEstado().equalsIgnoreCase("Alta")){
						mensaje("El paciente seleccionado ya se encuentra dado de alta.");
					}
					else {
						sendCodPaciente();
						dispose();
					}
				}
				else {
					mensaje("Asegurese de seleccionar un código de paciente por favor.");
				}
			}
		});
		btnSeleccionar.setIcon(new ImageIcon(BuscadorPacienteInternamiento.class.getResource("/views/images/btn-login.png")));
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
				Internamiento getInternamiento = internamiento.buscarPorCodigoInternamiento(code);
				txtPaciente.setText(getInternamiento.getNombre());
				txtCodigo.setText(getInternamiento.getCodPaciente());
			}
		});
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		tabla = new DefaultTableModel();
		tabla.addColumn("Cód. Intern");
		tabla.addColumn("Cód. Paciente");
		tabla.addColumn("Nombre");
		tabla.addColumn("Cód. Cama");
		table.setModel(tabla);
		
		lblBackground = new JLabel("");
		lblBackground.setBorder(new LineBorder(Constantes.lightgray, 2));
		lblBackground.setIcon(new ImageIcon(BuscadorPacienteInternamiento.class.getResource("/views/images/background-mantenimiento.png")));
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
		
		listarInternamientos();
	}
	
	private String getBusquedaCodigo(){
		return txtIngresar.getText();
	}

	private int cboBuscarPor(){
		String txtBuscar = txtBuscarPor.getText();
		if(txtBuscar.contentEquals("Código de Internamiento"))
			return 1;
		if(txtBuscar.contentEquals("Código de paciente"))
			return 2;
		if(txtBuscar.contentEquals("Código de cama"))
			return 3;
		else
			return 0;
	}
	
	private void mensaje(String msg){
		JOptionPane.showMessageDialog(null, msg);
	}
	
	private void listarInternamientos(){
		tabla.setRowCount(0);
		for(int i = 0; i < internamiento.tamanio(); i++){
			Object[] data = {
				internamiento.obtener(i).getCodInternamiento(),
				internamiento.obtener(i).getCodPaciente(),
				internamiento.obtener(i).getNombre(),
				internamiento.obtener(i).getCodCama()
			};
			tabla.addRow(data);
		}
	}
	
	public String sendCodPaciente(){
		return txtCodigo.getText();
	}
	
}
