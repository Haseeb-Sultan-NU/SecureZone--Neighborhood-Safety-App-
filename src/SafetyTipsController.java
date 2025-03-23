package com.example.app;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

public class SafetyTipsController {

    @FXML
    private ListView<String> tipsList;

    @FXML
    private TextArea tipDetails;

    @FXML
    public void initialize() {
        
        tipsList.getItems().addAll(
                "🏠 Home Safety Checklist",
                "🚗 Car Safety Tips",
                "👤 Personal Safety Guidelines",
                "🏢 Local Safety Resources",
                "🚔 Crime Prevention Tips"
        );

        
        tipsList.setOnMouseClicked(event -> showTipDetails());
    }

    private void showTipDetails() {
        String selectedTip = tipsList.getSelectionModel().getSelectedItem();
        if (selectedTip != null) {
            String details = switch (selectedTip) {
                case "🏠 Home Safety Checklist" -> 
                        "- Lock all doors and windows before leaving\n" +
                        "- Install security cameras\n" +
                        "- Keep emergency contacts easily accessible";
                case "🚗 Car Safety Tips" -> 
                        "- Always lock your car\n" +
                        "- Avoid leaving valuables inside\n" +
                        "- Park in well-lit areas";
                case "👤 Personal Safety Guidelines" -> 
                        "- Be aware of your surroundings\n" +
                        "- Avoid walking alone at night\n" +
                        "- Carry a personal safety alarm";
                case "🏢 Local Safety Resources" -> 
                        "- Community Shelter: 123 Main St\n" +
                        "- Women’s Help Center: +1 800-555-6789\n" +
                        "- Homeless Support: www.localhelp.org";
                case "🚔 Crime Prevention Tips" -> 
                        "- Report suspicious activity\n" +
                        "- Join a community watch program\n" +
                        "- Keep porch lights on at night";
                default -> "";
            };
            tipDetails.setText(details);
        }
    }
}
