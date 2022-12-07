package agh.ics.oop;

public class World {
    public static  void main(String[] args){
        String[] args1 = new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};

        IWorldMap map = new GrassField(12);
        MoveDirection[] direction = OptionsParser.parse(args1);
        Vector2d[] position = { new Vector2d(0,0), new Vector2d(4,4) };
        SimulationEngine engine = new SimulationEngine(direction, map, position);
        engine.run();
        System.out.println(map);
    }

/*    public static void run(MoveDirection[] directions){
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

 */
}
