import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// This class represents the JavaFX application for managing inventory.
public class InventoryManagementApp extends Application {
    private Inventory inventory; // The inventory instance

    // Entry point for the JavaFX application
    @Override
    public void start(Stage primaryStage) {
        inventory = new Inventory(); // Initialize the inventory instance

        // Create UI components
        Label welcomeLabel = new Label("Inventory Management System");
        TextField productIdField = new TextField();
        productIdField.setPromptText("Product ID");
        TextField productNameField = new TextField();
        productNameField.setPromptText("Product Name");
        TextField quantityField = new TextField();
        quantityField.setPromptText("Quantity");
        TextField priceField = new TextField();
        priceField.setPromptText("Price");
        Button addProductButton = new Button("Add Product");

        // Event handler for adding a new product
        addProductButton.setOnAction(event -> {
            // Retrieve input values from text fields
            String productId = productIdField.getText();
            String productName = productNameField.getText();
            int quantity = Integer.parseInt(quantityField.getText());
            double price = Double.parseDouble(priceField.getText());

            // Create a new electronics product and add it to the inventory
            Product newProduct = new Electronics(productId, productName, quantity, price, "Apple", inventory);
            inventory.storeItem(newProduct);

            // Clear input fields
            productIdField.clear();
            productNameField.clear();
            quantityField.clear();
            priceField.clear();

            // Show success alert
            showAlert(Alert.AlertType.INFORMATION, "Success", "Product added successfully!");
        });

        // Create a layout for the UI components
        VBox layout = new VBox(10);
        layout.getChildren().addAll(welcomeLabel, productIdField, productNameField, quantityField, priceField, addProductButton);

        // Create a scene with the layout
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setTitle("Inventory Management");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Displays an alert dialog with the specified type, title, and message.
     * 
     * @param alertType The type of the alert (e.g. INFORMATION, ERROR).
     * @param title The title of the alert.
     * @param message The message to be displayed in the alert.
     */
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Main method to launch the JavaFX application
    public static void main(String[] args) {
        launch(args);
    }
}
