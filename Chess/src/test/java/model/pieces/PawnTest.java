package model.pieces;

import model.board.ChessBoard;
import model.enums.Color;
import model.enums.MoveResult;
import model.enums.PieceType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

/**
 * @author Tom
 */
public class PawnTest {

    private ChessPiece pawn;

    @Before
    public void setup()
    {
        pawn = getBoard().getBoard().get(2).get(2).getPiece();
        assertThat(pawn.getColor()).isEqualTo(Color.WHITE);
        assertThat(pawn.getPieceType()).isEqualTo(PieceType.PAWN);
    }

    @After
    public void tearDown()
    {
        System.out.println(" ");
        ChessBoard.getChessBoard().print();
        ChessBoard.reset();
    }

    @Test
    public void testPawnCanMoveForward()
    {
        assertThat(pawn.move(3,2)).isEqualTo(MoveResult.MOVED);

        ChessPiece movedPawn = getBoard().getBoard().get(3).get(2).getPiece();
        assertThat(((SpecialMove) movedPawn).hasMoved()).isTrue();
        assertThat(getBoard().getBoard().get(2).get(2).getPiece()).isNull();
    }

    @Test
    public void testPawnCanDoDoubleMoveForward()
    {
        assertThat(pawn.move(4,2)).isEqualTo(MoveResult.MOVED);

        ChessPiece movedPawn = getBoard().getBoard().get(4).get(2).getPiece();
        assertThat(((SpecialMove) movedPawn).hasMoved()).isTrue();
        assertThat(getBoard().getBoard().get(2).get(2).getPiece()).isNull();
    }

    @Test
    public void testPawnCanDoDoubleMoveForwardOnlyOnce()
    {
        assertThat(pawn.move(4,2)).isEqualTo(MoveResult.MOVED);

        ChessPiece movedPawn = getBoard().getBoard().get(4).get(2).getPiece();
        assertThat(((SpecialMove) movedPawn).hasMoved()).isTrue();
        assertThat(getBoard().getBoard().get(2).get(2).getPiece()).isNull();

        assertThat(pawn.move(6,2)).isEqualTo(MoveResult.ILLEGAL);

        assertThat(getBoard().getBoard().get(6).get(2).getPiece()).isNull();
    }

    @Test
    public void testPawnCanNotMoveBackwards()
    {
        ChessBoard.reset();
        ChessBoard.getChessBoard(false);
        getBoard().putPiece(2,1,new Pawn(Color.WHITE));
        pawn = getBoard().getBoard().get(2).get(1).getPiece();

        assertThat(pawn.move(1,1)).isEqualTo(MoveResult.ILLEGAL);
    }

    @Test
    public void testPawnCanNotMoveIntoSpaceFieldOccupiedByPieceOfSameColor()
    {
        ChessBoard.reset();
        ChessBoard.getChessBoard(false);
        getBoard().putPiece(2,1,new Pawn(Color.WHITE));
        pawn = getBoard().getBoard().get(2).get(1).getPiece();
        getBoard().putPiece(3,1,new Pawn(Color.WHITE));
        assertThat(pawn.move(3,1)).isEqualTo(MoveResult.ILLEGAL);
    }

    @Test
    public void testPawnCanNotMoveOutsideOfTheBoard()
    {
        ChessBoard.reset();
        ChessBoard.getChessBoard(false);
        //Yesyes, the white pawn can never start here...
        pawn = new Pawn(Color.WHITE);
        getBoard().putPiece(8,1,pawn);
        assertThat(pawn.move(9,1)).isEqualTo(MoveResult.ILLEGAL);
    }

    @Test
    public void testBlackPawnMovesForwardInOppositeDirectionOfWhitePawn()
    {
        pawn = getBoard().getBoard().get(7).get(1).getPiece();

        assertThat(pawn.getColor()).isEqualTo(Color.BLACK);
        assertThat(pawn.move(6,1)).isEqualTo(MoveResult.MOVED);
    }

    @Test
    public void testBlackPawnCantMoveSameDirectionAsWhite()
    {
        ChessBoard.reset();
        ChessBoard.getChessBoard(false);

        pawn = new Pawn(Color.BLACK);

        getBoard().putPiece(7,1,pawn);
        assertThat(pawn.move(8,1)).isEqualTo(MoveResult.ILLEGAL);
    }

    @Test
    public void testWhitePawnCanTakeBlackPawnRightDiagonally(){
        ChessBoard.reset();
        ChessBoard.getChessBoard(false);

        Pawn blackPawn = new Pawn(Color.BLACK);
        Pawn whitePawn = new Pawn(Color.WHITE);

        getBoard().putPiece(5,3,blackPawn);
        getBoard().putPiece(4,4,whitePawn);

        assertThat(whitePawn.move(5,3)).isEqualTo(MoveResult.MOVED);
    }

