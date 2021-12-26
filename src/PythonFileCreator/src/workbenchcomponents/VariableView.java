/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workbenchcomponents;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author G-sta
 */
public class VariableView {
    
    private double width, height;

    
    private final VBox content;
    
    
    private final VBox header_area;
    private final Text header;

    
    private final ScrollPane variables_view;
    private final VBox variables;


    private final VBox button_area;
    private final Button add_section_button;
    
    public VariableView(double window_width, double window_height) {
        content = new VBox();
        
        variables = new VBox();
        variables_view = new ScrollPane(variables);
        
        width = (window_width/4);
        height = (window_height/2);
        
        header_area = new VBox();
        header = new Text("Variables");
        header.setTextAlignment(TextAlignment.CENTER);
        header.setUnderline(true);
        header_area.getChildren().add(header);
        header_area.setMargin(header, new Insets(10,10,10,10));
        header_area.setPrefHeight(40);
        
        button_area = new VBox();
        add_section_button = new Button("New Variable");
        button_area.getChildren().add(add_section_button);
        button_area.setMargin(add_section_button, new Insets(10,10,10,10));
        button_area.setPrefHeight(40);
        
        resizeDimensions();
        applyDefaultStyle();
        
        content.getChildren().addAll(header_area, variables_view, button_area);
    }
    
    public VBox getDisplay() { return content; }
    
    private void applyDefaultStyle() {
        content.setStyle("-fx-background-color: #009999; -fx-text-fill: white;");
        variables.setStyle("-fx-background-color: #009999; -fx-text-fill: white;");
        header.setFont(Font.font ("Times New Roman", 14));
        header.setFill(Color.WHITE);
    }
    
    /*
    public void applyStyle(String background_color, String text_color) {
        content.setStyle("-fx-background-color: " + background_color + "; -fx-text-fill: " + text_color + ";");
        content.applyCss();
    }
    */
    
    private void resizeDimensions() {
        content.setPrefSize(width, height);
        variables.setPrefSize(width - 15, height - 
                (header_area.getPrefHeight() + button_area.getPrefHeight()));
        variables_view.setPrefSize(width, variables.getPrefHeight());
    }
    
    
    public void resizeDimensions(double window_width, double window_height) {
        width = (window_width/4);
        height = (window_height/2);
        resizeDimensions();
    }
}
