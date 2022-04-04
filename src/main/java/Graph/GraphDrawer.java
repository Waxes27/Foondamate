package Graph;


import NetworkLayer.Model.UserBase;
import Util.DateSorter;
import org.apache.maven.surefire.shade.org.apache.maven.shared.utils.StringUtils;

import java.text.ParseException;
import java.util.*;

public class GraphDrawer {
    UserBase data;
    List<String> sortedKeyData;


    public GraphDrawer(UserBase data) throws ParseException {
        this.data = data;
        sortedKeyData = new DateSorter().getSortedKeyArray(data.asMap());
    }


    public void draw(){
        try {
            String largestValue = this.data.asMap().get(sortedKeyData.get(sortedKeyData.size() - 1)).toString();
            int count = largestValue.substring(1).length() - 1;
            int factor = Integer.parseInt("1" + StringUtils.repeat("0", count));


            for (String i : sortedKeyData) {
                System.out.println(i + "   " +
                        StringUtils.repeat("|", this.data.asMap().get(i) / factor) +
                        "|(" + this.data.asMap().get(i) + ")|"
                );
            }
        }catch (IndexOutOfBoundsException e){
            ;
        }

    }


}
