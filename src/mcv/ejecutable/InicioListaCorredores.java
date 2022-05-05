package mcv.ejecutable;

import java.awt.EventQueue;

import mvc.control.ControladorCorredores;

import mvc.modelo.ListaCorredores;

import mvc.view.PanelConsultar;
import mvc.view.PanelIntroducir;
import mvc.view.VCorredor;


public class InicioListaCorredores {

	public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				VCorredor ventana = new VCorredor(); //para crear la ventana necesitamos los datos por parámetro
				PanelIntroducir poIntroducir = new PanelIntroducir(); //también creamos los objetos de las nuevas ventanas creadas
				PanelConsultar poConsultar = new PanelConsultar();
				ListaCorredores liCorredores = new ListaCorredores();
			
				ControladorCorredores controlador = new ControladorCorredores(ventana, poIntroducir, poConsultar, liCorredores); //añadimos las 3 ventanas al controlador
				
				ventana.setControlador(controlador);
				poIntroducir.setControlador(controlador);
				poConsultar.setControlador(controlador);
				
				
				ventana.hacerVisible();
			}
		});
	}



}
