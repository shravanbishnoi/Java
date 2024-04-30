import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class testmain {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Double>> hm = new HashMap<>();
        String line;
        String csvSplitBy = ",";
        String csvFile = "C:\\Users\\Lenovo\\OneDrive\\Desktop\\Projects\\java_project\\Sentiment Analysis\\probabilities.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(csvSplitBy);
                if (tokens.length >= 3) {
                    String key = tokens[0].trim();
                    Double positive = Double.parseDouble(tokens[1]);
                    Double negative = Double.parseDouble(tokens[2]);

                    ArrayList<Double> values = new ArrayList<>();
                    values.add(positive);
                    values.add(negative);
                    hm.put(key, values);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
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
        System.out.println("The accuracy is: "+ (accuracy)*100 + " %");
    }
}

class test {
    public ArrayList<String> process(String path, HashMap<String, ArrayList<Double>> hm){
        ArrayList<String> result = new ArrayList<>();
        int progressvar = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            
            while ((line = br.readLine()) != null) {
                Double posScore = 0.0;
                Double negScore = 0.0;
                progressvar ++;
                line = line.toLowerCase();
                String cleanLine = removePunctuation(line);
                StringTokenizer tokenizer = new StringTokenizer(cleanLine);
                while (tokenizer.hasMoreTokens()) {
                    String token = tokenizer.nextToken().trim();
                    if (hm.containsKey(token)){
                        ArrayList<Double> values = hm.get(token);
                        if (values.get(0)!= 0){
                            posScore = posScore + values.get(0);
                        }
                        if (values.get(1) != 0){
                            negScore = negScore + values.get(1);
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
        }
        return cleanText.toString();
    }
}