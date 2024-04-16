public class Electronics extends Product {
    private String brand;
    private Inventory inventory;

    /**
     * Constructor for the Electronics class.
     * Initializes an Electronics object with the specified productId, productName, quantity, price, brand, and inventory.
     * 
     * @param productId The ID of the product.
     * @param productName The name of the product.
     * @param quantity The quantity of the product in stock.
     * @param price The price of the product.
     * @param brand The brand of the electronics item.
     * @param inventory The inventory system where the electronics item is stored.
     */
    public Electronics(String productId, String productName, int quantity, double price, String brand, Inventory inventory) {
        super(productId, productName, quantity, price);
        this.brand = brand;
        this.inventory = inventory;
    }

    /**
     * Stores an electronics item in the inventory.
     * Uses the Inventory instance to store the specified product.
     * 
     * @param product The product to be stored in the inventory.
     */
    @Override
    public void storeItem(Product product) {
        inventory.storeItem(product);
        System.out.println("Stored electronics item: " + product.productName);
    }

    /**
     * Retrieves an electronics item from the inventory based on the productId.
     * Uses the Inventory instance to retrieve the specified product.
     * 
     * @param productId The ID of the product to be retrieved.
     * @return The retrieved product, or null if not found.
     */
    @Override
    public Product retrieveItem(String productId) {
        Product retrievedProduct = inventory.retrieveItem(productId);
        System.out.println("Retrieved electronics item with ID: " + productId);
        return retrievedProduct;
    }
}
