package mars_rover;

public class TurningRight implements Command {

    public Vector execute(Vector vector) {
        return vector.turnRight();
    }
}
