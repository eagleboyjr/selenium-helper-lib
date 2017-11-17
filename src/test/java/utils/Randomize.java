package utils;

import java.util.concurrent.ThreadLocalRandom;

import static pagefactory.pagefactconsts.PageFactConsts.MAX;
import static pagefactory.pagefactconsts.PageFactConsts.MIN;

public class Randomize {

    public static Integer randomNum(){
        return ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
    }
}
