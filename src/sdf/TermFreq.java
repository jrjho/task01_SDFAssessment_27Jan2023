package sdf;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TermFreq {

    public static void main(String[] args) {

        // HashMap<String, Integer> words = new HashMap<>();
        Path filePath = Paths.get("./textfile/cat_in_the_hat.txt");
        File file = filePath.toFile();
        // int totalWordCount = 0;

        if (!file.exists()) {
            System.err.println("Cannot find file");
            System.exit(1);
        }

        try {

            String textContent = Files.readString(filePath);
            textContent = textContent.toLowerCase();

            // consider only between A-Z and a-z. Ignore all other characters
            Pattern pattern = Pattern.compile("[A-Za-z]+");
            Matcher matcher = pattern.matcher(textContent);

            
            // System.out.println(textContent);
            WordHandler wh = new WordHandler();

            while (matcher.find()) {
                String wordFound = matcher.group();
                wh.compute(wordFound);
            }
            // wh.eachWordCount();
            wh.totalCount();
            wh.getTopCount();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}