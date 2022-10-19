package agh.ics.oop;

public class World {
    public static  void main(String[] args){

        Animal animal = new Animal();
        System.out.println(animal);

    }

    public static void run(MoveDirection[] directions){
        for(MoveDirection direction : directions) {
            String msg = switch (direction) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tylu";
                case RIGHT -> "Zwierzak idzie w prawo";
                case LEFT -> "Zwierzak idzie w lewo";
            };
            System.out.println(msg);
        }
    }
    public static MoveDirection[] changed(String[] directions){
        MoveDirection[] ans = new MoveDirection[directions.length];
        for(int i = 0; i < directions.length; i++){
            switch (directions[i]){
                case "f" -> ans[i] = MoveDirection.FORWARD;
                case "b" -> ans[i] = MoveDirection.BACKWARD;
                case "r" -> ans[i] = MoveDirection.RIGHT;
                case "l" -> ans[i] = MoveDirection.LEFT;
            }
        }
        return ans;
    }
}
