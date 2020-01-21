package com.example.demo.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int resultId;

    private int biJoin;

    private int uniList;

    private int bi;

    private int uniObj;

    public Result() {
    }

    public Result(int biJoin, int uniList, int bi, int uniObj) {
        this.biJoin = biJoin;
        this.uniList = uniList;
        this.bi = bi;
        this.uniObj = uniObj;
    }

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public int getBiJoin() {
        return biJoin;
    }

    public void setBiJoin(int biJoin) {
        this.biJoin = biJoin;
    }

    public int getUniList() {
        return uniList;
    }

    public void setUniList(int uniList) {
        this.uniList = uniList;
    }

    public int getBi() {
        return bi;
    }

    public void setBi(int bi) {
        this.bi = bi;
    }

    public int getUniObj() {
        return uniObj;
    }

    public void setUniObj(int uniObj) {
        this.uniObj = uniObj;
    }
}
