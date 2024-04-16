public class Clothing extends Product {
    private String size;
    private Inventory inventory;

    /**
     * Constructor for the Clothing class.
     * Initializes a Clothing object with the specified productId, productName, quantity, price, size, and inventory.
     * 
     * @param productId The ID of the product.
     * @param productName The name of the product.
     * @param quantity The quantity of the product in stock.
     * @param price The price of the product.
     * @param size The size of the clothing item.
     * @param inventory The inventory system where the clothing item is stored.
     */
    public Clothing(String productId, String productName, int quantity, double price, String size, Inventory inventory) {
        super(productId, productName, quantity, price);
        this.size = size;
        this.inventory = inventory;
    }

    /**
     * Stores a clothing item in the inventory.
     * Uses the Inventory instance to store the specified product.
     * 
     * @param product The product to be stored in the inventory.
     */
    @Override
    public void storeItem(Product product) {
        inventory.storeItem(product);
        System.out.println("Stored clothing item: " + product.productName);
    }

    /**
     * Retrieves a clothing item from the inventory based on the productId.
     * Uses the Inventory instance to retrieve the specified product.
     * 
     * @param productId The ID of the product to be retrieved.
     * @return The retrieved product, or null if not found.
     */
    @Override
    public Product retrieveItem(String productId) {
        Product retrievedProduct = inventory.retrieveItem(productId);
        System.out.println("Retrieved clothing item with ID: " + productId);
        return retrievedProduct;
    }
}
