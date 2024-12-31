import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Product extends Expirable {
    protected String itemName;
    protected int stock;
    protected double price;
    protected String barCode;

    public Product(String itemName, double price, int stock, String barCode, String expDate) {
        super(expDate);
        this.itemName = itemName;
        this.price = price;
        this.stock = stock;
        this.barCode = barCode;
    }

    @Override
    public boolean isExpired() {
        if (expDate == null || expDate.isEmpty()) {
            throw new IllegalStateException("Expiry date is not set");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate expiryDate = LocalDate.parse(expDate, formatter);
        LocalDate currentDate = LocalDate.now();

        return !currentDate.isBefore(expiryDate);
    }

    public void setItemName(String itemName) {
        if (itemName == null || itemName.isEmpty()) {
            throw new IllegalArgumentException("Item name cannot be null or empty");
        }
        this.itemName = itemName;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        }
        this.stock = stock;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getItemName() {
        return itemName;
    }

    public int getStock() {
        return stock;
    }

    public String getBarCode() {
        return barCode;
    }

    public double getPrice() {
        return price;
    }
}
