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
}