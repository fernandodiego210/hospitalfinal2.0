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
}