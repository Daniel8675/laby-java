package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    void OneRightTurnFromNorth() {
        Animal animal = new Animal();
        animal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.EAST, animal.getOrientation());
    }

    @Test
    void TwoRightTurnsFromNorth() {
        Animal animal = new Animal();
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.SOUTH, animal.getOrientation());
    }

    @Test
    void ThreeRightTurnsFromNorth() {
        Animal animal = new Animal();
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.WEST, animal.getOrientation());
    }

    @Test
    void FourthRightTurnsFromNorth() {
        Animal animal = new Animal();
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.NORTH, animal.getOrientation());
    }

    @Test
    void OneLeftTurnFromNorth() {
        Animal animal = new Animal();
        animal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.WEST, animal.getOrientation());
    }

    @Test
    void TwoLeftTurnsFromNorth() {
        Animal animal = new Animal();
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.SOUTH, animal.getOrientation());
    }

    @Test
    void ThreeLeftTurnsFromNorth() {
        Animal animal = new Animal();
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.EAST, animal.getOrientation());
    }

    @Test
    void FourthLeftTurnsFromNorth() {
        Animal animal = new Animal();
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.NORTH, animal.getOrientation());
    }

    @Test
    void OneStepAhead(){
        Animal animal = new Animal();
        animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(2,3), animal.getPosition());
    }

    @Test
    void TwoStepAhead(){
        Animal animal = new Animal();
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(2,4), animal.getPosition());
    }

    @Test
    void ThreeStepAhead(){
        Animal animal = new Animal();
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(2,4), animal.getPosition());
    }

    @Test
    void FourthStepAhead(){
        Animal animal = new Animal();
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(2,4), animal.getPosition());
    }

    @Test
    void OneStepBack(){
        Animal animal = new Animal();
        animal.move(MoveDirection.BACKWARD);
        assertEquals(new Vector2d(2,1), animal.getPosition());
    }

    @Test
    void EightStepBack(){
        Animal animal = new Animal();
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        assertEquals(new Vector2d(2,0), animal.getPosition());
    }

    @Test
    void OneStepToTheRight(){
        Animal animal = new Animal();
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(3,2), animal.getPosition());
    }

    @Test
    void TwoStepToTheRight(){
        Animal animal = new Animal();
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(4,2), animal.getPosition());
    }

    @Test
    void ThreeStepToTheRight(){
        Animal animal = new Animal();
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(4,2), animal.getPosition());
    }

    @Test
    void OneStepToTheLeft(){
        Animal animal = new Animal();
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(1,2), animal.getPosition());
    }

    @Test
    void SeventhStepToTheLeft(){
        Animal animal = new Animal();
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(0,2), animal.getPosition());
    }

    @Test
    void isAt(){
        Animal animal = new Animal();
        assertTrue(animal.isAt(new Vector2d(2, 2)));
    }
}