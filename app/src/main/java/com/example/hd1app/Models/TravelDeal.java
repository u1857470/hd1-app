package com.example.hd1app.Models;

import java.util.Date;

public class TravelDeal extends Deal{

    public TravelDeal(String title, String discountCode, Date expirationDate, int numOfUses, int likes) {
        super(title, discountCode, expirationDate, numOfUses, likes);
    }
}
