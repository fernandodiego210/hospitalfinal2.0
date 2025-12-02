package dao;

import model.TipoExamen;
import util.ConexionBD;
import java.sql.*;

public class TipoExamenDAO {
    private static final String INSERT = "INSERT INTO TiposExamen (Nombre) VALUES (?)";
    private static final String SELECT_ALL = "SELECT * FROM TiposExamen";

    public boolean registrar(TipoExamen tipo) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(INSERT)) {
            stmt.setString(1, tipo.getNombre());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar tipo de examen: " + e.getMessage());
            return false;
        }
    }

    public void listar() {
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("Id") + ", Nombre: " + rs.getString("Nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar tipos de examen: " + e.getMessage());
        }
    }
}