package model.pieces;

import model.enums.MoveResult;

/**
 * @author Tom
 */
public interface Piece {

    /**
     * Moves a piece to his new location
     *  @param row the row on which the piece will be
     *  @param column the column on which the piece will be
     *
     *  @return the result of this move, just in case an illegal move is done
     */
    MoveResult move(Integer row, Integer column);
}
