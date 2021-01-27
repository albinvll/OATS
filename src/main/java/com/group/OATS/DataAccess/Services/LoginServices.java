package com.group.OATS.DataAccess.Services;

import com.group.OATS.DataAccess.StoredProcedures.PerdoruesiInsertSp;
import com.group.OATS.DataAccess.StoredProcedures.PerdoruesiSelectPerLoginSp;
import com.group.OATS.Models.Perdoruesi;
import org.springframework.stereotype.Repository;

@Repository
public class LoginServices {
    private PerdoruesiInsertSp perdoruesiInsertSp;
    private PerdoruesiSelectPerLoginSp perdoruesiSelectPerLoginSp;

    public LoginServices(PerdoruesiInsertSp perdoruesiInsertSp, PerdoruesiSelectPerLoginSp perdoruesiSelectPerLoginSp) {
        this.perdoruesiInsertSp = perdoruesiInsertSp;
        this.perdoruesiSelectPerLoginSp = perdoruesiSelectPerLoginSp;
    }

    public void insertPerdoruesin(Perdoruesi perdoruesi){
        perdoruesiInsertSp.insertPerdoruesi(perdoruesi);
    }
    public Perdoruesi getPerdoruesinPerLogin(Perdoruesi perdoruesi){
        Perdoruesi perdoruesiOut = perdoruesiSelectPerLoginSp.getPerdoruesinPerLogin(perdoruesi).get(0);
        return perdoruesiOut;
    }
}
