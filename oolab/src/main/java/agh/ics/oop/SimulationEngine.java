package agh.ics.oop;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine{
    protected MoveDirection[] directions;
    protected final IWorldMap map;
    protected Vector2d[] positions;

    protected SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions){
        this.directions = directions;
        this.map = map;
        this.positions = positions;

        for(Vector2d position: positions){
            this.map.place(new Animal(this.map, position));
        }
    }

    @Override
    public void run() {
        List<Animal> animals_with_this_map = new ArrayList<>();

        for (Animal animal: Animal.animals){
            if(animal.map.equals(this.map)){
                animals_with_this_map.add(animal);
            }
        }

        int i = 0;
        for (MoveDirection direction: directions){
            // System.out.println(this.map);
            if( i == animals_with_this_map.size()){
                i = 0;
            }
            animals_with_this_map.get(i).move(direction);
            i += 1;
        }
    }
}
