package mars_rover;

import mars_rover.location.Vector;
import mars_rover.message_interpreters.command_types.Command;

import java.util.List;

class Commands {

    private List<Command> commands;

    Commands(List<Command> commands) {
        this.commands = commands;
    }

    Vector execute(Vector vector) {
        for(Command command: commands) {
            vector = command.execute(vector);
        }
        return vector;
    }
}
