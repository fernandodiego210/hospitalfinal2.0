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
}