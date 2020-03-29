package com.mathpar.learning.secretmanager.controllers;

import com.mathpar.learning.secretmanager.services.PropertiesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PropertiesController {
    private final PropertiesService propertiesService;

    public PropertiesController(PropertiesService propertiesService) {
        this.propertiesService = propertiesService;
    }

    @GetMapping("/property")
    public ResponseEntity<String> getPropertyByKey(@RequestParam("key") String propertyKey, @RequestParam(value = "namespace", required = false) String namespace){
        if(propertyKey==null || propertyKey.trim().length()<1) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        var response = namespace==null?propertiesService.getProperty(propertyKey):propertiesService.getProperty(namespace, propertyKey);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getNamespaceProperties")
    public ResponseEntity<Map<String, String>> getNamespaceProperties(@RequestParam("namespace") String namespace){
        if(namespace==null || namespace.trim().length()<1) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(propertiesService.getNamespaceProperties(namespace), HttpStatus.OK);
    }
}
