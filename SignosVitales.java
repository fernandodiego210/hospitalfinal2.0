package model;

import java.time.LocalDateTime;

public class SignosVitales {
    private int id;
    private Paciente paciente;
    private LocalDateTime fecha;
    private double temperatura;
    private int presionArterial;
    private int frecuenciaCardiaca;

    public SignosVitales(int id, Paciente paciente, LocalDateTime fecha, double temperatura, int presionArterial, int frecuenciaCardiaca) {
        this.id = id;
        this.paciente = paciente;
        this.fecha = fecha;
        this.temperatura = temperatura;
        this.presionArterial = presionArterial;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }

    public int getId() { return id; }
    public Paciente getPaciente() { return paciente; }
    public LocalDateTime getFecha() { return fecha; }
    public double getTemperatura() { return temperatura; }
    public int getPresionArterial() { return presionArterial; }
    public int getFrecuenciaCardiaca() { return frecuenciaCardiaca; }

    public void mostrarInfo() {
        System.out.println("Signos Vitales ID: " + id + ", Paciente: " + paciente.getNombre() + ", Fecha: " + fecha + ", Temperatura: " + temperatura + ", Presión: " + presionArterial + ", FC: " + frecuenciaCardiaca);
    }
}
