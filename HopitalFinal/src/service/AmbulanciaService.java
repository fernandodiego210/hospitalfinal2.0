package service;

import dao.AmbulanciaDAO;
import model.Ambulancia;

public class AmbulanciaService implements IService<Ambulancia> {
    private AmbulanciaDAO ambulanciaDAO = new AmbulanciaDAO();

    @Override
    public boolean registrar(Ambulancia ambulancia) {
        return ambulanciaDAO.registrar(ambulancia);
    }

    @Override
    public void listar() {
        ambulanciaDAO.listar();
    }

    public Ambulancia obtenerPorId(int id) {
        return ambulanciaDAO.obtenerPorId(id);
    }

    public boolean actualizar(Ambulancia ambulancia, int id) {
        return ambulanciaDAO.actualizar(ambulancia, id);
    }

    public boolean eliminar(int id) {
        return ambulanciaDAO.eliminar(id);
    }
}