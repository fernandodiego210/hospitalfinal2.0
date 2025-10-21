package model;

import java.time.LocalDateTime;

public class OrdenExamen {
    private int id;
    private Paciente paciente;
    private Doctor doctor;
    private LocalDateTime fecha;
    private String tipoExamen;
    private String resultado;

    public OrdenExamen(int id, Paciente paciente, Doctor doctor, LocalDateTime fecha, String tipoExamen, String resultado) {
        this.id = id;
        this.paciente = paciente;
        this.doctor = doctor;
        this.fecha = fecha;
        this.tipoExamen = tipoExamen;
        this.resultado = resultado;
    }

    public int getId() { return id; }
    public Paciente getPaciente() { return paciente; }
    public Doctor getDoctor() { return doctor; }
    public LocalDateTime getFecha() { return fecha; }
    public String getTipoExamen() { return tipoExamen; }
    public String getResultado() { return resultado; }

    public void mostrarInfo() {
        System.out.println("Orden Examen ID: " + id + ", Paciente: " + paciente.getNombre() + ", Doctor: " + doctor.getNombre() + ", Fecha: " + fecha + ", Tipo: " + tipoExamen + ", Resultado: " + resultado);
    }
}
