package service;

import dao.PacienteDAO;
import model.Paciente;

public class PacienteService {
    private PacienteDAO pacienteDAO = new PacienteDAO();

    public boolean registrarPaciente(Paciente paciente) {
        return pacienteDAO.registrar(paciente);
    }

    public void listarPacientes() {
        pacienteDAO.listar();
    }
}