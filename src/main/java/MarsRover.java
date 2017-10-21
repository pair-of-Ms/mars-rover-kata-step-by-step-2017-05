public class MarsRover {

    private Coordinates coordinates;
    private String directionString;
    private Direction direction;

    public MarsRover(Coordinates coordinates, String direction) {

        this.coordinates = coordinates;
        this.setDirection(direction);
    }

    public void receive(String commandsSequence) {
        if(commandsSequence.isEmpty()) {
            return;
        }
        if (commandsSequence.equals("r")) {
            switch (getDirection()) {
                case "N":
                    setDirection("E");
                    break;
                case "E":
                    setDirection("S");
                    break;
                case "S":
                    setDirection("W");
                    break;
                default:
                    setDirection("N");
                    break;
            }
        } else {
            setDirection("W");
        }
    }

    private String getDirection() {
        return directionString;
    }

    private void setDirection(String direction) {
        this.directionString = direction;
        this.direction = Direction.parse(directionString);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MarsRover)) return false;

        MarsRover marsRover = (MarsRover) o;

        if (coordinates != null ? !coordinates.equals(marsRover.coordinates) : marsRover.coordinates != null)
            return false;
        return getDirection() != null ? getDirection().equals(marsRover.getDirection()) : marsRover.getDirection() == null;

    }

    @Override
    public int hashCode() {
        int result = coordinates != null ? coordinates.hashCode() : 0;
        result = 31 * result + (getDirection() != null ? getDirection().hashCode() : 0);
        return result;
    }
}
