package model;

public class Paciente extends Persona {
    private String enfermedad;
    private String seguro;

    public Paciente(String nombre, String id, String enfermedad, String seguro) {
        super(nombre, id);
        this.enfermedad = enfermedad;
        this.seguro = seguro;
    }

    public String getEnfermedad() { return enfermedad; }
    public String getSeguro() { return seguro; }

    @Override
    public void mostrarInfo() {
        System.out.println("Paciente: " + getNombre() + ", ID: " + getId() + ", Enfermedad: " + enfermedad + ", Seguro: " + seguro);
    }
}