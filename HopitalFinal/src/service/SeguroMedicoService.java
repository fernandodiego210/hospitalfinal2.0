package service;

import dao.SeguroMedicoDAO;
import model.SeguroMedico;

public class SeguroMedicoService implements IService<SeguroMedico> {
    private SeguroMedicoDAO seguroDAO = new SeguroMedicoDAO();

    @Override
    public boolean registrar(SeguroMedico seguro) {
        return seguroDAO.registrar(seguro);
    }

    @Override
    public void listar() {
        seguroDAO.listar();
    }
}