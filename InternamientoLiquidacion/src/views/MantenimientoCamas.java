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
import controllers.MantenimientoCamasController;
import models.Cama;

public class MantenimientoCamas extends JFrame {

	MantenimientoCamasController cama = new MantenimientoCamasController("camas.txt");
	
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
	private JLabel lblPrecio;
	private JLabel lblInputPrecio;
	private JLabel lblEstado;
	private JLabel lblInputEstado;
	private JTextField txtBuscar;
	private JTextField txtIngresar;
	private JTextField txtCodigo;
	private JTextField txtEstado;
	private JTextField txtPrecio;
	private JTable table;
	private JScrollPane tblTabla;
	private DefaultTableModel tabla;
	private JScrollPane scrollPane;
	private JLabel arrowBuscarPor;
	private JLabel cboBackground;
	private JLabel btnSeleccionar;
	private JLabel btnCodigo;
	private JLabel btnEstado;
	private JPanel cboBuscarPor;
	private JLabel btnIngresarConfirm;
	private JLabel btnModificarConfirm;
	private JLabel btnEliminarConfirm;
	private JLabel lblIngresarConfirm;
	private JLabel lblModificarConfirm;
	private JLabel lblEliminarConfirm;
	private JPanel cboEstado;
	private JLabel cboEstadoBackground;
	private JLabel btnSeleccionarEstado;
	private JLabel btnLibre;
	private JLabel btnOcupado;
	private JLabel label;
	private JLabel arrBuscarEstado;
	private JPanel cboBuscarEstado;
	private JLabel btnSelectBuscarEstado;
	private JLabel btnBuscarOcupado;
	private JLabel btnBuscarLibre;
	private JLabel lblNewLabel;

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
					MantenimientoCamas frame = new MantenimientoCamas();
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
	public MantenimientoCamas() {
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
				btnClose.setIcon(new ImageIcon(MantenimientoCamas.class.getResource("/views/images/close-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnClose.setIcon(new ImageIcon(MantenimientoCamas.class.getResource("/views/images/close.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
		cboBuscarPor = new JPanel();
		cboBuscarPor.setBorder(new EmptyBorder(0, 0, 0, 0));
		cboBuscarPor.setVisible(false);
		
		cboEstado = new JPanel();
		cboEstado.setVisible(false);
		
		cboBuscarEstado = new JPanel();
		cboBuscarEstado.setVisible(false);
		cboBuscarEstado.setBorder(new EmptyBorder(0, 0, 0, 0));
		cboBuscarEstado.setBounds(655, 249, 266, 115);
		contentPane.add(cboBuscarEstado);
		cboBuscarEstado.setLayout(null);
		
		btnSelectBuscarEstado = new JLabel("Seleccionar --");
		btnSelectBuscarEstado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent evt) {
				btnSelectBuscarEstado.setBackground(Constantes.hoverFont);
			}
			@Override
			public void mouseExited(MouseEvent evt) {
				btnSelectBuscarEstado.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent evt) {
				txtIngresar.setText(btnSelectBuscarEstado.getText());
				cboBuscarEstado.setVisible(false);
				listarCamas();
			}
		});
		btnSelectBuscarEstado.setCursor(Constantes.pointer);
		btnSelectBuscarEstado.setOpaque(true);
		btnSelectBuscarEstado.setForeground(Constantes.textgray);
		btnSelectBuscarEstado.setFont(Constantes.regularFont);
		btnSelectBuscarEstado.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnSelectBuscarEstado.setBackground(Color.WHITE);
		btnSelectBuscarEstado.setBounds(1, 11, 264, 30);
		cboBuscarEstado.add(btnSelectBuscarEstado);
		
		btnBuscarOcupado = new JLabel("Ocupado");
		btnBuscarOcupado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent evt) {
				btnBuscarOcupado.setBackground(Constantes.hoverFont);
			}
			@Override
			public void mouseExited(MouseEvent evt) {
				btnBuscarOcupado.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent evt) {
				txtIngresar.setText(btnBuscarOcupado.getText());
				cboBuscarEstado.setVisible(false);
				listaPorEstado();
			}
		});
		btnBuscarOcupado.setCursor(Constantes.pointer);
		btnBuscarOcupado.setOpaque(true);
		btnBuscarOcupado.setForeground(Constantes.textgray);
		btnBuscarOcupado.setFont(Constantes.regularFont);
		btnBuscarOcupado.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnBuscarOcupado.setBackground(Color.WHITE);
		btnBuscarOcupado.setBounds(1, 42, 264, 30);
		cboBuscarEstado.add(btnBuscarOcupado);
		
		btnBuscarLibre = new JLabel("Libre");
		btnBuscarLibre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent evt) {
				btnBuscarLibre.setBackground(Constantes.hoverFont);
			}
			@Override
			public void mouseExited(MouseEvent evt) {
				btnBuscarLibre.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent evt) {
				txtIngresar.setText(btnBuscarLibre.getText());
				cboBuscarEstado.setVisible(false);
				listaPorEstado();
			}
		});
		btnBuscarLibre.setCursor(Constantes.pointer);
		btnBuscarLibre.setOpaque(true);
		btnBuscarLibre.setForeground(Constantes.textgray);
		btnBuscarLibre.setFont(Constantes.regularFont);
		btnBuscarLibre.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnBuscarLibre.setBackground(Color.WHITE);
		btnBuscarLibre.setBounds(1, 73, 264, 30);
		cboBuscarEstado.add(btnBuscarLibre);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(MantenimientoCamas.class.getResource("/views/images/contenedor-combo-buscar-estado.png")));
		lblNewLabel.setBounds(0, 0, 266, 115);
		cboBuscarEstado.add(lblNewLabel);
		cboEstado.setBounds(127, 369, 349, 150);
		contentPane.add(cboEstado);
		cboEstado.setLayout(null);
		
		btnSeleccionarEstado = new JLabel("Seleccionar --");
		btnSeleccionarEstado.setOpaque(true);
		btnSeleccionarEstado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSeleccionarEstado.setBackground(Constantes.hoverFont);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSeleccionarEstado.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				txtEstado.setText(btnSeleccionarEstado.getText());
				cboEstado.setVisible(false);
			}
		});
		btnSeleccionarEstado.setForeground(Constantes.textgray);
		btnSeleccionarEstado.setBackground(Color.WHITE);
		btnSeleccionarEstado.setCursor(Constantes.pointer);
		btnSeleccionarEstado.setFont(Constantes.regularFont);
		btnSeleccionarEstado.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnSeleccionarEstado.setBounds(1, 12, 347, 30);
		cboEstado.add(btnSeleccionarEstado);
		
		btnLibre = new JLabel("Libre");
		btnLibre.setOpaque(true);
		btnLibre.setBackground(Color.WHITE);
		btnLibre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLibre.setBackground(Constantes.hoverFont);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnLibre.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				txtEstado.setText(btnLibre.getText());
				cboEstado.setVisible(false);
			}
		});
		btnLibre.setForeground(Constantes.textgray);
		btnLibre.setCursor(Constantes.pointer);
		btnLibre.setFont(Constantes.regularFont);
		btnLibre.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnLibre.setBounds(1, 42, 347, 30);
		cboEstado.add(btnLibre);
		
		btnOcupado = new JLabel("Ocupado");
		btnOcupado.setOpaque(true);
		btnOcupado.setBackground(Color.WHITE);
		btnOcupado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnOcupado.setBackground(Constantes.hoverFont);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnOcupado.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				txtEstado.setText(btnOcupado.getText());
				cboEstado.setVisible(false);
			}
		});
		btnOcupado.setForeground(Constantes.textgray);
		btnOcupado.setCursor(Constantes.pointer);
		btnOcupado.setFont(Constantes.regularFont);
		btnOcupado.setBorder(new EmptyBorder(0, 10, 0, 10));
		btnOcupado.setBounds(1, 73, 347, 30);
		cboEstado.add(btnOcupado);
		
		cboEstadoBackground = new JLabel("");
		cboEstadoBackground.setIcon(new ImageIcon(MantenimientoCamas.class.getResource("/views/images/contenedor-combo-estado.png")));
		cboEstadoBackground.setBounds(0, 0, 349, 150);
		cboEstado.add(cboEstadoBackground);
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
		
		btnCodigo = new JLabel("C\u00F3digo de cama");
		btnCodigo.setBackground(Color.WHITE);
		btnCodigo.setCursor(Constantes.pointer);
		btnCodigo.setBounds(1, 41, 198, 30);
		btnCodigo.setOpaque(true);
		cboBuscarPor.add(btnCodigo);
		btnCodigo.setForeground(Constantes.textgray);
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
		
		btnEstado = new JLabel("Estado");
		btnEstado.setBackground(Color.WHITE);
		btnEstado.setCursor(Constantes.pointer);
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
				txtBuscar.setText(btnEstado.getText());
				cboBuscarPor.setVisible(false);
				getCboBuscarPor();
				arrBuscarEstado.setVisible(true);
				txtIngresar.setCursor(Constantes.pointer);
				txtIngresar.setEditable(false);
				txtIngresar.requestFocus(false);
				txtIngresar.setText("Seleccionar --");
			}
		});
		btnEstado.setOpaque(true);
		btnEstado.setBounds(1, 72, 198, 30);
		cboBuscarPor.add(btnEstado);
		btnEstado.setForeground(Constantes.textgray);
		btnEstado.setFont(Constantes.regularFont);
		btnEstado.setBorder(new EmptyBorder(0, 10, 0, 10));
		
		cboBackground = new JLabel("");
		cboBackground.setBorder(new EmptyBorder(0, 0, 0, 0));
		cboBackground.setBounds(0, 0, 200, 150);
		cboBuscarPor.add(cboBackground);
		cboBackground.setIcon(new ImageIcon(MantenimientoCamas.class.getResource("/views/images/contenedor-combo.png")));
		
		lblTitulo = new JLabel("Mantenimiento de Camas");
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
		txtDesc.setText("En esta secci\u00F3n podr\u00E1s ingresar datos de camas, actualizar y eliminar sus datos, adem\u00E1s de listar todos los registros de nuestra base de datos.");
		txtDesc.setBounds(25, 77, this.getWidth()-50, 22);
		txtDesc.setEditable(false);
		txtDesc.setForeground(Constantes.textgray);
		contentPane.add(txtDesc);
		
		btnClose.setIcon(new ImageIcon(MantenimientoCamas.class.getResource("/views/images/close.png")));
		btnClose.setBounds(this.getWidth()-25, 10, 16, 14);
		btnClose.setCursor(Constantes.pointer);
		contentPane.add(btnClose);
		
		lblBackground = new JLabel("Al ingresar, activamos la opc\u00F3n de listar por defecto.*");
		lblBackground.setBackground(Color.WHITE);
		lblBackground.setBorder(new LineBorder(Constantes.lightgray, 2));
		ImageIcon background = new ImageIcon(MantenimientoCamas.class.getResource("/views/images/background-mantenimiento.png"));
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
				
				lblInputCodigo.setEnabled(false);
				txtCodigo.setEditable(false);
				lblInputPrecio.setEnabled(false);
				txtPrecio.setEditable(false);
				lblInputEstado.setEnabled(false);
				txtEstado.setCursor(Constantes.defaultCursor);
				
				txtCodigo.setText("");
				hideButtons();
				listarCamas();
			}
		});
		
		arrowBuscarPor = new JLabel("");
		arrowBuscarPor.setIcon(new ImageIcon(MantenimientoCamas.class.getResource("/views/images/ico-down.png")));
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
				lblInputPrecio.setEnabled(true);
				txtPrecio.setEditable(true);
				lblInputEstado.setEnabled(true);
				txtEstado.setEnabled(true);
				txtEstado.setCursor(Constantes.pointer);
				
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
				lblInputPrecio.setEnabled(false);
				txtPrecio.setEditable(false);
				lblInputEstado.setEnabled(false);
				
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
				lblInputPrecio.setEnabled(true);
				txtPrecio.setEditable(true);
				lblInputEstado.setEnabled(true);
				txtEstado.setEnabled(true);
				txtEstado.setCursor(Constantes.pointer);
				
				hideButtons();
				lblModificarConfirm.setVisible(true);
				btnModificarConfirm.setVisible(true);
				
