package dao;

import model.Enfermero;
import util.ConexionBD;
import java.sql.*;

public class EnfermeroDAO {
    private static final String INSERT = "INSERT INTO Enfermeros (Nombre, Area, Turno) VALUES (?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM Enfermeros";
    private static final String UPDATE = "UPDATE Enfermeros SET Nombre = ?, Area = ?, Turno = ? WHERE Id = ?";
    private static final String DELETE = "DELETE FROM Enfermeros WHERE Id = ?";
    private static final String SELECT_BY_ID = "SELECT * FROM Enfermeros WHERE Id = ?";

    public boolean registrar(Enfermero enfermero) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(INSERT)) {
            stmt.setString(1, enfermero.getNombre());
            stmt.setString(2, enfermero.getArea());
            stmt.setString(3, enfermero.getTurno());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar enfermero: " + e.getMessage());
            return false;
        }
    }

    public void listar() {
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("Id") + ", Nombre: " + rs.getString("Nombre") +
                        ", Área: " + rs.getString("Area") +
                        ", Turno: " + rs.getString("Turno"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar enfermeros: " + e.getMessage());
        }
    }

    public Enfermero obtenerPorId(String id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Enfermero(
                    rs.getString("Nombre"),
                    rs.getString("Id"),
                    rs.getString("Area"),
                    rs.getString("Turno")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener enfermero por ID: " + e.getMessage());
        }
        return null;
    }

    public boolean actualizar(Enfermero enfermero, String id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(UPDATE)) {
            stmt.setString(1, enfermero.getNombre());
            stmt.setString(2, enfermero.getArea());
            stmt.setString(3, enfermero.getTurno());
            stmt.setString(4, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar enfermero: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(String id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(DELETE)) {
            stmt.setString(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar enfermero: " + e.getMessage());
            return false;
        }
    }
}