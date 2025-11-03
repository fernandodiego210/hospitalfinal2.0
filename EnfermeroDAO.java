package dao;

import model.Enfermero;
import util.ConexionBD;
import java.sql.*;

public class EnfermeroDAO {
    private static final String INSERT = "INSERT INTO Enfermeros (Nombre, Area, Turno) VALUES (?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM Enfermeros";

    public boolean registrar(Enfermero enfermero) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(INSERT)) {
        	stmt.setString(1, enfermero.getNombre());
        	stmt.setString(2, enfermero.getArea());
        	stmt.setString(3, enfermero.getTurno());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar enfermero: " + e.getMessage());
            return false;
        }
    }

    public void listar() {
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("Id") + ", Nombre: " + rs.getString("Nombre") +
                        ", Área: " + rs.getString("Area") +
                        ", Turno: " + rs.getString("Turno"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar enfermeros: " + e.getMessage());
        }
    }
}