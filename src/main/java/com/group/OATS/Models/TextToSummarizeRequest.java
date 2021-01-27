package com.group.OATS.Models;

public class TextToSummarizeRequest {
    private Integer idPerdoruesi;
    private Integer idLlojiTekstitInput;
    private Integer getIdLlojiTekstitOutput;
    private String textToSummarize;
    private Double summPercentage;
    private String feedback;

    public Integer getIdPerdoruesi() {
        return idPerdoruesi;
    }

    public void setIdPerdoruesi(Integer idPerdoruesi) {
        this.idPerdoruesi = idPerdoruesi;
    }

    public Integer getIdLlojiTekstitInput() {
        return idLlojiTekstitInput;
    }

    public void setIdLlojiTekstitInput(Integer idLlojiTekstitInput) {
        this.idLlojiTekstitInput = idLlojiTekstitInput;
    }

    public Integer getGetIdLlojiTekstitOutput() {
        return getIdLlojiTekstitOutput;
    }

    public void setGetIdLlojiTekstitOutput(Integer getIdLlojiTekstitOutput) {
        this.getIdLlojiTekstitOutput = getIdLlojiTekstitOutput;
    }

    public String getTextToSummarize() {
        return textToSummarize;
    }

    public void setTextToSummarize(String textToSummarize) {
        this.textToSummarize = textToSummarize;
    }

    public Double getSummPercentage() {
        return summPercentage;
    }

    public void setSummPercentage(Double summPercentage) {
        this.summPercentage = summPercentage;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
