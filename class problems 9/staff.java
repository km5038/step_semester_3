
import java.util.Scanner;

abstract class staff {
    protected String name;

    staff(String name) {
        this.name = name;
    }

    abstract double cp();
}

class fulltime extends staff {
    double weeksal;

    fulltime(String name, double weeksal) {
        super(name);
        this.weeksal = weeksal;
    }

    double cp() {
        return weeksal;
    }
}

class hourly extends staff {
    double hours;
    double rate;

    hourly(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    double cp() {
        if (hours <= 40) {
            return hours * rate;
        } else {
            return 40 * rate + (hours - 40) * rate * 1.5;
        }
    }
}

class intern extends staff {
    double stipend;

    intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    double cp() {
        return stipend;
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

            staff s;

            switch (type) {
                case "FULLTIME":
                    double salary = sc.nextDouble();
                    s = new fulltime(name, salary);
                    break;

                case "HOURLY":
                    double hours = sc.nextDouble();
                    double rate = sc.nextDouble();
                    s = new hourly(name, hours, rate);
                    break;

                case "INTERN":
                    double stipend = sc.nextDouble();
                    s = new intern(name, stipend);
                    break;

                default:
                    continue;
            }

            double pay = s.cp();
            System.out.printf("%s: %.2f%n", name, pay);
            total += pay;
        }

        System.out.printf("Total Payroll: %.2f%n", total);
        sc.close();
    }
}
