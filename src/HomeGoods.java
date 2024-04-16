public class HomeGoods extends Product {
    private String material;
    private Inventory inventory;

    /**
     * Constructor for the HomeGoods class.
     * Initializes a HomeGoods object with the specified productId, productName, quantity, price, and material.
     * 
     * @param productId The ID of the product.
     * @param productName The name of the product.
     * @param quantity The quantity of the product in stock.
     * @param price The price of the product.
     * @param material The material of the home goods item.
     */
    public HomeGoods(String productId, String productName, int quantity, double price, String material) {
        super(productId, productName, quantity, price);
        this.material = material;
    }
    
    /**
     * Gets the material of the home goods item.
     * 
     * @return The material of the home goods item.
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Stores an home good item in the inventory.
     * Uses the Inventory instance to store the specified product.
     * 
     * @param product The product to be stored in the inventory.
     */
    @Override
    public void storeItem(Product product) {
        inventory.storeItem(product);
        System.out.println("Stored home good item: " + product.productName);
    }

    /**
     * Retrieves an home good item from the inventory based on the productId.
     * Uses the Inventory instance to retrieve the specified product.
     * 
     * @param productId The ID of the product to be retrieved.
     * @return The retrieved product, or null if not found.
     */
    @Override
    public Product retrieveItem(String productId) {
        Product retrievedProduct = inventory.retrieveItem(productId);
        System.out.println("Retrieved home good item with ID: " + productId);
        return retrievedProduct;
    }
}
