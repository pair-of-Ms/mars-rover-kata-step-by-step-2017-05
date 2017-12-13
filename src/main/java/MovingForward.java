public class MovingForward {
    private int delta;

    public MovingForward(int delta) {
        this.delta = delta;
    }

    public Vector execute(Vector vector) {
        return vector.moveForward(delta);
    }
}
