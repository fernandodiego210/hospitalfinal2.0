package model;

public class Especialidad {
    private int id;
    private String nombre;

    public Especialidad(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }

    public void mostrarInfo() {
        System.out.println("Especialidad ID: " + id + ", Nombre: " + nombre);
    }
}