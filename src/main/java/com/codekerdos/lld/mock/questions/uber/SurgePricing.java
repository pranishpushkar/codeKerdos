package com.codekerdos.lld.mock.questions.uber;

public class SurgePricing implements Pricing {

    private double pricePerKm;
    private double surgeFactor;

    @Override
    public double calculatePrice(Location source, Location destination){


        double distanceInKms = source.distance(destination);
        double price = distanceInKms*pricePerKm*surgeFactor;

    return price;

    }

}
