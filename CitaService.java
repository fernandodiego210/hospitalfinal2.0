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
}