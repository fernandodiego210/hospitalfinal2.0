package service;

import dao.AmbulanciaDAO;
import model.Ambulancia;

public class AmbulanciaService {
    private AmbulanciaDAO ambulanciaDAO = new AmbulanciaDAO();

    public boolean registrarAmbulancia(Ambulancia ambulancia) {
        return ambulanciaDAO.registrar(ambulancia);
    }

    public void listarAmbulancias() {
        ambulanciaDAO.listar();
    }
}