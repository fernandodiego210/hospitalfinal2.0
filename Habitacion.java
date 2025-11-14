package model;

public class Habitacion {
    private int id;
    private String numero;
    private String tipo;
    private String estado;
    private Departamento departamento;

    public Habitacion(int id, String numero, String tipo, String estado, Departamento departamento) {
        this.id = id;
        this.numero = numero;
        this.tipo = tipo;
        this.estado = estado;
        this.departamento = departamento;
    }

    public int getId() { return id; }
    public String getNumero() { return numero; }
    public String getTipo() { return tipo; }
    public String getEstado() { return estado; }
    public Departamento getDepartamento() { return departamento; }

    public void mostrarInfo() {
        System.out.println("Habitación ID: " + id + ", Número: " + numero + ", Tipo: " + tipo + ", Estado: " + estado + ", Departamento: " + departamento.getNombre());
    }
}