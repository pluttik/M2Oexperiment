package com.example.demo.business.service;

import com.example.demo.data.entity.Result;
import com.example.demo.data.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;

    public List<Result> findAll() {
        return (List<Result>) resultRepository.findAll();
    }

    public void save(Result result) { resultRepository.save(result); }
}
