package mars_rover;

import java.util.List;

public class Commands {

    private List<Command> commands;

    public Commands(List<Command> commands) {
        this.commands = commands;
    }

    public Vector execute(Vector vector) {
        for(Command command: commands) {
            vector = command.execute(vector);
        }
        return vector;
    }
}
