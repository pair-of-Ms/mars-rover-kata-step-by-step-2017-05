package mars_rover.messages_interpreter;

import mars_rover.Vector;

public class TurningRight implements Command {

    public Vector execute(Vector vector) {
        return vector.turnRight();
    }
}
