/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nearmiss;

import java.util.Scanner;

/**
 *
 * @author: Nolan
 * @assignment:
 */
public class GameLogic {

    private Board board;
    private Boolean running;
    private Scanner s;

    public GameLogic() {
        running = true;
        s = new Scanner(System.in);
        board = new Board();
        board.initBoard();
        run();
    }

    public void printBoard() {
        for (Object[] i : board.getEntries()) {
            for (Object j : i) {
                if (j != null) {
                    System.out.print(j + "\t");
                }
            }
            System.out.println();
        }

    }

    public void run() {
        while (running) {
            System.out.println("\f");
            int x = 0;
            int y = 0;
            int next = (int) (Math.random() * 10);
            System.out.println("The number is: " + next + "\nWhere would you like to put it?\n");
            printBoard();

            boolean placing = true;
            if (board.boardFilled()) {
                running = false;
            } 
            else {
                while (placing) {
                    boolean done = true;
                    while (done) {
                        System.out.println("Enter the x coord:");
                        try {
                            x = s.nextInt();
                            done = false;
                        } catch (Exception e) {
                            System.out.println("Try again");
                            s.next();
                        }
                    }
                    done = true;

                    while (done) {
                        System.out.println("Enter the y coord:");
                        try {
                            y = s.nextInt();
                            done = false;
                        } catch (Exception e) {
                            System.out.println("Try again");
                            s.next();
                        }
                    }
                    
                    if(!board.spaceFilled(x, y))
                    {
                        placing = false;
                        board.placeNumber(new Integer(next), x, y);
                    }
                    else
                    {
                        System.out.println("That space is filled");
                    }
                }
            }
        }
        System.out.println("Score: " + board.computeScore());
    }

}
