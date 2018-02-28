package mars_rover.messages_interpreter;

import mars_rover.*;

public class NASAMessageInterpreter extends MessageInterpreter {

    private static final int MOVEMENT_DELTA = 1;

    protected Command createCommand(String commandRepresentation) {

        if (commandRepresentation.equals("r")) {
            return new TurningRight();
        } else if (commandRepresentation.equals("l")) {
            return new TurningLeft();
        } else if (commandRepresentation.equals("f")) {
            return new MovingForward(MOVEMENT_DELTA);
        } else if (commandRepresentation.equals("b")){
            return new MovingBackwards(MOVEMENT_DELTA);
        } else {
            return new UnknownCommand();
        }
    }
}
