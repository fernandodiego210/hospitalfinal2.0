package dao;

import model.Doctor;
import util.ConexionBD;
import java.sql.*;

public class DoctorDAO {
    private static final String INSERT = "INSERT INTO Doctores (Nombre, Especialidad, DepartamentoId) VALUES (?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM Doctores";
    private static final String UPDATE = "UPDATE Doctores SET Nombre = ?, Especialidad = ?, DepartamentoId = ? WHERE Id = ?";
    private static final String DELETE = "DELETE FROM Doctores WHERE Id = ?";
    private static final String SELECT_BY_ID = "SELECT * FROM Doctores WHERE Id = ?";

    public boolean registrar(Doctor doctor) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(INSERT)) {
            stmt.setString(1, doctor.getNombre()); 
            stmt.setString(2, doctor.getEspecialidad());
            stmt.setInt(3, doctor.getDepartamentoId()); 
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar doctor: " + e.getMessage());
            return false;
        }
    }

    public void listar() {
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("Id") + ", Nombre: " + rs.getString("Nombre") +
                        ", Especialidad: " + rs.getString("Especialidad") +
                        ", Departamento ID: " + rs.getInt("DepartamentoId"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar doctores: " + e.getMessage());
        }
    }

    public Doctor obtenerPorId(String id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Doctor(
                    rs.getString("Nombre"),
                    rs.getString("Id"),
                    rs.getString("Especialidad"),
                    rs.getInt("DepartamentoId")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener doctor por ID: " + e.getMessage());
        }
        return null;
    }

    public boolean actualizar(Doctor doctor, String id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(UPDATE)) {
            stmt.setString(1, doctor.getNombre());
            stmt.setString(2, doctor.getEspecialidad());
            stmt.setInt(3, doctor.getDepartamentoId());
            stmt.setString(4, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar doctor: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(String id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(DELETE)) {
            stmt.setString(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar doctor: " + e.getMessage());
            return false;
        }
    }
}