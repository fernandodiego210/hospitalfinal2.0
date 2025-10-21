package service;

import dao.EmergenciaDAO;
import model.Emergencia;

public class EmergenciaService {
    private EmergenciaDAO emergenciaDAO = new EmergenciaDAO();

    public boolean registrarEmergencia(Emergencia emergencia) {
        return emergenciaDAO.registrar(emergencia);
    }

    public void listarEmergencias() {
        emergenciaDAO.listar();
    }
}