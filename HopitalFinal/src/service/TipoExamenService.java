package service;

import dao.TipoExamenDAO;
import model.TipoExamen;

public class TipoExamenService {
    private TipoExamenDAO tipoDAO = new TipoExamenDAO();

    public boolean registrarTipoExamen(TipoExamen tipo) {
        return tipoDAO.registrar(tipo);
    }

    public void listarTiposExamen() {
        tipoDAO.listar();
    }
}