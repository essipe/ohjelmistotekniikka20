/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domain.Board;
import dao.StatsDao;

import java.util.HashMap;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    int rows = 6;
    int columns = 7;
    Board board;
    Label turn;
    Label previousWinner;
    Stage window;
    HashMap<Integer, String> playerNames;
    TextField player1Field = new TextField("1");
    TextField player2Field = new TextField("2");
    StatsDao statsDao = new StatsDao("wins.txt");

    @Override
    public void start(Stage window) {
        this.window = window;
        mainMenu(window);
    }

    /**
     * Sets the first menu window that opens when the application is run
     *
     * @param window game window
     */
    public void mainMenu(Stage window) {
        VBox mainmenu = new VBox();
        playerNames = new HashMap<>();
        Label text = new Label("Welcome to Connect Four! \n In this game you play against your opponent taking turns \n dropping your disks into a grid and trying to be the first one \n to get four of your own disks in a vertical, horizontal or diagonal line. \n");
        Label text2 = new Label("\n Game starts on a standard 7x6 grid by default. \n If you want to change the size of the grid, select here.");
        Button start = new Button("Start game");
        start.setOnAction((event) -> {
            playerNames.put(1, player1Field.getText());
            playerNames.put(2, player2Field.getText());
            initGame(window);
        });
        mainmenu.getChildren().add(text);
        mainmenu.getChildren().add(textFields());
        mainmenu.getChildren().add(text2);
        mainmenu.getChildren().add(boardSizeButtons());
        mainmenu.getChildren().add(start);
        mainmenu.setAlignment(Pos.CENTER);
        mainmenu.setPadding(new Insets(10));
        Scene menuscene = new Scene(mainmenu);
        window.setScene(menuscene);
        window.setTitle("Connect Four");
        window.show();
    }

    /**
     * Sets the buttons to change the size of the game grid
     *
     * @return Returns the HBox element with buttons
     */
    public HBox boardSizeButtons() {
        HBox sizes = new HBox();
        Button small = new Button("6x5");
        Button big = new Button("8x7");
        small.setOnAction((event) -> {
            rows = 5;
            columns = 6;
        });
        big.setOnAction((event) -> {
            rows = 7;
            columns = 8;
        });
        sizes.getChildren().add(small);
        sizes.getChildren().add(big);
        sizes.setPadding(new Insets(5));
        sizes.setAlignment(Pos.CENTER);
        return sizes;
    }

    /**
     * Sets the text fields for player names
     *
     * @return Returns the HBox element with fields
     */
    public HBox textFields() {
        HBox fields = new HBox();
        fields.getChildren().add(new Label(" Player 1 name: "));
        fields.getChildren().add(player1Field);
        fields.getChildren().add(new Label(" Player 2 name: "));
        fields.getChildren().add(player2Field);
        fields.setPadding(new Insets(10));
        fields.setAlignment(Pos.CENTER);
        return fields;
    }

    /**
     * Initializes game window
     *
     * @param window gam window
     */
    public void initGame(Stage window) {
        buttons = new HBox();
        winmenu = new HBox();
        borderpane = new BorderPane();
        gameGrid = new GridPane();
        board = new Board(columns, rows);
        turn = new Label("Turn: " + playerNames.get(board.getTurn()));
        previousWinner = new Label("Winner of previous game: " + statsDao.getLastWinner());
        setButtons();
        setGrid();
        setSideMenu();
        borderpane.setCenter(sideMenu);
        borderpane.setTop(buttons);
        borderpane.setLeft(gameGrid);
        borderpane.setPadding(new Insets(5, 0, 10, 10));
        Scene scene = new Scene(borderpane);
        window.setTitle("Connect Four");
        window.setScene(scene);
        window.show();
    }

    /**
     * Initializes the side menu bar
     */
    public void setSideMenu() {
        sideMenu = new VBox();
        sideMenu.getChildren().add(previousWinner);
        sideMenu.getChildren().add(turn);
        sideMenu.setAlignment(Pos.CENTER);
        sideMenu.setPadding(new Insets(5));
    }

    /**
     * Initializes the buttons used to drop disks
     */
    public void setButtons() {
        for (int i = 1; i <= columns; i++) {
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

        for (int x = 1; x <= columns; x++) {
            for (int y = 1; y <= rows; y++) {
                Circle bg = backgroundCircle();
                gameGrid.add(bg, x, y + 1);
            }
        }
    }

    /**
     * Method for creating one background circle to first fill in the grid
     *
     * @return Returns the background circle
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
     * @return Returns the drawn disk
     */
    public Circle drawDisk() {
        turn.setText("Turn: " + playerNames.get(board.getTurn()));
        if (board.getWin()) {
            showGameOverText(1);
            try {
                System.out.println(playerNames.get(board.getWinner()));
                statsDao.writeWinner(playerNames.get(board.getWinner()));
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if (board.getBoardFull() && !board.getWin()) {
            showGameOverText(2);
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
     *
     * @param whichText 1 if win, 2 if tie
     */
    public void showGameOverText(int whichText) {
        int winner = board.getWinner();
        Label text1 = new Label("Player " + playerNames.get(winner) + " has won!");
        Label text2 = new Label("Game ended in a tie! Maybe try again?");
        Button newGame = new Button("New game");
        if (whichText == 1) {
            winmenu.getChildren().add(text1);
        } else if (whichText == 2) {
            winmenu.getChildren().add(text2);
        }
        winmenu.getChildren().add(newGame);
        newGame.setOnAction(((event) -> {
            start(window);
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
