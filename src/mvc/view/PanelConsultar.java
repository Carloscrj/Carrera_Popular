package mvc.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import mvc.control.ControladorCorredores;

import mvc.modelo.Corredor;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class PanelConsultar extends JPanel {
	private static final int ANCHO = 800;
	private static final int ALTO = 600;
	public static final String RBTN_HOMBRE= "Hombre";
	public static final String RBTN_MUJER= "Mujer";
	public static final String RBTN_TODOS= "Todos";
	public static final String BTN_CONSULTAR= "Consultar";
	private static final String NOMBRE = "NOMBRE";
	private static final String DORSAL = "DORSAL";
	private static final String SEXO = "SEXO";
	private static final String EDAD = "EDAD";
	public static final String MODALIDAD = "MODALIDAD";
	private DefaultTableModel tModel; //nos sirve para configurar la tabla
	
	private JTable tblCorredores;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JScrollPane scrpCorredores;
	private JRadioButton rbtnHombre;
	private JRadioButton rbtnMujer;
	private JRadioButton rbtnTodos;
	private JButton btnConsultar;
	
	public PanelConsultar() {
		setSize(ANCHO, ALTO);
		setLayout(null);
		
		scrpCorredores = new JScrollPane();
		scrpCorredores.setVisible(false);
		scrpCorredores.setBounds(74, 154, 402, 325);
		add(scrpCorredores);
		
		tblCorredores = new JTable();
		scrpCorredores.setViewportView(tblCorredores);
		configurarTabla();
		
		
		rbtnHombre = new JRadioButton(RBTN_HOMBRE);
		rbtnHombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonGroup.add(rbtnHombre);
		rbtnHombre.setBounds(74, 38, 103, 21);
		add(rbtnHombre);
		
		rbtnMujer = new JRadioButton(RBTN_MUJER);
		rbtnMujer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonGroup.add(rbtnMujer);
		rbtnMujer.setBounds(275, 38, 103, 21);
		add(rbtnMujer);
		
		rbtnTodos = new JRadioButton(RBTN_TODOS);
		rbtnTodos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonGroup.add(rbtnTodos);
		rbtnTodos.setBounds(498, 38, 103, 21);
		add(rbtnTodos);
		
		btnConsultar = new JButton(BTN_CONSULTAR);
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultar.setBounds(293, 99, 85, 21);
		add(btnConsultar);
		
	}
	
	private void configurarTabla() {
		tModel = new DefaultTableModel() { //inicializamos table model
			public boolean isCellEditable(int row, int column) {
				return false; //porque no queremos celdas editables
			}
		};
		
				tblCorredores.setModel(tModel);
		//Establecemos ahora el nombre de las columnas con constantes:
				tModel.addColumn(NOMBRE); //Será la posición 0 en la columna
				tModel.addColumn(DORSAL); //Será la posición 1 en la columna
				tModel.addColumn(SEXO); //Será la posición 2 en la columna
				tModel.addColumn(EDAD); //Será la posición 3 en la columna
				tModel.addColumn(MODALIDAD); //Será la posición 3 en la columna
				//Ponemos el ancho al campo de la columna:
				tblCorredores.getColumn(NOMBRE).setPreferredWidth(75);
				tblCorredores.getColumn(DORSAL).setPreferredWidth(75);
				tblCorredores.getColumn(SEXO).setPreferredWidth(75);
				tblCorredores.getColumn(EDAD).setPreferredWidth(75);
				tblCorredores.getColumn(MODALIDAD).setPreferredWidth(75);
	}
	
	public void  rellenarTabla(ArrayList<Corredor> listaCorredores) {
		
		tModel.getDataVector().clear();// sirve para limpiar el contenido de la tabla antes de cargar otra
		//tModel.setRowCount(0); spara lo mismo que el de arriba, en este le decimos que si contenido sea cero
		
		Object[] fila = new Object[5]; //creamos un array con el tamaño del número de columnas que tenemos que será para llenar las filas
		
		//vamos a rellenar las este array que hemos creado con un foreach; por ello hemos sacado los getters de cada atributo:
		for (Corredor corredor : listaCorredores) { 
			fila[0] = corredor.getNombre();
			fila[1] = corredor.getDorsal();
			fila[2] = corredor.getSexo();
			fila[3] = corredor.getEdad();
			fila[4] = corredor.getModalidad();
			
			tModel.addRow(fila); //se va añadiendo en cada iteración los datos de cada persona
		}
	}

	public void setControlador(ControladorCorredores controlador) {
		btnConsultar.addActionListener(controlador);
		rbtnHombre.addActionListener(controlador);
		rbtnMujer.addActionListener(controlador);
		rbtnTodos.addActionListener(controlador);
	}
	
	public void hacerVisibleScrp(boolean b) {
		scrpCorredores.setVisible(b);
		
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
	
	public String obtenerSexo() {
		String sexo = "";
		if (rbtnHombre.isSelected()) {
			sexo = rbtnHombre.getText();
			
		}else if (rbtnMujer.isSelected()) {
			sexo = rbtnMujer.getText();
			
		}else if (rbtnTodos.isSelected()) {
			sexo = rbtnTodos.getText();
			
		} 
		
		return sexo;
	}
	
	public void mostrarError(String error, String titulo) {
		JOptionPane.showMessageDialog(this, //ventana
				error, //mensaje
				titulo, //título ventana
				JOptionPane.ERROR_MESSAGE); //tipo icono de la ventana 
	}



}
