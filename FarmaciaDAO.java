package dao;

import model.Farmacia;
import util.ConexionBD;
import java.sql.*;

public class FarmaciaDAO {
    private static final String INSERT = "INSERT INTO Farmacias (Nombre, Direccion) VALUES (?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM Farmacias";

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
}