package com.ecc.exercises.springexercise.repository;

import com.ecc.exercises.springexercise.model.Person;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Integer> {

	// @Query("SELECT person FROM Person person LEFT JOIN fetch person.contacts " + 
	// 	"LEFT JOIN fetch person.roles WHERE person.id =:personId")
    @Transactional(readOnly = true)
    Optional<Person> findById(@Param("personId") Integer personId);

    @Transactional(readOnly = true)
    List<Person> findAll();
    
    // @Transactional(readOnly = true)
    // List<Person> findByOrderByNameAsc();

    // @Transactional(readOnly = true)
    // List<Person> findByOrderByGwaDesc();

    // @Transactional(readOnly = true)
    // List<Person> findByOrderByDateHiredDesc();
    void deleteById(Integer personId);
    void delete(Person person);
    @Transactional
    Person save(Person person);
}