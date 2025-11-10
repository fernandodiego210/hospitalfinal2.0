package ui;

import model.Especialidad;
import service.EspecialidadService;
import javax.swing.JOptionPane;

public class EspecialidadUI {
    private EspecialidadService especialidadService = new EspecialidadService();

    public void registrarEspecialidad() {
        String idInput = JOptionPane.showInputDialog("ID de la especialidad:");
        if (idInput == null) return;

        String nombre = JOptionPane.showInputDialog("Nombre de la especialidad:");
        if (nombre == null) return;

        try {
            int id = Integer.parseInt(idInput);
            Especialidad especialidad = new Especialidad(id, nombre);

            if (especialidadService.registrar(especialidad)) {
                JOptionPane.showMessageDialog(null, "Especialidad registrada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar especialidad.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID debe ser un número.");
        }
    }

    public void listarEspecialidades() {
        especialidadService.listar();
        JOptionPane.showMessageDialog(null, "Especialidades listadas en consola.");
    }
}