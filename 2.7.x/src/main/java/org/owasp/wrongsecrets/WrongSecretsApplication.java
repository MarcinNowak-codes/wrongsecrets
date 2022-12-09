package org.owasp.wrongsecrets;

import org.owasp.wrongsecrets.challenges.kubernetes.Vaultpassword;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(Vaultpassword.class)
public class WrongSecretsApplication {

    public static void main(String[] args) {
        SpringApplication.run(WrongSecretsApplication.class, args);
    }

}
