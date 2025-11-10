package ui;

import model.OrdenExamen;
import model.Paciente;
import model.Doctor;
import service.OrdenExamenService;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public class OrdenExamenUI {
    private OrdenExamenService ordenService = new OrdenExamenService();

    public void registrarOrdenExamen() {
        String idInput = JOptionPane.showInputDialog("ID de la orden:");
        if (idInput == null) return;

        String idPaciente = JOptionPane.showInputDialog("ID del paciente:");
        if (idPaciente == null) return;

        String idDoctor = JOptionPane.showInputDialog("ID del doctor:");
        if (idDoctor == null) return;

        String fecha = JOptionPane.showInputDialog("Fecha y hora (YYYY-MM-DD HH:MM):");
        if (fecha == null) return;

        String tipo = JOptionPane.showInputDialog("Tipo de examen:");
        if (tipo == null) return;

        String resultado = JOptionPane.showInputDialog("Resultado:");
        if (resultado == null) return;

        try {
            int id = Integer.parseInt(idInput);
            LocalDateTime fechaOrden = LocalDateTime.parse(fecha.replace(" ", "T"));
            Paciente paciente = new Paciente("Nombre", idPaciente, "Enfermedad", "Seguro");
            Doctor doctor = new Doctor("Nombre", idDoctor, "Especialidad", 0);

            OrdenExamen orden = new OrdenExamen(id, paciente, doctor, fechaOrden, tipo, resultado);

            if (ordenService.registrar(orden)) {
                JOptionPane.showMessageDialog(null, "Orden de examen registrada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar orden de examen.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato de fecha inválido.");
        }
    }

    public void listarOrdenesExamen() {
        ordenService.listar();
        JOptionPane.showMessageDialog(null, "Órdenes de examen listadas en consola.");
    }
}