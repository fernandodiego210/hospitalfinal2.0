package model;

public abstract class Persona {
    protected String nombre;
    protected String id;

    public Persona(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    // ✅ Getters públicos
    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public abstract void mostrarInfo();
}