package service;

import dao.OrdenExamenDAO;
import model.OrdenExamen;

public class OrdenExamenService {
    private OrdenExamenDAO ordenDAO = new OrdenExamenDAO();

    public boolean registrarOrdenExamen(OrdenExamen orden) {
        return ordenDAO.registrar(orden);
    }

    public void listarOrdenesExamen() {
        ordenDAO.listar();
    }
}