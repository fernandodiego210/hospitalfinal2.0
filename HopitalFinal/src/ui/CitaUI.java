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

    public void modificarCita() {
        String idInput = JOptionPane.showInputDialog("ID de la cita a modificar:");
        if (idInput == null) return;
        try {
            int id = Integer.parseInt(idInput);
            Cita existente = citaService.obtenerPorId(id);
            if (existente == null) {
                JOptionPane.showMessageDialog(null, "Cita no encontrada.");
                return;
            }
            String idPaciente = JOptionPane.showInputDialog("Nuevo ID paciente:", existente.getPaciente().getId());
            if (idPaciente == null) return;
            String idDoctor = JOptionPane.showInputDialog("Nuevo ID doctor:", existente.getDoctor().getId());
            if (idDoctor == null) return;
            String fecha = JOptionPane.showInputDialog("Nueva fecha (YYYY-MM-DD HH:MM):", existente.getFecha().toString().replace("T", " "));
            if (fecha == null) return;
            String motivo = JOptionPane.showInputDialog("Nuevo motivo:", existente.getMotivo());
            if (motivo == null) return;
            LocalDateTime nuevaFecha = LocalDateTime.parse(fecha.replace(" ", "T"));
            Paciente paciente = new Paciente("Nombre", idPaciente, "Enfermedad", "Seguro");
            Doctor doctor = new Doctor("Nombre", idDoctor, "Especialidad", 0);
            Cita nueva = new Cita(id, paciente, doctor, nuevaFecha, motivo);
            if (citaService.actualizar(nueva, id)) {
                JOptionPane.showMessageDialog(null, "Cita actualizada.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar cita.");
        }
    }

    public void eliminarCita() {
        String idInput = JOptionPane.showInputDialog("ID de la cita a eliminar:");
        if (idInput == null) return;
        try {
            int id = Integer.parseInt(idInput);
            if (citaService.eliminar(id)) {
                JOptionPane.showMessageDialog(null, "Cita eliminada.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar (¿existe?).");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID debe ser un número.");
        }
    }
}