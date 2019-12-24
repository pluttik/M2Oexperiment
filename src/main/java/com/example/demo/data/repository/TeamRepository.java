package com.example.demo.data.repository;

import com.example.demo.data.entity.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<Team, Integer> {

    void deleteAll();
}
