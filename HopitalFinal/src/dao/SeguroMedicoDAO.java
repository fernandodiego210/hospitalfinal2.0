package dao;

import model.SeguroMedico;
import util.ConexionBD;
import java.sql.*;

public class SeguroMedicoDAO {
    private static final String INSERT = "INSERT INTO SegurosMedicos (Nombre, Tipo) VALUES (?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM SegurosMedicos";

    public boolean registrar(SeguroMedico seguro) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(INSERT)) {
            stmt.setString(1, seguro.getNombre());
            stmt.setString(2, seguro.getTipo());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar seguro médico: " + e.getMessage());
            return false;
        }
    }

    public void listar() {
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("Id") + ", Nombre: " + rs.getString("Nombre") +
                        ", Tipo: " + rs.getString("Tipo"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar seguros médicos: " + e.getMessage());
        }
    }
}