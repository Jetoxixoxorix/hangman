package hangman;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Test {
    private static boolean playing;
    private static int errorsNumber;
    public static void main(String[] args) throws FileNotFoundException {
        playing = true;

        while (playing) {
            startingProgram();
        }

        System.out.println("Thank you.");

    }

    private static void playingGame(int lengthOfWord){ //, int errorsNumber
        WordsSearch wordsSearch = new WordsSearch();
        String word = wordsSearch.choosingWord(lengthOfWord);
        StringBuilder playerWord = new StringBuilder();
        for(int i = 0; i < word.length(); i++){
            playerWord.append("_");
        }

        System.out.println("Word was chosen.");

        while (!playerWord.toString().equals(word) && errorsNumber >= 0){ //|| errorsNumber >= 0
            System.out.println("Your word is: " + playerWord);
            System.out.println("You can do " + errorsNumber + " more errors.");
            choosingLetter(word, playerWord); //, errorsNumber
        }

        if(playerWord.toString().equals(word)){
            System.out.println("The word is " + word + "! You win.");
        }

        else {
            System.out.println("The word is " + word + "! You lose.");
        }

/*        System.out.println(word);
        System.out.println(playerWord);*/
    }

    private static int errorDiff(){ //int errorsNumber
        return errorsNumber--;
    }

    public static void choosingLetter(String word, StringBuilder playerWord){ //, int errorsNumber
        Scanner in = new Scanner(System.in);
        System.out.println("Please select a letter:");
        String letter = in.nextLine();
        if(letter.length() > 1){
            System.out.println("To many letters! Please try again.");
            choosingLetter(word, playerWord); //, errorsNumber
        }
        else if(letter.length() == 0){
            System.out.println("You didn't choose any letter! Please try again.");
            choosingLetter(word, playerWord); //, errorsNumber
        }
        else {
            char c = letter.charAt(0);
            if(Character.isLetter(c)){
                characterSearch(c, word, playerWord); //, errorsNumber)
            }
            else{
                System.out.println("Wrong input. Try again.");
                choosingLetter(word, playerWord); //, errorsNumber
            }
        }
    }

    public static StringBuilder characterSearch(char c, String word, StringBuilder playerWord){ //, int errorNumber
        int numberOfHits = 0;
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == c){
                playerWord = playerWord.replace(i, i + 1, String.valueOf(c));
                numberOfHits++;
            }
        }

        if(numberOfHits == 0){
           errorDiff(); //errorsNumbererrorsNumber
        }

        return playerWord;
    }

    public static void startingGame(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please, choose length of the word!");
        int lengthOfWord = in.nextInt();
        System.out.println("Please, choose number of errors you can make!");
        errorsNumber = in.nextInt();
        playingGame(lengthOfWord); //, errorsNumber
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
