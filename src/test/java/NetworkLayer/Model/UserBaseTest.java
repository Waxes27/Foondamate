package NetworkLayer.Model;



import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


import NetworkLayer.Http.DataAccess;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class UserBaseTest {
    String dataToTest = new DataAccess("http://sam-user-activity.eu-west-1.elasticbeanstalk.com/").getDataFromApi();
    UserBase correctUserBase = new UserBase(Map.of(
            "01-01-2022", 3000,
            "02-01-2022", 7000,
            "03-01-2022", 8000

    ));

    @Test
    void testConstructor() {
        assertEquals("Data", (new UserBase("Data")).getJsonData());
        assertEquals("{}", (new UserBase(new HashMap<>())).getJsonData());
    }

    UserBaseTest() throws IOException {
    }

    @Test
    void testAsMap() {
        UserBase base = new UserBase(dataToTest);
        assertEquals(base.asMap().getClass(), HashMap.class);
    }

    @Test
    void testAsMap2() {
        assertNull((new UserBase((String) null)).asMap());
        assertNull((new UserBase("")).asMap());
    }

    @Test
    void testAsMap3() {
        assertNull((new UserBase("Data")).asMap());
    }

    @Test
    void testAsMap4() {
        assertNull((new UserBase("")).asMap());
    }

    @Test
    void testAsMap5() {
        assertTrue((new UserBase(new HashMap<>())).asMap().isEmpty());
    }

    @Test
    void testAsMap6() {
        HashMap<String, Integer> stringIntegerMap = new HashMap<>();
        stringIntegerMap.put("Key", 42);
        Map<String, Integer> actualAsMapResult = (new UserBase(stringIntegerMap)).asMap();
        assertEquals(1, actualAsMapResult.size());
        Integer expectedGetResult = 42;
        assertEquals(expectedGetResult, actualAsMapResult.get("Key"));
    }

    @Test
    void testAsMap7() {
        HashMap<String, Integer> stringIntegerMap = new HashMap<>();
        stringIntegerMap.put("", 42);
        assertNull((new UserBase(stringIntegerMap)).asMap());
    }

    @Test
    void testAsMap8() {
        HashMap<String, Integer> stringIntegerMap = new HashMap<>();
        stringIntegerMap.put("Key", -1);
        Map<String, Integer> actualAsMapResult = (new UserBase(stringIntegerMap)).asMap();
        assertEquals(1, actualAsMapResult.size());
        Integer expectedGetResult = new Integer(-1);
        assertEquals(expectedGetResult, actualAsMapResult.get("Key"));
    }

    @Test
    void testAsMap9() {
        HashMap<String, Integer> stringIntegerMap = new HashMap<>();
        stringIntegerMap.put("42", 42);
        stringIntegerMap.put("Key", 42);
        Map<String, Integer> actualAsMapResult = (new UserBase(stringIntegerMap)).asMap();
        assertEquals(2, actualAsMapResult.size());
        Integer expectedGetResult = 42;
        assertEquals(expectedGetResult, actualAsMapResult.get("42"));
        Integer expectedGetResult1 = 42;
        assertEquals(expectedGetResult1, actualAsMapResult.get("Key"));
    }

    @Test
    void testFilterDates() throws ParseException {
        UserBase userBase = new UserBase("Data");
        assertEquals("{}", userBase.filterDates(new HashMap<>()).getJsonData());
    }


    @Test
    void testFilterDates2() throws ParseException {

        UserBase userBase = correctUserBase;
        assertEquals(2, userBase.filterDates(Map.of(
                "start", "01-01-2022",
                "end", "02-01-2022"
        )).asMap().size());

    }

    @Test
    void testFilterDates3() throws ParseException {
        UserBase userBase = new UserBase(new HashMap<>());
        assertEquals("{}", userBase.filterDates(new HashMap<>()).getJsonData());
    }

    @Test
    void testFilterDates4() throws ParseException {
        HashMap<String, Integer> stringIntegerMap = new HashMap<>();
        stringIntegerMap.put("start", 42);
        UserBase userBase = new UserBase(stringIntegerMap);
        assertEquals("{}", userBase.filterDates(new HashMap<>()).getJsonData());
    }

    @Test
    void testFilterDates5() throws ParseException {
        UserBase userBase = new UserBase("");
        assertEquals("{}", userBase.filterDates(new HashMap<>()).getJsonData());
    }

    @Test
    void testFilterDates6() throws ParseException {
        UserBase userBase = new UserBase(new HashMap<>());
        assertEquals("{}", userBase.filterDates(new HashMap<>()).getJsonData());
    }


    @Test
    void testFilterDates7() throws ParseException {
        HashMap<String, Integer> stringIntegerMap = new HashMap<>();
        stringIntegerMap.put("start", -1);
        UserBase userBase = new UserBase(stringIntegerMap);
        assertEquals("{}", userBase.filterDates(new HashMap<>()).getJsonData());
    }

    @Test
    void testFilterDates8() throws ParseException {
        HashMap<String, Integer> stringIntegerMap = new HashMap<>();
        stringIntegerMap.put("start", 42);
        UserBase userBase = new UserBase(stringIntegerMap);
        assertEquals("{}", userBase.filterDates(new HashMap<>()).getJsonData());
    }

    @Test
    void testFilterDates9() throws ParseException {
        HashMap<String, Integer> stringIntegerMap = new HashMap<>();
        stringIntegerMap.put("These are the available dates:", 42);
        UserBase userBase = new UserBase(stringIntegerMap);
        assertEquals("{}", userBase.filterDates(new HashMap<>()).getJsonData());
    }


    @Test
    void testFilterDates10() throws ParseException {
        HashMap<String, Integer> stringIntegerMap = new HashMap<>();
        stringIntegerMap.put("42", 42);
        UserBase userBase = new UserBase(stringIntegerMap);

        HashMap<String, String> stringStringMap = new HashMap<>();
        stringStringMap.put("start", "42");
        assertEquals("{}", userBase.filterDates(stringStringMap).getJsonData());
    }

    @Test
    void testFilterDates11() throws ParseException {
        HashMap<String, Integer> stringIntegerMap = new HashMap<>();
        stringIntegerMap.put("=", 42);
        UserBase userBase = new UserBase(stringIntegerMap);
        assertEquals("{}", userBase.filterDates(new HashMap<>()).getJsonData());
    }

    @Test
    void testFilterDates12() throws ParseException {
        HashMap<String, Integer> stringIntegerMap = new HashMap<>();
        stringIntegerMap.put("start", -1);
        UserBase userBase = new UserBase(stringIntegerMap);
        assertEquals("{}", userBase.filterDates(new HashMap<>()).getJsonData());
    }

}

