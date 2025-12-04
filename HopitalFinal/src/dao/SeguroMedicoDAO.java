package dao;

import model.SeguroMedico;
import util.ConexionBD;
import java.sql.*;

public class SeguroMedicoDAO {
    private static final String INSERT = "INSERT INTO SegurosMedicos (Nombre, Tipo) VALUES (?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM SegurosMedicos";
    private static final String UPDATE = "UPDATE SegurosMedicos SET Nombre = ?, Tipo = ? WHERE Id = ?";
    private static final String DELETE = "DELETE FROM SegurosMedicos WHERE Id = ?";
    private static final String SELECT_BY_ID = "SELECT * FROM SegurosMedicos WHERE Id = ?";

    public boolean registrar(SeguroMedico seguro) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(INSERT)) {
            stmt.setString(1, seguro.getNombre());
            stmt.setString(2, seguro.getTipo());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar seguro médico: " + e.getMessage());
            return false;
        }
    }

    public void listar() {
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("Id") + ", Nombre: " + rs.getString("Nombre") +
                        ", Tipo: " + rs.getString("Tipo"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar seguros médicos: " + e.getMessage());
        }
    }

    public SeguroMedico obtenerPorId(int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new SeguroMedico(rs.getInt("Id"), rs.getString("Nombre"), rs.getString("Tipo"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener seguro médico por ID: " + e.getMessage());
        }
        return null;
    }

    public boolean actualizar(SeguroMedico seguro, int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(UPDATE)) {
            stmt.setString(1, seguro.getNombre());
            stmt.setString(2, seguro.getTipo());
            stmt.setInt(3, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar seguro médico: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(DELETE)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar seguro médico: " + e.getMessage());
            return false;
        }
    }
}