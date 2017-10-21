public class MarsRover {

    private Coordinates coordinates;
    private Direction direction;

    public MarsRover(Coordinates coordinates, String direction) {
        this.coordinates = coordinates;
        this.direction = Direction.parse(direction);
    }

    public void receive(String commandsSequence) {
        if(commandsSequence.isEmpty()) {
            return;
        }
        if (commandsSequence.equals("r")) {
            if (getDirection().equals(Direction.North)) {
                setDirection(Direction.East);
            } else if (getDirection().equals(Direction.East)) {
                setDirection(Direction.South);
            } else if (getDirection().equals(Direction.South)) {
                setDirection(Direction.West);
            } else {
                setDirection(Direction.North);

            }
        } else {
            setDirection(Direction.West);
        }
    }

    private Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
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
}
