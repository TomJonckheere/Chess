package model.pieces;

import model.board.ChessBoard;
import model.enums.Color;
import model.enums.MoveResult;
import model.enums.PieceType;
import model.enums.Row;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Tom
 */
public class Pawn extends ChessPiece implements SpecialMove {

    public Pawn(Color color) {
        super(color);
    }

    //if moved one time, the double move is no longer possible...
    private Boolean hasMoved = false;

    private List<AllowedMove> allowedMoves = Arrays.asList(new AllowedMove(1,0), new AllowedMove(2,0, false));

    private List<AllowedMove> allowedTakeMoves = Arrays.asList(new AllowedMove(1,1), new AllowedMove(1,-1));

    @Override
    public MoveResult move(Integer row, Integer column) {
        if(verifyMoveIsAllowed(row, column)){
            ChessBoard.getChessBoard().clearFieldPiece(getRow().getRowNumber(), getColumn());
            ChessBoard.getChessBoard().putPiece(row, column, this);
            hasMoved = true;

            if ((this.getColor() == Color.WHITE && row == Row.H.getRowNumber()) || (this.getColor() == Color.BLACK && row == Row.A.getRowNumber())) {
                //TODO: players should get the option to choose the piece they want
                ChessBoard.getChessBoard().putPiece(row, column, new Queen(this.getColor()));
            }

            //TODO: When the piece is transformend to a queen this check is not done correctly, we should move this logic to a central processing unit
            if(hasPutKingMate()){
                return MoveResult.CHECK;
            }

            return MoveResult.MOVED;
        }
        return MoveResult.ILLEGAL;
    }

    private boolean hasPutKingMate() {
        return false;
    }

    private boolean verifyMoveIsAllowed(Integer row, Integer column){
        if(row.compareTo(1) < 0 || row.compareTo(8) > 0 || column.compareTo(1) < 0 || column.compareTo(8) > 0)
        {
            return false;
        }

        if(ChessBoard.getChessBoard().getBoard().get(row).get(column).getPiece() != null &&
                ChessBoard.getChessBoard().getBoard().get(row).get(column).getPiece().getColor().equals(this.getColor()))
        {
            return false;
        }

        boolean takeOptions = allowedTakeMoves.stream()
                .filter(m ->
                {
                    if(this.getColor()==Color.WHITE){
                        return getRow().getRowNumber() + m.getRowIncrement() == row && getColumn() + m.getColumnIncrement() == column;
                    }else{
                        return getRow().getRowNumber() - m.getRowIncrement() == row && getColumn() - m.getColumnIncrement() == column;
                    }
                })
                .collect(Collectors.toList()).size()>0;

        boolean moveOptions = allowedMoves.stream()
                .filter(m ->
                {
                 if(this.getColor()==Color.WHITE){
                     return getRow().getRowNumber() + m.getRowIncrement() == row && getColumn() + m.getColumnIncrement() == column
                             && ChessBoard.getChessBoard().getBoard().get(row).get(column).getPiece() ==null;
                 }else{
                     return getRow().getRowNumber() - m.getRowIncrement() == row && getColumn() - m.getColumnIncrement() == column
                             && ChessBoard.getChessBoard().getBoard().get(row).get(column).getPiece() ==null;
                 }
                })
                .filter(m -> m.getCanAlwaysBeDone() || (!m.getCanAlwaysBeDone() && !hasMoved))
                .collect(Collectors.toList()).size()>0;


        return takeOptions || moveOptions;
    }

    @Override
    public PieceType getPieceType() {
        return PieceType.PAWN;
    }

    @Override
    public List<AllowedMove> getAllowedMoves() {
        return allowedMoves;
    }

    @Override
    public List<AllowedMove> getAllowedTakeMoves() {
        return allowedTakeMoves;
    }

    @Override
    public void doSpecialMove() {
        //Can go 2 fields ahead when first move
    }

    @Override
    public Boolean hasMoved() {
        return hasMoved;
    }
}
