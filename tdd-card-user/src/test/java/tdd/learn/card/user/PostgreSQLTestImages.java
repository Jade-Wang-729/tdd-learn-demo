package tdd.learn.card.user;

import org.testcontainers.utility.DockerImageName;
public class PostgreSQLTestImages {

    static DockerImageName POSTGRES_TEST_IMAGE = DockerImageName.parse("postgres:latest");

}
