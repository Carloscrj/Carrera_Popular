package mvc.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import mvc.control.ControladorCorredores;

import mvc.modelo.Corredor;


import javax.swing.JRadioButton;
import javax.sound.sampled.ReverbType;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class PanelIntroducir extends JPanel {
	
	private static final int ANCHO = 800;
	private static final int ALTO = 600;
	public static final String GUARDAR_CORREDOR= "Guardar Corredor";
	public static final String LIMPIAR_DATOS= "Limpiar Datos";
	
	
	private final ButtonGroup btngroupSexo = new ButtonGroup();
	private JLabel lblNombre;
	private JLabel lblDorsal;  
	private JLabel lblSexo;
	private JRadioButton rbtnHombre;
	private JRadioButton rbtnMujer;
	private JLabel lblNewLabel;
	private JComboBox <String> cmbModalidad;
	private JButton btnGuardar;
	private JButton btnLimpiar;
	private JTextField txtNombre;
	private JTextField txtDorsal;
	private JSpinner spnEdad;
	
	public PanelIntroducir() {
		setSize(ANCHO, ALTO);
		setLayout(null);
		
		lblNombre = new JLabel("Nombre Corredor:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(53, 66, 120, 13);
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombre.setBounds(227, 65, 96, 19);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		lblDorsal = new JLabel("Dorsal:");
		lblDorsal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDorsal.setBounds(83, 132, 90, 13);
		add(lblDorsal);
		
		txtDorsal = new JTextField();
		txtDorsal.setBounds(227, 131, 96, 19);
		add(txtDorsal);
		txtDorsal.setColumns(10);
		
		lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSexo.setBounds(83, 217, 70, 13);
		add(lblSexo);
		
		rbtnHombre = new JRadioButton("Hombre");
		rbtnHombre.setSelected(true);
		btngroupSexo.add(rbtnHombre);
		rbtnHombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rbtnHombre.setBounds(204, 215, 103, 21);
		add(rbtnHombre);
		
		rbtnMujer = new JRadioButton("Mujer");
		btngroupSexo.add(rbtnMujer);
		rbtnMujer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rbtnMujer.setBounds(323, 215, 103, 21);
		add(rbtnMujer);
		
		lblNewLabel = new JLabel("Modalidad:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(83, 325, 80, 13);
		add(lblNewLabel);
		
		cmbModalidad = new JComboBox <String>();
		cmbModalidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbModalidad.setModel(new DefaultComboBoxModel<String>(Corredor.MODALIDAD));
		cmbModalidad.setBounds(204, 321, 70, 21);
		add(cmbModalidad);
		
		btnGuardar = new JButton(GUARDAR_CORREDOR);
		btnGuardar.setBounds(134, 394, 85, 21);
		add(btnGuardar);
		
		btnLimpiar = new JButton(LIMPIAR_DATOS);
		btnLimpiar.setBounds(367, 394, 85, 21);
		add(btnLimpiar);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEdad.setBounds(83, 273, 45, 13);
		add(lblEdad);
		
		spnEdad = new JSpinner();
		spnEdad.setModel(new SpinnerNumberModel(0, 0, 120, 1));
		spnEdad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spnEdad.setBounds(200, 272, 59, 20);
		add(spnEdad);
		
	}
	
	public Corredor  obtenerCorredor() {
		Corredor corredor = null;
		
		
		String nombre= txtNombre.getText();
		
		if (nombre.isBlank()) { 
			mostrarError("No ha introducido nombre", "ERROR");
		}else{
			  try {
	                int dorsal = Integer.valueOf(txtDorsal.getText());
	                if (dorsal>9999) {
	                    mostrarError("El dorsal no puede tener más de 5 dígitos", "Error Dorsal");
	                } else {
	                	String sexo= obtenerSexo();
	                	if (sexo.isBlank()) {
	                		mostrarError("Campo sexo vacio", "Error Sexo");
						}else {
							int edad= (int) spnEdad.getValue(); 
		        			
		        			String modalidad= (String) cmbModalidad.getSelectedItem();
		        			
		        			corredor= new Corredor(nombre, edad, sexo, edad, modalidad);
						}
	        			
	                }

	            } catch (NumberFormatException e) {
	                mostrarError("El dorsal debe ser un número", "Error dorsal incorrecto");
	            }
	        }
			
		return corredor;
	}
	
	private String obtenerSexo() {
		String sexo = "";
		if (rbtnHombre.isSelected()) {
			sexo = rbtnHombre.getText();
			
		}else if (rbtnMujer.isSelected()) {
			sexo = rbtnMujer.getText();
			
		} 
		
		return sexo;
	}

	public void limpiarCorredores() { //método para llamar en el controlador y así deseleccionar cuando seleccionamos "sin síntomas"
		txtNombre.setText("");
		txtDorsal.setText("");
		rbtnHombre.setSelected(true);
		rbtnMujer.setSelected(false);
		spnEdad.setValue(0);
		cmbModalidad.setSelectedIndex(0);
		
	}
	
	public void setControlador(ControladorCorredores controlador) {
		btnGuardar.addActionListener(controlador);
		btnLimpiar.addActionListener(controlador);
		
	}
	
	public void mostrarError(String error, String titulo) {
		JOptionPane.showMessageDialog(this, //ventana
				error, //mensaje
				titulo, //título ventana
				JOptionPane.ERROR_MESSAGE); //tipo icono de la ventana 
	}
	
	public void mostrarMensaje(String error, String titulo) {
		JOptionPane.showMessageDialog(this, //ventana
				error, //mensaje
				titulo, //título ventana
				JOptionPane.INFORMATION_MESSAGE); //tipo icono de la ventana 
	}
}
