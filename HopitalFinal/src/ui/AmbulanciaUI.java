package ui;

import model.Ambulancia;
import service.AmbulanciaService;
import javax.swing.JOptionPane;

public class AmbulanciaUI {
    private AmbulanciaService ambulanciaService = new AmbulanciaService();

    public void registrarAmbulancia() {
        String placa = JOptionPane.showInputDialog("Placa de la ambulancia:");
        if (placa == null) return;
        String tipo = JOptionPane.showInputDialog("Tipo (Básica, UCI, etc):");
        if (tipo == null) return;
        String disponibleInput = JOptionPane.showInputDialog("¿Disponible? (true/false):");
        if (disponibleInput == null) return;
        try {
            boolean disponible = Boolean.parseBoolean(disponibleInput);
            Ambulancia ambulancia = new Ambulancia(placa, tipo, disponible);
            if (ambulanciaService.registrar(ambulancia)) {
                JOptionPane.showMessageDialog(null, "Ambulancia registrada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar ambulancia.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar datos.");
        }
    }

    public void listarAmbulancias() {
        ambulanciaService.listar();
        JOptionPane.showMessageDialog(null, "Ambulancias listadas en consola.");
    }

    public void modificarAmbulancia() {
        String idInput = JOptionPane.showInputDialog("ID de la ambulancia a modificar:");
        if (idInput == null) return;
        try {
            int id = Integer.parseInt(idInput);
            Ambulancia existente = ambulanciaService.obtenerPorId(id);
            if (existente == null) {
                JOptionPane.showMessageDialog(null, "Ambulancia no encontrada.");
                return;
            }
            String placa = JOptionPane.showInputDialog("Nueva placa:", existente.getPlaca());
            if (placa == null) return;
            String tipo = JOptionPane.showInputDialog("Nuevo tipo:", existente.getTipo());
            if (tipo == null) return;
            String disp = JOptionPane.showInputDialog("¿Disponible? (true/false):", String.valueOf(existente.isDisponible()));
            if (disp == null) return;
            boolean disponible = Boolean.parseBoolean(disp);
            Ambulancia nueva = new Ambulancia(placa, tipo, disponible);
            if (ambulanciaService.actualizar(nueva, id)) {
                JOptionPane.showMessageDialog(null, "Ambulancia actualizada.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID debe ser un número.");
        }
    }

    public void eliminarAmbulancia() {
        String idInput = JOptionPane.showInputDialog("ID de la ambulancia a eliminar:");
        if (idInput == null) return;
        try {
            int id = Integer.parseInt(idInput);
            if (ambulanciaService.eliminar(id)) {
                JOptionPane.showMessageDialog(null, "Ambulancia eliminada.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar (¿existe?).");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID debe ser un número.");
        }
    }
}