public class PrimeChecker {

    void checkPrime(int number) {

        boolean isPrime = true;

        if (number <= 1) {
            isPrime = false;
        }

        for (int i = 2; i <= number / 2; i++) {

            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) {
            System.out.println("Prime");
        } else {
            System.out.println("Not Prime");
        }
    }

    public static void main(String[] args) {
        PrimeChecker obj = new PrimeChecker();
        obj.checkPrime(17);
    }
}