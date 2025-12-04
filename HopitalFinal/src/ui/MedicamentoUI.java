package ui;

import model.Medicamento;
import service.MedicamentoService;
import javax.swing.JOptionPane;

public class MedicamentoUI {
    private MedicamentoService medicamentoService = new MedicamentoService();

    public void registrarMedicamento() {
        String idInput = JOptionPane.showInputDialog("ID del medicamento:");
        if (idInput == null) return;
        String nombre = JOptionPane.showInputDialog("Nombre del medicamento:");
        if (nombre == null) return;
        String stockInput = JOptionPane.showInputDialog("Stock:");
        if (stockInput == null) return;
        String precioInput = JOptionPane.showInputDialog("Precio:");
        if (precioInput == null) return;
        try {
            int id = Integer.parseInt(idInput);
            int stock = Integer.parseInt(stockInput);
            double precio = Double.parseDouble(precioInput);
            Medicamento medicamento = new Medicamento(id, nombre, stock, precio);
            if (medicamentoService.registrar(medicamento)) {
                JOptionPane.showMessageDialog(null, "Medicamento registrado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar medicamento.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Stock y precio deben ser números.");
        }
    }

    public void listarMedicamentos() {
        medicamentoService.listar();
        JOptionPane.showMessageDialog(null, "Medicamentos listados en consola.");
    }

    public void modificarMedicamento() {
        String idInput = JOptionPane.showInputDialog("ID del medicamento a modificar:");
        if (idInput == null) return;
        try {
            int id = Integer.parseInt(idInput);
            Medicamento existente = medicamentoService.obtenerPorId(id);
            if (existente == null) {
                JOptionPane.showMessageDialog(null, "Medicamento no encontrado.");
                return;
            }
            String nombre = JOptionPane.showInputDialog("Nuevo nombre:", existente.getNombre());
            if (nombre == null) return;
            String stockInput = JOptionPane.showInputDialog("Nuevo stock:", String.valueOf(existente.getStock()));
            if (stockInput == null) return;
            String precioInput = JOptionPane.showInputDialog("Nuevo precio:", String.valueOf(existente.getPrecio()));
            if (precioInput == null) return;
            try {
                int stock = Integer.parseInt(stockInput);
                double precio = Double.parseDouble(precioInput);
                Medicamento nuevo = new Medicamento(id, nombre, stock, precio);
                if (medicamentoService.actualizar(nuevo, id)) {
                    JOptionPane.showMessageDialog(null, "Medicamento actualizado.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Stock y precio deben ser números.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID debe ser un número.");
        }
    }

    public void eliminarMedicamento() {
        String idInput = JOptionPane.showInputDialog("ID del medicamento a eliminar:");
        if (idInput == null) return;
        try {
            int id = Integer.parseInt(idInput);
            if (medicamentoService.eliminar(id)) {
                JOptionPane.showMessageDialog(null, "Medicamento eliminado.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar (¿existe?).");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID debe ser un número.");
        }
    }
}