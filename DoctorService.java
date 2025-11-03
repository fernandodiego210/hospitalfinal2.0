package service;

import dao.DoctorDAO;
import model.Doctor;

public class DoctorService {
    private DoctorDAO doctorDAO = new DoctorDAO();

    public boolean registrarDoctor(Doctor doctor) {
        return doctorDAO.registrar(doctor);
    }

    public void listarDoctores() {
        doctorDAO.listar();
    }
}