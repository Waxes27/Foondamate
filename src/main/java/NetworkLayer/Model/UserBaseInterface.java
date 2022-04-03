package NetworkLayer.Model;

import java.util.Date;
import java.util.Map;

public interface UserBaseInterface {


    public Map<String, Integer> asMap(String stringJson);
    public Map<String, Date> filterDates(Map<String, Date> data, Map<String,String> startEndDates);
}
