import java.util.Scanner;

class ConsoleHangman {
    private final Dictionary dictionary;
    private final Scanner scanner;

    public ConsoleHangman(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        String wordToGuess = dictionary.randomWord();
        Session session = new Session(wordToGuess, wordToGuess.length());

        while (true) {
            System.out.print("Guess a letter: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("give up")) {
                GuessResult result = session.giveUp();
                printState(result);
                break;
            }

            if (input.length() != 1) {
                System.out.println("Please enter a single letter.");
                continue;
            }

            char guess = input.charAt(0);
            GuessResult result = session.guess(guess);
            printState(result);

            if (result instanceof GuessResult.Win || result instanceof GuessResult.Defeat) {
                break;
            }
        }
    }

    private void printState(GuessResult guess) {
        System.out.println(guess.message());
        System.out.println("Current state: " + new String(guess.state()));
        System.out.println("Mistakes: " + guess.attempt() + "/" + guess.maxAttempts() + "\n");
    }
}