import java.util.Scanner;

public class Session {
    /*
    answer: word to guess
    user_answer: user answer
    max_attempts: max attempts to guess word
    attemts: user attempts
     */

    private final String answer;
    private final char[] user_answer;
    private final int max_attempts;
    private int attempts;

    public Session(String answer, int max_attempts) {
        this.answer = answer;
        this.max_attempts = max_attempts;
        this.user_answer = new char[answer.length()];
        for (int i = 0; i < user_answer.length; i++) {
            user_answer[i] = '_';
        }
        this.attempts = 0;
    }


    GuessResult guess(char guess) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Guess a letter: ");
        String letter = scanner.nextLine();
    }

    GuessResult giveUp() {
        return null;
    }
}
