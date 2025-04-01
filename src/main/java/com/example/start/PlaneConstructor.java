package com.example.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
public class PlaneConstructor {

    public Engine engine;

    @Autowired
    public PlaneConstructor(Engine engine) {
        this.engine = engine;
    }

    public void send() {
        engine.send();
    }

}
