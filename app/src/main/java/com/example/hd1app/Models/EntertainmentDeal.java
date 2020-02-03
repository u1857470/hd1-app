package com.example.hd1app.Models;

import java.util.Date;

public class EntertainmentDeal extends Deal {
    public EntertainmentDeal(String title, String discountCode, int numOfUses, Date expirationDate, boolean expiresIn5days, int likes) {
        super(title, discountCode, numOfUses, expirationDate, expiresIn5days, likes);
    }
}
