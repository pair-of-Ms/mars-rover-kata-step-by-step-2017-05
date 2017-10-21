public class MarsRover {

    private Coordinates coordinates;
    private String direction;

    public MarsRover(Coordinates coordinates, String direction) {

        this.coordinates = coordinates;
        this.direction = direction;
    }

    public void receive(String commandsSequence) {
        if(commandsSequence.isEmpty()) {
            return;
        }
        switch (direction) {
            case "N":
                direction = "E";
                break;
            case "E":
                direction = "S";
                break;
            case "S":
                direction = "W";
                break;
            default:
                direction = "N";
                break;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MarsRover)) return false;

        MarsRover marsRover = (MarsRover) o;

        if (coordinates != null ? !coordinates.equals(marsRover.coordinates) : marsRover.coordinates != null)
            return false;
        return direction != null ? direction.equals(marsRover.direction) : marsRover.direction == null;

    }

    @Override
    public int hashCode() {
        int result = coordinates != null ? coordinates.hashCode() : 0;
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        return result;
    }
}
