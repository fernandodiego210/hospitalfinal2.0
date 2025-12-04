package dao;

import model.Farmacia;
import util.ConexionBD;
import java.sql.*;

public class FarmaciaDAO {
    private static final String INSERT = "INSERT INTO Farmacias (Nombre, Direccion) VALUES (?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM Farmacias";
    private static final String UPDATE = "UPDATE Farmacias SET Nombre = ?, Direccion = ? WHERE Id = ?";
    private static final String DELETE = "DELETE FROM Farmacias WHERE Id = ?";
    private static final String SELECT_BY_ID = "SELECT * FROM Farmacias WHERE Id = ?";

    public boolean registrar(Farmacia farmacia) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(INSERT)) {
            stmt.setString(1, farmacia.getNombre());
            stmt.setString(2, farmacia.getDireccion());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar farmacia: " + e.getMessage());
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
            System.out.println("Error al listar farmacias: " + e.getMessage());
        }
    }

    public Farmacia obtenerPorId(int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Farmacia(rs.getInt("Id"), rs.getString("Nombre"), rs.getString("Direccion"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener farmacia por ID: " + e.getMessage());
        }
        return null;
    }

    public boolean actualizar(Farmacia farmacia, int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(UPDATE)) {
            stmt.setString(1, farmacia.getNombre());
            stmt.setString(2, farmacia.getDireccion());
            stmt.setInt(3, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar farmacia: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(DELETE)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar farmacia: " + e.getMessage());
            return false;
        }
    }
}