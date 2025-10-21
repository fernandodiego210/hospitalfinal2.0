package ui;

import model.Emergencia;
import model.Paciente;
import model.Doctor;
import service.EmergenciaService;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public class EmergenciaUI {
    private EmergenciaService emergenciaService = new EmergenciaService();

    public void registrarEmergencia() {
        String idPaciente = JOptionPane.showInputDialog("ID del paciente:");
        if (idPaciente == null) return;

        String idDoctor = JOptionPane.showInputDialog("ID del doctor:");
        if (idDoctor == null) return;

        String fecha = JOptionPane.showInputDialog("Fecha y hora (YYYY-MM-DD HH:MM):");
        if (fecha == null) return;

        String descripcion = JOptionPane.showInputDialog("Descripción:");
        if (descripcion == null) return;

        String prioridad = JOptionPane.showInputDialog("Prioridad (Alta, Media, Baja):");
        if (prioridad == null) return;

        try {
            LocalDateTime fechaEmergencia = LocalDateTime.parse(fecha.replace(" ", "T"));
            Paciente paciente = new Paciente("Nombre", idPaciente, "Enfermedad", "Seguro");
            Doctor doctor = new Doctor("Nombre", idDoctor, "Especialidad", 0);

            Emergencia emergencia = new Emergencia(0, paciente, doctor, fechaEmergencia, descripcion, prioridad);

            if (emergenciaService.registrarEmergencia(emergencia)) {
                JOptionPane.showMessageDialog(null, "Emergencia registrada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar emergencia.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato de fecha inválido.");
        }
    }

    public void listarEmergencias() {
        emergenciaService.listarEmergencias();
        JOptionPane.showMessageDialog(null, "Emergencias listadas en consola.");
    }
}