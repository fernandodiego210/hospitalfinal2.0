package service;

import dao.EnfermeroDAO;
import model.Enfermero;

public class EnfermeroService {
    private EnfermeroDAO enfermeroDAO = new EnfermeroDAO();

    public boolean registrarEnfermero(Enfermero enfermero) {
        return enfermeroDAO.registrar(enfermero);
    }

    public void listarEnfermeros() {
        enfermeroDAO.listar();
    }
}
