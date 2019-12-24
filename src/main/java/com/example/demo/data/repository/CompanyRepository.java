package com.example.demo.data.repository;

import com.example.demo.data.entity.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Integer> {

    void deleteAll();
}
