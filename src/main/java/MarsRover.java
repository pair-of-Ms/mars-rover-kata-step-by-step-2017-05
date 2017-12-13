public class MarsRover {

    private static final int MOVEMENT_DELTA = 1;
    private Coordinates coordinates;
    private Direction direction;

    public MarsRover(Coordinates coordinates, String direction) {
        this.setCoordinates(coordinates);
        this.setDirection(Direction.parse(direction));
    }

    public void receive(String commandsSequence) {
        for(String command:commandsSequence.split(""))
        {
            if (command.equals("r")) {
                setDirection(getDirection().turnRight());
            } else if (command.equals("l")) {
                setDirection(getDirection().turnLeft());
            } else if (command.equals("f")) {
                setCoordinates(getDirection().moveForward(getCoordinates(), MOVEMENT_DELTA));
            } else if (command.equals("b")){
                setCoordinates(getDirection().moveBackwards(getCoordinates(), MOVEMENT_DELTA));
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MarsRover)) return false;

        MarsRover marsRover = (MarsRover) o;

        if (getCoordinates() != null ? !getCoordinates().equals(marsRover.getCoordinates()) : marsRover.getCoordinates() != null)
            return false;
        return getDirection() == marsRover.getDirection();

    }

    @Override
    public int hashCode() {
        int result = getCoordinates() != null ? getCoordinates().hashCode() : 0;
        result = 31 * result + (getDirection() != null ? getDirection().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MarsRover{" +
            "coordinates=" + getCoordinates() +
            ", direction=" + getDirection() +
            '}';
    }

    private Coordinates getCoordinates() {
        return coordinates;
    }

    private void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    private Direction getDirection() {
        return direction;
    }

    private void setDirection(Direction direction) {
        this.direction = direction;
    }
}
