package dao;

import model.Paciente;
import util.ConexionBD;
import java.sql.*;

public class PacienteDAO {
    private static final String INSERT = "INSERT INTO Pacientes (Nombre, Enfermedad, Seguro) VALUES (?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM Pacientes";

    public boolean registrar(Paciente paciente) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(INSERT)) {
        	stmt.setString(1, paciente.getNombre());
        	stmt.setString(2, paciente.getEnfermedad());
        	stmt.setString(3, paciente.getSeguro());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar paciente: " + e.getMessage());
            return false;
        }
    }

    public void listar() {
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("Id") + ", Nombre: " + rs.getString("Nombre") +
                        ", Enfermedad: " + rs.getString("Enfermedad") +
                        ", Seguro: " + rs.getString("Seguro"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar pacientes: " + e.getMessage());
        }
    }
}