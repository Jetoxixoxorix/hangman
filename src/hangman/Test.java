package hangman;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("Please type length of word: ");
        int lengthOfWord = in.nextInt();

        WordsSearch wordsSearch = new WordsSearch();
        List<String> words = wordsSearch.searchingForWords(lengthOfWord);

        for(int i = 0; i < words.size(); i++){
            System.out.println(words.get(i));
        }

    }
}
