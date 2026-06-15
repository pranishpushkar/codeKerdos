package com.codekerdos.lld.strategy;

public class Driver {

    public static void main(String[] args) {
        PathInterface pathInterface = new Bicycle();
        pathInterface.findPath("Bicycle path to the park.");

        pathInterface = new Motorbike();
        pathInterface.findPath("Motorbike path to the park.");
    }

}
