package tdd.learn.card.user.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;
import tdd.learn.card.user.entity.Card;
//import tdd.learn.card.user.repository.CardRepository;
//import tdd.learn.card.user.request.CardRequest;
//
//import tdd.learn.card.user.db.AbstractContainerDatabaseTest;
//
//
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//
//@Testcontainers
//public class RedisBackedCacheIntTest {
//
//    private RedisBackedCache underTest;
//
//    // container {
//    @Container
//    public GenericContainer redis = new GenericContainer(DockerImageName.parse("redis:5.0.3-alpine"))
//            .withExposedPorts(6379);
//
//    // }
//
//    @BeforeEach
//    public void setUp() {
//        String address = redis.getHost();
//        Integer port = redis.getFirstMappedPort();
//
//        // Now we have an address and port for Redis, no matter where it is running
//        underTest = new RedisBackedCache(address, port);
//    }
//
//    @Test
//    public void testSimplePutAndGet() {
//        underTest.put("test", "example");
//
//        String retrieved = underTest.get("test");
//        assertThat(retrieved).isEqualTo("example");
//    }
//}

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,properties = {
//        "spring.datasource.url=jdbc:tc:postgresql:9.6.12:///postgres"})
//@ActiveProfiles("test")
//@Testcontainers
//class CardControllerTest extends AbstractContainerDatabaseTest{
//    @Autowired
//    TestRestTemplate restTemplate;
//
//    @Autowired
//    CardRepository cardRepository;
//
//    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(DockerImageName.parse("postgres:9.6.12"))
//            .withDatabaseName("postgres")
//            .withUsername("postgres")
//            .withPassword("password")
//            .withExposedPorts(5432);
//
//    @DynamicPropertySource
//    static void registerPgProperties(DynamicPropertyRegistry registry) {
//        postgres.start();
//        registry.add("spring.redis.host", postgres::getHost);
//        registry.add("spring.redis.port", postgres::getFirstMappedPort);
//    }
//
//
//    @Test
//    public void simpleTest() {
//        String testResource = "/card/test";
//
//        restTemplate.getForObject(testResource,String.class);
//
//        assertThat(restTemplate.getForObject(testResource, String.class)).as("value is set").isEqualTo("hello world");
//    }
//
//    @Test
//    public void simpleJPATest() {
//
//        String addResource = "/card/add";
//        CardRequest newCardRequest = new CardRequest();
//        newCardRequest.setId("testID");
//        restTemplate.put(addResource, newCardRequest);
//
//
//        Card resultCard = restTemplate.getForObject("/card/add", Card.class);
//        assertThat(resultCard.getId()).as("id is set").isEqualTo("testID");
//
//
//    }
////    @Test
////    @Sql("classpath:sql/insertVerificationToDb.sql")
////    public void dbTest() throws SQLException {
////
////    }
//
//
////
//
//    @Test
//    public void testSimple() throws SQLException {
//        PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(DockerImageName.parse("postgres:9.6.12"))
//                .withDatabaseName("postgres")
//                .withUsername("postgres")
//                .withPassword("password")
//                .withExposedPorts(5432);
//        postgres.start();
//        ResultSet resultSet = performQuery(postgres, "SELECT 1");
//        int resultSetInt = resultSet.getInt(1);
//        assertThat(resultSetInt).as("A basic SELECT query succeeds").isEqualTo(1);
//    }
//
//}
