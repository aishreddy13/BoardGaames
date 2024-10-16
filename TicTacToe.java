import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        //Random ran = new Random();
        Scanner scan = new Scanner(System.in);
        //Ask the user about the default or scalable size
        System.out.println("Do you want to play default board (3X3) or give different board size?");
        String sizeOption = scan.nextLine();
        //  The below condition is for default size
        if (sizeOption.equalsIgnoreCase("3")) {
            GameBoard TTTboard = new GameBoard();
            System.out.println("Welcome to Tic tac toe");
            TTTboard.printGameBoard();
            int counter1 = 0;
            int counter2 = 0;
            while (true) {
                int player = 0;
                while (true) {
                    System.out.println("Player " + (player == 0 ? "0" : "X") + " Enter your move");
                    String s = inputPosition(scan, TTTboard, (player == 0 ? '0' : 'X'));
                    String[] arr = s.split(",");
                    int row = Integer.parseInt(arr[0]);
                    int column = Integer.parseInt(arr[1]);
                    TTTboard.board[row][column] = (player == 0 ? '0' : 'X');
                    if (TTTboard.winnerCheck((player == 0 ? '0' : 'X'))) {
                        System.out.println("player " + (player == 0 ? '0' : 'X') + " is win");
                        if (player == 0) {
                            counter1++;
                        } else {
                            counter2++;
                        }
                        System.out.println("player 0 score is " + counter1);
                        System.out.println("player X score is " + counter2);
                        break;
                    }
                    if (TTTboard.drawCheck()) {
                        System.out.println("Game is draw");
                        break;
                    }
                    TTTboard.printGameBoard();
                    player = 1 - player;
                }
                System.out.println("Want to continue(y/n)");
                sizeOption = scan.nextLine();
                if (!sizeOption.equalsIgnoreCase("y")) {
                    break;
                }
            }
        }
        //The below code is for different size of code.
        else if(sizeOption.equalsIgnoreCase("4") || sizeOption.equalsIgnoreCase("5") || sizeOption.equalsIgnoreCase("6") ||
        sizeOption.equalsIgnoreCase("7") || sizeOption.equalsIgnoreCase("8") || sizeOption.equalsIgnoreCase("9") || sizeOption.equalsIgnoreCase("10") ) {
            int counter3 = 0;
            int counter4 = 0;
            while (true) {
                System.out.println("Enter the size of the board.");
                int n = scan.nextInt();
                scan.nextLine();
                int players = 0;
                GameBoard board = new GameBoard(n);
                board.printGameBoard();
                while (true) {
                    //int num = ran.nextInt(n / 2 + 1 - 1) + 1;
                    System.out.println("Team " + (players == 0 ? "0" : "X") + " Enter your move " );
                    String s = inputPosition(scan, board, (players == 0 ? '0' : 'X'));
                    String[] arr = s.split(",");
                    int row = Integer.parseInt(arr[0]);
                    int col = Integer.parseInt(arr[1]);
                    board.board[row][col] = (players == 0 ? '0' : 'X');
                    if (board.winnerCheck((players == 0 ? '0' : 'X'))) {
                        System.out.println("Team " + (players == 0 ? '0' : 'X') + " is win");
                        if (players == 0) {
                            counter3++;
                        } else {
                            counter4++;
                        }
                        System.out.println("Team 0 score is " + counter3);
                        System.out.println("Team 1 score is " + counter4);
                        break;
                    }
                    if (board.drawCheck()) {
                        System.out.println("Game is draw");
                        break;
                    }
                    board.printGameBoard();
                    players = 1 - players;
                }

                System.out.println("Do you want to continue(y/n)");
                sizeOption = scan.nextLine();
                System.out.println("Thank you for playing, comeback soon!!!");
                if (sizeOption.equalsIgnoreCase("n")) {

                    break;
                }
            }
        }
        else
            System.out.println("please enter a valid size from 4 to 10.");
    }


    private static String inputPosition(Scanner sc, GameBoard board, char ch) {
        String n = sc.nextLine();
        String[] arr = n.split(",");
        int row = Integer.parseInt(arr[0]);
        int col = Integer.parseInt(arr[1]);
        if (board.board[row][col] == ' ') {
            return n;
        }
        System.out.println("OOPs!! position is already taken!!!");
        return inputPosition(sc, board, ch);
    }
}

