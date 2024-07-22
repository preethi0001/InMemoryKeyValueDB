# InMemoryKeyValueDB
This code handles the basic commands (SET, GET, UNSET) and the transaction commands (BEGIN, ROLLBACK, COMMIT). 

# InMemoryKeyValueDB

InMemoryKeyValueDB is a simple in-memory key/value database implemented in Java. This project supports basic data commands such as `SET`, `GET`, and `UNSET`, as well as optional transaction commands like `BEGIN`, `ROLLBACK`, and `COMMIT`.

## Features

- **SET name value**: Set the variable `name` to the value `value`. For simplicity, `value` is an integer.
- **GET name**: Returns the value of the variable `name`, or `NULL` if that variable is not set.
- **UNSET name**: Unset the variable `name`, making it just like that variable was never set.
- **BEGIN**: Open a new transaction. Transactions cannot be nested, so only a single transaction can be active at any time.
- **ROLLBACK**: Undo commands issued in the current transaction, and close it.
- **COMMIT**: Close any open transaction, permanently applying the changes made in it.

## Example Usage

```java
public class Main {
    public static void main(String[] args) {
        set("a", 10);    // Sets a to 10

        begin();         // Begins a new transaction

        set("a", 5);     // Sets a to 5 within the transaction

        System.out.println(get("a")); // Should print 5
        rollback();      // Rolls back the transaction
        System.out.println(get("a")); // Should print 10 (after rollback)
        
        set("a", 10);    // Sets a to 10

        begin();         // Begins a new transaction

        set("a", 5);     // Sets a to 5 within the transaction

        System.out.println(get("a")); // Should print 5
        commit();        // Commits the transaction
        System.out.println(get("a")); // Should print 5 (after commit)
    }
}
```

## Methods
set(String name, int value)
Sets the variable name to the value value.

get(String name)
Returns the value of the variable name, or Integer.MIN_VALUE if that variable is not set.

unset(String name)
Unsets the variable name.

begin()
Opens a new transaction. If a transaction is already in progress, it returns an error.

rollback()
Undoes commands issued in the current transaction and closes it. If no transaction is in progress, it returns an error.

commit()
Closes any open transaction, permanently applying the changes made in it. If no transaction is in progress, it returns an error.
