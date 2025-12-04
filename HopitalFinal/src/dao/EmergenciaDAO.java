package dao;

import model.Emergencia;
import model.Paciente;
import model.Doctor;
import util.ConexionBD;
import java.sql.*;

public class EmergenciaDAO {
    private static final String INSERT = "INSERT INTO Emergencias (PacienteId, DoctorId, FechaIngreso, Descripcion, Prioridad) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM Emergencias";
    private static final String UPDATE = "UPDATE Emergencias SET PacienteId = ?, DoctorId = ?, FechaIngreso = ?, Descripcion = ?, Prioridad = ? WHERE Id = ?";
    private static final String DELETE = "DELETE FROM Emergencias WHERE Id = ?";
    private static final String SELECT_BY_ID = "SELECT * FROM Emergencias WHERE Id = ?";

    public boolean registrar(Emergencia emergencia) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(INSERT)) {
            stmt.setString(1, emergencia.getPaciente().getId());
            stmt.setString(2, emergencia.getDoctor().getId());
            stmt.setTimestamp(3, java.sql.Timestamp.valueOf(emergencia.getFechaIngreso().toString()));
            stmt.setString(4, emergencia.getDescripcion());
            stmt.setString(5, emergencia.getPrioridad());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar emergencia: " + e.getMessage());
            return false;
        }
    }

    public void listar() {
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("Id") + ", Paciente ID: " + rs.getString("PacienteId") +
                        ", Doctor ID: " + rs.getString("DoctorId") +
                        ", Fecha: " + rs.getTimestamp("FechaIngreso") +
                        ", Prioridad: " + rs.getString("Prioridad"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar emergencias: " + e.getMessage());
        }
    }

    public Emergencia obtenerPorId(int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Emergencia(
                    rs.getInt("Id"),
                    new Paciente("", rs.getString("PacienteId"), "", ""),
                    new Doctor("", rs.getString("DoctorId"), "", 0),
                    rs.getTimestamp("FechaIngreso").toLocalDateTime(),
                    rs.getString("Descripcion"),
                    rs.getString("Prioridad")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener emergencia por ID: " + e.getMessage());
        }
        return null;
    }

    public boolean actualizar(Emergencia emergencia, int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(UPDATE)) {
            stmt.setString(1, emergencia.getPaciente().getId());
            stmt.setString(2, emergencia.getDoctor().getId());
            stmt.setTimestamp(3, java.sql.Timestamp.valueOf(emergencia.getFechaIngreso().toString()));
            stmt.setString(4, emergencia.getDescripcion());
            stmt.setString(5, emergencia.getPrioridad());
            stmt.setInt(6, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar emergencia: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(DELETE)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar emergencia: " + e.getMessage());
            return false;
        }
    }
}