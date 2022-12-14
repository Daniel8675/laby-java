package agh.ics.oop;

import java.util.TreeSet;
import java.util.Comparator;

public class MapBoundary implements IPositionChangeObserver {

    Comparator<Vector2d> compX = new Comparator<Vector2d>() {
        public int compare(Vector2d a, Vector2d b) {
            if (a.x < b.x) {return -1;}
            if (a.x > b.x) {return 1;}
            return (int) Math.signum(a.y - b.y);
        }
    };

    Comparator<Vector2d> compY = new Comparator<Vector2d>() {
        @Override
        public int compare(Vector2d a, Vector2d b) {
            if (a.y < b.y) {return -1;}
            if (a.y > b.y) {return 1;}
            return (int) Math.signum(a.x - b.x);
        }
    };
    TreeSet<Vector2d> setX = new TreeSet<>(compX);
    TreeSet<Vector2d> setY = new TreeSet<>(compY);

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        setX.remove(oldPosition);
        setX.add(newPosition);

        setY.remove(oldPosition);
        setY.add(newPosition);
    }

    public void addElement(Vector2d position) {
        setX.add(position);
        setY.add(position);
    }

    public Vector2d getUpperBoundaries() {
        return setX.last().upperRight(setY.last());
    }

    public Vector2d getLowerBoundaries() {
        return setX.first().lowerLeft(setY.first());
    }
}