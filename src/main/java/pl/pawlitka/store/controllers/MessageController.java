package pl.pawlitka.store.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pawlitka.store.entities.Message;

@RestController
public class MessageController {

    @RequestMapping("/hello")
    public Message sayHello() {
        return new Message("Hello world");
    }
}
