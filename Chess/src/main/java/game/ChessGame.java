package game;

import model.board.ChessBoard;
import model.enums.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tom
 */
public class ChessGame {

    private ChessBoard chessBoard;

    private Player white;

    private Player black;

    private List<Move> moves;

    public void initialize(){
        white = new Player(Color.WHITE);
        black = new Player(Color.BLACK);
        moves = new ArrayList();

        ChessBoard.getChessBoard().print();
    }

}
