package tdd.learn.card.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tdd.learn.card.user.entity.Card;
import tdd.learn.card.user.repository.CardRepository;
import tdd.learn.card.user.request.CardRequest;

import javax.validation.Valid;


@RestController
@RequestMapping("/card")
public class CardController {
    private CardRepository cardRepository;

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("hello world");
    }

    @PostMapping("/add")
    public ResponseEntity<Card> add(@RequestBody @Valid CardRequest card) {
        Card newCard = new Card();
        newCard.setId(card.getId());
        cardRepository.save(newCard);

        Card newAddedCard = cardRepository.findById(card.getId()).orElseThrow();

        return ResponseEntity.ok(newAddedCard);
    }

}
