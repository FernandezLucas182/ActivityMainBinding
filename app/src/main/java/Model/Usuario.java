package Model;

import java.io.Serializable;

public class Usuario  implements Serializable {
    private  int dni;

    private String apellido;
    private String nombre;
    private String usuario;
    private String password;

    public Usuario(int dni, String apellido, String nombre, String usuario, String password) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() { return apellido;}
    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
}
