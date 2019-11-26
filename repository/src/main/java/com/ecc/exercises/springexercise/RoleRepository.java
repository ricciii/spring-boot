package com.ecc.exercises.springexercise.repository;

import com.ecc.exercises.springexercise.model.Role;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

    @Transactional(readOnly = true)
    Optional<Role> findById(Integer id);
    @Transactional(readOnly = true)
    List<Role> findAll();
    void delete(Role role);
    Role save(Role role);
}