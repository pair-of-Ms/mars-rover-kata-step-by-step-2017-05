package mars_rover;

import java.util.ArrayList;
import java.util.List;

public abstract class MessageInterpreter {

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

    protected abstract Command createCommand(String commandRepresentation);
}
