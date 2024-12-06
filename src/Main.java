public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new SimpleDictionary();
        ConsoleHangman game = new ConsoleHangman(dictionary);
        game.run();
    }
}