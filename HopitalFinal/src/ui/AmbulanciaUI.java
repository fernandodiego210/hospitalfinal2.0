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
}