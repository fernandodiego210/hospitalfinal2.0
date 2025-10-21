package ui;

import model.Departamento;
import service.DepartamentoService;
import javax.swing.JOptionPane;

public class DepartamentoUI {
    private DepartamentoService deptoService = new DepartamentoService();

    public void registrarDepartamento() {
        String idInput = JOptionPane.showInputDialog("ID del departamento:");
        if (idInput == null) return;

        String nombre = JOptionPane.showInputDialog("Nombre del departamento:");
        if (nombre == null) return;

        try {
            int id = Integer.parseInt(idInput);
            Departamento depto = new Departamento(id, nombre);

            if (deptoService.registrarDepartamento(depto)) {
                JOptionPane.showMessageDialog(null, "Departamento registrado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar departamento.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID debe ser un número.");
        }
    }

    public void listarDepartamentos() {
        deptoService.listarDepartamentos();
        JOptionPane.showMessageDialog(null, "Departamentos listados en consola.");
    }
}