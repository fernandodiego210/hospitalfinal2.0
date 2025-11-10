package service;

import dao.FarmaciaDAO;
import model.Farmacia;

public class FarmaciaService implements IService<Farmacia> {
    private FarmaciaDAO farmaciaDAO = new FarmaciaDAO();

    @Override
    public boolean registrar(Farmacia farmacia) {
        return farmaciaDAO.registrar(farmacia);
    }

    @Override
    public void listar() {
        farmaciaDAO.listar();
    }
}