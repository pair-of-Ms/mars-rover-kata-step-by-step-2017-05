import java.util.ArrayList;
import java.util.List;

public class MarsRover {

    private static final int MOVEMENT_DELTA = 1;
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
        List<Command> commands = new ArrayList<>();
        for(String commandRepresentation: parseMessage(message))
        {
            commands.add(createCommand(commandRepresentation));
        }
        return commands;
    }

    private String[] parseMessage(String message) {
        return message.split("");
    }

    private Command createCommand(String commandRepresentation) {

        if (commandRepresentation.equals("r")) {
            return new TurningRight();
        } else if (commandRepresentation.equals("l")) {
            return new TurningLeft();
        } else if (commandRepresentation.equals("f")) {
            return new MovingForward(MOVEMENT_DELTA);
        } else if (commandRepresentation.equals("b")){
            return new MovingBackwards(MOVEMENT_DELTA);
        } else {
            return new UnknownCommand();
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
