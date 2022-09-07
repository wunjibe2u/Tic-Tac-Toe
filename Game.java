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

    public boolean getStatus() {
        return curTurn;
    }

    public boolean getWinGame() {
        return winGame;
    }

    public void changeStatus() {
        this.curTurn = !this.curTurn;
    }

    public boolean run(int x, int y, CellStatus val) {
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game mainGame = new Game();
        do {
            if (mainGame.getStatus()) {
                System.out.println("O turn: ");
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                if (mainGame.run(x, y, CellStatus.O))
                    mainGame.changeStatus();
            } else {
                System.out.println("X turn: ");
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                if (mainGame.run(x, y, CellStatus.X))
                    mainGame.changeStatus();
            }
            if (mainGame.getWinGame())
                break;
        } while (true);
        scanner.close();
    }
}
