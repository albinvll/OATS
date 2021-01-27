package com.group.OATS.DataAccess.Services;

import com.group.OATS.DataAccess.StoredProcedures.TextToSummarizeDetailsInsertSp;
import com.group.OATS.DataAccess.StoredProcedures.TextToSummarizeHeaderInsertSp;
import com.group.OATS.DataAccess.StoredProcedures.TextToSummarizeTableSelectSp;
import com.group.OATS.Models.TextToSummarizeDetails;
import com.group.OATS.Models.TextToSummarizeHeader;
import com.group.OATS.Models.TextToSummarizeTable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TextToSummarizeService {
    private TextToSummarizeTableSelectSp textToSummarizeTableSelectSp;
    private TextToSummarizeHeaderInsertSp textToSummarizeHeaderInsertSp;
    private TextToSummarizeDetailsInsertSp textToSummarizeDetailsInsertSp;

    public TextToSummarizeService(TextToSummarizeTableSelectSp textToSummarizeTableSelectSp, TextToSummarizeHeaderInsertSp textToSummarizeHeaderInsertSp, TextToSummarizeDetailsInsertSp textToSummarizeDetailsInsertSp){
        this.textToSummarizeTableSelectSp=textToSummarizeTableSelectSp;
        this.textToSummarizeHeaderInsertSp = textToSummarizeHeaderInsertSp;
        this.textToSummarizeDetailsInsertSp = textToSummarizeDetailsInsertSp;
    }

    public List<TextToSummarizeTable> getTable(Integer id, Integer perdoruesi){
        return textToSummarizeTableSelectSp.getSummarizeTable(id,perdoruesi);
    }
    public Integer insertHeader(TextToSummarizeHeader textToSummarizeHeader){
        return textToSummarizeHeaderInsertSp.insertTextToSummarizeDetails(textToSummarizeHeader).get(0);
    }

    public void insertDetails(TextToSummarizeDetails textToSummarizeDetails) {
        textToSummarizeDetailsInsertSp.insertTextToSummarizeDetails(textToSummarizeDetails);
    }
}
