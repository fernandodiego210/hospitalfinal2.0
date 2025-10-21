package model;

public class Medicamento {
    private int id;
    private String nombre;
    private int stock;
    private double precio;

    public Medicamento(int id, String nombre, int stock, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getStock() { return stock; }
    public double getPrecio() { return precio; }

    public void mostrarInfo() {
        System.out.println("Medicamento ID: " + id + ", Nombre: " + nombre + ", Stock: " + stock + ", Precio: " + precio);
    }
}
