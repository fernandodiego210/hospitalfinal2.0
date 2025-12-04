package dao;

import model.Medicamento;
import util.ConexionBD;
import java.sql.*;

public class MedicamentoDAO {
    private static final String INSERT = "INSERT INTO Medicamentos (Nombre, Stock, Precio) VALUES (?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM Medicamentos";
    private static final String UPDATE = "UPDATE Medicamentos SET Nombre = ?, Stock = ?, Precio = ? WHERE Id = ?";
    private static final String DELETE = "DELETE FROM Medicamentos WHERE Id = ?";
    private static final String SELECT_BY_ID = "SELECT * FROM Medicamentos WHERE Id = ?";

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

    public Medicamento obtenerPorId(int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Medicamento(rs.getInt("Id"), rs.getString("Nombre"), rs.getInt("Stock"), rs.getDouble("Precio"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener medicamento por ID: " + e.getMessage());
        }
        return null;
    }

    public boolean actualizar(Medicamento medicamento, int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(UPDATE)) {
            stmt.setString(1, medicamento.getNombre());
            stmt.setInt(2, medicamento.getStock());
            stmt.setDouble(3, medicamento.getPrecio());
            stmt.setInt(4, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar medicamento: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(DELETE)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar medicamento: " + e.getMessage());
            return false;
        }
    }
}