package model.enums;

/**
 * @author Tom
 */
public enum PieceType {

    KING("K"),
    QUEEN("Q"),
    ROOK("R"),
    BISHOP("B"),
    KNIGHT("N"),
    PAWN("P");

    private final String abbrevation;

    private PieceType(String abbrevation)
    {
        this.abbrevation = abbrevation;
    }

    public String getAbbrevation(){
        return abbrevation;
    }

}
