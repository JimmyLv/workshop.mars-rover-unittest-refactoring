import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MarsRoverTest {

    private MarsRover rover;

    @Before
    public void setUp() throws Exception {
        rover = new MarsRover(1, 1, "N");
    }

    @Test
    public void should_move_rover_forward() throws Exception {
        assertThat(rover.run("MM"), is("1 3 N"));
    }

    @Test
    public void should_move_rover_backward() throws Exception {
        assertThat(rover.run("B"), is("1 0 N"));
    }

    @Test
    public void should_turn_rover_right() throws Exception {
        assertThat(rover.run("RRR"), is("1 1 W"));
    }

    @Test
    public void should_turn_rover_left() throws Exception {
        assertThat(rover.run("LLL"), is("1 1 E"));
    }

    @Test
    public void should_circle_around() throws Exception {
        assertThat(rover.run("MRMRMRMR"), is("1 1 N"));
        assertThat(rover.run("MLMLMLML"), is("1 1 N"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_not_allow_invalid_input() throws Exception {
        rover.run("invalid input");
    }
}
