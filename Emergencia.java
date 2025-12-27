package model;

import java.time.LocalDateTime;

public class Emergencia {
    private int id;
    private Paciente paciente;
    private Doctor doctor;
    private LocalDateTime fechaIngreso;
    private String descripcion;
    private String prioridad;

    public Emergencia(int id, Paciente paciente, Doctor doctor, LocalDateTime fechaIngreso, String descripcion, String prioridad) {
        this.id = id;
        this.paciente = paciente;
        this.doctor = doctor;
        this.fechaIngreso = fechaIngreso;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
    }

    public int getId() { return id; }
    public Paciente getPaciente() { return paciente; }
    public Doctor getDoctor() { return doctor; }
    public LocalDateTime getFechaIngreso() { return fechaIngreso; }
    public String getDescripcion() { return descripcion; }
    public String getPrioridad() { return prioridad; }

    public void mostrarInfo() {
        System.out.println("Emergencia ID: " + id + ", Paciente: " + paciente.getNombre() + ", Doctor: " + doctor.getNombre() + ", Fecha: " + fechaIngreso + ", Prioridad: " + prioridad);
    }
}