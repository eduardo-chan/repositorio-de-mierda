package mx.edu.utez.proyectoservlet.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public Connection getConnection(){
        final String DBNAME = "utex2",
                USERNAME = "root",
                PASSWORD = "root",
                TIMEZONE = "America/Mexico_City",
                USESSL = "true",       //conexiones remotas//
                PUBLICKEY = "true";

        //192.168.62.185
        //hacemos la conexión
        String dataSource = String.format("jdbc:mysql://localhost:3306/%s?user=%s&password=%s&serverTimeZone=" +
                "%s&useSSL=%s&allowPublickeyRetrieval=%s",
                DBNAME, USERNAME, PASSWORD, TIMEZONE, USESSL, PUBLICKEY);    //pasar parametros

        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            return DriverManager.getConnection(dataSource);              //le mandamos la petición
        }catch (SQLException e){
            System.out.println(this.getClass().getCanonicalName() + " -> " + e.getMessage());  //si falla
        }
        return null; //si no retorna nulo
    }

    public static void main(String[] args) {
        Connection conn = new MySQLConnection().getConnection();
        if (conn != null){
            try {
                System.out.println("Conexión realizada :)");
                conn.close();
            }catch (SQLException e){
                System.out.println(e + "xd");
            }
        } else {
            System.out.println("Conexión fallida :( xd");
        }
    }
}
