package com.example.app;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainPageController {

    @FXML
    private Label userReportingSection;

    @FXML
    private Label safetyMapSection;

    @FXML
    private Label emergencyContactsSection;

    @FXML
    private Label safetyTipsSection;

    @FXML
    public void initialize() {
        
    }

    @FXML
    private void handleUserReporting(MouseEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/app/user_reporting.fxml"));
        Scene reportingScene = new Scene(loader.load());

        
        Stage stage = (Stage) ((Label) event.getSource()).getScene().getWindow();
        stage.setScene(reportingScene);
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    @FXML
    private void handleSafetyMap(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/app/safety_map.fxml"));
            Scene mapScene = new Scene(loader.load());
    
           
            Stage stage = (Stage) ((Label) event.getSource()).getScene().getWindow();
            stage.setScene(mapScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleEmergencyContacts(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/app/emergency_contacts.fxml"));
            Scene contactsScene = new Scene(loader.load());
    
           
            Stage stage = (Stage) ((Label) event.getSource()).getScene().getWindow();
            stage.setScene(contactsScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleSafetyTips(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/app/safety_tips.fxml"));
            Scene tipsScene = new Scene(loader.load());
    
          
            Stage stage = (Stage) ((Label) event.getSource()).getScene().getWindow();
            stage.setScene(tipsScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
