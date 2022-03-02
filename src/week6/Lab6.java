package week6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

import static java.util.Map.Entry.comparingByValue;

public class Lab6 {

    static void q1(final String file) throws FileNotFoundException
    {
        Scanner reader = new Scanner(new FileReader(file));

        Map<String, Integer> wordMap = new HashMap<>();
        String word;
        while (reader.hasNext())
        {
            word = reader.next();
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            } else {
                wordMap.put(word, 0);
            }
        }

        wordMap.forEach((key, value) -> System.out.println(key + " - " + value));

        reader.close();
    }

    static boolean q2(String file) throws FileNotFoundException
    {
        Scanner reader = new Scanner(new FileReader(file));

        HashSet<String> wordSet = new HashSet<>();

        String word;
        while (reader.hasNext())
        {
            word = reader.next();
            if (wordSet.contains(word)) {
                return false;
            } else {
                wordSet.add(word);
            }
        }
        reader.close();
        return true;
    }

    static void q3(String file) throws FileNotFoundException
    {
        Scanner reader = new Scanner(new FileReader(file));

        //create your other variables (sets, etc)
        HashSet<String> keywords = new HashSet<>();
        Map<String, Long> excusesKeywordOccurrence = new HashMap<>();

        int keyWordsCount = reader.nextInt();
        int excuseCount = reader.nextInt();

        // skip first line with numbers
        reader.nextLine();

        //read keywords
        for(int i = 0; i < keyWordsCount; i++)
        {
            keywords.add(reader.nextLine());
            //read keywords e.g. datatype.add(reader.nextLine())
        }
        System.out.println(keywords);

        //evaluate excuses
        long keywordOccurrence;

        for(int i = 0; i < excuseCount; i++)
        {
            String excuse = reader.nextLine();
            String excuseWords[] = excuse.split(" ");
            keywordOccurrence = Arrays.stream(excuseWords).filter(keywords::contains).count();
            if (!excusesKeywordOccurrence.containsKey(excuse)) {
                excusesKeywordOccurrence.put(excuse, keywordOccurrence);
            }
        }

        System.out.println(excusesKeywordOccurrence);

        ArrayList<String> worstExcuses = new ArrayList<>();
        long maxOccurrence = Collections.max(excusesKeywordOccurrence.values());
        System.out.println(maxOccurrence);

        excusesKeywordOccurrence
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .filter(e -> e.getValue() >= maxOccurrence)
                .forEach(e -> System.out.println(e.getKey()));

        reader.close();

    }


    public static void main(String[] args) throws FileNotFoundException
    {
//        q1("love.txt");
//        q1("q2input.txt");
//        System.out.println(q2("q2input_distinct.txt"));
        q3("q3test.txt");
    }

}
