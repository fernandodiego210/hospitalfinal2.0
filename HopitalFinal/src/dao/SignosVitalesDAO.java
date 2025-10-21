package dao;

import model.SignosVitales;
import model.Paciente;
import util.ConexionBD;
import java.sql.*;

public class SignosVitalesDAO {
    private static final String INSERT = "INSERT INTO SignosVitales (PacienteId, Fecha, Temperatura, PresionArterial, FrecuenciaCardiaca) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM SignosVitales";

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
                System.out.println("ID: " + rs.getInt("Id") + ", Paciente ID: " + rs.getInt("PacienteId") +
                        ", Fecha: " + rs.getTimestamp("Fecha") +
                        ", Temperatura: " + rs.getDouble("Temperatura") +
                        ", Presión: " + rs.getInt("PresionArterial") +
                        ", FC: " + rs.getInt("FrecuenciaCardiaca"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar signos vitales: " + e.getMessage());
        }
    }
}