package model.pieces;

import model.enums.Color;
import model.enums.PieceType;
import model.enums.Row;

import java.util.Arrays;
import java.util.List;

/**
 * @author Tom
 */
public abstract class ChessPiece implements Piece {

    private Integer column;
    private Row row;

    private Color color;

    public ChessPiece(Color color){
        this.color = color;
    }

    public void getPosition(){

    }

    public abstract PieceType getPieceType();

    public Color getColor(){
        return color;
    }

    public String toString()
    {
        return getPieceType().getAbbrevation();
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public Row getRow() {
        return row;
    }

    public void setRow(Row row) {
        this.row = row;
    }

    public abstract List<AllowedMove> getAllowedMoves();

    public abstract List<AllowedMove> getAllowedTakeMoves();


}
