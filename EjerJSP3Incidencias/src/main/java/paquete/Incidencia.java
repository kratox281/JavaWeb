package paquete;

public class Incidencia {
private String tema;
private String descripcion;
private int id;
public String getTema() {
	return tema;
}
public void setTema(String tema) {
	this.tema = tema;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Incidencia(String tema, String descripcion, int id) {
	super();
	this.tema = tema;
	this.descripcion = descripcion;
	this.id = id;
}



}
