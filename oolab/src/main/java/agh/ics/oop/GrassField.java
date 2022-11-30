package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrassField extends AbstractWorldMap {
    private final int grass_counter;
    private final Vector2d LOWER_GRASS_BOUND;
    private final Vector2d UPPER_GRASS_BOUND;
    private final ArrayList<Grass> grass_list = new ArrayList<>();

    public GrassField(int grass_counter){
        this.grass_counter = grass_counter;

        this.LOWER_GRASS_BOUND = new Vector2d(0 ,0);
        this.UPPER_GRASS_BOUND = new Vector2d((int)Math.sqrt(grass_counter * 10), (int)Math.sqrt(grass_counter * 10));

        this.LOWER_BOUND = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        this.UPPER_BOUND = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);

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

        grass_list.add(new Grass(newLocation));
    }
    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal: this.animals) {
            if (animal.isAt(position)) {
                return animal;
            }
        }
        for (Grass grass: this.grass_list) {
            if (position.equals(grass.getPosition())) {
                return grass;
            }
        }
        return null;
    }
    @Override
    public boolean isOccupied(Vector2d position){
        if (super.isOccupied(position)){
            return true;
        }
        for (Grass grass: this.grass_list) {
            if (position.equals(grass.getPosition())){
                return true;
            }
        }
        return false;
    }
    public void setPrintBounds() {
        if (!animals.isEmpty()) {
            this.PRINT_LOWER_BOUND = this.PRINT_UPPER_BOUND = animals.get(0).getPosition();
        } else if (!grass_list.isEmpty()) {
            this.PRINT_LOWER_BOUND = this.PRINT_UPPER_BOUND = grass_list.get(0).getPosition();
        } else {
            this.PRINT_LOWER_BOUND = new Vector2d(0,0);
            this.PRINT_UPPER_BOUND = new Vector2d(0,0);
            return;
        }
        for (Animal animal: animals) {
            this.PRINT_LOWER_BOUND = this.PRINT_LOWER_BOUND.lowerLeft(animal.getPosition());
            this.PRINT_UPPER_BOUND = this.PRINT_UPPER_BOUND.upperRight(animal.getPosition());
        }
        for (Grass grass: grass_list) {
            this.PRINT_LOWER_BOUND = this.PRINT_LOWER_BOUND.lowerLeft(grass.getPosition());
            this.PRINT_UPPER_BOUND = this.PRINT_UPPER_BOUND.upperRight(grass.getPosition());
        }
    }

    public int getGrass_counter() {
        return grass_counter;
    }

    public Vector2d getLOWER_GRASS_BOUND() {
        return LOWER_GRASS_BOUND;
    }
}
