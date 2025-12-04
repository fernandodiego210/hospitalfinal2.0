package service;

import dao.SeguroMedicoDAO;
import model.SeguroMedico;

public class SeguroMedicoService implements IService<SeguroMedico> {
    private SeguroMedicoDAO seguroDAO = new SeguroMedicoDAO();

    @Override
    public boolean registrar(SeguroMedico seguro) {
        return seguroDAO.registrar(seguro);
    }

    @Override
    public void listar() {
        seguroDAO.listar();
    }

    public SeguroMedico obtenerPorId(int id) {
        return seguroDAO.obtenerPorId(id);
    }

    public boolean actualizar(SeguroMedico seguro, int id) {
        return seguroDAO.actualizar(seguro, id);
    }

    public boolean eliminar(int id) {
        return seguroDAO.eliminar(id);
    }
}