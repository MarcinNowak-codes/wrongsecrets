package org.owasp.wrongsecrets.asciidoc;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.StringWriter;


public class AsciiDocGenerator implements TemplateGenerator {

    @Override
    public String generate(String name) throws IOException {
        var templateFile = name + ".adoc";
        try (var is = new ClassPathResource(templateFile).getInputStream()) {
            var writer = new StringWriter();
            return writer.toString();
        }
    }
}
