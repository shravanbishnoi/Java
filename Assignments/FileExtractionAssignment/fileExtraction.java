import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class fileExtraction {
    public static void main(String[] args) {
        processText obj = new processText();
        if (args.length>0){
            String myDir = args[0];
            obj.processtext(myDir);
        }
        else{
            System.out.println("Please provide dir path as input!!");
        }
        // String myDir = "C:\\Users\\Shravan Bishnoi\\OneDrive\\Desktop\\JAVA\\Projects\\FileExtractionAssignment\\demofiles";
        
    }
}


class processText {
    public void processtext(String directoryPath) {
        File dir = new File(directoryPath);
        if (!dir.isDirectory()) {
            System.out.println("Provided path is not a directory.");}

        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("Error occurred");}

        System.out.println("Total number of files in directory: " + files.length);

        try{
            for (File file : files) {
                if (file.isFile()) {
                    displayFileContent(file);
                }
            }
            System.out.println("");
            System.out.println("");
            System.out.println("------------------PRINTING UPDATED CONTENT WITHOUT ANY STOPWORDS:-----------------");

            System.out.println("");
            System.out.println("");
            for (File file : files) {
                if (file.isFile()) {
                    displayUpdatedContent(file);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void displayFileContent(File file) throws IOException {
        System.out.println("Reading content from file: " + file.getName());

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            // Initiating a hashmap for storing word frequency
            HashMap<String, Integer> wordFrequencyMap = new HashMap<String, Integer>();
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                processLine(line, wordFrequencyMap);
            }
            System.out.println("Number of words in the File "+ file+" are: "+ wordFrequencyMap.size());
            System.out.println("Words in the File "+ file+" are: "+ wordFrequencyMap);
        }

        System.out.println();
    }

    private static void processLine(String line, HashMap<String, Integer> wordFrequencyMap) {
        // Splitting text using Regular Expression and calculating word frequency
        String[] words = line.split("[^a-zA-Z]+");
        for (String word : words) {
            if (!word.isEmpty()) {
                word = word.toLowerCase();
                wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
            }
        }
    }

    private static void displayUpdatedContent(File file) throws IOException {
        System.out.println("Reading content from file: " + file.getName());

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            String content = "";
            while ((line = reader.readLine()) != null) {
                String tempText = processUpdatedContent(line);
                content += "\n"+ tempText;
            }
            System.out.println(content);
        }
    }

    private static String processUpdatedContent(String line) {
        // Stops words that I will remove from text, if occurs
        String[] stopWordsArray = {
            "a", "an", "am", "and", "are", "as", "at", "for", "from", "has", "have",
            "in", "is", "it", "of", "on", "the", "to", "with"};

        // Splitting with space and removing stopwords
        String[] words = line.split(" ");
        String lineContent = "";
        for (String word : words) {
            if (!word.isEmpty()) {
                String oriWord = word;
                word = word.toLowerCase();
                if (Arrays.asList(stopWordsArray).contains(word)){
                    continue;
                }
                else{
                    lineContent += " " + oriWord; 
                }
            }
        }
        return lineContent;
    }
}


/* 
Here is the shell script file.
#!/bin/bash

# Java class name
javaClass="fileExtraction"

# Java directory path
directoryPath="/home/shravan/Java/FileExtractionAssignment/FileExtractionAssignment/demofiles"

# Compile Java program
javac $javaClass.java

# Runs the specified java program
java $javaClass $directoryPath


*/