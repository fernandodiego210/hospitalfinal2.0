package ui;

import model.SeguroMedico;
import service.SeguroMedicoService;
import javax.swing.JOptionPane;

public class SeguroMedicoUI {
    private SeguroMedicoService seguroService = new SeguroMedicoService();

    public void registrarSeguroMedico() {
        String idInput = JOptionPane.showInputDialog("ID del seguro:");
        if (idInput == null) return;
        String nombre = JOptionPane.showInputDialog("Nombre del seguro:");
        if (nombre == null) return;
        String tipo = JOptionPane.showInputDialog("Tipo:");
        if (tipo == null) return;
        try {
            int id = Integer.parseInt(idInput);
            SeguroMedico seguro = new SeguroMedico(id, nombre, tipo);
            if (seguroService.registrar(seguro)) {
                JOptionPane.showMessageDialog(null, "Seguro médico registrado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar seguro médico.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID debe ser un número.");
        }
    }

    public void listarSegurosMedicos() {
        seguroService.listar();
        JOptionPane.showMessageDialog(null, "Seguros médicos listados en consola.");
    }

    public void modificarSeguroMedico() {
        String idInput = JOptionPane.showInputDialog("ID del seguro a modificar:");
        if (idInput == null) return;
        try {
            int id = Integer.parseInt(idInput);
            SeguroMedico existente = seguroService.obtenerPorId(id);
            if (existente == null) {
                JOptionPane.showMessageDialog(null, "Seguro no encontrado.");
                return;
            }
            String nombre = JOptionPane.showInputDialog("Nuevo nombre:", existente.getNombre());
            if (nombre == null) return;
            String tipo = JOptionPane.showInputDialog("Nuevo tipo:", existente.getTipo());
            if (tipo == null) return;
            SeguroMedico nuevo = new SeguroMedico(id, nombre, tipo);
            if (seguroService.actualizar(nuevo, id)) {
                JOptionPane.showMessageDialog(null, "Seguro médico actualizado.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID debe ser un número.");
        }
    }

    public void eliminarSeguroMedico() {
        String idInput = JOptionPane.showInputDialog("ID del seguro a eliminar:");
        if (idInput == null) return;
        try {
            int id = Integer.parseInt(idInput);
            if (seguroService.eliminar(id)) {
                JOptionPane.showMessageDialog(null, "Seguro médico eliminado.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar (¿existe?).");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID debe ser un número.");
        }
    }
}