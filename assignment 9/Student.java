
import java.util.Scanner;

abstract class Student {
    String name;
    static final double BUS_FEE = 12000.0;

    Student(String name) {
        this.name = name;
    }

    abstract double tuitionAndOtherFees();

    boolean usesBus() {
        return false;
    }

    double totalFee() {
        return tuitionAndOtherFees() + (usesBus() ? BUS_FEE : 0);
    }
}

class DayScholar extends Student {
    DayScholar(String name) {
        super(name);
    }

    double tuitionAndOtherFees() {
        return 40000.0;
    }

    boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double tuitionAndOtherFees() {
        return 40000.0 + 60000.0;
    }
}

class Scholar extends Student {
    Scholar(String name) {
        super(name);
    }

    double tuitionAndOtherFees() {
        return 20000.0;
    }

    boolean usesBus() {
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            Student student;
            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    student = new Scholar(name);
                    break;
                default:
                    continue;
            }

            double fee = student.totalFee();
            total += fee;
            System.out.printf("%s: %.2f%n", name, fee);
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}
