package com.dp.designpattern.factorypattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FactoryPatternTest {

    enum TEST {
        HIGH, LOW, NOTHING;
    }

    interface Cal {
        public int getInt();
    }
    private FactoryPattern<TEST, Cal> factoryPattern;

    @BeforeEach
    public void setup() {
        factoryPattern = new FactoryPattern<TEST, Cal>();
        factoryPattern.addToFactory(TEST.LOW, () -> {
            return 1;
        });
        factoryPattern.addToFactory(TEST.HIGH, () -> {
            return 2;
        });
    }

    @Test
    public void factoryPattern_getConcreteObject_success() throws ConcretionNotFoundException {
        Assertions.assertEquals(1, factoryPattern.getInstanceFromFactory(TEST.LOW).getInt());
        Assertions.assertEquals(2, factoryPattern.getInstanceFromFactory(TEST.HIGH).getInt());
    }

    @Test
    public void factoryPattern_getConcreteObject_throwException() {
        Assertions.assertThrowsExactly(ConcretionNotFoundException.class, () ->
            factoryPattern.getInstanceFromFactory(TEST.NOTHING),
                "Expect throwing a ConcretionNotFoundException. But not!"
         );
    }
}
