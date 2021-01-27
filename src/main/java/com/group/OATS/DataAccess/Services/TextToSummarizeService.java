package com.group.OATS.DataAccess.Services;

import com.group.OATS.DataAccess.StoredProcedures.TextToSummarizeTableSelectSp;
import com.group.OATS.Models.TextToSummarizeTable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TextToSummarizeService {
    private TextToSummarizeTableSelectSp textToSummarizeTableSelectSp;

    public TextToSummarizeService(TextToSummarizeTableSelectSp textToSummarizeTableSelectSp){
        this.textToSummarizeTableSelectSp=textToSummarizeTableSelectSp;
    }

    public List<TextToSummarizeTable> getTable(Integer id, Integer perdoruesi){
        return textToSummarizeTableSelectSp.getSummarizeTable(id,perdoruesi);
    }
}
