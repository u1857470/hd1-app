package com.example.hd1app.Models;

import com.example.hd1app.Models.Deal;

import java.util.Date;

public class FashionDeal extends Deal {
    public FashionDeal(String title, String discountCode, Date expirationDate, int numOfUses, int likes) {
        super(title, discountCode, expirationDate, numOfUses, likes);
    }
}
