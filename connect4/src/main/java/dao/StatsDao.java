/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author essip
 */
public class StatsDao {

    String file;

    public StatsDao(String file) {
        this.file = file;
    }

    /**
     * Writes the name of the winner to a text file
     *
     * @param winner Name of the winner
     * @throws Exception exception
     */
    public void writeWinner(String winner) throws Exception {
        try (PrintWriter writer = new PrintWriter(new File(file))) {
            writer.println(winner);
            writer.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    /**
     * Reads the name of the last winner from a text file
     *
     * @return Returns the name of the last winner
     */
    public String getLastWinner() {
        String lastWinner = "";
        try (Scanner reader = new Scanner(new File(file))) {
            while (reader.hasNextLine()) {
                lastWinner = reader.nextLine();
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        return lastWinner;
    }

}
