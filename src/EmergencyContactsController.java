package com.example.app;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;

public class EmergencyContactsController {

    @FXML
    private ListView<String> emergencyList;

    @FXML
    public void initialize() {
        
        emergencyList.getItems().addAll(
                "🚔 Police: 15",
                "🚑 Medical Emergency: 1122",
                "🔥 Fire Department: 16",
                "👥 Community Watch Group: +92 312 0945713",
                "📞 Personal Emergency Contact: +92 3337840986"
        );

        
        emergencyList.setOnMouseClicked(event -> handleEmergencyCall(event));
    }

    private void handleEmergencyCall(MouseEvent event) {
        if (event.getClickCount() == 2) { // Double-click to "call"
            String selected = emergencyList.getSelectionModel().getSelectedItem();
            if (selected != null) {
                showCallDialog(selected);
            }
        }
    }

    private void showCallDialog(String contact) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Call Emergency Contact");
        alert.setHeaderText(null);
        alert.setContentText("Calling: " + contact);
        alert.showAndWait();
    }
}
