package agh.ics.oop;

public class World {
    public static void main(String[] args){
        String[] directions = {"f","f","r","l","b","f","l"};
        System.out.println("Start");
        Direction[] tab = changed(directions);
        run(tab);
        System.out.println("Stop");
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
