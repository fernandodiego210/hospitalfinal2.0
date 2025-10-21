package model;

public class Departamento {
    private int id;
    private String nombre;

    public Departamento(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }

    public void mostrarInfo() {
        System.out.println("Departamento ID: " + id + ", Nombre: " + nombre);
    }
}