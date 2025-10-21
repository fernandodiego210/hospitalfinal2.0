package service;

import dao.EspecialidadDAO;
import model.Especialidad;

public class EspecialidadService {
    private EspecialidadDAO especialidadDAO = new EspecialidadDAO();

    public boolean registrarEspecialidad(Especialidad especialidad) {
        return especialidadDAO.registrar(especialidad);
    }

    public void listarEspecialidades() {
        especialidadDAO.listar();
    }
}
