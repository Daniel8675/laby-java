package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GrassFieldTest {
    @Test
    void canMoveToTest() {
        IWorldMap map = new GrassField(10);
        Assertions.assertTrue(map.canMoveTo(new Vector2d(1, 1)));
        Assertions.assertTrue(map.canMoveTo(new Vector2d(-100, -100)));
    }

    @Test
    void placeTest() {
        IWorldMap map = new GrassField(4);

        Vector2d position = new Vector2d(2,3);
        Animal ant = new Animal(map, position);
        Animal bee = new Animal(map, new Vector2d(-20, -30));
        Animal cat = new Animal(map, position);

        Assertions.assertTrue(map.place(ant));
        Assertions.assertTrue(map.place(bee));

        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () ->  map.place(cat) );
        Assertions.assertEquals("position (2,3) is occupied", exception.getMessage());
    }

    @Test
    void isOccupiedTest() {
        IWorldMap map = new GrassField(1);
        Vector2d position = new Vector2d(1, 1);
        Animal animal = new Animal(map, position);
        map.place(animal);
        Assertions.assertTrue(map.isOccupied(position));
        Assertions.assertFalse(map.isOccupied(new Vector2d(-100, -100)));
    }

    @Test
    void objectAtTest() {
        IWorldMap map = new GrassField(2);
        Vector2d position = new Vector2d(1, 1);
        Animal animal = new Animal(map, position);
        map.place(animal);
        Assertions.assertEquals(animal, map.objectAt(position));
        Assertions.assertNull(map.objectAt(new Vector2d(-100, -100)));

    }
}