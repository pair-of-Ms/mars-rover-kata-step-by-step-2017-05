package mars_rover;

import mars_rover.message_interpreters.command_types.Command;

import java.util.ArrayList;
import java.util.List;

public abstract class MessageInterpreter {

    private String[] parseMessage(String message) {
        return message.split("");
    }

    protected abstract Command createCommand(String commandRepresentation);

    Commands interpret(String message) {
        List<Command> commands = new ArrayList<>();
        for(String commandRepresentation: parseMessage(message))
        {
            commands.add(createCommand(commandRepresentation));
        }
        return new Commands(commands);
    }
}
