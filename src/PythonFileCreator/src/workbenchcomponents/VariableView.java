/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workbenchcomponents;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author G-sta
 */
public class VariableView {
    
    private final ScrollPane view;
    private final VBox content;
    private double width, height;
    
    public VariableView(double window_width, double window_height) {
        this.content = new VBox();
        this.view = new ScrollPane(content);
        this.width = (window_width/4);
        this.height = (window_height/2);
        
        resizeDimensions();
        applyDefaultStyle();
    }
    
    public ScrollPane getView() { return view; }
    
    private void applyDefaultStyle() {
        content.setStyle("-fx-background-color: #0086b3; -fx-text-fill: white;");
        content.applyCss();
    }
    
    public void applyStyle(String background_color, String text_color) {
        content.setStyle("-fx-background-color: " + background_color + "; -fx-text-fill: " + text_color + ";");
        content.applyCss();
    }
    
    private void resizeDimensions() {
        this.content.setPrefSize(this.width - 15, this.height);
        this.view.setPrefSize(this.width, this.height);
    }
    
    public void resizeDimensions(double window_width, double window_height) {
        this.width = (window_width/4);
        this.height = (window_height/2);
        this.content.setPrefSize(this.width - 15, this.height);
        this.view.setPrefSize(this.width, this.height);
    }
}
