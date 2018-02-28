package mars_rover;

import mars_rover.messages_interpreter.Command;
import mars_rover.messages_interpreter.Commands;

import java.util.ArrayList;
import java.util.List;

public abstract class MessageInterpreter {

    private String[] parseMessage(String message) {
        return message.split("");
    }

    protected abstract Command createCommand(String commandRepresentation);

    public Commands interpret(String message) {
        List<Command> commands = new ArrayList<>();
        for(String commandRepresentation: parseMessage(message))
        {
            commands.add(createCommand(commandRepresentation));
        }
        return new Commands(commands);
    }
}
