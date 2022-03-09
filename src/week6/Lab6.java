package week6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;


/**
 * COMP3761 lab 6.
 *
 * @author Jonghoon Jang
 * @version Feb, 2022
 */
public final class Lab6 {

    private Lab6() {
    }

    /**
     * Find the number of times each word appears in the file.
     *
     * @param file a string representing the name of the file
     * @throws FileNotFoundException if the file is not found
     */
    static void q1(final String file) throws FileNotFoundException {
        Scanner reader = new Scanner(new FileReader(file));

        Map<String, Integer> wordMap = new HashMap<>();
        String word;

        // map song word and its occurrence
        while (reader.hasNext()) {
            word = reader.next().toLowerCase(Locale.ROOT);
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            } else {
                wordMap.put(word, 1);
            }
        }

        // print the output in alphabetical order
        wordMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));

        reader.close();
    }


    /**
     * Determine if all the words in a file are distinct.
     *
     * @param file a string representing the name of the file
     * @return true if all the words are distinct, else false as boolean
     * @throws FileNotFoundException if the file is not found
     */
    static boolean q2(final String file) throws FileNotFoundException {
        Scanner reader = new Scanner(new FileReader(file));

        HashSet<String> wordSet = new HashSet<>();

        String word;
        while (reader.hasNext()) {
            word = reader.next();
            if (wordSet.contains(word)) {
                System.out.print("NOT DISTINCT - return value: ");
                return false;
            } else {
                wordSet.add(word);
            }
        }
        reader.close();
        System.out.print("DISTINCT - return value: ");
        return true;
    }


    /**
     * Find the worst excuse(s) containing the largest number of keywords.
     *
     * @param file a string representing the name of the file
     * @throws FileNotFoundException if the file is not found
     */
    static void q3(final String file) throws FileNotFoundException {
        Scanner reader = new Scanner(new FileReader(file));

        HashSet<String> keywords = new HashSet<>();
        Map<String, Long> excusesKeywordOccurrence = new HashMap<>();

        // reads the number of keywords and excuses.
        int keyWordsCount = reader.nextInt();
        int excuseCount = reader.nextInt();

        // skip first line with numbers
        reader.nextLine();

        //read keywords
        for (int i = 0; i < keyWordsCount; i++) {
            keywords.add(reader.nextLine());
        }

        //evaluate excuses
        long keywordOccurrence;

        for (int i = 0; i < excuseCount; i++) {
            String excuse = reader.nextLine();
            String[] excuseWords = excuse.split(" ");

            // count the occurrence of the keywords and add insert into hashMap
            keywordOccurrence = Arrays.stream(excuseWords).filter(keywords::contains).count();
            if (!excusesKeywordOccurrence.containsKey(excuse)) {
                excusesKeywordOccurrence.put(excuse, keywordOccurrence);
            }
        }

        // find the maximum of occurrence
        long maxOccurrence = Collections.max(excusesKeywordOccurrence.values());

        // print worst excuse(s)
        excusesKeywordOccurrence
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .filter(e -> e.getValue() >= maxOccurrence)
                .forEach(e -> System.out.println(e.getKey()));

        reader.close();
    }


    /**
     * Run the simple tests.
     *
     * @param args unused
     * @throws FileNotFoundException if the file is not found
     */
    public static void main(final String[] args) throws FileNotFoundException {
//        q1("love.txt");
        System.out.println(q2("q2input.txt"));
//        q3("q3test.txt");
    }

}
