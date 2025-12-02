package model;

public class TipoExamen {
    private int id;
    private String nombre;

    public TipoExamen(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }

    public void mostrarInfo() {
        System.out.println("Tipo Examen ID: " + id + ", Nombre: " + nombre);
    }
}
