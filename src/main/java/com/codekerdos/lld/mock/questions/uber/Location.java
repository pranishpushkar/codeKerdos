package com.codekerdos.lld.mock.questions.uber;

public class Location {

    protected double latitude;
    protected double longitude;

    public Location(double latitude, double longitude){

        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double distance(Location location){
        double a = Math.abs(location.latitude - this.latitude);
        double b = Math.abs(location.longitude - this.longitude);

        return Math.sqrt(a*a+b*b);

    }

}
