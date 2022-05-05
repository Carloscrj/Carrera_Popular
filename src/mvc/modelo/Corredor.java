package mvc.modelo;

public class Corredor {
	
	public static final String[] MODALIDAD= {"10000", "MEDIA MARATÓN", "MARATÓN"};
	
	private String nombre;
	private int dorsal;
	private String sexo;
	private int edad;
	private String modalidad;
	
	public Corredor(String nombre, int dorsal, String sexo, int edad, String modalidad) {
		this.nombre = nombre;
		this.dorsal = dorsal;
		this.sexo = sexo;
		this.edad = edad;
		this.modalidad = modalidad;
	}
	

	public String getNombre() {
		return nombre;
	}



	public int getDorsal() {
		return dorsal;
	}



	public String getSexo() {
		return sexo;
	}



	public int getEdad() {
		return edad;
	}



	public String getModalidad() {
		return modalidad;
	}



	@Override
	public String toString() {
		return "Corredor [nombre=" + nombre + ", dorsal=" + dorsal + ", sexo=" + sexo + ", edad=" + edad
				+ ", modalidad=" + modalidad + "]";
	}
	
	
	
	
}
