package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Animal{

    private static final Vector2d LOWER_BOUND = new Vector2d(0,0);
    private static final Vector2d UPPER_BOUND = new Vector2d(4, 4);

    protected MapDirection orientation;
    protected Vector2d position;
    protected IWorldMap map;

    public static List<Animal> animals = new ArrayList<>();

//    Przy "projektowaniu" funkcji jezeli mozna tak to nazwac, przyjalem zalozenie ze klasa Animal zbiera wszystkie swoje
//    zwierzatka w jedna gromade i je przetrzymuje lecz nie jestem pewien czy moja interpretacja jest poprawna.
//    Wynikiem tej intepretacji jest lista animals. Bez zmian zostawilem rowniez konstruknot bezparametrowy aby testy z
//    poprzednich laborek dzialaly, niestety nie widze sposobu jak uproscic wszystkie konstruktory :/

    public Animal(){
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
    }
    public Animal(IWorldMap map){
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
        this.map = map;

        animals.add(this);
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.orientation = MapDirection.NORTH;
        this.position = initialPosition;
        this.map = map;

        animals.add(this);
    }


    @Override
    public String toString() {
        return switch (this.orientation){
            case NORTH -> "N";
            case SOUTH -> "S";
            case WEST -> "W";
            case EAST -> "E";
        };
    }

    public boolean isAt(Vector2d positionToCheck){
        return Objects.equals(position, positionToCheck );
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }

    public void move(MoveDirection direction){

        Vector2d orientationVector = this.orientation.toUnitVector();
        Vector2d newPosition = position ;

        switch (direction){
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FORWARD -> newPosition =  position.add(orientationVector);
            case BACKWARD -> newPosition = position.subtract(orientationVector);
        }


        if (this.map.canMoveTo(newPosition)){
            position = newPosition;
        }

    }

}