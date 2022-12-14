package agh.ics.oop;

import java.util.Objects;
import java.util.stream.Stream;

public class OptionsParser {

    public static MoveDirection[] parse(String[] directions){
        return Stream.of(directions)
                .map(OptionsParser::convertToMoveDirection)
                .filter(Objects::nonNull)
                .toArray(MoveDirection[]::new);
    }

    protected static MoveDirection convertToMoveDirection(String instructions) {
        return switch (instructions) {
            case "f", "forward" -> MoveDirection.FORWARD;
            case "b", "backward" -> MoveDirection.BACKWARD;
            case "r", "right" -> MoveDirection.RIGHT;
            case "l", "left" -> MoveDirection.LEFT;
            default -> throw new IllegalArgumentException(instructions + " is not legal move specification");
        };
    }
}
