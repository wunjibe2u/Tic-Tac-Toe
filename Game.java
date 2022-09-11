import java.util.Scanner;

public class Game {
    private boolean curTurn;
    private boolean winGame;
    private Board mainBoard;

    Game() {
        this.winGame = false;
        this.curTurn = false;
        mainBoard = new Board();
    }

    private void changeStatus() {
        this.curTurn = !this.curTurn;
    }

    private boolean run(int x, int y, CellStatus val) {
        if (mainBoard.setBoard(x, y, val)) {
            mainBoard.printBoard();
            if (mainBoard.checkWin() != 0) {
                if (mainBoard.checkWin() == 1) {
                    System.out.println("O wins");
                } else {
                    System.out.println("X wins");
                }
                this.winGame = true;
            }
            return true;
        } else {
            System.out.println("Invalid try again!");
            mainBoard.printBoard();
            return false;
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        do {
            if (curTurn) {
                System.out.println("O turn: ");
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                if (run(x, y, CellStatus.O))
                    changeStatus();
            } else {
                System.out.println("X turn: ");
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                if (run(x, y, CellStatus.X))
                    changeStatus();
            }
            if (winGame)
                break;
        } while (true);
        scanner.close();
    }

    public static void main(String[] args) {
        Game mainGame = new Game();
        mainGame.play();
    }
}
