interface GuessResult {
    char[] state();
    int attempt();
    int max_attempts();
    String message();

    record Defeat(char[] state, int attempt, int max_attempts, String message) implements GuessResult {}
    record Win(char[] state, int attempt, int max_attempts, String message) implements GuessResult {}
    record SuccessfulGuess(char[] state, int attempt, int max_attempts, String message) implements GuessResult {}
    record FailedGuess(char[] state, int attempt, int max_attempts, String message) implements GuessResult {}
}
