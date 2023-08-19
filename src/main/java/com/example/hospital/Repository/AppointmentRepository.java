package com.example.hospital.Repository;

import com.example.hospital.Model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
    Appointment findAppointmentById(Integer id);
    Appointment findAppointmentByUsername(String username);

    @Query("select a from Appointment a where a.doctorName=?1")
    List<Appointment>AppointmentListByDoctorName(String doctorName);

    List<Appointment> findAppointmentByClinicName(String clinicName);
    Appointment findAppointmentByEmail(String email);




}
