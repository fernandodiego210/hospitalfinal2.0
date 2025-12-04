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

    public Habitacion obtenerPorId(int id) {
        return habitacionDAO.obtenerPorId(id);
    }

    public boolean actualizar(Habitacion habitacion, int id) {
        return habitacionDAO.actualizar(habitacion, id);
    }

    public boolean eliminar(int id) {
        return habitacionDAO.eliminar(id);
    }
}