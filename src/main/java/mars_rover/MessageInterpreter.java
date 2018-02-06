package mars_rover;

import java.util.ArrayList;
import java.util.List;

public abstract class MessageInterpreter {

    private String[] parseMessage(String message) {
        return message.split("");
    }

    protected abstract Command createCommand(String commandRepresentation);

    public Commands createCommands(String message) {
        List<Command> commands = new ArrayList<>();
        for(String commandRepresentation: parseMessage(message))
        {
            commands.add(createCommand(commandRepresentation));
        }
        return new Commands(commands);
    }
}
