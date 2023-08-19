package com.example.hospital.Service;

import com.example.hospital.Api.ApiException;
import com.example.hospital.Model.Clinic;
import com.example.hospital.Repository.ClinicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClinicService {
    private final ClinicRepository clinicRepository;
    public List<Clinic> getAll(){
        return clinicRepository.findAll();
    }
    public void addClinic(Clinic clinic){
        clinicRepository.save(clinic);
    }
    public void updateClinic(Integer id,Clinic clinic){
        Clinic clinics = clinicRepository.findClinicById(id);
        if (clinics==null){
            throw new ApiException("id not founded");
        }
        clinics.setPatientName(clinic.getPatientName());
        clinics.setClinicName(clinic.getClinicName());
        clinics.setDoctorName(clinic.getDoctorName());
        clinics.setPrice(clinic.getPrice());

    }
    public void deleteClinic(Integer id){
        Clinic clinic =clinicRepository.findClinicById(id);
        if (clinic==null){
            throw new ApiException("id not founded");
        }
        clinicRepository.delete(clinic);

    }
    public Clinic findClinicById(Integer id){
        Clinic clinic = clinicRepository.findClinicById(id);
        if (clinic==null){
            throw new ApiException("id not found");
        }
        return clinic;
    }
    public List<Clinic> findClinicByName(String clinicName){
        List<Clinic> clinic = clinicRepository.findClinicByClinicName(clinicName);
        if (clinic==null){
            throw new ApiException("is empty");
        }
        return clinic;
    }
    public Clinic findClinicByPatientName(String patientName){
        Clinic clinic = clinicRepository.findClinicByPatientName(patientName);
        if (clinic==null){
            throw new ApiException("id not found");
        }
        return clinic;
    }

    public List<Clinic> whereDoctor_name(String doctorName){
        List<Clinic> clinic = clinicRepository.whereDoctor_name(doctorName);
        if (clinic==null){
            throw new ApiException("is empty");
        }
        return clinic;
    }
    public List<Clinic> findClinicByPrice(Integer price){
        List<Clinic> clinic = clinicRepository.findClinicByPrice(price);
        if (clinic==null){
            throw new ApiException("is empty");
        }
        return clinic;
    }





}
