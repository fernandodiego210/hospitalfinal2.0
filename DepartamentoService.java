package service;

import dao.DepartamentoDAO;
import model.Departamento;

public class DepartamentoService implements IService<Departamento> {
    private DepartamentoDAO deptoDAO = new DepartamentoDAO();

    @Override
    public boolean registrar(Departamento depto) {
        return deptoDAO.registrar(depto);
    }

    @Override
    public void listar() {
        deptoDAO.listar();
    }
}