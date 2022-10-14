package agh.ics.oop;

import java.util.Map;

public class World {
    public static  void main(String[] args){
        ////////////////////////////////////////////////////////
        // LAB 1

        /*String[] directions = {"f","f","r","l","b","f","l"};
        System.out.println("Start");
        Direction[] tab = changed(directions);
        run(tab);
        System.out.println("Stop");*/

        //////////////////////////////////////////////////////

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        System.out.println(MapDirection.SOUTH.toUnitVector());




    }

    public static void run(Direction[] directions){
        for(Direction direction : directions) {
            String msg = switch (direction) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tylu";
                case RIGHT -> "Zwierzak idzie w prawo";
                case LEFT -> "Zwierzak idzie w lewo";
            };
            System.out.println(msg);
        }
    }
    public static Direction[] changed(String[] directions){
        Direction[] ans = new Direction[directions.length];
        for(int i = 0; i < directions.length; i++){
            switch (directions[i]){
                case "f" -> ans[i] = Direction.FORWARD;
                case "b" -> ans[i] = Direction.BACKWARD;
                case "r" -> ans[i] = Direction.RIGHT;
                case "l" -> ans[i] = Direction.LEFT;
            }
        }
        return ans;
    }
}
