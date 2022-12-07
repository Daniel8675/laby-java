package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap {
    private final Vector2d LOWER_BOUND;
    private final Vector2d UPPER_BOUND;

    public RectangularMap(int width, int height) {
        this.LOWER_BOUND = new Vector2d(0, 0);
        this.UPPER_BOUND = new Vector2d(width, height);
    }

    public boolean canMoveTo(Vector2d position) {
        if (!isOccupied(position)) {
            return position.follows(calculateLowerBound()) && position.precedes(calculateUpperBound());
        } else {
            return false;
        }
    }

    @Override
    protected Vector2d calculateLowerBound() {
        return LOWER_BOUND;
    }

    @Override
    protected Vector2d calculateUpperBound() {
        return UPPER_BOUND;
    }

}

//    @Override
//    public boolean isOccupied(Vector2d position) {
//        return objectAt(position) != null;
//    //      return animals.stream()
//    //                .anyMatch(animal -> animal.isAt(position));
//    }

