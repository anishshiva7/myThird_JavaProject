import java.util.*;
public class MazeRunner {
    public static void main(String[] args) {
        Maze myMap = new Maze();
        intro();
        myMap.printMap();
        int moves = 0;
        while (myMap.didIWin() == false) {
            String move = userMove(myMap);
            System.out.println(move);
            moves++;
            movesMessage(moves);
        }
        if (myMap.didIWin() == true) {
            System.out.println("Congratulations, you made it out alive!");
            System.out.println("and you did it in " + moves + " moves");
        }
    }

    public static void intro() {
        System.out.println("Welcome to Maze Runner!\nHere is your current position: ");
    }

    public static String userMove(Maze myMap) {
        Scanner input = new Scanner(System.in);
        System.out.print("Where would you like to move? (R, L, U, D)");
        String key = input.next();
        while ("RLUDrlud".indexOf(key) < 0) {
            System.out.print("Please enter a valid direction (R, L, U, D): ");
            key = input.next();
        }
        if (key.equalsIgnoreCase("R") && myMap.canIMoveRight()) {
            myMap.moveRight();
        } else if (key.equalsIgnoreCase("L") && myMap.canIMoveLeft()) {
            myMap.moveLeft();
        } else if (key.equalsIgnoreCase("U") && myMap.canIMoveUp()) {
            myMap.moveUp();
        } else if (key.equalsIgnoreCase("D") && myMap.canIMoveDown()) {
            myMap.moveDown();
        } else if (myMap.isThereAPit("R") || myMap.isThereAPit("L") || myMap.isThereAPit("U") || myMap.isThereAPit("D")) {
            navigatePit(myMap, key);
        } else {
            System.out.println("Sorry you've hit a wall.");
        }
        myMap.printMap();
        return key;
    }

    public static void movesMessage(int moves) {
        if (moves == 50) {
            System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes");
        } else if (moves == 75) {
            System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
        } else if (moves == 90) {
            System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
        } else if (moves == 100) {
            System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
            System.out.println("Sorry, but you didn't escape in time- you lose!");
            System.exit(0);
        }
    }

    public static String navigatePit(Maze myMap, String move) {
        if (move.equalsIgnoreCase("R") && myMap.isThereAPit("R")) {
            System.out.println("Watch out! There's a pit ahead, jump it? (y/n) ");
            Scanner input = new Scanner(System.in);
            String answer = input.nextLine();
            answer = answer.toLowerCase();
            if (answer.startsWith("y")) {
                myMap.jumpOverPit("R");
            }
        } else if (move.equalsIgnoreCase("L") && myMap.isThereAPit("L")) {
            System.out.println("Watch out! There's a pit ahead, jump it? (y/n) ");
            Scanner input = new Scanner(System.in);
            String answer = input.nextLine();
            answer = answer.toLowerCase();
            if (answer.startsWith("y")) {
                myMap.jumpOverPit("L");
            }
        } else if (move.equalsIgnoreCase("U") && myMap.isThereAPit("U")) {
            System.out.println("Watch out! There's a pit ahead, jump it? (y/n) ");
            Scanner input = new Scanner(System.in);
            String answer = input.nextLine();
            answer = answer.toLowerCase();
            if (answer.startsWith("y")) {
                myMap.jumpOverPit("U");
            }
        } else if (move.equalsIgnoreCase("D") && myMap.isThereAPit("D")) {
            System.out.println("Watch out! There's a pit ahead, jump it? (y/n) ");
            Scanner input = new Scanner(System.in);
            String answer = input.nextLine();
            answer = answer.toLowerCase();
            if (answer.startsWith("y")) {
                myMap.jumpOverPit("D");
            }
        }
        return move;
    }
}