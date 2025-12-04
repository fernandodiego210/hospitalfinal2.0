package service;

import dao.PersonalCirugiaDAO;
import model.PersonalCirugia;

public class PersonalCirugiaService implements IService<PersonalCirugia> {
    private PersonalCirugiaDAO personalDAO = new PersonalCirugiaDAO();

    @Override
    public boolean registrar(PersonalCirugia personal) {
        return personalDAO.registrar(personal);
    }

    @Override
    public void listar() {
        personalDAO.listar();
    }

    public PersonalCirugia obtenerPorId(String id) {
        return personalDAO.obtenerPorId(id);
    }

    public boolean actualizar(PersonalCirugia personal, String id) {
        return personalDAO.actualizar(personal, id);
    }

    public boolean eliminar(String id) {
        return personalDAO.eliminar(id);
    }
}