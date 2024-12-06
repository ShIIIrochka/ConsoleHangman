import java.util.Scanner;

public class Session {
    /*
     * answer: word to guess
     * userAnswer: user answer
     * maxAttempts: max attempts to guess word
     * attempts: user attempts
     */

    private final String answer;
    private final char[] userAnswer;
    private final int maxAttempts;
    private int attempts;

    public Session(String answer, int maxAttempts) {
        this.answer = answer;
        this.maxAttempts = maxAttempts;
        this.userAnswer = new char[answer.length()];
        for (int i = 0; i < userAnswer.length; i++) {
            userAnswer[i] = '*';
        }
        this.attempts = 0;
    }

    public GuessResult guess(char guess) {
        boolean found = false;

        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == guess) {
                userAnswer[i] = guess;
                found = true;
            }
        }
        attempts++;

        String word = "";
        for (char i: userAnswer) {
            word += i;
        }

        if (String.valueOf(userAnswer).equals(answer)) {
            return new GuessResult.Win(userAnswer, attempts, maxAttempts, "You won!");
        }

        if (!found && attempts >= maxAttempts) {
            return new GuessResult.Defeat(userAnswer, attempts, maxAttempts, "You lost!");
        }

        if (found) {
            return new GuessResult.SuccessfulGuess(
                    userAnswer, attempts, maxAttempts, "Hit! \n The word: " + word
            );
        } else {
            return new GuessResult.FailedGuess(
                    userAnswer,
                    attempts,
                    maxAttempts,
                    "Missed, mistake " + attempts + " out of " + maxAttempts + "The word: " + word
            );
        }
    }

    public GuessResult giveUp() {
        return new GuessResult.Defeat(userAnswer, attempts, maxAttempts, "You lost!");
    }
}
