package dao;

import model.Paciente;
import util.ConexionBD;
import java.sql.*;

public class PacienteDAO {
    private static final String INSERT = "INSERT INTO Pacientes (Nombre, Enfermedad, Seguro) VALUES (?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM Pacientes";
    private static final String UPDATE = "UPDATE Pacientes SET Nombre = ?, Enfermedad = ?, Seguro = ? WHERE Id = ?";
    private static final String DELETE = "DELETE FROM Pacientes WHERE Id = ?";
    private static final String SELECT_BY_ID = "SELECT * FROM Pacientes WHERE Id = ?";

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

    public Paciente obtenerPorId(String id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Paciente(
                    rs.getString("Nombre"),
                    rs.getString("Id"),
                    rs.getString("Enfermedad"),
                    rs.getString("Seguro")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener paciente por ID: " + e.getMessage());
        }
        return null;
    }

    public boolean actualizar(Paciente paciente, String id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(UPDATE)) {
            stmt.setString(1, paciente.getNombre());
            stmt.setString(2, paciente.getEnfermedad());
            stmt.setString(3, paciente.getSeguro());
            stmt.setString(4, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar paciente: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(String id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(DELETE)) {
            stmt.setString(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar paciente: " + e.getMessage());
            return false;
        }
    }
}