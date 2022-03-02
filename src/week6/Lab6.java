package week6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Lab6 {

    static void q1(String file) throws FileNotFoundException
    {
        Scanner reader = new Scanner(new FileReader(file));

        Map<String, Integer> wordMap = new HashMap<>();
        String word;
        while(reader.hasNext())
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

//    static boolean q2(String file) throws FileNotFoundException
//    {
//        Scanner reader = new Scanner(new FileReader(file));
//
//        //create your hashset
//        while(reader.hasNext())
//        {
//            word = reader.next();
//            //Implement
//        }
//
//        reader.close();
//        return some bool;
//
//    }

    static void q3(String file) throws FileNotFoundException
    {
        Scanner reader = new Scanner(new FileReader(file));

        //create your other variables (sets, etc)

        int keyWordsCount = reader.nextInt();
        int excuseCount = reader.nextInt();

        // skip first line with numbers
        reader.nextLine();

        //read keywords
        for(int i = 0; i < keyWordsCount; i++)
        {
            //read keywords e.g. datatype.add(reader.nextLine())
        }

        //evaluate excuses
        for(int i = 0; i < excuseCount; i++)
        {
            String excuse = reader.nextLine();
            String excuseWords[] = excuse.split(" ");

            //Implement
        }

        //Print max excuses

        reader.close();

    }


    public static void main(String[] args) throws FileNotFoundException
    {
        q1("love.txt");
//        System.out.println(q2("q2input.txt"));
//        q3("q3test.txt");
    }

}
