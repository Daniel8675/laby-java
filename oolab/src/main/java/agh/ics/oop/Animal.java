package agh.ics.oop;

import java.util.Objects;

public class Animal{
    protected MapDirection orientation;
    protected Vector2d position;
    protected IWorldMap map;

    public Animal(){
        this(new RectangularMap(4, 4));
    }
    public Animal(IWorldMap map){
        this(map, new Vector2d(2, 2));
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.orientation = MapDirection.NORTH;
        this.position = initialPosition;
        this.map = map;
    }


    @Override
    public String toString() {
        return switch (this.orientation){
            case NORTH -> "N";
            case SOUTH -> "S";
            case WEST -> "W";
            case EAST -> "E";
        };
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


        if (this.map.canMoveTo(newPosition)){
            position = newPosition;
        }

    }

}