package dao;

import model.Departamento;
import util.ConexionBD;
import java.sql.*;

public class DepartamentoDAO {
    private static final String INSERT = "INSERT INTO Departamentos (Nombre) VALUES (?)";
    private static final String SELECT_ALL = "SELECT * FROM Departamentos";
    private static final String UPDATE = "UPDATE Departamentos SET Nombre = ? WHERE Id = ?";
    private static final String DELETE = "DELETE FROM Departamentos WHERE Id = ?";
    private static final String SELECT_BY_ID = "SELECT * FROM Departamentos WHERE Id = ?";

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

    public Departamento obtenerPorId(int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Departamento(rs.getInt("Id"), rs.getString("Nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener departamento por ID: " + e.getMessage());
        }
        return null;
    }

    public boolean actualizar(Departamento depto, int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(UPDATE)) {
            stmt.setString(1, depto.getNombre());
            stmt.setInt(2, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar departamento: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(DELETE)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar departamento: " + e.getMessage());
            return false;
        }
    }
}