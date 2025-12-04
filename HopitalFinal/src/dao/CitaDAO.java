package dao;

import model.Cita;
import model.Paciente;
import model.Doctor;
import util.ConexionBD;
import java.sql.*;

public class CitaDAO {
    private static final String INSERT = "INSERT INTO Citas (PacienteId, DoctorId, FechaCita, Motivo) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM Citas";
    private static final String UPDATE = "UPDATE Citas SET PacienteId = ?, DoctorId = ?, FechaCita = ?, Motivo = ? WHERE Id = ?";
    private static final String DELETE = "DELETE FROM Citas WHERE Id = ?";
    private static final String SELECT_BY_ID = "SELECT * FROM Citas WHERE Id = ?";

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
                System.out.println("ID: " + rs.getInt("Id") + ", Paciente ID: " + rs.getString("PacienteId") +
                        ", Doctor ID: " + rs.getString("DoctorId") +
                        ", Fecha: " + rs.getTimestamp("FechaCita") +
                        ", Motivo: " + rs.getString("Motivo"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar citas: " + e.getMessage());
        }
    }

    public Cita obtenerPorId(int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Cita(
                    rs.getInt("Id"),
                    new Paciente("", rs.getString("PacienteId"), "", ""),
                    new Doctor("", rs.getString("DoctorId"), "", 0),
                    rs.getTimestamp("FechaCita").toLocalDateTime(),
                    rs.getString("Motivo")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener cita por ID: " + e.getMessage());
        }
        return null;
    }

    public boolean actualizar(Cita cita, int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(UPDATE)) {
            stmt.setString(1, cita.getPaciente().getId());
            stmt.setString(2, cita.getDoctor().getId());
            stmt.setTimestamp(3, java.sql.Timestamp.valueOf(cita.getFecha().toString()));
            stmt.setString(4, cita.getMotivo());
            stmt.setInt(5, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar cita: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(DELETE)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar cita: " + e.getMessage());
            return false;
        }
    }
}