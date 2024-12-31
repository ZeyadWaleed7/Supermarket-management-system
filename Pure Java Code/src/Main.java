import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<NormalSale> salesList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Admin admin = new Admin("Admin", "admin@example.com", "admin123");
        ArrayList<Employee> employees = new ArrayList<>();

        admin.addCustomer("CUST001", "John Doe", "john@example.com");
        admin.addCustomer("CUST002", "Jane Smith", "jane@example.com");
        admin.addCustomer("CUST003", "Alice Johnson", "alice@example.com");


        Employee employee = new Employee("Employee", "employee@example.com", "emp123", 10, "2023-01-01");
        employee.addCustomer("CUST004", "Bob Brown", "bob@example.com");
        employee.addCustomer("CUST005", "Charlie Green", "charlie@example.com");
        employees.add(employee);

        ArrayList<Catalog> catalogs = new ArrayList<>();
        catalogs.add(new Catalog("CAT001"));
        catalogs.add(new Catalog("CAT002"));
        catalogs.add(new Catalog("CAT003"));

        while (true) {
            User user = signIn(admin, employees, scanner);
            if (user instanceof Admin) {
                adminMenu((Admin) user, employees, catalogs, scanner);
            } else if (user instanceof Employee) {
                employeeMenu((Employee) user, catalogs, scanner);
            }
        }
    }

    private static void adminMenu(Admin admin, ArrayList<Employee> employees, ArrayList<Catalog> catalogs, Scanner scanner) {
        while (true) {
            System.out.println("\n--- Admin Dashboard ---");
            System.out.println("1. Manage Products");
            System.out.println("2. Create Sale");
            System.out.println("3. Add User Membership");
            System.out.println("4. View Sales Details");
            System.out.println("5. Add Employee");
            System.out.println("6. Sign Out");
            System.out.println("7. Close Program");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    manageProducts(catalogs, scanner);
                    break;
                case 2:
                    createSale(catalogs, scanner);
                    break;
                case 3:
                    admin.addMembership(scanner);
                    break;
                case 4:
                    viewSales();
                    break;
                case 5:
                    addEmployee(admin, employees, scanner);
                    break;
                case 6:
                    System.out.println("Signing out...");
                    return;
                case 7:
                    System.out.println("Program terminated. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void employeeMenu(Employee employee, ArrayList<Catalog> catalogs, Scanner scanner) {
        while (true) {
            System.out.println("\n--- Employee Dashboard ---");
            System.out.println("1. Manage Products");
            System.out.println("2. Add User Membership");
            System.out.println("3. View Sales Details");
            System.out.println("4. Sign Out");
            System.out.println("5. Close Program");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    manageProducts(catalogs, scanner);
                    break;
                case 2:
                    employee.addMembership(scanner);
                    break;
                case 3:
                    viewSales();
                    break;
                case 4:
                    System.out.println("Signing out...");
                    return;
                case 5:
                    System.out.println("Program terminated. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageProducts(ArrayList<Catalog> catalogs, Scanner scanner) {
        while (true) {
            System.out.println("\n--- Manage Products ---");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Search Product");
            System.out.println("4. Sort Products");
            System.out.println("5. Display Catalog Info");
            System.out.println("6. Go Back to Dashboard");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    selectCatalog(catalogs, "add", scanner);
                    break;
                case 2:
                    selectCatalog(catalogs, "remove", scanner);
                    break;
                case 3:
                    selectCatalog(catalogs, "search", scanner);
                    break;
                case 4:
                    selectCatalog(catalogs, "sort", scanner);
                    break;
                case 5:
                    selectCatalog(catalogs, "display", scanner);
                    break;
                case 6:
                    System.out.println("Returning to Dashboard...\n");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void selectCatalog(ArrayList<Catalog> catalogs, String action, Scanner scanner) {
        System.out.println("\nSelect a catalog:");
        for (int i = 0; i < catalogs.size(); i++) {
            System.out.println((i + 1) + ". " + catalogs.get(i).getCatalogId());
        }

        System.out.print("Enter your choice: ");
        int catalogChoice = Integer.parseInt(scanner.nextLine());

        if (catalogChoice < 1 || catalogChoice > catalogs.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        Catalog selectedCatalog = catalogs.get(catalogChoice - 1);
        switch (action) {
            case "add":
                addProduct(selectedCatalog, scanner);
                break;
            case "remove":
                removeProduct(selectedCatalog, scanner);
                break;
            case "search":
                searchProduct(selectedCatalog, scanner);
                break;
            case "sort":
                sortProducts(selectedCatalog, scanner);
                break;
            case "display":
                selectedCatalog.displayInfo();
                break;
        }
    }

    private static void addProduct(Catalog catalog, Scanner scanner) {
        System.out.print("Enter product name: ");
        String itemName = scanner.nextLine();

        System.out.print("Enter product price: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter product stock: ");
        int stock = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter product barcode: ");
        String barCode = scanner.nextLine();

        System.out.print("Enter product expiry date (yyyy-MM-dd): ");
        String expDate = scanner.nextLine();

        Product product = new Product(itemName, price, stock, barCode, expDate);
        catalog.addProduct(product);
    }

    private static void removeProduct(Catalog catalog, Scanner scanner) {
        System.out.print("Enter the name of the product to remove: ");
        String itemName = scanner.nextLine();

        Product productToRemove = catalog.findProductByName(itemName);
        if (productToRemove != null) {
            catalog.removeProduct(productToRemove);
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void searchProduct(Catalog catalog, Scanner scanner) {
        System.out.print("Enter the name of the product to search: ");
        String itemName = scanner.nextLine();

        Product product = catalog.findProductByName(itemName);
        if (product != null) {
            String expiredStatus = product.isExpired() ? "Expired" : "Not Expired";
            System.out.println("Product found: " + product.getItemName() +
                    " | Price: $" + product.getPrice() +
                    " | Stock: " + product.getStock() +
                    " | Status: " + expiredStatus);
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void sortProducts(Catalog catalog, Scanner scanner) {
        System.out.println("Sort products by:");
        System.out.println("1. Name");
        System.out.println("2. Price");
        System.out.println("3. Stock");
        System.out.print("Enter your choice: ");
        int choice = Integer.parseInt(scanner.nextLine());

        catalog.sortBy(choice);
    }

    private static void addEmployee(Admin admin, ArrayList<Employee> employees, Scanner scanner) {
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter employee email: ");
        String email = scanner.nextLine();

        System.out.print("Enter employee password: ");
        String password = scanner.nextLine();

        System.out.print("Enter employee transactions count: ");
        int transactionsCount = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter employee join date: ");
        String joinDate = scanner.nextLine();

        admin.addEmployee(name, email, password, transactionsCount, joinDate);
        employees.add(new Employee(name, email, password, transactionsCount, joinDate));
    }

    private static void createSale(ArrayList<Catalog> catalogs, Scanner scanner) {
        System.out.println("\n--- Displaying Catalogs and Products ---");
        for (Catalog catalog : catalogs) {
            catalog.displayInfo();
        }

        System.out.println("Select a catalog to sale from:");
        for (int i = 0; i < catalogs.size(); i++) {
            System.out.println((i + 1) + ". " + catalogs.get(i).getCatalogId());
        }
        System.out.print("Enter your choice: ");
        int catalogChoice = Integer.parseInt(scanner.nextLine());

        if (catalogChoice < 1 || catalogChoice > catalogs.size()) {
            System.out.println("Invalid choice. Returning to dashboard.");
            return;
        }

        Catalog selectedCatalog = catalogs.get(catalogChoice - 1);
        selectedCatalog.displayInfo();

        NormalSale sale = new NormalSale("SALE-" + System.currentTimeMillis(), 0, 0, "2024-12-26", selectedCatalog);
        sale.productsQuantity(scanner);
        salesList.add(sale);

        System.out.println("Sale Details:");
        sale.viewSaleDetails();

        System.out.println("\nUpdated Catalog Info:");
        selectedCatalog.displayInfo();
    }

    private static void viewSales() {
        if (salesList.isEmpty()) {
            System.out.println("\nNo sales recorded yet.");
            return;
        }

        System.out.println("\n--- Sales History ---");
        for (NormalSale sale : salesList) {
            sale.viewSaleDetails();
        }
    }

    private static User signIn(Admin admin, ArrayList<Employee> employees, Scanner scanner) {
        while (true) {
            System.out.println("\n--- Sign In ---");
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
                System.out.println("Welcome, " + admin.getName() + "!");
                return admin;
            }

            for (Employee emp : employees) {
                if (emp.getEmail().equals(email) && emp.getPassword().equals(password)) {
                    System.out.println("Welcome, " + emp.getName() + "!");
                    return emp;
                }
            }

            System.out.println("Invalid email or password. Please try again.");
        }
    }
}
