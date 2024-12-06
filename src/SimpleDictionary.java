import java.util.Random;
import java.util.List;
import java.util.Arrays;

class SimpleDictionary implements Dictionary {
    public String randomWord() {
        List<String> words = Arrays.asList(
                "apple", "banana", "cherry", "date", "elderberry",
                "fig", "grape", "honeydew"
        );
        Random random = new Random();
        int randomIndex = random.nextInt(words.size());
        return words.get(randomIndex);
    }
}
