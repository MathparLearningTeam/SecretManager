package com.mathpar.learning.secretmanager.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Profile("local")
public class ClasspathPropertiesProvider extends FilesystemPropertiesProvider {

    public ClasspathPropertiesProvider(@Value("${mathpar.secretmanager.properties-prefix:/var/properties}") String prefix,
                                       @Value("${mathpar.secretmanager.properties-suffix:.namespace}") String suffix) {
        super(prefix, suffix);
    }

    @Override
    protected String loadNamespace(String namespace) throws IOException {
        return new String(new ClassPathResource(prefix+"/"+namespace+suffix).getInputStream().readAllBytes());
    }
}
