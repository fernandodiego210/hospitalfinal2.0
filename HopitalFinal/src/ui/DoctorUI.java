package ui;

import model.Doctor;
import service.DoctorService;
import javax.swing.JOptionPane;

public class DoctorUI {
    private DoctorService doctorService = new DoctorService();

    public void registrarDoctor() {
        String nombre = JOptionPane.showInputDialog("Nombre del doctor:");
        if (nombre == null) return;
        String id = JOptionPane.showInputDialog("ID del doctor:");
        if (id == null) return;
        String especialidad = JOptionPane.showInputDialog("Especialidad:");
        if (especialidad == null) return;
        String deptoInput = JOptionPane.showInputDialog("ID del departamento:");
        if (deptoInput == null) return;
        try {
            int deptoId = Integer.parseInt(deptoInput);
            Doctor doctor = new Doctor(nombre, id, especialidad, deptoId);
            if (doctorService.registrar(doctor)) {
                JOptionPane.showMessageDialog(null, "Doctor registrado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar doctor.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID del departamento debe ser un número.");
        }
    }

    public void listarDoctores() {
        doctorService.listar();
        JOptionPane.showMessageDialog(null, "Doctores listados en consola.");
    }

    public void modificarDoctor() {
        String id = JOptionPane.showInputDialog("ID del doctor a modificar:");
        if (id == null) return;
        Doctor existente = doctorService.obtenerPorId(id);
        if (existente == null) {
            JOptionPane.showMessageDialog(null, "Doctor no encontrado.");
            return;
        }
        String nombre = JOptionPane.showInputDialog("Nuevo nombre:", existente.getNombre());
        if (nombre == null) return;
        String especialidad = JOptionPane.showInputDialog("Nueva especialidad:", existente.getEspecialidad());
        if (especialidad == null) return;
        String deptoInput = JOptionPane.showInputDialog("Nuevo ID departamento:", String.valueOf(existente.getDepartamentoId()));
        if (deptoInput == null) return;
        try {
            int deptoId = Integer.parseInt(deptoInput);
            Doctor nuevo = new Doctor(nombre, id, especialidad, deptoId);
            if (doctorService.actualizar(nuevo, id)) {
                JOptionPane.showMessageDialog(null, "Doctor actualizado.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID del departamento debe ser un número.");
        }
    }

    public void eliminarDoctor() {
        String id = JOptionPane.showInputDialog("ID del doctor a eliminar:");
        if (id == null) return;
        if (doctorService.eliminar(id)) {
            JOptionPane.showMessageDialog(null, "Doctor eliminado.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar (¿existe?).");
        }
    }
}