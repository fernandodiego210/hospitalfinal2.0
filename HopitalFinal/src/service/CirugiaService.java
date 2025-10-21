package service;

import dao.CirugiaDAO;
import model.Cirugia;

public class CirugiaService {
    private CirugiaDAO cirugiaDAO = new CirugiaDAO();

    public boolean registrarCirugia(Cirugia cirugia) {
        return cirugiaDAO.registrar(cirugia);
    }

    public void listarCirugias() {
        cirugiaDAO.listar();
    }
}
