package com.dp.designpattern.factorypattern;

import java.util.HashMap;
import java.util.Map;
public class FactoryPattern<T extends Enum<T>,X> {

    private Map<T, X> concretions = new HashMap<>();

    public void addToFactory(T key, X value) {
        concretions.put(key, value);
    }

    public void addToFactory(Map<T, X> values) {
        concretions.putAll(values);
    }

    public X getInstanceFromFactory(T key) throws ConcretionNotFoundException {
        if (concretions.containsKey(key)) {
            return concretions.get(key);
        }
        throw new ConcretionNotFoundException();
    }
}
