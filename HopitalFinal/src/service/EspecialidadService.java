package service;

import dao.EspecialidadDAO;
import model.Especialidad;

public class EspecialidadService implements IService<Especialidad> {
    private EspecialidadDAO especialidadDAO = new EspecialidadDAO();

    @Override
    public boolean registrar(Especialidad especialidad) {
        return especialidadDAO.registrar(especialidad);
    }

    @Override
    public void listar() {
        especialidadDAO.listar();
    }
}