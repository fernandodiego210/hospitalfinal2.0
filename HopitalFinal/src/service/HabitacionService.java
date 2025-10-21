package service;

import dao.HabitacionDAO;
import model.Habitacion;

public class HabitacionService {
    private HabitacionDAO habitacionDAO = new HabitacionDAO();

    public boolean registrarHabitacion(Habitacion habitacion) {
        return habitacionDAO.registrar(habitacion);
    }

    public void listarHabitaciones() {
        habitacionDAO.listar();
    }
}