package unit_tests;

import mars_rover.*;
import mars_rover.messages_interpreter.ESAMessageInterpreter;
import mars_rover.messages_interpreter.NASAMessageInterpreter;

public class MarsRoverBuilder {

    private Coordinates coordinates;
    private String direction;
    private MessageInterpreter interpreter;

    public static MarsRoverBuilder aMarsRover()
    {
        return new MarsRoverBuilder();
    }

    public static MarsRoverBuilder aMarsRoverUnderstandingNasaCommandsAtIrrelevantPosition()
    {
        return aMarsRover().understandingNasaCommands().at(30,80);
    }

    public static MarsRoverBuilder aMarsRoverUnderstandingNasaCommands()
    {
        return aMarsRover().understandingNasaCommands();
    }

    public static MarsRoverBuilder aMarsRoverAnywherePointingToAnyDirection()
    {
        return aMarsRoverUnderstandingNasaCommandsAtIrrelevantPosition().pointing("N");
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

    public MarsRoverBuilder understandingNasaCommands() {
        this.interpreter = new NASAMessageInterpreter();
        return this;
    }

    public MarsRoverBuilder understandingEsaCommands() {
        this.interpreter = new ESAMessageInterpreter();
        return this;
    }

    public MarsRover build()
    {
        return new MarsRover(coordinates, direction, interpreter);
    }
}
