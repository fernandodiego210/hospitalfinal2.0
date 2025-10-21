package model;

public class Ambulancia {
    private String placa;
    private String tipo;
    private boolean disponible;

    public Ambulancia(String placa, String tipo, boolean disponible) {
        this.placa = placa;
        this.tipo = tipo;
        this.disponible = disponible;
    }

    public String getPlaca() { return placa; }
    public String getTipo() { return tipo; }
    public boolean isDisponible() { return disponible; }

    public void mostrarInfo() {
        System.out.println("Ambulancia: Placa=" + placa + ", Tipo=" + tipo + ", Disponible=" + disponible);
    }
}