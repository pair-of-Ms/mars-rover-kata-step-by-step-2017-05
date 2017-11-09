public enum Direction {
    North {
        public Direction turnRight() {
            return East;
        }

        public Direction turnLeft() {
            return West;
        }
    },
    South {
        public Direction turnRight() {
            return West;
        }
    },
    East {
        public Direction turnRight() {
            return South;
        }
    },
    West {
        public Direction turnRight() {
            return North;
        }
    };

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

    abstract public Direction turnRight();

    Direction turnLeft() {
        return South;
    }
}
