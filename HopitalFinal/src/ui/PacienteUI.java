package ui;

import model.Paciente;
import service.PacienteService;
import javax.swing.JOptionPane;

public class PacienteUI {
    private PacienteService pacienteService = new PacienteService();

    public void registrarPaciente() {
        String nombre = JOptionPane.showInputDialog("Nombre del paciente:");
        if (nombre == null) return;
        String id = JOptionPane.showInputDialog("ID del paciente:");
        if (id == null) return;
        String enfermedad = JOptionPane.showInputDialog("Enfermedad:");
        if (enfermedad == null) return;
        String seguro = JOptionPane.showInputDialog("Seguro:");
        if (seguro == null) return;
        Paciente paciente = new Paciente(nombre, id, enfermedad, seguro);
        if (pacienteService.registrar(paciente)) {
            JOptionPane.showMessageDialog(null, "Paciente registrado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar paciente.");
        }
    }

    public void listarPacientes() {
        pacienteService.listar();
        JOptionPane.showMessageDialog(null, "Pacientes listados en consola.");
    }

    public void modificarPaciente() {
        String id = JOptionPane.showInputDialog("ID del paciente a modificar:");
        if (id == null) return;
        Paciente existente = pacienteService.obtenerPorId(id);
        if (existente == null) {
            JOptionPane.showMessageDialog(null, "Paciente no encontrado.");
            return;
        }
        String nombre = JOptionPane.showInputDialog("Nuevo nombre:", existente.getNombre());
        if (nombre == null) return;
        String enfermedad = JOptionPane.showInputDialog("Nueva enfermedad:", existente.getEnfermedad());
        if (enfermedad == null) return;
        String seguro = JOptionPane.showInputDialog("Nuevo seguro:", existente.getSeguro());
        if (seguro == null) return;
        Paciente nuevo = new Paciente(nombre, id, enfermedad, seguro);
        if (pacienteService.actualizar(nuevo, id)) {
            JOptionPane.showMessageDialog(null, "Paciente actualizado.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar.");
        }
    }

    public void eliminarPaciente() {
        String id = JOptionPane.showInputDialog("ID del paciente a eliminar:");
        if (id == null) return;
        if (pacienteService.eliminar(id)) {
            JOptionPane.showMessageDialog(null, "Paciente eliminado.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar (¿existe?).");
        }
    }
}