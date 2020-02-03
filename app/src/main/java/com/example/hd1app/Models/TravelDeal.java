package com.example.hd1app.Models;

import java.util.Date;

public class TravelDeal extends Deal{
    public TravelDeal(String title, String discountCode, int numOfUses, Date expirationDate, boolean expiresIn5days, int likes) {
        super(title, discountCode, numOfUses, expirationDate, expiresIn5days, likes);
    }
}
