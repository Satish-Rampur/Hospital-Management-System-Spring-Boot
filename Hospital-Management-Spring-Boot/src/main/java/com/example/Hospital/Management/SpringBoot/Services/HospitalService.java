package com.example.Hospital.Management.SpringBoot.Services;

import com.example.Hospital.Management.SpringBoot.Models.Patient;
import com.example.Hospital.Management.SpringBoot.Repositories.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {

    @Autowired
    HospitalRepository hosptalRepo;

    public int getFirstEmptyBedNumber(){
        Patient[] beds = hosptalRepo.getAllBeds();

        for(int i  = 0; i < beds.length; i++){
            if(beds[i] == null){
                return i; // Got First Empty Bed
            }
        }
        return -1; // No Bed is empty
    }

    public void assignPatientABed(int bedNumber, Patient obj){
        hosptalRepo.assignPatientToBedNumber(bedNumber, obj);
    }

    public Patient getPatientFromBedNumber(int bedNumber){
        return hosptalRepo.getPatientAtParticularBedNumber(bedNumber);
    }

    public void deAllocatePatientsFromBed(String pId){
        hosptalRepo.deAllocatePatientFromBed(pId);
    }

    public  int getBedFee(){
        return hosptalRepo.getBedFee();
    }
}

