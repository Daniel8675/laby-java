package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void equalsVector2dTest(){
        var test = new Vector2d(0,0);
        assertEquals(test, new Vector2d(0, 0));
    }

    @Test
    void toStringVector2d(){
        String test = "(1,2)";
        var position = new Vector2d(1,2);
        assertEquals(test, position.toString() );
    }

    @Test
    void precedesVector2d() {
        var position1 = new Vector2d(1,2);
        var position2 = new Vector2d(2, 3);

        if (position1.x <= position2.x && position1.y <= position2.y)
            assertTrue(position1.precedes(position2));
        else
            assertFalse(position1.precedes(position2));
    }

    @Test
    void followsVector2d() {
        var position1 = new Vector2d(7,9);
        var position2 = new Vector2d(5, 5);

        if (position1.x >= position2.x && position1.y >= position2.y)
            assertTrue(position1.follows(position2));
        else
            assertFalse(position1.follows(position2));
    }

    @Test
    void upperRightVector2d() {
        var position1 = new Vector2d(7,2);
        var position2 = new Vector2d(0,5);
        var position3 = new Vector2d(7,5);
        assertEquals(position3, position1.upperRight(position2));
    }

    @Test
    void lowerLeftVector2d() {
        var position1 = new Vector2d(7,2);
        var position2 = new Vector2d(0,5);
        var position3 = new Vector2d(0,2);
        assertEquals(position3, position1.lowerLeft(position2));
    }

    @Test
    void addVector2d() {
        var position1 = new Vector2d(3,7);
        var position2 = new Vector2d(7,3);
        var position3 = new Vector2d(10,10);
        assertEquals(position3, position1.add(position2));
    }

    @Test
    void subtractVector2d() {
        var position1 = new Vector2d(3,7);
        var position2 = new Vector2d(7,3);
        var position3 = new Vector2d(-4,4);
        assertEquals(position3, position1.subtract(position2));
    }

    @Test
    void oppositeVector2d() {
        var position1 = new Vector2d(0, -5);
        var position2 = new Vector2d(0, 5);
        assertEquals(position1, position2.opposite());
    }
}