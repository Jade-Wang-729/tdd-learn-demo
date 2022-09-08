package tdd.learn.card.user;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
//@ActiveProfiles("test")
public class StartTest {

//    public static PostgreSQLContainer container = new PostgreSQLContainer()
//            .withUsername("postgres")
//            .withPassword("password")
//            .withDatabaseName("test");
    @Container
    public static PostgreSQLContainer<?> container = new PostgreSQLContainer<>(PostgreSQLTestImages.POSTGRES_TEST_IMAGE)
            .withUsername("postgres")
            .withPassword("password")
            .withDatabaseName("test");


    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        container.start();
        registry.add("spring.datasource.url",container::getJdbcUrl);
        registry.add("spring.datasource.username",container::getUsername);
        registry.add("spring.datasource.password",container::getUsername);
    }



    @Test
    void contextLoads() {
        System.out.println("CONTENT LOADS");
    }



}


