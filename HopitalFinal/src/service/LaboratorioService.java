package service;

import dao.LaboratorioDAO;
import model.Laboratorio;

public class LaboratorioService implements IService<Laboratorio> {
    private LaboratorioDAO laboratorioDAO = new LaboratorioDAO();

    @Override
    public boolean registrar(Laboratorio laboratorio) {
        return laboratorioDAO.registrar(laboratorio);
    }

    @Override
    public void listar() {
        laboratorioDAO.listar();
    }

    public Laboratorio obtenerPorId(int id) {
        return laboratorioDAO.obtenerPorId(id);
    }

    public boolean actualizar(Laboratorio laboratorio, int id) {
        return laboratorioDAO.actualizar(laboratorio, id);
    }

    public boolean eliminar(int id) {
        return laboratorioDAO.eliminar(id);
    }
}