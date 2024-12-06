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
        boolean found = false;

        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == guess) {
                user_answer[i] = guess;
                found = true;
            }
        }
        attempts++;

        if (String.valueOf(user_answer).equals(answer)) {
            return new GuessResult.Win(user_answer, attempts, max_attempts, "You won!");
        }

        if (!found && attempts >= max_attempts) {
            return new GuessResult.Defeat(user_answer, attempts, max_attempts, "You lost!");
        }

        if (found) {
            return new GuessResult.SuccessfulGuess(user_answer, attempts, max_attempts, "Hit!");
        } else {
            return new GuessResult.FailedGuess(user_answer, attempts, max_attempts, "Missed");
        }
    }

    public GuessResult giveUp() {
        return new GuessResult.Defeat(user_answer, attempts, max_attempts, "You lost!");
    }
}