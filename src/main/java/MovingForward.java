public class MovingForward implements Command {
    private int delta;

    public MovingForward(int delta) {
        this.delta = delta;
    }

    public Vector execute(Vector vector) {
        return vector.moveForward(delta);
    }
}
