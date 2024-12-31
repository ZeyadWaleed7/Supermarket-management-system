import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Catalog implements ListOperations {
    private String catalogId;
    private List<Product> products;

    public Catalog(String catalogId) {
        if (catalogId == null || catalogId.isEmpty()) {
            throw new IllegalArgumentException("Catalog ID cannot be null or empty.");
        }
        this.catalogId = catalogId;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        if (product == null) {
            System.out.println("Cannot add null product.");
            return;
        }
        products.add(product);
        System.out.println("Product added successfully!");
    }

    public void removeProduct(Product product) {
        if (products.remove(product)) {
            System.out.println("Product removed successfully!");
        } else {
            System.out.println("Failed to remove product.");
        }
    }

    public Product findProductByName(String itemName) {
        for (Product product : products) {
            if (product.getItemName().equalsIgnoreCase(itemName)) {
                return product;
            }
        }
        return null;
    }

    public void sortBy(int choice) {
        switch (choice) {
            case 1:
                products.sort(Comparator.comparing(Product::getItemName));
                System.out.println("Products sorted by name.");
                break;
            case 2:
                products.sort(Comparator.comparingDouble(Product::getPrice));
                System.out.println("Products sorted by price.");
                break;
            case 3:
                products.sort(Comparator.comparingInt(Product::getStock));
                System.out.println("Products sorted by stock.");
                break;
            default:
                System.out.println("Invalid choice. No sorting applied.");
        }
    }

    public void displayInfo() {
        System.out.println("\nCatalog ID: " + catalogId);
        System.out.println("Number of Products: " + products.size());
        System.out.println("Products in this catalog:");
        for (Product product : products) {
            System.out.println("- Name: " + product.getItemName() +
                    ", Price: $" + product.getPrice() +
                    ", Stock: " + product.getStock() +
                    ", Expiry Status: " + (product.isExpired() ? "Expired" : "Not Expired"));
        }
    }

    public String getCatalogId() {
        return catalogId;
    }

    public List<Product> getProducts() {
        return products;
    }
}
