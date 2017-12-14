package hangman;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordsSearch {
    FileReader fileReader = new FileReader();

    Scanner in;

    {
        try {
            in = new Scanner(fileReader.getFileName());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<String> searchingForWords(int lengthOfWord){
        List<String> words = new ArrayList<>();

        return words;
    }
}
