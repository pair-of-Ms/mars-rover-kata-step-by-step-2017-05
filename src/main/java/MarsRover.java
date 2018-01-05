import java.util.List;

public class MarsRover {

    private Vector vector;

    public MarsRover(Coordinates coordinates, String direction) {
        this.vector = new Vector(coordinates, Direction.parse(direction));
    }

    public void receive(String message) {
        execute(createCommands(message));
    }

    private void execute(List<Command> commands) {
        for(Command command:commands) {
            vector = command.execute(vector);
        }
    }

    private List<Command> createCommands(String message) {
        return new NASACommandCodeInterpreter().createCommands(message);
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
