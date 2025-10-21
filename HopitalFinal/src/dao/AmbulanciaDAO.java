package dao;

import model.Ambulancia;
import util.ConexionBD;
import java.sql.*;

public class AmbulanciaDAO {
    private static final String INSERT = "INSERT INTO Ambulancias (Placa, Tipo, Disponible) VALUES (?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM Ambulancias";

    public boolean registrar(Ambulancia ambulancia) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(INSERT)) {
            stmt.setString(1, ambulancia.getPlaca());
            stmt.setString(2, ambulancia.getTipo());
            stmt.setBoolean(3, ambulancia.isDisponible());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar ambulancia: " + e.getMessage());
            return false;
        }
    }

    public void listar() {
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("Id") + ", Placa: " + rs.getString("Placa") +
                        ", Tipo: " + rs.getString("Tipo") +
                        ", Disponible: " + rs.getBoolean("Disponible"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar ambulancias: " + e.getMessage());
        }
    }
}