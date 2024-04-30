import pandas as pd
from vaderSentiment.vaderSentiment import SentimentIntensityAnalyzer

df = pd.read_csv("C:/Users/Animesh/Downloads/archive (6)/IMDB Dataset.csv")

df = df.head(1000)

analyzer = SentimentIntensityAnalyzer()

df['vader_sentiment'] = df['review'].apply(lambda x: analyzer.polarity_scores(x)['compound'])

df['predicted_vader_label'] = df['vader_sentiment'].apply(lambda score: 1 if score > 0 else 0)

actual_labels = df['sentiment'].map({'positive': 1, 'negative': 0})

matching_count_vader = sum(df['predicted_vader_label'] == actual_labels)
total_reviews = len(df)
accuracy_vader = (matching_count_vader / total_reviews) * 100

print(f"VADER Sentimeent analysis tool Accuracy: {accuracy_vader:.2f}%")