package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import controllers.AtencionController;
import models.Atencion;

public class BuscadorAtencion extends JFrame {

	Constantes constantes = new Constantes();
	AtencionController atencion = new AtencionController("atencion.txt");
	
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
	private JTextField txtCodAtencion;
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
	private JLabel btnCodAtencion;
	private JLabel btnCodPaciente;
	private DefaultTableModel tabla;
	private JTable table;
	private JLabel arrBuscarEstado;
	private JPanel cboBuscarCama;
	private JLabel btnSelectEstado;
	private JLabel btnPagado;
	private JLabel btnPendiente;
	private JLabel lblNewLabel;
	private JLabel btnEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscadorAtencion frame = new BuscadorAtencion();
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
	public BuscadorAtencion() {
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
				btnClose.setIcon(new ImageIcon(BuscadorAtencion.class.getResource("/views/images/close-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnClose.setIcon(new ImageIcon(BuscadorAtencion.class.getResource("/views/images/close.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
		arrBuscarEstado = new JLabel("");
		arrBuscarEstado.setVisible(false);
		arrBuscarEstado.setBounds(497, 171, 10, 14);
		contentPane.add(arrBuscarEstado);
		arrBuscarEstado.setIcon(new ImageIcon(BuscadorAtencion.class.getResource("/views/images/ico-down.png")));
		
		cboBuscarCama = new JPanel();
		cboBuscarCama.setVisible(false);
		
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
		btnBuscarSeleccionar.setForeground(Constantes.textgray);
		btnBuscarSeleccionar.setFont(Constantes.regularFont);
		btnBuscarSeleccionar.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnBuscarSeleccionar.setBackground(Color.WHITE);
		btnBuscarSeleccionar.setBounds(1, 12, 264, 30);
		cboBuscarPor.add(btnBuscarSeleccionar);
		
		btnCodAtencion = new JLabel("C\u00F3digo de atenci\u00F3n");
		btnCodAtencion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCodAtencion.setBackground(Constantes.hoverFont);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCodAtencion.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				txtBuscarPor.setText(btnCodAtencion.getText());
				cboBuscarPor.setVisible(false);
				txtIngresar.setText("ATE");
				txtIngresar.requestFocus();
				arrBuscarEstado.setVisible(false);
				txtIngresar.setCursor(Constantes.textCursor);
				txtIngresar.setEditable(true);
				txtIngresar.requestFocus(true);
			}
		});
		btnCodAtencion.setOpaque(true);
		btnCodAtencion.setCursor(Constantes.pointer);
		btnCodAtencion.setForeground(Constantes.textgray);
		btnCodAtencion.setFont(Constantes.regularFont);
		btnCodAtencion.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnCodAtencion.setBackground(Color.WHITE);
		btnCodAtencion.setBounds(1, 43, 264, 30);
		cboBuscarPor.add(btnCodAtencion);
		
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
		btnCodPaciente.setForeground(Constantes.textgray);
		btnCodPaciente.setFont(Constantes.regularFont);
		btnCodPaciente.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnCodPaciente.setBackground(Color.WHITE);
		btnCodPaciente.setBounds(1, 74, 264, 30);
		cboBuscarPor.add(btnCodPaciente);
		
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
				txtIngresar.setEditable(false);
				arrBuscarEstado.setVisible(true);
				txtIngresar.setCursor(Constantes.pointer);
				txtIngresar.setEditable(false);
				txtIngresar.requestFocus(false);
				txtIngresar.setText("Seleccionar --");
			}
		});
		btnEstado.setOpaque(true);
		btnEstado.setCursor(Constantes.pointer);
		btnEstado.setForeground(Constantes.textgray);
		btnEstado.setFont(Constantes.regularFont);
		btnEstado.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnEstado.setBackground(Color.WHITE);
		btnEstado.setBounds(1, 105, 264, 30);
		cboBuscarPor.add(btnEstado);
		
		lblBackgroundCbo = new JLabel("");
		lblBackgroundCbo.setIcon(new ImageIcon(BuscadorAtencion.class.getResource("/views/images/combo-buscar-por-dos.png")));
		lblBackgroundCbo.setBounds(0, 0, 266, 150);
		cboBuscarPor.add(lblBackgroundCbo);
		cboBuscarCama.setBounds(252, 198, 266, 115);
		contentPane.add(cboBuscarCama);
		cboBuscarCama.setLayout(null);
		
		btnSelectEstado = new JLabel("Seleccionar --");
		btnSelectEstado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSelectEstado.setBackground(Constantes.hoverFont);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSelectEstado.setBackground(Color.white);
			}
			public void mouseClicked(MouseEvent e) {
				txtIngresar.setText(btnSelectEstado.getText());
				cboBuscarCama.setVisible(false);
				listarAtenciones();
			}
		});
		btnSelectEstado.setFont(Constantes.regularFont);
		btnSelectEstado.setBackground(Color.WHITE);
		btnSelectEstado.setOpaque(true);
		btnSelectEstado.setFont(Constantes.regularFont);
		btnSelectEstado.setCursor(Constantes.pointer);
		btnSelectEstado.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnSelectEstado.setBounds(1, 11, 264, 30);
		cboBuscarCama.add(btnSelectEstado);
		
		btnPagado = new JLabel("Pagado");
		btnPagado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPagado.setBackground(Constantes.hoverFont);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPagado.setBackground(Color.white);
			}
			public void mouseClicked(MouseEvent e) {
				txtIngresar.setText(btnPagado.getText());
				cboBuscarCama.setVisible(false);
				listaPorEstado();
			}
		});
		btnPagado.setFont(Constantes.regularFont);
		btnPagado.setBackground(Color.WHITE);
		btnPagado.setOpaque(true);
		btnPagado.setFont(Constantes.regularFont);
		btnPagado.setCursor(Constantes.pointer);
		btnPagado.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnPagado.setBounds(1, 42, 264, 30);
		cboBuscarCama.add(btnPagado);
		
		btnPendiente = new JLabel("Pendiente");
		btnPendiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPendiente.setBackground(Constantes.hoverFont);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPendiente.setBackground(Color.white);
			}
			public void mouseClicked(MouseEvent e) {
				txtIngresar.setText(btnPendiente.getText());
				cboBuscarCama.setVisible(false);
				listaPorEstado();
			}
		});
		btnPendiente.setFont(Constantes.regularFont);
		btnPendiente.setBackground(Color.WHITE);
		btnPendiente.setOpaque(true);
		btnPendiente.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnPendiente.setFont(Constantes.regularFont);
		btnPendiente.setCursor(Constantes.pointer);
		btnPendiente.setBounds(1, 73, 264, 30);
		cboBuscarCama.add(btnPendiente);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BuscadorAtencion.class.getResource("/views/images/cbo-select-cama.png")));
		lblNewLabel.setBounds(0, 0, 266, 115);
		cboBuscarCama.add(lblNewLabel);
		btnClose.setIcon(new ImageIcon(BuscadorAtencion.class.getResource("/views/images/close.png")));
		btnClose.setBounds(624, 11, 16, 14);
		btnClose.setCursor(Constantes.pointer);
		contentPane.add(btnClose);
		
		lblTitulo = new JLabel("Buscador de Atenciones");
		lblTitulo.setForeground(new Color(59, 138, 191));
		lblTitulo.setFont(Constantes.boldFont);
		lblTitulo.setBounds(25, 40, 269, 26);
		contentPane.add(lblTitulo);
		
		txtDesc = new JTextPane();
		txtDesc.setBackground(Color.WHITE);
		txtDesc.setText("Aqu\u00ED podr\u00E1s obtener el listado de atenciones y realizar la selecci\u00F3n seg\u00FAn sea requerido.");
		txtDesc.setOpaque(false);
		txtDesc.setForeground(Constantes.textgray);
		txtDesc.setFont(Constantes.regularFont);
		txtDesc.setEditable(false);
		txtDesc.setBounds(25, 69, 601, 21);
		contentPane.add(txtDesc);
		
		separator = new JSeparator();
		separator.setForeground(new Color(213, 213, 213));
		separator.setBounds(25, 102, 601, 2);
		contentPane.add(separator);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(BuscadorAtencion.class.getResource("/views/images/ico-down.png")));
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
		txtBuscarPor.setForeground(Constantes.textgray);
		txtBuscarPor.setFont(Constantes.regularFont);
		txtBuscarPor.setDisabledTextColor(Constantes.textgray);
		txtBuscarPor.setColumns(10);
		txtBuscarPor.setBorder(new EmptyBorder(0, 10, 0, 10));
		txtBuscarPor.setCursor(Constantes.pointer);
		txtBuscarPor.setBounds(252, 115, 266, 35);
		contentPane.add(txtBuscarPor);
		
		lblInputSeleccionar = new JLabel("");
		lblInputSeleccionar.setIcon(new ImageIcon(BuscadorAtencion.class.getResource("/views/images/text-ingresar.png")));
		lblInputSeleccionar.setBounds(252, 115, 266, 35);
		contentPane.add(lblInputSeleccionar);
		
		lblBuscarPor = new JLabel("Buscar por:");
		lblBuscarPor.setForeground(Constantes.textgray);
		lblBuscarPor.setFont(Constantes.regularFont);
		lblBuscarPor.setBounds(25, 115, 70, 35);
		contentPane.add(lblBuscarPor);
		
		txtIngresar = new JTextField();
		txtIngresar.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				if(txtIngresar.isEditable()){
					return;
				}
				else {
					boolean status = (cboBuscarCama.isVisible()) ? false : true;
					cboBuscarCama.setVisible(status);
				}
			}
		});
		txtIngresar.setOpaque(false);
		txtIngresar.setForeground(Constantes.textgray);
		txtIngresar.setFont(Constantes.regularFont);
		txtIngresar.setColumns(10);
		txtIngresar.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtIngresar.setBounds(260, 161, 251, 35);
		contentPane.add(txtIngresar);
		
		lblInputIngresar = new JLabel("");
		lblInputIngresar.setIcon(new ImageIcon(BuscadorAtencion.class.getResource("/views/images/text-ingresar.png")));
		lblInputIngresar.setBounds(252, 161, 266, 35);
		contentPane.add(lblInputIngresar);
		
		lblIngresar = new JLabel("Ingrese dato seg\u00FAn su selecci\u00F3n:");
		lblIngresar.setForeground(Constantes.textgray);
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
				btnBuscar.setIcon(new ImageIcon(BuscadorAtencion.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBuscar.setIcon(new ImageIcon(BuscadorAtencion.class.getResource("/views/images/btn-login.png")));
			}
			void mostrarDatos(Atencion data){
				txtCodAtencion.setText(data.getCodAtencion());
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
							if(term.matches("ATE\\d{3}")){
								Atencion buscarAtencion = atencion.buscarPorCodigo(term);
								if(buscarAtencion != null){
									mostrarDatos(buscarAtencion);
								}
								else {
									mensaje("No hay registros de atenciones con este código.");
								}
							}
							else {
								mensaje("El código no ha sido ingresado en un formato correcto.\nEjemplo: \"ATE001\"");
							}
						}
						if(cboSelect == 2){
							if(term.matches("PAC\\d{3}")){
								Atencion buscarAtencion = atencion.buscarPorCodigoPaciente(term);
								if(buscarAtencion != null){
									mostrarDatos(buscarAtencion);
								}
								else {
									mensaje("No hay registros de pacientes con este código.");
								}
							}
							else {
								mensaje("El código no ha sido ingresado en un formato correcto.\nEjemplo: \"PAC001\"");
							}
						}
					}
				}
				else {
					return;
				}
			}
		});
		btnBuscar.setIcon(new ImageIcon(BuscadorAtencion.class.getResource("/views/images/btn-login.png")));
		btnBuscar.setBounds(526, 161, 100, 35);
		contentPane.add(btnBuscar);
		
		txtCodAtencion = new JTextField();
		txtCodAtencion.setOpaque(false);
		txtCodAtencion.setEditable(false);
		txtCodAtencion.setForeground(Constantes.textgray);
		txtCodAtencion.setFont(Constantes.regularFont);
		txtCodAtencion.setColumns(10);
		txtCodAtencion.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtCodAtencion.setBounds(260, 207, 251, 35);
		contentPane.add(txtCodAtencion);
		
		lblInputCodCama = new JLabel("");
		lblInputCodCama.setIcon(new ImageIcon(BuscadorAtencion.class.getResource("/views/images/text-ingresar.png")));
		lblInputCodCama.setBounds(252, 207, 266, 35);
		contentPane.add(lblInputCodCama);
		
		lblCodCama = new JLabel("C\u00F3digo de atenci\u00F3n seleccionado:");
		lblCodCama.setForeground(Constantes.textgray);
		lblCodCama.setFont(Constantes.regularFont);
		lblCodCama.setBounds(25, 207, 217, 35);
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
				btnSeleccionar.setIcon(new ImageIcon(BuscadorAtencion.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSeleccionar.setIcon(new ImageIcon(BuscadorAtencion.class.getResource("/views/images/btn-login.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String code = txtCodAtencion.getText();
				Atencion getAtencion = atencion.buscarPorCodigo(code);
				if(getAtencion.getEstado().equalsIgnoreCase("Pagado")){
					mensaje("La atención seleccionada ya se encuetra pagada.");
				}
				else {
					sendCodAtencion();
					dispose();
				}
			}
		});
		btnSeleccionar.setIcon(new ImageIcon(BuscadorAtencion.class.getResource("/views/images/btn-login.png")));
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
				int rowIndex = table.getSelectedRow();
				String code = table.getValueAt(rowIndex, 0).toString();
				Atencion getAtencion = atencion.buscarPorCodigo(code);
				txtCodAtencion.setText(getAtencion.getCodAtencion());
			}
		});
		scrollPane.setViewportView(table);
		
		tabla = new DefaultTableModel();
		tabla.addColumn("Cód. Atención");
		tabla.addColumn("Cód. Paciente");
		tabla.addColumn("Fec. Atención");
		tabla.addColumn("Total a pagar");
		tabla.addColumn("Estado");
		table.setModel(tabla);
		
		lblBackground = new JLabel("");
		lblBackground.setBorder(new LineBorder(Constantes.lightgray, 2));
		lblBackground.setIcon(new ImageIcon(BuscadorAtencion.class.getResource("/views/images/background-mantenimiento.png")));
		lblBackground.setBounds(0, 0, 650, 450);
		contentPane.add(lblBackground);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		listarAtenciones();
	}
	
	private int getCboBuscarPor(){
		String cboSelect = txtBuscarPor.getText();
		if(cboSelect.contentEquals("Código de atención"))
			return 1;
		else if(cboSelect.contentEquals("Código de paciente"))
			return 2;
		else if(cboSelect.contentEquals("Estado"))
			return 3;
		else
			return 0;
	}
	
	private void mensaje(String msg){
		JOptionPane.showMessageDialog(null, msg);
	}
	
	private void listarAtenciones(){
		tabla.setRowCount(0);
		for(int i = 0; i < atencion.tamano(); i++){
			Object[] data = {
				atencion.obtener(i).getCodAtencion(),
				atencion.obtener(i).getCodPaciente(),
				atencion.obtener(i).getFechaAtencion(),
				atencion.obtener(i).getTotalPagar(),
				atencion.obtener(i).getEstado()
			};
			tabla.addRow(data);
		}
	}
	
	public String sendCodAtencion(){
		return txtCodAtencion.getText();
	}
	
	private void listaPorEstado(){
		String term = txtIngresar.getText();
		ArrayList<Atencion> listAtencion = atencion.listAtencionEstado(term);
		if(listAtencion != null){
			tabla.setRowCount(0);
			for(int i = 0; i < listAtencion.size(); i ++){
				Object[] data = {
					listAtencion.get(i).getCodAtencion(),
					listAtencion.get(i).getCodPaciente(),
					listAtencion.get(i).getFechaAtencion(),
					listAtencion.get(i).getTotalPagar(),
					listAtencion.get(i).getEstado()
				};
				tabla.addRow(data);
			}
		}
		else {
			mensaje("No hay registros de camas con estado:  " + term);
		}
	}
}
