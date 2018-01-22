package mars_rover;

import java.util.ArrayList;
import java.util.List;

public class ESAMessageInterpreter implements MessageInterpreter {

    private static final int MOVEMENT_DELTA = 1;

    public List<Command> createCommands(String message) {
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

        if (commandRepresentation.equals("d")) {
            return new TurningRight();
        } else if (commandRepresentation.equals("i")) {
            return new TurningLeft();
        } else if (commandRepresentation.equals("a")) {
            return new MovingForward(MOVEMENT_DELTA);
        } else if (commandRepresentation.equals("r")){
            return new MovingBackwards(MOVEMENT_DELTA);
        } else {
            return new UnknownCommand();
        }
    }
}
