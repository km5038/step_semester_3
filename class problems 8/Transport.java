import java.util.*;

abstract class Transport {
    double distance;

    Transport(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();
}

class Bus extends Transport {
    Bus(double distance) {
        super(distance);
    }

    double calculateFare() {
        return Math.min(10, 2 + 0.10 * distance);
    }
}

class Train extends Transport {
    Train(double distance) {
        super(distance);
    }

    double calculateFare() {
        return 3 + 0.15 * distance;
    }
}

class Metro extends Transport {
    double factor;

    Metro(double distance, double factor) {
        super(distance);
        this.factor = factor;
    }

    double calculateFare() {
        return (1.50 + 0.20 * distance) * factor;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            Transport transport;

            switch (type) {
                case "BUS":
                    transport = new Bus(distance);
                    break;

                case "TRAIN":
                    transport = new Train(distance);
                    break;

                default:
                    double factor = sc.nextDouble();
                    transport = new Metro(distance, factor);
            }

            double fare = transport.calculateFare();
            total += fare;

            System.out.printf("%s: %.2f%n", type, fare);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
```
