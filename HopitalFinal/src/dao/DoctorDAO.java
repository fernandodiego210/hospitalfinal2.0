package dao;

import model.Doctor;
import util.ConexionBD;
import java.sql.*;

public class DoctorDAO {
    private static final String INSERT = "INSERT INTO Doctores (Nombre, Especialidad, DepartamentoId) VALUES (?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM Doctores";

    public boolean registrar(Doctor doctor) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(INSERT)) {
            stmt.setString(1, doctor.getNombre()); // ✅ String
            stmt.setString(2, doctor.getEspecialidad()); // ✅ String
            stmt.setInt(3, doctor.getDepartamentoId()); // ✅ int → setInt
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
}