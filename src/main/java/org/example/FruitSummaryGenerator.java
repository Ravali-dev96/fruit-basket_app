package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FruitSummaryGenerator {
    public static void generateSummary(Path path) {

        if (path==null ||!Files.exists(path)) {
           System.err.println("File path doesn't exist");
            System.exit(1);
        }
        List<String> allLines=new ArrayList<>();
        try {
            allLines = Files.readAllLines(path);
        } catch (IOException e) {
           System.err.println("Something is wrong while reading the file");
           System.exit(1);
        }

        if(allLines.isEmpty()){
            System.err.println("File doesn't have data");
            System.exit(1);
        }
        String headerRow = allLines.get(0);
        String[] headerNames = headerRow.split(",");
        if (headerNames.length != 4) {
           System.err.println("The Size of HeaderLines must be 4");
            System.exit(1);
        }
        if (!"fruit-type".equals(headerNames[0]) || !"age-in-days".equals(headerNames[1]) ||
                !"characteristic1".equals(headerNames[2]) || !"characteristic2".equals(headerNames[3])) {
           System.err.println("File must contain 4 headers");
            System.exit(1);
        }
        int count=0;
        Map<String, Integer> distinctFruitsAndCount = new HashMap<>();
        Map<Fruit, Integer> fruitesByCharacterstics = new HashMap<>();

        int maxAge = Integer.MIN_VALUE;
        Set<String> fruitsWithMaxAge = new HashSet<>();
        for (int i = 1; i < allLines.size(); i++) {

            String valueRow = allLines.get(i);
            String[] valueNames = valueRow.split(",");

            if (valueNames.length != 4) {
               System.err.println("Number of columns in a row must be 4 "+valueRow);
                System.exit(1);
            }
            Fruit fruit = PrepareFruit( valueNames);
            count++;

            //Updates count in map
            distinctFruitsAndCount.merge(fruit.getFruitType(), 1, Integer::sum);
            fruitesByCharacterstics.merge(fruit,1, Integer::sum);

            //CALCULATING MAX AGE
            //case 1: if current fruit age is greater than the max
            if (fruit.getAgeInDays() > maxAge) {
                maxAge = fruit.getAgeInDays();
                fruitsWithMaxAge.clear();
                fruitsWithMaxAge.add(fruit.getFruitType());
            } else if (fruit.getAgeInDays() == maxAge) {
                {
                    //case 2: if current fruit age is equal to the max fruit
                    fruitsWithMaxAge.add(fruit.getFruitType());
                }
            }
        }

        System.out.println("Total number of fruit:\n" + count + "\n");
        System.out.println("Total types of fruit:\n" + distinctFruitsAndCount.size() + "\n");
        System.out.println("Oldest fruit & age:");

        for (String fruit : fruitsWithMaxAge) {
            System.out.println(fruit + ": " + maxAge);
        }
        System.out.println();
        System.out.println("The number of each type of fruit in descending order:");


        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(distinctFruitsAndCount.entrySet());
        entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for(Map.Entry<String,Integer> fruitType:entries){
            System.out.println(fruitType.getKey()+": "+fruitType.getValue());
        }
        System.out.println();


        System.out.println("The various characteristics (count, color, shape, etc.) of each fruit by type:");
        ArrayList<Map.Entry<Fruit, Integer>> fruitesByCharactersticsEntries = new ArrayList<>(fruitesByCharacterstics.entrySet());
        fruitesByCharactersticsEntries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for(Map.Entry<Fruit, Integer> entry:fruitesByCharactersticsEntries){
            Integer frequency = entry.getValue();
            Fruit fruit = entry.getKey();
            System.out.println( frequency+" "+fruit.getFruitType()+": "+fruit.getCharacteristic1()+", "+fruit.getCharacteristic2());
        }
        System.exit(0);
    }

    private static Fruit PrepareFruit( String[] valueNames) {
        Fruit fruit = new Fruit();
        fruit.setFruitType(valueNames[0]);
        fruit.setAgeInDays(Integer.parseInt(valueNames[1]));
        fruit.setCharacteristic1(valueNames[2]);
        fruit.setCharacteristic2(valueNames[3]);
        return fruit;
    }
}

