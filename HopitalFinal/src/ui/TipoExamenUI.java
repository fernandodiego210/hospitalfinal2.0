package ui;

import model.TipoExamen;
import service.TipoExamenService;
import javax.swing.JOptionPane;

public class TipoExamenUI {
    private TipoExamenService tipoService = new TipoExamenService();

    public void registrarTipoExamen() {
        String idInput = JOptionPane.showInputDialog("ID del tipo de examen:");
        if (idInput == null) return;
        String nombre = JOptionPane.showInputDialog("Nombre del tipo de examen:");
        if (nombre == null) return;
        try {
            int id = Integer.parseInt(idInput);
            TipoExamen tipo = new TipoExamen(id, nombre);
            if (tipoService.registrar(tipo)) {
                JOptionPane.showMessageDialog(null, "Tipo de examen registrado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar tipo de examen.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID debe ser un número.");
        }
    }

    public void listarTiposExamen() {
        tipoService.listar();
        JOptionPane.showMessageDialog(null, "Tipos de examen listados en consola.");
    }

    public void modificarTipoExamen() {
        String idInput = JOptionPane.showInputDialog("ID del tipo de examen a modificar:");
        if (idInput == null) return;
        try {
            int id = Integer.parseInt(idInput);
            TipoExamen existente = tipoService.obtenerPorId(id);
            if (existente == null) {
                JOptionPane.showMessageDialog(null, "Tipo de examen no encontrado.");
                return;
            }
            String nombre = JOptionPane.showInputDialog("Nuevo nombre:", existente.getNombre());
            if (nombre == null) return;
            TipoExamen nuevo = new TipoExamen(id, nombre);
            if (tipoService.actualizar(nuevo, id)) {
                JOptionPane.showMessageDialog(null, "Tipo de examen actualizado.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID debe ser un número.");
        }
    }

    public void eliminarTipoExamen() {
        String idInput = JOptionPane.showInputDialog("ID del tipo de examen a eliminar:");
        if (idInput == null) return;
        try {
            int id = Integer.parseInt(idInput);
            if (tipoService.eliminar(id)) {
                JOptionPane.showMessageDialog(null, "Tipo de examen eliminado.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar (¿existe?).");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID debe ser un número.");
        }
    }
}