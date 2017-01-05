package model.board;

import model.enums.Color;
import model.enums.Row;
import model.pieces.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Tom
 */
public class ChessBoard {

    private static ChessBoard chessBoard =null;

    private Map<Integer, Map<Integer, Field>> board;

    private ChessBoard(Boolean withPieces) {
        createBoard();
        if(withPieces){
            setupPieces();
        }
    }

    public static synchronized ChessBoard getChessBoard()
    {
        if(chessBoard==null){
            chessBoard = new ChessBoard(true);
        }
        return chessBoard;
    }

    public static synchronized ChessBoard getChessBoard(Boolean withPieces)
    {
        if(chessBoard==null){
            chessBoard = new ChessBoard(withPieces);
        }
        return chessBoard;
    }

    public static synchronized void reset(){
        chessBoard = null;
    }

    public Map<Integer, Map<Integer, Field>> getBoard()
    {
        return Collections.unmodifiableMap(board);
    }

    public void putPiece(Integer row, Integer column, ChessPiece piece)
    {
        board.get(row).get(column).setPiece(piece);
        piece.setRow(Row.getByRowNumber(row));
        piece.setColumn(column);
    }

    public Field getField(Integer row, Integer column)
    {
        return board.get(row).get(column);
    }

    public void clearFieldPiece(Integer row, Integer column)
    {
        board.get(row).get(column).setPiece(null);
    }

    private void setupPieces() {
        setupWhitePieces();
        setupBlackPieces();
    }

    private void setupWhitePieces()
    {

        putPiece(2,1,new Pawn(Color.WHITE));
        putPiece(2,2,new Pawn(Color.WHITE));
        putPiece(2,3,new Pawn(Color.WHITE));
        putPiece(2,4,new Pawn(Color.WHITE));
        putPiece(2,5,new Pawn(Color.WHITE));
        putPiece(2,6,new Pawn(Color.WHITE));
        putPiece(2,7,new Pawn(Color.WHITE));
        putPiece(2,8,new Pawn(Color.WHITE));

        putPiece(1,1,new Rook(Color.WHITE));
        putPiece(1,2,new Knight(Color.WHITE));
        putPiece(1,3,new Bishop(Color.WHITE));
        putPiece(1,4,new Queen(Color.WHITE));
        putPiece(1,5,new King(Color.WHITE));
        putPiece(1,6,new Bishop(Color.WHITE));
        putPiece(1,7,new Knight(Color.WHITE));
        putPiece(1,8,new Rook(Color.WHITE));
    }

    private void setupBlackPieces()
    {
        putPiece(7,1, new Pawn(Color.BLACK));
        putPiece(7,2, new Pawn(Color.BLACK));
        putPiece(7,3, new Pawn(Color.BLACK));
        putPiece(7,4, new Pawn(Color.BLACK));
        putPiece(7,5, new Pawn(Color.BLACK));
        putPiece(7,6, new Pawn(Color.BLACK));
        putPiece(7,7, new Pawn(Color.BLACK));
        putPiece(7,8, new Pawn(Color.BLACK));

        putPiece(8,1,new Rook(Color.BLACK));
        putPiece(8,2,new Knight(Color.BLACK));
        putPiece(8,3,new Bishop(Color.BLACK));
        putPiece(8,4,new Queen(Color.BLACK));
        putPiece(8,5,new King(Color.BLACK));
        putPiece(8,6,new Bishop(Color.BLACK));
        putPiece(8,7,new Knight(Color.BLACK));
        putPiece(8,8,new Rook(Color.BLACK));
    }

