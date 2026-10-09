
import java.util.Scanner;

abstract class ElectricityConnect {
    protected int units;

    ElectricityConnect(int units) {
        this.units = units;
    }

    abstract double Bill();
}

class Home extends ElectricityConnect {
    Home(int units) {
        super(units);
    }

    double Bill() {
        if (units <= 100) {
            return units * 5;
        } else {
            return 100 * 5 + (units - 100) * 7;
        }
    }
}

class Shop extends ElectricityConnect {
    Shop(int units) {
        super(units);
    }

    double Bill() {
        return units * 8 + 100;
    }
}

class Factory extends ElectricityConnect {
    Factory(int units) {
        super(units);
    }

    double Bill() {
        double bill = units * 6;
        if (bill < 1000) {
            return 1000;
        } else {
            return bill;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            ElectricityConnect connection;

            switch (type) {
                case "HOME":
                    connection = new Home(units);
                    break;
                case "SHOP":
                    connection = new Shop(units);
                    break;
                case "FACTORY":
                    connection = new Factory(units);
                    break;
                default:
                    continue;
            }

            double bill = connection.Bill();
            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
