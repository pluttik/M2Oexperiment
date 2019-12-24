package com.example.demo.data.repository;

import com.example.demo.data.entity.University;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends CrudRepository<University, Integer> {

    void deleteAll();
}
