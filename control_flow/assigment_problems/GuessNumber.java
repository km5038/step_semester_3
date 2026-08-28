public class GuessNumber {

    void guessTheNumber(
            int secretNumber,
            int maxTries,
            int[] guesses) {

        int tries = 0;
        boolean guessedCorrectly = false;

        while (tries < maxTries &&
               tries < guesses.length &&
               !guessedCorrectly) {

            int guess = guesses[tries];

            if (guess > secretNumber) {

                System.out.println("Too high");

            } else if (guess < secretNumber) {

                System.out.println("Too low");

            } else {

                System.out.println(
                    "Correct! You guessed it"
                );

                guessedCorrectly = true;
                break;
            }

            tries++;
        }

        if (!guessedCorrectly) {
            System.out.println(
                "Out of tries - the number was "
                        + secretNumber
            );
        }
    }

    public static void main(String[] args) {

        GuessNumber obj = new GuessNumber();

        int[] guesses = {20, 60, 42};

        obj.guessTheNumber(42, 4, guesses);
    }
}