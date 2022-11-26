/*
 * Clase de conexion para la primera instancia
 */
package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author silkn
 */
public class Conexion3 {
    public static Connection getConexion(){
    Connection conexion;
    String BD_URL = "jdbc:sqlserver://ls-1.database.windows.net:1434;"
                    +"database=AW_Production;"
                    +"user=itzeeel_cava;"
                    +"password=itzelCV2020.;"
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
