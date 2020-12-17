# Vending Machine

### Properties

1. A Coin Slot allows customers to insert coins into the machine. It also serves as a temporary storage for
inserted coins and accumulates the amount of face value.
2. A button to reject all inserted coins.
3. A Coin Changer stores coins for giving change. Change is the money that is returned to the customer who
has paid for the product that costs less than the amount that the customer has given.
4. A Soft Drink Slot holds the same products of soft drinks in a column. When a transaction is made, the slot
will drop a can of drink into the dispenser.

### Workflow

1. The customer inserts coins into the Coin Slot.
2. The customer selects a product.
3. If the customer has inserted enough amount of money for the product, the vending machine first drops the
product and return change (if necessary). Then, all coins in the Coin Slot are moved to the Coin Changer.

### Special Case

1. Insufficient amount of money to buy the drink.
2. The drink is out of stock
3. Not enough coins in Coin Changer for giving a particular amount of change to the customer.
