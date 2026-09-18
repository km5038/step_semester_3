class HallTicket {
    String studentName;
    int seatNumber;

    HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

public class Main {
    public static void main(String[] args) {

        HallTicket priya =
                new HallTicket("Priya", 0);

        // Both variables point to SAME object
        HallTicket copy = priya;

        // Change using second reference
        copy.seatNumber = 45;

        // Create a completely separate object
        HallTicket separate =
                new HallTicket("Priya", 45);

        System.out.println(
                "Priya's seatNumber (via first variable): "
                        + priya.seatNumber);

        System.out.println("copy == priya: " + (copy == priya));

        System.out.println(
                "separate == priya: " + (separate == priya));
    }
}