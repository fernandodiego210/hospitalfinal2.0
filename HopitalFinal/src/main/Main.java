package main;

import ui.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        DoctorUI doctorUI = new DoctorUI();
        PacienteUI pacienteUI = new PacienteUI();
        AmbulanciaUI ambulanciaUI = new AmbulanciaUI();
        CitaUI citaUI = new CitaUI();
        CirugiaUI cirugiaUI = new CirugiaUI();
        DepartamentoUI deptoUI = new DepartamentoUI();
        EmergenciaUI emergenciaUI = new EmergenciaUI();
        EnfermeroUI enfermeroUI = new EnfermeroUI();
        EspecialidadUI especialidadUI = new EspecialidadUI();
        FarmaciaUI farmaciaUI = new FarmaciaUI();
        HabitacionUI habitacionUI = new HabitacionUI();
        LaboratorioUI laboratorioUI = new LaboratorioUI();
        MedicamentoUI medicamentoUI = new MedicamentoUI();
        OrdenExamenUI ordenUI = new OrdenExamenUI();
        PersonalCirugiaUI personalUI = new PersonalCirugiaUI();
        SeguroMedicoUI seguroUI = new SeguroMedicoUI();
        SignosVitalesUI signosUI = new SignosVitalesUI();
        TipoExamenUI tipoUI = new TipoExamenUI();

        while (true) {
            String[] opciones = {
                "Registrar Doctor", "Registrar Paciente", "Registrar Ambulancia",
                "Registrar Cita", "Registrar Cirugía", "Registrar Departamento",
                "Registrar Emergencia", "Registrar Enfermero", "Registrar Especialidad",
                "Registrar Farmacia", "Registrar Habitación", "Registrar Laboratorio",
                "Registrar Medicamento", "Registrar Orden de Examen", "Registrar Personal de Cirugía",
                "Registrar Seguro Médico", "Registrar Signos Vitales", "Registrar Tipo de Examen",

                "Listar Doctores", "Listar Pacientes", "Listar Ambulancias",
                "Listar Citas", "Listar Cirugías", "Listar Departamentos",
                "Listar Emergencias", "Listar Enfermeros", "Listar Especialidades",
                "Listar Farmacias", "Listar Habitaciones", "Listar Laboratorios",
                "Listar Medicamentos", "Listar Órdenes de Examen", "Listar Personal de Cirugía",
                "Listar Seguros Médicos", "Listar Signos Vitales", "Listar Tipos de Examen",

                "Modificar Doctor", "Modificar Paciente", "Modificar Ambulancia",
                "Modificar Cita", "Modificar Cirugía", "Modificar Departamento",
                "Modificar Emergencia", "Modificar Enfermero", "Modificar Especialidad",
                "Modificar Farmacia", "Modificar Habitación", "Modificar Laboratorio",
                "Modificar Medicamento", "Modificar Orden de Examen", "Modificar Personal de Cirugía",
                "Modificar Seguro Médico", "Modificar Signos Vitales", "Modificar Tipo de Examen",

                "Eliminar Doctor", "Eliminar Paciente", "Eliminar Ambulancia",
                "Eliminar Cita", "Eliminar Cirugía", "Eliminar Departamento",
                "Eliminar Emergencia", "Eliminar Enfermero", "Eliminar Especialidad",
                "Eliminar Farmacia", "Eliminar Habitación", "Eliminar Laboratorio",
                "Eliminar Medicamento", "Eliminar Orden de Examen", "Eliminar Personal de Cirugía",
                "Eliminar Seguro Médico", "Eliminar Signos Vitales", "Eliminar Tipo de Examen",

                "Salir"
            };

            String seleccion = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione una opción:",
                "Gestión Hospitalaria",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
            );

            if (seleccion == null) break;

            switch (seleccion) {
                // === REGISTRAR ===
                case "Registrar Doctor": doctorUI.registrarDoctor(); break;
                case "Registrar Paciente": pacienteUI.registrarPaciente(); break;
                case "Registrar Ambulancia": ambulanciaUI.registrarAmbulancia(); break;
                case "Registrar Cita": citaUI.registrarCita(); break;
                case "Registrar Cirugía": cirugiaUI.registrarCirugia(); break;
                case "Registrar Departamento": deptoUI.registrarDepartamento(); break;
                case "Registrar Emergencia": emergenciaUI.registrarEmergencia(); break;
                case "Registrar Enfermero": enfermeroUI.registrarEnfermero(); break;
                case "Registrar Especialidad": especialidadUI.registrarEspecialidad(); break;
                case "Registrar Farmacia": farmaciaUI.registrarFarmacia(); break;
                case "Registrar Habitación": habitacionUI.registrarHabitacion(); break;
                case "Registrar Laboratorio": laboratorioUI.registrarLaboratorio(); break;
                case "Registrar Medicamento": medicamentoUI.registrarMedicamento(); break;
                case "Registrar Orden de Examen": ordenUI.registrarOrdenExamen(); break;
                case "Registrar Personal de Cirugía": personalUI.registrarPersonalCirugia(); break;
                case "Registrar Seguro Médico": seguroUI.registrarSeguroMedico(); break;
                case "Registrar Signos Vitales": signosUI.registrarSignosVitales(); break;
                case "Registrar Tipo de Examen": tipoUI.registrarTipoExamen(); break;

                // === LISTAR ===
                case "Listar Doctores": doctorUI.listarDoctores(); break;
                case "Listar Pacientes": pacienteUI.listarPacientes(); break;
                case "Listar Ambulancias": ambulanciaUI.listarAmbulancias(); break;
                case "Listar Citas": citaUI.listarCitas(); break;
                case "Listar Cirugías": cirugiaUI.listarCirugias(); break;
                case "Listar Departamentos": deptoUI.listarDepartamentos(); break;
                case "Listar Emergencias": emergenciaUI.listarEmergencias(); break;
                case "Listar Enfermeros": enfermeroUI.listarEnfermeros(); break;
                case "Listar Especialidades": especialidadUI.listarEspecialidades(); break;
                case "Listar Farmacias": farmaciaUI.listarFarmacias(); break;
                case "Listar Habitaciones": habitacionUI.listarHabitaciones(); break;
                case "Listar Laboratorios": laboratorioUI.listarLaboratorios(); break;
                case "Listar Medicamentos": medicamentoUI.listarMedicamentos(); break;
                case "Listar Órdenes de Examen": ordenUI.listarOrdenesExamen(); break;
                case "Listar Personal de Cirugía": personalUI.listarPersonalCirugia(); break;
                case "Listar Seguros Médicos": seguroUI.listarSegurosMedicos(); break;
                case "Listar Signos Vitales": signosUI.listarSignosVitales(); break;
                case "Listar Tipos de Examen": tipoUI.listarTiposExamen(); break;

                // === MODIFICAR ===
                case "Modificar Doctor": doctorUI.modificarDoctor(); break;
                case "Modificar Paciente": pacienteUI.modificarPaciente(); break;
                case "Modificar Ambulancia": ambulanciaUI.modificarAmbulancia(); break;
                case "Modificar Cita": citaUI.modificarCita(); break;
                case "Modificar Cirugía": cirugiaUI.modificarCirugia(); break;
                case "Modificar Departamento": deptoUI.modificarDepartamento(); break;
                case "Modificar Emergencia": emergenciaUI.modificarEmergencia(); break;
                case "Modificar Enfermero": enfermeroUI.modificarEnfermero(); break;
                case "Modificar Especialidad": especialidadUI.modificarEspecialidad(); break;
                case "Modificar Farmacia": farmaciaUI.modificarFarmacia(); break;
                case "Modificar Habitación": habitacionUI.modificarHabitacion(); break;
                case "Modificar Laboratorio": laboratorioUI.modificarLaboratorio(); break;
                case "Modificar Medicamento": medicamentoUI.modificarMedicamento(); break;
                case "Modificar Orden de Examen": ordenUI.modificarOrdenExamen(); break;
                case "Modificar Personal de Cirugía": personalUI.modificarPersonalCirugia(); break;
                case "Modificar Seguro Médico": seguroUI.modificarSeguroMedico(); break;
                case "Modificar Signos Vitales": signosUI.modificarSignosVitales(); break;
                case "Modificar Tipo de Examen": tipoUI.modificarTipoExamen(); break;

                // === ELIMINAR ===
                case "Eliminar Doctor": doctorUI.eliminarDoctor(); break;
                case "Eliminar Paciente": pacienteUI.eliminarPaciente(); break;
                case "Eliminar Ambulancia": ambulanciaUI.eliminarAmbulancia(); break;
                case "Eliminar Cita": citaUI.eliminarCita(); break;
                case "Eliminar Cirugía": cirugiaUI.eliminarCirugia(); break;
                case "Eliminar Departamento": deptoUI.eliminarDepartamento(); break;
                case "Eliminar Emergencia": emergenciaUI.eliminarEmergencia(); break;
                case "Eliminar Enfermero": enfermeroUI.eliminarEnfermero(); break;
                case "Eliminar Especialidad": especialidadUI.eliminarEspecialidad(); break;
                case "Eliminar Farmacia": farmaciaUI.eliminarFarmacia(); break;
                case "Eliminar Habitación": habitacionUI.eliminarHabitacion(); break;
                case "Eliminar Laboratorio": laboratorioUI.eliminarLaboratorio(); break;
                case "Eliminar Medicamento": medicamentoUI.eliminarMedicamento(); break;
                case "Eliminar Orden de Examen": ordenUI.eliminarOrdenExamen(); break;
                case "Eliminar Personal de Cirugía": personalUI.eliminarPersonalCirugia(); break;
                case "Eliminar Seguro Médico": seguroUI.eliminarSeguroMedico(); break;
                case "Eliminar Signos Vitales": signosUI.eliminarSignosVitales(); break;
                case "Eliminar Tipo de Examen": tipoUI.eliminarTipoExamen(); break;

                case "Salir":
                    int respuesta = JOptionPane.showConfirmDialog(
                        null,
                        "¿Estás seguro de que deseas salir?",
                        "Confirmar salida",
                        JOptionPane.YES_NO_OPTION
                    );
                    if (respuesta == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Saliendo...");
                        System.exit(0);
                    }
                    break;
            }
        }
    }
}