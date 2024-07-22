import java.util.*;

public class Main {
    static HashMap<String, Integer> hashMap = new HashMap<>();
    static HashMap<String, Integer> temp;
    static boolean transactionInProcess = false;

    public static void main(String[] args) {
        set("a", 10);

        begin();

        set("a", 5);

        System.out.println(get("a")); // Should print 5
        rollback();
        System.out.println(get("a")); // Should print 10

        set("a", 10);

        begin();

        set("a", 5);

        System.out.println(get("a")); // Should print 5
        commit();
        System.out.println(get("a")); // Should print 5
    }

    static void set(String name, int value) {
        hashMap.put(name, value);
    }

    static Object get(String name) {
        if (hashMap.containsKey(name))
            return hashMap.get(name);
        return null; // Return Integer.MIN_VALUE or NULL
    }

    static void unset(String name) {
        hashMap.remove(name);
    }

    static void begin() {
        if (transactionInProcess) {
            //throw error/exception as per requirement
            System.out.println("Error: Transaction already in progress.");
            return;
        }
        transactionInProcess = true;
        temp = new HashMap<>(hashMap);
    }

    static void commit() {
        if (!transactionInProcess) {
            System.out.println("Error: No transaction in progress.");
            return;
        }
        transactionInProcess = false;
    }

    static void rollback() {
        if (!transactionInProcess) {
            System.out.println("Error: No transaction in progress.");
            return;
        }
        hashMap = new HashMap<>(temp);
        transactionInProcess = false;
    }

    //TODO
    //savepoint implementation by maintaining a list
}


