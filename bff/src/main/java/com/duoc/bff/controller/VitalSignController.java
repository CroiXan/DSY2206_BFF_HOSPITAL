package com.duoc.bff.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.bff.client.VitalSignClient;
import com.duoc.bff.models.VitalSign;

@RestController
@RequestMapping("/api/vitalsign")
@CrossOrigin
public class VitalSignController {

    private final VitalSignClient vitalSignClient;

    public VitalSignController(VitalSignClient vitalSignClient){
        this.vitalSignClient = vitalSignClient;
    }

    @GetMapping
    public ResponseEntity<List<VitalSign>> getAllVitalSigns() {
        return vitalSignClient.getAllVitalSigns();
    }
    
    @PostMapping
    public ResponseEntity<Object> createVitalSign(@RequestBody VitalSign vitalSign) {
        return vitalSignClient.createVitalSign(vitalSign);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<VitalSign> getVitalSignById(@PathVariable int id) {
        return vitalSignClient.getVitalSignById(id);
    }

    @GetMapping("/last/patient/{id}")
    public ResponseEntity<VitalSign> getLastVitalSignByPatient(@PathVariable int id) {
        return vitalSignClient.getLastVitalSignByPatient(id);
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<List<VitalSign>> getVitalSignByPatient(@PathVariable int id) {
        return vitalSignClient.getVitalSignByPatient(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VitalSign> updateVitalSign(@PathVariable int id, @RequestBody VitalSign updatedVitalSign ) {
        return vitalSignClient.updateVitalSign(id,updatedVitalSign);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVitalSign(@PathVariable int id){
        return vitalSignClient.deleteVitalSign(id);
    }

}
