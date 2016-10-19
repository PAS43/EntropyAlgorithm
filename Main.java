import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/**
 * Created by Def on 17/10/2016.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        a.add("a");
        a.add("a");
        a.add("q");
        a.add("q");
        a.add("r");
        a.add("e");
        a.add("e");
        a.add("m");
        a.add("m");
        a.add("m");
        a.add("o");
        a.add("o");
        a.add("o");


        Entropy en = new Entropy();

        System.out.println(en.entropy(a));

    }


    }

