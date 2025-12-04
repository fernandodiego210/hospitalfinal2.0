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

    public Especialidad obtenerPorId(int id) {
        return especialidadDAO.obtenerPorId(id);
    }

    public boolean actualizar(Especialidad especialidad, int id) {
        return especialidadDAO.actualizar(especialidad, id);
    }

    public boolean eliminar(int id) {
        return especialidadDAO.eliminar(id);
    }
}