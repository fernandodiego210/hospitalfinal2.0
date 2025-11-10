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
}