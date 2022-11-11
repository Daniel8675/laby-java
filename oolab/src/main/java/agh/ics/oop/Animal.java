package agh.ics.oop;

import java.util.Objects;

public class Animal implements IWorldMap {

    private static final Vector2d LOWER_BOUND = new Vector2d(0,0);
    private static final Vector2d UPPER_BOUND = new Vector2d(4, 4);

    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

//    Animal(IWorldMap map){}

    @Override
    public String toString() {
        return "Animal{" +
                "orientation=" + orientation +
                ", position=" + position +
                '}';
    }

    public boolean isAt(Vector2d positionToCheck){
        return Objects.equals(position, positionToCheck );
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }

    public void move(MoveDirection direction){

        Vector2d orientationVector = this.orientation.toUnitVector();
        Vector2d newPosition = position ;

        switch (direction){
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FORWARD -> newPosition =  position.add(orientationVector);
            case BACKWARD -> newPosition = position.subtract(orientationVector);
        }


        if (newPosition.follows(LOWER_BOUND) && newPosition.precedes(UPPER_BOUND)){
            position = newPosition;
        }

    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(LOWER_BOUND) && position.precedes(UPPER_BOUND);
    }

    @Override
    public boolean place(Animal animal) {
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return null;
    }
}