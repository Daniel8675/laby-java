package agh.ics.oop;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    protected Map<Vector2d, Animal> animals= new HashMap<>();
    protected MapBoundary bounds = new MapBoundary();

    @Override
    abstract public boolean canMoveTo(Vector2d position);

    @Override
    public boolean place(Animal animal) {
        if (isOccupied(animal.getPosition()) && (objectAt(animal.getPosition()) instanceof Animal)) {
            throw new IllegalArgumentException("position " + animal.getPosition().toString() + " is occupied");
        }
        if (!canMoveTo(animal.getPosition())) {
            throw new IllegalArgumentException("position " + animal.getPosition().toString() + " is out of bounds");
        }
        animals.put(animal.getPosition(), animal);
        bounds.addElement(animal.getPosition());
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
        animals.remove(oldPosition);
        animals.put(newPosition, animals.get(oldPosition));

        if (this instanceof GrassField && this.objectAt(oldPosition) instanceof Grass) {
            bounds.addElement(newPosition);
        } else {
            bounds.positionChanged(oldPosition, newPosition);
        }
        //setPrintBounds();

    }



    public abstract Vector2d calculateLowerBound();

    public abstract Vector2d calculateUpperBound();

}