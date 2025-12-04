package dao;

import model.TipoExamen;
import util.ConexionBD;
import java.sql.*;

public class TipoExamenDAO {
    private static final String INSERT = "INSERT INTO TiposExamen (Nombre) VALUES (?)";
    private static final String SELECT_ALL = "SELECT * FROM TiposExamen";
    private static final String UPDATE = "UPDATE TiposExamen SET Nombre = ? WHERE Id = ?";
    private static final String DELETE = "DELETE FROM TiposExamen WHERE Id = ?";
    private static final String SELECT_BY_ID = "SELECT * FROM TiposExamen WHERE Id = ?";

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

    public TipoExamen obtenerPorId(int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new TipoExamen(rs.getInt("Id"), rs.getString("Nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener tipo de examen por ID: " + e.getMessage());
        }
        return null;
    }

    public boolean actualizar(TipoExamen tipo, int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(UPDATE)) {
            stmt.setString(1, tipo.getNombre());
            stmt.setInt(2, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar tipo de examen: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(DELETE)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar tipo de examen: " + e.getMessage());
            return false;
        }
    }
}