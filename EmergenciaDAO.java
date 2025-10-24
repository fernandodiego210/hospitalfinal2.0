package dao;

import model.Emergencia;
import model.Paciente;
import model.Doctor;
import util.ConexionBD;
import java.sql.*;

public class EmergenciaDAO {
    private static final String INSERT = "INSERT INTO Emergencias (PacienteId, DoctorId, FechaIngreso, Descripcion, Prioridad) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM Emergencias";

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
                System.out.println("ID: " + rs.getInt("Id") + ", Paciente ID: " + rs.getInt("PacienteId") +
                        ", Doctor ID: " + rs.getInt("DoctorId") +
                        ", Fecha: " + rs.getTimestamp("FechaIngreso") +
                        ", Prioridad: " + rs.getString("Prioridad"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar emergencias: " + e.getMessage());
        }
    }
}