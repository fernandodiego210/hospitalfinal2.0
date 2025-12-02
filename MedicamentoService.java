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
}