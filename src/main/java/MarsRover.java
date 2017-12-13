import java.util.ArrayList;
import java.util.List;

public class MarsRover {

    private static final int MOVEMENT_DELTA = 1;
    private Vector vector;

    public MarsRover(Coordinates coordinates, String direction) {
        this.vector = new Vector(coordinates, Direction.parse(direction));
    }

    public void receive(String commandsSequence) {
        execute(createCommands(commandsSequence));
    }

    private void execute(List<Command> commands) {
        for(Command command:commands) {
            vector = command.execute(vector);
        }
    }

    private List<Command> createCommands(String commandsSequence) {
        List<Command> commands = new ArrayList<>();
        for(String commandRepresentation:commandsSequence.split(""))
        {
            commands.add(createCommand(commandRepresentation));
        }
        return commands;
    }

    private Command createCommand(String commandRepresentation) {
        Command command;
        if (commandRepresentation.equals("r")) {
            command = new TurningRight();
        } else if (commandRepresentation.equals("l")) {
            command = new TurningLeft();
        } else if (commandRepresentation.equals("f")) {
            command = new MovingForward(MOVEMENT_DELTA);
        } else if (commandRepresentation.equals("b")){
            command = new MovingBackwards(MOVEMENT_DELTA);
        } else {
            command = new UnknownCommand();
        }
        return command;
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
