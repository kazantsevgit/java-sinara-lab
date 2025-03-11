package com.example.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Plane {

    private final Engine engine1;

    @Autowired
    @Qualifier("dieselEngine")
    private Engine engine2;

    private Engine engine3;

    @Autowired
    public void setEngine1(Engine engine3) {
        this.engine3 = engine3;
    }

    public Plane(Engine engine1) {
        this.engine1 = engine1;
    }
    public void takeOff() {
        engine1.send();
        engine2.send();
        engine3.send();
    }
}
