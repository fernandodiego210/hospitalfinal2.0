package service;

import dao.CitaDAO;
import model.Cita;

public class CitaService {
    private CitaDAO citaDAO = new CitaDAO();

    public boolean registrarCita(Cita cita) {
        return citaDAO.registrar(cita);
    }

    public void listarCitas() {
        citaDAO.listar();
    }
}