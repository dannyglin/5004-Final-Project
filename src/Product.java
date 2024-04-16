// Abstract class representing a product in the inventory system
public abstract class Product implements Storable {
    protected String productId; // The unique identifier of the product
    protected String productName; // The name of the product
    protected int quantity; // The quantity of the product in stock
    protected double price; // The price of the product

    // Constructor to initialize a product
    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // Calculate the total value of the product (quantity * price)
    public double calculateTotalValue() {
        return quantity * price;
    }

    // Update the quantity of the product
    public void updateQuantity(int newQuantity) {
        quantity = newQuantity;
    }

    // Abstract method for storing an item in the inventory
    // Must be implemented in concrete classes
    @Override
    public abstract void storeItem(Product product);

    // Abstract method for retrieving an item from the inventory
    // Must be implemented in concrete classes
    @Override
    public abstract Product retrieveItem(String productId);
}
