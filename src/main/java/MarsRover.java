public class MarsRover {

    private static final int MOVEMENT_DELTA = 1;
    private Coordinates coordinates;
    private Direction direction;

    public MarsRover(Coordinates coordinates, String direction) {
        this.coordinates = coordinates;
        this.direction = Direction.parse(direction);
    }

    public void receive(String commandsSequence) {
        if (commandsSequence.isEmpty()) {
            return;
        }
        if (commandsSequence.equals("r")) {
            direction = direction.turnRight();
        } else if(commandsSequence.equals("l")){
            direction = direction.turnLeft();
        } else if(commandsSequence.equals("f")){
            coordinates = direction.moveForward(coordinates, MOVEMENT_DELTA);
        } else {
            coordinates = direction.moveBackwards(coordinates, MOVEMENT_DELTA);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MarsRover)) return false;

        MarsRover marsRover = (MarsRover) o;

        if (coordinates != null ? !coordinates.equals(marsRover.coordinates) : marsRover.coordinates != null)
            return false;
        return direction == marsRover.direction;

    }

    @Override
    public int hashCode() {
        int result = coordinates != null ? coordinates.hashCode() : 0;
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MarsRover{" +
            "coordinates=" + coordinates +
            ", direction=" + direction +
            '}';
    }
}
