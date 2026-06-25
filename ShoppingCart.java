import java.util.*;

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

public class ShoppingCart {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product("Laptop", 50000));
        products.add(new Product("Mouse", 500));
        products.add(new Product("Keyboard", 1200));
        products.add(new Product("Headphones", 1500));

        HashMap<String, Integer> cart = new HashMap<>();

        while (true) {
            System.out.println("\n===== ONLINE SHOPPING CART =====");
            System.out.println("1. View Products");
            System.out.println("2. Add Item to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Calculate Total");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nAvailable Products:");
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println((i + 1) + ". "
                                + products.get(i).name
                                + " - ₹" + products.get(i).price);
                    }
                    break;

                case 2:
                    System.out.print("Enter Product Number: ");
                    int p = sc.nextInt();

                    if (p >= 1 && p <= products.size()) {
                        Product item = products.get(p - 1);

                        System.out.print("Enter Quantity: ");
                        int qty = sc.nextInt();

                        cart.put(item.name,
                                cart.getOrDefault(item.name, 0) + qty);

                        System.out.println(item.name + " added to cart.");
                    } else {
                        System.out.println("Invalid Product!");
                    }
                    break;

                case 3:
                    if (cart.isEmpty()) {
                        System.out.println("Cart is Empty!");
                    } else {
                        System.out.println("\nYour Cart:");
                        for (String item : cart.keySet()) {
                            System.out.println(item + " x "
                                    + cart.get(item));
                        }
                    }
                    break;

                case 4:
                    double total = 0;

                    for (Product product : products) {
                        if (cart.containsKey(product.name)) {
                            total += product.price *
                                    cart.get(product.name);
                        }
                    }

                    System.out.println("Total Price = ₹" + total);
                    break;

                case 5:
                    System.out.println("Thank You for Shopping!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
