package com.example.start;

import com.example.start.dto.AsyncEvent;
import com.example.start.dto.RegularEvent;
import com.example.start.dto.TransEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@Slf4j
public class Listeners {

    @EventListener
    public void handleRegularEvent(RegularEvent regularDTO) {
        log.info("Читаю обычное событие " + regularDTO.message() + System.currentTimeMillis());
    }

    @Async
    @EventListener
    public void handleAsyncEvent(AsyncEvent asyncEvent) {
        log.info("Читаю асинхронное " + asyncEvent.message() + System.currentTimeMillis());
    }

    @TransactionalEventListener
    public void handleTransactionalEvent(TransEvent transEvent) {
        if (transEvent.success()) {
            log.info("Обрабатываю транзативное " + transEvent.message() + System.currentTimeMillis());

        } else {
            log.info("Не могу обрабтать " + transEvent.message() + System.currentTimeMillis());
        }
    }
}