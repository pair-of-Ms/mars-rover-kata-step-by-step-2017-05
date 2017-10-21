public enum Direction {
    North, South, East, West;

    static public Direction parse(String directionAsString) {
        if (directionAsString.equals("N")) {
            return North;
        } else if (directionAsString.equals("E")) {
            return East;
        } else if (directionAsString.equals("S")) {
           return South;
        } else {
            return West;
        }
    }
}
