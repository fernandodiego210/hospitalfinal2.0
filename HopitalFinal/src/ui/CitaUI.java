package ui;

import model.Cita;
import model.Paciente;
import model.Doctor;
import service.CitaService;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public class CitaUI {
    private CitaService citaService = new CitaService();

    public void registrarCita() {
        String idPaciente = JOptionPane.showInputDialog("ID del paciente:");
        if (idPaciente == null) return;

        String idDoctor = JOptionPane.showInputDialog("ID del doctor:");
        if (idDoctor == null) return;

        String fecha = JOptionPane.showInputDialog("Fecha y hora (YYYY-MM-DD HH:MM):");
        if (fecha == null) return;

        String motivo = JOptionPane.showInputDialog("Motivo:");
        if (motivo == null) return;

        try {
            LocalDateTime fechaCita = LocalDateTime.parse(fecha.replace(" ", "T"));
            Paciente paciente = new Paciente("Nombre", idPaciente, "Enfermedad", "Seguro");
            Doctor doctor = new Doctor("Nombre", idDoctor, "Especialidad", 0);

            Cita cita = new Cita(0, paciente, doctor, fechaCita, motivo);

            if (citaService.registrar(cita)) {
                JOptionPane.showMessageDialog(null, "Cita registrada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar cita.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato de fecha inválido.");
        }
    }

    public void listarCitas() {
        citaService.listar();
        JOptionPane.showMessageDialog(null, "Citas listadas en consola.");
    }
}