package ui;

import model.Farmacia;
import service.FarmaciaService;
import javax.swing.JOptionPane;

public class FarmaciaUI {
    private FarmaciaService farmaciaService = new FarmaciaService();

    public void registrarFarmacia() {
        String idInput = JOptionPane.showInputDialog("ID de la farmacia:");
        if (idInput == null) return;
        String nombre = JOptionPane.showInputDialog("Nombre de la farmacia:");
        if (nombre == null) return;
        String direccion = JOptionPane.showInputDialog("Dirección:");
        if (direccion == null) return;
        try {
            int id = Integer.parseInt(idInput);
            Farmacia farmacia = new Farmacia(id, nombre, direccion);
            if (farmaciaService.registrar(farmacia)) {
                JOptionPane.showMessageDialog(null, "Farmacia registrada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar farmacia.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID debe ser un número.");
        }
    }

    public void listarFarmacias() {
        farmaciaService.listar();
        JOptionPane.showMessageDialog(null, "Farmacias listadas en consola.");
    }

    public void modificarFarmacia() {
        String idInput = JOptionPane.showInputDialog("ID de la farmacia a modificar:");
        if (idInput == null) return;
        try {
            int id = Integer.parseInt(idInput);
            Farmacia existente = farmaciaService.obtenerPorId(id);
            if (existente == null) {
                JOptionPane.showMessageDialog(null, "Farmacia no encontrada.");
                return;
            }
            String nombre = JOptionPane.showInputDialog("Nuevo nombre:", existente.getNombre());
            if (nombre == null) return;
            String direccion = JOptionPane.showInputDialog("Nueva dirección:", existente.getDireccion());
            if (direccion == null) return;
            Farmacia nueva = new Farmacia(id, nombre, direccion);
            if (farmaciaService.actualizar(nueva, id)) {
                JOptionPane.showMessageDialog(null, "Farmacia actualizada.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID debe ser un número.");
        }
    }

    public void eliminarFarmacia() {
        String idInput = JOptionPane.showInputDialog("ID de la farmacia a eliminar:");
        if (idInput == null) return;
        try {
            int id = Integer.parseInt(idInput);
            if (farmaciaService.eliminar(id)) {
                JOptionPane.showMessageDialog(null, "Farmacia eliminada.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar (¿existe?).");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID debe ser un número.");
        }
    }
}