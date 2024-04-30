import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import java.io.FileWriter;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        String train_csv = "C:\\Users\\Lenovo\\OneDrive\\Desktop\\Projects\\java_project\\Sentiment Analysis\\train_data1.csv";
        HashMap<String, Integer> Vocab = new HashMap();
        Vocab = getVocab(train_csv);
        ArrayList<Integer> counts = new ArrayList<>();
        counts = getCounts(train_csv);
        HashMap<String, ArrayList<Double>> hm = new HashMap<>();
        hm = getDict(train_csv, Vocab, counts);
        System.out.println(hm);

        String csvFile = "probabilities.csv";
        try (FileWriter writer = new FileWriter(csvFile)) {
            writer.append("Token, Positive, Negative\n");
            for (Map.Entry<String, ArrayList<Double>> entry : hm.entrySet()) {
                String key = entry.getKey();
                ArrayList<Double> values = entry.getValue();
                writer.append(key).append(",");
                for (Double value : values) {
                    writer.append(value.toString()).append(",");
                }
                writer.append("\n");
            }

            System.out.println("CSV file '" + csvFile + "' has been created successfully!");
        } catch (IOException e) {
            System.err.println("Error writing to CSV file: " + e.getMessage());
        }

        String test_csv = "C:\\Users\\Lenovo\\OneDrive\\Desktop\\Projects\\java_project\\Sentiment Analysis\\test_data1.csv";
        test obj = new test();
        ArrayList<String> testResults = new ArrayList<>();
        ArrayList<String> actualSentiments = new ArrayList<>();
        testResults = obj.process(test_csv, hm);
        actualSentiments = obj.getActual(test_csv);
        int matched = 0;
        int finalprogressbar = 0;
        if (testResults.size()==actualSentiments.size()){
            for (int i=0; i<testResults.size(); i++){
                finalprogressbar++;
                if (testResults.get(i).equals(actualSentiments.get(i))){
                    matched++;
                }
                if (finalprogressbar % 100 == 0){
                    System.out.println("Comparing with actual line: "+ finalprogressbar + " / " + actualSentiments.size());
                }
            }
        }
        else{
            System.out.println("Length mismatched!! Please check");
        }
        Double accuracy = (double) matched/testResults.size();
        System.out.println("The accuracy is: "+ (accuracy)*100+" %");
    }

    public static HashMap<String, Integer> getVocab(String path) {
        System.out.println("Building Vocab");
        HashMap<String, Integer> vocabulary = new HashMap();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                line = line.toLowerCase();
                String cleanLine = removePunctuation(line);
                StringTokenizer tokenizer =  new StringTokenizer(cleanLine);
                while (tokenizer.hasMoreTokens()) {
                    String token = tokenizer.nextToken().trim();
                    if (!token.isEmpty() && !vocabulary.containsKey(token) && token.length()>1) {
                        i++;
                        vocabulary.put(token, i);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }
        return vocabulary;
    }

    public static ArrayList<Integer> getCounts(String filepath){
        int posCount = 0;
        int negCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.toLowerCase();
                int lastCommaIndex = line.lastIndexOf(",");
                if (lastCommaIndex != -1 && lastCommaIndex < line.length() - 1) {
                    String textAfterComma = line.substring(lastCommaIndex + 1);
                    if (textAfterComma.trim().equals("positive")){
                        posCount++;
                    }
                    else if (textAfterComma.trim().equals("negative")){
                        negCount ++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int total = posCount + negCount;
        ArrayList<Integer> content = new ArrayList<>();
        content.add(posCount);
        content.add(negCount);
        content.add(total);
        return content;
    }

    
    public static String removePunctuation(String text) {
        StringBuilder cleanText = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isLetterOrDigit(ch) || Character.isWhitespace(ch)) {
                cleanText.append(ch);
            }
            else{
                cleanText.append(" ");
            }
        }
        return cleanText.toString();
    }


    public static HashMap<String, ArrayList<Double>> getDict(String path, HashMap<String, Integer> vocab, ArrayList<Integer> countarr){
        HashMap<String, ArrayList<Double>> dict = new HashMap<>();
        int progress = 0;
        for (String word : vocab.keySet()){
            progress++;
            int poscount = 0;
            int negcount = 0;
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                String line;
                while ((line = br.readLine()) != null) {
                    line = line.toLowerCase();
                    int num = isWordInString(line, word);
                    if (num==1){
                        poscount++;
                    }else if (num==-1){
                        negcount++;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            ArrayList<Double> arr = new ArrayList<>();
            double posres = (double) poscount/countarr.get(0);
            double negres = (double) negcount/countarr.get(1);
            arr.add(posres);
            arr.add(negres);
            dict.put(word, arr);
            if (progress%100 == 0){
                System.out.println("Calculating Probability: progress: "+ progress+ " / "+ vocab.size());
            }
        }
        return dict;
    }

    public static int isWordInString(String inputString, String wordToFind) {
        inputString = inputString.toLowerCase();
        wordToFind = wordToFind.toLowerCase();
        if (inputString.contains(wordToFind)){
            return getType(inputString);
        }
        return 0;
    }

    public static int getType(String inputString){
        String line = inputString.toLowerCase();
        int lastCommaIndex = line.lastIndexOf(",");
        if (lastCommaIndex != -1 && lastCommaIndex < line.length() - 1) {
            String textAfterComma = line.substring(lastCommaIndex + 1);
            if (textAfterComma.trim().equals("positive")){
                return 1;
            }
            return -1;
        }
        return 0;
    }
}


class test {
    public ArrayList<String> process(String path, HashMap<String, ArrayList<Double>> hm){
        ArrayList<String> result = new ArrayList<>();
        int progressvar = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            Double posScore = 1.0;
            Double negScore = 1.0;
            while ((line = br.readLine()) != null) {
                progressvar ++;
                line = line.toLowerCase();
                String cleanLine = removePunctuation(line);
                StringTokenizer tokenizer = new StringTokenizer(cleanLine);
                while (tokenizer.hasMoreTokens()) {
                    String token = tokenizer.nextToken().trim();
                    if (hm.containsKey(token)){
                        ArrayList<Double> values = hm.get(token);
                        if (values.get(0)!=0.0){
                            posScore = posScore*values.get(0);
                        }
                        if (values.get(1)!=0.0){
                            negScore = negScore*values.get(1);
                        }
                    }
                }
                if (posScore>=negScore){
                    result.add("positive");
                }
                else{
                    result.add("negative");
                }
                if (progressvar%100 == 0){
                    System.out.println("Calculating Testing Probability for: "+ progressvar+ " row.");
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }
        return result;
    }

    public ArrayList<String> getActual(String path){
        ArrayList<String> actual = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.toLowerCase();
                int lastCommaIndex = line.lastIndexOf(",");
                if (lastCommaIndex != -1 && lastCommaIndex < line.length() - 1) {
                    String textAfterComma = line.substring(lastCommaIndex + 1);
                    if (textAfterComma.trim().equals("positive")){
                        actual.add("positive");
                    }
                    else if (textAfterComma.trim().equals("negative")){
                        actual.add("negative");
                    }
                    else{
                        actual.add("None");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return actual;
    }
    public static String removePunctuation(String text) {
        StringBuilder cleanText = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isLetterOrDigit(ch) || Character.isWhitespace(ch)) {
                cleanText.append(ch);
            }
            else{
                cleanText.append(" ");
            }
        }
        return cleanText.toString();
    }
}

