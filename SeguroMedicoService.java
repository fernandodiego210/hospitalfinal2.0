package service;

import dao.SeguroMedicoDAO;
import model.SeguroMedico;

public class SeguroMedicoService {
    private SeguroMedicoDAO seguroDAO = new SeguroMedicoDAO();

    public boolean registrarSeguroMedico(SeguroMedico seguro) {
        return seguroDAO.registrar(seguro);
    }

    public void listarSegurosMedicos() {
        seguroDAO.listar();
    }
}
