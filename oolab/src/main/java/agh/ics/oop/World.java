package agh.ics.oop;

public class World {
    public static  void main(String[] args){

//        RectangularMap map = new RectangularMap(4, 4);
//        Animal animal1 = new Animal(map, new Vector2d(4,1));
//        Animal animal2 = new Animal(map, new Vector2d(4,2));
//        Animal animal3 = new Animal(map, new Vector2d(4,3));
//        Animal animal4 = new Animal(map, new Vector2d(4,4));
//
//        RectangularMap map2 = new RectangularMap(10, 10);
//        Animal animal5 = new Animal(map2, new Vector2d(3,1));
//        Animal animal6 = new Animal(map2, new Vector2d(3,2));
//        Animal animal7 = new Animal(map2, new Vector2d(3,3));
//        Animal animal8 = new Animal(map2, new Vector2d(3,4));

//        System.out.println(animal);
//        String[] test = new String[] {"right","forward","b","b","r","b","backward","b","l","f","ala","ola","ela","franek"};
//        MoveDirection[] moves = OptionsParser.parse(test);
//        for(MoveDirection Move : moves){
//            animal.move(Move);
//            System.out.println(animal);
//        }
//        System.out.println("START:");
//        System.out.println(map.isOccupied(new Vector2d(3,2)));
//        System.out.println(map.objectAt(new Vector2d(4,2)));
//        System.out.println(map.objectAt(new Vector2d(4,3)));
//        System.out.println(map.objectAt(new Vector2d(4,4)));
//
//        Animal animal9 = new Animal(map);
//        map2.place(animal9);
//        System.out.println(map2.isOccupied(new Vector2d(0,0)));

        String[] args1 = new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};

        MoveDirection[] directions = OptionsParser.parse(args1);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        System.out.println(map);
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
