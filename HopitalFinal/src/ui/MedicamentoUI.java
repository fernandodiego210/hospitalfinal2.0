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
}