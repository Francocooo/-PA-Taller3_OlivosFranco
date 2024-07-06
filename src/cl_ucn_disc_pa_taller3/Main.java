package cl_ucn_disc_pa_taller3;

import cl_ucn_disc_pa_taller3.colecciones.NodoProducto;
import cl_ucn_disc_pa_taller3.models.Administrador;
import cl_ucn_disc_pa_taller3.models.CarritoDeCompra;
import cl_ucn_disc_pa_taller3.models.Producto;
import cl_ucn_disc_pa_taller3.models.Usuario;
import cl_ucn_disc_pa_taller3.services.SistemaCompras;
import ucn.StdIn;
import ucn.StdOut;

public class Main {
    public static void main(String[] args) {

        SistemaCompras sistemaCompras = new SistemaCompras();
        sistemaCompras.leerProductos("productos.txt");
        Usuario usuario = new Usuario("1", "Edgardo Ortiz", "edgardo.ortiz@alumnos.ucn.cl", "Mi casa", "Chile", "");
        menuInicial(sistemaCompras, usuario);
    }


    public static void menuInicial(SistemaCompras sistemaCompras, Usuario usuario){

        String opcion;

        while(true) {
            StdOut.println("*********************************\n" +
                    "¡Bienvenido a SmartTech Market!\n" +
                    "*********************************");
            StdOut.println("[1] Iniciar sesion.");
            StdOut.println("[2] Salir.");
            opcion = StdIn.readString();

            if (opcion.equals("1")){
                menuInicioSesion(sistemaCompras, usuario);
                continue;
            }
            if (opcion.equals("2")){
                StdOut.println("Saliendo del sistema...");
                break;
            }
            StdOut.println("Ingrese una opcion valida por favor.");

        }

    }

    public static void menuInicioSesion(SistemaCompras sistemaCompras, Usuario usuario){

        String opcion;

        while(true) {
            StdOut.println("*********************************\n" +
                    "Iniciar sesion o registrarse\n" +
                    "*********************************");
            StdOut.println("[1] Iniciar sesion.");
            StdOut.println("[2] Registrar un nuevo usuario.");
            StdOut.println("[3] Regresar.");
            opcion = StdIn.readString();

            if (opcion.equals("1")){
                iniciarSesion(sistemaCompras, usuario);
                continue;
            }
            if (opcion.equals("2")){
                registrarUsuario(sistemaCompras);
                continue;
            }
            if (opcion.equals("3")){
                StdOut.println("Volviendo...");
                break;
            }
            StdOut.println("Ingrese una opcion valida por favor.");

        }

    }

    public static void iniciarSesion(SistemaCompras sistemaCompras, Usuario usuario) {
        StdOut.println("Ingrese su correo electrónico:");
        String correo = StdIn.readString();

        StdOut.println("Ingrese su contraseña:");
        String contrasenia = StdIn.readString();

        usuario = sistemaCompras.iniciarSesion(correo, contrasenia);
        if (usuario != null) {
            StdOut.println("Inicio de sesion realizado correctamente.");
            if (usuario instanceof Administrador) {
                menuAdministrador(sistemaCompras, usuario); //Mostrar menu de administrador en caso de que sea el administrador
            } else {
                menuUsuario(sistemaCompras, usuario); //Sino se muestra el menu de usuario
            }
        } else {
            StdOut.println("No se ha podido iniciar sesion, intente nuevamente.");
        }
    }

    public static void registrarUsuario(SistemaCompras sistemaCompras) {
        StdOut.println("Ingrese el ID del usuario:");
        String ID = StdIn.readString();

        StdOut.println("Ingrese el nombre del usuario:");
        String nombre = StdIn.readString();

        StdOut.println("Ingrese el correo electronico del usuario:");
        String correo = StdIn.readString();

        StdOut.println("Ingrese la direccion del usuario:");
        String direccion = StdIn.readString();

        StdOut.println("Ingrese el pais del usuario:");
        String pais = StdIn.readString();

        StdOut.println("Ingrese la contraseña del usuario:");
        String contrasenia = StdIn.readString();

        if (sistemaCompras.registrarUsuario(ID, nombre, correo, direccion, pais, contrasenia)) {
            StdOut.println("Usuario registrado exitosamente.");
        } else {
            StdOut.println("No se pudo registrar al usuario");
        }
    }

