public class MarsRoverBuilder {

    private Coordinates coordinates;
    private String direction;

    public static MarsRoverBuilder aMarsRover()
    {
        return new MarsRoverBuilder();
    }

    public static MarsRoverBuilder aMarsRoverAtIrrelevantPosition()
    {
        return aMarsRover().at(30,80);
    }

    public MarsRoverBuilder at(int x, int y)
    {
        coordinates = new Coordinates(x, y);
        return this;
    }

    public MarsRoverBuilder pointing(String direction)
    {
        this.direction = direction;
        return this;
    }

    public MarsRover build()
    {
        return new MarsRover(coordinates, direction);
    }
}
