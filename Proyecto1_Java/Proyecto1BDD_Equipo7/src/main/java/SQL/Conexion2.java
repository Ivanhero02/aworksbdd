/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author silkn
 */
public class Conexion2 {
    public static Connection getConexion(){
    Connection conexion;
    String BD_URL = "jdbc:sqlserver://ls1-bdd-1.database.windows.net:1434;"
                    +"database=AW_Person;"
                    +"user=SA_BDD;"
                    +"password=Holacomoestas1;"
                    +"loginTimeout=30;";
    try{
        conexion=DriverManager.getConnection(BD_URL);
        return conexion;
    }catch(SQLException ex){
        System.out.println(ex.toString());
        return null;
    }
    
    
    }
}
