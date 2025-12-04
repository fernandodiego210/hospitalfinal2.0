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

    public TipoExamen obtenerPorId(int id) {
        return tipoDAO.obtenerPorId(id);
    }

    public boolean actualizar(TipoExamen tipo, int id) {
        return tipoDAO.actualizar(tipo, id);
    }

    public boolean eliminar(int id) {
        return tipoDAO.eliminar(id);
    }
}