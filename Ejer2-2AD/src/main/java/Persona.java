
public class Persona {
private String nombre;
private String telefono;
private String edad;

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getTelefono() {
	return telefono;
}

public void setTelefono(String telefono) {
	this.telefono = telefono;
}

public String getNumero() {
	return edad;
}

public void setNumero(String numero) {
	this.edad = numero;
}

public Persona() {
	super();
}

public Persona(String nombre, String telefono, String numero) {
	if(nombre==null) {
		nombre = "Nombre generico";
	}
	if(telefono==null) {
		telefono = "000000000";
	}
	this.nombre = nombre;
	this.telefono = telefono;
	this.edad = numero;
}

@Override
public String toString() {
	return "Persona [nombre=" + nombre + ", telefono=" + telefono + ", numero=" + edad + "]";
}

}
