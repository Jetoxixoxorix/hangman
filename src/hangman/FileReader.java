package hangman;

import java.io.File;
import java.io.FileNotFoundException;

public class FileReader implements FileGiver {

    @Override
    public File getFileName() throws FileNotFoundException {
        File words = new File("TextFile/words.txt");
        return words;
    }
}
