package dao;

import model.SignosVitales;
import model.Paciente;
import util.ConexionBD;
import java.sql.*;

public class SignosVitalesDAO {
    private static final String INSERT = "INSERT INTO SignosVitales (PacienteId, Fecha, Temperatura, PresionArterial, FrecuenciaCardiaca) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM SignosVitales";
    private static final String UPDATE = "UPDATE SignosVitales SET PacienteId = ?, Fecha = ?, Temperatura = ?, PresionArterial = ?, FrecuenciaCardiaca = ? WHERE Id = ?";
    private static final String DELETE = "DELETE FROM SignosVitales WHERE Id = ?";
    private static final String SELECT_BY_ID = "SELECT * FROM SignosVitales WHERE Id = ?";

    public boolean registrar(SignosVitales signos) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(INSERT)) {
            stmt.setString(1, signos.getPaciente().getId());
            stmt.setTimestamp(2, java.sql.Timestamp.valueOf(signos.getFecha().toString()));
            stmt.setDouble(3, signos.getTemperatura());
            stmt.setInt(4, signos.getPresionArterial());
            stmt.setInt(5, signos.getFrecuenciaCardiaca());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar signos vitales: " + e.getMessage());
            return false;
        }
    }

    public void listar() {
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("Id") + ", Paciente ID: " + rs.getString("PacienteId") +
                        ", Fecha: " + rs.getTimestamp("Fecha") +
                        ", Temperatura: " + rs.getDouble("Temperatura") +
                        ", Presión: " + rs.getInt("PresionArterial") +
                        ", FC: " + rs.getInt("FrecuenciaCardiaca"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar signos vitales: " + e.getMessage());
        }
    }

    public SignosVitales obtenerPorId(int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new SignosVitales(
                    rs.getInt("Id"),
                    new Paciente("", rs.getString("PacienteId"), "", ""),
                    rs.getTimestamp("Fecha").toLocalDateTime(),
                    rs.getDouble("Temperatura"),
                    rs.getInt("PresionArterial"),
                    rs.getInt("FrecuenciaCardiaca")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener signos vitales por ID: " + e.getMessage());
        }
        return null;
    }

    public boolean actualizar(SignosVitales signos, int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(UPDATE)) {
            stmt.setString(1, signos.getPaciente().getId());
            stmt.setTimestamp(2, java.sql.Timestamp.valueOf(signos.getFecha().toString()));
            stmt.setDouble(3, signos.getTemperatura());
            stmt.setInt(4, signos.getPresionArterial());
            stmt.setInt(5, signos.getFrecuenciaCardiaca());
            stmt.setInt(6, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar signos vitales: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(DELETE)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar signos vitales: " + e.getMessage());
            return false;
        }
    }
}