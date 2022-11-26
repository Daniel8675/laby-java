package agh.ics.oop;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

public class GrassField extends AbstractWorldMap {
    private final Vector2d UPPER_GRASS_BOUND;
    private final HashMap<Vector2d, Grass> grass_list = new HashMap<>();
    //get pobieranie z mapy zwraca wartosc lub null
    //put containskey
    //keyset przechodzimy po zbiorze kluczy
    //.entryset
    //values zwraca wartosci tutaj sa kolekcja
    //wzorzec projektowy obserwator

    public GrassField(int grass_counter){
        this.UPPER_GRASS_BOUND = new Vector2d((int)Math.sqrt(grass_counter * 10), (int)Math.sqrt(grass_counter * 10));

        for(int i = 0; i < grass_counter; i++ ){
            placeGrass();
        }

    }

    private void placeGrass(){
        int max = this.UPPER_GRASS_BOUND.x;
        int x, y;
        Vector2d newLocation;
        Random rand = new Random();

        rand.setSeed(100);

        do {
            x = rand.nextInt(max);
            y = rand.nextInt(max);
            newLocation = new Vector2d(x, y);
        } while (isOccupied(newLocation));

        grass_list.put(newLocation, new Grass(newLocation));
    }
    @Override
    public Object objectAt(Vector2d position) {
        Object foundObject = super.objectAt(position);
        if (foundObject == null) {
            foundObject = grass_list.get(position);
        }
        return foundObject;
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        if (super.isOccupied(position)) {
            return true;
        }
        return (grass_list.get(position) != null);
    }
    public boolean canMoveTo(Vector2d position){
        Object obj = this.objectAt(position);
        return obj == null || obj instanceof Grass;
    }

    @Override
    protected Vector2d calculateLowerBound() {
        Vector2d LOWER_BOUND = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);

        for (Animal animal: animals.values()){
            LOWER_BOUND = LOWER_BOUND.lowerLeft(animal.getPosition());
        }

        for (Grass grass: grass_list.values()){
            LOWER_BOUND = LOWER_BOUND.lowerLeft(grass.getPosition());
        }
        return LOWER_BOUND;
    }

    @Override
    protected Vector2d calculateUpperBound() {
        Vector2d UPPER_BOUND = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);

        for (Animal animal: animals.values()){
            UPPER_BOUND = UPPER_BOUND.upperRight(animal.getPosition());
        }

        for (Grass grass: grass_list.values()){
            UPPER_BOUND = UPPER_BOUND.upperRight(grass.getPosition());
        }
        return UPPER_BOUND;
    }
}
