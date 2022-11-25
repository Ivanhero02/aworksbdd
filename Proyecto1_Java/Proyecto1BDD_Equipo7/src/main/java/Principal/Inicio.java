/*
 * PROGRAMA PRINCIPAL PARA LA REALIZACION Y BUSQUEDA DE LAS CONSULTAS DEL PROYECTO
 */
package Principal;

import SQL.Conexion1;
import SQL.Conexion2;
import SQL.Conexion3;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Equipo7BDD
 */
public class Inicio{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
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
            Conexion2 con2 = new Conexion2();
            Conexion3 con3 = new Conexion3();
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
                   System.out.println("Valor1"+result.getRow());
                }
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
            break;
        case 3:
            System.out.println("---Actualizar Stock por categoria un 5%---");
            break;
        case 4:
            System.out.println("---Determinacion de clientes en otras regiones---");
            break;
        case 5:
            System.out.println("---Actualizar cantidad de productos por orden---");
            break;
        case 6:
            System.out.println("---Actualizar Metodo de envio de una orden---");
            break;
        case 7:
            System.out.println("---Actualizar correo electronico de cliente---");
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
