import java.util.Scanner;

public class NormalSale implements Sale {
    private String id;
    private double total;
    private double discount;
    private String date;
    private Catalog catalog;

    public NormalSale(String id, double total, double discount, String date, Catalog catalog) {
        this.id = id;
        this.total = total;
        this.discount = discount;
        this.date = date;
        this.catalog = catalog;
    }

    @Override
    public void viewSaleDetails() {
        System.out.println("Sale ID: " + id);
        System.out.println("Total: " + total);
        System.out.println("Discount: " + discount);
        System.out.println("Date: " + date);
    }

    @Override
    public void calculateDiscount() {
        discount = total * 0.1; // Assuming 10% discount
        System.out.println("Discount calculated: " + discount);
    }

    @Override
    public void recordInvoice() {
        System.out.println("Recording invoice for Sale ID: " + id);
    }

    public void productsQuantity(Scanner scanner) {
        catalog.displayInfo();

        System.out.print("Enter the product name for sale: ");
        String itemName = scanner.nextLine();

        Product selectedProduct = catalog.findProductByName(itemName);
        if (selectedProduct == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.print("Enter the quantity of " + selectedProduct.getItemName() + " to sale: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        if (quantity > selectedProduct.getStock()) {
            System.out.println("Unable to process the sale. Not enough stock available.");
            return;
        }

        double productTotalPrice = selectedProduct.getPrice() * quantity;
        total += productTotalPrice;
        selectedProduct.setStock(selectedProduct.getStock() - quantity);

        System.out.println("Sale completed!");
        System.out.println("Total price for " + quantity + " " + selectedProduct.getItemName() + "(s): " + productTotalPrice);
        System.out.println("Updated total for the sale: " + total);

        System.out.println("\nUpdated Catalog:");
        catalog.displayInfo();
    }
}
