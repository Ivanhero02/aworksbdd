/*
 * Para realizar la conexion con la instancia 1
 */
package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author silkn
 */
public class ConexionIns1 {
    //Variables de conexion para la base de datos 
    protected Connection conexion;
    private final String usuario = "usuario";//Agregamos un usuario
    private final String contraseña = "";//contraseña
    private final String bd = "AdventureWorks2019"; //Base de datos a la que entraremos
    private final String ip = "";//Ip 
    private final String puerto = "1434";//Puerto de la instancia
    private final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String BD_URL = "jdbc:sqlserver://"+ip+":"+puerto+";"+"databaseName="+bd;


    
    //Funcion para conectar la base de datos
public void conectar() throws Exception {
        try {
            conexion = DriverManager.getConnection(BD_URL, usuario, contraseña);

        } catch (SQLException e) {
            System.out.println("ERROR " + e);
        }
    }
    
    public Connection obtenerconexion(){
        try {
            conexion = DriverManager.getConnection(BD_URL, usuario, contraseña);
        } catch (SQLException e) {
            System.out.println("ERROR " + e);
        }
        return conexion;
    }

    public void cerrar() throws SQLException {
        if (conexion != null) {
            if (!conexion.isClosed()) {
                conexion.close();
            }
        }
    }
}