    @Test
    public void testWhitePawnCanTakeBlackPawnLeftDiagonally(){
        ChessBoard.reset();
        ChessBoard.getChessBoard(false);

        Pawn blackPawn = new Pawn(Color.BLACK);
        Pawn whitePawn = new Pawn(Color.WHITE);

        getBoard().putPiece(4,4,blackPawn);
        getBoard().putPiece(3,3,whitePawn);

        assertThat(whitePawn.move(4,4)).isEqualTo(MoveResult.MOVED);
    }

    @Test
    public void testBlackPawnCanTakeWhitePawnRightDiagonally(){
        ChessBoard.reset();
        ChessBoard.getChessBoard(false);

        Pawn blackPawn = new Pawn(Color.BLACK);
        Pawn whitePawn = new Pawn(Color.WHITE);

        getBoard().putPiece(5,3,blackPawn);
        getBoard().putPiece(4,4,whitePawn);

        assertThat(blackPawn.move(4,4)).isEqualTo(MoveResult.MOVED);
    }

    @Test
    public void testBlackPawnCanTakeWhitePawnLeftDiagonally(){
        ChessBoard.reset();
        ChessBoard.getChessBoard(false);

        Pawn blackPawn = new Pawn(Color.BLACK);
        Pawn whitePawn = new Pawn(Color.WHITE);

        getBoard().putPiece(4,4,blackPawn);
        getBoard().putPiece(3,3,whitePawn);

        assertThat(blackPawn.move(3,3)).isEqualTo(MoveResult.MOVED);
    }

    @Test
    public void testBlackPawnCantTakeWhitePawnVertically(){
        ChessBoard.reset();
        ChessBoard.getChessBoard(false);

        Pawn blackPawn = new Pawn(Color.BLACK);
        Pawn whitePawn = new Pawn(Color.WHITE);

        getBoard().putPiece(4,3,blackPawn);
        getBoard().putPiece(3,3,whitePawn);

        assertThat(blackPawn.move(3,3)).isEqualTo(MoveResult.ILLEGAL);
    }

    @Test
    public void testWhitePawnCantTakeBlackPawnVertically(){
        ChessBoard.reset();
        ChessBoard.getChessBoard(false);

        Pawn blackPawn = new Pawn(Color.BLACK);
        Pawn whitePawn = new Pawn(Color.WHITE);

        getBoard().putPiece(4,3,blackPawn);
        getBoard().putPiece(3,3,whitePawn);

        assertThat(whitePawn.move(4,3)).isEqualTo(MoveResult.ILLEGAL);
    }

    @Test
    public void testWhenWhitePawnMovesToOppositeEndOfTheBoardItCanUpgrade()
    {
        ChessBoard.reset();
        ChessBoard.getChessBoard(false);

        pawn = new Pawn(Color.WHITE);
        getBoard().putPiece(7,7,pawn);
        assertThat(pawn.move(8,7)).isEqualTo(MoveResult.MOVED);

        assertThat(ChessBoard.getChessBoard().getBoard().get(8).get(7).getPiece().getColor()).isEqualTo(Color.WHITE);
        assertThat(ChessBoard.getChessBoard().getBoard().get(8).get(7).getPiece().getPieceType()).isEqualTo(PieceType.QUEEN);
    }

    @Test
    public void testWhenBlackPawnMovesToOppositeEndOfTheBoardItCanUpgrade()
    {
        ChessBoard.reset();
        ChessBoard.getChessBoard(false);

        pawn = new Pawn(Color.BLACK);
        getBoard().putPiece(2,2,pawn);
        assertThat(pawn.move(1,2)).isEqualTo(MoveResult.MOVED);

        assertThat(ChessBoard.getChessBoard().getBoard().get(8).get(7).getPiece().getColor()).isEqualTo(Color.BLACK);
        assertThat(ChessBoard.getChessBoard().getBoard().get(8).get(7).getPiece().getPieceType()).isEqualTo(PieceType.QUEEN);
    }

    @Test
    public void testWhitePawnCanPutBlackKingCheck()
    {
        ChessBoard.reset();
        ChessBoard.getChessBoard(false);

        pawn = new Pawn(Color.WHITE);
        getBoard().putPiece(5,5,pawn);

        ChessPiece king = new King(Color.BLACK);
        getBoard().putPiece(7,6, king);

        assertThat(pawn.move(6,5)).isEqualTo(MoveResult.CHECK);

    }

    //TODO: en passant



    private ChessBoard getBoard()
    {
        return ChessBoard.getChessBoard();
    }


}
