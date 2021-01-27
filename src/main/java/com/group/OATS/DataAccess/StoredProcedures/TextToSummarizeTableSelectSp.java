package com.group.OATS.DataAccess.StoredProcedures;

import com.group.OATS.Models.TextToSummarizeTable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TextToSummarizeTableSelectSp extends StoredProcedure {
    private static final String STORED_PROCEDURE = "TextToSummarizeTableSelect_sp";
    private static final String RESULT = "RESULT";
    public TextToSummarizeTableSelectSp(JdbcTemplate jdbcTemplate){
        super(jdbcTemplate,STORED_PROCEDURE);
        declareParameter(new SqlParameter("Id", Types.INTEGER));
        declareParameter(new SqlParameter("IdPerdoruesi", Types.INTEGER));
        declareParameter(
                new SqlReturnResultSet(RESULT, (RowMapper<TextToSummarizeTable>) (rs, rowNum) -> {
                    TextToSummarizeTable textToSummarizeTable = new TextToSummarizeTable();
                    textToSummarizeTable.setId(rs.getInt("Id"));
                    textToSummarizeTable.setSummarizedText(rs.getString("SummarizedText"));
                    textToSummarizeTable.setDataERegjistrimit(rs.getDate("DataERegjistrimit"));
                    return textToSummarizeTable;
                }));
        compile();
    }
    public List<TextToSummarizeTable> getSummarizeTable(Integer id, Integer idPerdoruesi){
        final Map<String, Object> map = new HashMap<>();
        map.put("Id", id);
        map.put("IdPerdoruesi", idPerdoruesi);
        List<TextToSummarizeTable> textToSummarizeTables = (List<TextToSummarizeTable>) super.execute(map).get(RESULT);
        return textToSummarizeTables;
    }
}
