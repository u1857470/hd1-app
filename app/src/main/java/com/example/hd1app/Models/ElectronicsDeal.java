package com.example.hd1app.Models;

import com.example.hd1app.Models.Deal;

import java.util.Date;

public class ElectronicsDeal extends Deal {
    public ElectronicsDeal(String title, String discountCode, int numOfUses, Date expirationDate, boolean expiresIn5days, int likes) {
        super(title, discountCode, numOfUses, expirationDate, expiresIn5days, likes);
    }
}
