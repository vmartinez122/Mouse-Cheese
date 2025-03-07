package model;

public class EndGameCell extends GameCell {
    EndGamecellType type;
    public EndGameCell(EndGamecellType type) {
        this.type = type;
        if(type.equals(EndGamecellType.Cat)){
            content="00";
        }else{
            content=type.getSymbol();
        }
    }

    public EndGamecellType getType() {
        return type;
    }
}
