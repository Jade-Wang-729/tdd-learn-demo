package tdd.learn.card.user.entity;



import lombok.Getter;
import lombok.Setter;
import org.aspectj.lang.annotation.control.CodeGenerationHint;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "cards")
@Setter
@Getter
public class Card {
    @Id
    @NotNull
    private String id;
    @Column(name = "pin")
    private String PIN;
    @Column(name = "card_status")
    private String cardStatus;

}
