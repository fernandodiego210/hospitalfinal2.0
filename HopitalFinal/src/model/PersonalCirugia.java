package model;

public class PersonalCirugia extends Persona {
    private String rol;

    public PersonalCirugia(String nombre, String id, String rol) {
        super(nombre, id);
        this.rol = rol;
    }

    public String getRol() { return rol; }

    @Override
    public void mostrarInfo() {
        System.out.println("Personal Cirugía: " + getNombre() + ", ID: " + getId() + ", Rol: " + rol);
    }
}