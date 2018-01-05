import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MarsRoverTest {

    @Test
    public void does_nothing_when_receiving_empty_commands_sequence() {
        MarsRover marsRover = MarsRoverBuilder.aMarsRoverAtIrrelevantPosition().pointing("N").build();

        marsRover.receive("");

        assertThat(marsRover, is(MarsRoverBuilder.aMarsRoverAtIrrelevantPosition().pointing("N").build()));
    }

    @Test
    public void turns_right_when_pointing_north() {
        MarsRover marsRover = MarsRoverBuilder.aMarsRoverAtIrrelevantPosition().pointing("N").build();

        marsRover.receive("r");

        assertThat(marsRover, is(MarsRoverBuilder.aMarsRoverAtIrrelevantPosition().pointing("E").build()));
    }

    @Test
    public void turns_right_when_pointing_east() {
        MarsRover marsRover = MarsRoverBuilder.aMarsRoverAtIrrelevantPosition().pointing("E").build();

        marsRover.receive("r");

        assertThat(marsRover, is(MarsRoverBuilder.aMarsRoverAtIrrelevantPosition().pointing("S").build()));
    }

    @Test
    public void turns_right_when_pointing_south() {
        MarsRover marsRover = MarsRoverBuilder.aMarsRoverAtIrrelevantPosition().pointing("S").build();

        marsRover.receive("r");

        assertThat(marsRover, is(MarsRoverBuilder.aMarsRoverAtIrrelevantPosition().pointing("W").build()));
    }

    @Test
    public void turns_right_when_pointing_west() {
        MarsRover marsRover = MarsRoverBuilder.aMarsRoverAtIrrelevantPosition().pointing("W").build();

        marsRover.receive("r");

        assertThat(marsRover, is(MarsRoverBuilder.aMarsRoverAtIrrelevantPosition().pointing("N").build()));
    }

    @Test
    public void turns_left_when_pointing_north() {
        MarsRover marsRover = MarsRoverBuilder.aMarsRoverAtIrrelevantPosition().pointing("N").build();

        marsRover.receive("l");

        assertThat(marsRover, is(MarsRoverBuilder.aMarsRoverAtIrrelevantPosition().pointing("W").build()));
    }

    @Test
    public void turns_left_when_pointing_west() {
        MarsRover marsRover = MarsRoverBuilder.aMarsRoverAtIrrelevantPosition().pointing("W").build();

        marsRover.receive("l");

        assertThat(marsRover, is(MarsRoverBuilder.aMarsRoverAtIrrelevantPosition().pointing("S").build()));
    }

    @Test
    public void turns_left_when_pointing_south() {
        MarsRover marsRover = MarsRoverBuilder.aMarsRoverAtIrrelevantPosition().pointing("S").build();

        marsRover.receive("l");

        assertThat(marsRover, is(MarsRoverBuilder.aMarsRoverAtIrrelevantPosition().pointing("E").build()));
    }

    @Test
    public void turns_left_when_pointing_east() {
        MarsRover marsRover = MarsRoverBuilder.aMarsRoverAtIrrelevantPosition().pointing("E").build();

        marsRover.receive("l");

        assertThat(marsRover, is(MarsRoverBuilder.aMarsRoverAtIrrelevantPosition().pointing("N").build()));
    }

    @Test
    public void moves_forward_when_pointing_north() {
        MarsRover marsRover = MarsRoverBuilder.aMarsRover().at(5,4).pointing("N").build();

        marsRover.receive("f");

        assertThat(marsRover, is(MarsRoverBuilder.aMarsRover().at(5,5).pointing("N").build()));
    }

    @Test
    public void moves_forward_when_pointing_east() {
        MarsRover marsRover = MarsRoverBuilder.aMarsRover().at(5,4).pointing("E").build();

        marsRover.receive("f");

        assertThat(marsRover, is(MarsRoverBuilder.aMarsRover().at(6,4).pointing("E").build()));
    }

    @Test
    public void moves_forward_when_pointing_south() {
        MarsRover marsRover = MarsRoverBuilder.aMarsRover().at(5,4).pointing("S").build();

        marsRover.receive("f");

        assertThat(marsRover, is(MarsRoverBuilder.aMarsRover().at(5,3).pointing("S").build()));
    }

    @Test
    public void moves_forward_when_pointing_west() {
        MarsRover marsRover = MarsRoverBuilder.aMarsRover().at(5,4).pointing("W").build();

        marsRover.receive("f");

        assertThat(marsRover, is(MarsRoverBuilder.aMarsRover().at(4,4).pointing("W").build()));
    }

    @Test
    public void moves_backward_when_pointing_north() {
        MarsRover marsRover = MarsRoverBuilder.aMarsRover().at(5,4).pointing("N").build();

        marsRover.receive("b");

        assertThat(marsRover, is(MarsRoverBuilder.aMarsRover().at(5,3).pointing("N").build()));
    }

    @Test
    public void moves_backward_when_pointing_east() {
        MarsRover marsRover = MarsRoverBuilder.aMarsRover().at(5,4).pointing("E").build();

        marsRover.receive("b");

        assertThat(marsRover, is(MarsRoverBuilder.aMarsRover().at(4,4).pointing("E").build()));
    }

    @Test
    public void moves_backward_when_pointing_south() {
        MarsRover marsRover = MarsRoverBuilder.aMarsRover().at(5,4).pointing("S").build();

        marsRover.receive("b");

        assertThat(marsRover, is(MarsRoverBuilder.aMarsRover().at(5,5).pointing("S").build()));
    }

    @Test
    public void moves_backward_when_pointing_west() {
        MarsRover marsRover = MarsRoverBuilder.aMarsRover().at(5,4).pointing("W").build();

        marsRover.receive("b");

        assertThat(marsRover, is(MarsRoverBuilder.aMarsRover().at(6,4).pointing("W").build()));
    }

    @Test
    public void receives_multiple_commands() {
        MarsRover marsRover = MarsRoverBuilder.aMarsRover().at(7,4).pointing("E").build();

        marsRover.receive("fr");

        assertThat(marsRover, is(MarsRoverBuilder.aMarsRover().at(8,4).pointing("S").build()));
    }

    @Test
    public void ignores_unknown_commands() {
        MarsRover marsRover = MarsRoverBuilder.aMarsRover().at(7,4).pointing("E").build();

        marsRover.receive("*");

        assertThat(marsRover, is(MarsRoverBuilder.aMarsRover().at(7,4).pointing("E").build()));
    }
}
