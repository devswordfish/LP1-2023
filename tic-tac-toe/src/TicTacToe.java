import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    private final char PLAYER1_SYMBOL = 'X';
    private final char PLAYER2_SYMBOL = 'O';
    private final int SPACING = 10; // to center the game

    private Scanner scan = new Scanner(System.in);
    private int playerTurn = 1;
    private char playerSymbol = PLAYER1_SYMBOL;
    private int turns = 0;
    private String winner = null;

    private boolean showPositionHint = false;

    private char[][] game = new char[3][3];
    private final int[][][] WINNINGS = { // row-column pairs
        { {0, 0}, {0, 1}, {0, 2} }, // top row
        { {1, 0}, {1, 1}, {1, 2} }, // middle row
        { {2, 0}, {2, 1}, {2, 2} }, // bottom row
        { {0, 0}, {1, 0}, {2, 0} }, // left column
        { {0, 1}, {1, 1}, {2, 1} }, // middle column
        { {0, 2}, {1, 2}, {2, 2} }, // right column
        { {0, 0}, {1, 1}, {2, 2} }, // diagonal left-top right-bottom
        { {0, 2}, {1, 1}, {2, 0} }, // diagonal right-top left-bottom
    };

    public boolean getShowPositionHint() {
        return showPositionHint;
    }
    public void setShowPositionHint(boolean showPositionHint) {
        this.showPositionHint = showPositionHint;
    }

    public void play() {
        title();

        showPositionHintGame();
        showGame();

        if (!showPositionHint) resetGame();

        while (winner == null) {
            askPosition();
            
            if (checkVictory()) {
                if (playerTurn == 1) winner = "player 1";
                else winner = "player 2";
            } else if (checkDraw()) {
                winner = "draw";
            }

            showGame();
            changeTurn();
        }

        if (winner == "draw") {
            System.out.println("It's a draw!!!");
        } else if (winner == "player 1") {
            System.out.println("Player 1 (X) have won!!!");
        } else {
            System.out.println("Player 2 (O) have won!!!");
        }
    }

    public void title() {
        System.out.println("-".repeat(2 * SPACING + 13));
        System.out.println("=".repeat(SPACING) + " Tic Tac Toe " + "=".repeat(SPACING));
        System.out.println("-".repeat(2 * SPACING + 13));
    }

    private void showPositionHintGame() {
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game.length; j++) {
                game[i][j] = (char) (i * 3 + j + 1 + '0');
            }
        }
    }

    private void resetGame() {
        for (char[] row : game) {
            Arrays.fill(row, ' ');
        }
    }

    private void showGame() {
        for (int i = game.length - 1; i >= 0; i--) {
            System.out.println(" ".repeat(SPACING) + "+---+---+---+");
            System.out.format(
                " ".repeat(SPACING) +
                "| %c | %c | %c |\n",
                game[i][0], game[i][1], game[i][2]
            );
        }
        System.out.println(" ".repeat(SPACING) + "+---+---+---+");
    }

    private void askPosition() {
        boolean keepAsking = true;

        while (keepAsking) {
            try {
                System.out.format(
                    "[PLAYER %d (%c)] Enter the position: ",
                    playerTurn, playerSymbol
                );
                int position = Integer.parseInt(scan.nextLine());

                if (position < 1 || position > 9) {
                    System.out.println("Enter a value between 1 and 9!");
                    continue;
                }

                position--;
                int row = position / 3;
                int column = position % 3;

                if (game[row][column] == PLAYER1_SYMBOL || game[row][column] == PLAYER2_SYMBOL) {
                    System.out.println("Position already chosen!");
                    continue;
                }

                game[row][column] = playerSymbol;
                turns++;

                keepAsking = false;
            } catch (Exception e) {
                System.out.println("Enter a valid position!");
            }
        }
    }

    private void changeTurn() {
        if (playerTurn == 1) {
            playerTurn = 2;
            playerSymbol = PLAYER2_SYMBOL;
        } else {
            playerTurn = 1;
            playerSymbol = PLAYER1_SYMBOL;
        }
    }

    private boolean checkDraw() {
        return turns == 9;
    }

    private boolean checkVictory() {
        for (int[][] winningGroups : WINNINGS) {
            boolean win = true;

            for (int[] position : winningGroups) {
                int row = position[0];
                int column = position[1];

                if (game[row][column] != playerSymbol) {
                    win = false;
                    break;
                }
            }

            if (win) {
                return true;
            }
        }
        return false;
    }
}
