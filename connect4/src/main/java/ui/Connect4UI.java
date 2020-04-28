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
import javafx.scene.layout.*;
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
    VBox sideMenu;
    BorderPane borderpane;
    GridPane gameGrid;
    Board board;
    Label turn;
    Label win;
    Stage window;

    @Override
    public void start(Stage window) {
        this.window = window;
        mainMenu(window);
    }

    /**
     * Sets the first menu window that opens when the application is run
     *
     * @param window
     */
    public void mainMenu(Stage window) {
        VBox mainmenu = new VBox();
        Label text = new Label("Welcome to Connect Four! \n In this game you play against your opponent taking turns \n dropping your disks into a grid and trying to be the first one \n to get four of your own disks in a vertical, horizontal or diagonal line.");
        Button start = new Button("Start game");
        start.setOnAction((event) -> {
            initGame(window);
        });
        mainmenu.getChildren().add(text);
        mainmenu.getChildren().add(start);
        mainmenu.setAlignment(Pos.CENTER);
        mainmenu.setPadding(new Insets(5));
        Scene menuscene = new Scene(mainmenu);
        window.setScene(menuscene);
        window.setTitle("Connect Four");
        window.show();
    }

    /**
     * Initializes game window
     *
     * @param window
     */
    public void initGame(Stage window) {
        buttons = new HBox();
        winmenu = new HBox();
        borderpane = new BorderPane();
        gameGrid = new GridPane();
        board = new Board();
        turn = new Label("Turn: Player 1");
        win = new Label();
        setButtons();
        setGrid();
        setMenu();
        borderpane.setCenter(sideMenu);
        borderpane.setTop(buttons);
        borderpane.setLeft(gameGrid);
        borderpane.setPrefSize(450, 350);
        borderpane.setPadding(new Insets(5, 0, 10, 10));
        Scene scene = new Scene(borderpane);
        window.setTitle("Connect Four");
        window.setScene(scene);
        window.show();
    }

    /**
     * Initializes the side menu bar
     */
    public void setMenu() {
        sideMenu = new VBox();
        sideMenu.getChildren().add(turn);
        sideMenu.getChildren().add(win);
        sideMenu.setAlignment(Pos.CENTER);
        sideMenu.setPadding(new Insets(5));
    }

    /**
     * Initializes the buttons used to drop disks
     */
    public void setButtons() {
        for (int i = 1; i <= 7; i++) {
            int row = i;
            Button button = new Button();
            button.setShape(new Circle(20));
            button.setMinSize(40, 40);
            button.setMaxSize(40, 40);
            buttons.getChildren().add(button);
            buttons.setSpacing(3);
            buttons.setPadding(new Insets(5, 0, 10, 13));
            buttons.setAlignment(Pos.BASELINE_LEFT);
            button.setOnAction((ActionEvent event) -> {
                int col = board.drop(row);
                if (col != 0) {
                    Circle disk = drawDisk();
                    gameGrid.add(disk, row, col + 1);
                }
            });
        }
    }

    /**
     * Initializes the game grid
     */
    public void setGrid() {
        gameGrid.setStyle("-fx-background-color: #2B60DE;");
        gameGrid.setHgap(3);
        gameGrid.setVgap(3);
        gameGrid.setPadding(new Insets(10, 10, 10, 10));
        gameGrid.setMinSize(323, 280);
        gameGrid.setMaxSize(323, 280);
        for (int x = 1; x <= 7; x++) {
            for (int y = 1; y <= 6; y++) {
                Circle bg = backgroundCircle();
                gameGrid.add(bg, x, y + 1);
            }
        }
    }

    /**
     * Method for creating one background circle to first fill in the grid
     *
     * @return
     */
    public Circle backgroundCircle() {
        Circle circle = new Circle(20);
        circle.setFill(Color.ALICEBLUE);
        circle.setCenterX(100.0f);
        circle.setCenterY(100.0f);
        circle.setRadius(20.0f);
        return circle;
    }

    /**
     * Draws the dropped disk on the grid
     *
     * @return
     */
    public Circle drawDisk() {
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

    /**
     * If a player has won, this method sets the winning text and a button to
     * start a new game
     */
    public void showWinningText() {
        int winner;
        if (board.getTurn() == 1) {
            winner = 2;
        } else {
            winner = 1;
        }
        Label text = new Label("Player " + winner + " has won!");
        Button newGame = new Button("New game");
        winmenu.getChildren().add(text);
        winmenu.getChildren().add(newGame);
        newGame.setOnAction(((event) -> {
            initGame(window);
        }));
        borderpane.setTop(winmenu);
        winmenu.setAlignment(Pos.BASELINE_CENTER);
        winmenu.setSpacing(5);
        winmenu.setPadding(new Insets(10, 20, 20, 0));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
