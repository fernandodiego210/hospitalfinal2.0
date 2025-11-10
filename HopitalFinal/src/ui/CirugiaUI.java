package ui;

import model.Cirugia;
import model.Paciente;
import model.Doctor;
import service.CirugiaService;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public class CirugiaUI {
    private CirugiaService cirugiaService = new CirugiaService();

    public void registrarCirugia() {
        String idInput = JOptionPane.showInputDialog("ID de la cirugía:");
        if (idInput == null) return;

        String idPaciente = JOptionPane.showInputDialog("ID del paciente:");
        if (idPaciente == null) return;

        String idDoctor = JOptionPane.showInputDialog("ID del doctor:");
        if (idDoctor == null) return;

        String fecha = JOptionPane.showInputDialog("Fecha y hora (YYYY-MM-DD HH:MM):");
        if (fecha == null) return;

        String tipo = JOptionPane.showInputDialog("Tipo de cirugía:");
        if (tipo == null) return;

        String resultado = JOptionPane.showInputDialog("Resultado:");
        if (resultado == null) return;

        try {
            int id = Integer.parseInt(idInput);
            LocalDateTime fechaCirugia = LocalDateTime.parse(fecha.replace(" ", "T"));
            Paciente paciente = new Paciente("Nombre", idPaciente, "Enfermedad", "Seguro");
            Doctor doctor = new Doctor("Nombre", idDoctor, "Especialidad", 0);

            Cirugia cirugia = new Cirugia(id, paciente, doctor, fechaCirugia, tipo, resultado);

            if (cirugiaService.registrar(cirugia)) {
                JOptionPane.showMessageDialog(null, "Cirugía registrada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar cirugía.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar datos.");
        }
    }

    public void listarCirugias() {
        cirugiaService.listar();
        JOptionPane.showMessageDialog(null, "Cirugías listadas en consola.");
    }
}