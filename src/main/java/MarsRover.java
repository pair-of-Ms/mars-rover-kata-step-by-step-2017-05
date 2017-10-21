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
        if(direction.equals("N")) {
            direction = "E";
        } else if(direction.equals("E")){
            direction = "S";
        } else if(direction.equals("S")){
            direction = "W";
        } else {
            direction = "N";
        }
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public String getDirection() {
        return direction;
    }
}
