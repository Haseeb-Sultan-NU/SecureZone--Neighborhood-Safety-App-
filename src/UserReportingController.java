package com.example.app;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.util.List;

public class UserReportingController {

    @FXML
    private ComboBox<String> incidentTypeDropdown;

    @FXML
    private TextArea incidentDescription;

    @FXML
    private TextField locationField;

    @FXML
    private CheckBox anonymousCheckbox;

    @FXML
    private Label uploadedFilesLabel;

    private List<File> selectedFiles;

    @FXML
    public void initialize() {
       
        incidentTypeDropdown.getItems().addAll("Crime", "Accident", "Hazard");
    }

    @FXML
    private void handleUploadFiles() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload Photos/Videos");
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Images & Videos", "*.png", "*.jpg", "*.jpeg", "*.mp4", "*.mov")
        );

        selectedFiles = fileChooser.showOpenMultipleDialog(new Stage());

        if (selectedFiles != null) {
            uploadedFilesLabel.setText("Files Selected: " + selectedFiles.size());
        }
    }

    @FXML
    private void handleSubmitReport() {
        String type = incidentTypeDropdown.getValue();
        String description = incidentDescription.getText();
        String location = locationField.getText();
        boolean isAnonymous = anonymousCheckbox.isSelected();

        if (type == null || description.isEmpty() || location.isEmpty()) {
            showAlert("Error", "Please fill in all required fields.");
            return;
        }

        System.out.println("Report Submitted: " + type + ", " + location + ", Anonymous: " + isAnonymous);
       
        showAlert("Success", "Your report has been submitted successfully.");
        resetForm();
    }

    private void resetForm() {
        incidentTypeDropdown.setValue(null);
        incidentDescription.clear();
        locationField.clear();
        anonymousCheckbox.setSelected(false);
        uploadedFilesLabel.setText("");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
