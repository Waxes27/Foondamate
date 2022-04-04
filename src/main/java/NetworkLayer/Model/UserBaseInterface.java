package NetworkLayer.Model;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;

public interface UserBaseInterface {


    public Map<String, Integer> asMap();
    public UserBase filterDates(Map<String,String> startEndDates) throws ParseException;
}
