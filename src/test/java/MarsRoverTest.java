import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MarsRoverTest {

    @Test
    public void does_nothing_when_receiving_empty_commands_sequence() {
        MarsRover marsRover = new MarsRover(new Coordinates(0,0), "N");
        marsRover.receive("");

        assertThat(marsRover.getCoordinates(), is(new Coordinates(0,0)));
        assertThat(marsRover.getDirection(), is("N"));
    }

    @Test
    public void turning_right_when_pointing_north() {
        MarsRover marsRover = new MarsRover(new Coordinates(0,0), "N");
        marsRover.receive("r");

        assertThat(marsRover.getCoordinates(), is(new Coordinates(0,0)));
        assertThat(marsRover.getDirection(), is("E"));
    }
}
