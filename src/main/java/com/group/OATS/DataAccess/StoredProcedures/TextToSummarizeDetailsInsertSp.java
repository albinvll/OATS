package com.group.OATS.DataAccess.StoredProcedures;

import com.group.OATS.Models.TextToSummarizeDetails;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

@Repository
public class TextToSummarizeDetailsInsertSp extends StoredProcedure {
    private static final String STORED_PROCEDURE = "TextToSummarizeDetailsInsert_sp";

    public TextToSummarizeDetailsInsertSp(JdbcTemplate jdbcTemplate){
        super(jdbcTemplate,STORED_PROCEDURE);
        declareParameter(new SqlParameter("IdHeader", Types.INTEGER));
        declareParameter(new SqlParameter("IdLlojiTekstitOutput", Types.INTEGER));
        declareParameter(new SqlParameter("TextToSummarize",  Types.VARCHAR));
        declareParameter(new SqlParameter("SummarizedText", Types.VARCHAR));
        declareParameter(new SqlParameter("SummPercentage", Types.DECIMAL));
        declareParameter(new SqlParameter("Feedback", Types.VARCHAR));
        compile();
    }

    public void insertTextToSummarizeDetails(TextToSummarizeDetails textToSummarizeDetails){
        final Map<String,Object> map = new HashMap<>();
        map.put("IdHeader",textToSummarizeDetails.getIdHeader());
        map.put("IdLlojiTekstitOutput",textToSummarizeDetails.getIdLlojiTekstit());
        map.put("TextToSummarize",textToSummarizeDetails.getTextToSummarize());
        map.put("SummarizedText",textToSummarizeDetails.getSummarizedText());
        map.put("SummPercentage",textToSummarizeDetails.getSummPercentage());
        map.put("Feedback",textToSummarizeDetails.getFeedback());
        super.execute(map);
    }
}
