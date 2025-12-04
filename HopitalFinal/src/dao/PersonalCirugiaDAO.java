package dao;

import model.PersonalCirugia;
import util.ConexionBD;
import java.sql.*;

public class PersonalCirugiaDAO {
    private static final String INSERT = "INSERT INTO PersonalCirugia (Nombre, Rol) VALUES (?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM PersonalCirugia";
    private static final String UPDATE = "UPDATE PersonalCirugia SET Nombre = ?, Rol = ? WHERE Id = ?";
    private static final String DELETE = "DELETE FROM PersonalCirugia WHERE Id = ?";
    private static final String SELECT_BY_ID = "SELECT * FROM PersonalCirugia WHERE Id = ?";

    public boolean registrar(PersonalCirugia personal) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(INSERT)) {
            stmt.setString(1, personal.getNombre());
            stmt.setString(2, personal.getRol());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar personal de cirugía: " + e.getMessage());
            return false;
        }
    }

    public void listar() {
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("Id") + ", Nombre: " + rs.getString("Nombre") +
                        ", Rol: " + rs.getString("Rol"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar personal de cirugía: " + e.getMessage());
        }
    }

    public PersonalCirugia obtenerPorId(String id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new PersonalCirugia(
                    rs.getString("Nombre"),
                    rs.getString("Id"),
                    rs.getString("Rol")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener personal de cirugía por ID: " + e.getMessage());
        }
        return null;
    }

    public boolean actualizar(PersonalCirugia personal, String id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(UPDATE)) {
            stmt.setString(1, personal.getNombre());
            stmt.setString(2, personal.getRol());
            stmt.setString(3, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar personal de cirugía: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(String id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(DELETE)) {
            stmt.setString(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar personal de cirugía: " + e.getMessage());
            return false;
        }
    }
}