package mvc.view;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import mvc.control.ControladorCorredores;


import javax.swing.JScrollPane;

public class VCorredor extends JFrame {
	
	public static final int ANCHO = 800;
	public static final int ALTO = 600;
	public static final String MNTN_INTRODUCIR = "Introducir Corredor";
	public static final String MNTN_CONSULTAR = "Consultar Corredores";
	public static final String MNTN_SALIR = "Salir";
	private JScrollPane scrpContenedor;
	private JMenuBar mnbMenu;
	private JMenuItem mntmMenu1;
	private JMenuItem mntmMenu2;
	private JMenuItem mntmMenu3;
	
	public VCorredor() {
		
		setTitle("Lista Corredores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 800);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		scrpContenedor = new JScrollPane();
		getContentPane().add(scrpContenedor, BorderLayout.CENTER);
		
		mnbMenu = new JMenuBar();
		setJMenuBar(mnbMenu);
		
		mntmMenu1 = new JMenuItem(MNTN_INTRODUCIR);
		mnbMenu.add(mntmMenu1);
		
		JSeparator separator = new JSeparator();
		mnbMenu.add(separator);
		
		mntmMenu2 = new JMenuItem(MNTN_CONSULTAR);
		mnbMenu.add(mntmMenu2);
		
		JSeparator separator_1 = new JSeparator();
		mnbMenu.add(separator_1);
		
		mntmMenu3 = new JMenuItem(MNTN_SALIR);
		mnbMenu.add(mntmMenu3);
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
	
	public void cargarPanel(JPanel panel) { //aquí añadimos como parámetro el ScrollPane que nos pasen; Opción 11 u Opción 12
		scrpContenedor.setViewportView(panel);
	}

	private void centrarVentana() {
		// Asignamos tamaño a la ventana:
		setPreferredSize(new Dimension(ANCHO, ALTO));  
		// Se obtienen las dimensiones en pixels de la pantalla:    
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();               
		// Se obtienen las dimensiones en pixels de la ventana:       
		Dimension ventana = this.getPreferredSize();               
		// Un cálculo para situar la ventana en el centro de la pantalla:       
		setLocation((pantalla.width - ventana.width) / 2,  (pantalla.height - ventana.height) / 2);
	
	}
	
	public void setControlador(ControladorCorredores controlador) {
		mntmMenu1.addActionListener(controlador);
		mntmMenu2.addActionListener(controlador);
		mntmMenu3.addActionListener(controlador);
	}

}
