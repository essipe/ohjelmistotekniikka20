/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author essip
 */
public class connect4 extends Application {

    @Override
    public void start(Stage window) {
        BorderPane borderpane = new BorderPane();
        GridPane gridpane = new GridPane();

        Circle circle = new Circle();
        circle.setCenterX(100.0f);
        circle.setCenterY(100.0f);
        circle.setRadius(20.0f);

        for (int x = 1; x <= 7; x++) {
            gridpane.add(new Button("drop"), x, 1);
            for (int y = 1; y <= 6; y++) {
                gridpane.add(new Circle(20), x, y+1);
            }
        }
        borderpane.setCenter(gridpane);
        Scene scene = new Scene(borderpane);

        window.setTitle("Connecr Four");
        window.setScene(scene);

        window.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
