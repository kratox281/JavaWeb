
public class Persona {
 private String nombre;
 private String apellidos;
 private String edad;
 private String contacto; 
 public Persona(String nom,String apell,String ed,String cont) {
	this.nombre = nom;
	this.apellidos = apell;
	this.edad = ed;
	this.contacto = cont;
 }
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellidos() {
	return apellidos;
}
public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
}
public String getEdad() {
	return edad;
}
public void setEdad(String edad) {
	this.edad = edad;
}
public String getContacto() {
	return contacto;
}
public void setContacto(String contacto) {
	this.contacto = contacto;
}
 
}
