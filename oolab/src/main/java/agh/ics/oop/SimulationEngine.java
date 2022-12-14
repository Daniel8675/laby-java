package agh.ics.oop;

import java.util.ArrayList;

public class SimulationEngine implements IEngine{
    protected MoveDirection[] directions;
    protected final IWorldMap map;
    protected Vector2d[] positions;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions){
        this.directions = directions;
        this.map = map;
        this.positions = positions;
    }

    @Override
    public void run() {
        ArrayList<Animal> animals = new ArrayList<>();
        for (Vector2d position: positions) {
            Animal newAnimal = new Animal(map, position);
            if (map.place(newAnimal)) {
                animals.add(newAnimal);
            }
        }
        int current = 0;
        for (MoveDirection direction: directions) {
            animals.get(current).move(direction);
            current += 1;
            current = current % animals.size();
        }
    }
}
