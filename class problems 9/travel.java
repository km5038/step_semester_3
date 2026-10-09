
import java.util.Scanner;

abstract class travel {
    protected double distance;
    static final double b_f = 50;

    travel(double distance) {
        this.distance = distance;
    }

    abstract double cf();
}

class bus extends travel {
    bus(double distance) {
        super(distance);
    }

    double cf() {
        return distance * 2 + b_f;
    }
}

class train extends travel {
    train(double distance) {
        super(distance);
    }

    double cf() {
        return distance * 1.5 + b_f;
    }
}

class flight extends travel {
    flight(double distance) {
        super(distance);
    }

    double cf() {
        return 2500 + distance * 4 + b_f;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();

            travel t;

            switch (mode) {
                case "BUS":
                    t = new bus(distance);
                    break;

                case "TRAIN":
                    t = new train(distance);
                    break;

                case "FLIGHT":
                    t = new flight(distance);
                    break;

                default:
                    continue;
            }

            double fare = t.cf();
            System.out.printf("%s: %.2f%n", mode, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
