package service;

import dao.MedicamentoDAO;
import model.Medicamento;

public class MedicamentoService implements IService<Medicamento> {
    private MedicamentoDAO medicamentoDAO = new MedicamentoDAO();

    @Override
    public boolean registrar(Medicamento medicamento) {
        return medicamentoDAO.registrar(medicamento);
    }

    @Override
    public void listar() {
        medicamentoDAO.listar();
    }

    public Medicamento obtenerPorId(int id) {
        return medicamentoDAO.obtenerPorId(id);
    }

    public boolean actualizar(Medicamento medicamento, int id) {
        return medicamentoDAO.actualizar(medicamento, id);
    }

    public boolean eliminar(int id) {
        return medicamentoDAO.eliminar(id);
    }
}