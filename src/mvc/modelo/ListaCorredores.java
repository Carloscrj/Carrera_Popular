package mvc.modelo;

import java.util.ArrayList;

public class ListaCorredores {
	
private ArrayList<Corredor> listaCorredores;

	
	public ListaCorredores(){
		listaCorredores= new ArrayList<Corredor>();
		
	}
	

	public ArrayList<Corredor> obtenerCorredoresSexo(String sexo) {
		ArrayList<Corredor> listaCorredoresSexo = new ArrayList<Corredor>();
		for (Corredor corredor : listaCorredores) {
			if (corredor.getSexo().equals(sexo)) {
				listaCorredoresSexo.add(corredor);
			}
		}
		return listaCorredoresSexo;
	}



	public void nuevoCorredor(Corredor corredor) { //método para añadir encuestas
		listaCorredores.add(corredor);
	}


	public ArrayList<Corredor> getListaCorredores() {
		return listaCorredores;
	}
	
	


}
