package dao;

import model.OrdenExamen;
import model.Paciente;
import model.Doctor;
import util.ConexionBD;
import java.sql.*;

public class OrdenExamenDAO {
    private static final String INSERT = "INSERT INTO OrdenesExamen (PacienteId, DoctorId, Fecha, TipoExamen, Resultado) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM OrdenesExamen";
    private static final String UPDATE = "UPDATE OrdenesExamen SET PacienteId = ?, DoctorId = ?, Fecha = ?, TipoExamen = ?, Resultado = ? WHERE Id = ?";
    private static final String DELETE = "DELETE FROM OrdenesExamen WHERE Id = ?";
    private static final String SELECT_BY_ID = "SELECT * FROM OrdenesExamen WHERE Id = ?";

    public boolean registrar(OrdenExamen orden) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(INSERT)) {
            stmt.setString(1, orden.getPaciente().getId());
            stmt.setString(2, orden.getDoctor().getId());
            stmt.setTimestamp(3, java.sql.Timestamp.valueOf(orden.getFecha().toString()));
            stmt.setString(4, orden.getTipoExamen());
            stmt.setString(5, orden.getResultado());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar orden de examen: " + e.getMessage());
            return false;
        }
    }

    public void listar() {
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("Id") + ", Paciente ID: " + rs.getString("PacienteId") +
                        ", Doctor ID: " + rs.getString("DoctorId") +
                        ", Fecha: " + rs.getTimestamp("Fecha") +
                        ", Tipo Examen: " + rs.getString("TipoExamen") +
                        ", Resultado: " + rs.getString("Resultado"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar órdenes de examen: " + e.getMessage());
        }
    }

    public OrdenExamen obtenerPorId(int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new OrdenExamen(
                    rs.getInt("Id"),
                    new Paciente("", rs.getString("PacienteId"), "", ""),
                    new Doctor("", rs.getString("DoctorId"), "", 0),
                    rs.getTimestamp("Fecha").toLocalDateTime(),
                    rs.getString("TipoExamen"),
                    rs.getString("Resultado")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener orden de examen por ID: " + e.getMessage());
        }
        return null;
    }

    public boolean actualizar(OrdenExamen orden, int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(UPDATE)) {
            stmt.setString(1, orden.getPaciente().getId());
            stmt.setString(2, orden.getDoctor().getId());
            stmt.setTimestamp(3, java.sql.Timestamp.valueOf(orden.getFecha().toString()));
            stmt.setString(4, orden.getTipoExamen());
            stmt.setString(5, orden.getResultado());
            stmt.setInt(6, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar orden de examen: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(DELETE)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar orden de examen: " + e.getMessage());
            return false;
        }
    }
}