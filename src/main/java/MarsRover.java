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

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public String getDirection() {
        return direction;
    }
}
