package tw.learn.game.location;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static tw.learn.game.Direction.*;

import org.junit.Test;

import tw.learn.game.Direction;

public class DirectionTest {
    @Test
    public void should_turn_left() throws Exception {
        Direction direction = N;

        Direction newDirection = direction.left();

        assertThat(newDirection, is(W));
    }
    @Test
    public void should_turn_right() throws Exception {
        Direction direction = N;

        Direction newDirection = direction.right();

        assertThat(newDirection, is(E));
    }
}
