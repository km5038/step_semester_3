import java.util.*;

abstract class Question {
    String correct, answer;
    double points;

    Question(String correct, String answer, double points) {
        this.correct = correct;
        this.answer = answer;
        this.points = points;
    }

    abstract double grade();
}

class MCQ extends Question {
    MCQ(String c, String a, double p) {
        super(c, a, p);
    }

    double grade() {
        return correct.equals(answer) ? points : 0;
    }
}

class TF extends Question {
    TF(String c, String a, double p) {
        super(c, a, p);
    }

    double grade() {
        return correct.equals(answer) ? points : 0;
    }
}

class Essay extends Question {
    Essay(String c, String a, double p) {
        super(c, a, p);
    }

    double grade() {
        String[] keywords = correct.split(",");
        int matches = 0;

        String studentAnswer = answer.toLowerCase();

        for (String keyword : keywords) {
            if (studentAnswer.contains(
                    keyword.trim().toLowerCase())) {
                matches++;
            }
        }

        if (matches >= 2) {
            return points * 0.75;
        } else if (matches == 1) {
            return points * 0.50;
        }

        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            java.util.regex.Matcher matcher =
                java.util.regex.Pattern
                .compile("\"([^\"]*)\"|(\\S+)")
                .matcher(line);

            ArrayList<String> tokens = new ArrayList<>();

            while (matcher.find()) {
                tokens.add(matcher.group(1) != null
                    ? matcher.group(1)
                    : matcher.group(2));
            }

            String type = tokens.get(0);
            String correct = tokens.get(2);
            String answer = tokens.get(3);
            double points = Double.parseDouble(tokens.get(4));

            Question question;

            switch (type) {
                case "MCQ":
                    question = new MCQ(correct, answer, points);
                    break;
                case "TF":
                    question = new TF(correct, answer, points);
                    break;
                default:
                    question = new Essay(correct, answer, points);
            }

            double score = question.grade();
            total += score;

            System.out.printf("%s: %.2f%n", type, score);
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}
```
