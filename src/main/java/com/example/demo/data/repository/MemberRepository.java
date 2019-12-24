package com.example.demo.data.repository;

import com.example.demo.data.entity.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Member, Integer> {

    void deleteAll();
}
