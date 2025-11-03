package model;

public class Doctor extends Persona {
    private String especialidad;
    private int departamentoId;

    public Doctor(String nombre, String id, String especialidad, int departamentoId) {
        super(nombre, id);
        this.especialidad = especialidad;
        this.departamentoId = departamentoId;
    }

    public String getEspecialidad() { return especialidad; }
    public int getDepartamentoId() { return departamentoId; } 

    @Override
    public void mostrarInfo() {
        System.out.println("Doctor: " + getNombre() + ", ID: " + getId() + ", Especialidad: " + especialidad + ", Departamento ID: " + departamentoId);
    }
}