import java.util.*;
import java.time.LocalDate;

abstract class Plan {
    String name;
    LocalDate startDate;

    Plan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract int validityDays();

    LocalDate renewalDate() {
        return startDate.plusDays(validityDays());
    }
}

class Basic extends Plan {
    Basic(String name, LocalDate date) {
        super(name, date);
    }

    int validityDays() {
        return 30;
    }
}

class Standard extends Plan {
    Standard(String name, LocalDate date) {
        super(name, date);
    }

    int validityDays() {
        return 90;
    }
}

class Premium extends Plan {
    Premium(String name, LocalDate date) {
        super(name, date);
    }

    int validityDays() {
        return 365;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().split("\\s+");

            String type = data[0];
            String name = data[1];
            LocalDate date = LocalDate.parse(data[2]);

            Plan plan;

            switch (type) {
                case "BASIC":
                    plan = new Basic(name, date);
                    break;
                case "STANDARD":
                    plan = new Standard(name, date);
                    break;
                default:
                    plan = new Premium(name, date);
            }

            System.out.println(
                plan.name + ": " + plan.renewalDate()
            );
        }

        sc.close();
    }
}
```
