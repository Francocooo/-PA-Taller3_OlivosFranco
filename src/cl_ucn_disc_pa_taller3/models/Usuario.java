package cl_ucn_disc_pa_taller3.models;

public class Usuario {

    private String ID;
    private String nombre;
    private String correo;
    private String direccion;
    private String pais;
    private String contrasenia;
    private CarritoDeCompra carritoDeCompra;

    public Usuario(String ID, String nombre, String correo, String direccion, String pais, String contrasenia) {
        this.ID = ID;
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
        this.pais = pais;
        this.contrasenia = contrasenia;
        this.carritoDeCompra = new CarritoDeCompra();

    }

    public boolean verificarUsuario(String correo, String contrasenia) {
        if(this.correo.equals(correo) && this.contrasenia.equals(contrasenia)){
            return true;
        }
        return false;
    }

    public boolean esAdministrador() {
        return false;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public CarritoDeCompra getCarritoDeCompra() {
        return carritoDeCompra;
    }

    public void setCarritoDeCompra(CarritoDeCompra carritoDeCompra) {
        this.carritoDeCompra = carritoDeCompra;
    }
}
