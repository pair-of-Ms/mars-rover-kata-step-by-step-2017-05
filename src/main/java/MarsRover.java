public class MarsRover {

    private Coordinates coordinates;
    private String direction;

    public MarsRover(Coordinates coordinates, String direction) {

        this.coordinates = coordinates;
        this.direction = direction;
    }

    public void receive(String commandsSequence) {
        
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public String getDirection() {
        return direction;
    }
}
