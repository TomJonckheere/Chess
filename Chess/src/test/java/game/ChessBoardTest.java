package game;

import model.board.ChessBoard;
import org.junit.After;

/**
 * @author Tom
 */
public class ChessBoardTest {

    @After
    public void tearDown()
    {
        System.out.println(" ");
        ChessBoard.getChessBoard().print();
        ChessBoard.reset();
    }
}
