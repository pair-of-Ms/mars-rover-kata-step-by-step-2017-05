import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CoordinatesTest {

    @Test
    public void increments_x() {
        Coordinates coordinates = new Coordinates(1,1);

        assertThat(coordinates.incrementX(1), is(new Coordinates(2, 1)));
        assertThat(coordinates.incrementX(-2), is(new Coordinates(-1, 1)));
    }

    @Test
    public void increments_y() {
        Coordinates coordinates = new Coordinates(1,1);

        assertThat(coordinates.incrementY(1), is(new Coordinates(1, 2)));
        assertThat(coordinates.incrementY(-2), is(new Coordinates(1, -1)));
    }


}
