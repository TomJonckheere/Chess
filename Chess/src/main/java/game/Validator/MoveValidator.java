package game.Validator;

import game.Move;
import model.board.ChessBoard;
import model.enums.Color;
import model.pieces.ChessPiece;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * @author Tom
 */
@Component
public class MoveValidator {

    public Boolean validateMove(Move move){
        if(!validateMoveObjectIsCorrect(move))
            return false;


        Integer endRow = move.getEndPosition().getRow();
        Integer endColumn = move.getEndPosition().getColumn();
        Integer startRow = move.getStartPosition().getRow();
        Integer startColumn = move.getStartPosition().getColumn();
        ChessPiece piece = ChessBoard.getChessBoard().getField(move.getStartPosition().getRow(), move.getStartPosition().getColumn()).getPiece();

        //TODO: a check if the correct player makes the correct move should also be implemented... In time...

        //TODO: for now, this is only pawn logic...
        boolean takeOptions = piece.getAllowedTakeMoves().stream()
                .filter(m ->
                {
                    if(piece.getColor()== Color.WHITE){
                        return startRow + m.getRowIncrement() == endRow && startColumn + m.getColumnIncrement() == endColumn;
                    }else{
                        return startRow - m.getRowIncrement() == endRow && startColumn - m.getColumnIncrement() == endColumn;
                    }
                })
                .collect(Collectors.toList()).size()>0;

        boolean moveOptions = piece.getAllowedMoves().stream()
                .filter(m ->
                {
                    if(piece.getColor()==Color.WHITE){
                        return startRow + m.getRowIncrement() == endRow && startColumn + m.getColumnIncrement() == endColumn
                                && ChessBoard.getChessBoard().getBoard().get(endRow).get(endColumn).getPiece() ==null;
                    }else{
                        return startRow - m.getRowIncrement() == endRow && startColumn - m.getColumnIncrement() == endColumn
                                && ChessBoard.getChessBoard().getBoard().get(endRow).get(endColumn).getPiece() ==null;
                    }
                })
                //TODO add hasMoved check...
                .filter(m -> m.getCanAlwaysBeDone() || (!m.getCanAlwaysBeDone() /*&& !piece.hasMoved)*/))
                .collect(Collectors.toList()).size()>0;


        return takeOptions || moveOptions;
    }

    private boolean validateMoveObjectIsCorrect(Move move)
    {
        if(move == null || !checkStartPosition(move) || !checkEndPosition(move)){
            return false;
        }

        return ChessBoard.getChessBoard().getField(move.getStartPosition().getRow(), move.getStartPosition().getColumn()).getPiece()!= null;
    }

    private boolean checkStartPosition(Move move)
    {
        return move.getStartPosition() != null
                && move.getStartPosition().getRow() != null
                && move.getStartPosition().getColumn() != null
                && move.getStartPosition().getRow()>0
                && move.getStartPosition().getRow()<9
                && move.getStartPosition().getColumn()>0
                && move.getStartPosition().getColumn()<9;
    }

    private boolean checkEndPosition(Move move)
    {
        return move.getEndPosition() != null
                && move.getEndPosition().getRow() != null
                && move.getEndPosition().getColumn() != null
                && move.getEndPosition().getRow()>0
                && move.getEndPosition().getRow()<9
                && move.getEndPosition().getColumn()>0
                && move.getEndPosition().getColumn()<9;
    }


}
