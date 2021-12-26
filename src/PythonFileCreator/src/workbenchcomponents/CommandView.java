/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workbenchcomponents;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


/**
 *
 * @author G-sta
 */
public class CommandView {  
    private final ScrollPane display;
    private final VBox content;
           
    private VBox commands_variable;
    
    public CommandView() {
        this.content = new VBox();
        
        
        Button variables_view_filter = new Button("+");
        variables_view_filter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            }
        });
        
        
        this.display = new ScrollPane(this.content);
    }
    
    
    private void addCommandView_Variable() {
        commands_variable = new VBox();
        this.content.getChildren().add(commands_variable);
        TextField variables_title = new TextField("variable");
        Button variables_view_filter = new Button("+");
        variables_view_filter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
            }
        });
    }
    
    private VBox createCommandGroup(String name) {
        VBox command = new VBox();
        
        
        Button view_filter = new Button("+");
        
        command.getChildren().addAll(view_filter);
        
        return command;
    }
}
