package ui;

import model.Enfermero;
import service.EnfermeroService;
import javax.swing.JOptionPane;

public class EnfermeroUI {
    private EnfermeroService enfermeroService = new EnfermeroService();

    public void registrarEnfermero() {
        String nombre = JOptionPane.showInputDialog("Nombre del enfermero:");
        if (nombre == null) return;

        String id = JOptionPane.showInputDialog("ID del enfermero:");
        if (id == null) return;

        String area = JOptionPane.showInputDialog("Área:");
        if (area == null) return;

        String turno = JOptionPane.showInputDialog("Turno (Mañana, Tarde, Noche):");
        if (turno == null) return;

        Enfermero enfermero = new Enfermero(nombre, id, area, turno);

        if (enfermeroService.registrarEnfermero(enfermero)) {
            JOptionPane.showMessageDialog(null, "Enfermero registrado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar enfermero.");
        }
    }

    public void listarEnfermeros() {
        enfermeroService.listarEnfermeros();
        JOptionPane.showMessageDialog(null, "Enfermeros listados en consola.");
    }
}