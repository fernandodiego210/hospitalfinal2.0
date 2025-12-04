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

    public void modificarPersonalCirugia() {
        String id = JOptionPane.showInputDialog("ID del personal a modificar:");
        if (id == null) return;
        PersonalCirugia existente = personalService.obtenerPorId(id);
        if (existente == null) {
            JOptionPane.showMessageDialog(null, "Personal no encontrado.");
            return;
        }
        String nombre = JOptionPane.showInputDialog("Nuevo nombre:", existente.getNombre());
        if (nombre == null) return;
        String rol = JOptionPane.showInputDialog("Nuevo rol:", existente.getRol());
        if (rol == null) return;
        PersonalCirugia nuevo = new PersonalCirugia(nombre, id, rol);
        if (personalService.actualizar(nuevo, id)) {
            JOptionPane.showMessageDialog(null, "Personal de cirugía actualizado.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar.");
        }
    }

    public void eliminarPersonalCirugia() {
        String id = JOptionPane.showInputDialog("ID del personal a eliminar:");
        if (id == null) return;
        if (personalService.eliminar(id)) {
            JOptionPane.showMessageDialog(null, "Personal de cirugía eliminado.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar (¿existe?).");
        }
    }
}