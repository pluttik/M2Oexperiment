package com.example.demo.web.application;

import com.example.demo.business.service.Service;
import com.example.demo.data.ReadAndWriteData;
import com.example.demo.data.entity.DisplayResultClass;
import com.example.demo.data.entity.Student;
import com.example.demo.data.entity.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@Controller
public class ReadWriteDataController {

    @Autowired
    private ReadAndWriteData readAndWriteData;

    @Autowired
    private Service service;

    @GetMapping("/")
    public String readwritedata(Model model) {
        DisplayResultClass results = service.readResultsFromFile();
        model.addAttribute("titles", results.getTitles());
        model.addAttribute("results", results.getResults());
        return ("readwritedata_template");
    }

    @PostMapping("do_getdata")
    public String getMoreData(Model model) {
        String[] newData = readAndWriteData.timeScenarioOne();
        DisplayResultClass results = service.readResultsFromFile();
        service.writeDataToResultsFile(results, newData);
        DisplayResultClass results2 = service.readResultsFromFile();
        model.addAttribute("titles", results2.getTitles());
        model.addAttribute("results", results2.getResults());
        return "readwritedata_template";
    }
}
