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

    public void modificarOrdenExamen() {
        String idInput = JOptionPane.showInputDialog("ID de la orden a modificar:");
        if (idInput == null) return;
        try {
            int id = Integer.parseInt(idInput);
            OrdenExamen existente = ordenService.obtenerPorId(id);
            if (existente == null) {
                JOptionPane.showMessageDialog(null, "Orden no encontrada.");
                return;
            }
            String idPaciente = JOptionPane.showInputDialog("Nuevo ID paciente:", existente.getPaciente().getId());
            if (idPaciente == null) return;
            String idDoctor = JOptionPane.showInputDialog("Nuevo ID doctor:", existente.getDoctor().getId());
            if (idDoctor == null) return;
            String fecha = JOptionPane.showInputDialog("Nueva fecha (YYYY-MM-DD HH:MM):", existente.getFecha().toString().replace("T", " "));
            if (fecha == null) return;
            String tipo = JOptionPane.showInputDialog("Nuevo tipo:", existente.getTipoExamen());
            if (tipo == null) return;
            String resultado = JOptionPane.showInputDialog("Nuevo resultado:", existente.getResultado());
            if (resultado == null) return;
            LocalDateTime nuevaFecha = LocalDateTime.parse(fecha.replace(" ", "T"));
            Paciente paciente = new Paciente("Nombre", idPaciente, "Enfermedad", "Seguro");
            Doctor doctor = new Doctor("Nombre", idDoctor, "Especialidad", 0);
            OrdenExamen nueva = new OrdenExamen(id, paciente, doctor, nuevaFecha, tipo, resultado);
            if (ordenService.actualizar(nueva, id)) {
                JOptionPane.showMessageDialog(null, "Orden de examen actualizada.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar orden.");
        }
    }

    public void eliminarOrdenExamen() {
        String idInput = JOptionPane.showInputDialog("ID de la orden a eliminar:");
        if (idInput == null) return;
        try {
            int id = Integer.parseInt(idInput);
            if (ordenService.eliminar(id)) {
                JOptionPane.showMessageDialog(null, "Orden de examen eliminada.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar (¿existe?).");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID debe ser un número.");
        }
    }
}