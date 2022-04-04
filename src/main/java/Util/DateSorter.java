package Util;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DateSorter {


    public List<String> getSortedKeyArray(Map<String, Integer> jsonData) throws ParseException {
        List<String> newData = new ArrayList<>();
        try{
        for (Object i: jsonData.keySet().toArray()) {
            newData.add((String) i);
        }
        newData.sort(new DateCompare());
    }catch (NullPointerException e){
            System.out.println("No Keys to sort");
        }
        return newData;
    }
}
