package model;

public class Enfermero extends Persona {
    private String area;
    private String turno;

    public Enfermero(String nombre, String id, String area, String turno) {
        super(nombre, id);
        this.area = area;
        this.turno = turno;
    }

    public String getArea() { return area; }
    public String getTurno() { return turno; }

    @Override
    public void mostrarInfo() {
        System.out.println("Enfermero: " + getNombre() + ", ID: " + getId() + ", Área: " + area + ", Turno: " + turno);
    }
}