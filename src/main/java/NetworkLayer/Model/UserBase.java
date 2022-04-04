package NetworkLayer.Model;


import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UserBase implements UserBaseInterface {
    private String jsonData;

    public UserBase(String data) {
        this.jsonData = data;
    }

    @Override
    public Map<String, Integer> asMap() {
        try {
            JSONObject jsonParser = new JSONObject(this.jsonData);
            Map<String,Integer> finalData = new HashMap<>();


            for (String i : jsonParser.keySet()) {
                finalData.put(i,Integer.parseInt(jsonParser.get(i).toString()));
            }
            return finalData;


        }catch (NullPointerException | JSONException e){
            return null;
        }


    }

    @Override
    public Map<String, Date> filterDates(Map<String, Date> data, Map<String, String> startEndDates) {
        return null;
    }
}
