package dao;

import model.Laboratorio;
import util.ConexionBD;
import java.sql.*;

public class LaboratorioDAO {
    private static final String INSERT = "INSERT INTO Laboratorios (Nombre, Direccion) VALUES (?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM Laboratorios";
    private static final String UPDATE = "UPDATE Laboratorios SET Nombre = ?, Direccion = ? WHERE Id = ?";
    private static final String DELETE = "DELETE FROM Laboratorios WHERE Id = ?";
    private static final String SELECT_BY_ID = "SELECT * FROM Laboratorios WHERE Id = ?";

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

    public Laboratorio obtenerPorId(int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Laboratorio(rs.getInt("Id"), rs.getString("Nombre"), rs.getString("Direccion"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener laboratorio por ID: " + e.getMessage());
        }
        return null;
    }

    public boolean actualizar(Laboratorio laboratorio, int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(UPDATE)) {
            stmt.setString(1, laboratorio.getNombre());
            stmt.setString(2, laboratorio.getDireccion());
            stmt.setInt(3, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar laboratorio: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(DELETE)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar laboratorio: " + e.getMessage());
            return false;
        }
    }
}