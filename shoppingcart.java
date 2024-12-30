import java.util.*;

public class shoppingcart {
    public static void main(String[] args) {
        HashMap<String, Double> priceList = new HashMap<>();
        priceList.put("Apple", 0.50);
        priceList.put("Banana", 0.30);
        priceList.put("Orange", 0.80);
        priceList.put("Milk", 1.20);
        priceList.put("Bread", 1.00);
        priceList.put("Eggs", 2.50);
        priceList.put("Cheese", 3.00);
        priceList.put("Chicken", 5.50);
        priceList.put("Rice", 1.10);

        Scanner scanner = new Scanner(System.in);

        HashMap<String, Integer> shoppingCart = new HashMap<>();
        String item;
        int quantity;

        System.out.println("Enter items and quantities (type 'done' to finish):");
        while (true) {
            System.out.print("Item: ");
            item = scanner.nextLine();

            if (item.equalsIgnoreCase("done")) {
                break;
            }

            if (!priceList.containsKey(item)) {
                System.out.println("Item not available. Please choose from the list: " + priceList.keySet());
                continue;
            }

            System.out.print("Quantity: ");
            try {
                quantity = Integer.parseInt(scanner.nextLine());
                if (quantity <= 0) {
                    System.out.println("Quantity must be greater than 0.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number for quantity.");
                continue;
            }

            shoppingCart.put(item, shoppingCart.getOrDefault(item, 0) + quantity);
        }

        double totalPrice = 0.0;
        System.out.println("\nItemized Bill:");
        System.out.println("Item\tQuantity\tPrice");
        for (Map.Entry<String, Integer> entry : shoppingCart.entrySet()) {
            String cartItem = entry.getKey();
            int cartQuantity = entry.getValue();
            double itemTotal = priceList.get(cartItem) * cartQuantity;
            totalPrice += itemTotal;
            System.out.printf("%s\t%d\t\t$%.2f\n", cartItem, cartQuantity, itemTotal);
        }

        System.out.printf("\nTotal Price: $%.2f\n", totalPrice);

        scanner.close();
    }
}
