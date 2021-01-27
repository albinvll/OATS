package com.group.OATS.Models;

public class Perdoruesi {
    private int Id;
    private String emri;
    private String mbiemri;
    private String email;
    private String password;
    private Integer idSubscription;

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public void setMbiemri(String mbiemri) {
        this.mbiemri = mbiemri;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIdSubscription() {
        return idSubscription;
    }

    public void setIdSubscription(Integer idSubscription) {
        this.idSubscription = idSubscription;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
