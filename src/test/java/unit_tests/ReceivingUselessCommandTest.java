package unit_tests;

import mars_rover.MarsRover;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static unit_tests.MarsRoverBuilder.aMarsRoverUnderstandingNasaCommands;
import static unit_tests.MarsRoverBuilder.aMarsRoverUnderstandingNasaCommandsAtIrrelevantPosition;

public class ReceivingUselessCommandTest {

    @Test
    public void does_nothing_when_receiving_empty_commands_sequence() {
        MarsRover marsRover = aMarsRoverUnderstandingNasaCommandsAtIrrelevantPosition().pointing("N").build();

        marsRover.receive("");

        assertThat(marsRover, is(aMarsRoverUnderstandingNasaCommandsAtIrrelevantPosition().pointing("N").build()));
    }

    @Test
    public void ignores_unknown_commands() {
        MarsRover marsRover = aMarsRoverUnderstandingNasaCommands().at(7,4).pointing("E").build();

        marsRover.receive("*");

        assertThat(marsRover, is(aMarsRoverUnderstandingNasaCommands().at(7,4).pointing("E").build()));
    }
}
