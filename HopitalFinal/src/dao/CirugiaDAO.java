package dao;

import model.Cirugia;
import model.Paciente;
import model.Doctor;
import util.ConexionBD;
import java.sql.*;

public class CirugiaDAO {
    private static final String INSERT = "INSERT INTO Cirugias (Id, PacienteId, DoctorId, Fecha, Tipo, Resultado) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM Cirugias";
    private static final String UPDATE = "UPDATE Cirugias SET PacienteId = ?, DoctorId = ?, Fecha = ?, Tipo = ?, Resultado = ? WHERE Id = ?";
    private static final String DELETE = "DELETE FROM Cirugias WHERE Id = ?";
    private static final String SELECT_BY_ID = "SELECT * FROM Cirugias WHERE Id = ?";

    public boolean registrar(Cirugia cirugia) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(INSERT)) {
            stmt.setInt(1, cirugia.getId());
            stmt.setString(2, cirugia.getPaciente().getId());
            stmt.setString(3, cirugia.getDoctor().getId());
            stmt.setTimestamp(4, java.sql.Timestamp.valueOf(cirugia.getFecha().toString()));
            stmt.setString(5, cirugia.getTipo());
            stmt.setString(6, cirugia.getResultado());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar cirugía: " + e.getMessage());
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
                        ", Tipo: " + rs.getString("Tipo") +
                        ", Resultado: " + rs.getString("Resultado"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar cirugías: " + e.getMessage());
        }
    }

    public Cirugia obtenerPorId(int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Cirugia(
                    rs.getInt("Id"),
                    new Paciente("", rs.getString("PacienteId"), "", ""),
                    new Doctor("", rs.getString("DoctorId"), "", 0),
                    rs.getTimestamp("Fecha").toLocalDateTime(),
                    rs.getString("Tipo"),
                    rs.getString("Resultado")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener cirugía por ID: " + e.getMessage());
        }
        return null;
    }

    public boolean actualizar(Cirugia cirugia, int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(UPDATE)) {
            stmt.setString(1, cirugia.getPaciente().getId());
            stmt.setString(2, cirugia.getDoctor().getId());
            stmt.setTimestamp(3, java.sql.Timestamp.valueOf(cirugia.getFecha().toString()));
            stmt.setString(4, cirugia.getTipo());
            stmt.setString(5, cirugia.getResultado());
            stmt.setInt(6, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar cirugía: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(DELETE)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar cirugía: " + e.getMessage());
            return false;
        }
    }
}