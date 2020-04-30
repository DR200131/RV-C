/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;
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
        String s1 = "";
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
                    ListaEnlazada mi_lista = new ListaEnlazada();
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
                            if (cadena.equals("1")) {
                                File f = new File("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\RV-C\\data\\Archivo_de_prueba_compras.txt");
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
                                    Producto nuevo_prod = new Producto(nombre, categoria, precio_compra, precio_venta, codigo_serial, proveedor, fecha_vencimiento);
                                    for (int i=0; i<cantidad; i++){
                                        mi_lista.agregarAtras(nuevo_prod);
                                        mi_inventario.añadir(nuevo_prod);
                                    }
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
                                    Producto nuevo_prod = new Producto(nombre, categoria, precio_compra, precio_venta, codigo_serial, proveedor, fecha_vencimiento);
                                    for (int i=0; i<cantidad; i++){
                                        mi_lista.agregarAtras(nuevo_prod);
                                        mi_inventario.añadir(nuevo_prod);
                                    }
                                }
                            }
                            Venta_Compra nueva_compra = new Venta_Compra();
                            float total = 0;
                            for(int i=0; i<mi_lista.tamaño(); i++){
                                Producto prod = (Producto) mi_lista.obtener(i);
                                total += prod.getPrecio_compra();
                            }
                            String hoy = new Date().toString();
                            nueva_compra.Compra(proveedor, total, hoy, mi_lista);
                            mi_reporte.añadirCompra(nueva_compra);
                            System.out.println();
                        }
                    }
                }
                else if(opcion_1 == 1){
                    ListaEnlazada mi_lista = new ListaEnlazada();
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
                            if (cadena.equals("1")) {
                                File f = new File("C:C:\\Users\\Usuario\\Documents\\NetBeansProjects\\RV-C\\data\\Archivo_de_prueba_ventas.txt");
                                Scanner sc2 = new Scanner(f);
                                cadena = sc2.next();
                                while (cadena.equals("EOF")==false){
                                    int serial = Integer.parseInt(cadena);
                                    int cantidad = Integer.parseInt(sc2.next());
                                    if (mi_inventario.contarProductos(serial) < cantidad){
                                        System.out.println("No hay suficiente disponibilidad del producto. Quedan "
                                                + mi_inventario.contarProductos(serial) + " unidades disponibles" + '\n');
                                    }
                                    else{
                                        Producto viejo_prod = mi_inventario.buscarSerial(serial);
                                        for (int i=0; i<cantidad; i++){
                                            mi_lista.agregarAtras(viejo_prod);
                                            mi_inventario.quitar(viejo_prod);
                                        }
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
                                    if (mi_inventario.contarProductos(serial) < cantidad){
                                        System.out.println("No hay suficiente disponibilidad del producto. Quedan "
                                                + mi_inventario.contarProductos(serial) + " unidades disponibles" + '\n');
                                    }
                                    else{
                                        Producto viejo_prod = mi_inventario.buscarSerial(serial);
                                        for (int i=0; i<cantidad; i++){
                                            mi_lista.agregarAtras(viejo_prod);
                                            mi_inventario.quitar(viejo_prod);
                                        }
                                    }
                                    cadena = sc.next();
                                    if(cadena.equals("0")) {inicio = false; break;}
                                    else if(cadena.equals("9")) break;
                                }
                            }
                            Venta_Compra nueva_venta = new Venta_Compra();
                            float total = 0;
                            for(int i=0; i<mi_lista.tamaño(); i++){
                                Producto prod = (Producto) mi_lista.obtener(i);
                                total += prod.getPrecio_venta();
                            }
                            String hoy = new Date().toString();
                            nueva_venta.Venta(cliente, total, hoy, mi_lista);
                            mi_reporte.añadirVenta(nueva_venta);
                            System.out.println();
                        }
                    }
                }
                else if (opcion_1 == 9) inicio = true;
                else if (opcion_1 == 0) {inicio = false; break;}
                else {System.out.println("Seleccione una opción válida"); System.out.println();}
            }
            else if (opcion_a == 2){
                if (mi_inventario.getInventario().tamaño() == 0) System.out.println("El inventario está vacío" + '\n');
                else {
                    mi_inventario.imprimeInventario(); System.out.println();
                    System.out.println("¿Desea conocer la disponibilidad de un proudcto? Escriba el código serial seguido de la tecla enter.");
                    System.out.println("¿Desea regresar al inicio? Presione '9'");
                    System.out.println("¿Desea salir? Presione '0'");
                    System.out.println();
                int opcion_b = sc.nextInt();    
                    if (opcion_b == 9) inicio = true;
                    else if (opcion_b == 0) {inicio = false; break;}
                    else{
                        while (opcion_b != 9 && opcion_b != 0){
                            System.out.println("Hay " + mi_inventario.contarProductos(opcion_b) + " unidades disponibles de ese producto" + '\n');
                            opcion_b = sc.nextInt();
                        }
                        if (opcion_b == 0) {inicio = false; break;}
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
                    if (mi_reporte.getVentas().tamaño() == 0) System.out.println("No hay ventas para mostrar" + '\n');
                    else {
                        System.out.println("Para ver el reporte completo presione 1.");
                        System.out.println("Para ver una venta específica presione 2.");
                        System.out.println("¿Desea regresar al inicio? Presione '9'");
                        System.out.println("¿Desea salir? Presione '0'");
                        System.out.println();
                        int opcion_3 = sc.nextInt();
                            if (opcion_3 == 1) {
                                mi_reporte.showVentas(); System.out.println();
                                float suma = 0;
                                for (int i = 0; i<mi_reporte.getVentas().tamaño(); i++){
                                    Venta_Compra it = (Venta_Compra) mi_reporte.getVentas().obtener(i);
                                    suma += it.getTotal();
                                }
                                System.out.println("GANANCIAS TOTALES = " + suma + '\n');
                            }
                            else if (opcion_3 == 2){
                                System.out.println("Ingrese el id de venta.");
                                System.out.println();
                                int opcion_4 = sc.nextInt();
                                for (int k=0; k<mi_reporte.getVentas().tamaño(); k++){
                                    Venta_Compra busca = (Venta_Compra) mi_reporte.getVentas().obtener(k);
                                    if (busca.getIdventa() == opcion_4) {
                                        System.out.println(busca);
                                        System.out.println("¿Desea eliminar esta venta? Presione 1");
                                        System.out.println("¿Desea regresar al inicio? Presione '9'");
                                        System.out.println("¿Desea salir? Presione '0'");
                                        System.out.println();
                                        int opcion_5 = sc.nextInt();
                                        if (opcion_5 == 1) {
                                            mi_reporte.quitarVenta(busca);
                                            for (int m=0; m<busca.getProductos().tamaño(); m++){
                                                Producto produ = (Producto) busca.getProductos().obtener(m);
                                                mi_inventario.añadir(produ);
                                            }
                                        }
                                        else if (opcion_5 == 9) inicio = true;
                                        else if (opcion_5 == 0) {inicio = false; break;}
                                        else {System.out.println("Seleccione una opción válida"); System.out.println();}
                                        break;
                                    } 
                                    else if (k == mi_reporte.getVentas().tamaño()-1) {System.out.println("Venta no encontrada");}
                                }
                            }
                            else if (opcion_3 == 9) inicio = true;
                            else if (opcion_3 == 0) {inicio = false; break;}
                            else {System.out.println("Seleccione una opción válida"); System.out.println();}
                    }
                }
                else if (opcion_2 == 2){
                    if (mi_reporte.getCompras().tamaño() == 0) System.out.println("No hay compras para mostrar" + '\n');
                    else {
                        System.out.println("Para ver el reporte completo presione 1.");
                        System.out.println("Para ver una compra específica presione 2.");
                        System.out.println("¿Desea regresar al inicio? Presione '9'");
                        System.out.println("¿Desea salir? Presione '0'");
                        System.out.println();
                        int opcion_6 = sc.nextInt();
                            if (opcion_6 == 1) {
                                mi_reporte.showCompras(); System.out.println();
                                float suma = 0;
                                for (int i = 0; i<mi_reporte.getCompras().tamaño(); i++){
                                    Venta_Compra it = (Venta_Compra) mi_reporte.getCompras().obtener(i);
                                    suma += it.getTotal();
                                }
                                System.out.println("INGRESOS TOTALES = " + suma + '\n');
                            }
                            else if (opcion_6 == 2){
                                System.out.println("Ingrese el id de compra.");
                                System.out.println();
                                int opcion_7 = sc.nextInt();
                                int revisor = 0;
                                for (int k=0; k<mi_reporte.getCompras().tamaño(); k++){
                                    Venta_Compra busca = (Venta_Compra) mi_reporte.getCompras().obtener(k);
                                    if (busca.getIdcompra() == opcion_7) {
                                        System.out.println(busca);
                                        System.out.println("¿Desea eliminar esta compra? Presione 1");
                                        System.out.println("¿Desea regresar al inicio? Presione '9'");
                                        System.out.println("¿Desea salir? Presione '0'");
                                        System.out.println();
                                        int opcion_8 = sc.nextInt();
                                        if (opcion_8 == 1) {
                                            mi_reporte.quitarCompra(busca);
                                            for (int m=0; m<busca.getProductos().tamaño(); m++){
                                                Producto produ = (Producto) busca.getProductos().obtener(m);
                                                mi_inventario.quitar(produ);
                                            }
                                        }
                                        else if (opcion_8 == 9) inicio = true;
                                        else if (opcion_8 == 0) {inicio = false; break;}
                                        else {System.out.println("Seleccione una opción válida"); System.out.println();}
                                        break;
                                    } 
                                    else if (k == mi_reporte.getCompras().tamaño()-1) {System.out.println("Compra no encontrada");}
                                }
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