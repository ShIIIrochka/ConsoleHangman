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
            if (answer.charAt(i) == guess && userAnswer[i] == '*') {
                userAnswer[i] = guess;
                found = true;
                break;
            }
        }

        if (!found) {
            attempts++;
        }

        // user wins
        if (String.valueOf(userAnswer).equals(answer)) {
            return new GuessResult.Win(userAnswer, attempts, maxAttempts, "You won!");
        }

        // user looses
        if (attempts >= maxAttempts) {
            return new GuessResult.Defeat(userAnswer, attempts, maxAttempts, "You lost!");
        }

        // user guesses a letter
        if (found) {
            return new GuessResult.SuccessfulGuess(
                    userAnswer, attempts, maxAttempts, "Hit!"
            );
        } else {
            return new GuessResult.FailedGuess(
                    userAnswer,
                    attempts,
                    maxAttempts,
                    "Missed"
            );
        }
    }

    public GuessResult giveUp() {
        return new GuessResult.Defeat(userAnswer, attempts, maxAttempts, "You lost!");
    }
}
