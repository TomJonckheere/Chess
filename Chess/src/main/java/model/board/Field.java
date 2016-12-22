package model.board;

import model.enums.Color;
import model.enums.Row;
import model.pieces.ChessPiece;
import model.pieces.Piece;

/**
 * @author Tom
 */
public class Field {

    private Row row;

    private Integer column;

    private Color color;

    private ChessPiece piece;

    public Field(Row row, Integer column, Color color)
    {
        this.row = row;
        this.column = column;
        this.color = color;
    }

    public Row getRow()
    {
        return row;
    }

    public Integer getColumn()
    {
        return column;
    }

    public Color getColor()
    {
        return color;
    }

    public void setPiece(ChessPiece piece) {
        this.piece = piece;
    }

    public ChessPiece getPiece() {
        return piece;
    }

    public String toString()
    {
        if(piece != null){
            return piece.toString();
        }
        return color.getStringRepresentation();
    }
}
