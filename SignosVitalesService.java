package service;

import dao.SignosVitalesDAO;
import model.SignosVitales;

public class SignosVitalesService {
    private SignosVitalesDAO signosDAO = new SignosVitalesDAO();

    public boolean registrarSignosVitales(SignosVitales signos) {
        return signosDAO.registrar(signos);
    }

    public void listarSignosVitales() {
        signosDAO.listar();
    }
}