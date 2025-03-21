import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;

class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return name + " (₹" + price + ")";
    }
}

public class ProductStreamProcessor {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 75000),
            new Product("Smartphone", "Electronics", 50000),
            new Product("Tablet", "Electronics", 30000),
            new Product("Chair", "Furniture", 5000),
            new Product("Sofa", "Furniture", 15000),
            new Product("Bed", "Furniture", 25000),
            new Product("T-Shirt", "Clothing", 1000),
            new Product("Jacket", "Clothing", 3000),
            new Product("Jeans", "Clothing", 2000)
        );

        // Grouping products by category
        Map<String, List<Product>> groupedByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        System.out.println("📦 Products Grouped by Category:");
        groupedByCategory.forEach((category, prodList) -> {
            System.out.println(category + ": " + prodList);
        });

        // Most expensive product in each category
        Map<String, Optional<Product>> mostExpensive = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))
                ));

        System.out.println("\n💰 Most Expensive Product in Each Category:");
        mostExpensive.forEach((category, productOpt) -> {
            productOpt.ifPresent(product ->
                    System.out.println(category + ": " + product));
        });

        // Average price of all products
        double averagePrice = products.stream()
                .collect(Collectors.averagingDouble(Product::getPrice));

        System.out.printf("\n📊 Average Price of All Products: ₹%.2f\n", averagePrice);
    }
}
