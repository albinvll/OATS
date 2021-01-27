package com.group.OATS.DataAccess.StoredProcedures;

import com.group.OATS.Models.Perdoruesi;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PerdoruesiInsertSp extends StoredProcedure {
    private static final String STORED_PROCEDURE = "PerdoruesiInsert_sp";

    public PerdoruesiInsertSp(JdbcTemplate jdbcTemplate){
        super(jdbcTemplate,STORED_PROCEDURE);
        declareParameter(new SqlParameter("Emri", Types.VARCHAR));
        declareParameter(new SqlParameter("Mbiemri", Types.VARCHAR));
        declareParameter(new SqlParameter("Email", Types.VARCHAR));
        declareParameter(new SqlParameter("Password", Types.VARCHAR));
        declareParameter(new SqlParameter("IdSubscription", Types.INTEGER));
        compile();
    }

    public void insertPerdoruesi(Perdoruesi perdoruesi){
        final Map<String, Object> map = new HashMap<>();
        map.put("Emri",perdoruesi.getEmri());
        map.put("Mbiemri",perdoruesi.getMbiemri());
        map.put("Email",perdoruesi.getMbiemri());
        map.put("Password",perdoruesi.getPassword());
        map.put("IdSubscription",perdoruesi.getIdSubscription());
        super.execute(map);
    }

}
