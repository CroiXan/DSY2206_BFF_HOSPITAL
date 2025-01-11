package com.duoc.bff.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.duoc.bff.client.PatientClient;
import com.duoc.bff.models.Patient;

import feign.FeignException;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin
public class PatientController {

    private final PatientClient patientClient;

    public PatientController(PatientClient patientClient){
        this.patientClient = patientClient;
    }

    @GetMapping
    public ResponseEntity<Object> getAllPatients() {
        return patientClient.getAllPatients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPatientById(@PathVariable int id) {
        return patientClient.getPatientById(id);
    }

    @PostMapping
    public ResponseEntity<?> postPatient(@RequestBody Patient patient) {
        return patientClient.postPatient(patient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putPatient(@PathVariable int id, @RequestBody Patient patient) {
        return patientClient.putPatient(id,patient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable int id) {
        return patientClient.deletePatient(id);
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<String> handleFeignErrors(FeignException ex) {
        return ResponseEntity.status(ex.status()).body(ex.contentUTF8());
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<String> handleFeignErrors(ResponseStatusException ex) {
        return ResponseEntity.status(ex.getStatusCode()).body(ex.getReason());
    }

}
