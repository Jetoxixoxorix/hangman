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

    public List<String> searchingForWords(int lengthOfWord){
        List<String> words = new ArrayList<>();
        String word = "";
        while (in.hasNext()){
            word = in.nextLine();
            if (word.length() == lengthOfWord)
                words.add(word);
        }

        return words;
    }
}
