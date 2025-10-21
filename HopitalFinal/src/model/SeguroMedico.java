package model;

public class SeguroMedico {
    private int id;
    private String nombre;
    private String tipo;

    public SeguroMedico(int id, String nombre, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }

    public void mostrarInfo() {
        System.out.println("Seguro Médico ID: " + id + ", Nombre: " + nombre + ", Tipo: " + tipo);
    }
}