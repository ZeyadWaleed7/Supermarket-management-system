| **ID** | **Rule**                                                                                   | **Changeability**  | **Source**                  |
|--------|--------------------------------------------------------------------------------------------|--------------------|-----------------------------|
| 1      | All users must authenticate using their username and password before accessing the system. | Low               | System Requirements        |
| 2      | The system must log user activities for auditing purposes.                                 | Medium            | Security Policy            |
| 3      | Each product must have a unique ID, name, category, and stock level.                       | Low               | Product Management Policy  |
| 4      | Products can only be added or removed by users with the role of "Admin."                  | Medium            | User Role Requirements     |
| 5      | The stock level must be updated automatically when sales are recorded.                    | Low               | System Functional Design   |
| 6      | Only products with a stock level greater than zero can be added to an invoice.            | Medium            | Sales Processing Rules     |
| 7      | Employee data can only be managed by users with the role of "Admin."                      | Medium            | Employee Management Policy |
| 8      | The system must lock user accounts after 5 unsuccessful login attempts.                   | Low               | Security Policy            |
| 9      | Reports must include total sales, best-selling products, and stock levels.                | High              | Reporting Requirements     |
| 10     | "Medicines" category must include an expiry date for each product.                        | Low               | Domain-Specific Standards  |
| 11     | Products nearing expiry (30 days or less) must trigger an alert to the admin.             | Medium            | Compliance Standards       |
| 12     | Discounts for groceries and detergents must follow predefined promotional rules.           | High              | Marketing Guidelines       |
| 13     | Passwords must be stored in an encrypted format.                                           | Low               | Security Best Practices    |
| 14     | Refunds can only be processed for purchases made within 30 days.                          | Medium            | Financial Policy           |
