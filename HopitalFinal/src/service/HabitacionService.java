package service;

import dao.HabitacionDAO;
import model.Habitacion;

public class HabitacionService implements IService<Habitacion> {
    private HabitacionDAO habitacionDAO = new HabitacionDAO();

    @Override
    public boolean registrar(Habitacion habitacion) {
        return habitacionDAO.registrar(habitacion);
    }

    @Override
    public void listar() {
        habitacionDAO.listar();
    }
}