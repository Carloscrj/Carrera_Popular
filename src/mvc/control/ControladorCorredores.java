package mvc.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.xml.crypto.dsig.XMLValidateContext;

import mvc.modelo.Corredor;
import mvc.modelo.ListaCorredores;
import mvc.view.PanelConsultar;
import mvc.view.PanelIntroducir;
import mvc.view.VCorredor;



	public class ControladorCorredores implements ActionListener {
	VCorredor ventana;
	PanelIntroducir poIntroducir;
	PanelConsultar poConsultar;
	ListaCorredores liCorredores;

	
	public ControladorCorredores(VCorredor ventana, PanelIntroducir poIntroducir, PanelConsultar poConsultar,ListaCorredores liCorredores) {
		this.ventana = ventana;
		this.poIntroducir = poIntroducir;
		this.poConsultar = poConsultar;
		this.liCorredores = liCorredores;
	
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JMenuItem) { 
			if (e.getActionCommand().equals(VCorredor.MNTN_INTRODUCIR)) {
				ventana.cargarPanel(poIntroducir);
			} else if (e.getActionCommand().equals(VCorredor.MNTN_CONSULTAR)) {
				ventana.cargarPanel(poConsultar);
				poConsultar.hacerVisibleScrp(false);
			} else if (e.getActionCommand().equals(VCorredor.MNTN_SALIR)) {
				int resp=JOptionPane.showConfirmDialog(ventana,
						"Se va a cerrrar la aplicación, ¿Desea continuar?",
						"Confirmar salida",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.INFORMATION_MESSAGE);
						if (resp== JOptionPane.YES_NO_OPTION) {
							System.exit(0);
						}
				
			} 
		}else if (e.getSource() instanceof JButton) { //si el componente en el que se ha producido el evento es un botón
			if (e.getActionCommand().equals(PanelIntroducir.GUARDAR_CORREDOR)) { //así identifico que se ha seleccionado el botón limpiar
				Corredor corredor = poIntroducir.obtenerCorredor(); //almacenamos los datos con este objeto a través del método y después
				liCorredores.nuevoCorredor(corredor);//añadimos al ArrayList del pojo ListaEncuestas, una nueva encuesta con los datos obtenido en la línea anterior
				if ( corredor!= null) {
					poIntroducir.mostrarMensaje("Receta guardada", "Guardar Receta");
				}
				
			} else if (e.getActionCommand().equals(PanelIntroducir.LIMPIAR_DATOS)) {
				poIntroducir.limpiarCorredores();
			} else if (e.getActionCommand().equals(PanelConsultar.BTN_CONSULTAR)) {
				
				if (liCorredores.getListaCorredores().isEmpty()) {
					poConsultar.mostrarError("No hay datos que mostrar", "Error");
				} else {
					 String sexo = poConsultar.obtenerSexo();
					 if (sexo.equals("Todos")) {
						 poConsultar.rellenarTabla(liCorredores.getListaCorredores());
						 
					} else {
						poConsultar.rellenarTabla(liCorredores.obtenerCorredoresSexo(sexo));
						
					} 
						poConsultar.hacerVisibleScrp(true);
						
				}
			

		} 

	}

  }
}
