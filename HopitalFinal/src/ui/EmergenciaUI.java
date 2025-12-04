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
            if (emergenciaService.registrar(emergencia)) {
                JOptionPane.showMessageDialog(null, "Emergencia registrada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar emergencia.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato de fecha inválido.");
        }
    }

    public void listarEmergencias() {
        emergenciaService.listar();
        JOptionPane.showMessageDialog(null, "Emergencias listadas en consola.");
    }

    public void modificarEmergencia() {
        String idInput = JOptionPane.showInputDialog("ID de la emergencia a modificar:");
        if (idInput == null) return;
        try {
            int id = Integer.parseInt(idInput);
            Emergencia existente = emergenciaService.obtenerPorId(id);
            if (existente == null) {
                JOptionPane.showMessageDialog(null, "Emergencia no encontrada.");
                return;
            }
            String idPaciente = JOptionPane.showInputDialog("Nuevo ID paciente:", existente.getPaciente().getId());
            if (idPaciente == null) return;
            String idDoctor = JOptionPane.showInputDialog("Nuevo ID doctor:", existente.getDoctor().getId());
            if (idDoctor == null) return;
            String fecha = JOptionPane.showInputDialog("Nueva fecha (YYYY-MM-DD HH:MM):", existente.getFechaIngreso().toString().replace("T", " "));
            if (fecha == null) return;
            String descripcion = JOptionPane.showInputDialog("Nueva descripción:", existente.getDescripcion());
            if (descripcion == null) return;
            String prioridad = JOptionPane.showInputDialog("Nueva prioridad:", existente.getPrioridad());
            if (prioridad == null) return;
            LocalDateTime nuevaFecha = LocalDateTime.parse(fecha.replace(" ", "T"));
            Paciente paciente = new Paciente("Nombre", idPaciente, "Enfermedad", "Seguro");
            Doctor doctor = new Doctor("Nombre", idDoctor, "Especialidad", 0);
            Emergencia nueva = new Emergencia(id, paciente, doctor, nuevaFecha, descripcion, prioridad);
            if (emergenciaService.actualizar(nueva, id)) {
                JOptionPane.showMessageDialog(null, "Emergencia actualizada.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar emergencia.");
        }
    }

    public void eliminarEmergencia() {
        String idInput = JOptionPane.showInputDialog("ID de la emergencia a eliminar:");
        if (idInput == null) return;
        try {
            int id = Integer.parseInt(idInput);
            if (emergenciaService.eliminar(id)) {
                JOptionPane.showMessageDialog(null, "Emergencia eliminada.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar (¿existe?).");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID debe ser un número.");
        }
    }
}