package hangman;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Test {
    private static boolean playing;
    public static void main(String[] args) throws FileNotFoundException {
        playing = true;

        while (playing) {
            startingProgram();
        }

        System.out.println("Thank you.");

    }

    private static void playingGame(int lengthOfWord, int errorsNumber){
        WordsSearch wordsSearch = new WordsSearch();
        String word = wordsSearch.choosingWord(lengthOfWord);
        StringBuilder playerWord = new StringBuilder();
        for(int i = 0; i < word.length(); i++){
            playerWord.append("_");
        }

        System.out.println("Word was chosen.");

        while (!playerWord.toString().equals(word)){ //|| errorsNumber >= 0
            System.out.println("Your word is: " + playerWord);
            choosingLetter(word, playerWord);
        }

        if(playerWord.toString().equals(word)){
            System.out.println("The word is " + word + "! You win.");
        }

/*        System.out.println(word);
        System.out.println(playerWord);*/
    }

    public static void  choosingLetter(String word, StringBuilder playerWord){
        Scanner in = new Scanner(System.in);
        System.out.println("Please select a letter:");
        String letter = in.nextLine();
        if(letter.length() > 1){
            System.out.println("To many letters! Please try again.");
            choosingLetter(word, playerWord);
        }
        else if(letter.length() == 0){
            System.out.println("You didn't choose any letter! Please try again.");
            choosingLetter(word, playerWord);
        }
        else {
            char c = letter.charAt(0);
            if(Character.isLetter(c)){
                characterSearch(c, word, playerWord);
            }
            else{
                System.out.println("Wrong input. Try again");
                choosingLetter(word, playerWord);
            }
        }
    }

    public static StringBuilder characterSearch(char c, String word, StringBuilder playerWord){
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == c){
                playerWord = playerWord.replace(i, i + 1, String.valueOf(c));
            }
        }

        return playerWord;
    }

    public static void startingGame(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please, choose length of the word!");
        int lengthOfWord = in.nextInt();
        System.out.println("Please, choose number of errors you can make!");
        int errorsNumber = in.nextInt();
        playingGame(lengthOfWord, errorsNumber);
    }

    private static boolean startingProgram(){
        Scanner in = new Scanner(System.in);
        System.out.println("What are you want to do? Write 'p' if you want to play, or 'q' if you want to exit.");
        String decision = in.nextLine();

        switch (decision.toLowerCase()){
            case "p":
                playing = true;
                startingGame();
                break;
            case "q":
                playing = false;
                break;
            default:
                System.out.println("There is no such command. Please choose again.");
                playing = true;
                break;
        }

        return playing;
    }
}
