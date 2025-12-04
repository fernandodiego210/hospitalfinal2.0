package ui;

import model.Habitacion;
import model.Departamento;
import service.HabitacionService;
import javax.swing.JOptionPane;

public class HabitacionUI {
    private HabitacionService habitacionService = new HabitacionService();

    public void registrarHabitacion() {
        String idInput = JOptionPane.showInputDialog("ID de la habitación:");
        if (idInput == null) return;
        String numero = JOptionPane.showInputDialog("Número de la habitación:");
        if (numero == null) return;
        String tipo = JOptionPane.showInputDialog("Tipo (Privada, Compartida, UCI):");
        if (tipo == null) return;
        String estado = JOptionPane.showInputDialog("Estado (Disponible, Ocupada):");
        if (estado == null) return;
        String idDeptoInput = JOptionPane.showInputDialog("ID del departamento:");
        if (idDeptoInput == null) return;
        try {
            int id = Integer.parseInt(idInput);
            int idDepto = Integer.parseInt(idDeptoInput);
            Departamento depto = new Departamento(idDepto, "Nombre");
            Habitacion habitacion = new Habitacion(id, numero, tipo, estado, depto);
            if (habitacionService.registrar(habitacion)) {
                JOptionPane.showMessageDialog(null, "Habitación registrada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar habitación.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID debe ser un número.");
        }
    }

    public void listarHabitaciones() {
        habitacionService.listar();
        JOptionPane.showMessageDialog(null, "Habitaciones listadas en consola.");
    }

    public void modificarHabitacion() {
        String idInput = JOptionPane.showInputDialog("ID de la habitación a modificar:");
        if (idInput == null) return;
        try {
            int id = Integer.parseInt(idInput);
            Habitacion existente = habitacionService.obtenerPorId(id);
            if (existente == null) {
                JOptionPane.showMessageDialog(null, "Habitación no encontrada.");
                return;
            }
            String numero = JOptionPane.showInputDialog("Nuevo número:", existente.getNumero());
            if (numero == null) return;
            String tipo = JOptionPane.showInputDialog("Nuevo tipo:", existente.getTipo());
            if (tipo == null) return;
            String estado = JOptionPane.showInputDialog("Nuevo estado:", existente.getEstado());
            if (estado == null) return;
            String idDeptoInput = JOptionPane.showInputDialog("Nuevo ID departamento:", String.valueOf(existente.getDepartamento().getId()));
            if (idDeptoInput == null) return;
            try {
                int idDepto = Integer.parseInt(idDeptoInput);
                Departamento depto = new Departamento(idDepto, "Nombre");
                Habitacion nueva = new Habitacion(id, numero, tipo, estado, depto);
                if (habitacionService.actualizar(nueva, id)) {
                    JOptionPane.showMessageDialog(null, "Habitación actualizada.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ID del departamento debe ser un número.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID debe ser un número.");
        }
    }

    public void eliminarHabitacion() {
        String idInput = JOptionPane.showInputDialog("ID de la habitación a eliminar:");
        if (idInput == null) return;
        try {
            int id = Integer.parseInt(idInput);
            if (habitacionService.eliminar(id)) {
                JOptionPane.showMessageDialog(null, "Habitación eliminada.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar (¿existe?).");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID debe ser un número.");
        }
    }
}