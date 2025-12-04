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

    public Farmacia obtenerPorId(int id) {
        return farmaciaDAO.obtenerPorId(id);
    }

    public boolean actualizar(Farmacia farmacia, int id) {
        return farmaciaDAO.actualizar(farmacia, id);
    }

    public boolean eliminar(int id) {
        return farmaciaDAO.eliminar(id);
    }
}