package dao;

import model.PersonalCirugia;
import util.ConexionBD;
import java.sql.*;

public class PersonalCirugiaDAO {
    private static final String INSERT = "INSERT INTO PersonalCirugia (Nombre, Rol) VALUES (?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM PersonalCirugia";

    public boolean registrar(PersonalCirugia personal) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(INSERT)) {
        	stmt.setString(1, personal.getNombre());
        	stmt.setString(2, personal.getRol());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar personal de cirugía: " + e.getMessage());
            return false;
        }
    }

    public void listar() {
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("Id") + ", Nombre: " + rs.getString("Nombre") +
                        ", Rol: " + rs.getString("Rol"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar personal de cirugía: " + e.getMessage());
        }
    }
}