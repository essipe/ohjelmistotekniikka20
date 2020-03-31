/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import domain.BoardService;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author essip
 */
public class Connect4UI extends Application {

    BorderPane borderpane = new BorderPane();
    GridPane gridpane = new GridPane();
    BoardService board = new BoardService();

    @Override
    public void start(Stage window) {
        gridpane.setStyle("-fx-background-color: #2B60DE;");
        for (int x = 1; x <= 7; x++) {
            int row = x;
            final Button button = new Button("drop");
            gridpane.add(button, x, 1);
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    int col = board.drop(row);
                    if (col != 0) {
                        Circle circle = new Circle(20);
                        circle.setFill(Color.RED);
                        gridpane.add(circle, row, col + 1);
                    }
                }
            });
            for (int y = 1; y <= 6; y++) {
                //
                Circle circle = new Circle(20);
                circle.setFill(Color.ALICEBLUE);
                circle.setCenterX(100.0f);
                circle.setCenterY(100.0f);
                circle.setRadius(20.0f);
                gridpane.add(circle, x, y + 1);
            }
        }
        borderpane.setCenter(gridpane);
        Scene scene = new Scene(borderpane);
        window.setTitle("Connect Four");
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
