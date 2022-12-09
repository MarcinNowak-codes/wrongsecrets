package org.owasp.wrongsecrets;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class DefinedPortWorksTests {

    @LocalServerPort
    private int port;

    @Autowired
    private RestTemplateBuilder builder;

    @Test
    void shouldRedirectWhenProtoProvided() {
        RestTemplate restTemplate = builder
                .defaultHeader("x-forwarded-proto", "value")
                .build();
        String rootAddress = "http://localhost:" + port + "/heroku";
        ResponseEntity<String> result = restTemplate.getForEntity(rootAddress, String.class);
        assertEquals(HttpStatus.FOUND, result.getStatusCode());
        assertEquals("https", result.getHeaders().getLocation().getScheme());
    }
}
