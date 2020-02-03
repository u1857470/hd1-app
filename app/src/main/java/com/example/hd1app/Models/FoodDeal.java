package com.example.hd1app.Models;

import java.util.Date;

public class FoodDeal extends Deal {
    public FoodDeal(String title, String discountCode, int numOfUses, Date expirationDate, boolean expiresIn5days, int likes) {
        super(title, discountCode, numOfUses, expirationDate, expiresIn5days, likes);
    }
}
