package agh.ics.oop;

import java.util.ArrayList;
import java.util.Objects;

public class Animal{
    protected MapDirection orientation;
    protected Vector2d position;
    protected IWorldMap map;

    private final ArrayList<IPositionChangeObserver> observers_list = new ArrayList<>();

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
            this.positionChanged(position, newPosition);
            position = newPosition;
        }

    }

    public void addObserver(IPositionChangeObserver observer) {
        observers_list.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer) {
        observers_list.remove(observer);
    }

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for (IPositionChangeObserver observer: observers_list) {
            observer.positionChanged(oldPosition, newPosition);
        }
    }

}