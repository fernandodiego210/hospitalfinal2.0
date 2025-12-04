package dao;

import model.Ambulancia;
import util.ConexionBD;
import java.sql.*;

public class AmbulanciaDAO {
    private static final String INSERT = "INSERT INTO Ambulancias (Placa, Tipo, Disponible) VALUES (?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM Ambulancias";
    private static final String UPDATE = "UPDATE Ambulancias SET Placa = ?, Tipo = ?, Disponible = ? WHERE Id = ?";
    private static final String DELETE = "DELETE FROM Ambulancias WHERE Id = ?";
    private static final String SELECT_BY_ID = "SELECT * FROM Ambulancias WHERE Id = ?";

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

    public Ambulancia obtenerPorId(int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Ambulancia(
                    rs.getString("Placa"),
                    rs.getString("Tipo"),
                    rs.getBoolean("Disponible")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener ambulancia por ID: " + e.getMessage());
        }
        return null;
    }

    public boolean actualizar(Ambulancia ambulancia, int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(UPDATE)) {
            stmt.setString(1, ambulancia.getPlaca());
            stmt.setString(2, ambulancia.getTipo());
            stmt.setBoolean(3, ambulancia.isDisponible());
            stmt.setInt(4, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar ambulancia: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(DELETE)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar ambulancia: " + e.getMessage());
            return false;
        }
    }
}