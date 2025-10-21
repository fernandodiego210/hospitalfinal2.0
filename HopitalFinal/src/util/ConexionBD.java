package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String SERVIDOR = "localhost\\SQLEXPRESS"; // ✅ Cambiado a localhost
    private static final String PUERTO = "1433";
    private static final String BASE_DATOS = "HospitalDB";
    private static final String USUARIO = "java_user";
    private static final String PASSWORD = "NuevaPassword123";

    private static final String URL = "jdbc:sqlserver://" + SERVIDOR + ":" + PUERTO +
            ";databaseName=" + BASE_DATOS + ";encrypt=false;trustServerCertificate=true;";

    public static Connection obtenerConexion() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(URL, USUARIO, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver no encontrado: " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            return null;
        }
    }
}