    private void createBoard() {
        board = new HashMap<>();
        Map<Integer, Field> rowA = new HashMap<>();
        Map<Integer, Field> rowB = new HashMap<>();
        Map<Integer, Field> rowC = new HashMap<>();
        Map<Integer, Field> rowD = new HashMap<>();
        Map<Integer, Field> rowE = new HashMap<>();
        Map<Integer, Field> rowF = new HashMap<>();
        Map<Integer, Field> rowG = new HashMap<>();
        Map<Integer, Field> rowH = new HashMap<>();

        rowH.put(1, new Field(Row.H, 1, Color.BLACK));
        rowH.put(2, new Field(Row.H, 2, Color.WHITE));
        rowH.put(3, new Field(Row.H, 3, Color.BLACK));
        rowH.put(4, new Field(Row.H, 4, Color.WHITE));
        rowH.put(5, new Field(Row.H, 5, Color.BLACK));
        rowH.put(6, new Field(Row.H, 6, Color.WHITE));
        rowH.put(7, new Field(Row.H, 7, Color.BLACK));
        rowH.put(8, new Field(Row.H, 8, Color.WHITE));
        rowG.put(1, new Field(Row.G, 1, Color.WHITE));
        rowG.put(2, new Field(Row.G, 2, Color.BLACK));
        rowG.put(3, new Field(Row.G, 3, Color.WHITE));
        rowG.put(4, new Field(Row.G, 4, Color.BLACK));
        rowG.put(5, new Field(Row.G, 5, Color.WHITE));
        rowG.put(6, new Field(Row.G, 6, Color.BLACK));
        rowG.put(7, new Field(Row.G, 7, Color.WHITE));
        rowG.put(8, new Field(Row.G, 8, Color.BLACK));
        rowF.put(1, new Field(Row.F, 1, Color.BLACK));
        rowF.put(2, new Field(Row.F, 2, Color.WHITE));
        rowF.put(3, new Field(Row.F, 3, Color.BLACK));
        rowF.put(4, new Field(Row.F, 4, Color.WHITE));
        rowF.put(5, new Field(Row.F, 5, Color.BLACK));
        rowF.put(6, new Field(Row.F, 6, Color.WHITE));
        rowF.put(7, new Field(Row.F, 7, Color.BLACK));
        rowF.put(8, new Field(Row.F, 8, Color.WHITE));
        rowE.put(1, new Field(Row.E, 1, Color.WHITE));
        rowE.put(2, new Field(Row.E, 2, Color.BLACK));
        rowE.put(3, new Field(Row.E, 3, Color.WHITE));
        rowE.put(4, new Field(Row.E, 4, Color.BLACK));
        rowE.put(5, new Field(Row.E, 5, Color.WHITE));
        rowE.put(6, new Field(Row.E, 6, Color.BLACK));
        rowE.put(7, new Field(Row.E, 7, Color.WHITE));
        rowE.put(8, new Field(Row.E, 8, Color.BLACK));
        rowD.put(1, new Field(Row.D, 1, Color.BLACK));
        rowD.put(2, new Field(Row.D, 2, Color.WHITE));
        rowD.put(3, new Field(Row.D, 3, Color.BLACK));
        rowD.put(4, new Field(Row.D, 4, Color.WHITE));
        rowD.put(5, new Field(Row.D, 5, Color.BLACK));
        rowD.put(6, new Field(Row.D, 6, Color.WHITE));
        rowD.put(7, new Field(Row.D, 7, Color.BLACK));
        rowD.put(8, new Field(Row.D, 8, Color.WHITE));
        rowC.put(1, new Field(Row.C, 1, Color.WHITE));
        rowC.put(2, new Field(Row.C, 2, Color.BLACK));
        rowC.put(3, new Field(Row.C, 3, Color.WHITE));
        rowC.put(4, new Field(Row.C, 4, Color.BLACK));
        rowC.put(5, new Field(Row.C, 5, Color.WHITE));
        rowC.put(6, new Field(Row.C, 6, Color.BLACK));
        rowC.put(7, new Field(Row.C, 7, Color.WHITE));
        rowC.put(8, new Field(Row.C, 8, Color.BLACK));
        rowB.put(1, new Field(Row.B, 1, Color.BLACK));
        rowB.put(2, new Field(Row.B, 2, Color.WHITE));
        rowB.put(3, new Field(Row.B, 3, Color.BLACK));
        rowB.put(4, new Field(Row.B, 4, Color.WHITE));
        rowB.put(5, new Field(Row.B, 5, Color.BLACK));
        rowB.put(6, new Field(Row.B, 6, Color.WHITE));
        rowB.put(7, new Field(Row.B, 7, Color.BLACK));
        rowB.put(8, new Field(Row.B, 8, Color.WHITE));
        rowA.put(1, new Field(Row.A, 1, Color.WHITE));
        rowA.put(2, new Field(Row.A, 2, Color.BLACK));
        rowA.put(3, new Field(Row.A, 3, Color.WHITE));
        rowA.put(4, new Field(Row.A, 4, Color.BLACK));
        rowA.put(5, new Field(Row.A, 5, Color.WHITE));
        rowA.put(6, new Field(Row.A, 6, Color.BLACK));
        rowA.put(7, new Field(Row.A, 7, Color.WHITE));
        rowA.put(8, new Field(Row.A, 8, Color.BLACK));

        board.put(1, rowA);
        board.put(2, rowB);
        board.put(3, rowC);
        board.put(4, rowD);
        board.put(5, rowE);
        board.put(6, rowF);
        board.put(7, rowG);
        board.put(8, rowH);
    }

    public void print(){
        printRow(board.get(8));
        printRow(board.get(7));
        printRow(board.get(6));
        printRow(board.get(5));
        printRow(board.get(4));
        printRow(board.get(3));
        printRow(board.get(2));
        printRow(board.get(1));
    }

    private void printRow(Map<Integer, Field> row){
        String output = "";
        output += row.get(1) + " ";
        output += row.get(2) + " ";
        output += row.get(3) + " ";
        output += row.get(4) + " ";
        output += row.get(5) + " ";
        output += row.get(6) + " ";
        output += row.get(7) + " ";
        output += row.get(8) + " ";
        System.out.println(output);
    }
}
