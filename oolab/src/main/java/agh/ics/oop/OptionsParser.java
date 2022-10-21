package agh.ics.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptionsParser {

    public static MoveDirection[] parse(String[] directions){

        List<MoveDirection> dummy = new ArrayList<MoveDirection>();
        for (String direction : directions) {
            switch (direction) {
                case "f", "forward" -> dummy.add(MoveDirection.FORWARD);
                case "b", "backward" -> dummy.add(MoveDirection.BACKWARD);
                case "r", "right" -> dummy.add(MoveDirection.RIGHT);
                case "l", "left" -> dummy.add(MoveDirection.LEFT);
            }
        }

        return dummy.toArray(new MoveDirection[0]);
        /*
        WYJASNIENIE CO TU SIE STALO
        Zamiana na liste byla spowodowana wartosciami null jakie pojawialy się w tablicy
        przy probie wywolania funkcji z Stringiem ktory nie ma sensu np. "ala".
        (Problem byl spowodowany dlugoscia tablicy)
        Majac do dyspozycji liste dodaje tylko elementy ktore powinny sie tam znalezc i ostatecznie
        zamieniam ja na tablice.
        Prawdopodobnie mozna to zrobic "sprytniej" ale wracam jeszcze raz do mema ktorego Pan Doktor
        mial juz okazje zobaczyc:
        https://i.imgur.com/qpPrV00.jpg
         */
    }
}
