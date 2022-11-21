package paquete;
import java.util.ArrayList;

public class Votacion {
	
	private String alumno;
	private ArrayList<String> votos;
	public Votacion(String alum,ArrayList<String> vot) {
		this.alumno = alum;
		this.votos = vot;
	}
	public String getAlumno() {
		return alumno;
	}
	public void setAlumno(String alumno) {
		this.alumno = alumno;
	}
	public ArrayList<String> getVotos() {
		return votos;
	}
	public void setVotos(ArrayList<String> votos) {
		this.votos = votos;
	}
	
}
