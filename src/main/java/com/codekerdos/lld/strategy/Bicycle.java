package com.codekerdos.lld.strategy;

public class Bicycle implements PathInterface {

    @Override
    public void findPath(String str) {
        System.out.println("Finding path for bicycle: " + str);
    }

}
