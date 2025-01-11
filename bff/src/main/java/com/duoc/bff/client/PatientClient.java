package com.duoc.bff.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "patient-service", url = "http://localhost:8080")
public class PatientClient {

}
