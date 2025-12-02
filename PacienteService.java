package service;

import dao.PacienteDAO;
import model.Paciente;

public class PacienteService implements IService<Paciente> {
    private PacienteDAO pacienteDAO = new PacienteDAO();

    @Override
    public boolean registrar(Paciente paciente) {
        return pacienteDAO.registrar(paciente);
    }

    @Override
    public void listar() {
        pacienteDAO.listar();
    }
}