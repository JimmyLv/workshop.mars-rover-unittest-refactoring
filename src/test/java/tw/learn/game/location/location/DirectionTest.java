package tw.learn.game.location.location;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.hamcrest.core.Is;
import org.junit.Test;

import tw.learn.game.location.Direction;

public class DirectionTest {
    @Test
    public void should_turn_left() throws Exception {
        Direction direction = Direction.N;

        Direction newDirection = direction.left();

        assertThat(newDirection, Is.is(Direction.W));
    }
    @Test
    public void should_turn_right() throws Exception {
        Direction direction = Direction.N;

        Direction newDirection = direction.right();

        assertThat(newDirection, Is.is(Direction.E));
    }
}
