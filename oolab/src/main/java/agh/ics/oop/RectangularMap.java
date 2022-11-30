package agh.ics.oop;

import java.util.*;

public class RectangularMap extends AbstractWorldMap{
    private final int width;
    private final int height;

    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
        this.LOWER_BOUND = new Vector2d(0 ,0);
        this.UPPER_BOUND = new Vector2d(width, height);
    }

    @Override
    public Object objectAt(Vector2d position) {
        return animals.stream()
                .filter(animal -> animal.isAt(position))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void setPrintBounds() {
        PRINT_LOWER_BOUND = this.LOWER_BOUND;
        PRINT_UPPER_BOUND = this.UPPER_BOUND;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

//    @Override
//    public boolean isOccupied(Vector2d position) {
//        return objectAt(position) != null;
//    //      return animals.stream()
//    //                .anyMatch(animal -> animal.isAt(position));
//    }
}
