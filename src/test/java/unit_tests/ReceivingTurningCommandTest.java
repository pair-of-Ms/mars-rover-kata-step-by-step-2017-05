package unit_tests;

import mars_rover.MarsRover;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static unit_tests.MarsRoverBuilder.aMarsRoverUnderstandingNasaCommandsAtIrrelevantPosition;

public class ReceivingTurningCommandTest {

    @Test
    public void turns_right_when_pointing_north() {
        MarsRover marsRover = aMarsRoverUnderstandingNasaCommandsAtIrrelevantPosition().pointing("N").build();

        marsRover.receive("r");

        assertThat(marsRover, is(aMarsRoverUnderstandingNasaCommandsAtIrrelevantPosition().pointing("E").build()));
    }

    @Test
    public void turns_right_when_pointing_east() {
        MarsRover marsRover = aMarsRoverUnderstandingNasaCommandsAtIrrelevantPosition().pointing("E").build();

        marsRover.receive("r");

        assertThat(marsRover, is(aMarsRoverUnderstandingNasaCommandsAtIrrelevantPosition().pointing("S").build()));
    }

    @Test
    public void turns_right_when_pointing_south() {
        MarsRover marsRover = aMarsRoverUnderstandingNasaCommandsAtIrrelevantPosition().pointing("S").build();

        marsRover.receive("r");

        assertThat(marsRover, is(aMarsRoverUnderstandingNasaCommandsAtIrrelevantPosition().pointing("W").build()));
    }

    @Test
    public void turns_right_when_pointing_west() {
        MarsRover marsRover = aMarsRoverUnderstandingNasaCommandsAtIrrelevantPosition().pointing("W").build();

        marsRover.receive("r");

        assertThat(marsRover, is(aMarsRoverUnderstandingNasaCommandsAtIrrelevantPosition().pointing("N").build()));
    }

    @Test
    public void turns_left_when_pointing_north() {
        MarsRover marsRover = aMarsRoverUnderstandingNasaCommandsAtIrrelevantPosition().pointing("N").build();

        marsRover.receive("l");

        assertThat(marsRover, is(aMarsRoverUnderstandingNasaCommandsAtIrrelevantPosition().pointing("W").build()));
    }

    @Test
    public void turns_left_when_pointing_west() {
        MarsRover marsRover = aMarsRoverUnderstandingNasaCommandsAtIrrelevantPosition().pointing("W").build();

        marsRover.receive("l");

        assertThat(marsRover, is(aMarsRoverUnderstandingNasaCommandsAtIrrelevantPosition().pointing("S").build()));
    }

    @Test
    public void turns_left_when_pointing_south() {
        MarsRover marsRover = aMarsRoverUnderstandingNasaCommandsAtIrrelevantPosition().pointing("S").build();

        marsRover.receive("l");

        assertThat(marsRover, is(aMarsRoverUnderstandingNasaCommandsAtIrrelevantPosition().pointing("E").build()));
    }

    @Test
    public void turns_left_when_pointing_east() {
        MarsRover marsRover = aMarsRoverUnderstandingNasaCommandsAtIrrelevantPosition().pointing("E").build();

        marsRover.receive("l");

        assertThat(marsRover, is(aMarsRoverUnderstandingNasaCommandsAtIrrelevantPosition().pointing("N").build()));
    }
}
