
import java.util.Scanner;

abstract class Cab {
    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double ratePerKm();

    double calculateFare() {
        return Math.max(100.0, km * ratePerKm());
    }
}

interface NightService {
    double addNightCharge(double fare);
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    double ratePerKm() {
        return 10.0;
    }
}

class Sedan extends Cab implements NightService {
    Sedan(double km) {
        super(km);
    }

    double ratePerKm() {
        return 14.0;
    }

    public double addNightCharge(double fare) {
        return fare * 1.20;
    }
}

class SUV extends Cab implements NightService {
    SUV(double km) {
        super(km);
    }

    double ratePerKm() {
        return 18.0;
    }

    public double addNightCharge(double fare) {
        return fare * 1.20;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab;
            switch (type) {
                case "MINI":
                    cab = new Mini(km);
                    break;
                case "SEDAN":
                    cab = new Sedan(km);
                    break;
                case "SUV":
                    cab = new SUV(km);
                    break;
                default:
                    continue;
            }

            if (time.equals("NIGHT")) {
                if (!(cab instanceof NightService)) {
                    System.out.println(
                        "MINI: night service not available"
                    );
                    continue;
                }
                NightService nightCab = (NightService) cab;
                double fare = nightCab.addNightCharge(
                    cab.calculateFare()
                );
                total += fare;
                System.out.printf("%s: %.2f%n", type, fare);
            } else {
                double fare = cab.calculateFare();
                total += fare;
                System.out.printf("%s: %.2f%n", type, fare);
            }
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
