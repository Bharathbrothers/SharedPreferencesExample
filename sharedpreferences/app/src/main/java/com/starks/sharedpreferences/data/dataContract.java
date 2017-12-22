package com.starks.sharedpreferences.data;

public final class dataContract {

    int rank;
    String cname;
    String ccode;


    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public dataContract(int rank) {
        this.rank=rank;
    }


}
