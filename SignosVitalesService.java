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
}