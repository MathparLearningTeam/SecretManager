package com.mathpar.learning.secretmanager;

import org.apache.catalina.startup.Tomcat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class EmbeddedTomcatRunner {
    public static void main(String[] args) throws Exception{
        String appBase = ".";
        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir(createTempDir());
        tomcat.setPort(8095);
        tomcat.getHost().setAppBase(appBase);
        tomcat.addWebapp("", appBase);
        tomcat.start();
        tomcat.getConnector();
        tomcat.getServer().await();
    }

    private static String createTempDir() {
        try {
            Path path = Files.createTempDirectory("tomcat.8080");
            path.toFile().deleteOnExit();
            return path.toAbsolutePath().toString();
        } catch (IOException ex) {
            throw new RuntimeException(
                    "Unable to create tempDir. java.io.tmpdir is set to " + System.getProperty("java.io.tmpdir"),
                    ex
            );
        }
    }
}
