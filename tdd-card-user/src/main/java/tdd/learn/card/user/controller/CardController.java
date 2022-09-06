package tdd.learn.card.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tdd.learn.card.user.repository.CardRepository;



@RestController
@RequestMapping("/card")
public class CardController {
    private CardRepository cardRepository;

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("hello world");
    }

}
