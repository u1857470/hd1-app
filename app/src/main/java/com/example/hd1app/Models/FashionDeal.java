package com.example.hd1app.Models;

import java.util.Date;

public class FashionDeal extends Deal {
    public FashionDeal(String title, String discountCode, Date expirationDate, int numOfUses, int likes, int imagePath) {
        super(title, discountCode, expirationDate, numOfUses, likes, imagePath);
    }
}
