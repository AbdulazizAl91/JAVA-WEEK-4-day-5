package com.example.hospital.Service;

import com.example.hospital.Api.ApiException;
import com.example.hospital.Model.Appointment;
import com.example.hospital.Model.Clinic;
import com.example.hospital.Repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public List<Appointment> getAll(){
       return appointmentRepository.findAll();
    }

    public void addAppointment(Appointment appointment){
        appointmentRepository.save(appointment);
    }
    public void updateAppointment(Integer id,Appointment appointment){
        Appointment appointment1=appointmentRepository.findAppointmentById(id);
        if (appointment1 ==null){
            throw new ApiException("appointment not founded");
        }
        appointment1.setPatient_name(appointment.getPatient_name());
        appointment1.setUsername(appointment.getUsername());
        appointment1.setPassword(appointment.getPassword());
        appointment1.setEmail(appointment.getEmail());
        appointment1.setDoctorName(appointment.getDoctorName());
        appointment1.setClinicName(appointment.getClinicName());
        appointmentRepository.save(appointment1);

    }
    public void deleteAppointment(Integer id){
        Appointment appointment = appointmentRepository.findAppointmentById(id);
        if (appointment==null){
            throw new ApiException("appointment not founded");
        }
        appointmentRepository.delete(appointment);
    }
    public Appointment findAppointmentById(Integer id){
        Appointment appointment = appointmentRepository.findAppointmentById(id);
        if (appointment==null){
            throw new ApiException("id not found");
        }
        return appointment;
    }
    public Appointment findAppointmentByUsername(String username){
        Appointment appointment = appointmentRepository.findAppointmentByUsername(username);
        if (appointment==null){
            throw new ApiException("check your username or password");
        }
        return appointment;
    }
    public List<Appointment> AppointmentListByDoctorName(String doctorName){
        List<Appointment> appointments = appointmentRepository.AppointmentListByDoctorName(doctorName);
        if (appointments==null){
            throw new ApiException("is empty");
        }
        return appointments;
    }
    public List<Appointment> findAppointmentByClinicName(String clinicName){
        List<Appointment> appointments = appointmentRepository.findAppointmentByClinicName(clinicName);
        if (appointments==null){
            throw new ApiException("is empty");
        }
        return appointments;
    }
    public Appointment findAppointmentByEmail(String email){
        Appointment appointment = appointmentRepository.findAppointmentByEmail(email);
        if (appointment==null){
            throw new ApiException("check your username or password");
        }
        return appointment;
    }




}
