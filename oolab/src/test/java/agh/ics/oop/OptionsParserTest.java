package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void FirstArray(){
        String[] test = new String[] {"right","r","left","l","forward","f","backward","b"};
        MoveDirection[] goodOne = new MoveDirection[] {MoveDirection.RIGHT,MoveDirection.RIGHT,MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.BACKWARD,MoveDirection.BACKWARD};
        assertArrayEquals(goodOne, OptionsParser.parse(test));

    }

    @Test
    void SecondArray(){
        String[] test = new String[] {"right","r","left","l","helena","forward","f","backward","b","ola","ela"};
        MoveDirection[] goodOne = new MoveDirection[] {MoveDirection.RIGHT,MoveDirection.RIGHT,MoveDirection.LEFT,MoveDirection.LEFT, MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.BACKWARD,MoveDirection.BACKWARD};

        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () ->  OptionsParser.convertToMoveDirection("helena") );
        Assertions.assertEquals("helena is not legal move specification", exception.getMessage());
    }
}