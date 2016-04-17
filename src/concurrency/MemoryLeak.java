package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Random;

public class MemoryLeak {
    // Generates long lines of gibberish words.
    static class GibberishGenerator implements Iterator<String>
    {
        private int MAX_WORD_LENGTH = 20;
        private int WORDS_PER_LINE = 500000;
        private String alphabet = ("abcdefghijklmnopqrstuvwxyz" +
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ");

        public boolean hasNext() {
            return true;
        }

        public String next() {
            StringBuffer result = new StringBuffer();
            for (int i = 0; i < WORDS_PER_LINE; i++) {
                if (i > 0) { result.append(" "); }
                result.append(generateWord(MAX_WORD_LENGTH));
            }

            return result.toString();
        }

        public void remove() {
            // not implemented
        }


        private String generateWord(int maxLength) {
            int length = (int)(Math.random() * (maxLength - 1)) + 1;
            StringBuffer result = new StringBuffer(length);
            Random r = new Random();

            for (int i = 0; i < length; i++) {
                result.append(alphabet.charAt(r.nextInt(alphabet.length())));
            }

            return result.toString();
        }
    }


    // A "good" word has as many vowels as consonants and is more than two
    // letters long.
    private static String vowels = "aeiouAEIOU";

    private static boolean isGoodWord(String word) {
        int vowelCount = 0;
        int consonantCount = 0;

        for (int i = 0; i < word.length(); i++) {
            if (vowels.indexOf(word.charAt(i)) >= 0) {
                vowelCount++;
            } else {
                consonantCount++;
            }
        }

        return (vowelCount > 2 && vowelCount == consonantCount);
    }


    public static void main(String[] args) {
        GibberishGenerator g = new GibberishGenerator();
        List<String> goodWords = new ArrayList<String>();

        for (int i = 0; i < 1000; i++) {
            String line = g.next();
            for (String word : line.split(" ")) {
                if (isGoodWord(word)) {
                    goodWords.add(word);

                    System.out.println("Found a good word: " + word);
                    break;
                }
            }
        }
    }
}