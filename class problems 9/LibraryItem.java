
import java.util.Scanner;

abstract class LibraryItem {
    protected String title;
    protected int dayslate;

    LibraryItem(String title, int dayslate) {
        this.title = title;
        this.dayslate = dayslate;
    }

    abstract double cfine();
}

class book extends LibraryItem {
    book(String title, int dayslate) {
        super(title, dayslate);
    }

    double cfine() {
        return dayslate * 2;
    }
}

class dvd extends LibraryItem {
    dvd(String title, int dayslate) {
        super(title, dayslate);
    }

    double cfine() {
        double fine = dayslate * 5;
        if (fine > 50) {
            return 50;
        } else {
            return fine;
        }
    }
}

class magazine extends LibraryItem {
    magazine(String title, int dayslate) {
        super(title, dayslate);
    }

    double cfine() {
        return dayslate;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int dayslate = sc.nextInt();

            LibraryItem item;

            switch (type) {
                case "BOOK":
                    item = new book(title, dayslate);
                    break;

                case "DVD":
                    item = new dvd(title, dayslate);
                    break;

                case "MAGAZINE":
                    item = new magazine(title, dayslate);
                    break;

                default:
                    continue;
            }

            double fine = item.cfine();
            System.out.printf("%s: %.2f%n", title, fine);
            total += fine;
        }

        System.out.printf("Total Fines: %.2f%n", total);
        sc.close();
    }
}
