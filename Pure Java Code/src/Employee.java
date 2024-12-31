import java.util.ArrayList;
import java.util.Scanner;

public class Employee extends User {
    protected String joinDate;
    protected int transactionsCount;
    private ArrayList<Customer> customers;

    public Employee(String name, String email, String password, int transactionsCount, String joinDate) {
        super(name, email, password);
        this.transactionsCount = transactionsCount;
        this.joinDate = joinDate;
        this.customers = new ArrayList<>();
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void addCustomer(String id, String name, String email) {
        customers.add(new Customer(id, name, email));
    }

    public void addMembership(Scanner scanner) {
        System.out.print("Enter customer ID: ");
        String customerId = scanner.nextLine();

        boolean found = false;
        for (Customer customer : customers) {
            if (customer.getId().equals(customerId)) {
                found = true;
                System.out.println("Membership successfully set for customer: " + customer.getName());
                break;
            }
        }

        if (!found) {
            System.out.println("Invalid customer identifier.");
        }
    }

    @Override
    public void signIn(String inputEmail, String inputPassword) {
        if (this.email.equals(inputEmail) && this.password.equals(inputPassword)) {
            System.out.println("Sign-in successful! Welcome, " + this.name + ".");
        } else {
            System.out.println("Sign-in failed! Invalid email or password.");
        }
    }
}
