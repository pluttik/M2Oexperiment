package com.example.demo.web.application;

import com.example.demo.business.service.ResultService;
import com.example.demo.business.service.Service;
import com.example.demo.data.ReadAndWriteData;
import com.example.demo.data.entity.Result;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ReadWriteDataController {

    @Autowired
    private ReadAndWriteData readAndWriteData;

    @Autowired
    private Service service;

    @Autowired
    private ResultService resultService;

    @GetMapping("/")
    public String readwritedata(Model model) {
        List<Result> results = resultService.findAll();
        String[] titles = {"BiJoin","UniList","Bi","UniObj"};
        model.addAttribute("titles", titles);
        model.addAttribute("results", results);
        return ("readwritedata_template");
    }

    @PostMapping("/")
    public String getMoreData(Model model) {
        Result emptyResult = new Result(0,0,0,0);
        Result newData = readAndWriteData.timeScenarioOne();
        emptyResult.setBiJoin(newData.getBiJoin());
        emptyResult.setBi(newData.getBi());
        emptyResult.setUniObj(newData.getUniObj());
        emptyResult.setUniList(newData.getUniList());
        resultService.save(emptyResult);

        List<Result> results2 = resultService.findAll();
        String[] titles = {"BiJoin","UniList","Bi","UniObj"};
        model.addAttribute("titles", titles);
        model.addAttribute("results", results2);
        return "readwritedata_template";
    }
}
