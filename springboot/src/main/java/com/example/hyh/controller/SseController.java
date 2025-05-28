package com.example.hyh.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@CrossOrigin(originPatterns = "*", allowCredentials = "true")
@RestController
public class SseController {

    // Executor service to manage thread scheduling
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    @GetMapping("/stream-sse")
    public SseEmitter streamSseMvc() {
        // Create a new SseEmitter with a timeout value (here, practically never timing out)
        SseEmitter emitter = new SseEmitter(10L);

        // Schedule a task to run every second
        scheduler.scheduleAtFixedRate(() -> {
            try {
                // Send the current time millis to the client
                emitter.send(System.currentTimeMillis());
            } catch (Exception e) {
                // If there is an error, complete the emitter with an error status
                emitter.completeWithError(e);
            }
        }, 0, 1, TimeUnit.SECONDS);

        // On completion of the emitter, shut down the scheduler
        emitter.onCompletion(() -> scheduler.shutdown());

        return emitter;
    }
}
