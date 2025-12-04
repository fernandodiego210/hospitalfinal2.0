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

    public void modificarEspecialidad() {
        String idInput = JOptionPane.showInputDialog("ID de la especialidad a modificar:");
        if (idInput == null) return;
        try {
            int id = Integer.parseInt(idInput);
            Especialidad existente = especialidadService.obtenerPorId(id);
            if (existente == null) {
                JOptionPane.showMessageDialog(null, "Especialidad no encontrada.");
                return;
            }
            String nombre = JOptionPane.showInputDialog("Nuevo nombre:", existente.getNombre());
            if (nombre == null) return;
            Especialidad nueva = new Especialidad(id, nombre);
            if (especialidadService.actualizar(nueva, id)) {
                JOptionPane.showMessageDialog(null, "Especialidad actualizada.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID debe ser un número.");
        }
    }

    public void eliminarEspecialidad() {
        String idInput = JOptionPane.showInputDialog("ID de la especialidad a eliminar:");
        if (idInput == null) return;
        try {
            int id = Integer.parseInt(idInput);
            if (especialidadService.eliminar(id)) {
                JOptionPane.showMessageDialog(null, "Especialidad eliminada.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar (¿existe?).");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID debe ser un número.");
        }
    }
}