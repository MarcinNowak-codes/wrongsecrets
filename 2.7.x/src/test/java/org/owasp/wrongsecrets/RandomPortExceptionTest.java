package org.owasp.wrongsecrets;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RandomPortExceptionTest {

    @LocalServerPort
    private int port;

    @Autowired
    private RestTemplateBuilder builder;

    @Test
    void shouldRedirectwhenProtoProvided() {
        var restTemplate = builder
                .defaultHeader("x-forwarded-proto", "value")
                .build();
        var rootAddress = "http://localhost:" + port + "/heroku";//note we loosely ask for "heroku" to be part of the url
        restTemplate.getForEntity(rootAddress, String.class);
    }
}
