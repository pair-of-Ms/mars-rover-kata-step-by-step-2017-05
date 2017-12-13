public class MarsRover {

    private static final int MOVEMENT_DELTA = 1;
    private Vector vector;

    public MarsRover(Coordinates coordinates, String direction) {
        this.vector = new Vector(coordinates, Direction.parse(direction));
    }

    public void receive(String commandsSequence) {
        for(String command:commandsSequence.split(""))
        {
            if (command.equals("r")) {
                vector = vector.turnRight();
            } else if (command.equals("l")) {
                vector = vector.turnLeft();
            } else if (command.equals("f")) {
                vector = vector.moveForward(MOVEMENT_DELTA);
            } else if (command.equals("b")){
                vector = vector.moveBackwards(MOVEMENT_DELTA);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MarsRover marsRover = (MarsRover) o;

        return vector != null ? vector.equals(marsRover.vector) : marsRover.vector == null;
    }

    @Override
    public int hashCode() {
        return vector != null ? vector.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "MarsRover{" +
                "vector=" + vector +
                '}';
    }

}
