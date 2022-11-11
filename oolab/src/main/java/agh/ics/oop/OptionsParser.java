package agh.ics.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class OptionsParser {

    public static MoveDirection[] parse(String[] directions){
        return Stream.of(directions)
                .map(OptionsParser::convertToMoveDirection)
                .filter(Objects::nonNull)
                .toArray(MoveDirection[]::new);
    }

    private static MoveDirection convertToMoveDirection(String instructions) {
        return switch (instructions) {
            case "f", "forward" -> MoveDirection.FORWARD;
            case "b", "backward" -> MoveDirection.BACKWARD;
            case "r", "right" -> MoveDirection.RIGHT;
            case "l", "left" -> MoveDirection.LEFT;
            default -> null;
        };
    }
}
