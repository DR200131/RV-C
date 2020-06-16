/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLogic;
import Data.*;
import Data.DataStructures.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author Juan Pablo
 */
public class Proyecto {
    
    public static void main(String[] args) throws FileNotFoundException{
        Inventario mi_inventario = new Inventario();
        Reporte mi_reporte = new Reporte();
        boolean inicio = true;
        while(inicio == true){
            System.out.println("Bienvenido. ¿Qué desea hacer?");
            System.out.println("Agregar venta o compra: Presione '1'");
            System.out.println("Ver tu inventario: Presione '2'");
            System.out.println("Generar reporte de ventas o compras: Presione '3'");
            System.out.println("¿Desea salir? Presione '0'");
            System.out.println();
            Scanner sc = new Scanner(System.in);
            int opcion_a = sc.nextInt();
            if (opcion_a == 1){
                System.out.println("¿Qué desea ingresar?");
                System.out.println("Venta: Presione '1'");
                System.out.println("Compra: Presione '2'");
                System.out.println("¿Desea regresar al inicio? Presione '9'");
                System.out.println("¿Desea salir? Presione '0'");
                System.out.println();
                int opcion_1 = sc.nextInt();
                if (opcion_1 == 2){
                    
                    System.out.println("Ingrese el nombre del proveedor");
                    System.out.println("¿Desea regresar al inicio? Presione '9'");
                    System.out.println("¿Desea salir? Presione '0'");
                    System.out.println();
                    String proveedor = sc.next();
                    if (proveedor.equals("9")) inicio = true;
                    else if (proveedor.equals("0")) {inicio = false; break;}
                    else{
                        System.out.println("Ingrese el nombre, la categoría, el precio de compra, el precio de venta que va a asignar, "
                                + "el código serial que va asignar," + '\n' + "la fecha de vencicimiento y, al final, la cantidad, para cada producto que va a adquirir de este proveedor." + '\n'
                                + "Escriba cada dato separado por espacios y cada producto en una nueva linea, terminando con la expresión EOF así:"
                                + '\n'+'\n' + "Producto_1 Categoria_1 PrecioCompra_1 PrecioVenta_1 Serial_1 FechaVencimiento_1 " + "Cantidad_1" + '\n'
                                + "Producto_2 Categoria_2 PrecioCompra_2 PrecioVenta_2 Serial_2 FechaVencimiento_2 " + "Cantidad_2" + '\n' + "EOF" + '\n');
                        System.out.println("¿Desea regresar al inicio? Presione '9'");
                        System.out.println("¿Desea salir? Presione '0'");
                        System.out.println("Para cargar archivo presionar 1");
                        System.out.println();
                        String cadena = sc.next();
                        if (cadena.equals("9")) inicio = true;
                        else if (cadena.equals("0")) {inicio = false; break;}
                        else{
                            ArbolAVL mi_arbol = new ArbolAVL();
                            float total = 0;
                            if (cadena.equals("1")) {
                                File f = new File("C:\\Users\\Juan Pablo\\Documents\\NetBeansProjects\\Generador de datos\\Archivo_de_prueba_compras.txt");
                                Scanner sc2 = new Scanner(f);
                                cadena = sc2.next();
                                while (cadena.equals("EOF")==false){
                                    String nombre = cadena;
                                    String categoria = sc2.next();
                                    float precio_compra = Float.parseFloat(sc2.next());
                                    float precio_venta = Float.parseFloat(sc2.next());
                                    int codigo_serial = Integer.parseInt(sc2.next());
                                    String fecha_vencimiento = sc2.next();
                                    int cantidad = Integer.parseInt(sc2.next());
                                    cadena = sc2.next();
                                    Producto nuevo_prod = new Producto(nombre, categoria, precio_compra, precio_venta, codigo_serial, proveedor, fecha_vencimiento, cantidad);
                                    if (mi_arbol.encontrar(nuevo_prod.getCodigo_serial()).equals(-1)){
                                        mi_arbol.insertar(nuevo_prod.getCodigo_serial(), nuevo_prod);
                                    }
                                    else {
                                        Producto antiguo = (Producto) mi_arbol.encontrar(nuevo_prod.getCodigo_serial());
                                        Producto nuevo_prod2 = new Producto(nombre, categoria, precio_compra, precio_venta, codigo_serial, proveedor, fecha_vencimiento, cantidad + antiguo.getCantidad());
                                        mi_arbol.eliminar(nuevo_prod.getCodigo_serial());
                                        mi_arbol.insertar(nuevo_prod2.getCodigo_serial(), nuevo_prod2);
                                    }
                                    if (mi_inventario.getArbolInventario().encontrar(codigo_serial).equals(-1)){
                                        mi_inventario.añadirArbol(nuevo_prod);
                                    }
                                    else{
                                        Producto antiguo = (Producto) mi_inventario.getArbolInventario().encontrar(codigo_serial);
                                        Producto nuevo_prod2 = new Producto(nombre, categoria, precio_compra, precio_venta, codigo_serial, proveedor, fecha_vencimiento, cantidad + antiguo.getCantidad());
                                        mi_inventario.quitarArbol(antiguo);
                                        mi_inventario.añadirArbol(nuevo_prod2);
                                    }
                                    total += precio_compra;
                                }
                            }
                            else{
                                while (cadena.equals("EOF")==false){
                                    String nombre = cadena;
                                    String categoria = sc.next();
                                    float precio_compra = Float.parseFloat(sc.next());
                                    float precio_venta = Float.parseFloat(sc.next());
                                    int codigo_serial = Integer.parseInt(sc.next());
                                    String fecha_vencimiento = sc.next();
                                    int cantidad = Integer.parseInt(sc.next());
                                    cadena = sc.next();
                                    Producto nuevo_prod = new Producto(nombre, categoria, precio_compra, precio_venta, codigo_serial, proveedor, fecha_vencimiento, cantidad);
                                    if (mi_arbol.encontrar(nuevo_prod.getCodigo_serial()).equals(-1)){
                                        mi_arbol.insertar(nuevo_prod.getCodigo_serial(), nuevo_prod);
                                    }
                                    else {
                                        Producto antiguo = (Producto) mi_arbol.encontrar(nuevo_prod.getCodigo_serial());
                                        Producto nuevo_prod2 = new Producto(nombre, categoria, precio_compra, precio_venta, codigo_serial, proveedor, fecha_vencimiento, cantidad + antiguo.getCantidad());
                                        mi_arbol.eliminar(nuevo_prod.getCodigo_serial());
                                        mi_arbol.insertar(nuevo_prod2.getCodigo_serial(), nuevo_prod2);
                                    }
                                    if (mi_inventario.getArbolInventario().encontrar(codigo_serial).equals(-1)){
                                        mi_inventario.añadirArbol(nuevo_prod);
                                    }
                                    else{
                                        Producto antiguo = (Producto) mi_inventario.getArbolInventario().encontrar(codigo_serial);
                                        Producto nuevo_prod2 = new Producto(nombre, categoria, precio_compra, precio_venta, codigo_serial, proveedor, fecha_vencimiento, cantidad + antiguo.getCantidad());
                                        mi_inventario.quitarArbol(antiguo);
                                        mi_inventario.añadirArbol(nuevo_prod2);
                                    }
                                    total += precio_compra;
                                }
                            }
                            //for (int i=0; i<1000000; i++){
                                Venta_Compra nueva_compra = new Venta_Compra();
                                String hoy = new Date().toString();
                                nueva_compra.ArbolCompra(proveedor, total, hoy, mi_arbol);
                                mi_reporte.añadirArbolCompra(nueva_compra);
                            //}
                            System.out.println();
                        }
                    }
                }
                else if(opcion_1 == 1){
                    if (mi_inventario.getArbolInventario().isEmpty()) System.out.println("El inventario está vacío" + '\n');
                    else{
                        System.out.println("Ingrese el nombre del cliente");
                        System.out.println("¿Desea regresar al inicio? Presione '9'");
                        System.out.println("¿Desea salir? Presione '0'");
                        System.out.println();
                        String cliente = sc.next();
                        if (cliente.equals("9")) inicio = true;
                        else if (cliente.equals("0")) {inicio = false; break;}
                        else{
                            System.out.println("Ingrese el código serial y la cantidad, para cada producto a vender." + '\n'
                                                + "Escriba cada dato separado por espacios y cada producto en una nueva linea, terminando con la expresión EOF así:"
                                                + '\n'+'\n' + "Serial_1 " + "Cantidad_1" + '\n' + "Serial_2 " + "Cantidad_2" + '\n' + "EOF" + '\n');
                            System.out.println("¿Desea regresar al inicio? Presione '9'");
                            System.out.println("¿Desea salir? Presione '0'");
                            System.out.println("Para cargar archivo presionar 1");
                            System.out.println();
                            String cadena = sc.next();
                            if (cadena.equals("9")) inicio = true;
                            else if (cadena.equals("0")) {inicio = false; break;}
                            else{
                                ArbolAVL mi_arbol = new ArbolAVL();
                                float total = 0;
                                if (cadena.equals("1")) {
                                    File f = new File("C:\\Users\\Juan Pablo\\Documents\\NetBeansProjects\\Generador de datos\\Archivo_de_prueba_ventas.txt");
                                    Scanner sc2 = new Scanner(f);
                                    cadena = sc2.next();
                                    while (cadena.equals("EOF")==false){
                                        int serial = Integer.parseInt(cadena);
                                        int cantidad = Integer.parseInt(sc2.next());
                                        if (mi_inventario.buscarArbolSerial(serial).getCantidad() < cantidad){
                                            System.out.println("No hay suficiente disponibilidad del producto. Quedan "
                                                    + mi_inventario.buscarArbolSerial(serial).getCantidad() + " unidades disponibles" + '\n');
                                        }
                                        else{
                                            Producto viejo_prod = mi_inventario.buscarArbolSerial(serial);
                                            float precio_venta = viejo_prod.getPrecio_venta();
                                            mi_inventario.quitarArbol(viejo_prod);
                                            int nueva_cantidad = (viejo_prod.getCantidad() - cantidad);
                                            if (nueva_cantidad != 0){
                                                Producto nuevo_prod = new Producto(viejo_prod.getNombre(), viejo_prod.getCategoria(), viejo_prod.getPrecio_compra(),
                                                viejo_prod.getPrecio_venta(), viejo_prod.getCodigo_serial(), viejo_prod.getFecha_vencimiento(), viejo_prod.getFecha_vencimiento(), nueva_cantidad);
                                                mi_inventario.añadirArbol(nuevo_prod);
                                            }
                                            if (mi_arbol.encontrar(viejo_prod.getCodigo_serial()).equals(-1)){
                                                Producto nuevo_prod2 = new Producto(viejo_prod.getNombre(), viejo_prod.getCategoria(), viejo_prod.getPrecio_compra(),
                                                viejo_prod.getPrecio_venta(), viejo_prod.getCodigo_serial(), viejo_prod.getFecha_vencimiento(), viejo_prod.getFecha_vencimiento(), cantidad);
                                                mi_arbol.insertar(nuevo_prod2.getCodigo_serial(), nuevo_prod2);
                                            }
                                            else {
                                                Producto antiguo = (Producto) mi_arbol.encontrar(viejo_prod.getCodigo_serial());
                                                Producto nuevo_prod2 = new Producto(viejo_prod.getNombre(), viejo_prod.getCategoria(), viejo_prod.getPrecio_compra(),
                                                viejo_prod.getPrecio_venta(), viejo_prod.getCodigo_serial(), viejo_prod.getFecha_vencimiento(), viejo_prod.getFecha_vencimiento(), cantidad+antiguo.getCantidad());
                                                mi_arbol.eliminar(antiguo.getCodigo_serial());
                                                mi_arbol.insertar(nuevo_prod2.getCodigo_serial(), nuevo_prod2);
                                            }
                                            total += precio_venta;
                                        }
                                        cadena = sc2.next();
                                        if(cadena.equals("0")) {inicio = false; break;}
                                        else if(cadena.equals("9")) break;
                                    }
                                }
                                else{
                                    while (cadena.equals("EOF")==false){
                                        int serial = Integer.parseInt(cadena);
                                        int cantidad = Integer.parseInt(sc.next());
                                        if (mi_inventario.buscarArbolSerial(serial).getCantidad() < cantidad){
                                            System.out.println("No hay suficiente disponibilidad del producto. Quedan "
                                                    + mi_inventario.buscarArbolSerial(serial).getCantidad() + " unidades disponibles" + '\n');
                                        }
                                        else{
                                            Producto viejo_prod = mi_inventario.buscarArbolSerial(serial);
                                            float precio_venta = viejo_prod.getPrecio_venta();
                                            mi_inventario.quitarArbol(viejo_prod);
                                            int nueva_cantidad = (viejo_prod.getCantidad() - cantidad);
                                            if (nueva_cantidad != 0){
                                                Producto nuevo_prod = new Producto(viejo_prod.getNombre(), viejo_prod.getCategoria(), viejo_prod.getPrecio_compra(),
                                                viejo_prod.getPrecio_venta(), viejo_prod.getCodigo_serial(), viejo_prod.getFecha_vencimiento(), viejo_prod.getFecha_vencimiento(), nueva_cantidad);
                                                mi_inventario.añadirArbol(nuevo_prod);
                                            }
                                            if (mi_arbol.encontrar(viejo_prod.getCodigo_serial()).equals(-1)){
                                                Producto nuevo_prod2 = new Producto(viejo_prod.getNombre(), viejo_prod.getCategoria(), viejo_prod.getPrecio_compra(),
                                                viejo_prod.getPrecio_venta(), viejo_prod.getCodigo_serial(), viejo_prod.getFecha_vencimiento(), viejo_prod.getFecha_vencimiento(), cantidad);
                                                mi_arbol.insertar(nuevo_prod2.getCodigo_serial(), nuevo_prod2);
                                            }
                                            else {
                                                Producto antiguo = (Producto) mi_arbol.encontrar(viejo_prod.getCodigo_serial());
                                                Producto nuevo_prod2 = new Producto(viejo_prod.getNombre(), viejo_prod.getCategoria(), viejo_prod.getPrecio_compra(),
                                                viejo_prod.getPrecio_venta(), viejo_prod.getCodigo_serial(), viejo_prod.getFecha_vencimiento(), viejo_prod.getFecha_vencimiento(), cantidad+antiguo.getCantidad());
                                                mi_arbol.eliminar(antiguo.getCodigo_serial());
                                                mi_arbol.insertar(nuevo_prod2.getCodigo_serial(), nuevo_prod2);
                                            }
                                            total += precio_venta;
                                        }
                                        cadena = sc.next();
                                        if(cadena.equals("0")) {inicio = false; break;}
                                        else if(cadena.equals("9")) break;
                                    }
                                }
                                Venta_Compra nueva_venta = new Venta_Compra();
                                String hoy = new Date().toString();
                                nueva_venta.ArbolVenta(cliente, total, hoy, mi_arbol);
                                mi_reporte.añadirArbolVenta(nueva_venta);
                                System.out.println();
                            }
                        }
                    }
                }
                else if (opcion_1 == 9) inicio = true;
                else if (opcion_1 == 0) {inicio = false; break;}
                else {System.out.println("Seleccione una opción válida"); System.out.println();}
            }
            else if (opcion_a == 2){
                if (mi_inventario.getArbolInventario().isEmpty()) System.out.println("El inventario está vacío" + '\n');
                else {
                    System.out.println("¿Desea conocer la disponibilidad de un proudcto? Escriba el código serial seguido de la tecla enter.");
                    System.out.println("¿Desea ver el inventario completo? Presione '1'");
                    System.out.println("¿Desea conocer los productos con prioridad para la próxima compra? Presione '2'");
                    System.out.println("¿Desea regresar al inicio? Presione '9'");
                    System.out.println("¿Desea salir? Presione '0'");
                    System.out.println();
                    int opcion_b = sc.nextInt();
                    while (opcion_b != 9){
                        if (opcion_b == 1) {mi_inventario.imprimeArbolInventario(); System.out.println(); break;}
                        else if (opcion_b == 2){
                            int max = mi_inventario.getArbolInventario().llaveMaximo();
                            int min = mi_inventario.getArbolInventario().llaveMinimo();
                            Cola_prioridad heap = new Cola_prioridad(max - min + 1);
                            Pila reserva = new Pila();
                            for (int i = min; i <= max; i++){
                                if (!mi_inventario.getArbolInventario().encontrar(i).equals(-1)){
                                    Producto disponible = (Producto) mi_inventario.getArbolInventario().encontrar(i);
                                    heap.insertar(disponible.getCantidad());
                                }
                            }
                            while (opcion_b == 2 && !mi_inventario.getArbolInventario().isEmpty()){
                                int prioritario = heap.peek();
                                for (int i = min; i <= max; i++){
                                    if (!mi_inventario.getArbolInventario().encontrar(i).equals(-1)){
                                        Producto disponible = (Producto) mi_inventario.getArbolInventario().encontrar(i);
                                        if (prioritario == disponible.getCantidad()){
                                            System.out.println(disponible);
                                            reserva.push(disponible);
                                            mi_inventario.quitarArbol(disponible);
                                            if (!mi_inventario.getArbolInventario().isEmpty()) heap.remove();
                                        }
                                    }
                                }
                                opcion_b = sc.nextInt();
                            }
                            while (!reserva.isEmpty()){
                                mi_inventario.añadirArbol((Producto) reserva.pop());
                            }
                            if (opcion_b == 0) inicio = false;
                            else {System.out.println("Opción inválida"); System.out.println();}
                            break;
                        }
                        else if (opcion_b == 0) {inicio = false; break;}
                        else{
                            System.out.println("Hay " + mi_inventario.buscarArbolSerial(opcion_b).getCantidad() + " unidades disponibles de ese producto" + '\n');
                        }
                        opcion_b = sc.nextInt();
                    }
                }
            }
            else if (opcion_a == 3){
                System.out.println("¿Qué desea generar?");
                System.out.println("Reporte de ventas: Presione '1'");
                System.out.println("Reporte de compras: Presione '2'");
                System.out.println("¿Desea regresar al inicio? Presione '9'");
                System.out.println("¿Desea salir? Presione '0'");
                System.out.println();
                int opcion_2 = sc.nextInt();
                if (opcion_2 == 1){
                    if (mi_reporte.getArbolVentas().isEmpty()) System.out.println("No hay ventas para mostrar" + '\n');
                    else {
                        System.out.println("Para ver el reporte completo presione 1.");
                        System.out.println("Para ver una venta específica presione 2.");
                        System.out.println("¿Desea regresar al inicio? Presione '9'");
                        System.out.println("¿Desea salir? Presione '0'");
                        System.out.println();
                        int opcion_3 = sc.nextInt();
                            if (opcion_3 == 1) {
                                mi_reporte.showArbolVentas(); System.out.println();
                                float suma = 0;
                                for (int i = 1; i<=mi_reporte.getArbolVentas().llaveMaximo(); i++){
                                    Venta_Compra it = (Venta_Compra) mi_reporte.getArbolVentas().encontrar(i);
                                    suma += it.getTotal();
                                }
                                System.out.println("GANANCIAS TOTALES = " + suma + '\n');
                            }
                            else if (opcion_3 == 2){
                                System.out.println("Ingrese el id de venta.");
                                System.out.println();
                                int opcion_4 = sc.nextInt();
                                Object n = mi_reporte.getArbolVentas().encontrar(opcion_4);
                                if (!n.equals(-1)) {
                                    Venta_Compra busca = (Venta_Compra) mi_reporte.getArbolVentas().encontrar(opcion_4);
                                    System.out.println(busca);
                                    System.out.println("¿Desea eliminar esta venta? Presione 1");
                                    System.out.println("¿Desea regresar al inicio? Presione '9'");
                                    System.out.println("¿Desea salir? Presione '0'");
                                    System.out.println();
                                    int opcion_5 = sc.nextInt();
                                    if (opcion_5 == 1) {
                                        while (!busca.getArbolProductos().isEmpty()){
                                            Producto viejo_prod = (Producto) busca.getArbolProductos().getDatoRaiz();
                                            int agrega = mi_inventario.buscarArbolSerial(viejo_prod.getCodigo_serial()).getCantidad();
                                            if (agrega == 0){mi_inventario.añadirArbol(viejo_prod);}
                                            else{
                                                Producto nuevo_prod = new Producto(viejo_prod.getNombre(), viejo_prod.getCategoria(), viejo_prod.getPrecio_compra(),
                                                viejo_prod.getPrecio_venta(), viejo_prod.getCodigo_serial(), viejo_prod.getFecha_vencimiento(), viejo_prod.getFecha_vencimiento(), viejo_prod.getCantidad()+agrega);
                                                mi_inventario.quitarArbol(viejo_prod);
                                                mi_inventario.añadirArbol(nuevo_prod);
                                            }
                                            busca.getArbolProductos().eliminar(busca.getArbolProductos().getLlaveRaiz());
                                        }
                                        mi_reporte.quitarArbolVenta(busca);
                                    }
                                    else if (opcion_5 == 9) inicio = true;
                                    else if (opcion_5 == 0) {inicio = false; break;}
                                    else {System.out.println("Seleccione una opción válida"); System.out.println();}
                                } 
                                else {System.out.println("Venta no encontrada");}
                            }
                            else if (opcion_3 == 9) inicio = true;
                            else if (opcion_3 == 0) {inicio = false; break;}
                            else {System.out.println("Seleccione una opción válida"); System.out.println();}
                    }
                }
                else if (opcion_2 == 2){
                    if (mi_reporte.getArbolCompras().isEmpty()) System.out.println("No hay compras para mostrar" + '\n');
                    else {
                        System.out.println("Para ver el reporte completo presione 1.");
                        System.out.println("Para ver una compra específica presione 2.");
                        System.out.println("¿Desea regresar al inicio? Presione '9'");
                        System.out.println("¿Desea salir? Presione '0'");
                        System.out.println();
                        int opcion_6 = sc.nextInt();
                            if (opcion_6 == 1) {
                                mi_reporte.showArbolCompras(); System.out.println();
                                float suma = 0;
                                for (int i = 1; i<=mi_reporte.getArbolCompras().llaveMaximo(); i++){
                                    Venta_Compra it = (Venta_Compra) mi_reporte.getArbolCompras().encontrar(i);
                                    suma += it.getTotal();
                            }
                            System.out.println("GASTOS TOTALES = " + suma + '\n');
                            }
                            else if (opcion_6 == 2){
                                System.out.println("Ingrese el id de compra.");
                                System.out.println();
                                int opcion_7 = sc.nextInt();
                                Object n = mi_reporte.getArbolCompras().encontrar(opcion_7);
                                if (!n.equals(-1)) {
                                    Venta_Compra busca = (Venta_Compra) mi_reporte.getArbolCompras().encontrar(opcion_7);
                                    System.out.println(busca);
                                    System.out.println("Productos = ");
                                    busca.getArbolProductos().inOrder(busca.getArbolProductos().getRaiz());
                                    System.out.println("¿Desea eliminar esta compra? Presione 1");
                                    System.out.println("¿Desea regresar al inicio? Presione '9'");
                                    System.out.println("¿Desea salir? Presione '0'");
                                    System.out.println();
                                    int opcion_8 = sc.nextInt();
                                    if (opcion_8 == 1) {
                                        while (!busca.getArbolProductos().isEmpty()){
                                            Producto viejo_prod = (Producto) busca.getArbolProductos().getDatoRaiz();
                                            mi_inventario.quitarArbol(viejo_prod);
                                            busca.getArbolProductos().eliminar(busca.getArbolProductos().getLlaveRaiz());
                                        }
                                        mi_reporte.quitarArbolCompra(busca);
                                    }
                                    else if (opcion_8 == 9) inicio = true;
                                    else if (opcion_8 == 0) {inicio = false; break;}
                                    else {System.out.println("Seleccione una opción válida"); System.out.println();}
                                } 
                                else {System.out.println("Compra no encontrada");}
                            }
                            else if (opcion_6 == 9) inicio = true;
                            else if (opcion_6 == 0) {inicio = false; break;}
                            else {System.out.println("Seleccione una opción válida"); System.out.println();}
                    }
                }
                else if (opcion_2 == 9) inicio = true;
                else if (opcion_2 == 0) {inicio = false; break;}
                else {System.out.println("Seleccione una opción válida"); System.out.println();}
            }
            else if (opcion_a == 0) {inicio = false; break;}
            else {System.out.println("Seleccione una opción válida"); System.out.println();}
        }
    }  
}