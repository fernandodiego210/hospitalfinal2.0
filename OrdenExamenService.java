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
}