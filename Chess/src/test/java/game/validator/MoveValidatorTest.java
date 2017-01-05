package game.validator;

import game.ChessBoardTest;
import game.Move;
import game.Position;
import game.Validator.MoveValidator;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

/**
 * @author Tom
 */
public class MoveValidatorTest extends ChessBoardTest {

    private MoveValidator moveValidator;

    @Before
    public void setup()
    {
        moveValidator = new MoveValidator();
    }

    @Test
    public void testMoveIsInvalidWhenStartPositionFieldIsEmpty()
    {
        Move move = new Move(new Position(4,4), new Position(5,5));
        assertThat(moveValidator.validateMove(move)).isFalse();
    }

    @Test
    public void testMoveWithEmptyMoveIsInvalid()
    {
        assertThat(moveValidator.validateMove(null)).isFalse();
    }

    @Test
    public void testMoveWithEmptyStartPositionIsInvalid()
    {
        Move move = new Move(null, new Position(5,5));
        assertThat(moveValidator.validateMove(move)).isFalse();

        move = new Move(new Position(null, 5), new Position(5,5));
        assertThat(moveValidator.validateMove(move)).isFalse();

        move = new Move(new Position(5, null), new Position(5,5));
        assertThat(moveValidator.validateMove(move)).isFalse();
    }

    @Test
    public void testMoveWithEmptyEndPositionIsInvalid()
    {
        Move move = new Move(new Position(5,5), null);
        assertThat(moveValidator.validateMove(move)).isFalse();

        move = new Move(new Position(5,5), new Position(null, 5));
        assertThat(moveValidator.validateMove(move)).isFalse();

        move = new Move(new Position(5,5), new Position(5, null));
        assertThat(moveValidator.validateMove(move)).isFalse();
    }

    @Test
    public void testMoveHasValidValues()
    {
        Move move = new Move(new Position(9,4), new Position(5,5));
        assertThat(moveValidator.validateMove(move)).isFalse();

        move = new Move(new Position(4,9), new Position(5,5));
        assertThat(moveValidator.validateMove(move)).isFalse();

        move = new Move(new Position(4,4), new Position(9,5));
        assertThat(moveValidator.validateMove(move)).isFalse();

        move = new Move(new Position(4,4), new Position(5,9));
        assertThat(moveValidator.validateMove(move)).isFalse();

        move = new Move(new Position(0,4), new Position(5,5));
        assertThat(moveValidator.validateMove(move)).isFalse();

        move = new Move(new Position(4,0), new Position(5,5));
        assertThat(moveValidator.validateMove(move)).isFalse();

        move = new Move(new Position(4,4), new Position(0,5));
        assertThat(moveValidator.validateMove(move)).isFalse();

        move = new Move(new Position(4,4), new Position(5,0));
        assertThat(moveValidator.validateMove(move)).isFalse();
    }

}
