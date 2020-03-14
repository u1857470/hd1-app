package com.example.hd1app.Models;

import java.util.Date;

public class EntertainmentDeal extends Deal {
    public EntertainmentDeal(String title, String discountCode, Date expirationDate, int numOfUses, int likes, int imagePath) {
        super(title, discountCode, expirationDate, numOfUses, likes, imagePath);
    }
}
