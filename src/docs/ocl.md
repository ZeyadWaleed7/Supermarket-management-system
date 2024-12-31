### Customer Constraints
```
context Customer
inv: self.email->matches('(?i)^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$')
inv: self.interactionNum >= 0
```

### Admin Constraints
```
context Admin
-- No constraints needed as the size of a collection is always non-negative by definition.
```


### Coupon Constraints
```
context Coupon
inv: self.id->isUnique()
inv: self.issueDate.isDefined() and self.expiryDate.isDefined()
inv: self.expiryDate > self.issueDate
inv: self.customer->size() = 1
inv: self.receipt->size() = 1
```

### Product Constraints
```
context Product
inv: self.Stock >= 0
inv: self.Price > 0

context Product::updateStock(newStock: Integer)
pre: newStock >= 0
post: self.Stock = newStock
```

### Sale Constraints
```
context Sale
inv: self.products->size() >= 1
inv: self.id->isUnique()

context Sale::createSale(total: Float, discount: Float, date: Date)
pre: total > 0 and discount >= 0
post: discount <= total
```
### CashierDevice Constraints
```
context CashierDevice
inv: self.Status in Sequence{'Working', 'Under maintenance', 'Out of service'}
inv: self.employee->size() = 1 //one cashier on the pc

context CashierDevice::storeAmount(amount: Float)
pre: self.Status = 'Working'
post: self.AmountStored = self.AmountStored@pre + amount
```
### Catalog Constraints
```
context Catalog
inv: self.products->size() >= 1
inv: self.ProductsNum = self.products->size()
```
### Receipt Constraints

```
context Receipt
inv: self.id->isUnique()
inv: self.sale->size() = 1
inv: self.cashierDevice->size() = 1
```