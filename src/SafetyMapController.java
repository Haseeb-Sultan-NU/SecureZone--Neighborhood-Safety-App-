package com.example.app;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class SafetyMapController {

    @FXML
    private WebView mapView;

    @FXML
    private ComboBox<String> incidentFilter;

    private WebEngine webEngine;

    @FXML
    public void initialize() {
        webEngine = mapView.getEngine();
        loadMap();

     
        incidentFilter.getItems().addAll("All", "Crime", "Accident", "Hazard");
        incidentFilter.setValue("All");
        
        
        incidentFilter.setOnAction(event -> applyFilter());
    }

    private void loadMap() {
        
        webEngine.load(getClass().getResource("/com/example/app/map.html").toExternalForm());
    }

    private void applyFilter() {
        String selectedFilter = incidentFilter.getValue();
        webEngine.executeScript("filterIncidents('" + selectedFilter + "')");
    }
}
