package service;

import dao.EmergenciaDAO;
import model.Emergencia;

public class EmergenciaService implements IService<Emergencia> {
    private EmergenciaDAO emergenciaDAO = new EmergenciaDAO();

    @Override
    public boolean registrar(Emergencia emergencia) {
        return emergenciaDAO.registrar(emergencia);
    }

    @Override
    public void listar() {
        emergenciaDAO.listar();
    }
}