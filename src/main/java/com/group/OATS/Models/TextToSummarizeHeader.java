package com.group.OATS.Models;

import java.sql.Timestamp;

public class TextToSummarizeHeader {
    private Integer id;
    private String idPerdoruesi;
    private Timestamp dataERegjistrimit;
    private String idLlojiTekstitOutput;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdPerdoruesi() {
        return idPerdoruesi;
    }

    public void setIdPerdoruesi(String idPerdoruesi) {
        this.idPerdoruesi = idPerdoruesi;
    }

    public Timestamp getDataERegjistrimit() {
        return dataERegjistrimit;
    }

    public void setDataERegjistrimit(Timestamp dataERegjistrimit) {
        this.dataERegjistrimit = dataERegjistrimit;
    }

    public String getIdLlojiTekstitOutput() {
        return idLlojiTekstitOutput;
    }

    public void setIdLlojiTekstitOutput(String idLlojiTekstitOutput) {
        this.idLlojiTekstitOutput = idLlojiTekstitOutput;
    }


}
