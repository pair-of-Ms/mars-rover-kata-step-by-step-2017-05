import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MarsRoverTest {

    @Test
    public void does_nothing_when_receiving_empty_commands_sequence() {
        MarsRover marsRover = new MarsRover(new Coordinates(0,0), "N");

        marsRover.receive("");

        assertThat(marsRover, is(new MarsRover(new Coordinates(0,0), "N")));
    }

    @Test
    public void turns_right_when_pointing_north() {
        MarsRover marsRover = new MarsRover(new Coordinates(0,0), "N");

        marsRover.receive("r");

        assertThat(marsRover, is(new MarsRover(new Coordinates(0,0), "E")));
    }

    @Test
    public void turns_right_when_pointing_east() {
        MarsRover marsRover = new MarsRover(new Coordinates(0,0), "E");

        marsRover.receive("r");

        assertThat(marsRover, is(new MarsRover(new Coordinates(0,0), "S")));
    }

    @Test
    public void turns_right_when_pointing_south() {
        MarsRover marsRover = new MarsRover(new Coordinates(0,0), "S");

        marsRover.receive("r");

        assertThat(marsRover, is(new MarsRover(new Coordinates(0,0), "W")));
    }

    @Test
    public void turns_right_when_pointing_west() {
        MarsRover marsRover = new MarsRover(new Coordinates(0,0), "W");

        marsRover.receive("r");

        assertThat(marsRover, is(new MarsRover(new Coordinates(0,0), "N")));
    }

    @Test
    public void turns_left_when_pointing_north() {
        MarsRover marsRover = new MarsRover(new Coordinates(0,0), "N");

        marsRover.receive("l");

        assertThat(marsRover, is(new MarsRover(new Coordinates(0,0), "W")));
    }

    @Test
    public void turns_left_when_pointing_west() {
        MarsRover marsRover = new MarsRover(new Coordinates(0,0), "W");

        marsRover.receive("l");

        assertThat(marsRover, is(new MarsRover(new Coordinates(0,0), "S")));
    }

    @Test
    public void turns_left_when_pointing_south() {
        MarsRover marsRover = new MarsRover(new Coordinates(0,0), "S");

        marsRover.receive("l");

        assertThat(marsRover, is(new MarsRover(new Coordinates(0,0), "E")));
    }

    @Test
    public void turns_left_when_pointing_east() {
        MarsRover marsRover = new MarsRover(new Coordinates(0,0), "E");

        marsRover.receive("l");

        assertThat(marsRover, is(new MarsRover(new Coordinates(0,0), "N")));
    }
}
