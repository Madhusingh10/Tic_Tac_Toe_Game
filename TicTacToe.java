import java.util.Scanner;

public class TicTacToe {
    private char[][] gameBoard;
    private char currentPlayerMark;
    private char player1Mark = 'X';
    private char player2Mark = 'O';
    private boolean isPlayer1Turn = true;

    public TicTacToe() {
        gameBoard = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameBoard[i][j] = '-';
            }
        }
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printGameBoard();
            makeMove(scanner);
            if (checkForWinner()) {
                printGameBoard();
                System.out.println("Player " + (isPlayer1Turn ? "2" : "1") + " wins!");
                break;
            }
            if (checkForTie()) {
                printGameBoard();
                System.out.println("It's a tie!");
                break;
            }
            switchTurn();
        }
    }

    private void printGameBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void makeMove(Scanner scanner) {
        int row, col;
        while (true) {
            System.out.println("Player " + (isPlayer1Turn ? "1" : "2") + "'s turn. Enter row (0-2):");
            row = scanner.nextInt();
            System.out.println("Enter column (0-2):");
            col = scanner.nextInt();
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && gameBoard[row][col] == '-') {
                gameBoard[row][col] = currentPlayerMark;
                break;
            } else {
                System.out.println("Invalid move, try again.");
            }
        }
    }

    private boolean checkForWinner() {
    
        for (int i = 0; i < 3; i++) {
            if (gameBoard[i][0] == currentPlayerMark && gameBoard[i][1] == currentPlayerMark && gameBoard[i][2] == currentPlayerMark) {
                return true;
            }
        }
        
        for (int i = 0; i < 3; i++) {
            if (gameBoard[0][i] == currentPlayerMark && gameBoard[1][i] == currentPlayerMark && gameBoard[2][i] == currentPlayerMark) {
                return true;
            }
        }
        
        if ((gameBoard[0][0] == currentPlayerMark && gameBoard[1][1] == currentPlayerMark && gameBoard[2][2] == currentPlayerMark) ||
                (gameBoard[0][2] == currentPlayerMark && gameBoard[1][1] == currentPlayerMark && gameBoard[2][0] == currentPlayerMark)) {
            return true;
        }
        return false;
    }

    private boolean checkForTie() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private void switchTurn() {
        isPlayer1Turn = !isPlayer1Turn;
        currentPlayerMark = isPlayer1Turn ? player1Mark : player2Mark;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playGame();
    }
}