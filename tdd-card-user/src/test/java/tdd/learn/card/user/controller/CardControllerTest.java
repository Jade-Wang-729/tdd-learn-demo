package tdd.learn.card.user.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;
import tdd.learn.card.user.entity.Card;
import tdd.learn.card.user.repository.CardRepository;
import tdd.learn.card.user.request.CardRequest;


import static org.assertj.core.api.Assertions.assertThat;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class CardControllerTest {
    @Autowired
    TestRestTemplate restTemplate;


    @Test
    public void simpleTest() {
        String testResource = "/card/test";

        restTemplate.getForObject(testResource,String.class);

        assertThat(restTemplate.getForObject(testResource, String.class)).as("value is set").isEqualTo("hello world");
    }



}
