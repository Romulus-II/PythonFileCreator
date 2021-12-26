/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pythonfilecreator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import workbenchcomponents.SectionView;
import workbenchcomponents.VariableView;

/**
 *
 * @author G-sta
 */
public class PythonFileCreator extends Application {
    
    private double window_width = 1150, window_height = 650;
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        
        HBox root = new HBox();
        
        VBox section_1 = new VBox();
     
        SectionView section_view = new SectionView(window_width, window_height);
        section_1.getChildren().add(section_view.getDisplay());
        VariableView variable_view = new VariableView(window_width, window_height);
        section_1.getChildren().add(variable_view.getDisplay());
        
        root.getChildren().addAll(section_1);
        
        Scene scene = new Scene(root, window_width, window_height);
       
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
