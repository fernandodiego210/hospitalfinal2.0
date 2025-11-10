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
}