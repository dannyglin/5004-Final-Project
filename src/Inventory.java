import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

// This class manages a linked list of products and implements the Storable interface.
public class Inventory implements Storable {

    // Nested Node class representing a product in the inventory
    private static class Node {
        Product product; // The product contained in the node
        Node next; // Reference to the next node

        // Constructor for a Node
        public Node(Product product) {
            this.product = product;
            this.next = null;
        }
    }

    private Node head; // Head of the linked list representing the inventory

    // Constructor for the Inventory class
    public Inventory() {
        this.head = null; // Initialize head to null when creating a new inventory
    }

    /**
     * Implements the storeItem method from the Storable interface using recursion.
     * Adds a product to the linked list in an ordered manner.
     * 
     * @param product The product to be stored in the inventory.
     */
    @Override
    public void storeItem(Product product) {
        head = storeItemRecursive(head, product);
    }

    // Recursive method for adding a product to the linked list
    private Node storeItemRecursive(Node current, Product product) {
        if (current == null) {
            // Base case: if current is null, create a new Node with the product
            return new Node(product);
        }
        // Recursively continue to find the correct position for the product
        current.next = storeItemRecursive(current.next, product);
        return current;
    }

    /**
     * Implements the retrieveItem method from the Storable interface using recursion.
     * Retrieves a product from the inventory based on its productId.
     * 
     * @param productId The ID of the product to retrieve.
     * @return The retrieved product, or null if not found.
     */
    @Override
    public Product retrieveItem(String productId) {
        return retrieveItemRecursive(head, productId);
    }

    // Recursive method for retrieving a product from the linked list
    private Product retrieveItemRecursive(Node current, String productId) {
        if (current == null) {
            // Base case: if current is null, the product was not found
            System.out.println("Product with ID " + productId + " not found");
            return null;
        }
        if (current.product.productId.equals(productId)) {
            // Product found, return it
            return current.product;
        }
        // Recursively search in the next node
        return retrieveItemRecursive(current.next, productId);
    }

    /**
     * Recursively traverses the linked list and prints each product name.
     */
    public void traverseAndPrint() {
        traverseAndPrintRecursive(head);
    }

    // Recursive method to traverse the linked list and print product names
    private void traverseAndPrintRecursive(Node current) {
        if (current != null) {
            System.out.println(current.product.productName);
            traverseAndPrintRecursive(current.next);
        }
    }

    /**
     * Uses a higher-order function to map each product in the inventory using a given function.
     * 
     * @param mapper The function to apply to each product in the inventory.
     */
    public void mapProducts(Function<Product, Product> mapper) {
        Node current = head;
        while (current != null) {
            // Apply the mapper function to each product
            current.product = mapper.apply(current.product);
            current = current.next;
        }
    }

    /**
     * Uses a higher-order function to filter products in the inventory using a given predicate.
     * 
     * @param predicate The predicate to use for filtering products.
     * @return A list of products that satisfy the predicate.
     */
    public List<Product> filterProducts(Predicate<Product> predicate) {
        List<Product> filteredProducts = new ArrayList<>();
        Node current = head;
        while (current != null) {
            // If the product satisfies the predicate, add it to the filtered list
            if (predicate.test(current.product)) {
                filteredProducts.add(current.product);
            }
            current = current.next;
        }
        return filteredProducts;
    }

    /**
     * Uses a higher-order function to fold products in the inventory using a given function.
     * 
     * @param folder The function to apply to each product and the accumulated result.
     * @param initialValue The initial value for the folding operation.
     * @return The result of folding the products in the inventory.
     */
    public double foldProducts(BiFunction<Double, Product, Double> folder, double initialValue) {
        double result = initialValue;
        Node current = head;
        while (current != null) {
            // Apply the folder function and accumulate the result
            result = folder.apply(result, current.product);
            current = current.next;
        }
        return result;
    }

    /**
     * Checks the inventory for products with low stock levels and prints alerts.
     */
    public void checkLowStock() {
        Node current = head;
        while (current != null) {
            // If the quantity of a product is less than 5, print a low stock alert
            if (current.product.quantity < 5) {
                System.out.println("Low stock alert! Product ID: " + current.product.productId + " - " + current.product.productName);
            }
            current = current.next;
        }
    }
}
