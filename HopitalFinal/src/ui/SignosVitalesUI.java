package ui;

import model.SignosVitales;
import model.Paciente;
import service.SignosVitalesService;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public class SignosVitalesUI {
    private SignosVitalesService signosService = new SignosVitalesService();

    public void registrarSignosVitales() {
        String idInput = JOptionPane.showInputDialog("ID de los signos:");
        if (idInput == null) return;
        String idPaciente = JOptionPane.showInputDialog("ID del paciente:");
        if (idPaciente == null) return;
        String fecha = JOptionPane.showInputDialog("Fecha y hora (YYYY-MM-DD HH:MM):");
        if (fecha == null) return;
        String temperaturaInput = JOptionPane.showInputDialog("Temperatura:");
        if (temperaturaInput == null) return;
        String presionInput = JOptionPane.showInputDialog("Presión arterial:");
        if (presionInput == null) return;
        String frecuenciaInput = JOptionPane.showInputDialog("Frecuencia cardíaca:");
        if (frecuenciaInput == null) return;
        try {
            int id = Integer.parseInt(idInput);
            LocalDateTime fechaSignos = LocalDateTime.parse(fecha.replace(" ", "T"));
            double temperatura = Double.parseDouble(temperaturaInput);
            int presion = Integer.parseInt(presionInput);
            int frecuencia = Integer.parseInt(frecuenciaInput);
            Paciente paciente = new Paciente("Nombre", idPaciente, "Enfermedad", "Seguro");
            SignosVitales signos = new SignosVitales(id, paciente, fechaSignos, temperatura, presion, frecuencia);
            if (signosService.registrar(signos)) {
                JOptionPane.showMessageDialog(null, "Signos vitales registrados exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar signos vitales.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar datos.");
        }
    }

    public void listarSignosVitales() {
        signosService.listar();
        JOptionPane.showMessageDialog(null, "Signos vitales listados en consola.");
    }

    public void modificarSignosVitales() {
        String idInput = JOptionPane.showInputDialog("ID de los signos a modificar:");
        if (idInput == null) return;
        try {
            int id = Integer.parseInt(idInput);
            SignosVitales existente = signosService.obtenerPorId(id);
            if (existente == null) {
                JOptionPane.showMessageDialog(null, "Signos vitales no encontrados.");
                return;
            }
            String idPaciente = JOptionPane.showInputDialog("Nuevo ID paciente:", existente.getPaciente().getId());
            if (idPaciente == null) return;
            String fecha = JOptionPane.showInputDialog("Nueva fecha (YYYY-MM-DD HH:MM):", existente.getFecha().toString().replace("T", " "));
            if (fecha == null) return;
            String temperaturaInput = JOptionPane.showInputDialog("Nueva temperatura:", String.valueOf(existente.getTemperatura()));
            if (temperaturaInput == null) return;
            String presionInput = JOptionPane.showInputDialog("Nueva presión:", String.valueOf(existente.getPresionArterial()));
            if (presionInput == null) return;
            String frecuenciaInput = JOptionPane.showInputDialog("Nueva frecuencia:", String.valueOf(existente.getFrecuenciaCardiaca()));
            if (frecuenciaInput == null) return;
            try {
                LocalDateTime nuevaFecha = LocalDateTime.parse(fecha.replace(" ", "T"));
                double temperatura = Double.parseDouble(temperaturaInput);
                int presion = Integer.parseInt(presionInput);
                int frecuencia = Integer.parseInt(frecuenciaInput);
                Paciente paciente = new Paciente("Nombre", idPaciente, "Enfermedad", "Seguro");
                SignosVitales nuevos = new SignosVitales(id, paciente, nuevaFecha, temperatura, presion, frecuencia);
                if (signosService.actualizar(nuevos, id)) {
                    JOptionPane.showMessageDialog(null, "Signos vitales actualizados.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valores numéricos inválidos.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID debe ser un número.");
        }
    }

    public void eliminarSignosVitales() {
        String idInput = JOptionPane.showInputDialog("ID de los signos a eliminar:");
        if (idInput == null) return;
        try {
            int id = Integer.parseInt(idInput);
            if (signosService.eliminar(id)) {
                JOptionPane.showMessageDialog(null, "Signos vitales eliminados.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar (¿existe?).");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID debe ser un número.");
        }
    }
}