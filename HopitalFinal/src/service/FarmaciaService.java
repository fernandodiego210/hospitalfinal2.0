package service;

import dao.FarmaciaDAO;
import model.Farmacia;

public class FarmaciaService {
    private FarmaciaDAO farmaciaDAO = new FarmaciaDAO();

    public boolean registrarFarmacia(Farmacia farmacia) {
        return farmaciaDAO.registrar(farmacia);
    }

    public void listarFarmacias() {
        farmaciaDAO.listar();
    }
}