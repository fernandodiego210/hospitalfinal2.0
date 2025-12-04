package dao;

import model.Habitacion;
import model.Departamento;
import util.ConexionBD;
import java.sql.*;

public class HabitacionDAO {
    private static final String INSERT = "INSERT INTO Habitaciones (Numero, Tipo, Estado, DepartamentoId) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM Habitaciones";
    private static final String UPDATE = "UPDATE Habitaciones SET Numero = ?, Tipo = ?, Estado = ?, DepartamentoId = ? WHERE Id = ?";
    private static final String DELETE = "DELETE FROM Habitaciones WHERE Id = ?";
    private static final String SELECT_BY_ID = "SELECT * FROM Habitaciones WHERE Id = ?";

    public boolean registrar(Habitacion habitacion) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(INSERT)) {
            stmt.setString(1, habitacion.getNumero());
            stmt.setString(2, habitacion.getTipo());
            stmt.setString(3, habitacion.getEstado());
            stmt.setInt(4, habitacion.getDepartamento().getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar habitación: " + e.getMessage());
            return false;
        }
    }

    public void listar() {
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("Id") + ", Número: " + rs.getString("Numero") +
                        ", Tipo: " + rs.getString("Tipo") +
                        ", Estado: " + rs.getString("Estado") +
                        ", Departamento ID: " + rs.getInt("DepartamentoId"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar habitaciones: " + e.getMessage());
        }
    }

    public Habitacion obtenerPorId(int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Habitacion(
                    rs.getInt("Id"),
                    rs.getString("Numero"),
                    rs.getString("Tipo"),
                    rs.getString("Estado"),
                    new Departamento(rs.getInt("DepartamentoId"), "")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener habitación por ID: " + e.getMessage());
        }
        return null;
    }

    public boolean actualizar(Habitacion habitacion, int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(UPDATE)) {
            stmt.setString(1, habitacion.getNumero());
            stmt.setString(2, habitacion.getTipo());
            stmt.setString(3, habitacion.getEstado());
            stmt.setInt(4, habitacion.getDepartamento().getId());
            stmt.setInt(5, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar habitación: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(DELETE)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar habitación: " + e.getMessage());
            return false;
        }
    }
}