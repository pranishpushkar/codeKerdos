package com.codekerdos.lld.strategy;

public class Motorbike implements PathInterface {

    @Override
    public void findPath(String str) {
        System.out.println("Finding path for motorbike: " + str);
    }

}
