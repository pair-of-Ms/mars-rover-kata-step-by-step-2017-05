import java.util.ArrayList;
import java.util.List;

public class MarsRover {

    private static final int MOVEMENT_DELTA = 1;
    private Vector vector;

    public MarsRover(Coordinates coordinates, String direction) {
        this.vector = new Vector(coordinates, Direction.parse(direction));
    }

    public void receive(String commandsSequence) {

        for(String commandRepresentation:commandsSequence.split(""))
        {
            if (commandRepresentation.equals("r")) {
                vector = new TurningRight().execute(vector);
            } else if (commandRepresentation.equals("l")) {
                vector = new TurningLeft().execute(vector);
            } else if (commandRepresentation.equals("f")) {
                vector = new MovingForward(MOVEMENT_DELTA).execute(vector);
            } else if (commandRepresentation.equals("b")){
                vector = new MovingBackwards(MOVEMENT_DELTA).execute(vector);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MarsRover marsRover = (MarsRover) o;

        return vector != null ? vector.equals(marsRover.vector) : marsRover.vector == null;
    }

    @Override
    public int hashCode() {
        return vector != null ? vector.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "MarsRover{" +
                "vector=" + vector +
                '}';
    }

}
