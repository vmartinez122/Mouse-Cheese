public class EndGameCell extends GameCell {
    EndGamecellType type;
    public EndGameCell(int x, int y, EndGamecellType type) {
        super(type.getSymbol(), x, y);
        this.type = type;
    }
}
