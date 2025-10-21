package model;

import java.time.LocalDateTime;

public class Cirugia {
    private int id;
    private Paciente paciente;
    private Doctor doctor;
    private LocalDateTime fecha;
    private String tipo;
    private String resultado;

    public Cirugia(int id, Paciente paciente, Doctor doctor, LocalDateTime fecha, String tipo, String resultado) {
        this.id = id;
        this.paciente = paciente;
        this.doctor = doctor;
        this.fecha = fecha;
        this.tipo = tipo;
        this.resultado = resultado;
    }

    public int getId() { return id; }
    public Paciente getPaciente() { return paciente; }
    public Doctor getDoctor() { return doctor; }
    public LocalDateTime getFecha() { return fecha; }
    public String getTipo() { return tipo; }
    public String getResultado() { return resultado; }

    public void mostrarInfo() {
        System.out.println("Cirugía ID: " + id + ", Paciente: " + paciente.getNombre() + ", Doctor: " + doctor.getNombre() + ", Fecha: " + fecha + ", Tipo: " + tipo + ", Resultado: " + resultado);
    }
}