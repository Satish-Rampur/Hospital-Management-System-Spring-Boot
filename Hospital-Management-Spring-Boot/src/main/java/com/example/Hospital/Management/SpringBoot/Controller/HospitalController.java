package com.example.Hospital.Management.SpringBoot.Controller;

import com.example.Hospital.Management.SpringBoot.Models.Patient;
import com.example.Hospital.Management.SpringBoot.Services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HospitalController {
    @Autowired
    HospitalService hospitalService;
    @GetMapping("/api/hospital/getpatient")
    public Patient getPatientByBedNumber(@RequestParam int bedNumber){
        return hospitalService.getPatientFromBedNumber(bedNumber);
    }
}