//				if(!txtEstado.getText().contentEquals("")){
//					String apellido = getApellidos();
//					Paciente modPaciente = paciente.buscarPorApellido(apellido);
//					txtNumero.setText(modPaciente.getCodPaciente());
//				}
//				else
//					txtNumero.setText("");
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
				lblInputPrecio.setEnabled(false);
				txtPrecio.setEditable(false);
				lblInputEstado.setEnabled(false);
				txtEstado.setCursor(Constantes.defaultCursor);
				
				hideButtons();
				lblEliminarConfirm.setVisible(true);
				btnEliminarConfirm.setVisible(true);
			}
		});
		btnEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		btnEliminar.setFont(Constantes.regularFont);
		btnEliminar.setForeground(Constantes.textgray);
		btnEliminar.setBounds(864, 122, 74, 26);
		btnEliminar.setCursor(Constantes.pointer);
		contentPane.add(btnEliminar);
		
		arrBuscarEstado = new JLabel("");
		arrBuscarEstado.setVisible(false);
		arrBuscarEstado.setIcon(new ImageIcon(MantenimientoCamas.class.getResource("/views/images/ico-down.png")));
		arrBuscarEstado.setBounds(904, 222, 10, 14);
		contentPane.add(arrBuscarEstado);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(MantenimientoCamas.class.getResource("/views/images/ico-down.png")));
		label.setBounds(455, 343, 10, 14);
		contentPane.add(label);
		
		txtIngresar = new JTextField();
		txtIngresar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				int select = getCboBuscarPor();
				if(select == 1){
					if(txtIngresar.getText().length() == 6){
						evt.consume();
					}
				}
			}
		});
		txtIngresar.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent evt){
				if(!txtIngresar.isEditable()){
					boolean status = (cboBuscarEstado.isVisible()) ? false : true;
					cboBuscarEstado.setVisible(status);
				}
				else {
					return;
				}
			}
		});
		txtIngresar.setEnabled(false);
		txtIngresar.setEditable(false);
		txtIngresar.setOpaque(false);
		txtIngresar.setForeground(Constantes.textgray);
		txtIngresar.setFont(Constantes.regularFont);
		txtIngresar.setColumns(10);
		txtIngresar.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtIngresar.setBounds(663, 212, 251, 35);
		contentPane.add(txtIngresar);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setOpaque(false);
		txtPrecio.setForeground(Constantes.textgray);
		txtPrecio.setFont(Constantes.regularFont);
		txtPrecio.setColumns(10);
		txtPrecio.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtPrecio.setBounds(691, 286, 329, 35);
		contentPane.add(txtPrecio);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setOpaque(false);
		txtCodigo.setForeground(Constantes.textgray);
		txtCodigo.setFont(Constantes.regularFont);
		txtCodigo.setColumns(10);
		txtCodigo.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtCodigo.setBounds(137, 286, 329, 35);
		contentPane.add(txtCodigo);
		
		txtEstado = new JTextField();
		txtEstado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!txtEstado.isEnabled()){
					return;
				}
				else {
					if(cboEstado.isVisible()){
						cboEstado.setVisible(false);
					}
					else {
						cboEstado.setVisible(true);
					}
				}
			}
		});
		txtEstado.setText("Seleccionar --");
		txtEstado.setEditable(false);
		txtEstado.setOpaque(false);
		txtEstado.setEnabled(false);
		txtEstado.setDisabledTextColor(Constantes.textgray);
		txtEstado.setForeground(Constantes.textgray);
		txtEstado.setFont(Constantes.regularFont);
		txtEstado.setColumns(10);
		txtEstado.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtEstado.setBounds(137, 332, 329, 35);
		contentPane.add(txtEstado);
		
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
					txtIngresar.setText("CAM");
					txtIngresar.requestFocus();
					arrBuscarEstado.setVisible(false);
					txtIngresar.setCursor(Constantes.textCursor);
					txtIngresar.setEditable(true);
					txtIngresar.requestFocus(true);
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
		lblInputBuscar.setIcon(new ImageIcon(MantenimientoCamas.class.getResource("/views/images/text-buscar.png")));
		lblInputBuscar.setBounds(127, 212, 200, 35);
		contentPane.add(lblInputBuscar);
		
		lblBuscarPor = new JLabel("Buscar por:");
		lblBuscarPor.setFont(Constantes.regularFont);
		lblBuscarPor.setForeground(Constantes.textgray);
		lblBuscarPor.setBounds(24, 212, 87, 35);
		contentPane.add(lblBuscarPor);
		
		lblInputIngresar = new JLabel("");
		lblInputIngresar.setEnabled(false);
		lblInputIngresar.setIcon(new ImageIcon(MantenimientoCamas.class.getResource("/views/images/text-ingresar.png")));
		lblInputIngresar.setBounds(655, 212, 266, 35);
		contentPane.add(lblInputIngresar);
		
		lblIngresar = new JLabel("Ingrese dato seg\u00FAn su selecci\u00F3n:");
		lblIngresar.setForeground(Constantes.textgray);
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
				btnBuscar.setIcon(new ImageIcon(MantenimientoCamas.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBuscar.setIcon(new ImageIcon(MantenimientoCamas.class.getResource("/views/images/btn-login.png")));
			}
			void mostrarDatos(Cama data){
				txtCodigo.setText(data.getCodCama());
				txtPrecio.setText("" + data.getPrecioDia());
				txtEstado.setText(data.getEstado());
				resetearBusqueda();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnBuscar.isEnabled()){
					int cboSelect = getCboBuscarPor();
					if(getBusquedaCodigo().contentEquals("") || cboSelect == 0){
						mensaje("Asegurese de haber seleccionado un filtro e ingresado un término de búsqueda.");
					}
					else {
						String term = getBusquedaCodigo();
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
		btnBuscar.setIcon(new ImageIcon(MantenimientoCamas.class.getResource("/views/images/btn-login.png")));
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
		lblCodigo.setForeground(Constantes.textgray);
		lblCodigo.setFont(Constantes.regularFont);
		lblCodigo.setBounds(25, 286, 87, 35);
		contentPane.add(lblCodigo);
		
		lblInputCodigo = new JLabel("");
		lblInputCodigo.setEnabled(false);
		lblInputCodigo.setIcon(new ImageIcon(MantenimientoCamas.class.getResource("/views/images/input-text-mantenimiento.png")));
		lblInputCodigo.setBounds(127, 286, 349, 35);
		contentPane.add(lblInputCodigo);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setForeground(Constantes.textgray);
		lblPrecio.setFont(Constantes.regularFont);
		lblPrecio.setBounds(580, 286, 87, 35);
		contentPane.add(lblPrecio);
		
		lblInputPrecio = new JLabel("");
		lblInputPrecio.setEnabled(false);
		lblInputPrecio.setIcon(new ImageIcon(MantenimientoCamas.class.getResource("/views/images/input-text-mantenimiento.png")));
		lblInputPrecio.setBounds(682, 286, 349, 35);
		contentPane.add(lblInputPrecio);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setForeground(Constantes.textgray);
		lblEstado.setFont(Constantes.regularFont);
		lblEstado.setBounds(25, 332, 87, 35);
		contentPane.add(lblEstado);
		
		lblInputEstado = new JLabel("");
		lblInputEstado.setEnabled(false);
		lblInputEstado.setCursor(Constantes.pointer);
		lblInputEstado.setIcon(new ImageIcon(MantenimientoCamas.class.getResource("/views/images/input-text-mantenimiento.png")));
		lblInputEstado.setBounds(127, 332, 349, 35);
		contentPane.add(lblInputEstado);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 392, 1006, 300);
		contentPane.add(scrollPane);
		
		tblTabla = new JScrollPane();
		scrollPane.setViewportView(tblTabla);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ev) {
				int rowIndex = table.getSelectedRow();
				String code = table.getValueAt(rowIndex, 0).toString();
				Cama getCama = cama.buscarPorCodigo(code);
				txtCodigo.setText(getCama.getCodCama());
				txtEstado.setText(getCama.getEstado());
				txtPrecio.setText("" + getCama.getPrecioDia());
			}
		});
		
		table.setForeground(Constantes.textgray);
		table.setFont(Constantes.regularFont);
		table.setRowHeight(30);
		table.setFillsViewportHeight(true);
		tblTabla.setViewportView(table);
		
		tabla = new DefaultTableModel();
		tabla.addColumn("Código de cama");
		tabla.addColumn("Precio por día");
		tabla.addColumn("Estado");
		table.setModel(tabla);
		
		lblIngresarConfirm = new JLabel("Ingresar");
		lblIngresarConfirm.setFont(Constantes.regularFont);
		lblIngresarConfirm.setCursor(Constantes.pointer);
		lblIngresarConfirm.setForeground(Color.WHITE);
		lblIngresarConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresarConfirm.setBounds(931, 333, 100, 34);
		lblIngresarConfirm.setVisible(false);
		contentPane.add(lblIngresarConfirm);
		
		btnIngresarConfirm = new JLabel("");
		btnIngresarConfirm.setVisible(false);
		btnIngresarConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIngresarConfirm.setIcon(new ImageIcon(MantenimientoCamas.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIngresarConfirm.setIcon(new ImageIcon(MantenimientoCamas.class.getResource("/views/images/btn-login.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					double precio = validarPrecio();
					if(precio == 0.0) return;
					
					String estado = txtEstado.getText();
					
					int option = JOptionPane.showConfirmDialog(null, "¿Está seguro de ingresar los registros de una nueva cama?", "Confirmar ingreso de datos", JOptionPane.OK_CANCEL_OPTION);
					if(option == 0){
						Cama newCama = new Cama(txtCodigo.getText(), precio, estado);
						cama.adicionar(newCama);
						cama.agregarCamas();
						
						mensaje("Los nuevos registros han sido grabados correctamente.");
						listarCamas();
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
		btnIngresarConfirm.setIcon(new ImageIcon(MantenimientoCamas.class.getResource("/views/images/btn-login.png")));
		btnIngresarConfirm.setBounds(931, 332, 100, 35);
		contentPane.add(btnIngresarConfirm);
		
		lblModificarConfirm = new JLabel("Modificar");
		lblModificarConfirm.setFont(Constantes.regularFont);
		lblModificarConfirm.setCursor(Constantes.pointer);
		lblModificarConfirm.setForeground(Color.WHITE);
		lblModificarConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificarConfirm.setBounds(931, 333, 100, 34);
		lblModificarConfirm.setVisible(false);
		contentPane.add(lblModificarConfirm);
		
		btnModificarConfirm = new JLabel("");
		btnModificarConfirm.setVisible(false);
		btnModificarConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIngresarConfirm.setIcon(new ImageIcon(MantenimientoCamas.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIngresarConfirm.setIcon(new ImageIcon(MantenimientoCamas.class.getResource("/views/images/btn-login.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					double precio = validarPrecio();
					if(precio == 0.0) return;
					
					String estado = txtEstado.getText();
					
					int option = JOptionPane.showConfirmDialog(null, "¿Está seguro de modificar los registros de este paciente?", "Confirmar modificación", JOptionPane.OK_CANCEL_OPTION);
					if(option == 0){
						String codigo = txtCodigo.getText();
						Cama modCama = cama.buscarPorCodigo(codigo);
						modCama.setPrecioDia(precio);
						modCama.setEstado(estado);
						
						mensaje("Los registros de este paciente han sido actualizados correctamente.");
						cama.agregarCamas();
						listarCamas();
						resetFields();
					}
				}
				catch(Exception er){
					mensaje("Hubo un error en el ingreso de datos.");
				}
			}
		});
		btnModificarConfirm.setIcon(new ImageIcon(MantenimientoCamas.class.getResource("/views/images/btn-login.png")));
		btnModificarConfirm.setBounds(931, 332, 100, 35);
		contentPane.add(btnModificarConfirm);
		
		lblEliminarConfirm = new JLabel("Eliminar");
		lblEliminarConfirm.setFont(Constantes.regularFont);
		lblEliminarConfirm.setCursor(Constantes.pointer);
		lblEliminarConfirm.setForeground(Color.WHITE);
		lblEliminarConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarConfirm.setBounds(931, 333, 100, 34);
		lblEliminarConfirm.setVisible(false);
		contentPane.add(lblEliminarConfirm);
		
		btnEliminarConfirm = new JLabel("");
		btnEliminarConfirm.setVisible(false);
		btnEliminarConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIngresarConfirm.setIcon(new ImageIcon(MantenimientoCamas.class.getResource("/views/images/btn-login-hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIngresarConfirm.setIcon(new ImageIcon(MantenimientoCamas.class.getResource("/views/images/btn-login.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				String codigo = txtCodigo.getText();
				Cama dropCama = cama.buscarPorCodigo(codigo);
				if(dropCama != null){
					int option = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar los registros de este paciente?", "Confirmar eliminación", JOptionPane.OK_CANCEL_OPTION);
					if(option == 0){
						cama.eliminarCama(dropCama);
						cama.agregarCamas();
						listarCamas();
						resetFields();
						mensaje("Los registros de este paciente han sido eliminados correctamente.");
					}
				}
				else {
					mensaje("No has ingresado pacientes para eliminar.");
				}
			}
		});
		btnEliminarConfirm.setIcon(new ImageIcon(MantenimientoCamas.class.getResource("/views/images/btn-login.png")));
		btnEliminarConfirm.setBounds(931, 332, 100, 35);
		contentPane.add(btnEliminarConfirm);
		
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
        
//        paciente.cargarPacientes();
        listarCamas();
	}
	
	private int getCboBuscarPor(){
		String cboSelect = txtBuscar.getText();
		if(cboSelect.contentEquals("Código de cama"))
			return 1;
		else if(cboSelect.contentEquals("Estado"))
			return 2;
		else
			return 0;
	}
	
	private double getPrecio(){
		return Double.parseDouble(txtPrecio.getText());
	}
	
	private void listarCamas(){
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
		txtPrecio.setText("");
		txtEstado.setText("Seleccionar --");
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
	
	private void autogenerateCode(){
		int lastCode = cama.obtenerUltimoCodigo() + 1;
		String newCode = "CAM";
		if(Integer.toString(lastCode).length() == 1) newCode += "00" + lastCode;
		if(Integer.toString(lastCode).length() == 2) newCode += "0" + lastCode;
		if(Integer.toString(lastCode).length() == 3) newCode += "" + lastCode;
		txtCodigo.setText(newCode);
	}
	
	private void listaPorEstado(){
		String term = txtIngresar.getText();
		ArrayList<Cama> lista = cama.listCamaEstado(term);
		if(lista != null){
			tabla.setRowCount(0);
			for(int i = 0; i < lista.size(); i ++){
				Object[] data = {
					lista.get(i).getCodCama(),
					lista.get(i).getPrecioDia(),
					lista.get(i).getEstado()
				};
				tabla.addRow(data);
			}
		}
		else {
			mensaje("No hay registros de camas con estado:  " + term);
		}
	}
	
}
