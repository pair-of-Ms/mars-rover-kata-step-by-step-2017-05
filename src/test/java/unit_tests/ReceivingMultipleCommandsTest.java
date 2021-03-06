package unit_tests;

import mars_rover.MarsRover;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static mars_rover.message_interpreters.MarsRoverBuilder.aMarsRover;

public class ReceivingMultipleCommandsTest {

    @Test
    public void receives_multiple_NASA_commands() {
        MarsRover marsRover = aMarsRover().understandingNasaCommands().at(7,4).pointing("E").build();

        marsRover.receive("frrbbl");

        assertThat(marsRover, is(aMarsRover().understandingNasaCommands().at(10,4).pointing("S").build()));
    }

    @Test
    public void receives_multiple_ESA_commands() {
        MarsRover marsRover = aMarsRover().understandingEsaCommands().at(7,4).pointing("E").build();

        marsRover.receive("addrri");

        assertThat(marsRover, is(aMarsRover().understandingEsaCommands().at(10,4).pointing("S").build()));
    }
}
