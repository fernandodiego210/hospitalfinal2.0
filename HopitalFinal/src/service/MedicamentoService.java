package service;

import dao.MedicamentoDAO;
import model.Medicamento;

public class MedicamentoService {
    private MedicamentoDAO medicamentoDAO = new MedicamentoDAO();

    public boolean registrarMedicamento(Medicamento medicamento) {
        return medicamentoDAO.registrar(medicamento);
    }

    public void listarMedicamentos() {
        medicamentoDAO.listar();
    }
}