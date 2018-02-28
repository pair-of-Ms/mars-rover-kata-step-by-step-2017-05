package mars_rover;

public class MarsRover {

    private final MessageInterpreter messageInterpeter;
    private Vector vector;

    public MarsRover(Coordinates coordinates, String direction) {
        this(coordinates, direction, new NASAMessageInterpreter());
    }

    public MarsRover(Coordinates coordinates, String direction, MessageInterpreter interpreter) {
        vector = new Vector(coordinates, Direction.parse(direction));
        messageInterpeter = interpreter;
    }

    public void receive(String message) {
        execute(createCommands(message));
    }

    private void execute(Commands commands) {
        vector = commands.execute(vector);
    }

    private Commands createCommands(String message) {
        return messageInterpeter.interpret(message);
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
        return "mars_rover.MarsRover{" +
                "vector=" + vector +
                '}';
    }

}
