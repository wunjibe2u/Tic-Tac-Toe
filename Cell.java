public class Cell {
    private CellStatus value;

    Cell() {
        value = CellStatus.NONE;
    }

    public void setValue(CellStatus value) {
        this.value = value;
    }

    public CellStatus getValue() {
        return this.value;
    }
}
