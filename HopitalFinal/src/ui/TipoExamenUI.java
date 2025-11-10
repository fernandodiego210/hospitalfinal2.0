package ui;

import model.TipoExamen;
import service.TipoExamenService;
import javax.swing.JOptionPane;

public class TipoExamenUI {
    private TipoExamenService tipoService = new TipoExamenService();

    public void registrarTipoExamen() {
        String idInput = JOptionPane.showInputDialog("ID del tipo de examen:");
        if (idInput == null) return;

        String nombre = JOptionPane.showInputDialog("Nombre del tipo de examen:");
        if (nombre == null) return;

        try {
            int id = Integer.parseInt(idInput);
            TipoExamen tipo = new TipoExamen(id, nombre);

            if (tipoService.registrar(tipo)) {
                JOptionPane.showMessageDialog(null, "Tipo de examen registrado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar tipo de examen.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID debe ser un número.");
        }
    }

    public void listarTiposExamen() {
        tipoService.listar();
        JOptionPane.showMessageDialog(null, "Tipos de examen listados en consola.");
    }
}