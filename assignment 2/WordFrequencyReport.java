import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class WordFrequencyReport {

    public static void printFilteredWordFrequency(String feedback) {

        // Convert to lowercase
        feedback = feedback.toLowerCase();

        // Remove punctuation
        feedback = feedback.replace(".", "");
        feedback = feedback.replace(",", "");


        // Stop words
        String[] stopWords = {
                "the", "was", "and",
                "a", "is", "of", "in"
        };


        // Split into words
        String[] words = feedback.split("\\s+");


        // HashMap to store word counts
        HashMap<String, Integer> wordCount =
                new HashMap<>();


        // Go through every word
        for (String word : words) {

            boolean isStopWord = false;


            // Check whether word is a stop word
            for (String stopWord : stopWords) {

                if (word.equals(stopWord)) {
                    isStopWord = true;
                    break;
                }
            }


            // If it is not a stop word
            if (!isStopWord) {

                if (wordCount.containsKey(word)) {

                    wordCount.put(
                            word,
                            wordCount.get(word) + 1
                    );

                } else {

                    wordCount.put(word, 1);
                }
            }
        }


        // Convert map entries to a list
        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(wordCount.entrySet());


        // Sort manually in descending order
        for (int i = 0; i < list.size(); i++) {

            for (int j = i + 1; j < list.size(); j++) {

                if (list.get(i).getValue()
                        < list.get(j).getValue()) {

                    Map.Entry<String, Integer> temp =
                            list.get(i);

                    list.set(i, list.get(j));

                    list.set(j, temp);
                }
            }
        }


        // Print the result
        for (Map.Entry<String, Integer> entry : list) {

            System.out.println(
                    entry.getKey()
                    + ": "
                    + entry.getValue()
            );
        }
    }


    public static void main(String[] args) {

        String feedback =
                "The mentor was great, the session was great and clear.";

        printFilteredWordFrequency(feedback);
    }
}