package tdd.learn.card.user;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.function.Supplier;

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
//            .withExposedPorts(5432);


    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        container.getMappedPort(5432);
        final String logs = container.getLogs();
        System.out.println("$$$$$$$$$$\n" + logs + "@@@@@@@@@@@\n");


//        registry.add("spring.datasource.host", container::getHost);
//        registry.add("spring.datasource.port", container::getFirstMappedPort);

        final Supplier<Object> getJdbcUrl = container::getJdbcUrl;
        registry.add("spring.datasource.url", getJdbcUrl);
        registry.add("spring.datasource.username",container::getUsername);
        registry.add("spring.datasource.password",container::getPassword);
    }



    @Test
    void contextLoads() {
        container.start();
        final String logs2 = container.getLogs();
        System.out.println("$$$$$$$$$$\n" + logs2 + "@@@@@@@@@\n");
        System.out.println("CONTENT LOADS");
    }



}


