package it.sunnyvale.poc.opentelemetrydatadog.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoController {

        @GetMapping("/hello/{name}")
        public String hello(@PathVariable String name) {
            try {
                // Pause this thread for a random amount of milliseconds
                Thread.sleep((long)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return String.format("Hello %s", name);
        }
}
