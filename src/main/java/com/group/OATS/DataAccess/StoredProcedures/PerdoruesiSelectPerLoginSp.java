package com.group.OATS.DataAccess.StoredProcedures;

import com.group.OATS.Models.Perdoruesi;
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
public class PerdoruesiSelectPerLoginSp extends StoredProcedure {
    private static final String STORED_PROCEDURE = "PerdoruesiSelectPerLogin_sp";
    private static final String RESULT = "RESULT";

    public PerdoruesiSelectPerLoginSp(JdbcTemplate jdbcTemplate){
        super(jdbcTemplate,STORED_PROCEDURE);
        declareParameter(new SqlParameter("Email", Types.VARCHAR));
        declareParameter(new SqlParameter("Password", Types.VARCHAR));
        declareParameter(
                new SqlReturnResultSet(RESULT, (RowMapper<Perdoruesi>) (rs, rowNum) -> {
                    Perdoruesi perdoruesi = new Perdoruesi();
                    perdoruesi.setId(rs.getInt("Id"));
                    perdoruesi.setEmri(rs.getString("Emri"));
                    perdoruesi.setMbiemri(rs.getString("Mbiemri"));
                    perdoruesi.setEmail(rs.getString("Email"));
                    perdoruesi.setIdSubscription(rs.getInt("IdSubscription"));
                    return perdoruesi;
                }));
        compile();
    }

    public List<Perdoruesi> getPerdoruesinPerLogin(Perdoruesi perdoruesi){
        final Map<String, Object> map = new HashMap<>();
        map.put("Email",perdoruesi.getEmail());
        map.put("Password",perdoruesi.getPassword());
        List<Perdoruesi> perdoruesiSelect = (List<Perdoruesi>) super.execute(map).get(RESULT);
        return perdoruesiSelect;
    }
}
