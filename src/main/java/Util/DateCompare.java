package Util;

import java.util.Comparator;

public class DateCompare implements Comparator<String> {
    @Override
    public int compare(String a, String b)
    {
        if (Integer.parseInt(a.split("-")[2]) == Integer.parseInt(b.split("-")[2])) {
            if (Integer.parseInt(a.split("-")[1]) > Integer.parseInt(b.split("-")[1])) {
                return 1;
            }

        }
        /* Returns sorted data in ascending order */
        return a.compareTo(b);
    }
}
