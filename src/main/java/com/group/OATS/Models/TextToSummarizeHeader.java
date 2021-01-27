package com.group.OATS.Models;

import java.sql.Timestamp;

public class TextToSummarizeHeader {
    private Integer id;
    private Integer idPerdoruesi;
    private Timestamp dataERegjistrimit;
    private Integer idLlojiTekstitInput;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdPerdoruesi() {
        return idPerdoruesi;
    }

    public void setIdPerdoruesi(Integer idPerdoruesi) {
        this.idPerdoruesi = idPerdoruesi;
    }

    public Timestamp getDataERegjistrimit() {
        return dataERegjistrimit;
    }

    public void setDataERegjistrimit(Timestamp dataERegjistrimit) {
        this.dataERegjistrimit = dataERegjistrimit;
    }

    public Integer getIdLlojiTekstitInput() {
        return idLlojiTekstitInput;
    }

    public void setIdLlojiTekstitInput(Integer idLlojiTekstitInput) {
        this.idLlojiTekstitInput = idLlojiTekstitInput;
    }


}
