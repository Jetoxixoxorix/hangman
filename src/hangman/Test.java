package hangman;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("Please type length of word: ");
        int lengthOfWord = in.nextInt();


        List<String> words = WordsSearch.searchingForWords(lengthOfWord);

/*        while(in.hasNext()){
            System.out.println(in.nextLine());
        }*/

    }
}
