package com.example.start;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/chocolate")
public class Controller {

    private final MeterRegistry meterRegistry;

    @GetMapping("/buy/{type}")
    public String buyChocolate(@PathVariable String type) {
        Counter counter = meterRegistry.counter("chocolate.purchases", "type", type);
        counter.increment();

        return "Вы купили: " + type;
    }

    @Timed(value = "buy.time")
    @GetMapping("/fast-buy")
    public String fastBuy() throws InterruptedException {
        Thread.sleep(500);
        return "Быстро куплено!";
    }
}


