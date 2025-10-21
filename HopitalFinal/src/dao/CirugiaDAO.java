package dao;

import model.Cirugia;
import model.Paciente;
import model.Doctor;
import util.ConexionBD;
import java.sql.*;

public class CirugiaDAO {
    private static final String INSERT = "INSERT INTO Cirugias (PacienteId, DoctorId, Fecha, Tipo, Resultado) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM Cirugias";

    public boolean registrar(Cirugia cirugia) {
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(INSERT)) {
        	
            stmt.setString(1, cirugia.getPaciente().getId()); 
            stmt.setString(2, cirugia.getDoctor().getId());   
            stmt.setTimestamp(3, java.sql.Timestamp.valueOf(cirugia.getFecha().toString()));
            stmt.setString(4, cirugia.getTipo());
            stmt.setString(5, cirugia.getResultado());
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
}