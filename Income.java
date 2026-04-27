package com.expense.model;

public class Income {
    private int sno;
    private String source;
    private String inc_date;
    private double amount;

    public Income (int sno, String source, String inc_date, double amount) {
        this.sno = sno;
        this.source = source;
        this.inc_date = inc_date;
        this.amount = amount;
    }

    public int getSno() { return sno; }
    public void setSno(int sno) { this.sno = sno; }
    
    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }
    
    public String getInc_date() { return inc_date; }
    public void setInc_date(String inc_date) { this.inc_date = inc_date; }
    
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}