package com.example.hd1app.Models;

import java.util.Date;

public class Deal {
    private String title;
    private String discountCode;
    private int numOfUses;
    private Date expirationDate;
    private boolean expiresIn5days;
    private int likes;

    public Deal(String title, String discountCode, int numOfUses, Date expirationDate, boolean expiresIn5days, int likes) {
        this.title = title;
        this.discountCode = discountCode;
        this.numOfUses = numOfUses;
        this.expirationDate = expirationDate;
        this.expiresIn5days = expiresIn5days;
        this.likes = likes;
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

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isExpiresIn5days() {
        return expiresIn5days;
    }

    public void setExpiresIn5days(boolean expiresIn5days) {
        this.expiresIn5days = expiresIn5days;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
