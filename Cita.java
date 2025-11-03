package model;

import java.time.LocalDateTime;

public class Cita {
    private int id;
    private Paciente paciente;
    private Doctor doctor;
    private LocalDateTime fecha;
    private String motivo;

    public Cita(int id, Paciente paciente, Doctor doctor, LocalDateTime fecha, String motivo) {
        this.id = id;
        this.paciente = paciente;
        this.doctor = doctor;
        this.fecha = fecha;
        this.motivo = motivo;
    }

    public int getId() { return id; }
    public Paciente getPaciente() { return paciente; }
    public Doctor getDoctor() { return doctor; }
    public LocalDateTime getFecha() { return fecha; }
    public String getMotivo() { return motivo; }

    public void mostrarInfo() {
        System.out.println("Cita ID: " + id + ", Paciente: " + paciente.getNombre() + ", Doctor: " + doctor.getNombre() + ", Fecha: " + fecha + ", Motivo: " + motivo);
    }
}