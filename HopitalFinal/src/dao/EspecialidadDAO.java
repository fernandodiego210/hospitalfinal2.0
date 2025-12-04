package dao;

import model.Especialidad;
import util.ConexionBD;
import java.sql.*;

public class EspecialidadDAO {
    private static final String INSERT = "INSERT INTO Especialidades (Nombre) VALUES (?)";
    private static final String SELECT_ALL = "SELECT * FROM Especialidades";
    private static final String UPDATE = "UPDATE Especialidades SET Nombre = ? WHERE Id = ?";
    private static final String DELETE = "DELETE FROM Especialidades WHERE Id = ?";
    private static final String SELECT_BY_ID = "SELECT * FROM Especialidades WHERE Id = ?";

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

    public Especialidad obtenerPorId(int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Especialidad(rs.getInt("Id"), rs.getString("Nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener especialidad por ID: " + e.getMessage());
        }
        return null;
    }

    public boolean actualizar(Especialidad especialidad, int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(UPDATE)) {
            stmt.setString(1, especialidad.getNombre());
            stmt.setInt(2, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar especialidad: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(DELETE)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar especialidad: " + e.getMessage());
            return false;
        }
    }
}