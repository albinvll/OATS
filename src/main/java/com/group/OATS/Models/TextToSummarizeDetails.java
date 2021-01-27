package com.group.OATS.Models;

public class TextToSummarizeDetails {
    private Integer Id;
    private Integer IdHeader;
    private Integer IdLlojiTekstit;
    private String TextToSummarize;
    private String SummarizedText;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getIdHeader() {
        return IdHeader;
    }

    public void setIdHeader(Integer idHeader) {
        IdHeader = idHeader;
    }

    public Integer getIdLlojiTekstit() {
        return IdLlojiTekstit;
    }

    public void setIdLlojiTekstit(Integer idLlojiTekstit) {
        IdLlojiTekstit = idLlojiTekstit;
    }

    public String getTextToSummarize() {
        return TextToSummarize;
    }

    public void setTextToSummarize(String textToSummarize) {
        TextToSummarize = textToSummarize;
    }

    public String getSummarizedText() {
        return SummarizedText;
    }

    public void setSummarizedText(String summarizedText) {
        SummarizedText = summarizedText;
    }

    public Double getSummPercentage() {
        return SummPercentage;
    }

    public void setSummPercentage(Double summPercentage) {
        SummPercentage = summPercentage;
    }

    public String getFeedback() {
        return Feedback;
    }

    public void setFeedback(String feedback) {
        Feedback = feedback;
    }

    private Double SummPercentage;
    private String Feedback;

}
