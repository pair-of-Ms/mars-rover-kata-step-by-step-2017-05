package mars_rover.messages_interpreter;

import mars_rover.Vector;

public class UnknownCommand implements Command {
    @Override
    public Vector execute(Vector vector) {
        return vector;
    }
}
