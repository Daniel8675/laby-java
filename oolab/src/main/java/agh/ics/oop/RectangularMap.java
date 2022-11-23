package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap{
    private final Vector2d LOWER_BOUND;
    private final Vector2d UPPER_BOUND;
    private final int width;
    private final int height;

    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
        this.LOWER_BOUND = new Vector2d(0 ,0);
        this.UPPER_BOUND = new Vector2d(width, height);
    }

    @Override
    public String toString() {
        return new MapVisualizer(this).draw(this.LOWER_BOUND, this.UPPER_BOUND);
    }

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
    public boolean place(Animal animal) {
        return !isOccupied(animal.position);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(Animal animal: Animal.animals){
            if (animal.map.equals(this) && animal.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal: Animal.animals){
            if (animal.map.equals(this) && animal.getPosition().equals(position)){
                return animal;
            }
        }
        return null;
    }


    public Vector2d getLower_bound() {
        return LOWER_BOUND;
    }

    public Vector2d getUpper_bound() {
        return UPPER_BOUND;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
