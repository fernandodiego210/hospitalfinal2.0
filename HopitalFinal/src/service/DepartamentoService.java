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

    public Departamento obtenerPorId(int id) {
        return deptoDAO.obtenerPorId(id);
    }

    public boolean actualizar(Departamento depto, int id) {
        return deptoDAO.actualizar(depto, id);
    }

    public boolean eliminar(int id) {
        return deptoDAO.eliminar(id);
    }
}