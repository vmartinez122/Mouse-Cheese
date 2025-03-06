package model;

public class EndGameCell extends GameCell {
    EndGamecellType type;
    public EndGameCell(EndGamecellType type) {
        content=type.getSymbol();
        this.type = type;
    }
}
