package dao;

import model.Laboratorio;
import util.ConexionBD;
import java.sql.*;

public class LaboratorioDAO {
    private static final String INSERT = "INSERT INTO Laboratorios (Nombre, Direccion) VALUES (?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM Laboratorios";

    public boolean registrar(Laboratorio laboratorio) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(INSERT)) {
            stmt.setString(1, laboratorio.getNombre());
            stmt.setString(2, laboratorio.getDireccion());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar laboratorio: " + e.getMessage());
            return false;
        }
    }

    public void listar() {
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("Id") + ", Nombre: " + rs.getString("Nombre") +
                        ", Dirección: " + rs.getString("Direccion"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar laboratorios: " + e.getMessage());
        }
    }
}