    public static void menuAdministrador(SistemaCompras sistemaCompras, Usuario usuario) {
        String opcion;

        while (true) {
            StdOut.println("*********************************\n" +
                    "Menu del Administrador\n" +
                    "*********************************");
            StdOut.println("[1] Buscar un producto.");
            StdOut.println("[2] Gestionar carrito de compras.");
            StdOut.println("[3] Estadisticas.");
            StdOut.println("[4] Salir.");
            opcion = StdIn.readString();

            if (opcion.equals("1")) {
                buscarProducto(sistemaCompras, usuario);
            }
            if (opcion.equals("2")) {
                menuGestionarCarrito(sistemaCompras, usuario);
            }
            if (opcion.equals("3")) {
            continue;
            }
            if (opcion.equals("4")) {
                StdOut.println("Volviendo...");
                break;
            }

            StdOut.println("Ingrese una opcion valida por favor.");

        }

    }

    public static void menuUsuario(SistemaCompras sistemaCompras, Usuario usuario) {
        String opcion;

        while (true) {
            StdOut.println("*********************************\n" +
                    "Menú del Usuario\n" +
                    "*********************************");
            StdOut.println("[1] Buscar un producto.");
            StdOut.println("[2] Gestionar carrito de compras.");
            StdOut.println("[3] Salir.");
            opcion = StdIn.readString();

            if (opcion.equals("1")) {
                buscarProducto(sistemaCompras, usuario);
            }
            if (opcion.equals("2")) {
                menuGestionarCarrito(sistemaCompras, usuario);
            }
            if (opcion.equals("3")) {
                StdOut.println("Volviendo...");
                break;
            }
                StdOut.println("Ingrese una opcion valida por favor.");
        }
    }

    public static void menuGestionarCarrito(SistemaCompras sistemaCompras, Usuario usuario) {
        String opcion;

        while (true) {
            StdOut.println("*********************************\n" +
                    "Gestionar Carrito de Compras\n" +
                    "*********************************");
            StdOut.println("[1] Pasar a pagar.");
            StdOut.println("[2] Eliminar producto del carrito.");
            StdOut.println("[3] Agregar producto al carrito.");
            StdOut.println("[4] Volver.");
            opcion = StdIn.readString();

            if (opcion.equals("1")) {
                pasarAPagar(sistemaCompras, usuario);
            }
            if (opcion.equals("2")) {
                eliminarProductoDelCarrito(sistemaCompras, usuario);
            }
            if (opcion.equals("3")) {
                aumentarCantidadProducto(sistemaCompras, usuario);
            }
            if (opcion.equals("4")) {
                StdOut.println("Volviendo...");
                break;
            }
            StdOut.println("Ingrese una opcion valida por favor.");
        }
    }

    public static void buscarProducto(SistemaCompras sistemaCompras, Usuario usuario) {
        StdOut.println("Ingrese la opcion deseada");
        StdOut.println("[1] Buscar producto por codigo.");
        StdOut.println("[2] Buscar producto por nombre.");
        String opcion = StdIn.readString();

        Producto producto = null;

        if (opcion.equals("1")) {
            StdOut.println("Ingrese el codigo del producto:");
            String codigo = StdIn.readString();
            producto = sistemaCompras.buscarProductoPorCodigo(codigo);
        } else if (opcion.equals("2")) {
            StdOut.println("Ingrese el nombre del producto:");
            String nombre = StdIn.readString();
            producto = sistemaCompras.buscarProductoPorNombre(nombre);
        } else {
            StdOut.println("Ingrese una opcion valida por favor.");
            return;
        }

        if (producto != null && producto.getStock() > 0) {
            StdOut.println("**** Producto ****");
            StdOut.println("Codigo: " + producto.getCodigo());
            StdOut.println("Nombre: " + producto.getNombre());
            StdOut.println("Precio: $" + producto.getPrecio());
            StdOut.println("Stock: " + producto.getStock());
            StdOut.println("Proveedor: " + producto.getProovedor());

            StdOut.println("¿Desea añadir el producto al carrito? [si|no]");
            String opcion2 = StdIn.readString();

            if (opcion2.equalsIgnoreCase("si")) {
                StdOut.println("Ingrese la cantidad que desea añadir:");
                int cantidad = StdIn.readInt();

                if (cantidad > 0) {
                    sistemaCompras.agregarProductoAlCarrito(usuario.getCarritoDeCompra(), producto, cantidad);
                } else {
                    StdOut.println("No se ha podido agregar al carrito.");
                }
            }

            StdOut.println("¿Desea buscar otro producto? [si|no]");
            opcion = StdIn.readString();

            if (opcion.equalsIgnoreCase("si")) {
                buscarProducto(sistemaCompras, usuario);
            } else {
                StdOut.println("Volviendo...");
            }
        } else {
            StdOut.println("No se pudo encontrar el producto.");
        }
    }

