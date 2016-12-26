package game;

import game.Move;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tom
 */
@RestController
public class MoveController {

    /*
    {
  "startPosition": {
    "row": 1,
    "column": 1
  },
  "endPosition": {
    "row": 2,
    "column": 2
  },
  "chessPiece": null
}
     */

    @RequestMapping(value = "/move", method = RequestMethod.POST)
    public Move move(Move move) {
        //TODO we should return the board, since we want to see the outcome of the move...
        return new Move(new Position(move.getStartPosition().getRow()+1, move.getStartPosition().getColumn() +1),
                new Position(move.getEndPosition().getRow() + 2, move.getEndPosition().getColumn() + 2),null);
    }
}
