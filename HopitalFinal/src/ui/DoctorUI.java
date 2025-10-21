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

            if (doctorService.registrarDoctor(doctor)) {
                JOptionPane.showMessageDialog(null, "Doctor registrado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar doctor.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID del departamento debe ser un número.");
        }
    }

    public void listarDoctores() {
        doctorService.listarDoctores();
        JOptionPane.showMessageDialog(null, "Doctores listados en consola.");
    }
}