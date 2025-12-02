package service;

import dao.DoctorDAO;
import model.Doctor;

public class DoctorService implements IService<Doctor> {
    private DoctorDAO doctorDAO = new DoctorDAO();

    @Override
    public boolean registrar(Doctor doctor) {
        return doctorDAO.registrar(doctor);
    }

    @Override
    public void listar() {
        doctorDAO.listar();
    }
}