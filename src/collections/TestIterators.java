package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by nirav_000 on 2/13/2016.
 */
public class TestIterators {

    public static void main(String[] args) {

    //    removeAnElementFromColletion();

        Double num = new Double(1.0);
        Double zero = new Double(0.0);

        System.out.println(1/0);
        System.out.println(Double.isInfinite(num/zero));

    }

    private static void removeAnElementFromColletion() {

        List<String> myList = Arrays.asList("Nirav", "Purvi", "Unknown", "Prisha");

        Iterator<String> iterator = myList.iterator();

        while (iterator.hasNext()) {
            String myString = iterator.next();
            if (myString.equals("Unknown")) {
                iterator.remove();
            }
            else {
                System.out.println(myString);
            }
        }
    }
}
