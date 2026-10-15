public class SumNaturalNumbers {

    void sumOfNaturalNumbers(int n) {
        int sum = 0;
        int i = 1;

        while (i <= n) {
            sum = sum + i;
            i++;
        }

        System.out.println("Sum of numbers from 1 to " + n + " = " + sum);
    }

    public static void main(String[] args) {
        SumNaturalNumbers obj = new SumNaturalNumbers();
        obj.sumOfNaturalNumbers(5);
    }
}