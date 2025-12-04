package service;

import dao.CirugiaDAO;
import model.Cirugia;

public class CirugiaService implements IService<Cirugia> {
    private CirugiaDAO cirugiaDAO = new CirugiaDAO();

    @Override
    public boolean registrar(Cirugia cirugia) {
        return cirugiaDAO.registrar(cirugia);
    }

    @Override
    public void listar() {
        cirugiaDAO.listar();
    }

    public Cirugia obtenerPorId(int id) {
        return cirugiaDAO.obtenerPorId(id);
    }

    public boolean actualizar(Cirugia cirugia, int id) {
        return cirugiaDAO.actualizar(cirugia, id);
    }

    public boolean eliminar(int id) {
        return cirugiaDAO.eliminar(id);
    }
}