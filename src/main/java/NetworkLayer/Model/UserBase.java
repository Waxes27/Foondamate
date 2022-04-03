package NetworkLayer.Model;


import org.json.JSONObject;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UserBase implements UserBaseInterface {

    @Override
    public Map<String, Integer> asMap(String stringJson) {
        JSONObject jsonParser = new JSONObject(stringJson);

        Map<String,Integer> finalData = new HashMap<>();


        for (String i : jsonParser.keySet()) {
            System.out.println(Integer.parseInt(jsonParser.get(i).toString()));
            finalData.put(i,Integer.parseInt(jsonParser.get(i).toString()));
        }

        return finalData;
    }

    @Override
    public Map<String, Date> filterDates(Map<String, Date> data, Map<String, String> startEndDates) {
        return null;
    }
}
