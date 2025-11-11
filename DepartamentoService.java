package service;

import dao.DepartamentoDAO;
import model.Departamento;

public class DepartamentoService {
    private DepartamentoDAO deptoDAO = new DepartamentoDAO();

    public boolean registrarDepartamento(Departamento depto) {
        return deptoDAO.registrar(depto);
    }

    public void listarDepartamentos() {
        deptoDAO.listar();
    }
}