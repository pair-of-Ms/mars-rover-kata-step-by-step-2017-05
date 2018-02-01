package mars_rover;

public class ESAMessageInterpreter extends MessageInterpreter {

    private static final int MOVEMENT_DELTA = 1;

    protected Command createCommand(String commandRepresentation) {

        if (commandRepresentation.equals("d")) {
            return new TurningRight();
        } else if (commandRepresentation.equals("i")) {
            return new TurningLeft();
        } else if (commandRepresentation.equals("a")) {
            return new MovingForward(MOVEMENT_DELTA);
        } else if (commandRepresentation.equals("r")){
            return new MovingBackwards(MOVEMENT_DELTA);
        } else {
            return new UnknownCommand();
        }
    }
}
