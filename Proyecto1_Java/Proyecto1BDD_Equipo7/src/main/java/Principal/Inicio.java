/*
 * PROGRAMA PRINCIPAL PARA LA REALIZACION Y BUSQUEDA DE LAS CONSULTAS DEL PROYECTO
 */
package Principal;

import SQL.Conexion1;
import SQL.Conexion2;
import SQL.Conexion3;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Equipo7BDD
 */
public class Inicio{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception {
    //Comenzamos con un menu para realizar las diferentes consultas
    Scanner sn=new Scanner(System.in);
    boolean salir = false;
    int op;
    while(!salir){
    System.out.println("------------MENU------------");
    System.out.println("1.-Total de Ventas de producto");
    System.out.println("2.-Consultar producto mas solicitado para norteamerica");
    System.out.println("3.-Actualizar Stock por categoria un 5%");
    System.out.println("4.-Determinacion de clientes en otras regiones");
    System.out.println("5.-Actualizar cantidad de productos por orden");
    System.out.println("6.-Actualizar Metodo de envio de una orden");
    System.out.println("7.-Actualizar correo electronico de cliente");
    System.out.println("8.-Salir");
    try{
        System.out.println("Escoga una opcion");
        op=sn.nextInt();
        switch(op){
        case 1:
            String bases="";
            System.out.println("---Total de Ventas de producto---");
            Conexion1 con1 = new Conexion1();
            //Para las conexiones con las demas instancias tomando asi los procedimientos almacenados
            //Conexion2 con2 = new Conexion2();
            //Conexion3 con3 = new Conexion3();
            int cat;
            Scanner sn2=new Scanner(System.in);
            try{
                System.out.println("\nIntroduzca la Categoria del producto:");
                cat=sn2.nextInt();
                //Llamamos al procedimiento almacenado
                CallableStatement pal1 = con1.getConexion().prepareCall("{call sp_Ejercicioa(?)}");
                //Agregamos el valor al procedimiento
                pal1.setInt(1,cat);
                //Ejecutamos la consulta al procedimiento
                pal1.execute();
                //Obtenemos los valores 
                final ResultSet result = pal1.getResultSet();
                while(result.next()){
                   System.out.println(result.getRow()+" Total Ventas:"+result.getString(1)+" Territorio:"+result.getString(2)+" ID Territorio:"+result.getString(3));
                }
                result.close();
                pal1.close();
                
            }catch(SQLException ex){
                System.out.println(ex.toString());
            }
            /*
            Prueba de conexion
            Conexion1 con = new Conexion1();
            try{
                Statement sql = con.getConexion().createStatement();
                String consulta = "select * from Sales.SalesOrderHeader";
                ResultSet resultado = sql.executeQuery(consulta);
                while(resultado.next()){
                    System.out.println("indice:"+resultado.getRow()+" valor1:"+resultado.getString(1));
                }
            }catch(SQLException ex){
                System.out.println(ex.toString());
            }
            */
            break;
        case 2:
            System.out.println("---Consultar producto mas solicitado para norteamerica---");
            Conexion1 con1_2 = new Conexion1();
            try{
                //Llamamos al procedimiento almacenado
                CallableStatement pal1 = con1_2.getConexion().prepareCall("{call sp_Ejerciciob}");
                //Agregamos el valor al procedimiento
                //Ejecutamos la consulta al procedimiento
                pal1.execute();
                //Obtenemos los valores 
                final ResultSet result = pal1.getResultSet();
                while(result.next()){
                   System.out.println(result.getRow()+" Producto:"+result.getString(1)+" Solicitudes:"+result.getString(2)+" Region:"+result.getString(3));
                }
                
            }catch(SQLException ex){
                System.out.println(ex.toString());
            }
            
            break;
        case 3:
            System.out.println("---Actualizar Stock por categoria un 5%---");
            int cat2,ID;
            Scanner sn3=new Scanner(System.in);
            Conexion1 con1_3 = new Conexion1();
            try{
                System.out.println("\nIntroduzca la Categoria del producto:");
                cat2=sn3.nextInt();
                System.out.println("\nIntroduzca la locacion ID:");
                ID=sn3.nextInt();
                //Llamamos al procedimiento almacenado
                CallableStatement pal1 = con1_3.getConexion().prepareCall("{call sp_Ejercicioc(?,?)}");
                //Agregamos el valor al procedimiento
                pal1.setInt(1,cat2);
                pal1.setInt(2, ID);
                //Ejecutamos la consulta al procedimiento
                pal1.execute();
                //Obtenemos los valores 
                System.out.println("Stock Actualizado");
            }catch(SQLException ex){
                System.out.println(ex.toString());
            }
            break;
        case 4:
            System.out.println("---Determinacion de clientes en otras regiones---");
            Conexion1 con1_4 = new Conexion1();
            try{
                //Llamamos al procedimiento almacenado
                CallableStatement pal1 = con1_4.getConexion().prepareCall("{call sp_Ejerciciod}");
                //Agregamos el valor al procedimiento
                //Ejecutamos la consulta al procedimiento
                pal1.execute();
                //Obtenemos los valores 
                final ResultSet result = pal1.getResultSet();
                while(result.next()){
                   System.out.println(result.getRow()+" ID: "+result.getString(1)+" TeritorioPedido:"+result.getString(2)+" TerritorioMandado:"+result.getString(3));
                }
            }catch(SQLException ex){
                System.out.println(ex.toString());
            }
            break;
        case 5:
            System.out.println("---Actualizar cantidad de productos por orden---");
            int ID2,PID,cant;
            Scanner sn4=new Scanner(System.in);
            Conexion1 con1_5 = new Conexion1();
            try{
                System.out.println("\nIntroduzca el ID:");
                ID2=sn4.nextInt();
                System.out.println("\nIntroduzca el ID del producto:");
                PID=sn4.nextInt();
                System.out.println("\nIntroduzca la cantidad:");
                cant=sn4.nextInt();
                //Llamamos al procedimiento almacenado
                CallableStatement pal1 = con1_5.getConexion().prepareCall("{call sp_Ejercicioe(?,?,?)}");
                //Agregamos el valor al procedimiento
                pal1.setInt(1,ID2);
                pal1.setInt(2, PID);
                pal1.setInt(3,cant);
                //Ejecutamos la consulta al procedimiento
                pal1.execute();
                //Obtenemos los valores 
               System.out.println("Cantidad Actualizada");
            }catch(SQLException ex){
                System.out.println(ex.toString());
            }
            break;
        case 6:
            System.out.println("---Actualizar Metodo de envio de una orden---");
            int ID3,dir;
            Scanner sn5=new Scanner(System.in);
            Conexion1 con1_6 = new Conexion1();
            try{
                System.out.println("\nIntroduzca el ID:");
                ID3=sn5.nextInt();
                System.out.println("\nIntroduzca el ID del metodo de envio nuevo:");
                dir=sn5.nextInt();
                //Llamamos al procedimiento almacenado
                CallableStatement pal1 = con1_6.getConexion().prepareCall("{call sp_Ejercicioe(?,?)}");
                //Agregamos el valor al procedimiento
                pal1.setInt(1,ID3);
                pal1.setInt(2, dir);
                //Ejecutamos la consulta al procedimiento
                pal1.execute();
                //Obtenemos los valores 
                 System.out.println("Metodo Actualizado");
            }catch(SQLException ex){
                System.out.println(ex.toString());
            }
            break;
        case 7:
            System.out.println("---Actualizar correo electronico de cliente---");
            int IDP;
            String email;
            Scanner sn6=new Scanner(System.in);
            Conexion1 con1_7 = new Conexion1();
            try{
                System.out.println("\nIntroduzca el ID de la persona:");
                IDP=sn6.nextInt();
                System.out.println("\nIntroduzca el nuevo email:");
                email=sn6.next();
                //Llamamos al procedimiento almacenado
                CallableStatement pal1 = con1_7.getConexion().prepareCall("{call sp_Ejercicioe(?,?)}");
                //Agregamos el valor al procedimiento
                pal1.setInt(1,IDP);
                pal1.setString(2, email);
                //Ejecutamos la consulta al procedimiento
                pal1.execute();
                //Obtenemos los valores 
                
                System.out.println("Email Actualizado");
            }catch(SQLException ex){
                System.out.println(ex.toString());
            }
            break;
        case 8:
            salir=true;
            break;
        default:
            System.out.println("Solo numeros de 1 a 8");
        }
    }catch(InputMismatchException e){
        System.out.println("Debe de insertar un numero");
        sn.next();
    }   
}
}
}
