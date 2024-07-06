package cl_ucn_disc_pa_taller3.colecciones;

import cl_ucn_disc_pa_taller3.models.Producto;

public class NodoProducto {

    private Producto productoAlmacenado;
    private int cantidad;
    private NodoProducto siguiente;
    private NodoProducto anterior;

    public NodoProducto(Producto producto, int cantidad) {
        this.productoAlmacenado = producto;
        this.cantidad = cantidad;
        this.siguiente = null;
        this.anterior = null;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public NodoProducto getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoProducto siguiente) {
        this.siguiente = siguiente;
    }

    public NodoProducto getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoProducto anterior) {
        this.anterior = anterior;
    }

    public Producto getProductoAlmacenado() {
        return productoAlmacenado;
    }

    public void setProductoAlmacenado(Producto productoAlmacenado) {
        this.productoAlmacenado = productoAlmacenado;
    }
}