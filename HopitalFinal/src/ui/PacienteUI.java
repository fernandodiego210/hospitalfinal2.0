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
}