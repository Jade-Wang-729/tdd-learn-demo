package tdd.learn.card.user.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CardRequest {

    @NotNull
    private String id;
    private String PIN;
    private String cardStatus;
}
