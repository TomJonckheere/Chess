package model.pieces;

import model.enums.Color;
import model.enums.MoveResult;
import model.enums.PieceType;
import model.enums.Row;

/**
 * @author Tom
 */
public class Knight extends ChessPiece implements Piece {

    public Knight(Color color) {
        super(color);
    }

    @Override
    public MoveResult move(Integer row, Integer column) {
        return null;
    }

    @Override
    public PieceType getPieceType() {
        return PieceType.KNIGHT;
    }
}
