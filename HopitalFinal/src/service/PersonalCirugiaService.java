package service;

import dao.PersonalCirugiaDAO;
import model.PersonalCirugia;

public class PersonalCirugiaService {
    private PersonalCirugiaDAO personalDAO = new PersonalCirugiaDAO();

    public boolean registrarPersonalCirugia(PersonalCirugia personal) {
        return personalDAO.registrar(personal);
    }

    public void listarPersonalCirugia() {
        personalDAO.listar();
    }
}