package com.group.OATS.DataAccess.StoredProcedures;

import com.group.OATS.Models.TextToSummarizeHeader;
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

public class TextToSummarizeHeaderInsertSp extends StoredProcedure {
    private static final String STORED_PROCEDURE = "TextToSummarizeHeaderInsert_sp";
    private static final String RESULT = "RESULT";

    public TextToSummarizeHeaderInsertSp(final JdbcTemplate jdbcTemplate){
        super(jdbcTemplate,STORED_PROCEDURE);
        declareParameter(new SqlParameter("IdPerdoruesi", Types.INTEGER));
        declareParameter(new SqlParameter("IdLLojiTekstitInput", Types.INTEGER));
        declareParameter(
                new SqlReturnResultSet(RESULT, (RowMapper<Integer>) (rs, rowNum) -> {
                    return rs.getInt("Id");
                }));
        compile();
    }

    public List<Integer> insertTextToSummarizeDetails(TextToSummarizeHeader textToSummarizeHeader){
        final Map<String, Object> map = new HashMap<>();
        map.put("IdPerdoruesi", textToSummarizeHeader.getIdPerdoruesi());
        map.put("IdLLojiTekstitInput",textToSummarizeHeader.getIdLlojiTekstitInput());
        return (List<Integer>)super.execute(map).get(RESULT);

    }
}
