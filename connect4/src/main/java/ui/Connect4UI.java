/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domain.Board;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author essip
 */
public class Connect4UI extends Application {

    HBox buttons;
    HBox winmenu;
    VBox menu;
    BorderPane borderpane;
    GridPane gridpane;
    Board board;
    Label turn = new Label("Turn: Player 1");
    Label win = new Label();
    Stage window;
    @Override
    public void start(Stage window) {
        this.window = window;
        startGame(window);
    }
    public void startGame(Stage window) {
        buttons = new HBox();
        winmenu  = new HBox();
        borderpane = new BorderPane();
        gridpane = new GridPane();
        board = new Board();
        setButtons();
        setGrid();
        setMenu();
        borderpane.setRight(menu);
        borderpane.setTop(buttons);
        borderpane.setCenter(gridpane);
        borderpane.setPrefSize(450, 350);
        Scene scene = new Scene(borderpane);
        window.setTitle("Connect Four");
        window.setScene(scene);
        window.show();
    }

    public void setMenu() {
        menu = new VBox();
        menu.getChildren().add(turn);
        menu.getChildren().add(win);
        menu.setAlignment(Pos.CENTER);
        menu.setPadding(new Insets(5));
    }

    public void setButtons() {
        for (int i = 1; i <= 7; i++) {
            int row = i;
            final Button button = new Button();
            button.setShape(new Circle(20));
            button.setMinSize(40, 40);
            button.setMaxSize(40, 40);
            buttons.getChildren().add(button);
            buttons.setSpacing(2);
            buttons.setPadding(new Insets(2));
            buttons.setAlignment(Pos.BASELINE_CENTER);
            button.setOnAction((ActionEvent event) -> {
                int col = board.drop(row);
                if (col != 0) {
                    Circle disk = dropDisk();
                    gridpane.add(disk, row, col + 1);
                }
            });
        }
    }

    public void setGrid() {
        gridpane.setStyle("-fx-background-color: #2B60DE;");
        gridpane.setHgap(3);
        gridpane.setVgap(3);
        gridpane.setPadding(new Insets(10, 10, 10, 10));
        gridpane.setMinSize(323, 280);
        gridpane.setMaxSize(323, 280);
        for (int x = 1; x <= 7; x++) {
            for (int y = 1; y <= 6; y++) {
                Circle bg = backgroundCircle();
                gridpane.add(bg, x, y + 1);
            }
        }
    }

    public Circle backgroundCircle() {
        Circle circle = new Circle(20);
        circle.setFill(Color.ALICEBLUE);
        circle.setCenterX(100.0f);
        circle.setCenterY(100.0f);
        circle.setRadius(20.0f);
        return circle;
    }

    public Circle dropDisk() {
        turn.setText("Turn: Player " + board.getTurn());
        if (board.isWin()) {
            showWinningText();
        }
        if (board.getTurn() == 1) {
            Circle circle = new Circle(20);
            circle.setFill(Color.RED);
            return circle;
        } else {
            Circle circle = new Circle(20);
            circle.setFill(Color.YELLOW);
            return circle;
        }
    }
    public void showWinningText() {
        Label text = new Label("Player "+ board.getTurn() + " has won!");
        Button newGame = new Button("New game");
        winmenu.getChildren().add(text);
        winmenu.getChildren().add(newGame);
        newGame.setOnAction(((event) -> {
            startGame(window);
        }));
        borderpane.setTop(winmenu);
        winmenu.setAlignment(Pos.BASELINE_CENTER);
        winmenu.setSpacing(5);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
