import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    private char PLAYER_1 = 'X';
    private char PLAYER_2 = 'O';

    private Scanner scan = new Scanner(System.in);
    private int playerTurn = 1;
    private int plays = 0;

    private char[][] game = new char[3][3];
    private int[][][] winnings = new int[][][] {
            { {0, 0}, {0, 1}, {0, 2} },
            { {1, 0}, {1, 1}, {1, 2} },
            { {2, 0}, {2, 1}, {2, 2} },
            { {0, 0}, {1, 0}, {2, 0} },
            { {0, 1}, {1, 1}, {2, 1} },
            { {0, 2}, {1, 2}, {2, 2} },
            { {0, 0}, {1, 1}, {2, 2} },
            { {0, 2}, {1, 1}, {2, 0} }
    };

    public void play() {
        System.out.println("=".repeat(10) + " Tic Tac Toe " + "=".repeat(10));

        positionHintGame();

        showGame();
        resetGame();

        while (!gameFinished()) {
            int[] position = askUser();
            int row = position[0];
            int column = position[1];

            while (game[row][column] != ' ') {
                System.out.println("Position already chosen!");
                position = askUser();
                row = position[0];
                column = position[1];
            }

            game[row][column] = playerTurn == 1 ? PLAYER_1 : PLAYER_2;
            plays++;

            showGame();

            playerTurn = playerTurn == 1 ? 2 : 1;
        }
        playerTurn = playerTurn == 1 ? 2 : 1;

        if (isDraw()) {
            System.out.println("It's a draw!!!");
        } else {
            System.out.format("Player %d win!!!", playerTurn);
        }
    }

    public void positionHintGame() {
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game.length; j++) {
                game[i][j] = (char) (i * 3 + j + 1 + (int) '0');
            }
        }
    }

    public void resetGame() {
        for (char[] row : game) {
            Arrays.fill(row, ' ');
        }
    }

    public void showGame() {
        for (int i = 0; i < game.length; i++) {
            System.out.print("+-+-+-+\n|");

            for (int j = 0; j < game.length; j++) {
                System.out.print(game[i][j] + "|");
            }

            System.out.println();
        }
        System.out.println("+-+-+-+");
    }

    public int[] askUser() {
        System.out.format("[PLAYER %d] Enter the position: ", playerTurn);
        int pos = scan.nextInt();
        pos--;

        int row = pos / 3;
        int column = pos % 3;

        return new int[] { row, column };
    }

    public boolean isDraw() {
        return plays == 9;
    }

    public boolean isVictory() {
        for (int[][] winningGroups : winnings) {
            boolean win = true;

            for (int[] position : winningGroups) {
                int row = position[0];
                int column = position[1];

                if (playerTurn == 1) {
                    if (game[row][column] != PLAYER_2) {
                        win = false;
                        break;
                    }
                } else {
                    if (game[row][column] != PLAYER_1) {
                        win = false;
                        break;
                    }
                }
            }

            if (win) {
                return true;
            }
        }
        return false;
    }

    public boolean gameFinished() {
        return isDraw() || isVictory();
    }
}
