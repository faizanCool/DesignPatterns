package com.dp.designpattern.factorypattern;

public class ConcretionNotFoundException extends Exception {

    public ConcretionNotFoundException(){
        super("Factory does not contain the concretion");
    }
}
