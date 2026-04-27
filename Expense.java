package com.expense.model;

public class Expense {
    private int sno;
    private String item;
    private String category;
    private String exp_date; 
    private double price;

    public Expense(int sno, String item, String category, String exp_date, double price) {
        this.sno = sno;
        this.item = item;
        this.category = category;
        this.exp_date = exp_date;
        this.price = price;
    }

    public int getSno() { return sno; }
    public void setSno(int sno) { this.sno = sno; }
    
    public String getItem() { return item; }
    public void setItem(String item) { this.item = item; }
    
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    
    public String getExp_date() { return exp_date; }
    public void setExp_date(String exp_date) { this.exp_date = exp_date; }
    
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}