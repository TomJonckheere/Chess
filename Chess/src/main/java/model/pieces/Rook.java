package model.pieces;

import model.enums.Color;
import model.enums.MoveResult;
import model.enums.PieceType;
import model.enums.Row;

/**
 * @author Tom
 */
public class Rook extends ChessPiece implements Piece, SpecialMove {

    public Rook(Color color) {
        super(color);
    }

    @Override
    public MoveResult move(Integer row, Integer column) {
        return null;
    }

    @Override
    public PieceType getPieceType() {
        return PieceType.ROOK;
    }

    @Override
    public void doSpecialMove() {
        //Rocade with the king, if they havent moved yet or wernt set check...
    }

    @Override
    public Boolean hasMoved() {
        return null;
    }
}
