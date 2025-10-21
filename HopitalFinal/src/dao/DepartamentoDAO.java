package dao;

import model.Departamento;
import util.ConexionBD;
import java.sql.*;

public class DepartamentoDAO {
    private static final String INSERT = "INSERT INTO Departamentos (Nombre) VALUES (?)";
    private static final String SELECT_ALL = "SELECT * FROM Departamentos";

    public boolean registrar(Departamento depto) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(INSERT)) {
            stmt.setString(1, depto.getNombre());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar departamento: " + e.getMessage());
            return false;
        }
    }

    public void listar() {
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("Id") + ", Nombre: " + rs.getString("Nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar departamentos: " + e.getMessage());
        }
    }
}