package com.example.hospital.Controller;

import com.example.hospital.Api.ApiResponse;
import com.example.hospital.Model.Admission;
import com.example.hospital.Model.Clinic;
import com.example.hospital.Service.ClinicService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hospital/clinic")
@RequiredArgsConstructor

public class ClinicController {
    private final ClinicService clinicService;
    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(clinicService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity addClinic(@RequestBody @Valid Clinic clinic){
        clinicService.addClinic(clinic);
        return ResponseEntity.status(200).body(new ApiResponse("Clinic added"));
    }
    @PutMapping("/udate/{id}")
    public ResponseEntity updateClinic(@PathVariable Integer id,@RequestBody Clinic clinic){
        clinicService.updateClinic(id,clinic);
        return ResponseEntity.status(200).body(new ApiResponse("clinic updated"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteClinic(@PathVariable Integer id){
        clinicService.deleteClinic(id);
        return ResponseEntity.status(200).body(new ApiResponse("clinic deleted"));
    }
    @GetMapping("/search-by-id/{id}")
    public ResponseEntity findClinicById(@PathVariable Integer id){

        return ResponseEntity.status(200).body(clinicService.findClinicById(id));
    }
    @GetMapping("/search-by-name/{name}")
    public ResponseEntity findClinicByName(@PathVariable String name){
        List<Clinic> clinics= clinicService.findClinicByName(name);
        return ResponseEntity.status(200).body(clinics);
    }
    @GetMapping("/search-by-patient-name/{PatientName}")
    public ResponseEntity findClinicByPatientName(@PathVariable String PatientName){

        return ResponseEntity.status(200).body(clinicService.findClinicByPatientName(PatientName));
    }
    @GetMapping("/search-by-doctorName/{doctorName}")
    public ResponseEntity whereDoctor_name(@PathVariable String doctorName){
        List<Clinic> clinics= clinicService.whereDoctor_name(doctorName);
        return ResponseEntity.status(200).body(clinics);
    }
    @GetMapping("/search-by-price/{price}")
    public ResponseEntity findClinicByPrice(@PathVariable Integer price){

        return ResponseEntity.status(200).body(clinicService.findClinicByPrice(price));
    }





}
