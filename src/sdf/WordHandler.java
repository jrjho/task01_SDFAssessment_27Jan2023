package sdf;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WordHandler {
    private int totalWordCount = 0;
    // private String word;
    private String wordFound;
    HashMap<String, Integer> words = new HashMap<>();

    public void compute(String wordFound) {
        // this.word = word;
        this.wordFound = wordFound;

        if (words.containsKey(wordFound)) {
            // if key exist, increase value by 1
            words.computeIfPresent(wordFound, (word, count) -> Integer.valueOf(count.intValue() + 1));
            totalWordCount += 1;

        } else {
            // if new key, set key value of map to 1
            words.computeIfAbsent(wordFound, word -> Integer.valueOf(1));
            totalWordCount += 1;
        }

    }
    //used for manual checking purpose
    public void eachWordCount() {
        words.forEach((word, count) -> System.out.println(words));
    }

    public void totalCount() {
        System.out.printf("Total word count: %d\n", totalWordCount);
    }


    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hashMap) {
        int count = 0;
        // Create a sorted list from input "words" hashmap
        List<Map.Entry<String, Integer>> sortedList = new LinkedList<Map.Entry<String, Integer>>(hashMap.entrySet());

        // Sort
        Collections.sort(sortedList, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> e1,
                    Map.Entry<String, Integer> e2) {
                return (e2.getValue()).compareTo(e1.getValue());
            }
        });

        // put data from sorted list->sorted hashmap
        HashMap<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        
        for (Map.Entry<String, Integer> i : sortedList) {
            sortedMap.put(i.getKey(), i.getValue());
            count +=1;
            if(count>=10)
                break;
        }
        return sortedMap;


    }

    public void getTopCount() {
        int count =0;
        float freq = 0;

        Map<String, Integer> sortedWords = sortByValue(words);
        System.out.println("The top 10 most freq words are:");

        for (Map.Entry<String, Integer> i : sortedWords.entrySet()) {
            freq = ((float)i.getValue())/totalWordCount;
            count +=1; 
            System.out.printf("%d) Word = %s, Count = %d, Freq = %.5f\n", (count), i.getKey() , i.getValue(),freq);
              
        }
    }

}
