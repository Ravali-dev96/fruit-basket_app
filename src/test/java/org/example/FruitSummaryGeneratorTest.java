package org.example;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class FruitSummaryGeneratorTest {

    @org.junit.jupiter.api.Test
    void generateSummary() throws URISyntaxException {
        URL resource = FruitSummaryGenerator.class.getClassLoader().getResource("fruits.csv");
        FruitSummaryGenerator.generateSummary(Paths.get(resource.toURI()));
    }

}