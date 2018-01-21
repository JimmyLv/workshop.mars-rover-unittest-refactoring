import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MarsRoverTest {

    @Test
    public void should_turn_west_after_receiving_L() {
        MarsRover marsRover = new MarsRover(0, 0, "N");

        String result = marsRover.run("L");

        assertThat(result, is("(0, 0, W)"));
    }

    @Test
    public void should_turn_east_after_receiving_R() {
        MarsRover marsRover = new MarsRover(0, 0, "N");

        String result = marsRover.run("R");

        assertThat(result, is("(0, 0, E)"));
    }

    @Test
    public void should_move_to_0_1_N_after_receiving_M() {
        MarsRover marsRover = new MarsRover(0, 0, "N");

        String result = marsRover.run("M");

        assertThat(result, is("(0, 1, N)"));
    }
}
