package com.group.OATS.BusinessLogic.Controllers;

import com.group.OATS.DataAccess.Services.TextToSummarizeService;
import com.group.OATS.Models.TextToSummarizeDetails;
import com.group.OATS.Models.TextToSummarizeHeader;
import com.group.OATS.Models.TextToSummarizeRequest;
import com.group.OATS.Models.TextToSummarizeTable;
import com.group.OATS.Summarizer;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/summarization")
public class TextToSummarizeController {
    private TextToSummarizeService textToSummarizeService;

    public TextToSummarizeController(TextToSummarizeService textToSummarizeService) {
        this.textToSummarizeService = textToSummarizeService;
    }

    @PostMapping
    @Transactional
    @RequestMapping(value = "/getTable/{idPerdoruesi}")
    public List<TextToSummarizeTable> getTables(
            @PathVariable(value = "idPerdoruesi") Integer idPerdoruesi){
        try{
            List<TextToSummarizeTable> table = textToSummarizeService.getTable(null, idPerdoruesi);
            return table;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping
    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(value = "/summarizeText")
    public void insertTextToSummarize(@RequestBody TextToSummarizeRequest textToSummarizeRequest){
        try{
            TextToSummarizeHeader textToSummarizeHeader = new TextToSummarizeHeader();
            textToSummarizeHeader.setIdPerdoruesi(textToSummarizeRequest.getIdPerdoruesi());
            textToSummarizeHeader.setIdLlojiTekstitInput(textToSummarizeRequest.getIdLlojiTekstitInput());
            Integer idHeader = textToSummarizeService.insertHeader(textToSummarizeHeader);
            if(idHeader!= null){
                TextToSummarizeDetails textToSummarizeDetails = new TextToSummarizeDetails();
                textToSummarizeDetails.setIdHeader(idHeader);
                textToSummarizeDetails.setFeedback(null);
                textToSummarizeDetails.setIdLlojiTekstit(textToSummarizeRequest.getGetIdLlojiTekstitOutput());
                textToSummarizeDetails.setSummPercentage(textToSummarizeRequest.getSummPercentage());
                textToSummarizeDetails.setTextToSummarize(textToSummarizeRequest.getTextToSummarize());
                textToSummarizeDetails.setSummarizedText(Summarizer.summarizeText(textToSummarizeRequest.getTextToSummarize(),textToSummarizeRequest.getSummPercentage()));
                textToSummarizeService.insertDetails(textToSummarizeDetails);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
