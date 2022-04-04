package Graph;


import NetworkLayer.Model.UserBase;
import Util.DateCompare;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class GraphDrawer {
    UserBase data;


    public GraphDrawer(UserBase data) throws ParseException {
        this.data = data;
        System.out.println(getSortedArray(data.asMap()));
    }


    List<String> getSortedArray(Map<String, Integer> jsonData) throws ParseException {
        List<String> newData = new ArrayList<>();
        for (Object i: jsonData.keySet().toArray()) {
            newData.add((String) i);
        }
        newData.sort(new DateCompare());
        return newData;
    }

    public void Draw(){

    }
}
