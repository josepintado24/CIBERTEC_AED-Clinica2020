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
import java.awt.event.MouseListener;
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
import controllers.MantenimientoMedicinasController;
import models.Medicina;
import models.Paciente;

public class MantenimientoMedicinas extends JFrame {

	MantenimientoMedicinasController medicina = new MantenimientoMedicinasController("medicinas.txt");
	
	private JPanel contentPane;
	private JLabel lblBackground;
	private JLabel btnClose;
	private JTextPane txtDesc;
	private JSeparator separator;
	private JSeparator separatorMenu;
	private JLabel lblTitulo;
	private JLabel btnListar;
	private JLabel btnIngresar;
	private JLabel btnConsultar;
	private JLabel btnModificar;
	private JLabel btnEliminar;
	private JLabel lblInputBuscar;
	private JLabel lblBuscarPor;
	private JLabel lblInputIngresar;
	private JLabel lblIngresar;
	private JLabel btnBuscar;
	private JLabel lblBuscar;
	private JLabel lblAviso;
	private JLabel lblCodigo;
	private JLabel lblInputCodigo;
	private JLabel lblNombre;
	private JLabel lblInputNombres;
	private JLabel lblLaboratorio;
	private JLabel lblInputApellidos;
	private JLabel lblPrecio;
	private JLabel lblInputDni;
	private JLabel lblStock;
	private JLabel lblInputTelefono;
	private JTextField txtBuscar;
	private JTextField txtIngresar;
	private JTextField txtCodigo;
	private JTextField txtLaboratorio;
	private JTextField txtStock;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTable table;
	private JScrollPane tblTabla;
	private DefaultTableModel tabla;
	private JScrollPane scrollPane;
	private JLabel arrowBuscarPor;
	private JLabel cboBackground;
	private JLabel btnSeleccionar;
	private JLabel btnCodigo;
	private JLabel btnLaborario;
	private JLabel btnNombre;
	private JPanel cboBuscarPor;
	private JLabel btnIngresarConfirm;
	private JLabel btnModificarConfirm;
	private JLabel btnEliminarConfirm;
	private JLabel lblIngresarConfirm;
	private JLabel lblModificarConfirm;
	private JLabel lblEliminarConfirm;

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
					MantenimientoMedicinas frame = new MantenimientoMedicinas();
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
	public MantenimientoMedicinas() {
		setBackground(Color.WHITE);
		// Obtener el tamaÒo de la pantalla
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
				btnClose.setIcon(new ImageIcon(MantenimientoMedicinas.class.getResource("/views/images/close-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnClose.setIcon(new ImageIcon(MantenimientoMedicinas.class.getResource("/views/images/close.png")));
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
		
		btnCodigo = new JLabel("C\u00F3digo de medicina");
		btnCodigo.setBackground(Color.WHITE);
		btnCodigo.setCursor(Constantes.pointer);
		btnCodigo.setBounds(1, 41, 198, 30);
		btnCodigo.setOpaque(true);
		cboBuscarPor.add(btnCodigo);
		btnCodigo.setForeground(new Color(68, 68, 68));
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
				txtBuscar.setText(btnCodigo.getText());
				cboBuscarPor.setVisible(false);
				getCboBuscarPor();
			}
		});
		btnCodigo.setFont(Constantes.regularFont);
		btnCodigo.setBorder(new EmptyBorder(0, 10, 0, 10));
		
		btnLaborario = new JLabel("Laboratorio");
		btnLaborario.setBackground(Color.WHITE);
		btnLaborario.setCursor(Constantes.pointer);
		btnLaborario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLaborario.setBackground(Constantes.hoverFont);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnLaborario.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				txtBuscar.setText(btnLaborario.getText());
				cboBuscarPor.setVisible(false);
				getCboBuscarPor();
			}
		});
		btnLaborario.setOpaque(true);
		btnLaborario.setBounds(1, 72, 198, 30);
		cboBuscarPor.add(btnLaborario);
		btnLaborario.setForeground(new Color(68, 68, 68));
		btnLaborario.setFont(Constantes.regularFont);
		btnLaborario.setBorder(new EmptyBorder(0, 10, 0, 10));
		
		btnNombre = new JLabel("Nombre");
		btnNombre.setBackground(Color.WHITE);
		btnNombre.setOpaque(true);
		btnNombre.setBounds(1, 104, 198, 30);
		cboBuscarPor.add(btnNombre);
		btnNombre.setForeground(new Color(68, 68, 68));
		btnNombre.setCursor(Constantes.pointer);
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
				txtBuscar.setText(btnNombre.getText());
				cboBuscarPor.setVisible(false);
				getCboBuscarPor();
			}
		});
		btnNombre.setFont(Constantes.regularFont);
		btnNombre.setBorder(new EmptyBorder(0, 10, 0, 10));
		
		cboBackground = new JLabel("");
		cboBackground.setBorder(new EmptyBorder(0, 0, 0, 0));
		cboBackground.setBounds(0, 0, 200, 150);
		cboBuscarPor.add(cboBackground);
		cboBackground.setIcon(new ImageIcon(MantenimientoMedicinas.class.getResource("/views/images/contenedor-combo.png")));
		
		lblTitulo = new JLabel("Mantenimiento de Medicinas");
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
		txtDesc.setText("En esta secci\u00F3n podr\u00E1s ingresar datos de nuevas medicinas, actualizar y eliminar sus datos, adem\u00E1s de listar todos los registros de nuestra base de datos.");
		txtDesc.setBounds(25, 77, this.getWidth()-50, 22);
		txtDesc.setEditable(false);
		txtDesc.setForeground(Constantes.textgray);
		contentPane.add(txtDesc);
		
		btnClose.setIcon(new ImageIcon(MantenimientoMedicinas.class.getResource("/views/images/close.png")));
		btnClose.setBounds(this.getWidth()-25, 10, 16, 14);
		btnClose.setCursor(Constantes.pointer);
		contentPane.add(btnClose);
		
		lblBackground = new JLabel("Al ingresar, activamos la opc\u00F3n de listar por defecto.*");
		lblBackground.setBackground(Color.WHITE);
		lblBackground.setBorder(new LineBorder(Constantes.lightgray, 2));
		ImageIcon background = new ImageIcon(MantenimientoMedicinas.class.getResource("/views/images/background-mantenimiento.png"));
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
//				btnListar.setForeground(Constantes.skyblue);
				txtBuscar.setEnabled(false);
				lblInputBuscar.setEnabled(false);
				lblInputIngresar.setEnabled(false);
				txtIngresar.setEditable(false);
				txtIngresar.setEnabled(false);
				btnBuscar.setEnabled(false);
				lblBuscar.setEnabled(false);
				
				lblInputCodigo.setEnabled(false);
				txtCodigo.setEditable(false);
				lblInputNombres.setEnabled(false);
				txtNombre.setEditable(false);
				lblInputApellidos.setEnabled(false);
				txtLaboratorio.setEditable(false);
				lblInputTelefono.setEnabled(false);
				txtStock.setEditable(false);
				lblInputDni.setEnabled(false);
				txtPrecio.setEditable(false);
				
				txtCodigo.setText("");
				hideButtons();
			}
		});
		
		arrowBuscarPor = new JLabel("");
		arrowBuscarPor.setIcon(new ImageIcon(MantenimientoMedicinas.class.getResource("/views/images/ico-down.png")));
		arrowBuscarPor.setCursor(Constantes.pointer);
		arrowBuscarPor.setBounds(307, 222, 10, 14);
		
		contentPane.add(arrowBuscarPor);
		btnListar.setHorizontalAlignment(SwingConstants.CENTER);
		btnListar.setFont(Constantes.regularFont);
		btnListar.setForeground(Constantes.textgray);
		btnListar.setCursor(Constantes.pointer);
		btnListar.setBounds(121, 122, 64, 26);
		contentPane.add(btnListar);
		
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
				txtBuscar.setEnabled(false);
				lblInputBuscar.setEnabled(false);
				lblInputIngresar.setEnabled(false);
				txtIngresar.setEditable(false);
				txtIngresar.setEnabled(false);
				btnBuscar.setEnabled(false);
				lblBuscar.setEnabled(false);
				
				lblInputCodigo.setEnabled(false);
				txtCodigo.setEditable(false);
				lblInputNombres.setEnabled(true);
				txtNombre.setEditable(true);
				lblInputApellidos.setEnabled(true);
				txtLaboratorio.setEditable(true);
				lblInputTelefono.setEnabled(true);
				txtStock.setEditable(true);
				lblInputDni.setEnabled(true);
				txtPrecio.setEditable(true);
				
				hideButtons();
				lblIngresarConfirm.setVisible(true);
				btnIngresarConfirm.setVisible(true);
				
				autogenerateCode();
			}
		});
		btnIngresar.setHorizontalAlignment(SwingConstants.CENTER);
		btnIngresar.setFont(Constantes.regularFont);
		btnIngresar.setForeground(Constantes.textgray);
		btnIngresar.setBounds(307, 122, 64, 26);
		btnIngresar.setCursor(Constantes.pointer);
		contentPane.add(btnIngresar);
		
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
				
				lblInputCodigo.setEnabled(false);
				txtCodigo.setEditable(false);
				lblInputNombres.setEnabled(false);
				txtNombre.setEditable(false);
				lblInputApellidos.setEnabled(false);
				txtLaboratorio.setEditable(false);
				lblInputTelefono.setEnabled(false);
				txtStock.setEditable(false);
				lblInputDni.setEnabled(false);
				txtPrecio.setEditable(false);
				
				txtCodigo.setText("");
				hideButtons();
				resetFields();
				
			}
		});
		btnConsultar.setHorizontalAlignment(SwingConstants.CENTER);
		btnConsultar.setFont(Constantes.regularFont);
		btnConsultar.setForeground(Constantes.textgray);
		btnConsultar.setBounds(496, 122, 64, 26);
		btnConsultar.setCursor(Constantes.pointer);
		contentPane.add(btnConsultar);
		
		btnModificar = new JLabel("Modificar");
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnModificar.setForeground(Constantes.skyblue);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnModificar.setForeground(Constantes.textgray);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				changeOptionActive("Modificar");
				txtBuscar.setEnabled(true);
				lblInputBuscar.setEnabled(true);
				lblInputIngresar.setEnabled(true);
				txtIngresar.setEditable(true);
				txtIngresar.setEnabled(true);
				btnBuscar.setEnabled(true);
				lblBuscar.setEnabled(true);
				
				lblInputCodigo.setEnabled(false);
				txtCodigo.setEditable(false);
				lblInputNombres.setEnabled(true);
				txtNombre.setEditable(true);
				lblInputApellidos.setEnabled(true);
				txtLaboratorio.setEditable(true);
				lblInputTelefono.setEnabled(true);
				txtStock.setEditable(true);
				lblInputDni.setEnabled(true);
				txtPrecio.setEditable(true);
				
				hideButtons();
				lblModificarConfirm.setVisible(true);
				btnModificarConfirm.setVisible(true);
			}
		});
		btnModificar.setHorizontalAlignment(SwingConstants.CENTER);
		btnModificar.setFont(Constantes.regularFont);
		btnListar.setForeground(Constantes.textgray);
		btnModificar.setBounds(692, 122, 74, 26);
		btnModificar.setCursor(Constantes.pointer);
		contentPane.add(btnModificar);
		
		btnEliminar = new JLabel("Eliminar");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEliminar.setForeground(Constantes.skyblue);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEliminar.setForeground(Constantes.textgray);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				changeOptionActive("Eliminar");
				txtBuscar.setEnabled(true);
				lblInputBuscar.setEnabled(true);
				lblInputIngresar.setEnabled(true);
				txtIngresar.setEditable(true);
				txtIngresar.setEnabled(true);
				btnBuscar.setEnabled(true);
				lblBuscar.setEnabled(true);
				
				lblInputCodigo.setEnabled(false);
				txtCodigo.setEditable(false);
				lblInputNombres.setEnabled(false);
				txtNombre.setEditable(false);
				lblInputApellidos.setEnabled(false);
				txtLaboratorio.setEditable(false);
				lblInputTelefono.setEnabled(false);
				txtStock.setEditable(false);
				lblInputDni.setEnabled(false);
				txtPrecio.setEditable(false);
				
				hideButtons();
				lblEliminarConfirm.setVisible(true);
				btnEliminarConfirm.setVisible(true);
				
				txtCodigo.setText("");
				if(!txtNombre.getText().contentEquals("")){
					String getMedicina = txtNombre.getText();
					Medicina dropMedicina = medicina.buscarPorNombre(getMedicina);
					txtCodigo.setText(dropMedicina.getCodMedicina());
				}
			}
		});
		btnEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		btnEliminar.setFont(Constantes.regularFont);
		btnEliminar.setForeground(Constantes.textgray);
		btnEliminar.setBounds(864, 122, 74, 26);
		btnEliminar.setCursor(Constantes.pointer);
		contentPane.add(btnEliminar);
		
		txtIngresar = new JTextField();
		txtIngresar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0){
				int cboSelect = getCboBuscarPor();
				if(cboSelect == 0){
					mensaje("Asegurese de haber seleccionado un filtro e ingresado un tÈrmino de b˙squeda.");
				}
				else {
					if(cboSelect == 1){
						if(txtIngresar.getText().length() == 6){
							arg0.consume();
						}
					}
					if(cboSelect == 3){
						if(txtIngresar.getText().length() == 8){
							arg0.consume();
						}
					}
				}
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				int cboSelect = getCboBuscarPor();
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
							ArrayList<Medicina> buscarMedicina = medicina.listLaboratorio(term);
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
							ArrayList<Medicina> buscarMedicina = medicina.listNombre(term);
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
		txtIngresar.setEnabled(false);
		txtIngresar.setEditable(false);
		txtIngresar.setOpaque(false);
		txtIngresar.setForeground(new Color(68, 68, 68));
		txtIngresar.setFont(Constantes.regularFont);
		txtIngresar.setColumns(10);
		txtIngresar.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtIngresar.setBounds(663, 212, 251, 35);
		contentPane.add(txtIngresar);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setOpaque(false);
		txtNombre.setForeground(new Color(68, 68, 68));
		txtNombre.setFont(Constantes.regularFont);
		txtNombre.setColumns(10);
		txtNombre.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtNombre.setBounds(691, 286, 329, 35);
		contentPane.add(txtNombre);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setOpaque(false);
		txtPrecio.setForeground(new Color(68, 68, 68));
		txtPrecio.setFont(Constantes.regularFont);
		txtPrecio.setColumns(10);
		txtPrecio.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtPrecio.setBounds(692, 332, 329, 35);
		contentPane.add(txtPrecio);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setOpaque(false);
		txtCodigo.setForeground(new Color(68, 68, 68));
		txtCodigo.setFont(Constantes.regularFont);
		txtCodigo.setColumns(10);
		txtCodigo.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtCodigo.setBounds(137, 286, 329, 35);
		contentPane.add(txtCodigo);
		
		txtStock = new JTextField();
		txtStock.setEditable(false);
		txtStock.setOpaque(false);
		txtStock.setForeground(new Color(68, 68, 68));
		txtStock.setFont(Constantes.regularFont);
		txtStock.setColumns(10);
		txtStock.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtStock.setBounds(137, 379, 329, 35);
		contentPane.add(txtStock);
		
		txtLaboratorio = new JTextField();
		txtLaboratorio.setEditable(false);
		txtLaboratorio.setOpaque(false);
		txtLaboratorio.setForeground(new Color(68, 68, 68));
		txtLaboratorio.setFont(Constantes.regularFont);
		txtLaboratorio.setColumns(10);
		txtLaboratorio.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtLaboratorio.setBounds(137, 332, 329, 35);
		contentPane.add(txtLaboratorio);
		
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
					txtIngresar.setText("MED");
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
		lblInputBuscar.setIcon(new ImageIcon(MantenimientoMedicinas.class.getResource("/views/images/text-buscar.png")));
		lblInputBuscar.setBounds(127, 212, 200, 35);
		contentPane.add(lblInputBuscar);
		
		lblBuscarPor = new JLabel("Buscar por:");
		lblBuscarPor.setFont(Constantes.regularFont);
		lblBuscarPor.setForeground(Constantes.textgray);
		lblBuscarPor.setBounds(24, 212, 87, 35);
		contentPane.add(lblBuscarPor);
		
		lblInputIngresar = new JLabel("");
		lblInputIngresar.setEnabled(false);
		lblInputIngresar.setIcon(new ImageIcon(MantenimientoMedicinas.class.getResource("/views/images/text-ingresar.png")));
		lblInputIngresar.setBounds(655, 212, 266, 35);
		contentPane.add(lblInputIngresar);
		
		lblIngresar = new JLabel("Ingrese dato seg\u00FAn su selecci\u00F3n:");
		lblIngresar.setForeground(new Color(68, 68, 68));
		lblIngresar.setFont(Constantes.regularFont);
		lblIngresar.setBounds(428, 212, 217, 35);
		contentPane.add(lblIngresar);
		
		lblBuscar = new JLabel("Buscar");
		lblBuscar.setEnabled(false);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(Constantes.regularFont);
		lblBuscar.setBounds(931, 212, 100, 35);
		lblBuscar.setCursor(Constantes.pointer);
		contentPane.add(lblBuscar);
		
		btnBuscar = new JLabel("");
		btnBuscar.setEnabled(false);
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBuscar.setIcon(new ImageIcon(MantenimientoMedicinas.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBuscar.setIcon(new ImageIcon(MantenimientoMedicinas.class.getResource("/views/images/btn-login.png")));
			}
			void mostrarDatos(Medicina data){
				txtCodigo.setText(data.getCodMedicina());
				txtNombre.setText(data.getNombre());
				txtLaboratorio.setText(data.getLaboratorio());
				txtPrecio.setText("" + data.getPrecio());
				txtStock.setText("" + data.getStock());
				resetearBusqueda();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnBuscar.isEnabled()){
					int cboSelect = getCboBuscarPor();
					if(getBusquedaCodigo().contentEquals("") || cboSelect == 0){
						mensaje("Asegurese de haber seleccionado un filtro e ingresado un tÈrmino de b˙squeda.");
					}
					else {
						String term = getBusquedaCodigo();
						if(cboSelect == 1){
							if(term.matches("MED\\d{3}")){
								Medicina buscarMedicina = medicina.buscarPorCodigo(term);
								if(buscarMedicina != null){
									mostrarDatos(buscarMedicina);
								}
								else {
									mensaje("No hay registros de pacientes con este cÛdigo.");
								}
							}
							else {
								mensaje("El cÛdigo no ha sido ingresado en un formato correcto.\nEjemplo: \"MED001\"");
							}
						}
						if(cboSelect == 2){
							if(term.matches("[a-zA-ZÒ—·ÈÌÛ˙¡…Õ”⁄\\s+]{3,25}") || term.matches("[a-zA-ZÒ—·ÈÌÛ˙¡…Õ”⁄+]{3,25}")){
								Medicina buscarMedicina = medicina.buscarPorLaboratorio(term);
								if(buscarMedicina != null){
									mostrarDatos(buscarMedicina);
								}
								else {
									mensaje("No hay registros de pacientes con este nombre de laboratorio.");
								}
							}
							else {
								mensaje("El laboratorio no ha sido ingresado en un formato correcto.\nIngrese sÛlo letras.");
							}
						}
						if(cboSelect == 3){
							if(term.matches("[a-zA-ZÒ—·ÈÌÛ˙¡…Õ”⁄\\s+]{3,25}")){
								Medicina buscarMedicina = medicina.buscarPorNombre(term);
								if(buscarMedicina != null){
									mostrarDatos(buscarMedicina);
								}
								else {
									mensaje("No hay registros de pacientes con este Nombre.");
								}
							}
							else {
								mensaje("El nombre no ha sido ingresado en un formato correcto.\nEjemplo: \"Paracetamol\"");
							}
						}
					}
				}
				else {
					return;
				}
			}
		});
		btnBuscar.setIcon(new ImageIcon(MantenimientoMedicinas.class.getResource("/views/images/btn-login.png")));
		btnBuscar.setCursor(Constantes.pointer);
		btnBuscar.setBounds(931, 212, 100, 35);
		contentPane.add(btnBuscar);
		
		lblAviso = new JLabel("* Opci\u00F3n activa: Listar");
		lblAviso.setHorizontalAlignment(SwingConstants.LEFT);
		lblAviso.setFont(Constantes.regularFont);
		lblAviso.setBounds(25, 167, 172, 26);
		lblAviso.setForeground(Constantes.skyblue);
		contentPane.add(lblAviso);
		
		lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setForeground(new Color(68, 68, 68));
		lblCodigo.setFont(Constantes.regularFont);
		lblCodigo.setBounds(25, 286, 87, 35);
		contentPane.add(lblCodigo);
		
		lblInputCodigo = new JLabel("");
		lblInputCodigo.setEnabled(false);
		lblInputCodigo.setIcon(new ImageIcon(MantenimientoMedicinas.class.getResource("/views/images/input-text-mantenimiento.png")));
		lblInputCodigo.setBounds(127, 286, 349, 35);
		contentPane.add(lblInputCodigo);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(new Color(68, 68, 68));
		lblNombre.setFont(Constantes.regularFont);
		lblNombre.setBounds(580, 286, 87, 35);
		contentPane.add(lblNombre);
		
		lblInputNombres = new JLabel("");
		lblInputNombres.setEnabled(false);
		lblInputNombres.setIcon(new ImageIcon(MantenimientoMedicinas.class.getResource("/views/images/input-text-mantenimiento.png")));
		lblInputNombres.setBounds(682, 286, 349, 35);
		contentPane.add(lblInputNombres);
		
		lblLaboratorio = new JLabel("Laboratorio:");
		lblLaboratorio.setForeground(new Color(68, 68, 68));
		lblLaboratorio.setFont(Constantes.regularFont);
		lblLaboratorio.setBounds(25, 332, 87, 35);
		contentPane.add(lblLaboratorio);
		
		lblInputApellidos = new JLabel("");
		lblInputApellidos.setEnabled(false);
		lblInputApellidos.setIcon(new ImageIcon(MantenimientoMedicinas.class.getResource("/views/images/input-text-mantenimiento.png")));
		lblInputApellidos.setBounds(127, 332, 349, 35);
		contentPane.add(lblInputApellidos);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setForeground(new Color(68, 68, 68));
		lblPrecio.setFont(Constantes.regularFont);
		lblPrecio.setBounds(580, 332, 87, 35);
		contentPane.add(lblPrecio);
		
		lblInputDni = new JLabel("");
		lblInputDni.setEnabled(false);
		lblInputDni.setIcon(new ImageIcon(MantenimientoMedicinas.class.getResource("/views/images/input-text-mantenimiento.png")));
		lblInputDni.setBounds(682, 332, 349, 35);
		contentPane.add(lblInputDni);
		
		lblStock = new JLabel("Stock:");
		lblStock.setForeground(new Color(68, 68, 68));
		lblStock.setFont(Constantes.regularFont);
		lblStock.setBounds(25, 379, 87, 35);
		contentPane.add(lblStock);
		
		lblInputTelefono = new JLabel("");
		lblInputTelefono.setEnabled(false);
		lblInputTelefono.setIcon(new ImageIcon(MantenimientoMedicinas.class.getResource("/views/images/input-text-mantenimiento.png")));
		lblInputTelefono.setBounds(127, 379, 349, 35);
		contentPane.add(lblInputTelefono);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 438, 1006, 254);
		contentPane.add(scrollPane);
		
		tblTabla = new JScrollPane();
		scrollPane.setViewportView(tblTabla);
		
		table = new JTable();
		table.setEnabled(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowIndex = table.getSelectedRow();
				String code = table.getValueAt(rowIndex, 0).toString();
				Medicina getMedicina = medicina.buscarPorCodigo(code);
				txtCodigo.setText(getMedicina.getCodMedicina());
				txtNombre.setText(getMedicina.getNombre());
				txtLaboratorio.setText(getMedicina.getLaboratorio());
				txtPrecio.setText("" + getMedicina.getPrecio());
				txtStock.setText("" + getMedicina.getStock());
			}
		});
		table.setForeground(Constantes.textgray);
		table.setFont(Constantes.regularFont);
		table.setRowHeight(30);
		table.setFillsViewportHeight(true);
		tblTabla.setViewportView(table);
		
		tabla = new DefaultTableModel();
		tabla.addColumn("CÛdigo");
		tabla.addColumn("Nombre");
		tabla.addColumn("Laboratorio");
		tabla.addColumn("Precio");
		tabla.addColumn("Stock");
		table.setModel(tabla);
		
		lblIngresarConfirm = new JLabel("Ingresar");
		lblIngresarConfirm.setFont(Constantes.regularFont);
		lblIngresarConfirm.setCursor(Constantes.pointer);
		lblIngresarConfirm.setForeground(Color.WHITE);
		lblIngresarConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresarConfirm.setBounds(931, 380, 100, 34);
		lblIngresarConfirm.setVisible(false);
		contentPane.add(lblIngresarConfirm);
		
		btnIngresarConfirm = new JLabel("");
		btnIngresarConfirm.setVisible(false);
		btnIngresarConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIngresarConfirm.setIcon(new ImageIcon(MantenimientoMedicinas.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIngresarConfirm.setIcon(new ImageIcon(MantenimientoMedicinas.class.getResource("/views/images/btn-login.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String nombre = validarNombre();
					if(nombre == null) return;
					
					String laboratorio = validarLaboratorio();
					if(laboratorio == null) return;
					
					double precio = validarPrecio();
					if(precio == 0) return;
					
					int stock = validarStock();
					if(stock == 0) return;
					
					int option = JOptionPane.showConfirmDialog(null, "øEst· seguro de ingresar los registros de un nuevo paciente?", "Confirmar ingreso de datos", JOptionPane.OK_CANCEL_OPTION);
					if(option == 0){
						Medicina newMedicina = new Medicina(txtCodigo.getText(), nombre, laboratorio, precio, stock);
						medicina.adicionar(newMedicina);
						medicina.agregarMedicina();
						
						mensaje("Los nuevos registros han sido grabados correctamente.");
						listarMedicinas();
						resetFields();
						autogenerateCode();
					}
				}
				catch(Exception er){
					mensaje("Hubo un error en el ingreso de datos.");
					System.out.println(er);
				}
			}
		});
		btnIngresarConfirm.setIcon(new ImageIcon(MantenimientoMedicinas.class.getResource("/views/images/btn-login.png")));
		btnIngresarConfirm.setBounds(931, 379, 100, 35);
		contentPane.add(btnIngresarConfirm);
		
		lblModificarConfirm = new JLabel("Modificar");
		lblModificarConfirm.setFont(Constantes.regularFont);
		lblModificarConfirm.setCursor(Constantes.pointer);
		lblModificarConfirm.setForeground(Color.WHITE);
		lblModificarConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificarConfirm.setBounds(931, 380, 100, 34);
		lblModificarConfirm.setVisible(false);
		contentPane.add(lblModificarConfirm);
		
		btnModificarConfirm = new JLabel("");
		btnModificarConfirm.setVisible(false);
		btnModificarConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIngresarConfirm.setIcon(new ImageIcon(MantenimientoMedicinas.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIngresarConfirm.setIcon(new ImageIcon(MantenimientoMedicinas.class.getResource("/views/images/btn-login.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String nombre = validarNombre();
					if(nombre == null) return;
					
					String laboratorio = validarLaboratorio();
					if(laboratorio == null) return;
					
					double precio = validarPrecio();
					if(precio == 0) return;
					
					int stock = validarStock();
					if(stock == 0) return;
					
					int option = JOptionPane.showConfirmDialog(null, "øEst· seguro de modificar los registros de este paciente?", "Confirmar modificaciÛn", JOptionPane.OK_CANCEL_OPTION);
					if(option == 0){
						String codigo = txtCodigo.getText();
						Medicina modMedicina = medicina.buscarPorCodigo(codigo);
						modMedicina.setNombre(nombre);
						modMedicina.setLaboratorio(laboratorio);
						modMedicina.setPrecio(precio);
						modMedicina.setStock(stock);
						
						mensaje("Los registros de este paciente han sido actualizados correctamente.");
						medicina.agregarMedicina();
						listarMedicinas();
						resetFields();
					}
				}
				catch(Exception er){
					mensaje("Hubo un error en el ingreso de datos.");
				}
			}
		});
		btnModificarConfirm.setIcon(new ImageIcon(MantenimientoMedicinas.class.getResource("/views/images/btn-login.png")));
		btnModificarConfirm.setBounds(931, 379, 100, 35);
		contentPane.add(btnModificarConfirm);
		
		lblEliminarConfirm = new JLabel("Eliminar");
		lblEliminarConfirm.setFont(Constantes.regularFont);
		lblEliminarConfirm.setCursor(Constantes.pointer);
		lblEliminarConfirm.setForeground(Color.WHITE);
		lblEliminarConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarConfirm.setBounds(931, 380, 100, 34);
		lblEliminarConfirm.setVisible(false);
		contentPane.add(lblEliminarConfirm);
		
		btnEliminarConfirm = new JLabel("");
		btnEliminarConfirm.setVisible(false);
		btnEliminarConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIngresarConfirm.setIcon(new ImageIcon(MantenimientoMedicinas.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIngresarConfirm.setIcon(new ImageIcon(MantenimientoMedicinas.class.getResource("/views/images/btn-login.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				String codigo = txtCodigo.getText();
				Medicina dropMedicina = medicina.buscarPorCodigo(codigo);
				if(dropMedicina != null){
					int option = JOptionPane.showConfirmDialog(null, "øEst· seguro de eliminar los registros de este paciente?", "Confirmar eliminaciÛn", JOptionPane.OK_CANCEL_OPTION);
					if(option == 0){
						medicina.eliminarMedicina(dropMedicina);
						medicina.agregarMedicina();
						listarMedicinas();
						resetFields();
						mensaje("Los registros de este paciente han sido eliminados correctamente.");
					}
				}
				else {
					mensaje("No has ingresado pacientes para eliminar.");
				}
			}
		});
		btnEliminarConfirm.setIcon(new ImageIcon(MantenimientoMedicinas.class.getResource("/views/images/btn-login.png")));
		btnEliminarConfirm.setBounds(931, 379, 100, 35);
		contentPane.add(btnEliminarConfirm);
		
		lblBackground.setIcon(backfinal);
		lblBackground.setBounds(0, 0, xSize-310, ySize-50);
		contentPane.add(lblBackground);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		//Ubicar la barra de men˙ en la parte superior izquierda de la pantalla
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX() - this.getWidth();
        int y = (int) rect.getMinY();
        setLocation(x, y);
        setVisible(true);
        
        listarMedicinas();
	}
	
	private int getCboBuscarPor(){
		String cboSelect = txtBuscar.getText();
		if(cboSelect.contentEquals("CÛdigo de medicina"))
			return 1;
		else if(cboSelect.contentEquals("Laboratorio"))
			return 2;
		else if(cboSelect.contentEquals("Nombre"))
			return 3;
		else
			return 0;
	}
	
	String getNombre(){
		return txtNombre.getText();
	}
	
	String getLaboratorio(){
		return txtLaboratorio.getText();
	}
	
	double getPrecio(){
		return Double.parseDouble(txtPrecio.getText());
	}
	
	int getStock(){
		return Integer.parseInt(txtStock.getText());
	}
	
	private void listarMedicinas(){
		tabla.setRowCount(0);
		for(int i = 0; i < medicina.tamanio(); i++){
			Object[] data = {
				medicina.obtener(i).getCodMedicina(),
				medicina.obtener(i).getNombre(),
				medicina.obtener(i).getLaboratorio(),
				medicina.obtener(i).getPrecio(),
				medicina.obtener(i).getStock()
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
		txtCodigo.setText("");
		txtNombre.setText("");
		txtLaboratorio.setText("");
		txtPrecio.setText("");
		txtStock.setText("");
	}
	
	private void changeOptionActive(String optionActive){
		String text = lblAviso.getText().split(":")[0];
		lblAviso.setText(text + ": " + optionActive);
	}
	
	private void hideButtons(){
		lblIngresarConfirm.setVisible(false);
		btnIngresarConfirm.setVisible(false);
		lblModificarConfirm.setVisible(false);
		btnModificarConfirm.setVisible(false);
		lblEliminarConfirm.setVisible(false);
		btnEliminarConfirm.setVisible(false);
	}
	
	private String validarNombre(){
		String nombre = "";
		if(getNombre().matches("[a-zA-ZÒ—·ÈÌÛ˙¡…Õ”⁄\\s+]{3,25}"))
			nombre = getNombre();
		else {
			mensaje("Ingrese un nombre correcto por favor.\nEjemplo: \"Naproxeno Forte\".");
			txtNombre.requestFocus();
			return null;
		}
		return nombre;
	}
	
	private String validarLaboratorio(){
		String apellidos = "";
		if(getLaboratorio().matches("[a-zA-ZÒ—·ÈÌÛ˙¡…Õ”⁄\\-\\s+]{3,25}"))
			apellidos = getLaboratorio();
		else {
			mensaje("Ingrese el nombre del laboratorio correctamente por favor.\nEjemplo: \"Vademecum\".");
			txtLaboratorio.requestFocus();
			return null;
		}
		return apellidos;
	}
	
	private double validarPrecio(){
		double precio = 0.0;
		if(!txtPrecio.getText().contentEquals("") && (txtPrecio.getText().matches("(\\d+)(\\.)(\\d+)") || txtPrecio.getText().matches("(\\d+)")))
			precio = getPrecio();
		else {
			mensaje("Ingrese correctamente el precio.\nEjemplo: \"10.5\".");
			txtPrecio.requestFocus();
			return 0;
		}
		return precio;
	}
	
	private int validarStock(){
		int stock = 0;
		if(!txtStock.getText().contentEquals("") && txtStock.getText().matches("(\\d+)"))
				stock = getStock();
		else {
			mensaje("Ingrese correctamente el stock.\nEjemplo: \"150\"\nSÛlo n˙meros.");
			txtStock.requestFocus();
			return 0;
		}
		return stock;
	}
	
	private void autogenerateCode(){
		int lastCode = medicina.obtenerUltimoCodigo() + 1;
		String newCode = "MED";
		if(Integer.toString(lastCode).length() == 1) newCode += "00" + lastCode;
		if(Integer.toString(lastCode).length() == 2) newCode += "0" + lastCode;
		if(Integer.toString(lastCode).length() == 3) newCode += "" + lastCode;
		txtCodigo.setText(newCode);
	}
	
}
