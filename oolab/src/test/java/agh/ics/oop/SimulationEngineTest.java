package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationEngineTest {

    @Test
    void runOne() {
        String[] args1 = new String[]{"f", "b", "r", "l"};

        MoveDirection[] directions = OptionsParser.parse(args1);
        IWorldMap map = new RectangularMap(4, 4);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        List<Animal> animals_with_this_map = new ArrayList<>();
        for(Animal animal: AbstractWorldMap.animals.values()){
            if(animal.map.equals(map)){
                animals_with_this_map.add(animal);
            }
        }

        assertEquals(new Vector2d(3, 3), animals_with_this_map.get(0).getPosition());
        assertEquals(MapDirection.WEST, animals_with_this_map.get(0).getOrientation());

        assertEquals(new Vector2d(2, 3), animals_with_this_map.get(1).getPosition());
        assertEquals(MapDirection.EAST, animals_with_this_map.get(1).getOrientation());

    }

}