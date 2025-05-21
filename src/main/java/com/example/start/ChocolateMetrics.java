package com.example.start;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class ChocolateMetrics implements MeterBinder {

    private final Map<String, AtomicInteger> chocolates = new ConcurrentHashMap<>();

    public ChocolateMetrics() {
        chocolates.put("KitKat", new AtomicInteger(0));
        chocolates.put("Snickers", new AtomicInteger(0));
        chocolates.put("Twix", new AtomicInteger(0));
    }

    public void buy(String name) {
        chocolates.getOrDefault(name, new AtomicInteger(0)).incrementAndGet();
    }

    @Override
    public void bindTo(MeterRegistry registry) {
        chocolates.forEach((name, counter) ->
                Gauge.builder("chocolate.purchased", counter, AtomicInteger::get)
                        .tag("type", name)
                        .register(registry)
        );
    }
}
