package com.example.calcurator;

public class History {

    //INSTANSSIMUUTTUJAT
    private String ruuannimi;
    private int calmaara;


    //RAKENTAJA
    public History(String ruuannimi, int calmaara) {
        this.ruuannimi = ruuannimi;
        this.calmaara = calmaara;
    }

    //METODIT

    public String getRuuannimi() {
    return this.ruuannimi;
    }

    public int getCalmaara(){
        return this.calmaara;
    }
}
