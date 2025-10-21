package dao;

import model.Habitacion;
import model.Departamento;
import util.ConexionBD;
import java.sql.*;

public class HabitacionDAO {
    private static final String INSERT = "INSERT INTO Habitaciones (Numero, Tipo, Estado, DepartamentoId) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM Habitaciones";

    public boolean registrar(Habitacion habitacion) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(INSERT)) {
            stmt.setString(1, habitacion.getNumero());
            stmt.setString(2, habitacion.getTipo());
            stmt.setString(3, habitacion.getEstado());
            stmt.setString(4, String.valueOf(habitacion.getDepartamento().getId()));
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar habitación: " + e.getMessage());
            return false;
        }
    }

    public void listar() {
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("Id") + ", Número: " + rs.getString("Numero") +
                        ", Tipo: " + rs.getString("Tipo") +
                        ", Estado: " + rs.getString("Estado") +
                        ", Departamento ID: " + rs.getInt("DepartamentoId"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar habitaciones: " + e.getMessage());
        }
    }
}