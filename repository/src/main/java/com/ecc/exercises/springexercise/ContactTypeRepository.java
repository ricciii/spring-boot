package com.ecc.exercises.springexercise.repository;

import com.ecc.exercises.springexercise.model.ContactType;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface ContactTypeRepository extends Repository<ContactType, Integer> {

    @Transactional(readOnly = true)
    public List<ContactType> findAll();
}