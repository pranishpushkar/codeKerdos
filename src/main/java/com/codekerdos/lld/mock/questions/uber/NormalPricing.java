package com.codekerdos.lld.mock.questions.uber;

public class NormalPricing implements Pricing {

    private double pricePerKm;

    @Override
    public double calculatePrice(Location source, Location destination){


        double distanceInKms = source.distance(destination);
        double price = distanceInKms*pricePerKm;

    return price;

    }


}
