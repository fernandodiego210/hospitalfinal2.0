package service;

import dao.EnfermeroDAO;
import model.Enfermero;

public class EnfermeroService implements IService<Enfermero> {
    private EnfermeroDAO enfermeroDAO = new EnfermeroDAO();

    @Override
    public boolean registrar(Enfermero enfermero) {
        return enfermeroDAO.registrar(enfermero);
    }

    @Override
    public void listar() {
        enfermeroDAO.listar();
    }
}