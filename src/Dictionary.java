import java.util.Random;
import java.util.List;
import java.util.Arrays;


public class Dictionary {
    public static String random_word() {
        /*
        Generates random word from array
         */

        List<String> words = Arrays.asList(
                "apple", "banana", "cherry", "date", "elderberry",
                "fig", "grape", "honeydew"
        );
        Random random = new Random();
        int random_index = random.nextInt(words.size());
        String randomWord = words.get(random_index);
        return randomWord;
    }
}
