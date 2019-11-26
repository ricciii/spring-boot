package com.ecc.exercises.springexercise.controller;

import com.ecc.exercises.springexercise.model.dto.ContactTypeDto;
import com.ecc.exercises.springexercise.service.ContactTypeService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping(value = "api/contact-types")
public class ContactTypeController {

    private ContactTypeService contactTypeService;

    @Autowired
    public ContactTypeController(ContactTypeService contactTypeService) {
    	this.contactTypeService = contactTypeService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<ContactTypeDto>> getContactTypesList() {
        return new ResponseEntity<List<ContactTypeDto>>(contactTypeService.getContactTypesAsList(), HttpStatus.OK);
    }
}