import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = new char[3][3];
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    private static final char EMPTY_SPACE = ' ';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize the board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY_SPACE;
            }
        }

        // Game loop
        boolean gameOver = false;
        char currentPlayer = PLAYER_X;

        while (!gameOver) {
            printBoard();
            System.out.println("Player " + currentPlayer + "'s turn. Enter row and column (1-3):");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            // Check if the move is valid
            if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != EMPTY_SPACE) {
                System.out.println("Invalid move. Try again!");
                continue;
            }

            // Make the move
            board[row][col] = currentPlayer;

            // Check for win or draw
            if (checkWin(currentPlayer)) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                gameOver = true;
            } else if (checkDraw()) {
                printBoard();
                System.out.println("It's a draw!");
                gameOver = true;
            } else {
                // Switch players
                currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
            }
        }
    }

    private static void printBoard() {
        System.out.println(" 1 | 2 | 3");
        System.out.println(" ---------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + board[i][j] + " |");
            }
            System.out.println("\n ---------");
        }
    }

    private static boolean checkWin(char player) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

        // Check diagonals
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }

        return false;
    }

    private static boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY_SPACE) {
                    return false;
                }
            }
        }
        return true;
    }
}