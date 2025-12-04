package service;

import dao.OrdenExamenDAO;
import model.OrdenExamen;

public class OrdenExamenService implements IService<OrdenExamen> {
    private OrdenExamenDAO ordenDAO = new OrdenExamenDAO();

    @Override
    public boolean registrar(OrdenExamen orden) {
        return ordenDAO.registrar(orden);
    }

    @Override
    public void listar() {
        ordenDAO.listar();
    }

    public OrdenExamen obtenerPorId(int id) {
        return ordenDAO.obtenerPorId(id);
    }

    public boolean actualizar(OrdenExamen orden, int id) {
        return ordenDAO.actualizar(orden, id);
    }

    public boolean eliminar(int id) {
        return ordenDAO.eliminar(id);
    }
}