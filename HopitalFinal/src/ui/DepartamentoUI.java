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
            if (deptoService.registrar(depto)) {
                JOptionPane.showMessageDialog(null, "Departamento registrado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar departamento.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID debe ser un número.");
        }
    }

    public void listarDepartamentos() {
        deptoService.listar();
        JOptionPane.showMessageDialog(null, "Departamentos listados en consola.");
    }

    public void modificarDepartamento() {
        String idInput = JOptionPane.showInputDialog("ID del departamento a modificar:");
        if (idInput == null) return;
        try {
            int id = Integer.parseInt(idInput);
            Departamento existente = deptoService.obtenerPorId(id);
            if (existente == null) {
                JOptionPane.showMessageDialog(null, "Departamento no encontrado.");
                return;
            }
            String nombre = JOptionPane.showInputDialog("Nuevo nombre:", existente.getNombre());
            if (nombre == null) return;
            Departamento nuevo = new Departamento(id, nombre);
            if (deptoService.actualizar(nuevo, id)) {
                JOptionPane.showMessageDialog(null, "Departamento actualizado.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID debe ser un número.");
        }
    }

    public void eliminarDepartamento() {
        String idInput = JOptionPane.showInputDialog("ID del departamento a eliminar:");
        if (idInput == null) return;
        try {
            int id = Integer.parseInt(idInput);
            if (deptoService.eliminar(id)) {
                JOptionPane.showMessageDialog(null, "Departamento eliminado.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar (¿existe?).");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID debe ser un número.");
        }
    }
}