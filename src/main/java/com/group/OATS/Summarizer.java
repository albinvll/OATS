package com.group.OATS;

public class Summarizer {
    public static String summarizeText(String text, double summPercentage){
        String[] splitText = text.split(" ");
        int summarizationLength = (int)(splitText.length/2);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i<summarizationLength; i++){
            stringBuilder.append(splitText[i] + " ");
        }
        return stringBuilder.toString();
    }
}
