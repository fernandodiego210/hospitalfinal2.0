package ui;

import model.Enfermero;
import service.EnfermeroService;
import javax.swing.JOptionPane;

public class EnfermeroUI {
    private EnfermeroService enfermeroService = new EnfermeroService();

    public void registrarEnfermero() {
        String nombre = JOptionPane.showInputDialog("Nombre del enfermero:");
        if (nombre == null) return;
        String id = JOptionPane.showInputDialog("ID del enfermero:");
        if (id == null) return;
        String area = JOptionPane.showInputDialog("Área:");
        if (area == null) return;
        String turno = JOptionPane.showInputDialog("Turno (Mañana, Tarde, Noche):");
        if (turno == null) return;
        Enfermero enfermero = new Enfermero(nombre, id, area, turno);
        if (enfermeroService.registrar(enfermero)) {
            JOptionPane.showMessageDialog(null, "Enfermero registrado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar enfermero.");
        }
    }

    public void listarEnfermeros() {
        enfermeroService.listar();
        JOptionPane.showMessageDialog(null, "Enfermeros listados en consola.");
    }

    public void modificarEnfermero() {
        String id = JOptionPane.showInputDialog("ID del enfermero a modificar:");
        if (id == null) return;
        Enfermero existente = enfermeroService.obtenerPorId(id);
        if (existente == null) {
            JOptionPane.showMessageDialog(null, "Enfermero no encontrado.");
            return;
        }
        String nombre = JOptionPane.showInputDialog("Nuevo nombre:", existente.getNombre());
        if (nombre == null) return;
        String area = JOptionPane.showInputDialog("Nueva área:", existente.getArea());
        if (area == null) return;
        String turno = JOptionPane.showInputDialog("Nuevo turno:", existente.getTurno());
        if (turno == null) return;
        Enfermero nuevo = new Enfermero(nombre, id, area, turno);
        if (enfermeroService.actualizar(nuevo, id)) {
            JOptionPane.showMessageDialog(null, "Enfermero actualizado.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar.");
        }
    }

    public void eliminarEnfermero() {
        String id = JOptionPane.showInputDialog("ID del enfermero a eliminar:");
        if (id == null) return;
        if (enfermeroService.eliminar(id)) {
            JOptionPane.showMessageDialog(null, "Enfermero eliminado.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar (¿existe?).");
        }
    }
}