package service;

import dao.TipoExamenDAO;
import model.TipoExamen;

public class TipoExamenService implements IService<TipoExamen> {
    private TipoExamenDAO tipoDAO = new TipoExamenDAO();

    @Override
    public boolean registrar(TipoExamen tipo) {
        return tipoDAO.registrar(tipo);
    }

    @Override
    public void listar() {
        tipoDAO.listar();
    }
}