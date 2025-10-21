package model;

public class Farmacia {
    private int id;
    private String nombre;
    private String direccion;

    public Farmacia(int id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDireccion() { return direccion; }

    public void mostrarInfo() {
        System.out.println("Farmacia ID: " + id + ", Nombre: " + nombre + ", Dirección: " + direccion);
    }
}