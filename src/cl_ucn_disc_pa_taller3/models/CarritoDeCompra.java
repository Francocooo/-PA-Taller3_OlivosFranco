package cl_ucn_disc_pa_taller3.models;

import cl_ucn_disc_pa_taller3.colecciones.NodoProducto;

public class CarritoDeCompra {

    private NodoProducto cabeza;
    private NodoProducto cola;
    private int cantidadDeElementos;

    public CarritoDeCompra() {
        this.cabeza = null;
        this.cola = null;
        this.cantidadDeElementos = 0;
    }



    public boolean agregarProductos(Producto producto, int cantidad) {
        if (producto.getStock() < cantidad) {
            return false;
        }
        producto.setStock(producto.getStock() - cantidad);

        NodoProducto nuevoNodo = new NodoProducto(producto, cantidad);

        if (isVacia()) {
            this.cabeza = nuevoNodo;
            this.cola = nuevoNodo;
            nuevoNodo.setSiguiente(this.cabeza);
            nuevoNodo.setAnterior(this.cola);
        } else {
            nuevoNodo.setSiguiente(this.cabeza);
            this.cabeza.setAnterior(nuevoNodo);
            nuevoNodo.setAnterior(this.cola);
            this.cola.setSiguiente(nuevoNodo);
            this.cabeza = nuevoNodo;
        }
        this.cantidadDeElementos++;
        return true;
    }


    public boolean eliminarProducto(String codigo) {

        if (isVacia()) {
            return false;
        }

        NodoProducto nodoAux = this.cabeza;

        if (nodoAux.getProductoAlmacenado().getCodigo().equalsIgnoreCase(codigo)) {

            if (this.cabeza == this.cola) {
                this.cabeza = null;
                this.cola = null;
            } else {
                this.cabeza = nodoAux.getSiguiente();
                this.cabeza.setAnterior(null);
            }
            this.cantidadDeElementos--;
            return true;
        }

        if (nodoAux.getSiguiente() != null && nodoAux.getSiguiente().getProductoAlmacenado().getCodigo().equalsIgnoreCase(codigo)) {
            NodoProducto nodoEliminar = nodoAux.getSiguiente();
            nodoAux.setSiguiente(nodoEliminar.getSiguiente());
            if (nodoEliminar.getSiguiente() != null) {
                nodoEliminar.getSiguiente().setAnterior(nodoAux);
            } else {
                this.cola = nodoAux;
            }
            this.cantidadDeElementos--;
            return true;
        }

        while (nodoAux.getSiguiente() != null) {
            nodoAux = nodoAux.getSiguiente();
            if (nodoAux.getSiguiente() != null && nodoAux.getSiguiente().getProductoAlmacenado().getCodigo().equalsIgnoreCase(codigo)) {
                NodoProducto nodoEliminar = nodoAux.getSiguiente();
                nodoAux.setSiguiente(nodoEliminar.getSiguiente());
                if (nodoEliminar.getSiguiente() != null) {
                    nodoEliminar.getSiguiente().setAnterior(nodoAux);
                } else {
                    this.cola = nodoAux;
                }
                this.cantidadDeElementos--;
                return true;
            }
        }

        return false;
    }

    public boolean isVacia(){
        return this.cabeza == null;
    }

    public NodoProducto getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoProducto cabeza) {
        this.cabeza = cabeza;
    }

    public NodoProducto getCola() {
        return cola;
    }

    public void setCola(NodoProducto cola) {
        this.cola = cola;
    }

    public int getCantidadDeElementos() {
        return cantidadDeElementos;
    }

    public void setCantidadDeElementos(int cantidadDeElementos) {
        this.cantidadDeElementos = cantidadDeElementos;
    }

    public float calcularTotal() {
        float total = 0;
        NodoProducto nodoAux = this.cabeza;

        if (nodoAux == null) {
            return total;
        }

        do {
            Producto producto = nodoAux.getProductoAlmacenado();
            int cantidad = nodoAux.getCantidad();
            total += producto.getPrecio() * cantidad;
            nodoAux = nodoAux.getSiguiente();
        } while (nodoAux != null && nodoAux != this.cabeza);

        return total;
    }

    public void vaciarCarrito() {
        this.cabeza = null;
        this.cola = null;
        this.cantidadDeElementos = 0;
    }
}