    public static void pasarAPagar(SistemaCompras sistemaCompras, Usuario usuario) {
        CarritoDeCompra carrito = usuario.getCarritoDeCompra();
        if (carrito.getCantidadDeElementos() == 0) {
            StdOut.println("El carrito de compras esta vacio.");
            return;
        }

        double totalAPagar = carrito.calcularTotal();
        StdOut.println("Total a pagar: $" + totalAPagar);

        StdOut.println("¿Desea confirmar el pago? [si|no]");
        String respuesta = StdIn.readString();

        if (respuesta.equalsIgnoreCase("si")) {
            sistemaCompras.pagar(usuario);
            StdOut.println("Pago confirmado, muchas gracias por su compra.");
        } else {
            StdOut.println("Pago cancelado.");
        }
    }

    public static void eliminarProductoDelCarrito(SistemaCompras sistemaCompras, Usuario usuario) {
        StdOut.println("Ingrese el codigo del producto que desea eliminar:");
        String codigo = StdIn.readString();
        sistemaCompras.eliminarProductoDelCarrito(usuario, codigo);
    }


    public static void aumentarCantidadProducto(SistemaCompras sistemaCompras, Usuario usuario) {
        CarritoDeCompra carrito = usuario.getCarritoDeCompra();

        if (carrito.getCantidadDeElementos() == 0) {
            StdOut.println("El carrito de compras esta vacio.");
            return;
        }

        StdOut.println("***** CARRITO DE COMPRAS *****");

        NodoProducto nodoAux = carrito.getCabeza();
        if (nodoAux == null) {
            StdOut.println("El carrito de compras esta vacio.");
            return;
        }

        Producto producto = nodoAux.getProductoAlmacenado();
        StdOut.println("Codigo: " + producto.getCodigo() +
                "\nNombre: " + producto.getNombre() +
                "\nPrecio: $" + producto.getPrecio() +
                "\nCantidad: " + nodoAux.getCantidad() +
                "\nProveedor: " + producto.getProovedor());

        StdOut.println("Ingrese el codigo del producto al cual desea aumentar la cantidad:");
        String codigo = StdIn.readString();
        producto = sistemaCompras.buscarProductoPorCodigo(codigo);

        if (producto != null) {

            nodoAux = carrito.getCabeza();
            if (nodoAux != null && nodoAux.getProductoAlmacenado().getCodigo().equalsIgnoreCase(codigo)) {
                StdOut.println("Producto encontrado en el carrito.");

                int cantidadDisponible = producto.getStock();
                int cantidadActual = nodoAux.getCantidad();

                StdOut.println("Ingrese la cantidad adicional que desea agregar:");
                int cantidadAgregar = StdIn.readInt();

                if (cantidadAgregar > 0 && cantidadAgregar <= cantidadDisponible) {
                    nodoAux.setCantidad(cantidadActual + cantidadAgregar);
                    producto.setStock(cantidadDisponible - cantidadAgregar);
                    StdOut.println("Cantidad aumentada correctamente en el carrito.");
                } else {
                    StdOut.println("La cantidad ingresada no es valida.");
                }
            } else {
                StdOut.println("El producto no esta en el carrito.");
            }
        } else {
            StdOut.println("Producto no encontrado.");
        }
    }


}