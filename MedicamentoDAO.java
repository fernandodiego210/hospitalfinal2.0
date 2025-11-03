package dao;

import model.Medicamento;
import util.ConexionBD;
import java.sql.*;

public class MedicamentoDAO {
    private static final String INSERT = "INSERT INTO Medicamentos (Nombre, Stock, Precio) VALUES (?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM Medicamentos";

    public boolean registrar(Medicamento medicamento) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(INSERT)) {
            stmt.setString(1, medicamento.getNombre());
            stmt.setInt(2, medicamento.getStock());
            stmt.setDouble(3, medicamento.getPrecio());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar medicamento: " + e.getMessage());
            return false;
        }
    }

    public void listar() {
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("Id") + ", Nombre: " + rs.getString("Nombre") +
                        ", Stock: " + rs.getInt("Stock") +
                        ", Precio: " + rs.getDouble("Precio"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar medicamentos: " + e.getMessage());
        }
    }
}