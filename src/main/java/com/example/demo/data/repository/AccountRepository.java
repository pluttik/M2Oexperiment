package com.example.demo.data.repository;

import com.example.demo.data.entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {

    void deleteAll();
}
