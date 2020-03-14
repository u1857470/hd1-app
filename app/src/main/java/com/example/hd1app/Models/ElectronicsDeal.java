package com.example.hd1app.Models;

import java.util.Date;

public class ElectronicsDeal extends Deal {

    public ElectronicsDeal(String title, String discountCode, Date expirationDate, int numOfUses, int likes, int image) {
        super(title, discountCode, expirationDate, numOfUses, likes, image);
    }
}
