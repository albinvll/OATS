package com.group.OATS.BusinessLogic.Controllers;

import com.group.OATS.DataAccess.Services.TextToSummarizeService;
import com.group.OATS.Models.TextToSummarizeTable;
import org.springframework.http.ResponseEntity;
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
    public List<TextToSummarizeTable> login(
            @PathVariable(value = "idPerdoruesi") Integer idPerdoruesi){
        try{
            List<TextToSummarizeTable> table = textToSummarizeService.getTable(null, idPerdoruesi);
            return table;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
