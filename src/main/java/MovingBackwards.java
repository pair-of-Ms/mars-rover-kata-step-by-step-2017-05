public class MovingBackwards implements Command {
    private int delta;

    public MovingBackwards(int delta) {
        this.delta = delta;
    }

    public Vector execute(Vector vector) {
        return vector.moveBackwards(delta);
    }
}
