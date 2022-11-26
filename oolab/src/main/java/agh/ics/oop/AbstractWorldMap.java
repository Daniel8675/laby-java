package agh.ics.oop;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    protected static Map<Vector2d, Animal> animals= new HashMap<>();

    @Override
    abstract public boolean canMoveTo(Vector2d position);

    @Override
    public boolean place(Animal animal) {
        if (!canMoveTo(animal.getPosition())) {
            return false;
        }
        if (isOccupied(animal.getPosition()) && (objectAt(animal.getPosition()) instanceof Animal)) {
            return false;
        }
        animals.put(animal.getPosition(), animal);
        animal.addObserver(this);

        return true;
    }

    @Override
    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(calculateLowerBound(), calculateUpperBound());
    }

    @Override
    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.get(position) != null;
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        animals.put(newPosition, animals.get(oldPosition));
        animals.remove(oldPosition);
    }


    abstract protected Vector2d calculateLowerBound();

    abstract protected Vector2d calculateUpperBound();

}