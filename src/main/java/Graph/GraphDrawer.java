package Graph;


import NetworkLayer.Model.UserBase;
import Util.DateCompare;
//import org.apache.commons.lang3.StringUtils;

import org.apache.maven.surefire.shade.org.apache.maven.shared.utils.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class GraphDrawer {
    UserBase data;
    List<String> sortedKeyData;


    public GraphDrawer(UserBase data) throws ParseException {
        this.data = data;
        sortedKeyData = getSortedKeyArray(data.asMap());

    }


    List<String> getSortedKeyArray(Map<String, Integer> jsonData) throws ParseException {
        List<String> newData = new ArrayList<>();
        for (Object i: jsonData.keySet().toArray()) {
            newData.add((String) i);
        }
        newData.sort(new DateCompare());
        return newData;
    }


    public void draw(){

        String largestValue = this.data.asMap().get(sortedKeyData.get(sortedKeyData.size()-1)).toString();
        int count = largestValue.substring(1).length() - 1;
        int factor = Integer.parseInt("1" + StringUtils.repeat("0",count));


        for (String i : sortedKeyData){
            System.out.println(i + "   " + StringUtils.repeat("|", this.data.asMap().get(i)/factor));
        }

    }


}
