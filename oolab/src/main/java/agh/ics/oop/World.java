package agh.ics.oop;

public class World {
    public static  void main(String[] args){
        /*
        Mechanizm wykluczajacy znalezienia sie dwoch zwierzat na danej pozycji mozna zaimplemenotwac w sposob taki
        aby przed wykonaniem kroku za pomoca metody move wywowlac funkcje isAt i sprawdzic czy dane pole jest
        "puste" to znaczy nie zajmuje go inny obiekt z klasy Animals.
        Bez uzycia metody isAt mozna stworzyc 2 wymiarowa tablice ktora bedzie reprezentowala nasz obszar 4 na 4
        znajdujacy sie na osi. Teraz wystarczy tylko w momencie kroku stawiac wartosc 1 na zajmowana pozycje oraz
        0 na poprzednia pozycje. Oczywiscie trzeba pamietac ze krok mozliwy jest wtedy gdy pozycja na ktora chcemy
        stanac ma wartosc 0.
         */
        Animal animal = new Animal();
        System.out.println(animal);
        String[] test = new String[] {"right","forward","b","b","r","b","backward","b","l","f","ala","ola","ela","franek"};
        MoveDirection[] moves = OptionsParser.parse(test);
        for(MoveDirection Move : moves){
            animal.move(Move);
            System.out.println(animal);
        }
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
