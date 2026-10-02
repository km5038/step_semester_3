import java.util.*;
import java.time.LocalDate;

abstract class LibraryItem {
    String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract int loanDays();

    LocalDate dueDate() {
        return LocalDate.of(2023, 10, 26)
                .plusDays(loanDays());
    }
}

class Book extends LibraryItem {
    Book(String title) {
        super(title);
    }

    int loanDays() {
        return 14;
    }
}

class DVD extends LibraryItem {
    DVD(String title) {
        super(title);
    }

    int loanDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    Magazine(String title) {
        super(title);
    }

    int loanDays() {
        return 3;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            int firstSpace = line.indexOf(' ');
            String type = line.substring(0, firstSpace);
            String title = line.substring(firstSpace + 1)
                    .replaceAll("^\"|\"$", "");

            LibraryItem item;

            switch (type) {
                case "BOOK":
                    item = new Book(title);
                    break;
                case "DVD":
                    item = new DVD(title);
                    break;
                default:
                    item = new Magazine(title);
            }

            System.out.println(
                item.title + ": " + item.dueDate()
            );
        }

        sc.close();
    }
}
```
