public class LoginController {
    
}
package com.example.app;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class LoginController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private CheckBox rememberMeCheckBox;

    @FXML
    private Label forgotPasswordLabel;

    @FXML
    private Button signInButton;

    @FXML
    private Button signUpButton;

    @FXML
    private CheckBox showPasswordCheckBox;

    @FXML
    private TextField visiblePasswordField;

    @FXML
    public void initialize() {
        
        visiblePasswordField.managedProperty().bind(showPasswordCheckBox.selectedProperty());
        visiblePasswordField.visibleProperty().bind(showPasswordCheckBox.selectedProperty());
        visiblePasswordField.textProperty().bindBidirectional(passwordField.textProperty());

        passwordField.managedProperty().bind(showPasswordCheckBox.selectedProperty().not());
        passwordField.visibleProperty().bind(showPasswordCheckBox.selectedProperty().not());
    }

    @FXML
    private void handleSignIn() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/app/main_page.fxml"));
            Scene mainScene = new Scene(loader.load());
    
            
            Stage stage = (Stage) signInButton.getScene().getWindow();
            stage.setScene(mainScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }

    @FXML
    private void handleSignUp() {
        System.out.println("Redirecting to Sign Up...");
        
    }

    @FXML
    private void handleForgotPassword(MouseEvent event) {
        System.out.println("Redirecting to Password Recovery...");
        
    }
}
