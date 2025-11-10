package ui;

import model.PersonalCirugia;
import service.PersonalCirugiaService;
import javax.swing.JOptionPane;

public class PersonalCirugiaUI {
    private PersonalCirugiaService personalService = new PersonalCirugiaService();

    public void registrarPersonalCirugia() {
        String nombre = JOptionPane.showInputDialog("Nombre del personal:");
        if (nombre == null) return;

        String id = JOptionPane.showInputDialog("ID del personal:");
        if (id == null) return;

        String rol = JOptionPane.showInputDialog("Rol:");
        if (rol == null) return;

        PersonalCirugia personal = new PersonalCirugia(nombre, id, rol);

        if (personalService.registrar(personal)) {
            JOptionPane.showMessageDialog(null, "Personal de cirugía registrado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar personal de cirugía.");
        }
    }

    public void listarPersonalCirugia() {
        personalService.listar();
        JOptionPane.showMessageDialog(null, "Personal de cirugía listado en consola.");
    }
}