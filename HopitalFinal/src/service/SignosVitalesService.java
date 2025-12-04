package service;

import dao.SignosVitalesDAO;
import model.SignosVitales;

public class SignosVitalesService implements IService<SignosVitales> {
    private SignosVitalesDAO signosDAO = new SignosVitalesDAO();

    @Override
    public boolean registrar(SignosVitales signos) {
        return signosDAO.registrar(signos);
    }

    @Override
    public void listar() {
        signosDAO.listar();
    }

    public SignosVitales obtenerPorId(int id) {
        return signosDAO.obtenerPorId(id);
    }

    public boolean actualizar(SignosVitales signos, int id) {
        return signosDAO.actualizar(signos, id);
    }

    public boolean eliminar(int id) {
        return signosDAO.eliminar(id);
    }
}