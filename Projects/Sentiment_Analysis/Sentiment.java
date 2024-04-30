
// Main.java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import edu.stanford.nlp.simple.Document;
import edu.stanford.nlp.simple.Sentence;
import edu.stanford.nlp.simple.SentimentClass;


public class Sentiment {
    public static void main(String[] args) {
        String datasetPath = "C:\\Users\\Animesh\\Documents\\JAVA\\IMDB Dataset.csv";

        // Load the dataset
        // Assuming each line in the dataset contains a review followed by the actual sentiment label (0 or 1)
        // Modify this part based on your actual dataset format

        int totalReviews = 0;
        int correctPredictions = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(datasetPath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split(",");
                String review = parts[0]; // Assuming review is in the first column
                int actualSentiment = parts[1].equalsIgnoreCase("positive") ? 1 : 0; // Assuming sentiment label is in the second column

                // Perform sentiment analysis using MachineLearningSentimentAnalyzer
                int mlSentiment = MachineLearningSentimentAnalyzer.analyzeSentiment(review);

                // Compare predicted sentiment with actual sentiment
                int predictedSentiment = mlSentiment; // Convert SentimentClass to integer (0 or 1)
                if (predictedSentiment == actualSentiment) {
                    correctPredictions++;
                }
                totalReviews++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Calculate accuracy
        double accuracy = (double) correctPredictions / totalReviews * 100;
        System.out.println("Accuracy: " + accuracy + "%");
    }
}



class MachineLearningSentimentAnalyzer {
    public static int analyzeSentiment(String review) {
        // Use Stanford NLP's pre-trained sentiment analysis model
        Document doc = new Document(review);
        Sentence sentence = doc.sentences().get(0);
        SentimentClass sentimentLabel = sentence.sentiment();

        // Map SentimentClass to "Positive" or "Negative"
        if (sentimentLabel == SentimentClass.POSITIVE) {
            return 1;
        } else {
            return 0;
        }
    }
}

