package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import constantes.Constantes;
import controllers.MantenimientoCamasController;
import models.Cama;
import models.Paciente;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BuscadorCama extends JFrame {

	Constantes constantes = new Constantes();
	MantenimientoCamasController cama = new MantenimientoCamasController("camas.txt");
	
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
	private JTextField txtCodCama;
	private JLabel lblInputCodCama;
	private JLabel lblCodCama;
	private JLabel lblSeleccionar;
	private JLabel btnSeleccionar;
	private JTable tblTabla;
	private JScrollPane scrollPane;
	private JLabel lblBackground;
	private JPanel cboBuscarPor;
	private JLabel lblBackgroundCbo;
	private JLabel btnBuscarSeleccionar;
	private JLabel btnCodigo;
	private JLabel btnEstado;
	private DefaultTableModel tabla;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscadorCama frame = new BuscadorCama();
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
	public BuscadorCama() {
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
		
		btnCodigo = new JLabel("C\u00F3digo de cama");
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
				txtIngresar.setText("CAM");
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
		
		btnEstado = new JLabel("Estado");
		btnEstado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEstado.setBackground(Constantes.hoverFont);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEstado.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				txtBuscarPor.setText(btnEstado.getText());
				cboBuscarPor.setVisible(false);
			}
		});
		btnEstado.setOpaque(true);
		btnEstado.setCursor(Constantes.pointer);
		btnEstado.setForeground(new Color(68, 68, 68));
		btnEstado.setFont(Constantes.regularFont);
		btnEstado.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnEstado.setBackground(Color.WHITE);
		btnEstado.setBounds(1, 74, 264, 30);
		cboBuscarPor.add(btnEstado);
		
		lblBackgroundCbo = new JLabel("");
		lblBackgroundCbo.setIcon(new ImageIcon(BuscadorCama.class.getResource("/views/images/combo-buscar-por-dos.png")));
		lblBackgroundCbo.setBounds(0, 0, 266, 150);
		cboBuscarPor.add(lblBackgroundCbo);
		
		btnClose = new JLabel("");
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnClose.setIcon(new ImageIcon(BuscadorCama.class.getResource("/views/images/close-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnClose.setIcon(new ImageIcon(BuscadorCama.class.getResource("/views/images/close.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnClose.setIcon(new ImageIcon(BuscadorCama.class.getResource("/views/images/close.png")));
		btnClose.setBounds(624, 11, 16, 14);
		btnClose.setCursor(Constantes.pointer);
		contentPane.add(btnClose);
		
		lblTitulo = new JLabel("Buscador de Camas");
		lblTitulo.setForeground(new Color(59, 138, 191));
		lblTitulo.setFont(Constantes.boldFont);
		lblTitulo.setBounds(25, 40, 269, 26);
		contentPane.add(lblTitulo);
		
		txtDesc = new JTextPane();
		txtDesc.setBackground(Color.WHITE);
		txtDesc.setText("Aqu\u00ED podr\u00E1s obtener el listado de camas y realizar la selecci\u00F3n seg\u00FAn sea requerido.");
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
		label.setIcon(new ImageIcon(BuscadorCama.class.getResource("/views/images/ico-down.png")));
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
		lblInputSeleccionar.setIcon(new ImageIcon(BuscadorCama.class.getResource("/views/images/text-ingresar.png")));
		lblInputSeleccionar.setBounds(252, 115, 266, 35);
		contentPane.add(lblInputSeleccionar);
		
		lblBuscarPor = new JLabel("Buscar por:");
		lblBuscarPor.setForeground(new Color(68, 68, 68));
		lblBuscarPor.setFont(Constantes.regularFont);
		lblBuscarPor.setBounds(25, 115, 70, 35);
		contentPane.add(lblBuscarPor);
		
		txtIngresar = new JTextField();
		txtIngresar.setOpaque(false);
		txtIngresar.setForeground(new Color(68, 68, 68));
		txtIngresar.setFont(Constantes.regularFont);
		txtIngresar.setColumns(10);
		txtIngresar.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtIngresar.setBounds(260, 161, 251, 35);
		contentPane.add(txtIngresar);
		
		lblInputIngresar = new JLabel("");
		lblInputIngresar.setIcon(new ImageIcon(BuscadorCama.class.getResource("/views/images/text-ingresar.png")));
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
				btnBuscar.setIcon(new ImageIcon(BuscadorCama.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBuscar.setIcon(new ImageIcon(BuscadorCama.class.getResource("/views/images/btn-login.png")));
			}
			void mostrarDatos(Cama data){
				txtCodCama.setText(data.getCodCama());
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnBuscar.isEnabled()){
					int cboSelect = getCboBuscarPor();
					if(txtIngresar.getText().contentEquals("") || cboSelect == 0){
						mensaje("Asegurese de haber seleccionado un filtro e ingresado un término de búsqueda.");
					}
					else {
						String term = txtIngresar.getText();
						if(cboSelect == 1){
							if(term.matches("CAM\\d{3}")){
								Cama buscarCama = cama.buscarPorCodigo(term);
								if(buscarCama != null){
									mostrarDatos(buscarCama);
								}
								else {
									mensaje("No hay registros de camas con este código.");
								}
							}
							else {
								mensaje("El código no ha sido ingresado en un formato correcto.\nEjemplo: \"CAM001\"");
							}
						}
						if(cboSelect == 2){
							if(term.equalsIgnoreCase("Libre") || term.equalsIgnoreCase("Ocupado")){
								Cama buscarCama = cama.buscarPorEstado(term);
								if(buscarCama != null){
									mostrarDatos(buscarCama);
								}
								else {
									mensaje("No hay registros de camas con este estado.");
								}
							}
							else {
								mensaje("El estado no es válido.\nIngrese Libre u Ocupado.");
							}
						}
					}
				}
				else {
					return;
				}
			}
		});
		btnBuscar.setIcon(new ImageIcon(BuscadorCama.class.getResource("/views/images/btn-login.png")));
		btnBuscar.setBounds(526, 161, 100, 35);
		contentPane.add(btnBuscar);
		
		txtCodCama = new JTextField();
		txtCodCama.setOpaque(false);
		txtCodCama.setForeground(new Color(68, 68, 68));
		txtCodCama.setFont(Constantes.regularFont);
		txtCodCama.setColumns(10);
		txtCodCama.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtCodCama.setBounds(260, 207, 251, 35);
		contentPane.add(txtCodCama);
		
		lblInputCodCama = new JLabel("");
		lblInputCodCama.setIcon(new ImageIcon(BuscadorCama.class.getResource("/views/images/text-ingresar.png")));
		lblInputCodCama.setBounds(252, 207, 266, 35);
		contentPane.add(lblInputCodCama);
		
		lblCodCama = new JLabel("C\u00F3digo de cama seleccionado:");
		lblCodCama.setForeground(new Color(68, 68, 68));
		lblCodCama.setFont(Constantes.regularFont);
		lblCodCama.setBounds(25, 207, 200, 35);
		contentPane.add(lblCodCama);
		
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
				btnSeleccionar.setIcon(new ImageIcon(BuscadorCama.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSeleccionar.setIcon(new ImageIcon(BuscadorCama.class.getResource("/views/images/btn-login.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				sendCodCama();
				dispose();
			}
		});
		btnSeleccionar.setIcon(new ImageIcon(BuscadorCama.class.getResource("/views/images/btn-login.png")));
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
		table.setFillsViewportHeight(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cama getCama = cama.obtener(table.getSelectedRow());
				txtCodCama.setText(getCama.getCodCama());
			}
		});
		scrollPane.setViewportView(table);
		
		tabla = new DefaultTableModel();
		tabla.addColumn("Código");
		tabla.addColumn("Precio por día");
		tabla.addColumn("Estado");
		table.setModel(tabla);
		
		lblBackground = new JLabel("");
		lblBackground.setBorder(new LineBorder(Constantes.lightgray, 2));
		lblBackground.setIcon(new ImageIcon(BuscadorCama.class.getResource("/views/images/background-mantenimiento.png")));
		lblBackground.setBounds(0, 0, 650, 450);
		contentPane.add(lblBackground);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		listarPacientes();
	}
	
	private int getCboBuscarPor(){
		String cboSelect = txtBuscarPor.getText();
		if(cboSelect.contentEquals("Código de cama"))
			return 1;
		else if(cboSelect.contentEquals("Estado"))
			return 2;
		else
			return 0;
	}
	
	private void mensaje(String msg){
		JOptionPane.showMessageDialog(null, msg);
	}
	
	private void listarPacientes(){
		tabla.setRowCount(0);
		for(int i = 0; i < cama.tamanio(); i++){
			Object[] data = {
					cama.obtener(i).getCodCama(),
					cama.obtener(i).getPrecioDia(),
					cama.obtener(i).getEstado(),
			};
			tabla.addRow(data);
		}
	}
	
	public String sendCodCama(){
		return txtCodCama.getText();
	}
	
}
