package game;

import model.pieces.ChessPiece;

/**
 * @author Tom
 */
public class Move {

    private Position startPosition;
    private Position endPosition;
    private ChessPiece chessPiece;

    public Move(){
    }

    public Move(Position startPosition, Position endPosition, ChessPiece chessPiece){
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.chessPiece = chessPiece;
    }

    public Position getStartPosition()
    {
        return startPosition;
    }

    public Position getEndPosition()
    {
        return endPosition;
    }

    public ChessPiece getChessPiece()
    {
        return chessPiece;
    }

}
