/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import com.mysql.cj.jdbc.Driver;
import java.sql.*;

public class MySql {
    private static Connection con;
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "Sebastian31";
    private static final String url = "jdbc:mysql://localhost:3306/RVC";

    public MySql() {
    }
    
    public boolean login(String Nom_usu, String passw, String cargo){
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            PreparedStatement st = con.prepareStatement("Select * from Usuario where Nom_usu = ? and passw = ? and tipo_usuario = ?");
            st.setString(1, Nom_usu);
            st.setString(2, passw);
            st.setString(3, cargo);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return true;
            }
            else{
                System.out.println(rs);
                return false;
            }
            
        }
        catch(Exception e){
            return false;
        }
    }
    
    public boolean RegistroV(String Nom_Cli, float total, String Fecha, int cantidad, int codigo_s){
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            PreparedStatement st = con.prepareStatement("Insert into Venta(Nom_Cli, Total, F_Venta) Values(?,?,?)");
            st.setString(1, Nom_Cli);
            st.setDouble(2, (Double.parseDouble(String.valueOf(total))));
            st.setString(3, Fecha);
            int rs = st.executeUpdate();
            
            long cod_prod = IdProd(codigo_s);
            
            long cod_ven = IdVenta(Nom_Cli, total, Fecha);
            
            int r = Es_De_Venta(cod_prod, cod_ven, cantidad);
            
            boolean r2 = mod_canV(cantidad, codigo_s);
            
            if(rs > 0 && r > 0 && r2){
                return true;
            }
            else{
                System.out.println(rs);
                return false;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
    
    public long IdProd(int c_serial){
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            PreparedStatement st2 = con.prepareStatement("Select IdProducto from Producto where c_serial = ?");
            st2.setLong(1, (Long.parseLong(String.valueOf(c_serial))));
            ResultSet rs2 = st2.executeQuery();
            if(rs2.next()){
                long cod_prod = rs2.getInt(1);
                return cod_prod;
            }
            else{
                return 0;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return 0;
        }
    }
    
    public long IdVenta(String Nom_Cli, float total, String Fecha){
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            PreparedStatement st3 = con.prepareStatement("Select IdVenta from Venta where Nom_Cli = ? and Total = ? and F_venta = ?");
            st3.setString(1, Nom_Cli);
            st3.setDouble(2, (Double.parseDouble(String.valueOf(total))));
            st3.setString(3, Fecha);
            ResultSet rs3 = st3.executeQuery();
            if(rs3.next()){
                long cod_ven = rs3.getInt(1);
                return cod_ven;
            }
            else{
                return 0;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return 0;
        }
    }
    
    public int Es_De_Venta(long idprod, long idven, int cant){
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            PreparedStatement st4 = con.prepareStatement("Insert into Es_de_Venta(IdVenta, IdProducto, Cantidad_V) Values(?,?,?)");
            st4.setLong(1, idven);
            st4.setLong(2, idprod);
            st4.setInt(3, cant);
            int rs4 = st4.executeUpdate();
            return rs4;
        }
        catch(Exception e){
            System.out.println(e);
            return 0;
        }
    }
    
    public int consultarC(int c_serial){
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            PreparedStatement st2 = con.prepareStatement("Select cantidad from Producto where c_serial = ?");
            st2.setLong(1, (Long.parseLong(String.valueOf(c_serial))));
            ResultSet rs2 = st2.executeQuery();
            if(rs2.next()){
                int can_prod = rs2.getInt(1);
                return can_prod;
            }
            else{
                return 0;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return 0;
        }
    }
    
    public boolean mod_canV(int cantv, int c_serial){
        int cantp = consultarC(c_serial);
        cantp = cantp - cantv;
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            PreparedStatement st2 = con.prepareStatement("update Producto set cantidad = ? Where c_serial = ?");
            st2.setInt(1, cantp);
            st2.setLong(2, (Long.parseLong(String.valueOf(c_serial))));
            int rs2 = st2.executeUpdate();
            if(rs2 > 0){
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
    
    public boolean RegistroC(String Provee, String Nom_p, String Cate, float precio_c, int codigo_s, String F_ven, int cant, float precio_v, float total, String Fecha_c){
        int idprov = consultarIDprov(Provee);
        boolean r2 = true;
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            PreparedStatement st = con.prepareStatement("Insert into Compra(IdProveedor, Total, F_compra) Values(?,?,?)");
            st.setLong(1, idprov);
            st.setDouble(2, (Double.parseDouble(String.valueOf(total))));
            st.setString(3, Fecha_c);
            int rs = st.executeUpdate();
            
            long cod_prod = IdProd(codigo_s);
            if(cod_prod == 0){
                boolean rp = RegistrarP(Nom_p, Cate, precio_c, precio_v, codigo_s, F_ven, cant, idprov);
                if(rp == true){
                    cod_prod = IdProd(codigo_s);
                }
                else{
                    return false;
                }
            }
            else{
                r2 = mod_canC(cant, codigo_s);
            }
            
            long cod_com = IdCompra(idprov, total, Fecha_c);

            int r = Es_De_Compra(cod_prod, cod_com, cant);
            
            
            if(rs > 0 && r > 0 && r2){
                return true;
            }
            else{
                System.out.println(rs);
                return false;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
    
    public int consultarIDprov(String Nom_prov){
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            PreparedStatement st2 = con.prepareStatement("Select IdProveedor from Proveedor where Nomb_Prov = ?");
            st2.setString(1, Nom_prov);
            ResultSet rs2 = st2.executeQuery();
            if(rs2.next()){
                int idprov = rs2.getInt(1);
                return idprov;
            }
            else{
                return 0;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return 0;
        }
    }
    
    public boolean RegistrarP(String Nom_p, String cate, float precio_c, float precio_v, int c_serial, String f_ven, int cant, int idprov){
         try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            PreparedStatement st = con.prepareStatement("Insert into Producto(nombre, categoria, precio_c, precio_v, c_serial, f_vencimiento, cantidad, IdProveedor) Values(?,?,?,?,?,?,?,?)");
            st.setString(1, Nom_p);
            st.setString(2, cate);
            st.setDouble(3, (Double.parseDouble(String.valueOf(precio_c))));
            st.setDouble(4, (Double.parseDouble(String.valueOf(precio_v))));
            st.setLong(5, (Long.parseLong(String.valueOf(c_serial))));
            st.setString(6, f_ven);
            st.setInt(7, cant);
            st.setInt(8, idprov);
            int rs = st.executeUpdate();
         
            if(rs > 0){
                return true;
            }
            else{
                System.out.println(rs);
                return false;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
    
    public long IdCompra(int IdProv, float total, String Fecha){
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            PreparedStatement st3 = con.prepareStatement("Select IdCompra from Compra where IdProveedor = ? and Total = ? and F_compra = ?");
            st3.setInt(1, IdProv);
            st3.setDouble(2, (Double.parseDouble(String.valueOf(total))));
            st3.setString(3, Fecha);
            ResultSet rs3 = st3.executeQuery();
            if(rs3.next()){
                long cod_com= rs3.getInt(1);
                return cod_com;
            }
            else{
                return 0;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return 0;
        }
    }
    
    public int Es_De_Compra(long idprod, long idcom, int cant){
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            PreparedStatement st4 = con.prepareStatement("Insert into Es_de_Compra(IdCompra, IdProducto, Cantidad_C) Values(?,?,?)");
            st4.setLong(1, idcom);
            st4.setLong(2, idprod);
            st4.setInt(3, cant);
            int rs4 = st4.executeUpdate();
            return rs4;
        }
        catch(Exception e){
            System.out.println(e);
            return 0;
        }
    }
    
    public boolean mod_canC(int cantc, int c_serial){
        int cantp = consultarC(c_serial);
        cantp = cantp + cantc;
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            PreparedStatement st2 = con.prepareStatement("update Producto set cantidad = ? Where c_serial = ?");
            st2.setInt(1, cantp);
            st2.setLong(2, (Long.parseLong(String.valueOf(c_serial))));
            int rs2 = st2.executeUpdate();
            if(rs2 > 0){
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
    
    public ResultSet consultalproductos(){
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            PreparedStatement st3 = con.prepareStatement("Select IdProveedor, nombre, categoria, precio_c, precio_v, c_serial, f_vencimiento, cantidad from Producto");
            ResultSet rs3 = st3.executeQuery();
            if(rs3 != null){
                return rs3;
            }
            else{
                return null;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public ResultSet consultaC(){
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            PreparedStatement st3 = con.prepareStatement("Select pr.Nomb_Prov, p.nombre, p.categoria, p.precio_c, p.c_serial, p.f_vencimiento, e.cantidad_c, p.precio_v, c.F_compra, c.Total from compra c, es_de_compra e, Producto p, Proveedor pr where c.IdCompra = e.IdCompra and c.IdProveedor = pr.IdProveedor and p.IdProducto = e.IdProducto");
            ResultSet rs3 = st3.executeQuery();
            if(rs3 != null){
                return rs3;
            }
            else{
                return null;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public ResultSet consultaV(){
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            PreparedStatement st3 = con.prepareStatement("Select v.Nom_Cli, p.nombre, p.categoria, p.c_serial, p.f_vencimiento, e.cantidad_v, p.precio_v, v.F_venta, v.Total from venta v, es_de_venta e, producto p where p.IdProducto = e.IdProducto and v.IdVenta = e.IdVenta");
            ResultSet rs3 = st3.executeQuery();
            if(rs3 != null){
                return rs3;
            }
            else{
                return null;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
