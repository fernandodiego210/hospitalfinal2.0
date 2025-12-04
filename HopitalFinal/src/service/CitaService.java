package service;

import dao.CitaDAO;
import model.Cita;

public class CitaService implements IService<Cita> {
    private CitaDAO citaDAO = new CitaDAO();

    @Override
    public boolean registrar(Cita cita) {
        return citaDAO.registrar(cita);
    }

    @Override
    public void listar() {
        citaDAO.listar();
    }

    public Cita obtenerPorId(int id) {
        return citaDAO.obtenerPorId(id);
    }

    public boolean actualizar(Cita cita, int id) {
        return citaDAO.actualizar(cita, id);
    }

    public boolean eliminar(int id) {
        return citaDAO.eliminar(id);
    }
}