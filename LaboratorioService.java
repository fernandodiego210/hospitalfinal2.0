package service;

import dao.LaboratorioDAO;
import model.Laboratorio;

public class LaboratorioService {
    private LaboratorioDAO laboratorioDAO = new LaboratorioDAO();

    public boolean registrarLaboratorio(Laboratorio laboratorio) {
        return laboratorioDAO.registrar(laboratorio);
    }

    public void listarLaboratorios() {
        laboratorioDAO.listar();
    }
}
