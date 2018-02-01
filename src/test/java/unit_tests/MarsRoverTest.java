package unit_tests;

import mars_rover.MarsRover;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static unit_tests.MarsRoverBuilder.aMarsRoverUnderstandingNasaCommands;
import static unit_tests.MarsRoverBuilder.aMarsRoverUnderstandingNasaCommandsAtIrrelevantPosition;

public class MarsRoverTest {

    @Test
    public void does_nothing_when_receiving_empty_commands_sequence() {
        MarsRover marsRover = aMarsRoverUnderstandingNasaCommandsAtIrrelevantPosition().pointing("N").build();

        marsRover.receive("");

        assertThat(marsRover, is(aMarsRoverUnderstandingNasaCommandsAtIrrelevantPosition().pointing("N").build()));
    }

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

    @Test
    public void ignores_unknown_commands() {
        MarsRover marsRover = aMarsRoverUnderstandingNasaCommands().at(7,4).pointing("E").build();

        marsRover.receive("*");

        assertThat(marsRover, is(aMarsRoverUnderstandingNasaCommands().at(7,4).pointing("E").build()));
    }
}
