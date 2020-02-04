package com.example.hd1app.Models;

import java.util.Calendar;
import java.util.Date;

public class Deal {
    private String title;
    private String discountCode;
    private int numOfUses;
    private Date dateAdded;
    private Date expirationDate;
    private int likes;

    public Deal(String title, String discountCode, Date expirationDate, int numOfUses, int likes) {
        this.title = title;
        this.discountCode = discountCode;
        this.numOfUses = numOfUses;
        this.dateAdded = getCurrentDate();
        this.expirationDate = expirationDate;
        this.likes = likes;
    }
    public Deal(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public int getNumOfUses() {
        return numOfUses;
    }

    public void setNumOfUses(int numOfUses) {
        this.numOfUses = numOfUses;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }
    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    private Date getCurrentDate(){
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }
}
