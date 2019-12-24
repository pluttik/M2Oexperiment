package com.example.demo.data.repository;

import com.example.demo.data.entity.Boss;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BossRepository extends CrudRepository<Boss, Integer> {

    void deleteAll();
}
