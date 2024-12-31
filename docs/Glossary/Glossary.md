# Glossary for Zalabat Mart Management System

## Revision History

| Version | Date       | Description                     | Author       |
| ------- | ---------- | ------------------------------- | ------------ |
| 1.0     | 2024-11-24 | Phase 1                         | Zeyad Waleed |
| 1.1     | 2024-11-30 | updating phase 1 after feedback | Zeyad Waleed |
| 2.0     | 2024-12-26 | Adding Phase 2 requirements     | Mohy Saleh   |

---

## Terms and Definitions

| Term           | Definition                                                                             | Format                  | Validation Rules                                | Aliases                    |
| -------------- | -------------------------------------------------------------------------------------- | ----------------------- | ----------------------------------------------- | -------------------------- |
| Product        | An item available for sale in the store.                                               | Alphanumeric (max 255)  | Required; Must have a unique ID and name.       | Item, Merchandise          |
| Category       | A grouping of products with similar attributes (e.g., Grocery, Medicine, Detergent).   | Alphanumeric (max 100)  | Required; Predefined categories only.           | Group, Type                |
| Invoice        | A document summarizing the products purchased, quantities, and total cost.             | Alphanumeric (max 500)  | Required; Must include product details.         | Bill, Receipt              |
| User           | An individual interacting with the system (e.g., admin, employee, customer).           | Alphanumeric (max 50)   | Must be unique in the system.                   | Account Holder             |
| Stock          | The quantity of a product available in the inventory.                                  | Numeric (integer)       | Cannot be negative.                             | Inventory Count            |
| Sale           | A transaction where products are sold to customers.                                    | Alphanumeric (max 500)  | Required; Must include product and invoice ID.  | Transaction                |
| Employee       | A staff member responsible for managing products, sales, or other store operations.    | Alphanumeric (max 255)  | Required; Must include role and contract dates. | Staff, Worker              |
| Discount       | A reduction in the price of a product or group of products.                            | Numeric (percentage)    | Optional; Cannot exceed 100%.                   | Promotion, Offer           |
| Membership     | A customer subscription offering benefits such as discounts and loyalty points.        | Alphanumeric (max 255)  | Optional; Must have valid start and end dates.  | Subscription, Loyalty Plan |
| Catalog        | A structured list of products with descriptions, prices, and categories.               | Alphanumeric (max 1000) | Must include valid product entries.             | Product List               |
| Notification   | A system-generated alert for updates like low stock, sales, or discounts.              | Alphanumeric (max 500)  | Optional                                        | Alert, Reminder            |
| Access Control | Security measures determining user permissions based on roles (e.g., admin, employee). | Alphanumeric (max 255)  | Required; Role-based restrictions apply.        | Authorization, Permissions |
| Security       | Mechanisms to protect sensitive information, such as customer data and transactions.   | Alphanumeric            | Required; Includes encryption and validation.   | Data Protection            |
