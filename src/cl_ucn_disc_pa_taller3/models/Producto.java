package cl_ucn_disc_pa_taller3.models;

public class Producto {

    private String codigo;
    private String nombre;
    private float precio;
    private int Stock;
    private String proovedor;

    public Producto(String codigo, String nombre, float precio, int stock, String proovedor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        Stock = stock;
        this.proovedor = proovedor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public String getProovedor() {
        return proovedor;
    }

    public void setProovedor(String proovedor) {
        this.proovedor = proovedor;
    }
}
