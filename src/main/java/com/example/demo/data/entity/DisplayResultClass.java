package com.example.demo.data.entity;

import java.util.ArrayList;
import java.util.List;

public class DisplayResultClass {
    String[] titles;
    List<String[]> results;

    public DisplayResultClass() {
        this.titles = new String[4];
        this.results = new ArrayList<String[]>();
    }

    public String[] getTitles() {
        return titles;
    }

    public void setTitles(String[] titles) {
        this.titles = titles;
    }

    public List<String[]> getResults() {
        return results;
    }

    public void setResults(List<String[]> results) {
        this.results = results;
    }

    public void setResult(String[] result) {
        results.add(result);
    }
}
