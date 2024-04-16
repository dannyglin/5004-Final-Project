interface Storable {
    // Method to store an item (product) in the storage system
    void storeItem(Product product);
    
    // Method to retrieve an item (product) from the storage system using its product ID
    Product retrieveItem(String productId);
}
