package mars_rover.messages_interpreter;

import mars_rover.Vector;

public interface Command {
    Vector execute(Vector vector);
}
