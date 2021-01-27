package com.group.OATS.Models;

import java.util.Date;

public class TextToSummarizeTable {
    private Integer id;
    private String summarizedText;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSummarizedText() {
        return summarizedText;
    }

    public void setSummarizedText(String summarizedText) {
        this.summarizedText = summarizedText;
    }

    public Date getDataERegjistrimit() {
        return dataERegjistrimit;
    }

    public void setDataERegjistrimit(Date dataERegjistrimit) {
        this.dataERegjistrimit = dataERegjistrimit;
    }

    private Date dataERegjistrimit;
}
