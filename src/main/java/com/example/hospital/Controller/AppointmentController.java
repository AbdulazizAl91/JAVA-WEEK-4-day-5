package com.example.hospital.Controller;

import com.example.hospital.Api.ApiResponse;
import com.example.hospital.Model.Admission;
import com.example.hospital.Model.Appointment;
import com.example.hospital.Service.AppointmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hospital/appointment")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(appointmentService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity addAppointment(Appointment appointment){
        appointmentService.addAppointment(appointment);
        return ResponseEntity.status(200).body(new ApiResponse("appointment add"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateAppointment(@PathVariable Integer id, @RequestBody @Valid Appointment appointment){
        appointmentService.updateAppointment(id,appointment);
        return ResponseEntity.status(200).body(new ApiResponse("appointment updated"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAppointment(@PathVariable Integer id){
        appointmentService.deleteAppointment(id);
        return ResponseEntity.status(200).body(new ApiResponse("appointment deleted"));
    }
    @GetMapping("/search-by-id/{id}")
    public ResponseEntity findAppointmentById(@PathVariable Integer id){

        return ResponseEntity.status(200).body(appointmentService.findAppointmentById(id));
    }
    @GetMapping("/search-by-username/{username}")
    public ResponseEntity findAppointmentByUsername(@PathVariable String username){

        return ResponseEntity.status(200).body(appointmentService.findAppointmentByUsername(username));
    }
    @GetMapping("/search-by-doctor-name/{doctorName}")
    public ResponseEntity AppointmentListByDoctorName(@PathVariable String doctorName){
        List<Appointment> appointments= appointmentService.AppointmentListByDoctorName(doctorName);
        return ResponseEntity.status(200).body(appointments);
    }
    @GetMapping("/search-by-clinic-name/{clinicName}")
    public ResponseEntity findAppointmentByClinicName(@PathVariable String clinicName){
        List<Appointment> appointments= appointmentService.findAppointmentByClinicName(clinicName);
        return ResponseEntity.status(200).body(appointments);
    }
    @GetMapping("/search-by-email/{email}")
    public ResponseEntity findAppointmentByEmail(@PathVariable String email){

        return ResponseEntity.status(200).body(appointmentService.findAppointmentByEmail(email));
    }

}
