import java.util.Random;
import java.util.Scanner;

public class OrderNChaos {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Order and Chaos");
        System.out.println("Do you want to be Order or Chaos?");
        String choice = sc.nextLine();
        //here order aims to get 5 pieces in a row either vertically, horizontally, or diagonally.
        if (choice.equalsIgnoreCase("Order")) {
            GameBoard board = new GameBoard(6);
            board.printGameBoard();
            int counter1 = 0;
            int counter2 = 0;

            while (true) {
                System.out.println("Do you want to select X or 0?");
                String inputString = sc.nextLine();
                int p;
                if(inputString.equalsIgnoreCase(("X")))
                {  p = 1; }
                else p = 0;
                while (true) {
                    System.out.println("Player " + inputString + " Enter your move");
                    String s = inputValue(sc, board, (p == 0 ? '0' : 'X'));
                    String[] arr = s.split(",");
                    int r = Integer.parseInt(arr[0]);
                    int c = Integer.parseInt(arr[1]);
                    board.board[r][c] = (p == 0 ? '0' : 'X');
                    if (board.winnerCheck((p == 0 ? '0' : 'X'))) {
                        System.out.println("player " + (p == 0 ? '0' : 'X') + " is win");
                        if (p == 0) {
                            counter1++;
                        } else {
                            counter2++;
                        }
                        System.out.println("player 0 score is " + counter1);
                        System.out.println("player X score is " + counter2);
                        break;
                    }
                    if (board.drawCheck()) {
                        System.out.println("Game is draw");
                        break;
                    }
                    board.printGameBoard();
                    System.out.println();
                    String change = "n";
                    System.out.println("Next Chaos turn: Choose X or 0");
                    change = sc.nextLine();
                    if (change.equalsIgnoreCase("X")) {
                    p = 1; }
                        else p = 0;
                }
                System.out.println("Want to continue(y/n)");
                choice = sc.nextLine();
                if (!choice.equalsIgnoreCase("y")) {
                    break;
                }
            }
        } else if(choice.equalsIgnoreCase("Chaos")) {
            int t1 = 0;
            int t2 = 0;
            while (true) {
                System.out.println("Do you want to select X or 0?");
                //int n = sc.nextInt();
                String inputString = sc.nextLine();
                int p;
                if(inputString.equalsIgnoreCase(("X")))
                {  p = 1; }
                else p = 0;
                GameBoard board = new GameBoard(6);
                board.printGameBoard();
                while (true) {
                    //int num = random.nextInt(n / 2 + 1 - 1) + 1;
                    System.out.println("Player " + inputString + " Enter your move");
                    String s = inputValue(sc, board, (p == 0 ? '0' : 'X'));
                    String[] arr = s.split(",");
                    int r = Integer.parseInt(arr[0]);
                    int c = Integer.parseInt(arr[1]);
                    board.board[r][c] = (p == 0 ? '0' : 'X');
                    if (board.winnerCheck((p == 0 ? '0' : 'X'))) {
                        System.out.println("Player " + (p == 0 ? '0' : '1') + " is win");
                        if (p == 0) {
                            t1++;
                        } else {
                            t2++;
                        }
                        System.out.println("Team 0 score is " + t1);
                        System.out.println("Team 1 score is " + t2);
                        break;
                    }
                    if (board.drawCheck()) {
                        System.out.println("Game is draw");
                        break;
                    }
                    board.printGameBoard();
                    System.out.println();
                    //String change;
                    System.out.println("Next Order turn: Choose X or 0 ");
                    inputString = sc.nextLine();
                    if (inputString.equalsIgnoreCase("X")) {
                        p = 1; }
                    else p = 0;
                }

                System.out.println("Do you want to continue(y/n)");
                choice = sc.nextLine();
                if (!choice.equalsIgnoreCase("y")) {
                    System.out.println("Thank you for playing, comeback soon!!!");
                    break;
                }
            }
        }
    }

    private static String inputValue(Scanner sc, GameBoard board, char ch) {
        String s = sc.nextLine();
        String[] arr = s.split(",");
        int r = Integer.parseInt(arr[0]);
        int c = Integer.parseInt(arr[1]);
        if (board.board[r][c] == ' ') {
            return s;
        }
        System.out.println("OOPs! select any other position");
        return inputValue(sc, board, ch);
    }
}

