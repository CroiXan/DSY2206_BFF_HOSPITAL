package com.duoc.bff.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.duoc.bff.config.FeignBasicAuthConfig;
import com.duoc.bff.models.Patient;

@FeignClient(name = "patient-service", url = "http://172.31.85.255:8080/api/patients", configuration = FeignBasicAuthConfig.class)
public interface PatientClient {

    @GetMapping
    ResponseEntity<Object> getAllPatients();

    @GetMapping("/{id}")
    ResponseEntity<Object> getPatientById(@PathVariable int id);

    @PostMapping
    ResponseEntity<?> postPatient(@RequestBody Patient patient);

    @PutMapping("/{id}")
    ResponseEntity<?> putPatient(@PathVariable int id, @RequestBody Patient patient);

    @DeleteMapping("/{id}")
    ResponseEntity<String> deletePatient(@PathVariable int id);

}
