public class ProductInventoryParser {

    public static void parseInventoryRecord(String csvLine) {

        String[] details = csvLine.split(",");

        if (details.length != 3) {

            System.out.println("Invalid Record");

        } else {

            System.out.println(
                    "Product: " + details[0]
                    + " | SKU: " + details[1]
                    + " | Qty: " + details[2]
            );
        }
    }

    public static void main(String[] args) {

        parseInventoryRecord(
                "Wireless Mouse,WM-2201,150"
        );

        parseInventoryRecord(
                "Wireless Mouse,150"
        );
    }
}