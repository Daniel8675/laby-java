package agh.ics.oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {

    protected Vector2d LOWER_BOUND;
    protected Vector2d UPPER_BOUND;
    protected Vector2d PRINT_LOWER_BOUND;
    protected Vector2d PRINT_UPPER_BOUND;
    protected ArrayList<Animal> animals = new ArrayList<>();

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (!isOccupied(position)){
            return position.follows(LOWER_BOUND) && position.precedes(UPPER_BOUND);
        }
        else {
            return false;
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.stream()
                      .anyMatch(animal -> animal.isAt(position));
    }

    @Override
    public boolean place(Animal animal) {
        if (!canMoveTo(animal.getPosition())) {
            return false;
        }
        if (isOccupied(animal.getPosition()) && (objectAt(animal.getPosition()) instanceof Animal)) {
            return false;
        }
        this.animals.add(animal);
        return true;
    }

    @Override
    public String toString() {
        MapVisualizer visualization = new MapVisualizer(this);
        setPrintBounds();
        return visualization.draw(this.PRINT_LOWER_BOUND, this.PRINT_UPPER_BOUND);
    }

    abstract public void setPrintBounds();

    public List<Animal> getAnimals() {
        return Collections.unmodifiableList(animals);
    }

}