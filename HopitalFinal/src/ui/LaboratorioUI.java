package ui;

import model.Laboratorio;
import service.LaboratorioService;
import javax.swing.JOptionPane;

public class LaboratorioUI {
    private LaboratorioService laboratorioService = new LaboratorioService();

    public void registrarLaboratorio() {
        String idInput = JOptionPane.showInputDialog("ID del laboratorio:");
        if (idInput == null) return;

        String nombre = JOptionPane.showInputDialog("Nombre del laboratorio:");
        if (nombre == null) return;

        String direccion = JOptionPane.showInputDialog("Dirección:");
        if (direccion == null) return;

        try {
            int id = Integer.parseInt(idInput);
            Laboratorio laboratorio = new Laboratorio(id, nombre, direccion);

            if (laboratorioService.registrar(laboratorio)) {
                JOptionPane.showMessageDialog(null, "Laboratorio registrado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar laboratorio.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID debe ser un número.");
        }
    }

    public void listarLaboratorios() {
        laboratorioService.listar();
        JOptionPane.showMessageDialog(null, "Laboratorios listados en consola.");
    }
}