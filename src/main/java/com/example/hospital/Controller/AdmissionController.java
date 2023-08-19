package com.example.hospital.Controller;

import com.example.hospital.Api.ApiResponse;
import com.example.hospital.Model.Admission;
import com.example.hospital.Repository.AdmissionRepository;
import com.example.hospital.Service.AdmissionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hospital/admission")
@RequiredArgsConstructor
public class AdmissionController {
    private final AdmissionService admissionService;
    @GetMapping("/get")
    public ResponseEntity getAll(){
       return ResponseEntity.status(200).body(admissionService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity addAdmission(Admission admission){
        admissionService.addAdmission(admission);
        return ResponseEntity.status(200).body(new ApiResponse("admission add"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateAdmission(@PathVariable Integer id, @RequestBody @Valid Admission admission){
        admissionService.updateAdmission(id,admission);
        return ResponseEntity.status(200).body(new ApiResponse("admission updated"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAdmission(@PathVariable Integer id){
        admissionService.deleteAdmission(id);
        return ResponseEntity.status(200).body(new ApiResponse("admission deleted"));
    }
    @GetMapping("/search-by-id/{id}")
    public ResponseEntity findAdmissionById(@PathVariable Integer id){

        return ResponseEntity.status(200).body(admissionService.findAdmissionById(id));
    }
    @GetMapping("/search-by-patient-name/{patientName}")
    public ResponseEntity findAdmissionByPatientName(@PathVariable String patientName){

        return ResponseEntity.status(200).body(admissionService.findAdmissionByPatientName(patientName));
    }
    @GetMapping("/search-by-doctor-name/{doctorName}")
    public ResponseEntity findAdmissionByDoctorName(@PathVariable String doctorName){
        List<Admission> admissions= admissionService.findAdmissionByDoctorName(doctorName);
        return ResponseEntity.status(200).body(admissions);
    }


}
