package dao;

import model.Cita;
import model.Paciente;
import model.Doctor;
import util.ConexionBD;
import java.sql.*;

public class CitaDAO {
    private static final String INSERT = "INSERT INTO Citas (PacienteId, DoctorId, FechaCita, Motivo) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM Citas";

    public boolean registrar(Cita cita) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(INSERT)) {
        	stmt.setString(1, cita.getPaciente().getId());
        	stmt.setString(2, cita.getDoctor().getId());
            stmt.setTimestamp(3, java.sql.Timestamp.valueOf(cita.getFecha().toString()));
            stmt.setString(4, cita.getMotivo());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar cita: " + e.getMessage());
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
                        ", Fecha: " + rs.getTimestamp("FechaCita") +
                        ", Motivo: " + rs.getString("Motivo"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar citas: " + e.getMessage());
        }
    }
}