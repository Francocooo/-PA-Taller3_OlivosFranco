package cl_ucn_disc_pa_taller3.models;

public class Administrador extends Usuario{
    public Administrador(String ID, String nombre, String correo, String direccion, String pais, String contrasenia) {
        super(ID, nombre, correo, direccion, pais, contrasenia);
    }

    public boolean esAdministrador() {
        return true;
    }

}
