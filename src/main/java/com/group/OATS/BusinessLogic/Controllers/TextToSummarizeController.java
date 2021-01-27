package com.group.OATS.BusinessLogic.Controllers;

import com.group.OATS.DataAccess.Services.TextToSummarizeService;
import com.group.OATS.Models.TextToSummarizeTable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
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
    @CrossOrigin(origins = "http://localhost:3000")
    public List<TextToSummarizeTable> login(
            @PathVariable(value = "idPerdoruesi") Integer idPerdoruesi){
        try{
            return textToSummarizeService.getTable(null,idPerdoruesi);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
