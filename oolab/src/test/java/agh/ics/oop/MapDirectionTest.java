package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {

    @Test
    void nextToNorthShouldBeEast(){
        assertEquals(MapDirection.EAST, MapDirection.NORTH.next());
    }

    @Test
    void nextToEastShouldBeSouth(){
        assertEquals(MapDirection.SOUTH, MapDirection.EAST.next());
    }

    @Test
    void nextToSouthShouldBeWest(){
        assertEquals(MapDirection.WEST, MapDirection.SOUTH.next());
    }

    @Test
    void nextToWestShouldBeNorth(){
        assertEquals(MapDirection.NORTH, MapDirection.WEST.next());
    }

    @Test
    void previousToNorthShouldBeWest(){
        assertEquals(MapDirection.WEST, MapDirection.NORTH.previous());
    }

    @Test
    void previousToWestShouldBeSouth(){
        assertEquals(MapDirection.SOUTH, MapDirection.WEST.previous());
    }

    @Test
    void previousToSouthShouldBeEast(){
        assertEquals(MapDirection.EAST, MapDirection.SOUTH.previous());
    }

    @Test
    void previousToEastShouldBeNorth(){
        assertEquals(MapDirection.NORTH, MapDirection.EAST.previous());
    }
}