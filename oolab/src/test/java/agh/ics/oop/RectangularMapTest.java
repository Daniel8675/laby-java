package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangularMapTest {
    @Test
    void canMoveToTest() {
        IWorldMap map = new RectangularMap(4, 4);
        Assertions.assertFalse(map.canMoveTo(new Vector2d(19, 11)));
        Assertions.assertTrue(map.canMoveTo(new Vector2d(3,3)));
    }

    @Test
    void placeTest() {
        IWorldMap map = new RectangularMap(10, 10);
        Vector2d position = new Vector2d(5,5);
        Animal animal = new Animal(map, position);
        Assertions.assertTrue(map.place(animal));

        position = new Vector2d(20,20);
        animal = new Animal(map, position);
        Assertions.assertFalse(map.place(animal));
    }

    @Test
    void isOccupiedTest() {
        IWorldMap map = new RectangularMap(10, 10);
        Vector2d position = new Vector2d(5,5);
        Animal animal = new Animal(map, position);
        map.place(animal);
        Assertions.assertTrue(map.isOccupied(position));
        Assertions.assertFalse(map.isOccupied(new Vector2d(5,6)));
    }

    @Test
    void objectAtTest() {
        IWorldMap map = new RectangularMap(10, 10);
        Vector2d position = new Vector2d(5,5);
        Animal animal = new Animal(map, position);
        map.place(animal);
        Assertions.assertEquals(animal, map.objectAt(position));
        Assertions.assertNull(map.objectAt(new Vector2d(5, 6)));
    }

}