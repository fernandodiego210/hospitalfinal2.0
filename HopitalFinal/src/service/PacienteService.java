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

    public Paciente obtenerPorId(String id) {
        return pacienteDAO.obtenerPorId(id);
    }

    public boolean actualizar(Paciente paciente, String id) {
        return pacienteDAO.actualizar(paciente, id);
    }

    public boolean eliminar(String id) {
        return pacienteDAO.eliminar(id);
    }
}