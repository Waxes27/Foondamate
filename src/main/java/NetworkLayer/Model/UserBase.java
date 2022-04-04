package NetworkLayer.Model;


import Util.DateSorter;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;

public class UserBase implements UserBaseInterface {
    private final String jsonData;

    public UserBase(String data) {

        this.jsonData = data;
    }

    public UserBase(Map<String, Integer> data){
        this.jsonData = data.toString().replace("=",":");
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
    public UserBase filterDates(Map<String, String> startEndDates) throws ParseException {

        List<String> dateSorted= new DateSorter().getSortedKeyArray(this.asMap());
        Map<String,Integer> stringMapToBeReturned = new HashMap<>();


        try {
            dateSorted = dateSorted.subList(
                    dateSorted.indexOf(startEndDates.get("start")),
                    dateSorted.indexOf(startEndDates.get("end"))+1);

            for (String i: dateSorted) {
                stringMapToBeReturned.put(i,this.asMap().get(i));
            }


        }catch (IndexOutOfBoundsException | IllegalArgumentException e){
            System.out.println("These are the available dates:");
            for (Object i: dateSorted) {
                System.out.println(i);
            }
            System.out.println("Error, range (" + startEndDates.get("start")+"  -  "+startEndDates.get("end")+") were not found");
        }


        return new UserBase(stringMapToBeReturned);
    }

    public String getJsonData() {
        return jsonData;
    }


}
