package com.example.hospital.Service;

import com.example.hospital.Api.ApiException;
import com.example.hospital.Model.Admission;
import com.example.hospital.Model.Clinic;
import com.example.hospital.Repository.AdmissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdmissionService {
    private final AdmissionRepository admissionRepository;

    public List<Admission> getAll(){
        return admissionRepository.findAll();
    }
    public void addAdmission(Admission admission){
        admissionRepository.save(admission);
    }
    public void updateAdmission(Integer id,Admission admission){
        Admission admission1 = admissionRepository.findAdmissionById(id);
        if (admission1==null){
            throw new ApiException("admission not founded");
        }
        admission1.setNumberOfBedsCapacity(admission.getNumberOfBedsCapacity());
        admission1.setPatientName(admission.getPatientName());
        admission1.setPatientBedNumber(admission.getPatientBedNumber());
        admission1.setDoctorName(admission.getDoctorName());
        admissionRepository.save(admission1);

    }
    public void deleteAdmission(Integer id){
        Admission admission= admissionRepository.findAdmissionById(id);
        if (admission == null){
            throw new ApiException("admission not founded");
        }
        admissionRepository.delete(admission);
    }
    public Admission findAdmissionById(Integer id){
        Admission admission = admissionRepository.findAdmissionById(id);
        if (admission==null){
            throw new ApiException("id not found");
        }
        return admission;
    }
    public Admission findAdmissionByPatientName(String patientName){
        Admission admission = admissionRepository.findAdmissionByPatientName(patientName);
        if (admission==null){
            throw new ApiException("id not found");
        }
        return admission;
    }
    public Admission wherePatientBedNumber(Integer patientBedNumber){
        Admission admission = admissionRepository.wherePatientBedNumber(patientBedNumber);
        if (admission==null){
            throw new ApiException("id not found");
        }
        return admission;
    }
    public List<Admission> findAdmissionByDoctorName(String doctorName){
        List<Admission> admissions = admissionRepository.findAdmissionByDoctorName(doctorName);
        if (admissions==null){
            throw new ApiException("is empty");
        }
        return admissions;
    }




}
