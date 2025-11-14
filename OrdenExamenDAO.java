package dao;

import model.OrdenExamen;
import model.Paciente;
import model.Doctor;
import util.ConexionBD;
import java.sql.*;

public class OrdenExamenDAO {
    private static final String INSERT = "INSERT INTO OrdenesExamen (PacienteId, DoctorId, Fecha, TipoExamen, Resultado) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM OrdenesExamen";

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
                System.out.println("ID: " + rs.getInt("Id") + ", Paciente ID: " + rs.getInt("PacienteId") +
                        ", Doctor ID: " + rs.getInt("DoctorId") +
                        ", Fecha: " + rs.getTimestamp("Fecha") +
                        ", Tipo Examen: " + rs.getString("TipoExamen") +
                        ", Resultado: " + rs.getString("Resultado"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar órdenes de examen: " + e.getMessage());
        }
    }
}