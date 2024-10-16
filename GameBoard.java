public class GameBoard {
    char[][] board;

    public GameBoard() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public GameBoard(int n) {
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = ' ';
            }
        }
    }
    public void printGameBoard() {
        String t="+--";
        for(int i=0;i<board.length-1;i++){
            t+="+--";
        }
        t+="+";
        System.out.println(t);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print("|" + (board[i][j] == ' ' ? "  " : board[i][j]));
            }
            System.out.println("|");
            System.out.println(t);
        }
    }

    public boolean winnerCheck(char ch) {
        for (int i = 0; i < board.length; i++) {
            boolean flag = true;
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != ch) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        for (int i = 0; i < board.length; i++) {
            boolean flag = true;
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != ch) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        boolean flag = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] != ch) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return true;
        }
        flag = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][board.length - 1 - i] != ch) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public boolean drawCheck() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}

