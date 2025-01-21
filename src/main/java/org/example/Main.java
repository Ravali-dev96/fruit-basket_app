package org.example;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 */
public class Main {
    public static void main(String[] args) {

        if(args.length==0){
            System.err.println("Please provide the file name");
            System.exit(1);
        }
        String fileLocation=args[0];
        if(fileLocation==null ||"".equals(fileLocation)){
           System.err.println("Please provide valid file location");
            System.exit(1);
        }
        Path path = Paths.get(fileLocation);
       FruitSummaryGenerator.generateSummary(path);
    }
}