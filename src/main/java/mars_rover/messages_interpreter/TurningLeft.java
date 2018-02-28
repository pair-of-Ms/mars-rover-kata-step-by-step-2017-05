package mars_rover.messages_interpreter;

import mars_rover.Vector;

public class TurningLeft implements Command {
    public Vector execute(Vector vector) {
        return vector.turnLeft();
    }
}
