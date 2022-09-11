public class Board {
    private Cell[] cellBoard;

    Board() {
        cellBoard = new Cell[9];
        for (int i = 0; i < 9; i++)
            cellBoard[i] = new Cell();
    }

    public boolean setBoard(int x, int y, CellStatus val) {
        if ((x < 1) || (x > 3) || (y < 1) || (y > 3)
                || (cellBoard[(x - 1) * 3 + y - 1].getValue() != CellStatus.NONE)) {
            return false;
        } else {
            cellBoard[(x - 1) * 3 + y - 1].setValue(val);
            return true;
        }
    }

    public int checkWin() {
        for (int i = 0; i < 7; i += 3) {
            if (cellBoard[i].getValue() == cellBoard[i + 1].getValue()
                    && cellBoard[i + 1].getValue() == cellBoard[i + 2].getValue()) {
                if (cellBoard[i].getValue() == CellStatus.O)
                    return 1;
                else if (cellBoard[i].getValue() == CellStatus.X)
                    return 2;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (cellBoard[i].getValue() == cellBoard[i + 3].getValue()
                    && cellBoard[i + 3].getValue() == cellBoard[i + 6].getValue()) {
                if (cellBoard[i].getValue() == CellStatus.O)
                    return 1;
                else if (cellBoard[i].getValue() == CellStatus.X)
                    return 2;
            }
        }
        if (cellBoard[0].getValue() == cellBoard[4].getValue()
                && cellBoard[4].getValue() == cellBoard[8].getValue()) {
            if (cellBoard[4].getValue() == CellStatus.O)
                return 1;
            else if (cellBoard[4].getValue() == CellStatus.X)
                return 2;
        }
        if (cellBoard[2].getValue() == cellBoard[4].getValue()
                && cellBoard[4].getValue() == cellBoard[6].getValue()) {
            if (cellBoard[4].getValue() == CellStatus.O)
                return 1;
            else if (cellBoard[4].getValue() == CellStatus.X)
                return 2;
        }
        return 0;
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("[");
                if (cellBoard[i * 3 + j].getValue() == CellStatus.NONE)
                    System.out.print(" ");
                else if (cellBoard[i * 3 + j].getValue() == CellStatus.O)
                    System.out.print("O");
                else if (cellBoard[i * 3 + j].getValue() == CellStatus.X)
                    System.out.print("X");
                System.out.print("]");
            }
            System.out.print("\n");
        }
    }
}
