package cl_ucn_disc_pa_taller3.services;

import cl_ucn_disc_pa_taller3.models.CarritoDeCompra;
import cl_ucn_disc_pa_taller3.models.Producto;
import cl_ucn_disc_pa_taller3.models.Usuario;

public interface ISistemaCompras {
    void leerProductos(String archivo);
    void guardarUsuarios(String archivo);
    Usuario verificarUsuario(String correo, String contrasena);
    void generarBoleta(Usuario usuario, CarritoDeCompra carritoDeCompra);
    void eliminarProductoDelCarrito(Usuario usuario, String codigo);
    void agregarUsuario(Usuario usuario);
    Producto buscarProductoPorCodigo(String codigo);
    Producto buscarProductoPorNombre(String nombre);
    void pagar(Usuario usuario);
}
