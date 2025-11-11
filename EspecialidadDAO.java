package dao;

import model.Especialidad;
import util.ConexionBD;
import java.sql.*;

public class EspecialidadDAO {
    private static final String INSERT = "INSERT INTO Especialidades (Nombre) VALUES (?)";
    private static final String SELECT_ALL = "SELECT * FROM Especialidades";

    public boolean registrar(Especialidad especialidad) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(INSERT)) {
            stmt.setString(1, especialidad.getNombre());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar especialidad: " + e.getMessage());
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
            System.out.println("Error al listar especialidades: " + e.getMessage());
        }
    }
}