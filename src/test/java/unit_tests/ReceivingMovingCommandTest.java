package unit_tests;

import mars_rover.MarsRover;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static mars_rover.message_interpreters.MarsRoverBuilder.aMarsRoverUnderstandingNasaCommands;

public class ReceivingMovingCommandTest {

    @Test
    public void moves_forward_when_pointing_north() {
        MarsRover marsRover = aMarsRoverUnderstandingNasaCommands().at(5,4).pointing("N").build();

        marsRover.receive("f");

        assertThat(marsRover, is(aMarsRoverUnderstandingNasaCommands().at(5,5).pointing("N").build()));
    }

    @Test
    public void moves_forward_when_pointing_east() {
        MarsRover marsRover = aMarsRoverUnderstandingNasaCommands().at(5,4).pointing("E").build();

        marsRover.receive("f");

        assertThat(marsRover, is(aMarsRoverUnderstandingNasaCommands().at(6,4).pointing("E").build()));
    }

    @Test
    public void moves_forward_when_pointing_south() {
        MarsRover marsRover = aMarsRoverUnderstandingNasaCommands().at(5,4).pointing("S").build();

        marsRover.receive("f");

        assertThat(marsRover, is(aMarsRoverUnderstandingNasaCommands().at(5,3).pointing("S").build()));
    }

    @Test
    public void moves_forward_when_pointing_west() {
        MarsRover marsRover = aMarsRoverUnderstandingNasaCommands().at(5,4).pointing("W").build();

        marsRover.receive("f");

        assertThat(marsRover, is(aMarsRoverUnderstandingNasaCommands().at(4,4).pointing("W").build()));
    }

    @Test
    public void moves_backward_when_pointing_north() {
        MarsRover marsRover = aMarsRoverUnderstandingNasaCommands().at(5,4).pointing("N").build();

        marsRover.receive("b");

        assertThat(marsRover, is(aMarsRoverUnderstandingNasaCommands().at(5,3).pointing("N").build()));
    }

    @Test
    public void moves_backward_when_pointing_east() {
        MarsRover marsRover = aMarsRoverUnderstandingNasaCommands().at(5,4).pointing("E").build();

        marsRover.receive("b");

        assertThat(marsRover, is(aMarsRoverUnderstandingNasaCommands().at(4,4).pointing("E").build()));
    }

    @Test
    public void moves_backward_when_pointing_south() {
        MarsRover marsRover = aMarsRoverUnderstandingNasaCommands().at(5,4).pointing("S").build();

        marsRover.receive("b");

        assertThat(marsRover, is(aMarsRoverUnderstandingNasaCommands().at(5,5).pointing("S").build()));
    }

    @Test
    public void moves_backward_when_pointing_west() {
        MarsRover marsRover = aMarsRoverUnderstandingNasaCommands().at(5,4).pointing("W").build();

        marsRover.receive("b");

        assertThat(marsRover, is(aMarsRoverUnderstandingNasaCommands().at(6,4).pointing("W").build()));
    }
}
