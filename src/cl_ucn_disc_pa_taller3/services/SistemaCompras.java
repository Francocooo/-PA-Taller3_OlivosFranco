package cl_ucn_disc_pa_taller3.services;

import cl_ucn_disc_pa_taller3.colecciones.NodoProducto;
import cl_ucn_disc_pa_taller3.models.Administrador;
import cl_ucn_disc_pa_taller3.models.CarritoDeCompra;
import cl_ucn_disc_pa_taller3.models.Producto;
import cl_ucn_disc_pa_taller3.models.Usuario;
import edu.princeton.cs.stdlib.In;
import edu.princeton.cs.stdlib.StdIn;
import edu.princeton.cs.stdlib.StdOut;

import java.util.ArrayList;

public class SistemaCompras implements ISistemaCompras {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Producto> productos;
    private final String archivoProductos = "productos.txt";

    public SistemaCompras() {
        this.usuarios = new ArrayList<>();
        this.productos = new ArrayList<>();
        Usuario admin = new Administrador("1", "Edgardo Ortiz", "edgardo.ortiz@alumnos.ucn.cl", "Mi casa", "Chile", "");
        this.usuarios.add(admin);
    }

    @Override
    public void leerProductos(String archivo) {
        In archivoDeEntrada = new In(archivo);

        StdOut.println("***** LISTA DE PRODUCTOS *****");

        while (!archivoDeEntrada.isEmpty()) {
            String linea = archivoDeEntrada.readLine();
            String[] datos = linea.split(",");

            if (datos.length == 5) {
                String codigo = datos[0].trim();
                String nombre = datos[1].trim();
                float precio = Float.parseFloat(datos[2].trim());
                int stock = Integer.parseInt(datos[3].trim());
                String proveedor = datos[4].trim();

                Producto producto = new Producto(codigo, nombre, precio, stock, proveedor);
                productos.add(producto);

                StdOut.println("Codigo: " + codigo + " || Nombre: " + nombre + " || Precio: $" + precio + " || Stock: " + stock + " || Proveedor: " + proveedor);
            } else {
                StdOut.println("No se puede cargar el archivo");
            }
        }
        archivoDeEntrada.close();
    }


    public Usuario iniciarSesion(String correo, String datoSeguridad) {
        for (Usuario usuario : usuarios) {
            if (usuario.verificarUsuario(correo, datoSeguridad)) {
                if (usuario.esAdministrador()) {
                    StdOut.println("Ha inciado sesion como Administrador: " + usuario.getNombre());
                } else {
                    StdOut.println("Ha iniciado sesion como Usuario: " + usuario.getNombre());
                }
                return usuario;
            }
        }
        StdOut.println("Usuario no encontrado.");
        return null;
    }


    public boolean registrarUsuario(String ID, String nombre, String correo, String direccion, String pais, String contrasenia) {

        for (Usuario usuario : usuarios) {
            if (usuario.getCorreo().equals(correo)) {
                StdOut.println("El correo " + correo + " ya esta registrado.");
                return false;
            }
        }

        Usuario nuevoUsuario = new Usuario(ID, nombre, correo, direccion, pais, contrasenia);
        usuarios.add(nuevoUsuario);
        return true;
    }


    @Override
    public void guardarUsuarios(String archivo) {

    }


    public boolean agregarProductoAlCarrito(CarritoDeCompra carritoDeCompra, Producto producto, int cantidad) {
        if (producto.getStock() >= cantidad) {
            carritoDeCompra.agregarProductos(producto, cantidad);
            return true;
        } else {
            StdOut.println("No hay suficiente stock del producto.");
            return false;
        }
    }

    @Override
    public Usuario verificarUsuario(String correo, String contrasena) {
        return null;
    }

    @Override
    public Producto buscarProductoPorCodigo(String codigo) {
        for (Producto producto : productos) {
            if (producto.getCodigo().equalsIgnoreCase(codigo)) {
                return producto;
            }
        }
        return null;
    }

    @Override
    public Producto buscarProductoPorNombre(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }

    @Override
    public void pagar(Usuario usuario) {
        CarritoDeCompra carritoDeCompra = usuario.getCarritoDeCompra();
        if (carritoDeCompra.getCantidadDeElementos() == 0) {
            StdOut.println("El carrito de compras esta vacio.");
            return;
        }

        String respuesta = StdIn.readString();

        if (respuesta.equalsIgnoreCase("si")) {
            generarBoleta(usuario, carritoDeCompra);
            carritoDeCompra.vaciarCarrito();
        } else {
            StdOut.println("Pago cancelado.");
        }
    }



    @Override
    public void generarBoleta(Usuario usuario, CarritoDeCompra carritoDeCompra) {
        StdOut.println("***** BOLETA *****");
        StdOut.println("Usuario: " + usuario.getNombre());

        NodoProducto nodoAux = carritoDeCompra.getCabeza();
        if (nodoAux == null) {
            StdOut.println("No hay productos en el carrito.");
        } else {
            Producto producto = nodoAux.getProductoAlmacenado();
            StdOut.println("Codigo: " + producto.getCodigo());
            StdOut.println("Nombre: " + producto.getNombre());
            StdOut.println("Precio: $" + producto.getPrecio());
            StdOut.println("Proovedor: " + producto.getProovedor());
        }

        float totalPagar = carritoDeCompra.calcularTotal();
        StdOut.println("Monto final: $" + totalPagar);
    }


    @Override
    public void eliminarProductoDelCarrito(Usuario usuario, String codigo) {
        CarritoDeCompra carritoDeCompra = usuario.getCarritoDeCompra();
        boolean eliminado = carritoDeCompra.eliminarProducto(codigo);

        if (eliminado) {
            StdOut.println("Producto eliminado del carrito correctamente.");
        } else {
            StdOut.println("No se pudo eliminar el producto del carrito.");
        }
    }


    @Override
    public void agregarUsuario(Usuario usuario) {

    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public String getArchivoProductos() {
        return archivoProductos;
    }


}
