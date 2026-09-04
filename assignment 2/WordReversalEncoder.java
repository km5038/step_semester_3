public class WordReversalEncoder {

    public static String reverseEachWord(String sentence) {

        String[] words = sentence.split(" ");

        String result = "";

        for (int i = 0; i < words.length; i++) {

            StringBuilder reversedWord =
                    new StringBuilder(words[i]);

            reversedWord.reverse();

            result = result + reversedWord;

            if (i != words.length - 1) {
                result = result + " ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        String answer = reverseEachWord("hello club");

        System.out.println(answer);
    }
}