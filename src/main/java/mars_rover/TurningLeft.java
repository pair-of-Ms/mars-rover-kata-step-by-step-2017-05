package mars_rover;

public class TurningLeft implements Command {
    public Vector execute(Vector vector) {
        return vector.turnLeft();
    }
}
