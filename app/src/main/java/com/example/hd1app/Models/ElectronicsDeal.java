package com.example.hd1app.Models;

import com.example.hd1app.Models.Deal;

import java.util.Date;

public class ElectronicsDeal extends Deal {

    public ElectronicsDeal(String title, String discountCode, Date expirationDate, int numOfUses, int likes) {
        super(title, discountCode, expirationDate, numOfUses, likes);
    }
}
