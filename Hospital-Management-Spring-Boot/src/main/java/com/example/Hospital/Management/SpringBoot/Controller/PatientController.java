package com.example.Hospital.Management.SpringBoot.Controller;

import com.example.Hospital.Management.SpringBoot.Models.Bill;
import com.example.Hospital.Management.SpringBoot.Models.Doctor;
import com.example.Hospital.Management.SpringBoot.Models.Patient;
import com.example.Hospital.Management.SpringBoot.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController {
    @Autowired
    PatientService patientService;

    @DeleteMapping("/api/patient/discharge")
    public Bill disChargePatient(@RequestParam String patientId, @RequestParam String dischargeDate){
        return patientService.dischargePatient(patientId, dischargeDate);
    }

    @GetMapping("/api/patient")
    public Patient getPatientByID(@RequestParam String patientID){
        return patientService.getPatientById(patientID);
    }

    @PostMapping("/api/patient/addpatient")
    public String addPatientToDatabase(@RequestBody Patient obj){
        patientService.addPatientToDatabase(obj);
        return "Patient got added successfully into database";
    }


    @GetMapping("/api/patient/getdoctor/{pID}")
    public Doctor getPatientsDoctor(@PathVariable String pID){
        // Which doctor is handeling the particular patient
        return patientService.getPatientsDoctor(pID);
    }


    // user (pID) ->
}
