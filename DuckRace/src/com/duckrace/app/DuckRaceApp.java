package com.duckrace.app;

import duckrace.Board;
import duckrace.Reward;

import java.util.Locale;
import java.util.Scanner;

import static duckrace.Reward.*;

/*
 * Application "controller"
 * Directs overall flow of the application
 * Prompts users for inputs and forwards those inputs into the system
 */
public class DuckRaceApp {
    private final Scanner scanner = new Scanner(System.in);
    private final Board board = new Board();
    //high-level overall flow of the application
    public void execute(){
        welcome();
        showBoard();
        int id = promptForId();
        Reward reward = promptForReward();
        updateBoard(id, reward);
        showBoard();
    }
    //user inputs are passed into the system, let the system classes do the work
    private void updateBoard(int id, Reward reward) {
        board.update(id, reward);
    }

    private Reward promptForReward() {
        Reward reward = null;
        boolean validInput = false;
        while(!validInput){
            System.out.print("Please enter [D]ebit card or [P]rizes: ");
            String input = scanner.nextLine().trim().toUpperCase();
            if(input.matches("D|P")){
             validInput = true;
             reward = ("D".equals(input)) ? DEBIT_CARD : PRIZES;
            }
        }
        return reward;
    }

    private int promptForId() {
        int id = 0;
        boolean validInput = false;
        while(!validInput){
            System.out.print("Please enter id of the winner [1-21]: "); //TODO: don't hardcore the 21
            String input = scanner.nextLine().trim();
            if(input.matches("\\d{1,2}")){ //any digit one or two times
                id = Integer.parseInt(input); //safe to do so, because you know you got digits
                if(id > 1 && id <= 21){
                    validInput = true;
                }
            }
        }
        return id;
    }

    private void showBoard() {
        board.show();
    }

    private void welcome() {
        System.out.println("WELCOME TO THE DUCKRACE");
    }
}